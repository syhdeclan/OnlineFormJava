package com.syhdeclan.onlineform.service;

import com.syhdeclan.onlineform.repository.FormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormDataService {

    @Autowired
    private FormDataRepository formDataRepository;

    public List getAllData(){
        return this.formDataRepository.findAllByIsDeleteOrderByFormIdAsc(0);
    }

}
