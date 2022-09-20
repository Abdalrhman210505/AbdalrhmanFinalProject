package yassen.salam.abdalrhmanfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivty extends AppCompatActivity {
    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private Button btnsignin;
    private Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnsignin = findViewById(R.id.btnsignin);
        btnsignup = findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivty.this, SignUpActivity.class);
                startActivity(i);

            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkandsave();
            }
        });
    }

    private void checkandsave() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        boolean isOk = true;
        if (email.length() == 0) {
            etEmail.setError("enter your email");
            isOk = false;
        }
        if (password.length() == 0) {
            etPassword.setError("enter your Password");
            isOk = false;
        }
        if (email.indexOf('@') <= 0) {
            etEmail.setError("wrong Email");
            isOk = false;

        }
        if (password.length() >= 7) {
            etPassword.setError("Password at least require 7 letters");
            isOk = false;


        }
        if (isOk) {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignInActivty.this, "Successful", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(SignInActivty.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else {
                        Toast.makeText(SignInActivty.this, "NotSuccessful"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
    }
}