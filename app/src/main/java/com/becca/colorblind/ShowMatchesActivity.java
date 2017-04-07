package com.becca.colorblind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ShowMatchesActivity extends AppCompatActivity {
    DrawMatches drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_matches);

        drawColors();
    }

    private void drawColors()
    {
        int baseColor = getIntent().getIntExtra("colorInt", 0);

        drawView = new DrawMatches(this, baseColor);
        setContentView(drawView);
    }
}
