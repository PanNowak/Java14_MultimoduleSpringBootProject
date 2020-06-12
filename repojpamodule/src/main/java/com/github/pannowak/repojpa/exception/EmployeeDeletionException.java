package com.github.pannowak.repojpa.exception;

import com.github.pannowak.repoapi.exception.EmployeePersistenceException;

public class EmployeeDeletionException extends EmployeePersistenceException {

    public EmployeeDeletionException(Throwable cause) {
        super(cause);
    }
}
