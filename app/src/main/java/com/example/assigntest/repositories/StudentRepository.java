package com.example.assigntest.repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.assigntest.database.AppDatabase;

import com.example.assigntest.database.Dao.StudentsDao;
import com.example.assigntest.database.model.Student;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class StudentRepository {
    //Live Data of List of all students
    private LiveData<List<Student>> mAllStudents;
    //Define student Dao
    StudentsDao mStudentDao;

    public StudentRepository(@NonNull Application application) {
        AppDatabase appDatabase = AppDatabase.getDatabase(application);
        //init student Dao
        mStudentDao = appDatabase.studentsDao();
        //get all students
        mAllStudents = mStudentDao.getAllStudents();
    }
    //method to get all students
    public LiveData<List<Student>> getAllNotes() {
        return mAllStudents;
    }

    //method to add students
    public void addStudents(Student student) {
        new AddNote().execute(student);
    }

    //Async task to add student
    public class AddNote extends AsyncTask<Student, Void, Void> {
        @Override
        protected Void doInBackground(Student... student) {
            mStudentDao.insert(student);
            return null;
        }
    }

    public void deleteStudents() {
        new DeleteNote().execute();
    }

    //Async task to delete student
    public class DeleteNote extends AsyncTask<Student, Void, Void> {
        @Override
        protected Void doInBackground(Student... student) {
            mStudentDao.delete();
            return null;
        }
    }
}
