package yassen.salam.abdalrhmanfinalproject.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import yassen.salam.abdalrhmanfinalproject.R;

/**وسيط فقط من نوع مهمات
 *
 */
public class TaskAdapter extends ArrayAdapter<Appointment> {

    public TaskAdapter(@NonNull Context context) {
        super(context, R.layout.task_item);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //building item view
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.task_item,parent,false);
        TextView tvTitle=vitem.findViewById(R.id.tvTitle);
        TextView tvSubject=vitem.findViewById(R.id.tvSubject);
        RatingBar rb=vitem.findViewById(R.id.rb);
        CheckBox checkbox=vitem.findViewById(R.id.checkbox);
        ImageView iinfo=vitem.findViewById(R.id.iinfo);
//getting data source
        final Appointment appointment=getItem(position);
        tvTitle.setText(appointment.getTitle());
        tvSubject.setText(appointment.getSubject());
        rb.setRating(appointment.getTaskImportance());
        checkbox.setChecked(false);
       // checkbox.setOnCheckedChangeListener;

        return vitem;

    }
}


