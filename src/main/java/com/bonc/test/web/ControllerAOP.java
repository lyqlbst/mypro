package com.bonc.test.web;


import com.bonc.test.domain.base.CheckException;
import com.bonc.test.domain.base.PageResultBean;
import com.bonc.test.domain.base.ResultBean;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LinYuQiang on 2018/1/2 0002.
 */
@Configuration
@Aspect
public class ControllerAOP {

    private static final Logger logger = Logger.getLogger(ControllerAOP.class);

    @Pointcut("execution(* com.bonc.test.web..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object handlerControllerMethod(ProceedingJoinPoint point) {
        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = point.proceed();
            logger.info(point.getSignature() + "use time" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(point, e);
        }
        return result;
    }

    private Object handlerException(ProceedingJoinPoint point, Throwable e) {
        Object result = point;
        // 已知异常
        if (e instanceof CheckException) {
            if (point instanceof ResultBean) {
                ((ResultBean) point).setMsg(e.getLocalizedMessage());
                ((ResultBean) point).setCode(ResultBean.FAIL);
            } else if (point instanceof PageResultBean) {
                ((PageResultBean) point).setMsg(e.getLocalizedMessage());
                ((PageResultBean) point).setCode(ResultBean.FAIL);
            }
        } else {
            if (point instanceof ResultBean) {
                ((ResultBean) point).setMsg(e.toString());
                ((ResultBean) point).setCode(ResultBean.UNKNOWN_ERROR);
            } else if (point instanceof PageResultBean) {
                ((PageResultBean) point).setMsg(e.toString());
            ((PageResultBean) point).setCode(ResultBean.UNKNOWN_ERROR);
        }
            logger.error(point.getSignature() + " error ", e);
            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
        }
        return result;
    }
}
