package com.becca.colorblind;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import static android.R.attr.x;

public class SelectAreaActivity extends AppCompatActivity {

    Bitmap imageBitmap;
    ImageView imageView;
    int baseColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_area);

        imageView = (ImageView) findViewById(R.id.image_view);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        imageBitmap = BitmapFactory.decodeFile(getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
        imageView.setMaxWidth(imageBitmap.getScaledWidth(metrics));
        imageView.setMaxHeight(imageBitmap.getScaledHeight(metrics));
        imageView.setImageBitmap(imageBitmap);

        final Button acceptAreaButton = (Button) findViewById(R.id.accept_button);
        acceptAreaButton.setEnabled(false);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float trueX = event.getX();
                float trueY = event.getY();
                int vWidth = imageView.getWidth();
                int vHeight = imageView.getHeight();
                int bWidth = imageBitmap.getWidth();
                int bHeight = imageBitmap.getHeight();
                float x = (trueX * bWidth)/vWidth;
                float y = (trueY * bHeight)/vHeight;
                if (x < 0 || y < 0 || x >= imageBitmap.getWidth() || y >= imageBitmap.getHeight()) {
                    acceptAreaButton.setBackgroundColor(0);
                    return false;
                }
                baseColor = imageBitmap.getPixel((int) x, (int) y);
                acceptAreaButton.setEnabled(true);
                acceptAreaButton.setBackgroundColor(baseColor);
                return true;
            }
        });

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMatchesIntent = new Intent(getApplicationContext(), ShowMatchesActivity.class);
                showMatchesIntent.putExtra("colorInt", baseColor);
                startActivity(showMatchesIntent);
            }
        };
        acceptAreaButton.setOnClickListener(clickListener);
    }

}
