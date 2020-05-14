package com.example.assigntest.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.assigntest.R;
import com.example.assigntest.database.model.Student;
import com.example.assigntest.adapters.StudentsAdapter;
import com.example.assigntest.utils.Utils;
import com.example.assigntest.viewmodels.StudentListViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    StudentListViewModel studentListViewModel;
    private RecyclerView recyclerView;
    List<Student> users = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview_students);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        final StudentsAdapter studentsAdapter = new StudentsAdapter();


        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "listdetails.json");
        Log.i("data", jsonFileString);

        Gson gson = new Gson();

        Type listUserType = new TypeToken<List<Student>>() {
        }.getType();


        users = gson.fromJson(jsonFileString, listUserType);

        recyclerView.setAdapter(studentsAdapter);
        studentListViewModel = ViewModelProviders.of(this).get(StudentListViewModel.class);

        studentListViewModel.deleteStudents();

        for (int i = 0; i < users.size(); i++) {

            studentListViewModel.addStudents(new Student(users.get(i).getName(), users.get(i).getRollNumber(), users.get(i).getAge(), users.get(i).getStandard()));
        }
        // observe for notes data changes

        studentListViewModel.getAllNotes().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> students) {
                //add students to adapter
                Log.e("studentlist", String.valueOf(students.size()));
                studentsAdapter.addStudents(students);
            }
        });


    }
}