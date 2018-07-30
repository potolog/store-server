package com.x3800.store.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.x3800.store.serializer.JsonDateTimeSerializer;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // 판매일시
    @Temporal(TemporalType.TIMESTAMP)
    private Date sale_datetime;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Column
    private double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    public Date getSale_datetime() {
        return sale_datetime;
    }

    public void setSale_datetime(Date sale_datetime) {
        this.sale_datetime = sale_datetime;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @PrePersist // Auto created date when it's created
    public void prePersist() {
        sale_datetime = new Date();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", sale_datetime=" + sale_datetime +
                ", store=" + store +
                ", menu=" + menu +
                ", price=" + price +
                '}';
    }
}
