package com.syhdeclan.onlineform.service;

import com.syhdeclan.onlineform.common.Code;
import com.syhdeclan.onlineform.common.WebException;
import com.syhdeclan.onlineform.entity.Form;
import com.syhdeclan.onlineform.repository.FormRepository;
import com.syhdeclan.onlineform.security.entity.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Random;

/**
 * @Author syh
 */

@Service
@Validated
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<Form> getByCode(@NotBlank String code) {
        return this.formRepository.findFirstByCodeAndIsDelete(code, 0);
    }

    /**
     * 向外提供获取ID的接口
     * @param code
     * @return
     */
    public long getIdByCode(@NotBlank String code) {
        List<Form> list = this.formRepository.findFirstByCodeAndIsDelete(code, 0);
        if (list.size() == 0) {
            throw new WebException(Code.ENTITY_NOT_EXISTS);
        }
        return list.get(0).getId();
    }

    public List<Form> getAll() {
        //分页相关以后需要考虑可能
        return this.formRepository.findAllByIsDelete(0);
    }

    public void create(@Valid Form form) {

        //这里需要来一个判定Code是否重复的步骤吧，需要考虑一下
        form.setCode(getRandomString(6).toUpperCase());
        //用户信息相关
        JwtUser user = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        form.setAuthorId(user.getId());
        form.setAuthorName(user.getUsername());
        this.formRepository.save(form);
    }


    /**
     * 获取指定长度随机字符串
     * 没有做排除重复的处理，目前是默认一定不会有重复的
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }

}
