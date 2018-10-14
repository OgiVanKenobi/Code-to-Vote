package com.example.android.codetovote.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.codetovote.R;

public class PitanjaActivity extends Activity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_prijava_problema);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("username");
        if (msg != null) {
            Toast.makeText(getApplicationContext(), "Korisnik " + msg + " uspešno ulogovan!", Toast.LENGTH_LONG).show();
        }

        spinner = findViewById(R.id.spinner);
        String[] items = new String[]{"Nisam u mogućnosti da glasam u mestu prebivališta",
                "Nisam siguran gde je moje biračko mesto", "Nemam za koga da glasam", "matram da je glasanje neregularno",
                "matram da moj glas neće ništa promeniti"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);




    }
}
