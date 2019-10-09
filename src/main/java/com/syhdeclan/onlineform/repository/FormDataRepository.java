package com.syhdeclan.onlineform.repository;

import com.syhdeclan.onlineform.entity.FormData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormDataRepository extends JpaRepository<FormData, Integer> {

    public List<FormData> findAllByIsDeleteOrderByFormIdAsc(int isDelete);

}
