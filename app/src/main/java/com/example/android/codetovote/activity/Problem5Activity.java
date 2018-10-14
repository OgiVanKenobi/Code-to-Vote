package com.example.android.codetovote.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.codetovote.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Problem5Activity extends Activity {

    private TextView link;
    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem5);

        link = findViewById(R.id.P5TextView9);
        imageView1 = findViewById(R.id.skupstina1);
        imageView2 = findViewById(R.id.skupstina2);


        imageView1.setAdjustViewBounds(true);
        imageView2.setAdjustViewBounds(true);

        PhotoViewAttacher photoViewAttacher1 = new PhotoViewAttacher(imageView1);
        PhotoViewAttacher photoViewAttacher2 = new PhotoViewAttacher(imageView2);

        photoViewAttacher1.update();
        photoViewAttacher2.update();

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.parlament.gov.rs/%D0%BD%D0%B0%D1%80%D0%BE%D0%B4%D0%BD%D0%B0-%D1%81%D0%BA%D1%83%D0%BF%D1%88%D1%82%D0%B8%D0%BD%D0%B0/%D1%83%D0%BB%D0%BE%D0%B3%D0%B0-%D0%B8-%D0%BD%D0%B0%D1%87%D0%B8%D0%BD-%D1%80%D0%B0%D0%B4%D0%B0/%D0%BD%D0%B0%D0%B4%D0%BB%D0%B5%D0%B6%D0%BD%D0%BE%D1%81%D1%82.17.html";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
