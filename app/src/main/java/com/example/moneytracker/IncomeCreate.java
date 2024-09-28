package com.example.moneytracker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IncomeCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_create);

        ImageButton back_btn = findViewById(R.id.btnBack);
        String [] cardSpinner = new String[]{"item1","item2", "item3"};
        Spinner cS = findViewById(R.id.cardCreateIncome);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cardSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cS.setAdapter(adapter);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IncomeCreate.this, HomePage.class);
                startActivity(i);
            }

        });
    }

}
