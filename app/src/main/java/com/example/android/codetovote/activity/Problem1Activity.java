package com.example.android.codetovote.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.codetovote.R;


public class Problem1Activity extends Activity {


    private TextView pdfLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem1);


        TextView pdfLink = findViewById(R.id.P1TextView2);

        pdfLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.rik.parlament.gov.rs/doc/dokumenta/zakoni/ZoJBS/zakon%20o%20jedinstvenom%20birackom%20spisku.pdf";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
