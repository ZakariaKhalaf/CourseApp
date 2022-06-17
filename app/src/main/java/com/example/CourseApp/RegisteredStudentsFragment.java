package com.example.CourseApp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;


public class RegisteredStudentsFragment extends Fragment {


    private RecyclerView recyclerView;
    private StudentsAdapter regAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public RegisteredStudentsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View root = inflater.inflate(R.layout.fragmentregisteredrtudents_layout, container, false);


        recyclerView = root.findViewById(R.id.rv_fragment_registered_students);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        regAdapter = new StudentsAdapter(StudentsData.registeredStudents, getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(regAdapter);



        EditText editText = root.findViewById(R.id.search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                 filter(s.toString());
            }
        });


        return root;
    }

    private void filter(String text) {
        ArrayList<RegisteredStudents> filteredList = new ArrayList<>();

        for (RegisteredStudents item : StudentsData.registeredStudents) {
            if (item.getCourseName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        regAdapter.filterList(filteredList);
    }

}
