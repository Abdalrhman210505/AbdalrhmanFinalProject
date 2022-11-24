package yassen.salam.abdalrhmanfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreenActivity extends AppCompatActivity {
private Button btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//يبني واجهةالمستخدم بحيث تبني كل الكائنات الموجودة بملف التنسيق
        LoadingDialog loadingDialog=new LoadingDialog(SplashScreenActivity.this);
        setContentView(R.layout.activity_splash_screen);
        //start next activity (screen) automaically afer period of time فتح الشاشة التالية تلقائيا بعد فترة من الزمن
        Handler h=new Handler();
       btnnext=findViewById(R.id.btnnext);
       btnnext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               loadingDialog.startLoadingDialog();
               h.postDelayed(R)
           }
       });
        Runnable R=new Runnable() {
            @Override
            public void run() {
                //فحص هل تم الدخول مسبقا ؟
                FirebaseAuth auth=FirebaseAuth.getInstance();
                if (auth.getCurrentUser()== null){
                    //to open new screen from current to next screen
                    Intent i=new Intent(SplashScreenActivity.this, SignInActivty.class);
                    startActivity(i);
                    //to close current activity
                    finish();


                }
                else {
                    //to open new screen from current to next screen
                    Intent i=new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(i);
                    //to close current activity
                    finish();
                }



             }

        };


        h.postDelayed(R,3000);


    }
}