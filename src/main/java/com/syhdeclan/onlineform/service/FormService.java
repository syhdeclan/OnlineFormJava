package com.syhdeclan.onlineform.service;

import com.syhdeclan.onlineform.entity.Form;
import com.syhdeclan.onlineform.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author syh
 */

@Service
@Validated
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<Form> getByCode(@NotBlank String code){
        return this.formRepository.findFirstByCodeAndIsDelete(code,0);
    }

    public List<Form> getAll(){
        return this.formRepository.findAllByIsDelete(0);
    }

    public void create(@Valid Form form){
        this.formRepository.save(form);
    }

}
