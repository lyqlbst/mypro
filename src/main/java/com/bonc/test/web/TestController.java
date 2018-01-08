package com.bonc.test.web;

import com.bonc.test.domain.ResultBean;
import com.bonc.test.domain.TextBean;
import com.bonc.test.service.IMyTestService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@RestController
@RequestMapping("Test")
public class TestController {

    @Autowired
    IMyTestService service;

    @ApiOperation(value = "根据名字获取text", notes = "根据名字获取text")
    @RequestMapping(value = "text/{name}", method = RequestMethod.GET)
    public ResultBean name(@PathVariable("name") String name) {
        return new ResultBean<>(service.getAllText(name));
    }

    @RequestMapping(value = "{name}/{text}/update", method = RequestMethod.PUT)
    public ResultBean putText(@PathVariable("name") String name, @PathVariable("text") String text) {
        return new ResultBean<>(service.putText(new TextBean(UUID.randomUUID().toString(), text, name)));
    }

    @ApiOperation(value = "测试", notes = "测试接收字节流")
    @RequestMapping(value = "{bytes}", method = RequestMethod.PUT)
    public ResultBean test(@PathVariable("bytes") byte[] bytes) {
        System.out.println(bytes);
        return new ResultBean<>(bytes.toString());
    }

}