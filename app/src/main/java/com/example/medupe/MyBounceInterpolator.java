package com.example.medupe;

public class MyBounceInterpolator {
    private double mAmplitude = 1;
    private double mFrequency = 10;

    public MyBounceInterpolator(double mAmplitude, double mFrequency) {
        this.mAmplitude = mAmplitude;
        this.mFrequency = mFrequency;
    }

    public float MyBounceInterpolator(float time) {
        return (float)(-1 * Math.pow(Math.E, -time/ mAmplitude) * Math.cos(mFrequency * time) + 1);

    }
}
