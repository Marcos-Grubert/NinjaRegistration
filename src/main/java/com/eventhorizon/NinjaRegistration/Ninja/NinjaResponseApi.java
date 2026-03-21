package com.eventhorizon.NinjaRegistration.Ninja;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NinjaResponseApi<T>{
    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public NinjaResponseApi(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }
}
