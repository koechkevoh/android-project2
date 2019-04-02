package com.example.foodapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodapp.model.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    EditText editPhone,editPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPassword = (EditText)findViewById(R.id.edtPassword);
        editPhone = (EditText)findViewById(R.id.edtPhone);
        btnSignIn = (Button)findViewById(R.id.btsignin);


        // init firebase

        FirebaseDatabase database = FirebaseDatabase.getInstance();
       final DatabaseReference table_user = database.getReference("user");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog myDialog = new ProgressDialog(SignIn.this);
                myDialog.setMessage("Please Waiting...");
                myDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(editPhone.getText().toString()).exists()) {
                            myDialog.dismiss();
                            //get user information

                            user user = dataSnapshot.child(editPhone.getText().toString()).getValue(user.class);
                            if (user.getPassword().equals(editPassword.getText().toString())) {

                                Toast.makeText(SignIn.this, "Sign in is Successfully", Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(SignIn.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}