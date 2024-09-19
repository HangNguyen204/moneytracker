package com.example.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.StringReader;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText User_Name = findViewById(R.id.User_name_editText);
        EditText User_Email = findViewById(R.id.User_email_edit_text);
        EditText Password = findViewById(R.id.Password_edit_text);
        EditText Re_enterPassword = findViewById(R.id.re_enter_pass_text_edit);
        Button Back_btn = findViewById(R.id.Back_btn);
        Button Submit_btn = findViewById(R.id.Submit_btn);

        Back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent To_home_page = new Intent(SignUp.this, MainActivity.class);
                startActivity(To_home_page);
            }
        });
        Submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Vld_user_name = User_Name.getText().toString();
                String Vld_user_email = User_Email.getText().toString();
                String Vld_user_password = Password.getText().toString();
                String Vld_re_enter_password = Re_enterPassword.getText().toString();
                if (Vld_user_name.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Name is blank", Toast.LENGTH_SHORT).show();
                } else if (Vld_user_email.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Email is blank", Toast.LENGTH_SHORT).show();
                } else if (Vld_user_password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Password is blank", Toast.LENGTH_SHORT).show();
                } else if(Vld_re_enter_password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please confirm your password", Toast.LENGTH_SHORT).show();
                } else if (!Vld_user_password.equals(Vld_re_enter_password)){
                    Toast.makeText(getApplicationContext(),"Password not match", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}