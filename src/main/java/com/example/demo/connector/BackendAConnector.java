package com.example.demo.connector;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import com.example.demo.exception.BusinessException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.reactivex.Observable;

/**
 * This Connector shows how to use the CircuitBreaker annotation.
 */
@CircuitBreaker(name = "backendA")
@Component(value = "backendAConnector")
public class BackendAConnector implements Connector {

    @Override
    public String failure() {
        throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception");
    }

    @Override
    public String ignoreException() {
        throw new BusinessException("This exception is ignored by the CircuitBreaker of backend A");
    }

    @Override
    public String success() {
        return "Hello World from backend A";
    }

    @Override
    public Observable<String> methodWhichReturnsAStream() {
        return Observable.never();
    }
}
