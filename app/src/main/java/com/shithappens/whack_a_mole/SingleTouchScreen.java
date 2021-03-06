package com.shithappens.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.fonts.Font;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchScreen extends AppCompatActivity implements View.OnTouchListener {

    private Context context;

    private boolean loop = false;

    Game game;



    CountDownTimer timer;
    private final int MAX_SEG = 10;
    private long tempoRestanteEmMiliseg = (MAX_SEG + 1) * 1000;

    GameOver gameOver;

    private static int pontos;

    public static int getPontos() {
        return pontos;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_touch_screen);



        game = new Game(this);
        setContentView(game);

        game.setOnTouchListener(this);

    }

    private void startTimer() {
       timer = new CountDownTimer(5000, 1000) {
           @Override
           public void onTick(long millisUntilFinished) {
            tempoRestanteEmMiliseg = millisUntilFinished;

           }

           @Override
           public void onFinish() {
               OnFimDeJogo();
           }
           }.start();
       }


    private void onFimDeJogo(){
    Intent intent = new Intent(this.context, GameOver.class);
    startActivity(intent);
    finish();

    }
    
    @Override
    protected void onResume() {
        super.onResume();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {


            @Override
            public void run() {
                game.update();
                game.invalidate();


                new Handler().postDelayed(this, 300);
            }
        }, 300);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {



        if (event.getAction() == MotionEvent.ACTION_DOWN){
            int x = (int)event.getX();
            int y = (int)event.getY();

            game.touch(x, y);


        }

        return false;
    }
}