package com.shithappens.whack_a_mole;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class Game extends View {

    int x, y, targetX, targetY;

    public Game(Context context) {
        super(context);

    }

    public void update() {
    }

    public void touch(int x, int y){
        targetX = x;
        targetY = y;
    }

    public void invalidate() {
    }
}
