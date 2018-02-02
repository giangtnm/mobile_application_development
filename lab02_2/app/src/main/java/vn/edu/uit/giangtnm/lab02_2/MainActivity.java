package vn.edu.uit.giangtnm.lab02_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    TextView tvSelection;
    Button btnSubmit;
    ListView lvPerson;
    ArrayList<String> names = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.et_name);
        tvSelection = (TextView) findViewById(R.id.tv_selection);
        lvPerson = (ListView) findViewById(R.id.lv_person);
        btnSubmit = (Button) findViewById(R.id.btn_nhap);

        //Create ArrayList object
        names = new ArrayList<String>();

        //assign Data source (ArrayList object) to ArrayAdapter
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        // assign Adapter to ListView
        lvPerson.setAdapter(adapter);

        // execute event after press button
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names.add(etName.getText().toString());
                etName.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        // execute event after choose element
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvSelection.setText("position: " + i + "; value = " + names.get(i));
            }
        });

        //execute event after Long click
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                names.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
