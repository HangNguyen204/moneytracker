package com.example.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Login_btn = findViewById(R.id.Login_Btn);
        Button Sign_up_btn = findViewById(R.id.Sign_Up_btn);

        Sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent To_Sign_Up = new  Intent(MainActivity.this , SignUp.class);
                startActivity(To_Sign_Up);
            }
        });
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent To_Log_In = new  Intent(MainActivity.this , LogIn.class);
                startActivity(To_Log_In);
            }
        });
    }
}