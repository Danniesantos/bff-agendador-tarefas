package com.daniela.bffagendadortarefas.infrastructure.client.config;

import com.daniela.bffagendadortarefas.infrastructure.exceptions.*;
import com.daniela.bffagendadortarefas.infrastructure.exceptions.IllegalArgumentException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {
    private static final String ERROR_PREFIX = "Erro: ";

    @Override
    public Exception decode(String s, Response response) {

        String mensagemErro = mensagemErro(response);


        switch (response.status()) {
            case 409:
                return new ConflictException(ERROR_PREFIX + mensagemErro);
            case 404:
                return new ResourceNotFoundException(ERROR_PREFIX + mensagemErro);
            case 401:
                return new UnauthorizedException(ERROR_PREFIX + mensagemErro);
            case 400:
                return new IllegalArgumentException(ERROR_PREFIX + mensagemErro);
            case 502:
                return new CommunicationException(ERROR_PREFIX + mensagemErro);
            default:
                return new BusinessException(ERROR_PREFIX + mensagemErro);
        }
    }

    private String mensagemErro(Response response) {
        try {
            if (Objects.isNull(response.body())) {
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new CommunicationException("Erro de comunicação com o servidor", e);
        }
    }


}
