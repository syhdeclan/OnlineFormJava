package com.syhdeclan.onlineform.controller;

import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.entity.Form;
import com.syhdeclan.onlineform.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author syh
 */
@RestController
@RequestMapping("/form")
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
            return new JsonResult<>(0,"获取表单数据成功", list.get(0));
        }
        return new JsonResult<>(1,"不存在该表单",null);
    }

    @GetMapping
    public JsonResult<List<Form>> list(){
        return new JsonResult<>(0,"获取表单列表成功",this.formService.getAll());
    }

    @PostMapping
    public JsonResult create(Form form){
        this.formService.create(form);
        return new JsonResult(0,"创建成功");
    }






    @PutMapping
    public JsonResult modify(){

        return new JsonResult(0,"修改数据成功");
    }

    @DeleteMapping
    public JsonResult delete(){

        return new JsonResult(0,"删除数据成功");
    }

}
