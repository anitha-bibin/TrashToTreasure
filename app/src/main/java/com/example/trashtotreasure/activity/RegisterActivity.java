package com.example.trashtotreasure.activity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;
import com.example.trashtotreasure.pojo.LoginRequest;
import com.example.trashtotreasure.pojo.LoginResponse;
import com.example.trashtotreasure.pojo.RegisterRequest;
import com.example.trashtotreasure.ws.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = findViewById(R.id.btn_register);

        final EditText etRegUname = findViewById(R.id.etreguname);
        final EditText etRegPhone = findViewById(R.id.etregphone);
        final EditText etRegEmail = findViewById(R.id.etregemail);
        final EditText etRegPass = findViewById(R.id.etregpass);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etRegUname.getText().toString();
                //   getText() returns "editable" type value. tostring() converts it into string.
                String userphone = etRegPhone.getText().toString();
                String useremail = etRegEmail.getText().toString();
                String userpass = etRegPass.getText().toString();

                RegisterRequest registerRequest = new RegisterRequest();
                /*registerRequest.setfName(userfname);
                registerRequest.setlName(userlname);
                registerRequest.setfName(userphone);
                registerRequest.setfName(useremail);
                registerRequest.setpass(userpass);*/

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.48.35/trashtotreasure")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service=retrofit.create(APIService.class);
                    /*Call<LoginResponse.enqueue (new Callback<LoginResponse>(){

                }*/
            }

        });

    }

    public void signInLinkClick(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
