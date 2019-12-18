package com.example.trashtotreasure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trashtotreasure.R;
import com.example.trashtotreasure.pojo.RegisterRequest;
import com.example.trashtotreasure.pojo.RegisterResponse;
import com.example.trashtotreasure.ws.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etRegUname = findViewById(R.id.etreguname);
        final EditText etRegPhone = findViewById(R.id.etregphone);
        final EditText etRegEmail = findViewById(R.id.etregemail);
        final EditText etRegPass = findViewById(R.id.etregpass);
        final EditText etRegAddr = findViewById(R.id.etregaddr);

        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   getText() returns "editable" type value. tostring() converts it into string.
                String username = etRegUname.getText().toString();
                String userphone = etRegPhone.getText().toString();
                String useremail = etRegEmail.getText().toString();
                String userpass = etRegPass.getText().toString();
                String useraddress = etRegAddr.getText().toString();

                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setUsername(username);
                registerRequest.setPassword(userpass);
                registerRequest.setEmail(useremail);
                registerRequest.setMobile(userphone);
                registerRequest.setAddress(useraddress);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://backtowork.icfoss.qleapbs.com/trash2treasure/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);
                Call<RegisterResponse> registerResponse = service.Register(registerRequest);
                registerResponse.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.body() != null) {
                            if (response.body().getStatus()) {
                                Toast.makeText(RegisterActivity.this, "Registration successful" , Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MyAccountActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Response Body Status is false", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "Response Body is null", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Connection failed" + t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void signInLinkClick(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
