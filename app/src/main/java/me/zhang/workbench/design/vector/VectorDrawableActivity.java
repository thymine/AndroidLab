package me.zhang.workbench.design.vector;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import me.zhang.workbench.R;

public class VectorDrawableActivity extends AppCompatActivity {
    private ImageView imageView;
    private AnimatedVectorDrawable emptyHeart;
    private AnimatedVectorDrawable fillHeart;
    private boolean full = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_drawable);
        imageView = findViewById(R.id.image_view);
        emptyHeart = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_heart_empty);
        fillHeart = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_heart_fill);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void animateHeart(View view) {
        AnimatedVectorDrawable drawable = full ? emptyHeart : fillHeart;
        imageView.setImageDrawable(drawable);
        drawable.start();
        full = !full;
    }

}