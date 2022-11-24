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
        TextView tvName=vitem.findViewById(R.id.tvName);
        TextView tvNumberOfclass=vitem.findViewById(R.id.tvNumberOfclass);
        CheckBox checkbox=vitem.findViewById(R.id.checkBox);
        CheckBox checkbox2=vitem.findViewById(R.id.checkBox2);
//getting data source
        final Appointment appointment=getItem(position);
        tvName.setText(appointment.getNameofstudent());
//day month year format (convert class date to string without any problems)
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(appointment.getDate());

        tvDate.setText(date);
      //convert the time from class Time to string
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String time = dateFormat.format(appointment.getTime());
        tvTime.setText(time);
        tvNumberOfclass.setText(appointment.getNumberOfClass());
        tvPhone.setText(appointment.getPhoneNumber());
        tvType.setText(appointment.getType());
       // checkbox.setChecked(false);
        //checkbox.setOnCheckedChangeListener(new );
        //checkbox2.setChecked(false);
        //checkbox2.setOnCheckedChangeListener();

        //checkbox.setOnCheckedChangeListener;

        return vitem;

    }
}


