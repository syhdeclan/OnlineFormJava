package com.syhdeclan.onlineform.repository;

import com.syhdeclan.onlineform.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    /**
     * 获取所有数据
     * @param isDelete
     * @return
     */
    List<Project> findAllByIsDelete(int isDelete);

    /**
     * 根据id获取项目
     * @param id
     * @param isDelete
     * @return
     */
    List<Project> findByIdAndIsDelete(long id, int isDelete);

    /**
     * 根据英文名查询
     * @param id
     * @param isDelete
     * @return
     */
    List<Project> findByEnglishAndIsDelete(String english, int isDelete);



}
