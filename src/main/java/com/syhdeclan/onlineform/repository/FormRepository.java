package com.syhdeclan.onlineform.repository;

import com.syhdeclan.onlineform.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormRepository extends JpaRepository<Form,Integer> {


    /**
     * 通过表单的唯一code获取
     * @param code 表单的唯一标识
     * @param isDelete 是否被删除
     * @return 长度为1的list
     */
    List<Form> findFirstByCodeAndIsDelete(String code,int isDelete);

    /**
     * 一次性全部获取所有表单
     * @param isDelete 是否被删除
     * @return 所有未被删除的表单
     */
    List<Form> findAllByIsDelete(int isDelete);

}
