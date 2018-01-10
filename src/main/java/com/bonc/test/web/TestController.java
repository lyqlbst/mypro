package com.bonc.test.web;

import com.bonc.test.domain.TextBean;
import com.bonc.test.domain.base.CheckException;
import com.bonc.test.domain.base.PageResultBean;
import com.bonc.test.domain.base.ResultBean;
import com.bonc.test.service.IMyTestService;
import com.bonc.test.util.CheckParamUtil;
import com.bonc.test.util.UUIDUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    IMyTestService service;

    @ApiOperation(value = "获取text", notes = "获取text（分页）")
    @RequestMapping(value = "userInfo", method = RequestMethod.GET)
    public ResultBean getUserInfo() {
        return new ResultBean<>(service.getUserInfo());
    }

    @ApiOperation(value = "获取text", notes = "获取text（分页）")
    @RequestMapping(value = "texts", method = RequestMethod.GET)
    public PageResultBean getAllText(Integer pageNum, Integer pageSize) {
        return new PageResultBean<>(new PageInfo<>(service.getAllText(pageNum, pageSize)));
    }

    @ApiOperation(value = "根据userId获取text", notes = "根据userId获取text（分页）")
    @RequestMapping(value = "texts/{userId}", method = RequestMethod.GET)
    public PageResultBean getTextByUserId(@PathVariable("userId") String userId, Integer pageNum, Integer pageSize) {
        return new PageResultBean<>(new PageInfo<>(service.getTextByUserId(userId, pageNum, pageSize)));
    }

    @RequestMapping(value = "texts", method = RequestMethod.POST)
    @ApiOperation(value = "新增text", notes = "新增text")
    public ResultBean putText(@Valid @RequestBody TextBean textBean, BindingResult bindingResult) {
        CheckParamUtil.checkParam(bindingResult);
        return new ResultBean<>(service.putText(textBean.builder().testId(UUIDUtil.getRandomUUID()).build()));
    }

    @RequestMapping(value = "texts/{testId}", method = RequestMethod.PATCH)
    @ApiOperation(value = "根据testId编辑text", notes = "根据testId修改text")//testId:2630f6a70d8d4aa4a5fe4f85ad733378
    public ResultBean editTextByTestId(@PathVariable("testId") String testId, @RequestBody TextBean textBean) {
        return new ResultBean<>(service.editTextByTestId(testId, textBean.getTestText()));
    }

    @RequestMapping(value = "texts/{testId}", method = RequestMethod.PUT)
    @ApiOperation(value = "根据testId编辑test所有信息", notes = "根据testId编辑test所有信息")//testId:2630f6a70d8d4aa4a5fe4f85ad733378
    public ResultBean editTestInfoByTestId(@PathVariable("testId") String testId, @RequestBody TextBean textBean) {
        return new ResultBean<>(service.editTestInfoByTestId(textBean.builder().testId(testId).build()));
    }

    @RequestMapping(value = "texts/{testId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据testId删除test信息", notes = "根据testId删除test信息")//testId:2630f6a70d8d4aa4a5fe4f85ad733378
    public ResultBean deleteTestInfoByTestId(@PathVariable("testId") String testId) {
        return new ResultBean<>(service.deleteTestInfoByTestId(testId));
    }
}