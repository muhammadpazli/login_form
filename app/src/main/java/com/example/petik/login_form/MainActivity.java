package com.example.petik.login_form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {
    private Button btnlng;
    private EditText inuser, inpass;
    //public String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inuser = (EditText) findViewById(R.id.inuser);
        inpass  = (EditText) findViewById(R.id.inpass);

        btnlng = (Button)findViewById(R.id.btnlng);
        btnlng.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (inuser.getText().toString().equals("erji") && inpass.getText().toString().equals("123")){
                    Toast.makeText(getApplicationContext(),"Anda Login Sebagai : "+ inuser.getText().toString() + " dan Password : "+inpass.getText().toString(),Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, HasilLogin.class);
                    i.putExtra("username",inuser.getText().toString());
                    i.putExtra("password",inpass.getText().toString());
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Username dan Pssword tidak sesuai Anda gagal Login",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

