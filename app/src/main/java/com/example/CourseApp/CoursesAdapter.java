package com.example.CourseApp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CoursesViewHolder> {

    ArrayList<Courses> courses;
    Context context;

    public CoursesAdapter(ArrayList<Courses> course, Context context) {
        this.courses = course;
        this.context = context;
    }


    public static class CoursesViewHolder extends RecyclerView.ViewHolder {

        TextView courseName;
        TextView targetNumber;
        TextView remainingChairs;

        public CoursesViewHolder(View itemView) {
            super(itemView);

            targetNumber = itemView.findViewById(R.id.target_number);
            courseName = itemView.findViewById(R.id.course_name);
            remainingChairs = itemView.findViewById(R.id.remaining_chairs);

        }
    }



    @NonNull
    @Override
    public CoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_courses_layout, null, false);
        CoursesViewHolder coursesviewholder = new CoursesViewHolder(root);
        return coursesviewholder;
    }
    @Override
    public void onBindViewHolder(@NonNull final CoursesViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Courses course = this.courses.get(position);
        holder.courseName.setText(course.getName());
        holder.targetNumber.setText(course.getTargetNumber() + "");
        holder.remainingChairs.setText(course.getRemainingChairs() + "");

        CoursesViewHolder coursesviewholder = holder;

        coursesviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CoursesAdapter.this.courses.get(position).getRemainingChairs() > 0){
                    RegistrationDialog registrationDialog = new RegistrationDialog(CoursesAdapter.this.courses.get(position).getName(), CoursesAdapter.this.courses, position, holder, context);
                    FragmentActivity activity = (FragmentActivity)(context);
                    FragmentManager fm = activity.getSupportFragmentManager();
                    registrationDialog.show(fm,"registrationDialog");
                }
                else {
                    Toast.makeText(context,"Register is full",Toast.LENGTH_SHORT).show();
                }
            }
        });
        }

    @Override
    public int getItemCount() {
        return this.courses.size();
    }


}