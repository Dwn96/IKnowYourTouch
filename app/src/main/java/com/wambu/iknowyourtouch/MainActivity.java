package com.wambu.iknowyourtouch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener, View.OnTouchListener {


    RelativeLayout relativeLayout;
    private GestureDetector mGestureDetector;
    Context context= this;
    MediaPlayer mp;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setOnTouchListener(this);



        mGestureDetector = new GestureDetector(this,this);









    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        mp = MediaPlayer.create(context, R.raw.doubletap);
        Toast.makeText(this,"You double tapped me!",Toast.LENGTH_SHORT).show();
        try {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();

            } mp.start();
        } catch(Exception t) { t.printStackTrace(); }
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mp= MediaPlayer.create(context,R.raw.longpress);
        Toast.makeText(this,"You long pressed me!",Toast.LENGTH_SHORT).show();
        try{
            if (mp.isPlaying()){
                mp.stop();
                mp.release();

            }mp.start();
        }
        catch (Exception t){
            t.printStackTrace();
        }

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if(view.getId() == R.id.relativeLayout){
            //methods for touching button
            mGestureDetector.onTouchEvent(event);
            return true;
        }

        return true;
    }
}

