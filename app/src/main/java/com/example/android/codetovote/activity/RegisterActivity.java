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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends Activity {

    private TextView backDugmeNaLogin;
    CardView registerButton;
    EditText usernameInput, passwordInput, confirmPasswordInput;
    String username, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);

        backDugmeNaLogin = findViewById(R.id.loginLink);
        registerButton = findViewById(R.id.registerButton);
        usernameInput = findViewById(R.id.editTextUsername);
        passwordInput = findViewById(R.id.editTextPassword);
        confirmPasswordInput = findViewById(R.id.editTextConfirmPassword);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width *.9), (int) (height * .9));

        backDugmeNaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User();
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();
                confirmPassword = confirmPasswordInput.getText().toString();


                if(!username.isEmpty() && !password.isEmpty()){
                    if(password.equals(confirmPassword)) {
                        user.setUsername(username);
                        user.setPassword(password);
                        UserAPI userApi = RetrofitClient.getRetrofitInstance().create(UserAPI.class);
                        Call<User> call = userApi.register(user);
                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if (response.code() == 200) {
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    intent.putExtra("username", response.body().getUsername());
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Korisničko ime već postoji!", Toast.LENGTH_LONG).show();
                                }

                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                Log.d("FAILUREE!!! NoooNoNoNNN", t.getMessage());
                            }

                        });
                    }else{
                        Toast.makeText(getApplicationContext(), "Lozinke moraju da se podudaraju!",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Polja ne mogu biti prazna!",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
