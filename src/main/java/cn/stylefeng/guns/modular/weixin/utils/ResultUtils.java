package cn.stylefeng.guns.modular.weixin.utils;

/**
 * @Description: 自定义响应数据结构
 * 这个类是提供给门户，ios，安卓，微信商城用的
 * 门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 其他自行处理

 * @Author: superC
 * @Date: 2018/11/17 13:16
 */
public class ResultUtils {

    /**
     * 响应业务状态
     * 200：表示成功
     * 500：表示错误，错误信息在msg字段中
     * 501：bean验证错误，不管多少个错误都以map形式返回
     * 502：拦截器拦截到用户token出错
     * 555：异常抛出信息
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应中的数据
     */
    private Object data;


    /**
     * 自定义返回信息
     * @param status
     * @param msg
     * @param data
     * @return
     */
    public static ResultUtils build(Integer status, String msg, Object data) {
        return new ResultUtils(status, msg, data);
    }

    /**
     * 成功，返回data数据
     * @param data
     * @return
     */
    public static ResultUtils ok(Object data) {
        return new ResultUtils(data);
    }

    /**
     * 成功，无数据
     * @return
     */
    public static ResultUtils ok() {
        return new ResultUtils(null);
    }

    /**
     * 设置错误信息
     * @param msg
     * @return
     */
    public static ResultUtils errorMsg(String msg) {
        return new ResultUtils(500, msg, null);
    }

    public static ResultUtils errorMap(Object data) {
        return new ResultUtils(501, "error", data);
    }

    public static ResultUtils errorTokenMsg(String msg) {
        return new ResultUtils(502, msg, null);
    }

    public static ResultUtils errorException(String msg) {
        return new ResultUtils(555, msg, null);
    }

    /**
     * 构造函数
     */
    public ResultUtils() {

    }

    public ResultUtils(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtils(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    /**
     * 是否成功
     * @return
     */
    public Boolean isOK() {
        return this.status == 200;
    }

    /**
     * setter /getter
     */
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
