package br.com.portobello.digital.partnerspurchaseorderbatch.service.facade;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.PurchaseOrderPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order.PbaBatchesOrderInfo;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory.NewItemOrderFactory;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory.OrderFactory;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.vos.leroy.FilterVo;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.pba.order.PbaBatchItemOrderRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.pba.order.PbaBatchNewItemOrderRepository;
import br.com.portobello.digital.partnerspurchaseorderbatch.repository.pba.order.PbaBatchesOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

@Service
public class PbaBatchFacadeService {

    Logger logger = LoggerFactory.getLogger(PbaBatchFacadeService.class);

    @Autowired
    private PbaBatchesOrderRepository orderRepository;

    @Autowired
    private PbaBatchItemOrderRepository batchItemOrderRepository;

    @Autowired
    private PbaBatchNewItemOrderRepository batchNewItemOrderRepository;


    @Autowired
    private NewItemOrderFactory newItemOrderFactory;

    @Autowired
    private OrderFactory orderFactory;

    public void clearDocuments() {
        logger.info("Cleaning documents");
        batchItemOrderRepository.deleteAll();
    }

    public FilterVo getIntegrationPeriod() {
        PbaBatchesOrderInfo lastExecutionTime = orderRepository.findFirstByLastExecutionIsNotNullOrderByLastExecutionDesc();
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        LocalDateTime initialDateTime = Objects.nonNull(lastExecutionTime) ? lastExecutionTime.getLastExecution() : now;
        return new FilterVo(initialDateTime, now, null);
    }

    public void saveNewItens(List<PurchaseOrderPbaDTO> purchaseOrders) {
        purchaseOrders.stream().map(po -> newItemOrderFactory.createPbaNewItem(po, orderFactory.createOrderDTO(po))).forEach(batchNewItemOrderRepository::save);
    }
}
