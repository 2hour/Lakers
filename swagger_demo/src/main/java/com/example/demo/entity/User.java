package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体", description = "User Entity")
public class User {

	@ApiModelProperty(value = "用户id" ,required = true)
	private Integer id;

	@ApiModelProperty(value = "用户名称" ,required = true)
	private String name;

	@ApiModelProperty(value = "工作岗位" ,required = true)
	private String job;

}
