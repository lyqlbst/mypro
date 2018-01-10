package com.bonc.test.domain.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg;
    private int code;

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
