package com.mathmind.springboot.dao;

public class ServiceResponse<T> {
    private T data;
    private String errorMessage;

    // Constructor for successful response
    public ServiceResponse(T data) {
        this.data = data;
    }

    // Constructor for error response
    public ServiceResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getters for data and errorMessage
    public T getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    // Method to check if response is successful
    public boolean isSuccess() {
        return errorMessage == null;
    }
}
