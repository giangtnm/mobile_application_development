package vn.edu.uit.giangtnm.lab02_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

import vn.edu.uit.giangtnm.lab02_3.model.Employee;
import vn.edu.uit.giangtnm.lab02_3.model.EmployeeFulltime;
import vn.edu.uit.giangtnm.lab02_3.model.EmployeeParttime;

public class MainActivity extends AppCompatActivity {

    private EditText etId, etName;
    private Button btnSubmit;
    private RadioGroup rgType;
    private ListView lvEmployee;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayAdapter<Employee> adapter = null;
    //Declare Employee object
    private Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = (EditText) findViewById(R.id.et_ma_nv);
        etName = (EditText) findViewById(R.id.et_ten_nv);
        btnSubmit = (Button) findViewById(R.id.btn_nhap);
        rgType = (RadioGroup) findViewById(R.id.rg_loai_nv);
        lvEmployee = (ListView) findViewById(R.id.lv_nv);

        //import employee to Adapter
        adapter = new ArrayAdapter<Employee>(
                this, android.R.layout.simple_list_item_1, employees);

        //set adapter to ListView
        lvEmployee.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewEmployee();
            }
        });

        lvEmployee.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                employees.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    // handle after press button submit
    public void addNewEmployee() {
        //get correct id from checked Radio Button
        int radId = rgType.getCheckedRadioButtonId();
        String id = etId.getText().toString();
        String name = etName.getText().toString();

        if (radId == R.id.rd_chinhthuc)
            employee = new EmployeeFulltime();
        else
            employee = new EmployeeParttime();

        //EmployeeFullTime and PartTime are both employee
        employee.setId(id);
        employee.setName(name);
        //add employee to ArrayList
        employees.add(employee);
        //Update layout
        adapter.notifyDataSetChanged();
    }
}
