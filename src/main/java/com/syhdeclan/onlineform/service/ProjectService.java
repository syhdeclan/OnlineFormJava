package com.syhdeclan.onlineform.service;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.JsonResult;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.entity.Project;
import com.syhdeclan.onlineform.repository.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-01-12 09
 **/

@Service
@Validated
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAll(){
        return this.projectRepository.findAllByIsDelete(0);
    }

    /**
     * 获取单个表单
     * @param english
     * @return
     */
    public List<Project> getOneProject(@NotBlank String english){
        List<Project> projectList = this.projectRepository.findByEnglishAndIsDelete(english, 0);
        if (projectList.size() != 1) {
            throw new WebException(Code.ENTITY_NOT_EXISTS);
        }
        return projectList;
    }

    /**
     * 获取单个表单
     * @param id
     * @return
     */
    public List<Project> getOneProject(@NotBlank long id){
        List<Project> projectList = this.projectRepository.findByIdAndIsDelete(id, 0);
        if (projectList.size() != 1) {
            throw new WebException(Code.ENTITY_NOT_EXISTS);
        }
        return projectList;
    }

    public void create(@Valid Project project){

        this.projectRepository.save(project);
    }

    public void update(@Valid Project project){

        List<Project> list = this.projectRepository.findByIdAndIsDelete(project.getId(), 0);
        if (list.size() != 1) {
            throw new WebException(Code.ENTITY_NOT_EXISTS);
        }
        Project pro = list.get(0);
        BeanUtils.copyProperties(project,pro);
        this.projectRepository.save(pro);

    }

}
