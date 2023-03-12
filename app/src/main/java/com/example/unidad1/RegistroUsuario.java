package com.example.unidad1;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroUsuario extends AppCompatActivity {

    Button btnRegister;
    EditText txtUserName, txtEmail, txtPass;
    TextView link_to_login, register_error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtUserName = findViewById(R.id.txtUserName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        register_error = findViewById(R.id.register_error);
        link_to_login = findViewById(R.id.link_to_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtEmail.getText().toString()
                        txtPass.getText().toString().equals(txtPass)) {
                    Intent intent = new Intent (v.getContext(), Inicio.class);
                    startActivityForResult(intent,  0);

                }else{
                    System.out.println("debe llenar los campos");
                }
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





