package vn.edu.uit.giangtnm.lab03_4;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.giangtnm.lab03_4.adapter.DbAdapter;

public class MainActivity extends AppCompatActivity {

    private DbAdapter dbAdapter;
    private Cursor cursor;
    private List<String> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
        dbAdapter.deleteAllUsers();

        for (int i = 0; i < 15; i++)
            dbAdapter.createUser("Nguyễn Văn An " + i);

        users = getData();
        showData();
    }

    private List<String> getData() {
        List<String> users = new ArrayList<>();

        cursor = dbAdapter.getAllUsers();
        while (cursor.moveToNext())
            users.add(cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_NAME)));

        return users;
    }

    private void showData() {
        ListView lvUser = (ListView) findViewById(R.id.lv_user);
        ArrayAdapter<String> userAdapter = new ArrayAdapter<String>(
                MainActivity.this, R.layout.item_user, users);
        lvUser.setAdapter(userAdapter);
    }
}
