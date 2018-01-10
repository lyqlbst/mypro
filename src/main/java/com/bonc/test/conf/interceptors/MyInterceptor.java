package com.bonc.test.conf.interceptors;

import com.alibaba.fastjson.JSON;
import com.bonc.test.domain.base.ErrorCode;
import com.bonc.test.domain.base.ResultBean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LinYuQiang on 2018/1/10 0010.
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        String requestURI = httpServletRequest.getRequestURI();
//        if (requestURI != null && requestURI.contains("swagger")) return true;
//        httpServletResponse.setHeader("content-type", "application/json;charset=UTF-8");
////        httpServletResponse.setCharacterEncoding("UTF-8");
//        httpServletResponse.setStatus(401);
//        ResultBean<Object> resultBean = ResultBean.builder().code(ErrorCode.NO_LOGIN.getCode()).msg(ErrorCode.NO_LOGIN.getMsg()).build();
//        httpServletResponse.getOutputStream().write(JSON.toJSONBytes(resultBean));
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}