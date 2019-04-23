package com.gzmu.springcloud_eureka_client.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hero")
public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "appellation", nullable = false, unique = true)
    private String appellation;
    @Column(name = "sex", nullable = false)
    private Boolean sex;
    @Column(name = "position", nullable = false)
    private String position;
    @Column(name = "profession", nullable = false)
    private String profession;
    @Column(name = "evaluate", nullable = false)
    private String evaluate;
    @Column(name = "remark", nullable = false)
    private String remark;

    /**
     * toString方法
     *
     * @return
     */
    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appellation='" + appellation + '\'' +
                ", sex=" + sex +
                ", position='" + position + '\'' +
                ", profession='" + profession + '\'' +
                ", evaluate='" + evaluate + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
