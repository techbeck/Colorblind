package com.becca.colorblind;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawMatches extends View {

    private int baseColor;
    private int complementColor;
    private int split0Color;
    private int split1Color;
    private int triad0Color;
    private int triad1Color;
    private int analogous0Color;
    private int analogous1Color;
    private int square0Color;
    private int square1Color;
    private int square2Color;
    private int tetradic0Color;
    private int tetradic1Color;
    private int tetradic2Color;

    public DrawMatches(Context context, int color) {
        super(context);
        baseColor = color;
    }
    private void getColors()
    {
        complementColor = ColorMatching.getComplement(baseColor);
        int[] splitColors = ColorMatching.getSplitComplementary(baseColor, 60);
        split0Color = splitColors[0];
        split1Color = splitColors[1];
        int[] triadColors = ColorMatching.getTriad(baseColor);
        triad0Color = triadColors[0];
        triad1Color = triadColors[1];
        int[] analogousColors = ColorMatching.getAnalogous(baseColor, 60);
        analogous0Color = analogousColors[0];
        analogous1Color = analogousColors[1];
        int[] squareColors = ColorMatching.getSquare(baseColor);
        square0Color = squareColors[0];
        square1Color = squareColors[1];
        square2Color = squareColors[2];
        int[] tetradicColors = ColorMatching.getTetradic(baseColor);
        tetradic0Color = tetradicColors[0];
        tetradic1Color = tetradicColors[1];
        tetradic2Color = tetradicColors[2];
    }

    @Override
    public void onDraw(Canvas canvas) {
        getColors();
        drawColors(canvas);
    }

    private void drawColors(Canvas canvas)
    {
        int y = 500;
        int x = 1000;
        int titleHeight = 70;
        int colorHeight = y - (4 * titleHeight);
        int base = titleHeight;

        Paint basePaint = new Paint();
        basePaint.setColor(baseColor);

        Paint complementPaint = new Paint();
        complementPaint.setColor(complementColor);

        Paint split0Paint = new Paint();
        split0Paint.setColor(split0Color);
        Paint split1Paint = new Paint();
        split1Paint.setColor(split1Color);

        Paint triad0Paint = new Paint();
        triad0Paint.setColor(triad0Color);
        Paint triad1Paint = new Paint();
        triad1Paint.setColor(triad1Color);

        Paint analogous0Paint = new Paint();
        analogous0Paint.setColor(analogous0Color);
        Paint analogous1Paint = new Paint();
        analogous1Paint.setColor(analogous1Color);

        Paint square0Paint = new Paint();
        square0Paint.setColor(square0Color);
        Paint square1Paint = new Paint();
        square1Paint.setColor(square1Color);
        Paint square2Paint = new Paint();
        square2Paint.setColor(square2Color);

        Paint tetradic0Paint = new Paint();
        tetradic0Paint.setColor(tetradic0Color);
        Paint tetradic1Paint = new Paint();
        tetradic1Paint.setColor(tetradic1Color);
        Paint tetradic2Paint = new Paint();
        tetradic2Paint.setColor(tetradic2Color);

        Paint ink = new Paint();
        ink.setColor(Color.BLACK);
        ink.setTextSize(titleHeight);

        canvas.drawText("Complement", 0, 10, 0, base, ink);
        canvas.drawRect(0, base, x * (float) .5, base + colorHeight, basePaint);
        canvas.drawRect((float) .5 * x, base, x, base + colorHeight, complementPaint);

        base = 2*titleHeight + colorHeight;
        canvas.drawText("Split Complement", 0, 16, 0, base, ink);
        canvas.drawRect(0, base, (float) (1.0 / 3.0) * x, base + colorHeight, basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, base, (float) (2.0/3.0) * x, base + colorHeight, split0Paint);
        canvas.drawRect((float) (2.0 / 3.0) * x, base, x, base + colorHeight, split1Paint);

        base = 3*titleHeight + 2*colorHeight;
        canvas.drawText("Triad", 0, 5, 0, base, ink);
        canvas.drawRect(0, base, (float) (1.0 / 3.0) * x, base + colorHeight, basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, base, (float) (2.0/3.0) * x, base + colorHeight, triad0Paint);
        canvas.drawRect((float) (2.0/3.0) * x, base, x, base + colorHeight, triad1Paint);

        base = 4 * titleHeight + 3 *colorHeight;
        canvas.drawText("Analogous", 0, 9, 0, base, ink);
        canvas.drawRect(0, base, (float) (1.0/3.0) * x, base + colorHeight, basePaint);
        canvas.drawRect((float) (1.0/3.0) * x, base, (float) (2.0/3.0) * x, base + colorHeight, analogous0Paint);
        canvas.drawRect((float) (2.0/3.0) * x, base, x, base + colorHeight, analogous1Paint);

        base = 5 * titleHeight + 4 *colorHeight;
        canvas.drawText("Square", 0, 6, 0, base, ink);
        canvas.drawRect(0, base, (float) .25 * x, base + colorHeight, basePaint);
        canvas.drawRect((float) .25 * x, base, (float) .5 * x, base + colorHeight, square1Paint);
        canvas.drawRect((float) .5 * x, base, (float) .75 * x, base + colorHeight, square0Paint);
        canvas.drawRect((float) .75 * x, base, x, base + colorHeight, square2Paint);

        base = 6 * titleHeight + 5 *colorHeight;
        canvas.drawText("Tetradic", 0, 8, 0, base, ink);
        canvas.drawRect(0, base, (float) .25 * x, base + colorHeight, basePaint);
        canvas.drawRect((float) .25 * x, base, (float) .5 * x, base + colorHeight, tetradic1Paint);
        canvas.drawRect((float) .5 * x, base, (float) .75 * x, base + colorHeight, tetradic0Paint);
        canvas.drawRect((float) .75 * x, base, x, base + colorHeight, tetradic2Paint);
    }

}