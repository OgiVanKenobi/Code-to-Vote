package com.example.android.codetovote.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.codetovote.R;
import com.example.android.codetovote.domain.User;
import com.example.android.codetovote.retrofit.RetrofitClient;
import com.example.android.codetovote.retrofit.UserAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ImageView add_questionIcon;
    private CardView problem1Buton, problem2Buton, problem3Buton, problem4Buton, problem5Buton;
    ProgressDialog progressDoalog;
    private static final String BASE_URL_USER = "https://simplifiedcoding.net/demos/marvel/";
    //private static final String BASE_URL_USER = "http://localhost:9006/user/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_questionIcon = findViewById(R.id.add_question);
        problem1Buton = findViewById(R.id.Problem1Button);
        problem2Buton = findViewById(R.id.Problem2Button);
        problem3Buton = findViewById(R.id.Problem3Button);
        problem4Buton = findViewById(R.id.Problem4Button);
        problem5Buton = findViewById(R.id.Problem5Button);


        add_questionIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

        problem1Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Problem1Activity.class);
                startActivity(intent);

            }
        });

        problem2Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Problem2Activity.class);
                startActivity(intent);

            }
        });

        problem3Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Problem3Activity.class);
                startActivity(intent);

            }
        });

        problem4Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Problem4Activity.class);
                startActivity(intent);

            }
        });

        problem5Buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Problem5Activity.class);
                startActivity(intent);

            }
        });

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        UserAPI userApi = RetrofitClient.getRetrofitInstance().create(UserAPI.class);


        Call<List<User>>  call = userApi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressDoalog.dismiss();
                Log.d("response", response.toString());
                List<User> usersList = response.body();
                for(User u : usersList){
                    Log.d("id", u.getId().toString());
                    Log.d("username", u.getUsername());
                    Log.d("password", u.getPassword());
                }
                Toast.makeText(getApplicationContext(), "Navodno je uspesno!!!!!! AAAA", Toast.LENGTH_LONG);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressDoalog.dismiss();
                Log.d("ERROR", t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
            }
        });


    }
}
