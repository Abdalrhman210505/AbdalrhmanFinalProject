package yassen.salam.abdalrhmanfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
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
    btnsave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkandsave();
        }
    });
    }

    private void checkandsave() {
        String email = hEmail.getText().toString();
        String password = hPassword.getText().toString();
        String confirm = hConfirm.getText().toString();

        boolean isOk=true;
        if (email.length()*password.length()*confirm.length()==0){
            hEmail.setError("one of the files are emtpy");
            isOk=false;

        }
        if (password.equals(confirm)==false){
            hConfirm.setError("password doesnt match");
            isOk=false;

        }
        if (isOk){
            FirebaseAuth auth=FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUpActivity.this, "creation is successful", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "creation field"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}
