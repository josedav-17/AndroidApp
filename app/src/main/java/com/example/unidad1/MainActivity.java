package com.example.unidad1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, link_to_register;
    EditText txtEmail, txtPass;
    TextView login_error;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtPass = (EditText)findViewById(R.id.txtPass);

        link_to_register = (Button)findViewById(R.id.link_to_register);
        login_error = (TextView)findViewById(R.id.login_error);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQlite admin = new AdminSQlite(getApplicationContext(), "Admin", null, 1 );
                SQLiteDatabase db = admin.getWritableDatabase();

                String email = txtEmail.getText().toString();
                String password  = txtPass.getText().toString();

                Cursor fila = db.rawQuery("select Email, pass from usuario where Email='" +
                        email + "' and pass ='" + password + "'", null);

                if(fila.moveToFirst()){
                    String txtEmail=fila.getString(0);
                    String txtPass=fila.getString(1);
                    if (txtEmail.equals(email) && txtPass.equals(password)) {
                        Intent i = new Intent(MainActivity.this, EsperaActivity.class);
                        startActivity(i);
                    }
                }
            }
        });


        link_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), RegistroUsuario.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}