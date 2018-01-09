package com.bonc.test.service.impl;

import com.bonc.test.caches.CacheNames;
import com.bonc.test.domain.TextBean;
import com.bonc.test.domain.UserInfo;
import com.bonc.test.mapper.MyTestMapper;
import com.bonc.test.service.IMyTestService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LinYuQiang on 2018/1/3 0003.
 */
@Service
public class MyTestService implements IMyTestService {

    @Autowired
    MyTestMapper testMapper;

    @Cacheable(CacheNames.USER_INO)
    @Override
    public List<UserInfo> getUserInfo() {
        return testMapper.selectUserInfo();
    }

    //    @Cacheable(CacheNames.TEXT)
    @Override
    public List<TextBean> getAllText(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return testMapper.selectText();
    }

    //    @Cacheable(CacheNames.TEXT)
    @Override
    public List<TextBean> getTextByUserId(String userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return testMapper.selectTextByUserId(userId);
    }

    //    @CacheEvict(value = CacheNames.TEST, allEntries = true)
    @Override
    public TextBean putText(TextBean textBean) {
        testMapper.insertText(textBean);
        return testMapper.selectTestInfoByTestId(textBean.getTestId());
    }

    @Override
    public TextBean editTextByTestId(String testId, String text) {
        testMapper.updateTextByTestId(testId, text);
        return testMapper.selectTestInfoByTestId(testId);
    }

    @Override
    public TextBean editTestInfoByTestId(TextBean textBean) {
        testMapper.updateTestInfoByTestId(textBean);
        return testMapper.selectTestInfoByTestId(textBean.getTestId());
    }

    @Override
    public TextBean deleteTestInfoByTestId(String testId) {
        testMapper.deleteTestInfoByTestId(testId);
        return testMapper.selectTestInfoByTestId(testId);
    }
}
