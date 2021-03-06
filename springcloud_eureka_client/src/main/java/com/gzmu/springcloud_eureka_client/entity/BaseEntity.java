package com.gzmu.springcloud_eureka_client.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @className: BaseEntity(模型基类)
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午4:36 19-4-22
 * @modified:
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 是否启用
     */
    @Column(name = "is_enable")
    private Boolean isEnable = true;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "create_time", columnDefinition = "datetime not null default now() comment '创建时间'")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @LastModifiedDate
    @Column(name = "modify_time", columnDefinition = "datetime not null default now() comment '修改时间'")
    private LocalDateTime modifyTime;

    /**
     * 创建用户
     */
    @CreatedBy
    @Column(name = "create_user")
    private String createUser;

    /**
     * 修改用户
     */
    @LastModifiedBy
    @Column(name = "modify_user")
    private String modifyUser;
}
