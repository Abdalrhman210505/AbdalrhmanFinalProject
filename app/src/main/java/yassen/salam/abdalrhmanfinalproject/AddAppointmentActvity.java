package yassen.salam.abdalrhmanfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Date;
import java.sql.Time;

import yassen.salam.abdalrhmanfinalproject.data.Appointment;

public class AddAppointmentActvity extends AppCompatActivity {
    private TextInputEditText etName;// name of student
    private EditText ettime;
    private EditText etdate;
    private TextInputEditText etIdentity;//identity number
    private TextInputEditText etPhone;//student phone number
    private TextInputEditText etType;//type of licence that student wants to learn
    private Button btnSave;
    private Button btnCancel;
    //private DatePickerDialog.OnDateSetListener setListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment_actvity);
        etName = findViewById(R.id.etName);
        ettime = findViewById(R.id.editTextTime2);
        etdate = findViewById(R.id.editTextDate);
        etIdentity = findViewById(R.id.etIdentity);
        etPhone = findViewById(R.id.etPhone);
        etType = findViewById(R.id.etType);
        btnSave = findViewById(R.id.btnsave);
        btnCancel = findViewById(R.id.btncancel);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkandSave();
            }
        });
    }

    private void checkandSave() {
        //استخراج القيم من صفحة الاضافة
        String Name = etName.getText().toString();
        String Identity = etIdentity.getText().toString();
        String Phone = etPhone.getText().toString();
        String Type = etType.getText().toString();
        String time =ettime.getText().toString();
        String date=etdate.getText().toString();
        //بناء الكائن واعطائه قيم الصفات
        Appointment m=new Appointment();
        m.setNameofstudent(Name);
        m.setDate(date);
        m.setIdentity(Identity);
        m.setTime(time);
        m.setPhoneNumber(Phone);
        m.setType(Type);
        //استخراج رقم المميز UID
//user that signed in previously
        String Owner= FirebaseAuth.getInstance().getCurrentUser().getUid();
        m.setOwner(Owner);
        //استخراج رقم المميز لللقاء
        String Key= FirebaseDatabase.getInstance().getReference().child("Appointments")//جذر جديد يتم تخزين المهمات بعده
        //اضافة قيمة جديدة
                .child(Owner).push().getKey();
        m.setKey(Key);
        //حفظ بالخادم
        //عنوان جذر شجرة معطيات
        FirebaseDatabase.getInstance().getReference().child("Appointments").child(Owner).child(Key).setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        }{
        })
    }
}


}