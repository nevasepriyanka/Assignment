package com.example.assigntest.adapters;





import android.view.LayoutInflater;

import android.view.ViewGroup;
import com.example.assigntest.R;
import com.example.assigntest.database.model.Student;
import com.example.assigntest.databinding.StudentsItemBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsAdapter extends RecyclerView.Adapter <StudentsAdapter.StudentViewHolder> {

    private ArrayList<Student> students;


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        StudentsItemBinding studentsItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.students_item, viewGroup, false);
        return new StudentViewHolder(studentsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        Student  student = students.get(i);
        studentViewHolder.studentsItemBinding.setStudent(student);
    }

    @Override
    public int getItemCount() {
        if (students != null) {
            return students.size();
        } else {
            return 0;
        }
    }

    public void setStudentList(ArrayList<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }



    class StudentViewHolder extends RecyclerView.ViewHolder  {

       private StudentsItemBinding studentsItemBinding;

       public StudentViewHolder(@NonNull StudentsItemBinding studentsItemBinding) {
           super(studentsItemBinding.getRoot());

           this.studentsItemBinding = studentsItemBinding;
       }


    }

}