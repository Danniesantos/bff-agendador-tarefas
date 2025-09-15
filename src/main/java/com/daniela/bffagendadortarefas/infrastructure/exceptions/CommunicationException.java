package com.daniela.bffagendadortarefas.infrastructure.exceptions;

public class CommunicationException extends RuntimeException {
    public CommunicationException(String message) {
        super(message);
    }

    public CommunicationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
