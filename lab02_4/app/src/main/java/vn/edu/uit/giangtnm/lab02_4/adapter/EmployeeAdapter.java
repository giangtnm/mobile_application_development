package vn.edu.uit.giangtnm.lab02_4.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import vn.edu.uit.giangtnm.lab02_4.R;
import vn.edu.uit.giangtnm.lab02_4.model.Employee;

/**
 * Created by giangtnm on 2/3/18.
 */

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Activity context;

    public EmployeeAdapter(Activity context, int layoutID, List<Employee> objects) {
        super(context, layoutID, objects);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_employee, null, false);

        // Get item
        Employee employee = getItem(position);

        // Get view
    }
}
