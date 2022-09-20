package yassen.salam.abdalrhmanfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//يبني واجهةالمستخدم بحيث تبني كل الكائنات الموجودة بملف التنسيق

        setContentView(R.layout.activity_splash_screen);
        //start next activity (screen) automaically afer period of time فتح الشاشة التالية تلقائيا بعد فترة من الزمن
        Handler h=new Handler();
        Runnable R=new Runnable() {
            @Override
            public void run() {
                //to open new screen from current to next screen
                Intent i=new Intent(SplashScreenActivity.this, SignInActivty.class);
                startActivity(i);
                //to close current activity
                finish();


            }
        };
        h.postDelayed(R,3000);


    }
}