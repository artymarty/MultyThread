package com.example.multythread;
import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class CounterOdd implements Runnable {
    // Make new activity to keep passed parameter
    Activity activity;

    // Constructor with one Activity parameter (wraped in reference stuff
    public CounterOdd(WeakReference<Context> applicationContext) {
        // Context get inself and cast to Activity
        activity = (Activity) applicationContext.get();
    }

    // Actually a Tread operations in run function
    @Override
    public void run() {
        for (int iterator = 1; iterator <= 100; iterator+=2) {
            System.out.println(iterator);
        }
        try {
            Thread.sleep(250);  // somehow sleep needs try/catch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // our saved activity is a bridge back to UI screen. We start it in new thread
        activity.runOnUiThread (new Runnable () {
            @Override
            public void run() {
                // Activity is a part of context, so Toast will not argue.
                Toast.makeText(activity, "Odd counter compleated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
