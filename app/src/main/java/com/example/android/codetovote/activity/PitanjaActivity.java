package com.example.android.codetovote.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.example.android.codetovote.R;

public class PitanjaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pitanja);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("username");
        if (msg != null) {
            Toast.makeText(getApplicationContext(), "Korisnik " + msg + "uspešno ulogovan!", Toast.LENGTH_LONG).show();
        }

    }
}
