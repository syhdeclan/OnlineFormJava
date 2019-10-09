package com.syhdeclan.onlineform.controller;

import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author syh
 */
@RestController
@RequestMapping("formData/{code}")
public class FormDataController {

    @Autowired
    private FormDataService formDataService;

    @GetMapping()
    public JsonResult list(){
        return new JsonResult<>(0,"获取数据成功",this.formDataService.getAllData());
    }

    @PostMapping
    public JsonResult create(){
        return new JsonResult(0,"添加数据成功");
    }

}
