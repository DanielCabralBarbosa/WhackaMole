package com.shithappens.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouchActivity extends AppCompatActivity {
    public static final int MAX_TOUCHES = 5;

    Point points[];
    boolean isVisible[];

    private MultiTouchView multiTouchView;

    public class MultiTouchView extends View implements View.OnTouchListener {

        public MultiTouchView(Context context) {
            super(context);
            points = new Point[MAX_TOUCHES];
            isVisible = new boolean[MAX_TOUCHES];

        }
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            int action = event.getActionMasked();
            int pointerIndex = event.getActionIndex();
            int id = event.getPointerId(pointerIndex);

            switch (action){
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_POINTER_DOWN:

                    points[id] = new Point();
                    points[id].x = (int) event.getX(pointerIndex);
                    points[id].y = (int) event.getY(pointerIndex);
                    isVisible[id] = true;
                    break;

                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_POINTER_UP:
                isVisible[id] = false;
            }

            return false;
        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        multiTouchView = new MultiTouchView(this);
        setContentView(multiTouchView);
    }
}