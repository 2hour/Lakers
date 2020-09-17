package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 会扫描该包下所有 Controller 定义的 API，并产生文档内容（除了被 @ApiIgnore 指定的请求）
 * @author Administrator
 * @date 2020年9月15日
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	//控制层包路径
	public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.example.demo.controller";
	
	public static final String VERSION = "1.0.0";
	
	@Bean //配置docket以配置Swagger具体参数
	public Docket createRestApi() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.enable(true) //配置是否启用Swagger，如果是false，在浏览器将无法访问
				.select() //返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给 Swagger 来展现，本例采用指定扫描的包路径来定义
				.apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
				.paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
				.build();
	}
	
	/*
	 * 上面的paths()的可选值为：
	 *                       （1）any() // 任何请求都扫描
	 *                       （2）none() // 任何请求都不扫描
	 *                       （3）regex(final String pathRegex) // 通过正则表达式控制
	 *                       （4）ant(final String antPattern) // 通过ant()控制
	 */
	
	
	// 配置文档信息
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("hu ren zon guan jun")
				.description("这是一个简单的 Swagger API 演示")
				.version(VERSION)
				.build();
	}

}
