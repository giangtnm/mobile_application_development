package vn.edu.uit.giangtnm.lab02_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create data for arr[] (data source)
        // Data in code java
//        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};
        // Data in xml
        final String arr[] = getResources().getStringArray(R.array.names);

        // Get ListView object based on id
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);

        // Map Data source with ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, arr);

        // set data to ListView
        lvPerson.setAdapter(adapter);

        final TextView tvSelection = (TextView) findViewById(R.id.tv_selection);

        // Create event
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i is the position of element in arr
                tvSelection.setText("position:" + i + " ; value = " + arr[i]);
            }
        });
    }
}
