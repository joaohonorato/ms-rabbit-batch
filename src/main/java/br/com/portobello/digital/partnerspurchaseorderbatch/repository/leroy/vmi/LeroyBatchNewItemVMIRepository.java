package br.com.portobello.digital.partnerspurchaseorderbatch.repository.leroy.vmi;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.leroy.vmi.LeroyBatchNewItemVMI;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeroyBatchNewItemVMIRepository extends MongoRepository<LeroyBatchNewItemVMI, String> {
    Optional<LeroyBatchNewItemVMI> findById(String id);
}
