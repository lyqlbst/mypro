package com.bonc.test.domain.base;

import lombok.*;

import java.io.Serializable;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int SUCCESS = 200;
    public static final int FAIL = 402;

    private String msg = ErrorCode.SUCCESS.getMsg();
    private int code = ErrorCode.SUCCESS.getCode();
    private T data;

    public ResultBean(T data) {
        super();
        this.data = data;
    }

}
