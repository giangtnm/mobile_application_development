package vn.edu.uit.giangtnm.lab01_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("ActivityStatus", "Create");

        //View by id
        Button btnTest01 = (Button) findViewById(R.id.btn_test);

        //Handle click event
        btnTest01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iSubActivity01 = new Intent(MainActivity.this, SubActivity.class);
                startActivity(iSubActivity01);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityStatus", "Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityStatus", "Pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityStatus", "Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityStatus", "Resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityStatus", "Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityStatus", "Stop");
    }
}
