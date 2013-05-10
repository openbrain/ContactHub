package com.durgesh.view.touchlistener;

import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public abstract class GestureListener extends SimpleOnGestureListener implements OnTouchListener {

    private static final int SWIPE_MIN_DISTANCE = 4;
    private static final int SWIPE_THRESHOLD_VELOCITY = 10;
    private final GestureDetector gdt = new GestureDetector(this);
    
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gdt.onTouchEvent(event);
        return true;
        
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            onRightToLeft();
            return true;
        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            onLeftToRight();
            return true;
        }
        if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            onBottomToTop();
            return true;
        } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            onTopToBottom();
            return true;
        }
        return true;
    }
    
    public abstract void onRightToLeft();

    public abstract void onLeftToRight();

    public abstract void onBottomToTop();

    public abstract void onTopToBottom();
}
