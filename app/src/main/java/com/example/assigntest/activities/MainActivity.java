package com.example.assigntest.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.assigntest.R;
import com.example.assigntest.database.model.Student;
import com.example.assigntest.adapters.StudentsAdapter;
import com.example.assigntest.databinding.ActivityMainBinding;
import com.example.assigntest.utils.Utils;
import com.example.assigntest.viewmodels.StudentListViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StudentListViewModel studentListViewModel;
private StudentsAdapter studentsAdapter;
    private ArrayList<Student> students;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "listdetails.json");
        Log.i("data", jsonFileString);
        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<Student>>() {
        }.getType();
        students = gson.fromJson(jsonFileString, listUserType);

        // bind RecyclerView
        RecyclerView recyclerView = activityMainBinding.recyclerviewstudents;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);




        studentListViewModel = ViewModelProviders.of(this).get(StudentListViewModel.class);
        studentListViewModel.deleteStudents();
        studentsAdapter = new StudentsAdapter();

        recyclerView.setAdapter(studentsAdapter);


        for (int i = 0; i < students.size(); i++) {

            studentListViewModel.addStudents(new Student(students.get(i).getName(), students.get(i).getRollNumber(), students.get(i).getAge(), students.get(i).getStandard()));
        }
        // observe for notes data changes

        studentListViewModel.getAllNotes().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> students) {
                //add students to adapter
                Log.e("studentlist", String.valueOf(students.size()));

                studentsAdapter.setStudentList((ArrayList<Student>) students);
            }
        });


    }
}