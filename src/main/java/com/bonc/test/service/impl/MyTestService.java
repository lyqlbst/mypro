package com.bonc.test.service.impl;

import com.bonc.test.caches.CacheNames;
import com.bonc.test.domain.CheckException;
import com.bonc.test.domain.TextBean;
import com.bonc.test.mapper.MyTestMapper;
import com.bonc.test.service.IMyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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

    @Cacheable(CacheNames.TEST)
    @Override
    public List<TextBean> getAllText(String name) {
        if ("德福".equals(name)) throw new CheckException("德福不能登录");
        return testMapper.selectTextByName(name);
    }

    @CacheEvict(value = CacheNames.TEST, allEntries = true)
    @Override
    public TextBean putText(TextBean textBean) {
        return testMapper.insertText(textBean) == 1 ? testMapper.selectTextById(textBean.getTestId()) : null;
    }
}
