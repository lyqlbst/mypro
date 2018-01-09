package com.bonc.test.domain.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@Data
public class ResultBean<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    public static final int SUCCESS = 200;
    public static final int FAIL = 402;
    public static final int NO_LOGIN = 401;
    public static final int NO_PERMISSION = 403;
    public static final int UNKNOWN_ERROR = 500;

    private String msg = "success";
    private int code = SUCCESS;
    private T data;

    public ResultBean(){
        super();
    }

    public ResultBean(T data){
        super();
        this.data = data;
    }

    public ResultBean(Throwable e){
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }
}
