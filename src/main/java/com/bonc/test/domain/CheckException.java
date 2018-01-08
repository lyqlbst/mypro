package com.bonc.test.domain;

import lombok.Data;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@Data
public class CheckException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
