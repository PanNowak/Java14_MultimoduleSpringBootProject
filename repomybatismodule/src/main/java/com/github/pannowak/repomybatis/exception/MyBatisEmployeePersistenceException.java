package com.github.pannowak.repomybatis.exception;

import com.github.pannowak.repoapi.exception.EmployeePersistenceException;

public class MyBatisEmployeePersistenceException extends EmployeePersistenceException {

    public MyBatisEmployeePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
