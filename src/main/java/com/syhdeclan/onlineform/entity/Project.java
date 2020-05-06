package com.syhdeclan.onlineform.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-01-11 21
 **/

@Entity
@Table(name = "project")
@DynamicInsert
@DynamicUpdate
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @NotBlank
    private String name;

    private String intro;

    @NotBlank
    private String manager;

    private String member;

    private String deployment;

    private String api;

    @CreationTimestamp
    private Date createAt;

    @UpdateTimestamp
    private Date updateAt;

    private Integer isDelete;

    private String status;

    private String english;

}
