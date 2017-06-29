package com.xw.web.exception;

import com.alibaba.fastjson.JSON;
import com.xw.common.exception.ApiException;
import com.xw.common.model.ApiResponse;
import com.xw.common.model.RetCode;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-12
 * <p>Version: 1.0
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    private Logger logger =  LoggerFactory.getLogger(DefaultExceptionHandler.class);

    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.setViewName("unauthorized");
        return mv;
    }

    @ExceptionHandler({ApiException.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    public void processUnauthenticatedException(HttpServletResponse response, RuntimeException ex) {
        ApiResponse apiResponse = new ApiResponse();
        if (ex instanceof ApiException) {
            ApiException apiException = (ApiException) ex;
            apiResponse.setCode(apiException.getErrCode());
            apiResponse.setMsg(apiException.getMessage());
        } else {
            apiResponse.setCode(RetCode.UNKNOW_ERR);
            apiResponse.setMsg(ex.getMessage());
            logger.error("出现未知的运行时异常：", ex);
        }
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            writer = response.getWriter();
            writer.write(JSON.toJSONString(apiResponse));
            writer.flush();
        } catch (IOException e) {
            logger.error("fail to write error message to response");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
