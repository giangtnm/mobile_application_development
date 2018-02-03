package vn.edu.uit.giangtnm.lab03_3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnDialog;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog = (Button) findViewById(R.id.btn_dialog);
        tvContent = (TextView) findViewById(R.id.tv_content);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                View customDialogView = li.inflate(R.layout.custom_dialog, null);

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                alertDialogBuilder.setView(customDialogView);

                final EditText etName = (EditText) customDialogView.findViewById(R.id.et_username);
                final EditText etPass = (EditText) customDialogView.findViewById(R.id.et_password);
                Button btnSignIn = (Button) customDialogView.findViewById(R.id.btn_sign_in);
                Button btnCancel = (Button) customDialogView.findViewById(R.id.btn_cancel);

//                alertDialogBuilder.setCancelable(false).setPositiveButton("Sign in",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                tvContent.setText("Your name: " + etName.getText().toString());
//                            }
//                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });

                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                btnSignIn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvContent.setText("Your name: " + etName.getText().toString());
                        alertDialog.cancel();
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
            }
        });
    }
}
