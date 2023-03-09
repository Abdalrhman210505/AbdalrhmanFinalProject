package yassen.salam.abdalrhmanfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import yassen.salam.abdalrhmanfinalproject.R;
import yassen.salam.abdalrhmanfinalproject.data.Appointment;

public class AddAppointmentActvity extends AppCompatActivity implements LocationListener {
    private TextInputEditText etName;// name of student
    private Button btntime;
    private Button btndate;
    private TextInputEditText etIdentity;//identity number
    private TextInputEditText etPhone;//student phone number
    private TextInputEditText etType;//type of licence that student wants to learn
    private Button btnSave1;
    private Button btnCancel;
    private Boolean toEdit=false;

    //permissions list for current location
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    protected RadioButton rbManual;//
    protected RadioButton rbAutomatic;
    private TextView txtLat;
    String lat;
    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;
    Appointment m = new Appointment();
    //private DatePickerDialog.OnDateSetListener setListener;
    final Calendar calendar = Calendar.getInstance();


    @Override
    public void onLocationChanged(Location location) {
        if(txtLat!=null)
          txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
        else
        {
            //Toast.makeText(context, "Location service is denied", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude", "disable");
    }

   @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude", "enable");
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
        btnSave1 = findViewById(R.id.btnSave1);
        btnCancel = findViewById(R.id.btnCancel);
        txtLat = findViewById(R.id.textView1);
        rbManual = findViewById(R.id.rbManual);
        rbAutomatic = findViewById(R.id.rbAutomatic);

        etPhone.setText(m.getPhoneNumber());
        etIdentity.setText(m.getIdentity());
        etName.setText(m.getNameofstudent());


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        initLoacation();
        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkandSave();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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

    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent() != null && getIntent().hasExtra("Appointment")) {
            toEdit = true;
            m = (Appointment) getIntent().getExtras().get("Appointment");
            btnSave1.setText("update");
           etName.setText(m.getNameofstudent());
           etIdentity.setText(m.getIdentity());
           etPhone.setText(m.getPhoneNumber());
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(m.getTime());
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            Date date = null;
            try {
                date = sdf.parse(instance.getTime().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            btntime.setText(date.toString());
             sdf = new SimpleDateFormat("dd-M-yyyy");
            try {
                date = sdf.parse(instance.getTime().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            btndate.setText(date.toString());
          // etType.

        }

    }

    private void initLoacation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 200);
        }
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(AddAppointmentActvity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(AddAppointmentActvity.this, "Permission Denied", Toast.LENGTH_SHORT).show();

        }
    }

    private void showDateDialog()//thats a function that open calendar to choose the right date
    {
     DatePickerDialog dp=new DatePickerDialog(this);
     dp.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker datePicker, int d, int m1, int y)
         {

            m1=m1+1;
             btndate.setText(d+"/"+m1+"/"+y);
           calendar.set(Calendar.DAY_OF_MONTH, d);
           calendar.set(Calendar.YEAR,y);
           calendar.set(Calendar.MONTH,m1);
            showTimeDialog();
         }

     });
             Calendar.getInstance().get(Calendar.YEAR);
        Calendar.getInstance().get(Calendar.MONTH);
        Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        Date date=new Date();
        Calendar c=Calendar.getInstance();
        int y=c.get(Calendar.YEAR);
        int d=c.get(Calendar.DAY_OF_MONTH);
        int m=c.get(Calendar.MONTH);
        dp.updateDate(y,m,d);
        dp.show();


    }

    private void showTimeDialog(){//
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
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                    }
                }, mHour, mMinute, true);
        timePickerDialog.show();

    }





    private void checkandSave() {
        //استخراج القيم من صفحة الاضافة
        String Name = etName.getText().toString();
        String Identity = etIdentity.getText().toString();
        String Phone = etPhone.getText().toString();
        Boolean isManual=rbManual.isChecked();
        String time = btntime.getText().toString();
        String Location = txtLat.getText().toString();
        String date=btndate.getText().toString();
        //String date = btndate.getText().toString();
        //بناء الكائن واعطائه قيم الصفات
        m.setLocation(Location);
        m.setNameofstudent(Name);
        m.setIdentity(Identity);
        m.setPhoneNumber(Phone);
        m.setTime(calendar.getTimeInMillis());



       // m.setDate(date);
        m.setiSManualType(isManual);

        //استخراج رقم المميز UID
//user that signed in previously
        String Owner = FirebaseAuth.getInstance().getCurrentUser().getUid();
        m.setOwner(Owner);
        //استخراج رقم المميز لللقاء
        //استخراج رقم المميز لللقاء
        String Key=m.getKey();
        if (toEdit==false)
         Key = FirebaseDatabase.getInstance().getReference().child("Appointments")//جذر جديد يتم تخزين المهمات بعده
                //اضافة قيمة جديدة
                .child(Owner).push().getKey();
        m.setKey(Key);
        //حفظ بالخادم
        //عنوان جذر شجرة معطيات
        FirebaseDatabase.getInstance().getReference().child("Appointments").child(Owner).child(Key).setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task<Void> task) {//when we check
                if (task.isSuccessful()) {
                    finish();
                    addtogooglecalender();

                    Toast.makeText(AddAppointmentActvity.this, "Added Succesfully", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(AddAppointmentActvity.this, "Add Field" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

            }

        });


    }

    /**
     *
     */
    private void addtogooglecalender() {
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTimeInMillis(calendar.getTimeInMillis());
        Calendar endTime = Calendar.getInstance();
        endTime.setTimeInMillis(calendar.getTimeInMillis());
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, "driving lessons:")
                .putExtra(CalendarContract.Events.DESCRIPTION, "Event Description")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Event Location"+m.getLocation());
        startActivity(intent);
    }
}

