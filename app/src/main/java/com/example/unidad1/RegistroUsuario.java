package com.example.unidad1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroUsuario extends AppCompatActivity {

    Button btnRegister;
    EditText txtUserName, txtEmail, txtPass, txtDocuments;
    TextView link_to_login, register_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtDocuments = findViewById(R.id.txtDocuments);
        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);

        register_error = findViewById(R.id.register_error);
        link_to_login = findViewById(R.id.link_to_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQlite admin = new AdminSQlite(getApplicationContext(), "Admin", null, 1 );
                SQLiteDatabase db = admin.getWritableDatabase();

                String name = txtUserName.getText().toString();
                int documento = Integer.parseInt(txtDocuments.getText().toString());
                String email = txtEmail.getText().toString();
                String password  = txtPass.getText().toString();

                ContentValues Datos = new ContentValues();
                Datos.put("documento", documento);
                Datos.put("nombre", name);
                Datos.put("correo", email);
                Datos.put("Contraseña", password);

                db.insert("usuario", null, Datos);
                db.close();

                Intent intent = new Intent (v.getContext(), Inicio.class);
                startActivityForResult(intent,  0);
            }
        });

        link_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}





