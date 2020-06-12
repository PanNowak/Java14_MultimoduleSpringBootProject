package com.github.pannowak.repojpa.exception;

import com.github.pannowak.repoapi.exception.EmployeePersistenceException;

public class EmployeeRetrievalException extends EmployeePersistenceException {

    public EmployeeRetrievalException(Throwable cause) {
        super(cause);
    }
}
