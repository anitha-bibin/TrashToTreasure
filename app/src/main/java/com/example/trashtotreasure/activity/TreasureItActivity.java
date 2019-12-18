package com.example.trashtotreasure.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;

public class TreasureItActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_treasureit);

        Button btnRegister = findViewById(R.id.btn_treasure);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TreasureItActivity.this, "Message sent", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

