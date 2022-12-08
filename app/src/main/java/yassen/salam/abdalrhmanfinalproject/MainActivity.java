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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import yassen.salam.abdalrhmanfinalproject.data.Appointment;
import yassen.salam.abdalrhmanfinalproject.data.AppointmentAdapter;

/**
 * MainActivity
 */
public class MainActivity extends AppCompatActivity {
    //تجهيز وسيط 3.1
    AppointmentAdapter appointmentAdapter;
    ListView listView;
private android.widget.SearchView SearchView;
private ListView List;
private ImageButton imageButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //قوم ببناء شاشة التنسيق وكل الاكائنات التي تحويها
        setContentView(R.layout.activity_main);
        //3.2 بناء الوسيط
        appointmentAdapter =new AppointmentAdapter(getApplicationContext());
        //تجهيز مؤشر لقائمة العرض
        listView=findViewById(R.id.List);
        listView.setAdapter(appointmentAdapter);
        //3.3 ربط قائمة العرض بالوسيط
        SearchView=findViewById(R.id.SearchView);
        imageButtonAdd=findViewById(R.id.imageButtonAdd);
        readTasksFromFireBase();
    imageButtonAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent i=new Intent(MainActivity.this,AddAppointmentActvity.class);
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
            Intent i = new Intent(MainActivity.this, Settings.class);//وصف لعملية اللي بتخليه ينقل من شاشة لشاشة عن طريق الكائن i وهاي العملية بتشتغل لما بحط ستارت اكتيفيتي
            startActivity(i);
        }

        else if(item.getItemId()==R.id.itmsignout){

           // FirebaseAuth.getInstance().signOut();
            //finish();
            //1.تحجهيز البناء للدايلوج
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setTitle("Confirm SignOut");
            builder.setTitle("Are You Sure?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {//يضيف ال زر النعم
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
            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {//يضيف زر ال no
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

        //مؤشر لجذر قاعدة البيانات التابعة للمشروع
        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference();

        String Owner = FirebaseAuth.getInstance().getCurrentUser().getUid();

       FirebaseDatabase.getInstance().getReference().child("Appointments").
       child(Owner).addValueEventListener(new ValueEventListener() {
            /**
            *دالة معالجة حدث عند تغيير اي قيمة
            * parameter snapshot تحوي نسخة عن كل المعطيات تحت العنوان المراقب


             **/
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //remove all appointment
                appointmentAdapter.clear();
                //remove all thing
                for (DataSnapshot d : snapshot.getChildren())//يمر على جميع مبنى المعطيات d
                {
                    Appointment value = d.getValue(Appointment.class);
                appointmentAdapter.add(value);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



}