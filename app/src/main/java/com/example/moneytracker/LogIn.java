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

public class LogIn extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        dataBaseHelper = new DataBaseHelper(this);
        Button Login_btn = findViewById(R.id.button2);
        Button Back_btn = findViewById(R.id.button);
        EditText email = findViewById(R.id.Email_Edit_Text);
        EditText password = findViewById(R.id.Password_edit_text);


        Back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_home_intent = new Intent(LogIn.this, MainActivity.class);
                startActivity(back_home_intent);
            }
        });
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Valid_email = email.getText().toString();
                String Valid_password = password.getText().toString();

                if(Valid_email.equals("")||Valid_password.equals("")){
                    Toast.makeText(getApplicationContext(),"All field needed to be filled!!", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkUser = dataBaseHelper.checkEmailPassword(Valid_email, Valid_password);
                    if(checkUser == true){
                        Toast.makeText(getApplicationContext(),"Login Success!!", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Login Fail!!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}