package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;
    EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=(Button)findViewById(R.id.bt1);
        button2=(Button)findViewById(R.id.bt2);
        editText1=(EditText)findViewById(R.id.edt1);
        editText2 =(EditText)findViewById(R.id.edt2);
        buttonOne();
        buttonTwo();
    }

    public void buttonOne(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText1.getText().toString().isEmpty() &&!editText2.getText().toString().isEmpty()){
                    int num1=Integer.parseInt(editText1.getText().toString());
                    int num2=Integer.parseInt(editText2.getText().toString());
                    int sum = num1+num2;

                    Toast.makeText(MainActivity.this, "sum is"+sum, Toast.LENGTH_SHORT).show();

                }
                else{

                    Toast.makeText(MainActivity.this, "please enter num 1", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void buttonTwo(){
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText1.getText().toString().isEmpty() &&!editText2.getText().toString().isEmpty()){
                    int num1=Integer.parseInt(editText1.getText().toString());
                    int num2=Integer.parseInt(editText2.getText().toString());
                    int sub = num1+num2;

                    Toast.makeText(MainActivity.this, "sum is"+sub, Toast.LENGTH_SHORT).show();

                }
                else{

                    Toast.makeText(MainActivity.this, "please enter num ", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
