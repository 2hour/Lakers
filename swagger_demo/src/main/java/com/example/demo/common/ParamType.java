package com.example.demo.common;

/**
 * 代表参数应该放在请求的什么地方
 * @author Administrator
 * @date 2020年9月15日
 */
public final class ParamType {
    
	/**
	 * 用于restful接口  请求参数的获取：@PathVariable(代码中接收注解)
	 */
    public final static String PATH = "path";

	/**
	 * 用于get请求的参数拼接。请求参数的获取：@RequestParam(代码中接收注解)
	 */
    public final static String QUERY = "query";
    
	/**
	 * 放在请求头。请求参数的获取：@RequestHeader(代码中接收注解)
	 */
    public final static String HEADER = "header";
    
	/**
	 * 放在请求体。请求参数的获取：@RequestBody(代码中接收注解)
	 */
    public final static String BODY = "body";
    
	/**
	 * 代表参数应该放在form
	 */
    public final static String FORM = "form";

}