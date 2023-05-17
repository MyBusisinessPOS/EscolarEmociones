package com.example.escolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.UsuariosDao;

public class LoginActivity extends AppCompatActivity {

    EditText editTextCorreo, editTextPassword;
    Button button_registrar;
    Button button_login;

    Switch remember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciaControles();
    }

    private void iniciaControles() {

        button_registrar = findViewById(R.id.button_registrar);
        button_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = editTextCorreo.getText().toString();
                String password = editTextPassword.getText().toString();

                if (usuario.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Ingrese el correo", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }
                final UsuariosDao usuariosDao = new UsuariosDao();
                final UsuariosBean usuarioBean = usuariosDao.login(usuario, password);
                if (usuarioBean != null) {

                    usuarioBean.setIsLogin(1);
                    usuariosDao.save(usuarioBean);

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
        editTextCorreo = findViewById(R.id.correo);
        editTextPassword = findViewById(R.id.password);
    }


    @Override
    protected void onStart() {
        super.onStart();
        final UsuariosDao usuariosDao = new UsuariosDao();
        final UsuariosBean usuarioBean = usuariosDao.isLogin();
        if (usuarioBean != null){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}