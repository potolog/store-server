package com.x3800.store.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.x3800.store.serializer.JsonDateSerializer;
import com.x3800.store.serializer.JsonDateTimeSerializer;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // 사원코드
    @Column(length = 50, unique = true, nullable = false)
    private String employee_id;

    // 사원명
    @Column(length = 100, nullable = false)
    private String employee_name;

    // 입사일
    @Temporal(TemporalType.DATE)
    private Date employee_date;

    @Lob
    private String notes;

    // 사용여부
    @Column(name="enabled", columnDefinition = "tinyint default 1")
    private int enabled;

    // 등록일시
    @Temporal(TemporalType.TIMESTAMP)
    private Date regist_datetime;

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getEmployee_date() {
        return employee_date;
    }

    public void setEmployee_date(Date employee_date) {
        this.employee_date = employee_date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        employee_date = new Date();
        regist_datetime = new Date();
        enabled = 1;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employee_id='" + employee_id + '\'' +
                ", employee_name='" + employee_name + '\'' +
                ", employee_date=" + employee_date +
                ", notes=" + notes +
                ", enabled=" + enabled +
                ", regist_datetime=" + regist_datetime +
                '}';
    }
}
