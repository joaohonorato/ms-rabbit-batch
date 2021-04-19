package br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.vmi;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.vmi.LeroyBatchItemVMI;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeroyBatchItemVMIRepository extends MongoRepository<LeroyBatchItemVMI, String> {
}
