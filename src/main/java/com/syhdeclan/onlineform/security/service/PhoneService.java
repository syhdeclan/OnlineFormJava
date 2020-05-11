package com.syhdeclan.onlineform.security.service;

import com.syhdeclan.onlineform.security.entity.JwtUser;
import com.syhdeclan.onlineform.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shenyvhao
 * @program onlineform
 * @description
 * @create 2020-05-11 00
 **/

@Service
public class PhoneService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<JwtUser> jwtUserList = this.userRepository.findByPhoneAndIsDelete(username,0);
        if (jwtUserList.size() != 1) {
            throw new UsernameNotFoundException("手机号不存在");
        }
        JwtUser jwtUser = jwtUserList.get(0);
        if (!jwtUser.isEnabled()) {
            throw new UsernameNotFoundException("用户未激活");
        }
        //返回的这个对象是要干嘛用的
        return new JwtUser(jwtUser.getId(), jwtUser.getUsername(), jwtUser.getPassword(), jwtUser.getAvatarId(), jwtUser.getEmail(), jwtUser.getEnabled(), jwtUser.getPhone(), jwtUser.getCreateTime(), jwtUser.getUpdateTime(), jwtUser.getSex(),jwtUser.getIsDelete());
    }

}
