package com.project.DuAnTotNghiep.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
class User {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role; // e.g., "ADMIN", "CUSTOMER", "STAFF"

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}