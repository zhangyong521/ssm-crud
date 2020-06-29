package com.zhangyong.bean;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 张勇
 * @Date 2019/12/28 21:50
 * @Version 1.0
 * 定义json返回对象
 */
@Data
public class Msg {
    /**
     * 状态码，100表示成功，200表示失败
     */
    private int code;
    /**
     * 返回提示信息
     */
    private String msg;
    /**
     * 将返回的浏览器的数据保存在map中
     */
    private Map<String,Object> extend = new HashMap<> ();

    /**
     * 请求成功
     * @return
     */
    public static Msg success(){
        Msg result = new Msg ();
        result.setCode (100);
        result.setMsg ("处理成功");
        return result;
    }

    /**
     * 请求失败
     * @return
     */
    public static Msg fail(){
        Msg result = new Msg ();
        result.setCode (200);
        result.setMsg ("处理失败");
        return result;
    }



    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public Msg add(String key, Object value) {
        this.getExtend ().put (key,value);
        return this;
    }
}
