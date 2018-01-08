package com.bonc.test.mapper;

import com.bonc.test.domain.TextBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@Repository
public interface MyTestMapper {

    List<TextBean> selectTextByName(@Param("name") String name);

    TextBean selectTextById(@Param("id") String id);

    int insertText(@Param("textBean") TextBean textBean);
}
