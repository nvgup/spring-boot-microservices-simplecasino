package com.simplecasino.gameservice.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    private static final Logger logger = LoggerFactory.getLogger(FeignErrorDecoder.class);

    private ErrorDecoder defaultErrorDecoder = new Default();

    private ObjectMapper objectMapper;

    @Autowired
    public FeignErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() >= 400 && response.status() < 500) {
            try {
                ApiError apiError = objectMapper.readValue(response.body().asReader(), ApiError.class);
                return new ExternalServiceException(apiError);
            } catch (IOException e) {
                logger.error("Error during mapping response to ApiError", e);
            }
        }

        return defaultErrorDecoder.decode(s, response);
    }
}
