package com.example.multythread;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class CounterEven implements Runnable {
    // Getting the activity from constructor
    Activity activity;
    public CounterEven(WeakReference<Activity> applicationContext) {
        activity = applicationContext.get();
    }
    // Actually a Tread operations in run function
    @Override
    public void run() {
        for (int iterator = 0; iterator <= 100; iterator+=2) {
            System.out.println(iterator);
        }
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // our saved activity is a bridge back to UI screen. We start it in new thread
        activity.runOnUiThread (new Runnable () {
            @Override
            public void run() {
                // Activity is a part of context
                Toast.makeText(activity, "Even counter compleated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
