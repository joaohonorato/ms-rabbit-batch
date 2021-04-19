package br.com.portobello.digital.partnerspurchaseorderbatch.repository.pba.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.pba.order.PbaBatchNewItemOrder;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.enums.EventStatusType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PbaBatchNewItemOrderRepository extends MongoRepository<PbaBatchNewItemOrder, String> {
    List<PbaBatchNewItemOrder> findByStatusType(EventStatusType statusType);

    Optional<PbaBatchNewItemOrder> findById(String id);
}
