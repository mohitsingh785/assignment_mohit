package com.mohit.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView characterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterView = findViewById(R.id.characterView);
    }

    float x1, x2, y1, y2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                float deltaX = x2 - x1;
                float deltaY = y2 - y1;

                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    // Horizontal swipe
                    if (deltaX > 0) {
                        // Swipe right, rotate right
                        rotateCharacter(90);
                    } else {
                        // Swipe left, rotate left
                        rotateCharacter(-90);
                    }
                } else {
                    // Vertical swipe
                    if (deltaY > 0) {
                        // Swipe down, rotate down
                        rotateCharacter(180);
                    } else {
                        // Swipe up, rotate up
                        rotateCharacter(0);
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private void rotateCharacter(float toDegree) {
        Animation animation = new RotateAnimation(
                characterView.getRotation(),
                toDegree,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        animation.setDuration(500);
        animation.setFillAfter(true);

        characterView.startAnimation(animation);
    }
}