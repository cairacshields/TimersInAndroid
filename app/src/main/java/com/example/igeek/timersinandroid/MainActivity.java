package com.example.igeek.timersinandroid;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    //Here is a simple class that shows how to use time management in Android.
    //Below I will utilize two ways to manage timely tasks, Countdowntimers and Handlers
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long l) {

                //This method happens while the countdown is actually countingdown
                //It is also important to note that the method will give us the amount of time until
                //the timer is done.
                Log.i("Seconds till done...", String.valueOf(l/1000));
            }


            public void onFinish(){

                //this method happens when the countdown is finished
                Log.i("Done!", "Countdown timer finished");
            }
        };

        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            //Remember that Runnable has the default method 'run' that has to be overriden.
            @Override
            public void run() {
                //Insert the code you want to run here.
                //Now we use our handler to actually run the code

                Log.d("Runnable has run!", "A second has passed!");
                handler.postDelayed(this, 1000);
            }
        };

        //This line will actually run our code in the run method
        handler.post(run);
    }
}
