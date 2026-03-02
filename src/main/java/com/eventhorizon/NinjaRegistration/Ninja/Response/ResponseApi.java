package com.eventhorizon.NinjaRegistration.Ninja.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseApi<T>{
    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ResponseApi(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
