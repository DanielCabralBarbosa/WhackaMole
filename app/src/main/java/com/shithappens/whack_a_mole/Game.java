package com.shithappens.whack_a_mole;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class Game extends View {

    Bitmap mole;
    int x, y, targetX, targetY;

    public Game(Context context) {
        super(context);

        mole = BitmapFactory.decodeResource(getResources(), R.drawable.mole);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect dstRect = new Rect();
        dstRect.left = x; dstRect.top = y;
        dstRect.right = dstRect.left + mole.getWidth();
        dstRect.bottom = dstRect.top + mole.getHeight();

        canvas.drawBitmap(mole, null, dstRect, null);
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
