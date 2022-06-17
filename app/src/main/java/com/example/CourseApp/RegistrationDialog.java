package com.example.CourseApp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayList;


public class RegistrationDialog extends DialogFragment {

    final String text;
    final ArrayList<Courses> arrayList;
    final int posistion;
    final CoursesAdapter.CoursesViewHolder holder;
    final Context context;

    public RegistrationDialog(String text, ArrayList<Courses> arrayList, int pos, CoursesAdapter.CoursesViewHolder holder, Context context){
            this.text = text;
            this.arrayList = arrayList;
            this.posistion = pos;
            this.holder = holder;
            this.context = context;
        }


    public View onCreateView(LayoutInflater inflater , @NonNull ViewGroup container, @NonNull Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dialog_layout,container,false);

        final TextView textView = view.findViewById(R.id.rg);
        textView.setText(" Registration for " + text + " Course");

        final EditText name = view.findViewById(R.id.name);
        final EditText phone = view.findViewById(R.id.phone);
        final EditText email = view.findViewById(R.id.email);
        final Button save = view.findViewById(R.id.save_btn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arrayList.get(posistion).getRemainingChairs() > 0){

                    if (name.getText().toString().equals("") || phone.getText().toString().equals("") || email.getText().toString().equals("")){
                        Toast.makeText(context,"Field is empty!",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        StudentsData.registeredStudents.add(new RegisteredStudents(email.getText().toString(),text, name.getText().toString(), phone.getText().toString()));
                        int remaining_chairs = arrayList.get(posistion).getRemainingChairs();
                        arrayList.get(posistion).setRemainingChairs(remaining_chairs - 1);
                        holder.remainingChairs.setText(arrayList.get(posistion).getRemainingChairs() + "");
                        Toast.makeText(context,"Register is done",Toast.LENGTH_SHORT).show();
                        RegistrationDialog.this.dismiss();
                    }
                }
                else{
                    Toast.makeText(context,"Register is full",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
        }
    }
