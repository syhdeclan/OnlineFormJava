package com.syhdeclan.onlineform.security.service;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.security.entity.JwtUser;
import com.syhdeclan.onlineform.security.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description 主要提供用户验证的类
 * @create 2020-05-07 19
 **/

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<JwtUser> jwtUserList = this.userRepository.findByUsernameAndIsDelete(username,0);
        if (jwtUserList.size() != 1) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        JwtUser jwtUser = jwtUserList.get(0);
        if (!jwtUser.isEnabled()) {
            throw new UsernameNotFoundException("用户未激活");
        }
        //返回的这个对象是要干嘛用的
        return new JwtUser(jwtUser.getId(), jwtUser.getUsername(), jwtUser.getPassword(), jwtUser.getAvatarId(), jwtUser.getEmail(), jwtUser.getEnabled(), jwtUser.getPhone(), jwtUser.getCreateTime(), jwtUser.getUpdateTime(), jwtUser.getSex(),jwtUser.getIsDelete());
    }

    public JwtUser createUser(@Valid JwtUser user){
        JwtUser newUser = new JwtUser();
        BeanUtils.copyProperties(user,newUser);
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        return this.userRepository.save(newUser);
    }

    public boolean checkUsernameIsUsed(String username){
        return this.userRepository.findByUsernameAndIsDelete(username,0).size() == 1;
    }


    public boolean checkPhoneIsUsed(String phone){
        return this.userRepository.findByPhoneAndIsDelete(phone,0).size() == 1;
    }

    public boolean checkEmailIsUsed(String email){
        return this.userRepository.findByEmailAndIsDelete(email,0).size() == 1;
    }



}
