package com.example.assigntest.database.model;



import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.PrimaryKey;

@Entity
public class Student   {

    public Student(String name, String rollNumber, String age, String standard) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.standard = standard;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "rollNumber")
    private String rollNumber;

    @ColumnInfo(name = "Age")
    private String age;

    @ColumnInfo(name = "standard")
    private String standard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}
