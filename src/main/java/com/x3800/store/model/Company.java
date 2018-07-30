package com.x3800.store.model;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(updatable = false)
    private Long id;

    // 회사명
    @Column(length = 100, nullable = false)
    private String company_name;




}
