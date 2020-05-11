package com.syhdeclan.onlineform.security.repository;

import com.syhdeclan.onlineform.security.entity.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<JwtUser,Long> {

    /**
     * 根据用户名获取用户
     * @return
     */
    List<JwtUser> findByUsernameAndIsDelete(String name, int isDelete);


    List<JwtUser> findByEmailAndIsDelete(String email, int isDelete);


    List<JwtUser> findByPhoneAndIsDelete(String phone, int isDelete);



}
