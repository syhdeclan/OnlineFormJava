package com.syhdeclan.onlineform.controller;

import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.entity.UpdateLog;
import com.syhdeclan.onlineform.service.UpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-05-05 18
 **/

@RestController
@RequestMapping("/api/updateLog")
public class UpdateLogController {

    @Autowired
    UpdateLogService updateLogService;

    @GetMapping("/{english}")
    public JsonResult getAll(@PathVariable String english) {
        List<UpdateLog> all = this.updateLogService.getAll(english);
        return JsonResult.success(all);
    }

    @GetMapping
    public JsonResult getAll(HttpServletRequest request) {
        List<UpdateLog> all = this.updateLogService.getAll(request.getParameter("english"));
        return JsonResult.success(all);
    }

    @PostMapping
    public JsonResult create(@RequestBody UpdateLog updateLog) {
        this.updateLogService.create(updateLog);
        return JsonResult.success("创建版本日志成功");
    }

    @DeleteMapping
    public JsonResult delete(@RequestBody Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            this.updateLogService.delete(ids[i]);
        }
        return JsonResult.success("删除版本日志成功");
    }

}
