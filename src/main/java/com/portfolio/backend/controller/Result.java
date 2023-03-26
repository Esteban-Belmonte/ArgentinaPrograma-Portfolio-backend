package com.portfolio.backend.controller;

/*
Clase que unicamente existe para regresar un mensaje en algunos endpoints
*/
class Result {
    private final String message;

    Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
