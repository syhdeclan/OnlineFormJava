package com.syhdeclan.onlineform.controller;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.entity.Form;
import com.syhdeclan.onlineform.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * @Author syh
 */
@RestController
@RequestMapping("/api/form")
public class FormController {

    @Autowired
    private FormService formService;

//    @ApiOperation(value = "单个表单信息",notes = "将根据表单的唯一标识码获取表单")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "code",value = "表单的唯一标识码",required = true,dataType = "String")
//    })

    @GetMapping(value = "/{code}")
    public JsonResult<Form> get(@PathVariable String code){
        List<Form> list = this.formService.getByCode(code);
        if (list.size() > 0){
            return JsonResult.success(list.get(0));
        }
        return JsonResult.error(Code.ENTITY_NOT_EXISTS);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public JsonResult<List<Form>> list(){
        return JsonResult.success(this.formService.getAll());
    }

    @PostMapping
    public JsonResult create(@RequestBody Form form){
        this.formService.create(form);
        return JsonResult.success("创建表单成功");
    }


    @PutMapping
    public JsonResult modify(){

        return JsonResult.success("修改数据成功");
    }

    @DeleteMapping
    public JsonResult delete(){

        return JsonResult.success("删除数据成功");
    }

}
