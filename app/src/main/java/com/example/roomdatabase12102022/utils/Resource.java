package com.example.roomdatabase12102022.utils;

public class Resource<T> {
    public T data;
    public String message;
    public Status status;

    public Resource(T data, Status status) {
        this.data = data;
        this.status = status;
    }

    public Resource(String message, Status status) {
        this.message = message;
        this.status = status;
    }

    public static class Success<T> extends Resource<T> {
        public Success(T data) {
            super(data, Status.SUCCESS);
        }
    }

    public static class Error<T> extends Resource<T> {
        public Error(String message) {
            super(message, Status.ERROR);
        }
    }

    public static class Loading<T> extends Resource<T> {
        public Loading(T data) {
            super(data, Status.LOADING);
        }
    }

    public enum Status {
        SUCCESS, LOADING, ERROR
    }
}
