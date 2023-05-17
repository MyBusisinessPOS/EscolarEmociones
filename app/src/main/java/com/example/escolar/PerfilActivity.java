package com.example.escolar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.UsuariosDao;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextEdad, editTextFecha, editTextCorreo;
    private CircleImageView perfil_edit_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_perfil);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Perfil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iniciaControles();

    }

    private void iniciaControles(){
        editTextNombre = findViewById(R.id.perfil_usuario);
        editTextEdad = findViewById(R.id.perfil_edad);
        editTextFecha = findViewById(R.id.perfil_fecha);
        editTextCorreo = findViewById(R.id.perfil_correo);
        perfil_edit_img = findViewById(R.id.perfil_edit_img);
        final UsuariosDao usuariosDao = new UsuariosDao();
        final UsuariosBean usuarioBean = usuariosDao.isLogin();
        if (usuarioBean != null){
            editTextNombre.setText("" + usuarioBean.getNombre());
            editTextEdad.setText("" + usuarioBean.getEdad());
            editTextFecha.setText("" + usuarioBean.getFecha_nacimiento());
            editTextCorreo .setText("" + usuarioBean.getCorreo());
            String imagePath = usuarioBean.getPath_image();
            Uri imageUri = Uri.fromFile(new File(imagePath));
            perfil_edit_img.setImageURI(imageUri);
        }else {
            Toast.makeText(PerfilActivity.this, "No se encontrol el usuario", Toast.LENGTH_SHORT).show();
        }
    }
}