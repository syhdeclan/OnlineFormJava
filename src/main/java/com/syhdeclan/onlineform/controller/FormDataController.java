package com.syhdeclan.onlineform.controller;

import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.entity.FormData;
import com.syhdeclan.onlineform.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author syh
 */
@RestController
@RequestMapping("/api/formData/{code}")
public class FormDataController {

    @Autowired
    private FormDataService formDataService;

    /**
     * 获取某个表单的所有填写数据
     * @param code 表单标识
     * @return Json
     */
    @GetMapping()
    public JsonResult list(@PathVariable String code){
        return JsonResult.success(this.formDataService.getAllData(code));
    }

    /**
     * 填写某个表单的数据
     * @return Json
     */
    @PostMapping
    public JsonResult create(@RequestBody FormData formData, @PathVariable String code){
        this.formDataService.fillAForm(formData,code);
        return JsonResult.success("添加数据成功");
    }

}
