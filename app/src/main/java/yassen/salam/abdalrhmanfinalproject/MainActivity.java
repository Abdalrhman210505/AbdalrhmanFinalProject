package yassen.salam.abdalrhmanfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
private android.widget.SearchView SearchView;
private ListView List;
private ImageButton imageButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchView=findViewById(R.id.SearchView);
        List=findViewById(R.id.List);
        imageButtonAdd=findViewById(R.id.imageButtonAdd);

        imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddTaskActivity.class);
                startActivity(i);
            }
        });



    }

    @Override
    //a function that returns true if all things are alright (no bugs)
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);      //to make menu appear in the emulator
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //when you select menu item they change the screen to another screen (if i select history the screen goes to history screen)
        if(item.getItemId()==R.id.itmsetting){
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
        }

        else if(item.getItemId()==R.id.itmsignout){

           // FirebaseAuth.getInstance().signOut();
            //finish();
            //1.تحجهيز البناء للدايلوج
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setTitle("Confirm SignOut");
            builder.setTitle("are you sure?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    //اخفاء الديالوج
                    dialogInterface.dismiss();
                    //تسجيل الخروج من الحساب
                    FirebaseAuth.getInstance().signOut();
                    //الخروج من الشاشة
                    finish();


                    //اخفاء الديالوج
                }
            });
            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    dialogInterface.cancel();
                }
            });
            //dialouge building

            AlertDialog dialog=builder.create();
            dialog.show();
        }
        else if (item.getItemId()==R.id.itmhistory){
            Intent i = new Intent(MainActivity.this,History.class);
            startActivity(i);

        }
        return true;
    }
    private void readTasksFromFireBase(){


    }



}