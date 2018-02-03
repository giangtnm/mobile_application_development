package vn.edu.uit.giangtnm.lab03_1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Dialog with 1 button
//        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        // Dialog with 3 buttons
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        alertDialog.setTitle("Demo Alert Dialog");
        alertDialog.setMessage("Dialog with button(s)");
        alertDialog.setIcon(R.mipmap.ic_launcher);

        // Dialog with 1 button
//        alertDialog.setButton(
//                AlertDialog.BUTTON_NEGATIVE, "OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity.this,
//                                "You clicked on OK", Toast.LENGTH_SHORT).show();
//                    }
//                });

        //Dialog with 3 buttons
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,
                        "You clicked on YES", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,
                        "You clicked on NO", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setNeutralButton("SKIP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,
                        "You clicked on SKIP", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }
}
