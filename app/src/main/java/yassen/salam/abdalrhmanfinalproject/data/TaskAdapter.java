package yassen.salam.abdalrhmanfinalproject.data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import yassen.salam.abdalrhmanfinalproject.R;
public class TaskAdapter extends ArrayAdapter {

    public TaskAdapter(@NonNull Context context) {
        super(context, R.layout.task_item);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
}
