package br.com.portobello.digital.partnerspurchaseorderbatch.service.batch;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductVMIResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.reponse.EstoqueEBSResponseDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierProductsStockDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierStockRequestDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.vmi.LeroyBatchNewItemVMI;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.EventStatusType;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.events.RabbitOperationErrorEvent;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory.OrderFactory;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory.VmiFactory;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.vmi.LeroyBatchNewItemVMIRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.broker.VMIOutboundBrokerPartnersPurchase;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.ebs.EbsEstoqueService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.leroy.LeroyVMIService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba.PbaCustomerService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba.PbaPurchaseOrderService;
import br.com.portobello.digital.partnerspurchaseorderbatch.service.integration.pba.PbaSalesOrderService;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeroyVMIBatchService {

    public static final int OFFSET = 0;
    public static final int LIMIT = 10;
    Logger logger = LoggerFactory.getLogger(PbaPurchaseOrderService.class);


    @Value("${app.pba.defaultCustomerNumber}")
    private String defaultCustomerNumber;

    @Value("${app.pba.supplierId}")
    private List<String> supplierId;

    @Value("${app.pba.allowedTransactionStatus}")
    private List<String> allowedTransactionStatus;

    @Autowired
    private LeroyVMIService leroyVMIService;

    @Autowired
    private PbaCustomerService customerService;

    @Autowired
    private PbaSalesOrderService salesOrderService;

    @Autowired
    private EbsEstoqueService ebsEstoqueService;

    @Autowired
    private OrderFactory orderFactory;

    @Autowired
    private VmiFactory vmiFactory;

    @Autowired
    private LeroyBatchNewItemVMIRepository batchNewItemRepository;

    @Autowired
    private VMIOutboundBrokerPartnersPurchase outbound;

    @TransactionalEventListener
    public void saveAndPublish(LeroyBatchNewItemVMI newItem) {
        try {
            SupplierStockRequestDTO stockRequestDTO = newItem.getStockInfo();
            stockRequestDTO.setPayloadId(newItem.getLastExecution().toString());
            logger.info("Saving and Publishing Leroy VMI stock into database and rabbitmq : Event Date id {} ", newItem.getStockInfo().getPayloadId());
            outbound.sendMessageVMIRequested(new RabbitEvent<>(stockRequestDTO));
            newItem.setStatusType(EventStatusType.PUBLISHED);
            batchNewItemRepository.save(newItem);
        } catch (Exception e) {
            outbound.sendMessageVMIOperationError(new RabbitOperationErrorEvent(e.getMessage(), e.getLocalizedMessage(), HttpStatus.BAD_GATEWAY));
        }
    }

    public List<ProductVMIResponseLeroyDTO> getStockVMIFromLeroy(String id) {
        List<ProductVMIResponseLeroyDTO> vmiList = new ArrayList<>();
        try {
            logger.info("Getting VMI stock from id: {}", id);
            ProductVMIResponseLeroyDTO vmiPage = leroyVMIService.getVMI(id, OFFSET, LIMIT);
            vmiList.add(vmiPage);

            while (!(vmiPage.getHeader().getOffset() + vmiPage.getHeader().getLimit() > vmiPage.getHeader().getTotal())) {
                vmiPage = leroyVMIService.getVMI(id, vmiPage.getHeader().getOffset() + LIMIT, LIMIT);
                vmiList.add(vmiPage);
            }
            //purchaseOrders.addAll(purchaseOrderService.getPurchaseOrders(dtf.format(LocalDateTime.of(2021, 02, 17, 00, 00, 00)), supplierId.get(i)));                logger.info("Added {} purchase order to integration list", purchaseOrders.size());
        } catch (FeignException e) {
            outbound.sendMessageVMIOperationError(new RabbitOperationErrorEvent(e.getMessage(), e.getLocalizedMessage(), HttpStatus.BAD_GATEWAY));
            throw new HttpServerErrorException(HttpStatus.BAD_GATEWAY, e.getLocalizedMessage());
        }
        return vmiList;
    }


    public ProductVMIResponseLeroyDTO flatMapList(List<ProductVMIResponseLeroyDTO> stockLeroy) {
        List<ProductLeroyDTO> itens = new ArrayList<>();
        stockLeroy.forEach(stock -> itens.addAll(stock.getItems()));
        ProductVMIResponseLeroyDTO products = new ProductVMIResponseLeroyDTO();
        products.setHeader(ObjectUtils.isEmpty(stockLeroy) ? null : stockLeroy.get(0).getHeader());
        products.setItems(itens);
        return products;
    }

    public SupplierStockRequestDTO createSupplierRequest(ProductVMIResponseLeroyDTO stockLeroy, List<EstoqueEBSResponseDTO> stockEbs) {
        List<SupplierProductsStockDTO> supplierProductsStock = new ArrayList<>();
        for (ProductLeroyDTO product : stockLeroy.getItems()) {
            List<EstoqueEBSResponseDTO> stock = stockEbs.stream().filter(estoque -> estoque.getCodigoProduto().equalsIgnoreCase(product.getSupplierProductId())).collect(Collectors.toList());
            if (ObjectUtils.isEmpty(stock)) {
                supplierProductsStock.add(vmiFactory.createFromLeroySupplierProductsStockDTO(product));
            } else {
                supplierProductsStock.add(vmiFactory.createFromEbsSupplierProductsStockDTO(product, stock.get(0)));
            }
        }
        return vmiFactory.createSupplierStockRequestDTO(supplierProductsStock);
    }

    public List<EstoqueEBSResponseDTO> getStockFromEbs(List<ProductVMIResponseLeroyDTO> stockVMI) {
        if (ObjectUtils.isEmpty(stockVMI)) {
            return null;
        }
        List<EstoqueEBSResponseDTO> estoqueEBS = new ArrayList<>();

        try {
            stockVMI.forEach(stock -> estoqueEBS.addAll(ebsEstoqueService.getEstoqueInfo(vmiFactory.createEstoqueEBSRequestDTO(stock))));
        } catch (FeignException e) {
            outbound.sendMessageVMIOperationError(new RabbitOperationErrorEvent(e.getMessage(), e.getLocalizedMessage(), HttpStatus.BAD_GATEWAY));
            throw new HttpServerErrorException(HttpStatus.BAD_GATEWAY, e.getLocalizedMessage());
        }
        return estoqueEBS;
    }
}
