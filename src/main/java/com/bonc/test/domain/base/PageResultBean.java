package com.bonc.test.domain.base;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LinYuQiang on 2018/1/9 0009.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResultBean<T>implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pageNum;//当前页
    private int pageSize;//每页的数量
    private int size;//当前页的数量
    private long total;//总记录数
    private int pages;//总页数

    private String msg = ErrorCode.SUCCESS.getMsg();
    private int code = ErrorCode.SUCCESS.getCode();
    private List<T> data;

    public PageResultBean(PageInfo<T> data) {
        this.pageNum = data.getPageNum();
        this.pageSize = data.getPageSize();
        this.size = data.getSize();
        this.total = data.getTotal();
        this.pages = data.getPages();
        this.data = data.getList();
    }
}
