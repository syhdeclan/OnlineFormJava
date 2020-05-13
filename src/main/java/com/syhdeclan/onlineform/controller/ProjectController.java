package com.syhdeclan.onlineform.controller;

import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.entity.Project;
import com.syhdeclan.onlineform.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-01-12 11
 **/

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public JsonResult getAll(){
        List<Project> all = this.projectService.getAll();
        return JsonResult.success(all);
    }

    @GetMapping("/{english}")
    public JsonResult getOneProject(@PathVariable String english){
        return JsonResult.success(this.projectService.getOneProject(english).get(0));
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public JsonResult create(@RequestBody Project project){
        this.projectService.create(project);
        return JsonResult.success("创建项目成功");
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public JsonResult update(@RequestBody Project project){
        this.projectService.update(project);
        return JsonResult.success("修改成功");
    }

}
