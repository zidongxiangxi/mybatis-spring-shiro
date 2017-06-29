package com.xw.common.model;

public class RetCode {
    /**
     * 默认的成功代码和消息
     */
    public static final int SUCCESS_CODE = 10000;
    public static final String SUCCESS_MSG = "成功";

    public static final int UNKNOW_ERR = 40000; //未知错误
    public static final String UNKNOW_ERR_MSG = "未知错误";

    /**
     * 请求的接口不存在
     */
    public static final int METHOD_NOT_FOUND_CODE = 40100;
    public static final String METHOD_NOT_FOUND_MSG = "接口访问方式不正确(GET/POST/PUT/DELETE...)";

    /**
     * 接口参数错误<br>
     * 必传的没传,参数类型转换错误,或者手动抛出InvalidParamException(有的时候验证框架并不完美,需要手动验证并抛出)等等<br>
     *
     * validtion框架验证不通过
     */
    public static final int WRONG_METHOD_PARAM_CODE = 40200;
    public static final String WRONG_METHOD_PARAM_MSG = "接口参数错误(少传、格式或类型错误)";

    /**
     * 数据问题(残缺)错误
     */
    public static final int INVALID_DATA_CODE = 40300;
    public static final String INVALID_DATA_MSG = "数据问题(残缺)错误";

    /**
     * 没有权限调用接口(摘要错误)
     */
    public static final int NOT_AUTH_CODE = 40400;
    public static final String NOT_AUTH_MSG = "没有权限调用接口(摘要错误)";

    /**
     * 意料之外的运行时异常
     */
    public static final int RUNTIME_EX_CODE = 40500;
    public static final String RUNTIME_EX_MSG = "意料之外的运行时异常";

    /**
     * 非公共业务错误码(允许重复)
     *
     * @author xdchen
     *
     */
    public static class Busi {

    }
}
