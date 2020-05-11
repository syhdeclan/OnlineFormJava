package com.syhdeclan.onlineform.service;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.entity.Project;
import com.syhdeclan.onlineform.entity.UpdateLog;
import com.syhdeclan.onlineform.repository.UpdateLogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-01-12 11
 **/


@Service
@Validated
public class UpdateLogService {

    @Autowired
    private UpdateLogRepository updateLogRepository;

    /**
     * 获取某个项目的所有日志
     * @param english
     * @return
     */
    public List<UpdateLog> getAll(@NotNull String english){
        List<UpdateLog> list = this.updateLogRepository.findAllByEnglishAndIsDeleteOrderByCreateAtDesc(english, 0);
        return list;
    }

    /**
     * 给某个项目创建日志
     * @param updateLog
     */
    public void create(@Valid UpdateLog updateLog){
        //还差一个用户ID需要设置


        UpdateLog update = new UpdateLog();
        BeanUtils.copyProperties(updateLog,update);
        this.updateLogRepository.save(update);

    }

    /**
     * 删除某个项目的日志
     * @param id
     */
    public void delete(@NotNull long id){

        List<UpdateLog> list = this.updateLogRepository.findAllByIdAndIsDelete(id,0);
        if (list.size() != 1) {
            throw new WebException(Code.ENTITY_NOT_EXISTS);
        }
        UpdateLog updateLog = list.get(0);
        updateLog.setIsDelete(1);
        this.updateLogRepository.save(updateLog);
    }


}
