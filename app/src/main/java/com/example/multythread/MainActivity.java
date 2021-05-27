package com.example.multythread;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countOdd(View view) {
        WeakReference<Context> ref = new WeakReference<Context>(this);
        CounterOdd counter = new CounterOdd(ref);
        counter.run();
    }

    public void countEven(View view) {
        WeakReference<Activity> activity = new WeakReference<Activity>(this);
        CounterEven counter = new CounterEven(activity);
        counter.run();
    }
}