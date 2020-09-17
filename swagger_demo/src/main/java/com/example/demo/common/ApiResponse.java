package com.example.demo.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "通用接口返回", description = "Common Api Response")
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Code {

		SUCCESS(200, "succees"), FAIL(400, "fail");

		@Getter
		private int code;

		@Getter
		private String msg;

		// 构造方法私有化
		private Code() {
		}

		private Code(int code, String msg) {
			this.code = code;
			this.msg = msg;
		}
	}

	@ApiModelProperty(value = "通用返回状态", required = true)
	private Code code;

	@ApiModelProperty(value = "通用返回信息", required = true)
	private String message;

	@ApiModelProperty(value = "通用返回数据", required = true)
	private Object data;

}
