package com.bonc.test.service;

import com.bonc.test.domain.TextBean;

import java.util.List;

/**
 * Created by LinYuQiang on 2018/1/3 0003.
 */
public interface IMyTestService {

    List<TextBean> getAllText(String name);

    TextBean putText(TextBean textBean);

}
