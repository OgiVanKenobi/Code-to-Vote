package com.example.android.codetovote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import com.example.android.codetovote.activity.LoginActivity;
import com.example.android.codetovote.activity.Problem1Activity;
import com.example.android.codetovote.activity.Problem2Activity;
import com.example.android.codetovote.activity.Problem3Activity;
import com.example.android.codetovote.activity.Problem4Activity;
import com.example.android.codetovote.activity.Problem5Activity;

public class MainActivity extends AppCompatActivity {


    private ImageView add_questionIcon;
    private CardView problem1Buton, problem2Buton, problem3Buton, problem4Buton, problem5Buton;


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


    }
}
