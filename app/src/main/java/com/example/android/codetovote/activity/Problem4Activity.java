package com.example.android.codetovote.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.codetovote.R;

public class Problem4Activity extends Activity {


    private TextView link1, link2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem4);


        link1 = findViewById(R.id.P4TextView5);
        link2 = findViewById(R.id.P4TextView6);


        link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.rik.parlament.gov.rs/doc/dokumenta/zakoni/ZoINP/zakon%20o%20izboru%20narodnih%20poslanika.pdf";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        link2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.parlament.gov.rs/upload/archive/files/lat/pdf/predlozi_zakona/3533-13Lat.pdf";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
