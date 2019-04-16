package com.example.appfood;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button signUp,signIn;
    TextView txtSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn= (Button)findViewById(R.id.btsignIn);
        signUp = (Button)findViewById(R.id.btsignUp);
        txtSlogan = (TextView)findViewById(R.id.slogan);
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/NABILA.TTF");
        txtSlogan.setTypeface(face);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signup = new Intent(MainActivity.this, com.example.appfood.SignUp.class);
                startActivity(Signup);

            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signin = new Intent(MainActivity.this, com.example.appfood.SignIn.class);
                startActivity(Signin);
            }
        });

    }

}
/*app:headerLayout="@layout/nav_header_home"
        android:background="@color/overlayBackground"
        app:itemTextColor="@android:color/white"
        app:itemIconTint="@android:color/white"
        app:menu="@menu/activity_home_drawer" */