package com.example.assigntest.adapters;



import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assigntest.R;
import com.example.assigntest.database.model.Student;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsAdapter extends RecyclerView.Adapter {


  List<Student> students = new ArrayList<>();



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Get layout inflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //Inflate layout
        View row = inflater.inflate(R.layout.students_item, parent, false);
        //return notes holder and pass row inside
        return new StudentHolder(row);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Student student = students.get(position);
        StudentHolder studentHolder = (StudentHolder) holder;
        studentHolder.name.setText("Name : "+student.getName());
        studentHolder.rollnumber.setText("Roll Number : "+student.getRollNumber());
        studentHolder.age.setText("Age : "+student.getAge());
        studentHolder.standard.setText("Standard : "+student.getStandard());





















    }

    @Override
    public int getItemCount() {
        return students.size();
    }

   public class StudentHolder extends RecyclerView.ViewHolder  {

        TextView name, age, rollnumber, standard;

        public StudentHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            rollnumber = itemView.findViewById(R.id.rollnumber);
            standard = itemView.findViewById(R.id.standard);



        }


    }
    public void addStudents(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }
}