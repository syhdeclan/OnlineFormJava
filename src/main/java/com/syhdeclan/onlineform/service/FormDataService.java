package com.syhdeclan.onlineform.service;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.entity.Form;
import com.syhdeclan.onlineform.entity.FormData;
import com.syhdeclan.onlineform.repository.FormDataRepository;
import com.syhdeclan.onlineform.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author
 */
@Service
@Validated
public class FormDataService {

    @Autowired
    private FormDataRepository formDataRepository;

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private FormService formService;

    public List getAllData(@NotBlank String code){
        //先找到表单ID
        Long id = this.formService.getIdByCode(code);
        //然后通过ID找到相关的所有数据
        return this.formDataRepository.findAllByFormIdAndIsDeleteOrderByCreatedAtDesc(id,0);
    }

    @Transactional(rollbackOn = Exception.class)
    public void fillAForm(@Valid FormData formData,@NotBlank String code){
        //存入一条填写数据
        List<Form> list = this.formService.getByCode(code);
        if (list.size() != 1){
            throw new WebException(Code.ENTITY_NOT_EXISTS);
        }
        Form form = list.get(0);
        formData.setFormId(form.getId());
        //暂时没有用户信息
        formData.setAuthorId(0);
        formData.setAuthorName("Guest");
        this.formDataRepository.save(formData);

        //再重调表单填写总数
        //!!!!!!!!!!!!!!!!!!!!!并发！！！！！！！！！！！！！！！！
        form.setCount(form.getCount()+1);
        this.formRepository.save(form);

    }

}
