package yassen.salam.abdalrhmanfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.sql.Date;
import java.sql.Time;

public class AddAppointmentActvity extends AppCompatActivity {
private TextInputEditText etName;// name of student
private Time time;
private Date date;
private TextInputEditText etIdentity;//identity number
private TextInputEditText etPhone;//student phone number
private TextInputEditText etType;//type of licence that student wants to learn
private Button btnSave;
private Button btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment_actvity);
        etName=findViewById(R.id.etName);
        time=findViewById(R.id.editTextTime2);
        date=findViewById(R.id.editTextDate);
        etIdentity=findViewById(R.id.etIdentity);
        etPhone=findViewById(R.id.etPhone);
        etType=findViewById(R.id.etType);
        btnSave=findViewById(R.id.btnsave);
        btnCancel=findViewById(R.id.btncancel);
btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        checkandSave();
    }
});
    }

}