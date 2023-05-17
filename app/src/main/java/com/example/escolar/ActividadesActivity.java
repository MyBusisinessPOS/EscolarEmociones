package com.example.escolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.escolar.database.Utils;
import com.example.escolar.database.bean.ActividadBean;
import com.example.escolar.database.bean.EmocionesBean;
import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.ActividadesDao;
import com.example.escolar.database.dao.EmocionesDao;
import com.example.escolar.database.dao.UsuariosDao;

public class ActividadesActivity extends AppCompatActivity {

    Button btnSiguiente;

    private ImageView ImageViewBuenSuenio, ImageViewMedioSuenio, ImageViewMalSuenio, ImageViewDormirTarde, ImageViewDepertarTemprano;

    private ImageView ImageViewPelis, ImageViewLeer, ImageViewPintar, ImageViewFitnes, ImageViewJugar, ImageViewDeportivo;

    private ImageView ImageViewDepresivo, ImageViewAncioso, ImageViewDolorCabeza, ImageViewEstres, ImageViewEnfermo, ImageViewPeriodo;

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        iniciaControles();
    }

    private void iniciaControles(){
        ImageViewBuenSuenio = findViewById(R.id.ImageViewBuenSuenio);
        ImageViewBuenSuenio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Buen sueño", Toast.LENGTH_SHORT).show();
                guardaActualiza("Buen sueño", "Domir");
            }
        });

        ImageViewMedioSuenio = findViewById(R.id.ImageViewMedioSuenio);
        ImageViewMedioSuenio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Medio sueño", Toast.LENGTH_SHORT).show();
                guardaActualiza("Medio sueño", "Domir");
            }
        });


        ImageViewMalSuenio = findViewById(R.id.ImageViewMalSuenio);
        ImageViewMalSuenio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Mal sueño", Toast.LENGTH_SHORT).show();
                guardaActualiza("Mal sueño", "Domir");
            }
        });

        ImageViewDormirTarde = findViewById(R.id.ImageViewDormirTarde);
        ImageViewDormirTarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Dormir tarde", Toast.LENGTH_SHORT).show();
                guardaActualiza("Dormir tarde", "Domir");
            }
        });

       ImageViewDepertarTemprano = findViewById(R.id.ImageViewDepertarTemprano);
        ImageViewDepertarTemprano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Dormir temprano", Toast.LENGTH_SHORT).show();

                guardaActualiza("Dormir temprano", "Domir");
            }
        });


        //Habitos
        ImageViewPelis = findViewById(R.id.ImageViewPelis);
        ImageViewPelis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Pelis y TV", Toast.LENGTH_SHORT).show();
                guardaActualiza("Pelis y TV", "Habitos");
            }
        });
        ImageViewLeer = findViewById(R.id.ImageViewLeer);
        ImageViewLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Leer", Toast.LENGTH_SHORT).show();
                guardaActualiza("Leer", "Habitos");
            }
        });
        ImageViewPintar = findViewById(R.id.ImageViewPintar);
        ImageViewPintar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Pintar", Toast.LENGTH_SHORT).show();
                guardaActualiza("Pintar", "Habitos");
            }
        });
        ImageViewFitnes = findViewById(R.id.ImageViewFitnes);
        ImageViewFitnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Fitnes", Toast.LENGTH_SHORT).show();
                guardaActualiza("Fitnes", "Habitos");
            }
        });
        ImageViewJugar = findViewById(R.id.ImageViewJugar);
        ImageViewJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Jugar", Toast.LENGTH_SHORT).show();
                guardaActualiza("Jugar", "Habitos");
            }
        });
        ImageViewDeportivo = findViewById(R.id.ImageViewDeportivo);
        ImageViewDeportivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Deportivo", Toast.LENGTH_SHORT).show();
                guardaActualiza("Deportivo", "Habitos");
            }
        });

        //Salud
        ImageViewDepresivo = findViewById(R.id.ImageViewDepresivo);
        ImageViewDepresivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Depresivo", Toast.LENGTH_SHORT).show();

                guardaActualiza("Depresivo", "Salud");
            }
        });

        ImageViewAncioso = findViewById(R.id.ImageViewAncioso);
        ImageViewAncioso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Ancioso", Toast.LENGTH_SHORT).show();

                guardaActualiza("Ancioso", "Salud");
            }
        });

        ImageViewDolorCabeza = findViewById(R.id.ImageViewDolorCabeza);
        ImageViewDolorCabeza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Dolor de cabeza", Toast.LENGTH_SHORT).show();

                guardaActualiza("Dolor de cabeza", "Salud");
            }
        });

        ImageViewEstres = findViewById(R.id.ImageViewEstres);
        ImageViewEstres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Estres", Toast.LENGTH_SHORT).show();

                guardaActualiza("Estres", "Salud");
            }
        });

        ImageViewEnfermo = findViewById(R.id.ImageViewEnfermo);
        ImageViewEnfermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Enfermo", Toast.LENGTH_SHORT).show();

                guardaActualiza("Enfermo", "Salud");
            }
        });

        ImageViewPeriodo = findViewById(R.id.ImageViewPeriodo);
        ImageViewPeriodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(ActividadesActivity.this, "Periodo", Toast.LENGTH_SHORT).show();

                guardaActualiza("Periodo", "Salud");
            }
        });

        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count >= 3){
                    Intent intent = new Intent(ActividadesActivity.this, AlimentoActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(ActividadesActivity.this, "Debe se selecionar almenos un elemnto por cada emoción", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    private void guardaActualiza(String actividad, String categoria){
        final UsuariosDao usuariosDao = new UsuariosDao();
        final UsuariosBean usuariosBean = usuariosDao.isLogin();

        if (usuariosBean != null) {
            final ActividadesDao actividadesDao = new ActividadesDao();
            final ActividadBean actividadBean = actividadesDao.actividadesPorUsuario(usuariosBean.getId(), Utils.fechaActual(), categoria);
            if (actividadBean == null){
                final ActividadBean bean = new ActividadBean();
                final ActividadesDao dao = new ActividadesDao();
                bean.setFecha(Utils.fechaActual());
                bean.setActividad(actividad);
                bean.setCategoria(categoria);
                bean.setIdUsuario(usuariosBean.getId());
                dao.save(bean);
            }else{
                actividadBean.setActividad(actividad);
                actividadesDao.save(actividadBean);
            }
        }
    }
}