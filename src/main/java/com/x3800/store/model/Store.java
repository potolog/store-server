package com.x3800.store.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.x3800.store.serializer.JsonDateTimeSerializer;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", length = 50, updatable = false)
    private String store_id;

    // 상점코드
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "store")
//  @Column(length = 50, unique = true, nullable = false)
//  private String store_id;
//  private List<Menu> store_id;

    // 상점명
    @Column(length = 50, nullable = false)
    private String store_name;

    // 이메일
    @Column(length = 255)
    private String email;

    // 전화번호
    @Column(length = 255)
    private String telephone;

    // 메뉴
    @OneToMany(mappedBy = "store")
    private List<Menu> menus = new ArrayList<Menu>();

    // 사용여부
    @Column
    private int enabled;

    // 등록일시
    @Column
    private Date regist_datetime;

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /*

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    */

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    public Date getRegist_datetime() {
        return regist_datetime;
    }

    public void setRegist_datetime(Date regist_datetime) {
        this.regist_datetime = regist_datetime;
    }


    @PrePersist // Auto created date when it's created
    public void prePersist() {
        regist_datetime = new Date();
    }

    @Override
    public String toString() {
        return "Store{" +
        //      "id=" + id +
                ", store_id='" + store_id + '\'' +
                ", store_name='" + store_name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", enabled=" + enabled +
                ", regist_datetime=" + regist_datetime +
                '}';
    }

}
