package yassen.salam.abdalrhmanfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {
    private TextInputEditText hEmail;
    private TextInputEditText hPassword;
    private TextInputEditText hConfirm;
    private Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        hEmail=findViewById(R.id.hEmail);
        hPassword=findViewById(R.id.hPass);
        hConfirm=findViewById(R.id.hConfirm);
        btnsave=findViewById(R.id.btnsave);
    }

}