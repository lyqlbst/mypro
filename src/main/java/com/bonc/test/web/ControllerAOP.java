package com.bonc.test.web;


import com.bonc.test.domain.base.CheckException;
import com.bonc.test.domain.base.ErrorCode;
import com.bonc.test.domain.base.PageResultBean;
import com.bonc.test.domain.base.ResultBean;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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
        Object result;
        try {
            result = point.proceed();
        } catch (Throwable e) {
            result = handlerException(point, e);
        }
        return result;
    }

    /**
     * 处理异常
     *
     * @param point ProceedingJoinPoint 切入点
     * @param e     异常
     * @return 统一返回ResultBean
     */
    private Object handlerException(ProceedingJoinPoint point, Throwable e) {
        ResultBean<?> result = ResultBean.builder().build();

        // 已知异常
        if (e instanceof CheckException) {
            return result.builder().code(((CheckException) e).getCode()).msg(((CheckException) e).getMsg()).build();
        } else {
            logger.error(point.getSignature() + " error ", e);

            result.builder().code(ErrorCode.SERVER_ERROR.getCode()).msg(ErrorCode.SERVER_ERROR.getMsg()).build();
            // 未知异常是应该重点关注的，这里可以做其他操作，如通知邮件，单独写到某个文件等等。
        }
        return result;
    }
}
