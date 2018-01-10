package com.bonc.test.util;

import com.bonc.test.domain.base.CheckException;
import com.bonc.test.domain.base.ErrorCode;
import com.google.common.base.Strings;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Created by LinYuQiang on 2018/1/10 0010.
 */
public class CheckParamUtil {

    public static void checkParam(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //表单验证
            StringBuffer sb = new StringBuffer();
            FieldError error = bindingResult.getFieldError();
            String field = error.getField();
            sb.append(error.getCode()).append("---").append(field).
                    append("---").append(error.getDefaultMessage());
            throw new CheckException(sb.toString(), ErrorCode.PARAMETER_ERROR.getCode());
        }
    }
}
