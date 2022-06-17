package com.example.CourseApp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;




public class CoursesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter coursesAdapter;
    private RecyclerView.LayoutManager layoutManager;

    ArrayList<Courses> courses = new ArrayList<Courses>(
            Arrays.asList(
                           new Courses("Java", 20, 20),
                           new Courses("javaScript", 1, 1),
                           new Courses("PHP", 15, 15),
                           new Courses("JSP", 10, 10),
                           new Courses("NodeJS", 10, 20),
                           new Courses("IOS Programming", 15, 15)
                         )
    );



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_courses_layout, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        coursesAdapter = new CoursesAdapter(courses,getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(coursesAdapter);

        return root;
    }
}