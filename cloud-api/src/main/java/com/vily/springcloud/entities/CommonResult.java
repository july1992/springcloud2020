package com.vily.springcloud.entities;

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

	//两个参数，因为注解上，已经有了空参和全参
	public CommonResult(Integer code,String message){
		this(code,message,null);
	}

}
