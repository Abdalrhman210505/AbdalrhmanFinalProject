package yassen.salam.abdalrhmanfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import yassen.salam.abdalrhmanfinalproject.data.Appointment;

public class AddAppointmentActvity extends AppCompatActivity implements LocationListener{
    private TextInputEditText etName;// name of student
    private Button btntime;
    private Button btndate;
    private TextInputEditText etIdentity;//identity number
    private TextInputEditText etPhone;//student phone number
    private TextInputEditText etType;//type of licence that student wants to learn
    private Button btnSave1;
    private Button btnCancel;
    //permissions list for current location
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected String latitude,longitude;
    protected boolean gps_enabled,network_enabled;

    //private DatePickerDialog.OnDateSetListener setListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLat = (TextView) findViewById(R.id.textView1);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }
    @Override
    public void onLocationChanged(Location location) {
        txtLat = (TextView) findViewById(R.id.textView1);
        txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment_actvity);
        etName = findViewById(R.id.etName);
        btntime = findViewById(R.id.btntime);
        btndate = findViewById(R.id.btndate);
        etIdentity = findViewById(R.id.etIdentity);
        etPhone = findViewById(R.id.etPhone);
        etType = findViewById(R.id.etType);
        btnSave1 = findViewById(R.id.btnSave1);
        btnCancel = findViewById(R.id.btncancel);

        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkandSave();
            }
        });
        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();

            }
        });
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog();
            }
        });


    }

    private void showDateDialog()
    {
     DatePickerDialog dp=new DatePickerDialog(this);
     dp.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker datePicker, int d, int m, int y)
         {


             btndate.setText(d+"/"+m+"/"+y);

         }


     });
        Date date=new Date();
        Calendar c=Calendar.getInstance();
        int y=c.get(Calendar.YEAR);
        int d=c.get(Calendar.DAY_OF_MONTH);
        int m=c.get(Calendar.MONTH);
        dp.updateDate(y,m,d);
        dp.show();


    }


    private void showTimeDialog(){
        // Get Current Time
        final Calendar c = Calendar.getInstance();

        int mHour = c.get(Calendar.HOUR_OF_DAY);
       int mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        btntime.setText(hourOfDay + ":" + minute);

                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();

    }









    private void checkandSave() {
        //استخراج القيم من صفحة الاضافة
        String Name = etName.getText().toString();
        String Identity = etIdentity.getText().toString();
        String Phone = etPhone.getText().toString();
        String Type = etType.getText().toString();
        String time = btntime.getText().toString();
        String date = btndate.getText().toString();
        //بناء الكائن واعطائه قيم الصفات
        Appointment m = new Appointment();
        m.setNameofstudent(Name);
        m.setIdentity(Identity);
        m.setPhoneNumber(Phone);
        m.setType(Type);
        m.setTime(time);
        m.setDate(date);

        //استخراج رقم المميز UID
//user that signed in previously
        String Owner = FirebaseAuth.getInstance().getCurrentUser().getUid();
        m.setOwner(Owner);
        //استخراج رقم المميز لللقاء
        String Key = FirebaseDatabase.getInstance().getReference().child("Appointments")//جذر جديد يتم تخزين المهمات بعده
                //اضافة قيمة جديدة
                .child(Owner).push().getKey();
        m.setKey(Key);
        //حفظ بالخادم
        //عنوان جذر شجرة معطيات
        FirebaseDatabase.getInstance().getReference().child("Appointments").child(Owner).child(Key).setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {


            @Override
            public void onComplete(@NonNull Task<Void> appointment) {
                if (appointment.isSuccessful()) {
                    finish();
                    Toast.makeText(AddAppointmentActvity.this, "Added Succesfully", Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(AddAppointmentActvity.this, "Add Field"+appointment.getException().getMessage(), Toast.LENGTH_SHORT).show();
                finish();
            }

            }
        );}

    }


