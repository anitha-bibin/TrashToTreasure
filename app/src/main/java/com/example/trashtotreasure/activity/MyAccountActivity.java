package com.example.trashtotreasure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;

public class MyAccountActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_myaccount);

    }

    public void homeClick(View view) {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
    }
}
