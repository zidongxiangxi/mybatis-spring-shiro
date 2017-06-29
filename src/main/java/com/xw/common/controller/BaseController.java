package com.xw.common.controller;

import com.xw.common.exception.ApiException;
import com.xw.common.model.ApiResponse;
import com.xw.common.model.RetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.lang.reflect.ParameterizedType;

@SuppressWarnings(value = { "unchecked" })
@Controller
public abstract class BaseController<T> {
    protected Logger logger = null;
    private Class<T> clazzT;

    public BaseController() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        clazzT = (Class<T>) type.getActualTypeArguments()[0];
        logger = LoggerFactory.getLogger(clazzT);
    }

    protected ApiResponse getRet(Object data) {
        ApiResponse response = new ApiResponse();
        response.setCode(RetCode.SUCCESS_CODE);
        response.setMsg(RetCode.SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    protected ApiResponse getRet() {
        ApiResponse response = new ApiResponse();
        response.setCode(RetCode.SUCCESS_CODE);
        response.setMsg(RetCode.SUCCESS_MSG);
        response.setData(null);
        return response;
    }

    protected void throwApiEx(int errCode, String errMsg) {
        throw new ApiException(errCode, errMsg, null);
    }

    /**
     * 当Service遇到强制需要捕获的异常,或者自己想捕获的时候使用
     *
     * @param e
     * @param msg
     * @author xdchen
     */
    protected void throwRuntimeEx(Exception e, String msg) {
        String err = e.getMessage();
        msg = msg == null ? "" : msg;
        throw new RuntimeException("Controller运行时异常:" + msg + "|" + err, e);
    }
}
