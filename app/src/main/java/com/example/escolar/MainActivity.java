package com.example.escolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.UsuariosDao;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton button_diario, btn_close_session, button_agenda, button_agenda_semanal, button_resumen;
    MaterialButton button_perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciaControles();
    }

    private void iniciaControles(){

        button_resumen = findViewById(R.id.button_resumen);
        button_resumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResumenActivity.class);
                startActivity(intent);
            }
        });
        button_agenda_semanal = findViewById(R.id.button_agenda_semanal);
        button_agenda_semanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AgendaSemanalActivity.class);
                startActivity(intent);
            }
        });

        button_agenda = findViewById(R.id.button_agenda);
        button_agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AgendaActivity.class);
                startActivity(intent);
            }
        });
        btn_close_session = findViewById(R.id.btn_close_session);
        btn_close_session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final UsuariosDao usuariosDao = new UsuariosDao();
                final UsuariosBean usuarioBean = usuariosDao.isLogin();
                if (usuarioBean != null){
                    usuarioBean.setIsLogin(0);
                    usuariosDao.save(usuarioBean);
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "No se pudo cerrar la sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button_diario = findViewById(R.id.button_diario);
        button_diario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiarioActivity.class);
                startActivity(intent);
            }
        });

        button_perfil = findViewById(R.id.button_perfil);
        button_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
}