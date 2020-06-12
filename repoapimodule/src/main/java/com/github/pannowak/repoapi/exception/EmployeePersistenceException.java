package com.github.pannowak.repoapi.exception;

public class EmployeePersistenceException extends Exception {

    public EmployeePersistenceException(String message) {
        super(message);
    }

    public EmployeePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeePersistenceException(Throwable cause) {
        super(cause);
    }
}
