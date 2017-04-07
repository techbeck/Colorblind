package com.becca.colorblind;

import android.support.v4.graphics.ColorUtils;

public class ColorMatching {
    private static float[] hsl = new float[3];
    public static int getComplement(int color)
    {
        ColorUtils.colorToHSL(color, hsl);
        float[] complementHSL = ColorRelationship.getComplement(hsl);
        return ColorUtils.HSLToColor(complementHSL);
    }
    public static int[] getSplitComplementary(int color, float splitOffset)
    {
        ColorUtils.colorToHSL(color, hsl);
        float[][] splitHSLs = ColorRelationship.getSplitComplementary(hsl, splitOffset);
        float[] split0HSL = new float[3];
        float[] split1HSL = new float[3];
        for (int i = 0; i < 3; i++)
        {
            split0HSL[i] = splitHSLs[0][i];
            split1HSL[i] = splitHSLs[1][i];
        }
        int[] splitInt = new int[2];
        splitInt[0] = ColorUtils.HSLToColor(split0HSL);
        splitInt[1] = ColorUtils.HSLToColor(split1HSL);
        return splitInt;
    }
    public static int[] getTriad(int color)
    {
        ColorUtils.colorToHSL(color, hsl);
        float[][] triadHSLs = ColorRelationship.getTriad(hsl);
        float[] triad0HSL = new float[3];
        float[] triad1HSL = new float[3];
        for (int i = 0; i < 3; i++)
        {
            triad0HSL[i] = triadHSLs[0][i];
            triad1HSL[i] = triadHSLs[1][i];
        }
        int[] triadInt = new int[2];
        triadInt[0] = ColorUtils.HSLToColor(triad0HSL);
        triadInt[1] = ColorUtils.HSLToColor(triad1HSL);
        return triadInt;
    }
    public static int[] getAnalogous(int color, int splitDegree)
    {
        ColorUtils.colorToHSL(color, hsl);
        float[][] analogousHSLs = ColorRelationship.getAnalogous(hsl, splitDegree);
        float[] analogous0HSL = new float[3];
        float[] analogous1HSL = new float[3];
        for (int i = 0; i < 3; i++)
        {
            analogous0HSL[i] = analogousHSLs[0][i];
            analogous1HSL[i] = analogousHSLs[1][i];
        }
        int[] analogousInt = new int[2];
        analogousInt[0] = ColorUtils.HSLToColor(analogous0HSL);
        analogousInt[1] = ColorUtils.HSLToColor(analogous1HSL);
        return analogousInt;
    }
    public static int[] getSquare(int color)
    {
        ColorUtils.colorToHSL(color, hsl);
        float[][] squareHSLs = ColorRelationship.getSquare(hsl);
        float[] square0HSL = new float[3];
        float[] square1HSL = new float[3];
        float[] square2HSL = new float[3];
        for (int i = 0; i < 3; i++)
        {
            square0HSL[i] = squareHSLs[0][i];
            square1HSL[i] = squareHSLs[1][i];
            square2HSL[i] = squareHSLs[2][i];
        }
        int[] squareInt = new int[3];
        squareInt[0] = ColorUtils.HSLToColor(square0HSL);
        squareInt[1] = ColorUtils.HSLToColor(square1HSL);
        squareInt[2] = ColorUtils.HSLToColor(square2HSL);
        return squareInt;
    }
    public static int[] getTetradic(int color)
    {
        int triadPick = getTriad(color)[0];
        int triComp = getComplement(triadPick);
        int comp = getComplement(color);
        return new int[] { triadPick, triComp, comp};
    }
}

