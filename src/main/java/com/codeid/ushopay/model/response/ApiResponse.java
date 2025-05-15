package com.codeid.ushopay.model.response;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private Instant timestamp = Instant.now();

    // // Constructors
    // public ApiResponse(String status, String message, T data) {
    //     this.status = status;
    //     this.message = message;
    //     this.data = data;
    //     this.timestamp = Instant.now();
    // }
}