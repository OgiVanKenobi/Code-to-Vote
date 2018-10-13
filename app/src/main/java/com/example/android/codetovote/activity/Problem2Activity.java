package com.example.android.codetovote.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.codetovote.R;

public class Problem2Activity extends Activity {


    private TextView mestoGlasanjaLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem2);

        mestoGlasanjaLink = findViewById(R.id.P2TextView2);

        mestoGlasanjaLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://birackispisak.mduls.gov.rs/javniportal";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
