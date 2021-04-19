package br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.order;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.order.LeroyBatchItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeroyBatchItemRepository extends MongoRepository<LeroyBatchItem, String> {
}
