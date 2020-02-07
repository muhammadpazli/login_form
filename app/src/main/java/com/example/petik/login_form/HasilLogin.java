package com.example.petik.login_form;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class HasilLogin extends AppCompatActivity implements View.OnClickListener {

    private TextView txtUsername,txtPassword;
    private Button keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_login);

        txtUsername = (TextView)findViewById(R.id.txthasiluser);
        txtPassword = (TextView)findViewById(R.id.txthasilpass);

        Intent i = getIntent();
        String txthasiluser = i.getStringExtra("username");
        String txthasilpass = i.getStringExtra("password");

        txtUsername.setText(txthasiluser.toString());
        txtPassword.setText(txthasilpass.toString());

        keluar = (Button) findViewById(R.id.btnExit);
        keluar.setOnClickListener(this);
    }

    public void onClick(View clicked) {
        switch (clicked.getId()) {
            case R.id.btnExit:
                exit();
                break;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //jika tombol BACK ditekan
        if(keyCode == KeyEvent.KEYCODE_BACK){
            exit();
        }
        return super.onKeyDown(keyCode,event );
    }
    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Apakah Kamu Benar-Benar ingin keluar?")
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}


