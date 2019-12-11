package com.example.trashtotreasure.activity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;
import com.example.trashtotreasure.pojo.LoginRequest;
import com.example.trashtotreasure.pojo.LoginResponse;
import com.example.trashtotreasure.ws.APIService;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login); //


            Button btnSignUp = findViewById(R.id.btn_login);
            final EditText eusername = findViewById(R.id.etloginuser);
            final EditText epass = findViewById(R.id.etloginpass);

            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = eusername.getText().toString();
                    String pass =epass.getText().toString();

                    LoginRequest loginRequest = new LoginRequest();
                 //   loginRequest.setName(user);
                 //   loginRequest.setpass(pass);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://192.168.48.35/trashtotreasure")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    APIService service=retrofit.create(APIService.class);
                   // Call<LoginResponse.enqueue(new Callback<LoginResponse>(){

                    }
                });
            }

    public void signUpLinkClick(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}
