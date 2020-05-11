package com.syhdeclan.onlineform.repository;

import com.syhdeclan.onlineform.entity.UpdateLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UpdateLogRepository extends JpaRepository<UpdateLog,Long> {

    /**
     * 根据english获取对应的日志信息
     * @param english
     * @param isDelete
     * @return
     */
    List<UpdateLog> findAllByEnglishAndIsDeleteOrderByCreateAtDesc(String english, int isDelete);

    List<UpdateLog> findAllByIdAndIsDelete(long id, int isDelete);


}
