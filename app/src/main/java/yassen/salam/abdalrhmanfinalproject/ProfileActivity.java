package yassen.salam.abdalrhmanfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import yassen.salam.abdalrhmanfinalproject.data.Profile;

public class ProfileActivity extends AppCompatActivity {
private EditText proName;
private EditText prophone;
private RadioButton prord1;
private RadioButton prord2;
private EditText proidentity;
private Button bSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);
        proName=findViewById(R.id.proname);
        prophone=findViewById(R.id.prophone);
        proidentity=findViewById(R.id.proidentity);
        prord1=findViewById(R.id.prord1);
        prord2=findViewById(R.id.prord2);
        bSave=findViewById(R.id.bSave);
        readTaskFromFirebase();
        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckAndSave();
            }
        });
    }
    public void CheckAndSave(){
        String Name=proName.getText().toString();
        String Phone=prophone.getText().toString();
        String Identity=proName.getText().toString();
        Boolean Manual=prord1.isChecked();
        Boolean Automatic=prord2.isChecked();
        Profile profile=new Profile();
        profile.setIdentity(Identity);
        String owner= FirebaseAuth.getInstance().getCurrentUser().getUid();
        profile.setOwner(owner);
        profile.setPhoneNumber(Phone);
        profile.setRbAutomatic(Automatic);
        profile.setRbManual(Manual);
        profile.setName(Name);
        FirebaseDatabase.getInstance().getReference().child("profile").child(owner).setValue(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    finish();
                    Toast.makeText(ProfileActivity.this, "Saved Succesfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ProfileActivity.this, "save failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void readTaskFromFirebase(){
        String owner=FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference().child("profile").child(owner).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshot.getChildren();
                for (DataSnapshot d:snapshot.getChildren()){
                    Profile profile1=d.getValue(Profile.class);
                    proidentity.setText(profile1.getIdentity());
                    prophone.setText(profile1.getPhoneNumber());
                    proName.setText(profile1.getName());
                    prord1.setText(profile1.getRbAutomatic().toString());
                    prord2.setText(profile1.getRbManual().toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}