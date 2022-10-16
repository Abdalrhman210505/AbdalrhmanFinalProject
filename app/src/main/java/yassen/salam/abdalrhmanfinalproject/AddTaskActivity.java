package yassen.salam.abdalrhmanfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import javax.security.auth.Subject;

import yassen.salam.abdalrhmanfinalproject.data.Task;

public class AddTaskActivity extends AppCompatActivity {
    private TextInputEditText etTitle;
    private TextInputEditText etSubject;
    private SeekBar sbImportant;
    private Button btnSave;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle=findViewById(R.id.etTitle);
        etSubject=findViewById(R.id.etSubject);
        sbImportant=findViewById(R.id.sbimportant);
        btnSave=findViewById(R.id.btnsave);
        btnCancel=findViewById(R.id.btncancel);
btnSave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        checkandSave();

    }
});


        }


    private void checkandSave() {
        //استخراج القيم من صفحة الاضافة
        String Title=etTitle.getText().toString();
        String subj=etSubject.getText().toString();
         int imp=sbImportant.getProgress();
        //بناء الكائن واعطائه قيم الصفات
        Task m=new Task();
        m.setTitle(Title);
        m.setSubject(subj);
        m.setTaskImportance(imp);
        //استخراج رقم المميز للمستعملuid
        //user that signed in previously
        String Owner= FirebaseAuth.getInstance().getCurrentUser().getUid();
        m.setOwner(Owner);
    //للمهمة استخراج رقم المميز
        String key= FirebaseDatabase.getInstance().getReference().child("Tasks")//جذر جديد يتم تخزين المهمات بعده
                //اضافة قيمة جديدة
                .child(Owner).push().getKey();
        m.setKey(key);
        //حفظ بالخادم
        //عنوان جذر شجرة المعطيات
        FirebaseDatabase.getInstance().getReference().child("Tasks").child(Owner).child(key).setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {
                if (task.isSuccessful()) {
                    finish();
                    Toast.makeText(AddTaskActivity.this, "Added Succesfully", Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(AddTaskActivity.this, "Add Field", Toast.LENGTH_SHORT).show();
            }



    });}
}
