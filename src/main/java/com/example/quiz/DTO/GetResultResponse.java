package com.example.quiz.DTO;

import org.springframework.http.HttpStatus;

public class GetResultResponse {
    private HttpStatus status;
    private String message;

    public GetResultResponse(){}

    public GetResultResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
