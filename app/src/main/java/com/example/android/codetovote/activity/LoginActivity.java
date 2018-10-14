package com.example.android.codetovote.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.codetovote.R;
import com.example.android.codetovote.domain.User;
import com.example.android.codetovote.retrofit.RetrofitClient;
import com.example.android.codetovote.retrofit.UserAPI;

import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {

    private TextView registerLink;
    private CardView loginButton;
    EditText usernameInput, passwordInput;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("username");
        if (msg != null) {
            Toast.makeText(getApplicationContext(), "Korisnik " + msg + " uspešno registrovan!", Toast.LENGTH_LONG).show();
        }

        registerLink = findViewById(R.id.registerLink);
        loginButton = findViewById(R.id.loginButton);
        usernameInput = findViewById(R.id.editTextUsername);
        passwordInput = findViewById(R.id.editTextPassword);



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .9));

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();
                user.setUsername(username);
                user.setPassword(password);

                if(!username.isEmpty() && !password.isEmpty()){

                        UserAPI userApi = RetrofitClient.getRetrofitInstance().create(UserAPI.class);
                        Call<User> call = userApi.login(user);
                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if (response.code() == 200){
                                    Intent intent = new Intent(LoginActivity.this, PitanjaActivity.class);
                                    intent.putExtra("username", response.body().getUsername());
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(getApplicationContext(), "Pogrešan username ili lozinka!",Toast.LENGTH_LONG).show();
                                }

                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                Log.d("FAILUREE!!! NoooNoNoNNN", t.getMessage());
                            }

                        });

                }else{
                    Toast.makeText(getApplicationContext(), "Polja ne mogu biti prazna!",Toast.LENGTH_LONG).show();
                }





            }

        });
    }
}


