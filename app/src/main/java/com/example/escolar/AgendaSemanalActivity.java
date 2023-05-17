package com.example.escolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.escolar.database.Utils;
import com.example.escolar.database.bean.DiariosBean;
import com.example.escolar.database.bean.EmocionesBean;
import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.DiariosDao;
import com.example.escolar.database.dao.EmocionesDao;
import com.example.escolar.database.dao.UsuariosDao;

public class AgendaSemanalActivity extends AppCompatActivity {

    private RadioGroup radio_group_tristeza, radio_group_felicidad, radio_group_enojo, radio_group_angustia, radio_group_miedo, radio_group_amor, radio_group_calma, radio_group_anciedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_semanal);
        iniciaControles();
    }


    private void iniciaControles(){
        radio_group_tristeza = findViewById(R.id.radio_group_tristeza);
        radio_group_tristeza.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedDay = radioButton.getText().toString();
                guardaActualiza("Tristeza");
                String mood = "Tristeza";
                Toast.makeText(AgendaSemanalActivity.this, "Estado de ánimo registrado: " + mood + " - " + selectedDay, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AgendaSemanalActivity.this, ActividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });


        radio_group_felicidad = findViewById(R.id.radio_group_felicidad);
        radio_group_felicidad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedDay = radioButton.getText().toString();
                String mood = "Felicidad";
                guardaActualiza("Felicidad");
                Toast.makeText(AgendaSemanalActivity.this, "Estado de ánimo registrado: " + mood + " - " + selectedDay, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AgendaSemanalActivity.this, ActividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        radio_group_enojo = findViewById(R.id.radio_group_enojo);
        radio_group_enojo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedDay = radioButton.getText().toString();
                String mood = "Enojo";
                guardaActualiza("Enojo");
                Toast.makeText(AgendaSemanalActivity.this, "Estado de ánimo registrado: " + mood + " - " + selectedDay, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AgendaSemanalActivity.this, ActividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        radio_group_angustia = findViewById(R.id.radio_group_angustia);
        radio_group_angustia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedDay = radioButton.getText().toString();
                String mood = "Angustia";
                guardaActualiza("Angustia");
                Toast.makeText(AgendaSemanalActivity.this, "Estado de ánimo registrado: " + mood + " - " + selectedDay, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AgendaSemanalActivity.this, ActividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });

        radio_group_miedo = findViewById(R.id.radio_group_miedo);
        radio_group_miedo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedDay = radioButton.getText().toString();
                String mood = "Miedo";
                guardaActualiza("Miedo");
                Toast.makeText(AgendaSemanalActivity.this, "Estado de ánimo registrado: " + mood + " - " + selectedDay, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AgendaSemanalActivity.this, ActividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });


        radio_group_amor = findViewById(R.id.radio_group_amor);
        radio_group_amor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedDay = radioButton.getText().toString();
                String mood = "Amor";
                guardaActualiza("Amor");
                Toast.makeText(AgendaSemanalActivity.this, "Estado de ánimo registrado: " + mood + " - " + selectedDay, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AgendaSemanalActivity.this, ActividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        radio_group_calma = findViewById(R.id.radio_group_calma);
        radio_group_calma.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedDay = radioButton.getText().toString();
                String mood = "Calma";
                guardaActualiza("Calma");
                Toast.makeText(AgendaSemanalActivity.this, "Estado de ánimo registrado: " + mood + " - " + selectedDay, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AgendaSemanalActivity.this, ActividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        radio_group_anciedad = findViewById(R.id.radio_group_anciedad);
        radio_group_anciedad.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String selectedDay = radioButton.getText().toString();
                String mood = "Anciedad";
                guardaActualiza("Anciedad");
                Toast.makeText(AgendaSemanalActivity.this, "Estado de ánimo registrado: " + mood + " - " + selectedDay, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AgendaSemanalActivity.this, ActividadesActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void guardaActualiza(String emocion){
        final UsuariosDao usuariosDao = new UsuariosDao();
        final UsuariosBean usuariosBean = usuariosDao.isLogin();

        if (usuariosBean != null) {
            final EmocionesDao emocionesDao = new EmocionesDao();
            final EmocionesBean emocionesBean = emocionesDao.emocionesPorUsuario(usuariosBean.getId(), Utils.fechaActual());
            if (emocionesBean == null){
                final EmocionesBean bean = new EmocionesBean();
                final EmocionesDao dao = new EmocionesDao();
                bean.setFecha(Utils.fechaActual());
                bean.setEmocion(emocion);
                bean.setIdUsuario(usuariosBean.getId());
                dao.save(bean);
            }else{
                emocionesBean.setEmocion(emocion);
                emocionesDao.save(emocionesBean);
            }
        }
    }
}