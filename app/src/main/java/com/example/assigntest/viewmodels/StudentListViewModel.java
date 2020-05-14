package com.example.assigntest.viewmodels;

import android.app.Application;

import com.example.assigntest.database.model.Student;
import com.example.assigntest.repositories.StudentRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class StudentListViewModel extends AndroidViewModel {
    private LiveData<List<Student>> mAllStudents;
    StudentRepository mstudentsRepository;

    public StudentListViewModel(@NonNull Application application) {
        super(application);
        mstudentsRepository = new StudentRepository(application);
        mAllStudents = mstudentsRepository.getAllNotes();


    }
    public LiveData<List<Student>> getAllNotes() {
        return mAllStudents;
    }

    public void addStudents(Student student) {
        mstudentsRepository.addStudents(student);
    }

    public void deleteStudents() {
        mstudentsRepository.deleteStudents();
    }

}
