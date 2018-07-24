package com.x3800.store.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.x3800.store.serializer.JsonDateTimeSerializer;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // 메뉴코드
    @Column(length = 50, unique = true, nullable = false)
    private String menu_id;

    // 메뉴명
    @Column(length = 100, nullable = false)
    private String menu_name;

    // 가격
    @Column
    private Double price;

    @ManyToOne(targetEntity=Store.class, fetch=FetchType.LAZY)
    @JoinColumn(name="store_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
//  @ForeignKey(name = "fk_store_menu")
    private Store store;

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

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
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
        return "Menu{" +
                "id=" + id +
                ", menu_id='" + menu_id + '\'' +
                ", menu_name='" + menu_name + '\'' +
                ", price=" + price +
                ", store=" + store.toString() +
                ", enabled=" + enabled +
                ", regist_datetime=" + regist_datetime +
                '}';
    }

    */
}
