package com.intern_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int stuId;
    private  String stuName;
    private int stuAge;
}
