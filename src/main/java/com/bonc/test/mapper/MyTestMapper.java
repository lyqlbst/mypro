package com.bonc.test.mapper;

import com.bonc.test.domain.TextBean;
import com.bonc.test.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@Repository
public interface MyTestMapper {

    TextBean selectTestInfoByTestId(@Param("testId") String testId);

    List<UserInfo> selectUserInfo();

    List<TextBean> selectText();

    List<TextBean> selectTextByUserId(@Param("userId") String userId);

    int insertText(@Param("textBean") TextBean textBean);

    int updateTextByTestId(@Param("testId") String testId, @Param("text") String text);

    int updateTestInfoByTestId(@Param("textBean") TextBean textBean);

    int deleteTestInfoByTestId(@Param("testId") String testId);
}
