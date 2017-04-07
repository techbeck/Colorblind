package com.becca.colorblind;

public class ColorRelationship
{
    public static float[] getComplement(float[] color)
    {
        float[] complement = new float[3];
        complement[1] = color[1];
        complement[2] = color[2];

        if(color[0] > 180)
            complement[0] = color[0] - (float) 180.0;
        else
            complement[0] = color[0] + (float) 180.0;

        return complement;
    }

    public static float[][] getTriad(float[] color)
    {
        float[][] triad = new float[2][3];
        for(int i = 0; i < 2; i++)
        {
            triad[i][1] = color[1];
            triad[i][2] = color[2];
        }

        if(color[0] > 240)
        {
            triad[0][0] = color[0] - (float) 120.0;
            triad[1][0] = color[0] - (float) 240.0;
        }
        else if(color[0] > 120)
        {
            triad[0][0] = color[0] - (float) 120.0;
            triad[1][0] = color[0] + (float) 120.0;
        }
        else
        {
            triad[0][0] = color[0] + (float) 120.0;
            triad[1][0] = color[0] + (float) 240.0;
        }

        return triad;
    }

    public static float[][] getSplitComplementary(float[] color, float splitDegrees)
    {
        float[] complement = getComplement(color);
        float[][] splitComp = getAnalogous(complement, splitDegrees);

        return splitComp;
    }

    public static float[][] getAnalogous(float[] color, float splitDegrees)
    {
        float[][] analogous = new float[2][3];
        for(int i = 0; i < 2; i++)
        {
            analogous[i][1] = color[1];
            analogous[i][2] = color[2];
        }

        float degreesOffset = splitDegrees / (float) 2.0;

        analogous[0][0] = color[0] + degreesOffset;
        analogous[1][0] = color[0] - degreesOffset;

        for(int i = 0; i < 2; i++)
        {
            if(analogous[i][0] > 360.0)
                analogous[i][0] = analogous[i][0] - (float) 360.0;
            else if(analogous[i][0] < 0.0)
                analogous[i][0] = analogous[i][0] + (float) 360.0;
        }

        return analogous;
    }

    public static float[][] getSquare(float[] color)
    {
        float[][] square = new float[3][3];
        for(int i = 0; i < 3; i++)
        {
            square[i][1] = color[1];
            square[i][2] = color[2];
        }

        for(int i = 0; i < 3; i++)
        {
            square[i][0] = color[0] + ((i + 1) * 90);
            if(square[i][0] > 360.0)
            {
                square[i][0] = square[i][0] - (float) 360.0;
            }
        }

        return square;
    }
}