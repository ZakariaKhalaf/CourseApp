package com.example.CourseApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomnavigationview;
    private CoursesFragment coursesFragment;
    private RegisteredStudentsFragment registeredStudentsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coursesFragment = new CoursesFragment();
        registeredStudentsFragment = new RegisteredStudentsFragment() ;
        setFragment(coursesFragment);
        bottomnavigationview=findViewById(R.id.bottombar);
        bottomnavigationview.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.courses:
                        setFragment(coursesFragment);
                        return true;
                    case R.id.registeredstudents:
                        setFragment(registeredStudentsFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();
    }
}