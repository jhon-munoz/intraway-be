package com.intraway.project.exceptions;

import com.intraway.project.exceptions.errors.ErrorEnum;

public class BadGatewayException extends BaseException {

    public BadGatewayException(ErrorEnum error, Object... args) {
        super(error, args);
    }
}
