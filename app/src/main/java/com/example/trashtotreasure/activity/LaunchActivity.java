package com.example.trashtotreasure.activity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.CredentialProtectedWhileLockedViolation;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;

public class LaunchActivity extends AppCompatActivity{
    protected void onCreate(@Nullable Bundle x){

        super.onCreate(x);
        setContentView(R.layout.activity_launch);

    }

    public void homeClick(View view) {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);

    }

}
