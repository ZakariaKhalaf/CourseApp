package com.example.CourseApp;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder> {
    Context context;
    ArrayList<RegisteredStudents> courses;

    public StudentsAdapter(ArrayList<RegisteredStudents> registeredstudents, Context context) {
        this.courses = registeredstudents;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentsAdapter.StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.registered_students, null, false);
        StudentsAdapter.StudentsViewHolder studentsViewHolder = new StudentsAdapter.StudentsViewHolder(v);
        return studentsViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull StudentsViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        RegisteredStudents registeredstudents = this.courses.get(position);

        holder.courseName.setText(registeredstudents.getCourseName());
        holder.email.setText(registeredstudents.getEmail());
        holder.phone.setText(registeredstudents.getPhone() + "");
        holder.name.setText(registeredstudents.getName() + "");


    }
    @Override
    public int getItemCount() {
        return this.courses.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterList(ArrayList<RegisteredStudents> filteredList) {
        courses = filteredList;
        notifyDataSetChanged();
    }

    class StudentsViewHolder extends RecyclerView.ViewHolder {
        TextView courseName;
        TextView name;
        TextView phone;
        TextView email;

        StudentsViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.reg_name);
            courseName = itemView.findViewById(R.id.reg_course_name);
            phone = itemView.findViewById(R.id.reg_phone);
            email = itemView.findViewById(R.id.reg_email);

        }
    }
}