package com.example.android.codetovote.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.android.codetovote.R;

public class PitanjaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pitanja);

    }
}
