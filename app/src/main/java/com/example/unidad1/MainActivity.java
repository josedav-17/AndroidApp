package com.example.unidad1;

import android.content.Intent;
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
                if(txtEmail.getText().toString().equals("admin@admin.com") &&
                        txtPass.getText().toString().equals("admin")) {
                    Intent intent = new Intent (v.getContext(), Inicio.class);
                    startActivityForResult(intent,  0);

                }else{
                    txtEmail.setVisibility(View.VISIBLE);
                    txtEmail.setBackgroundColor(Color.RED);
                    counter--;
                    txtEmail.setText(Integer.toString(counter));

                    if (counter == 0) {
                        btnLogin.setEnabled(false);
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