package com.shithappens.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    Button btnJogarNovamente;
    TextView txtScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        btnJogarNovamente = findViewById(R.id.btnJogarNovamente);
        txtScore = findViewById(R.id.txtScore);

        btnJogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SingleTouchScreen.class);

                startActivity( intent );

            }
        });

    }

}