package com.shithappens.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchScreen extends AppCompatActivity implements View.OnTouchListener {

    Game game;
    Mole mole;
    Hole hole;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new Game(this);
        setContentView(game);

    }

    private void setContentView(Game game) {
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

                //new Handler().postDelayed(this, 300);//
            }
        }, 300);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            int x = (int) event.getX();
            int y = (int) event.getY();

            game.touch(x, y);
        }

        return false;
    }
}