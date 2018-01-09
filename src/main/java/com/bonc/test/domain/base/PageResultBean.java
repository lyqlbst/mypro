package com.bonc.test.domain.base;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LinYuQiang on 2018/1/9 0009.
 */
@Data
public class PageResultBean<T>implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pageNum;//当前页
    private int pageSize;//每页的数量
    private int size;//当前页的数量
    private long total;//总记录数
    private int pages;//总页数

    public static final int SUCCESS = 200;
    public static final int FAIL = 402;
    public static final int NO_LOGIN = 401;
    public static final int NO_PERMISSION = 403;
    public static final int UNKNOWN_ERROR = 500;

    private String msg = "success";
    private int code = SUCCESS;
    private List<T> data;

    public PageResultBean() {
        super();
    }

    public PageResultBean(PageInfo<T> data) {
        this.pageNum = data.getPageNum();
        this.pageSize = data.getPageSize();
        this.size = data.getSize();
        this.total = data.getTotal();
        this.pages = data.getPages();
        this.data = data.getList();
    }

    public PageResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }
}
