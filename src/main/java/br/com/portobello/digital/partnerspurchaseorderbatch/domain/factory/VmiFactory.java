package br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.productVMI.ProductVMIResponseLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.reponse.EstoqueEBSResponseDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.request.EstoqueEBSRequestDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.ebs.request.ItemEBSDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierProductsStockDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierStockDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.stockLevel.leroy.request.SupplierStockRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class VmiFactory {
    private static final String CLIENTE = "LEROY";
    private static final String CANAL = "REVENDA";
    private static final String DEPOSITO = "EET";
    Logger logger = LoggerFactory.getLogger(VmiFactory.class);
    @Autowired
    ClienteFactory clienteFactory;

    @Autowired
    EntregaFactory entregaFactory;

    @Autowired
    ItemFactory itemFactory;

    public EstoqueEBSRequestDTO createEstoqueEBSRequestDTO(ProductVMIResponseLeroyDTO stockVmi) {
        logger.info("Creating OrderDTO from PBA Purchase Order");
        var estoqueEBSRequestDTO = new EstoqueEBSRequestDTO();
        estoqueEBSRequestDTO.setCliente(CLIENTE);
        estoqueEBSRequestDTO.setCanal(CANAL);
        estoqueEBSRequestDTO.setDeposito(DEPOSITO);
        estoqueEBSRequestDTO.setItens(createItensEbs(stockVmi.getItems()));
        return estoqueEBSRequestDTO;

    }

    private List<ItemEBSDTO> createItensEbs(List<ProductLeroyDTO> productLeroyDTOList) {
        List<ItemEBSDTO> itemEBSDTOS = new ArrayList<>();
        for (ProductLeroyDTO produto : productLeroyDTOList) {
            itemEBSDTOS.add(new ItemEBSDTO(produto.getSupplierProductId(), produto.getSupplierSalesUnitMeasure()));
        }
        return itemEBSDTOS;
    }

    public SupplierProductsStockDTO createFromLeroySupplierProductsStockDTO(ProductLeroyDTO product) {
        SupplierProductsStockDTO stockDTO = new SupplierProductsStockDTO();
        stockDTO.setAvailableStock(BigDecimal.ZERO);
        stockDTO.setMinimumSalesQuantity(product.getMinSalesQuantity());
        stockDTO.setOperation("insert");
        stockDTO.setProductEAN(product.getProductEAN());
        stockDTO.setProductId(product.getProductId());
        stockDTO.setSupplierProductId(product.getSupplierProductId());
        stockDTO.setSupplierSalesUnitMeasure(product.getSupplierSalesUnitMeasure());
        stockDTO.setSupplierTransactionId(product.getSupplierFiscalId());
        return stockDTO;
    }

    public SupplierProductsStockDTO createFromEbsSupplierProductsStockDTO(ProductLeroyDTO product, EstoqueEBSResponseDTO stock) {
        SupplierProductsStockDTO stockDTO = new SupplierProductsStockDTO();
        stockDTO.setAvailableStock(ObjectUtils.isEmpty(stock.getSaldoDisponivelLongtailConv()) ? BigDecimal.ZERO : new BigDecimal(stock.getSaldoDisponivelLongtailConv()));
        stockDTO.setMinimumSalesQuantity(product.getMinSalesQuantity());
        stockDTO.setOperation("insert");
        stockDTO.setProductEAN(product.getProductEAN());
        stockDTO.setProductId(product.getProductId());
        stockDTO.setSupplierProductId(product.getSupplierProductId());
        stockDTO.setSupplierSalesUnitMeasure(product.getSupplierSalesUnitMeasure());
        stockDTO.setSupplierTransactionId(product.getSupplierFiscalId());
        return stockDTO;
    }

    public SupplierStockRequestDTO createSupplierStockRequestDTO(List<SupplierProductsStockDTO> supplierProductsStock) {
        return new SupplierStockRequestDTO(new SupplierStockDTO(supplierProductsStock));
    }
}
