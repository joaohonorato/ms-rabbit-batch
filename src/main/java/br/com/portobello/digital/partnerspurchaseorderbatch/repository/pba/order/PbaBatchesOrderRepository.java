package br.com.portobello.digital.partnerspurchaseorderbatch.repository.pba.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order.PbaBatchesOrderInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PbaBatchesOrderRepository extends MongoRepository<PbaBatchesOrderInfo, String> {

    PbaBatchesOrderInfo findFirstByLastExecutionIsNotNullOrderByLastExecutionDesc();
}
