package br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order.LeroyBatchesInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeroyBatchesRepository extends MongoRepository<LeroyBatchesInfo, String> {

    LeroyBatchesInfo findFirstByLastExecutionIsNotNullOrderByLastExecutionDesc();
}
