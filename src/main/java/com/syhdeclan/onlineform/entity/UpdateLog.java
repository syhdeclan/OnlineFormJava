package com.syhdeclan.onlineform.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author shenyvhao
 * @program OnlineForm
 * @description
 * @create 2020-01-11 21
 **/

@Entity
@Table(name = "update_log")
@DynamicUpdate
@DynamicInsert
@Data
public class UpdateLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long projectId;

    private String english;

    private String version;

    private String detail;

    private String manager;

    @CreationTimestamp
    private Date createAt;

    @UpdateTimestamp
    private Date updateAt;

    private Integer isDelete;

}
