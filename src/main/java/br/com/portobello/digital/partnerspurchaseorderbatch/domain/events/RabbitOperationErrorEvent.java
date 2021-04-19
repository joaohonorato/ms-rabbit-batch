package br.com.portobello.digital.partnerspurchaseorderbatch.domain.events;

import org.springframework.http.HttpStatus;

public class RabbitOperationErrorEvent {
    private final String errorMessage;
    private final String localizedMessage;
    private final HttpStatus httpStatus;

    public RabbitOperationErrorEvent(String errorMessage, String localizedMessage, HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.localizedMessage = localizedMessage;
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getLocalizedMessage() {
        return localizedMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
