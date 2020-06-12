package com.github.pannowak.repojpa.exception;

import com.github.pannowak.repoapi.exception.EmployeePersistenceException;

public class EmployeeStorageException extends EmployeePersistenceException {

    public EmployeeStorageException(Throwable cause) {
        super(cause);
    }
}
