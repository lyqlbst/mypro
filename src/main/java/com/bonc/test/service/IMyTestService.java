package com.bonc.test.service;

import com.bonc.test.domain.TextBean;
import com.bonc.test.domain.TextParam;
import com.bonc.test.domain.UserInfo;

import java.util.List;

/**
 * Created by LinYuQiang on 2018/1/3 0003.
 */
public interface IMyTestService {

    List<UserInfo> getUserInfo();

    List<TextBean> getAllText(Integer pageNum,Integer pageSize);

    List<TextBean> getTextByUserId(String userId,Integer pageNum,Integer pageSize);

    TextBean putText(TextBean textBean);

    TextBean editTextByTestId(String testId, String text);

    TextBean editTestInfoByTestId(TextBean textBean);

    TextBean deleteTestInfoByTestId(String testId);
}
