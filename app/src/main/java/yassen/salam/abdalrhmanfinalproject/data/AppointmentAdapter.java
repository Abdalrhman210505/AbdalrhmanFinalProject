package yassen.salam.abdalrhmanfinalproject.data;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AlertDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import yassen.salam.abdalrhmanfinalproject.AddAppointmentActvity;
import yassen.salam.abdalrhmanfinalproject.R;

/**وسيط فقط من نوع مهمات
 *
 */
public class AppointmentAdapter extends ArrayAdapter<Appointment> {

    public AppointmentAdapter(@NonNull Context context) {
        super(context, R.layout.appointment_item);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //building item view
        View vitem = LayoutInflater.from(getContext()).inflate(R.layout.appointment_item, parent, false);
        TextView tvTime = vitem.findViewById(R.id.tvTime);
        TextView tvDate = vitem.findViewById(R.id.tvDate);
        TextView tvType = vitem.findViewById(R.id.tvType);

        TextView tvIdentity = vitem.findViewById(R.id.tvIdentity);
        TextView tvName = vitem.findViewById(R.id.tvName);
        TextView tvNumberOfclass = vitem.findViewById(R.id.tvNumberOfclass);
        TextView textView1 = vitem.findViewById(R.id.textView1);
        Button bEdit = vitem.findViewById(R.id.bEdit);
        Button bDelete = vitem.findViewById(R.id.bDelete);


//getting data source
        final Appointment appointment = getItem(position);
        tvName.setText("Name:  " + appointment.getNameofstudent());
//day month year format (convert class date to string without any problems)
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
         String date = simpleDateFormat.format(appointment.getTime());
//todo use as date object
        tvDate.setText("Date:  " + date);
        //convert the time from class Time to string
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);
         String time = dateFormat.format(appointment.getTime());
        tvTime.setText("Time:  " + time);
        // tvNumberOfclass.setText("NumberOfClass:  "+appointment.getNumberOfClass());
        tvIdentity.setText("Identity:  " + appointment.getIdentity());
        textView1.setText("Location:  "+appointment.getLocation());








        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //because thats not an acivity so we use context
                Intent i = new Intent(getContext(), AddAppointmentActvity.class);
                i.putExtra("Appointment",appointment);//here the code send the same Object with same proporities
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(i);
            }
        });
        bDelete.setOnClickListener(new View.OnClickListener() {// دالة تحذف الكائن appointment لتي اضيفت ل ال list
            //function that delete the object
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                builder1.setTitle("Are u Sure u want to delete");
                builder1.setTitle("Are You Sure?");
                builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {//يضيف ال زر النعم
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //اخفاء الديالوج
                        dialogInterface.dismiss();
                        //تسجيل الخروج من الحساب

                        FirebaseDatabase.getInstance().getReference().child("Appointments").child(appointment.getOwner()).child(appointment.getKey()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getContext(), "there is problem with deleting", Toast.LENGTH_SHORT).show();
                                }
                            }


                        });

                        //اخفاء الديالوج
                    }
                });
                builder1.setNegativeButton("no", new DialogInterface.OnClickListener() {//يضيف زر ال no
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                //dialouge building

                AlertDialog dialog1 = builder1.create();
                dialog1.show();

            }
        });



        return vitem;


    }
}