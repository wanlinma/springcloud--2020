package com.atguigu.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(T data) {
        this(200, "成功", data);
    }

    public static CommonResult ok(Integer code, String message){
        return new CommonResult(code,message);
    }

    public static CommonResult ok(Object data)
    {
        return new CommonResult(data);
    }

}
