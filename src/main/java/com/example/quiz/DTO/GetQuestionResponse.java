package com.example.quiz.DTO;

import com.example.quiz.model.Questions;
import org.springframework.http.HttpStatus;

public class GetQuestionResponse {
    private Questions question;
    private HttpStatus status;
    private String message;

    public GetQuestionResponse(){}

    public GetQuestionResponse(Questions question, HttpStatus status, String message) {
        this.question = question;
        this.status = status;
        this.message = message;
    }

    public Questions getQuestion() {
        return question;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
