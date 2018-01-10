package com.bonc.test.domain.base;

/**
 * Created by LinYuQiang on 2018/1/10 0010.
 */
public enum ErrorCode {

    SUCCESS(200,"成功"),
    NO_LOGIN(401,"未登录"),
    PARAMETER_ERROR(402,"参数错误"),
    NO_PERMISSION(403,"无权限"),
    EDIT_ERROR(405,"编辑失败"),
    SERVER_ERROR(500,"服务器错误");

    private int code;
    private String msg;

    ErrorCode(int code, String value){
        this.code = code;
        this.msg = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
