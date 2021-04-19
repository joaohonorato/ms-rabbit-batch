package br.com.portobello.digital.partnerspurchaseorderbatch.domain.entities.commons;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public abstract class BatchesInfo {
    @Id
    private String id;

    private LocalDateTime lastExecution;

    public BatchesInfo() {
        lastExecution = LocalDateTime.now();
    }

    public BatchesInfo(LocalDateTime now) {
        this.lastExecution = now;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLastExecution() {
        return lastExecution;
    }

    public void setLastExecution(LocalDateTime lastExecution) {
        this.lastExecution = lastExecution;
    }
}
