package com.bonc.test.web;


import com.bonc.test.domain.CheckException;
import com.bonc.test.domain.ResultBean;
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
        ResultBean<?> resultBean;
        try {
            resultBean = (ResultBean<?>) point.proceed();
            logger.info(point.getSignature() + "use time" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            resultBean = handlerException(point, e);
        }
        return resultBean;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint point, Throwable e) {
        ResultBean<?> result = new ResultBean();
        // 已知异常
        if (e instanceof CheckException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.FAIL);
        } else {
            logger.error(point.getSignature() + " error ", e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.UNKNOWN_ERROR);
            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。

        }
        return result;
    }
}
