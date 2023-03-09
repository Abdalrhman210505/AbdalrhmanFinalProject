package yassen.salam.abdalrhmanfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Profile extends AppCompatActivity {
private EditText proName;
private EditText prophone;
private RadioButton prord1;
private RadioButton prord2;
private EditText proidentity;
private Button bSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        proName=findViewById(R.id.proname);
        prophone=findViewById(R.id.prophone);
        proidentity=findViewById(R.id.proidentity);
        prord1=findViewById(R.id.prord1);
        prord2=findViewById(R.id.prord2);
        bSave=findViewById(R.id.bSave);
    }
    public void CheckAndSave(){
        String Name=proName.getText().toString();
        String Phone=prophone.getText().toString();
        String Identity=proName.getText().toString();
        String Name=proName.getText().toString();
    }
}