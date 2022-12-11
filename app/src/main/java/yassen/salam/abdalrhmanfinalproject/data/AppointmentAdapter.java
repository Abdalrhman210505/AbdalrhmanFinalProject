package yassen.salam.abdalrhmanfinalproject.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.appointment_item,parent,false);
        TextView tvTime=vitem.findViewById(R.id.tvTime);
        TextView tvDate=vitem.findViewById(R.id.tvDate);
        TextView tvType=vitem.findViewById(R.id.tvType);
        TextView tvPhone=vitem.findViewById(R.id.tvPhone);
        TextView tvIdentity=vitem.findViewById(R.id.tvIdentity);
        TextView tvName=vitem.findViewById(R.id.tvName);
        TextView tvNumberOfclass=vitem.findViewById(R.id.tvNumberOfclass);
         TextView textView1=vitem.findViewById(R.id.textView1);

//getting data source
        final Appointment appointment=getItem(position);
        tvName.setText("Name:  "+appointment.getNameofstudent());
//day month year format (convert class date to string without any problems)
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      //  String date = simpleDateFormat.format(appointment.getDate());
//todo use as date object
        tvDate.setText("Date:  "+appointment.getDate());
      //convert the time from class Time to string
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);
       // String time = dateFormat.format(appointment.getTime());
        tvTime.setText("Time:  "+appointment.getTime());
       // tvNumberOfclass.setText("NumberOfClass:  "+appointment.getNumberOfClass());
        tvPhone.setText("PhoneNumber:  "+appointment.getPhoneNumber());
        tvIdentity.setText("Identity:  "+appointment.getIdentity());
        //tvType.setText("Type:"+appointment.getType());
        if (appointment.getManualType()==true){
            tvType.setText("Manual");
        }
        if (appointment.getAutomaticType()==true){
            tvType.setText("Automatic");
        }





        return vitem;

    }
}


