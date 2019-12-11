package com.example.trashtotreasure.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;

public class PreviewItemActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle x) {
        super.onCreate(x);
        setContentView(R.layout.activity_previewitem);
        //Get the bundle
        Bundle bundle = getIntent().getExtras();
//Extract the data…
        String stuff = bundle.getString("imageid");

        Toast.makeText(PreviewItemActivity.this, "Toast displayed. Selected image id "+stuff , Toast.LENGTH_SHORT).show();
    }
}
