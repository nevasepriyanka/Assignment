package com.example.assigntest.database.Dao;


import com.example.assigntest.database.model.Student;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentsDao {
    @Query("SELECT * FROM student")
    LiveData<List<Student>> getAllStudents();

    @Insert
    void insert(Student[] student);

    @Query("DELETE FROM student")
    void delete();

    @Update
    void update(Student student);
}
