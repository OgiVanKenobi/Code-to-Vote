package com.example.android.codetovote.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.codetovote.R;
import com.example.android.codetovote.domain.PotentialProblem;
import com.example.android.codetovote.domain.User;
import com.example.android.codetovote.retrofit.RetrofitClient;
import com.example.android.codetovote.retrofit.UserAPI;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrijavaProblemaActivity extends Activity {

    Spinner spinner;
    CardView submitButton, cancelButton;
    EditText naslovInput, opisInput;
    String naslov, opis;


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


        submitButton = findViewById(R.id.submitButton);
        cancelButton = findViewById(R.id.CancelButton);
        naslovInput = findViewById(R.id.editTextNaslov);
        opisInput = findViewById(R.id.editTextOpis);
        spinner = findViewById(R.id.spinner);


        //Padajuca lista
        String[] items = new String[]{"Nisam u mogućnosti da glasam u mestu prebivališta",
                "Nisam siguran gde je moje biračko mesto", "Nemam za koga da glasam", "matram da je glasanje neregularno",
                "matram da moj glas neće ništa promeniti"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                naslov = naslovInput.getText().toString();
                opis = opisInput.getText().toString();
                if(!naslov.isEmpty() && !opis.isEmpty()) {
                    User user = new User(13, "aaa", "aaa");
                    Date date = new Date();
                    PotentialProblem potentialProblem = new PotentialProblem(Long.valueOf(1), naslov, opis, date, user, false);

                    //Mockup kod
                    Intent intent = new Intent(PrijavaProblemaActivity.this, PitanjaActivity.class);
                    intent.putExtra("msg", "Vaš odgovor je registrovan. Hvala što učestvujete!");
                    startActivity(intent);
                    finish();

//
//                    UserAPI userApi = RetrofitClient.getRetrofitInstance().create(UserAPI.class);
//                    Call<PotentialProblem> call = userApi.save(potentialProblem);
//                    call.enqueue(new Callback<PotentialProblem>() {
//                        @Override
//                        public void onResponse(Call<PotentialProblem> call, Response<PotentialProblem> response) {
//                            if (response.code() == 200) {
//                                Intent intent = new Intent(PrijavaProblemaActivity.this, PitanjaActivity.class);
//                                intent.putExtra("msg", "Vaš odgovor je registrovan. Hvala što učestvujete!");
//                                startActivity(intent);
//                                finish();
//                            } else {
//                                Toast.makeText(getApplicationContext(), "Došlo je do problema! Pokušajte ponovo.", Toast.LENGTH_LONG).show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<PotentialProblem> call, Throwable t) {
//
//                        }
//
//                    });
//
                }else{
                    Toast.makeText(getApplicationContext(), "Polja ne mogu biti prazna!",Toast.LENGTH_LONG).show();
                }

                }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
