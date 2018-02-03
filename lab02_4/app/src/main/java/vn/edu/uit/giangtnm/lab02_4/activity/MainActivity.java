package vn.edu.uit.giangtnm.lab02_4.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.giangtnm.lab02_4.R;
import vn.edu.uit.giangtnm.lab02_4.adapter.EmployeeAdapter;
import vn.edu.uit.giangtnm.lab02_4.model.Employee;

public class MainActivity extends AppCompatActivity {

    private List<Employee> employees;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View by ID
        final EditText etID = (EditText) findViewById(R.id.et_id);
        final EditText etFullName = (EditText) findViewById(R.id.et_fullname);
        final CheckBox cbManager = (CheckBox) findViewById(R.id.cb_manager);
        Button btnAdd = (Button) findViewById(R.id.btn_add);
        ListView lvEmployee = (ListView) findViewById(R.id.lv_employee);

        // Init data
        employees = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(MainActivity.this, 1, employees);

        // Set data for lvEmployee
        lvEmployee.setAdapter(employeeAdapter);

        // Handle clicks btnAdd
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Init new employee
                Employee employee = new Employee();
                employee.setId(etID.getText().toString());
                employee.setFullName(etFullName.getText().toString());
                employee.setManager(cbManager.isChecked());

                // Add new employee to list
                employees.add(employee);

                // Update new data to ListView
                employeeAdapter.notifyDataSetChanged();

                // Remove added data
                etID.setText("");
                etFullName.setText("");
                cbManager.setChecked(false);

                // Focus to etID
                etID.requestFocus();
            }
        });

        lvEmployee.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                employees.remove(i);
                employeeAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
