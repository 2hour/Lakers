package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.ApiResponse;
import com.example.demo.common.ApiResponse.Code;
import com.example.demo.common.DataType;
import com.example.demo.common.ParamType;
import com.example.demo.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "Swagger接口例子", value = "SwaggerController_Here")
public class SwaggerController {
	
    @Value(value = "${application.version}")
    private String DEMO_VERSION;

    /**
     * @des 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据主键ID查询用户（Get）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户主键ID", dataType = DataType.INTEGER, paramType = ParamType.PATH)})
    public ApiResponse get(@ApiParam(value = "查询的用户ID", required = true) @PathVariable Integer id) {
        log.info("单个参数用  @ApiImplicitParam");
        return ApiResponse.builder().code(Code.SUCCESS)
        		.message("查询用户成功")
        		.data(new User(id, "Mariy", "测试开发工程师"))
        		.build();
    }
    
    /**
     * @des 根据id删除用户
     * @param id
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据主键ID删除用户（Delete）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户主键ID", dataType = DataType.INTEGER, paramType = ParamType.PATH)})
    public Integer delete(@PathVariable Integer id) {
        log.info("单个参数用 ApiImplicitParam。NOW_DATE_TIME: " + DEMO_VERSION);
        return id;
    }
    
    /**
     * @des 添加用户
     * @param user
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加用户（Post）")
    public User post(@RequestBody User user) {
        log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam。NOW_DATE_TIME: " + DEMO_VERSION);
        return user;
    }
    
    /**
     * @des 修改用户
     * @param id
     * @param user
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "修改用户（Put）")
    public User put(@PathVariable Integer id, @RequestBody User user) {
        log.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息.NOW_DATE_TIME: " + DEMO_VERSION );
        user.setId(id);
        return user;
    }

    /**
     * @des 文件上傳
     * @param id
     * @param file
     * @return
     */
    @PostMapping("/{id}/file")
    @ApiOperation(value = "文件上传（Post）")
    public String file(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        log.info(file.getContentType());
        log.info(file.getName());
        log.info(file.getOriginalFilename());
        return file.getOriginalFilename();
    }
    
	
}
