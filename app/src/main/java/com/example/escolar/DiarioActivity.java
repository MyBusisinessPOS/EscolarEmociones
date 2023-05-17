package com.example.escolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.escolar.database.Utils;
import com.example.escolar.database.bean.DiariosBean;
import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.DiariosDao;
import com.example.escolar.database.dao.UsuariosDao;

public class DiarioActivity extends AppCompatActivity {


    ImageView imageViewMuyMal, imageViewMal, imageViewNormal, imageViewBien, imageViewExcelente;
    TextView textViewEmocion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario);
        iniciaControles();
    }

    private void iniciaControles() {

        textViewEmocion = findViewById(R.id.text_emocion);
        imageViewMuyMal = findViewById(R.id.ImageViewMuyMal);
        imageViewMal = findViewById(R.id.ImageViewMal);
        imageViewNormal = findViewById(R.id.ImageViewNormal);
        imageViewBien = findViewById(R.id.ImageViewBien);
        imageViewExcelente = findViewById(R.id.ImageViewExcelente);

        imageViewMuyMal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSave("muymal");
                Toast.makeText(DiarioActivity.this, "Sentimos que te sientas muy mal", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        imageViewMal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSave("mal");
                Toast.makeText(DiarioActivity.this, "Sentimos que te sientas  mal", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        imageViewNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSave("normal");
                Toast.makeText(DiarioActivity.this, "Nos gusta que te sientas normal", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        imageViewBien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSave("bien");
                Toast.makeText(DiarioActivity.this, "Nos gusta que te sientas bien", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        imageViewExcelente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSave("excelente");
                Toast.makeText(DiarioActivity.this, "Nos encanra que te sientas excelente", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        obtieneOmocionesDeHoy();
    }


    private void obtieneOmocionesDeHoy(){
        final UsuariosDao usuariosDao = new UsuariosDao();
        final UsuariosBean usuariosBean = usuariosDao.isLogin();

        if (usuariosBean != null) {
            final DiariosDao diariosDao = new DiariosDao();
            final DiariosBean diariosBean = diariosDao.emocionesPorUsuario(usuariosBean.getId(), Utils.fechaActual());

            String emocion = "";
            //Actualizamos
            if (diariosBean != null) {
                if (diariosBean.getMuy_mal()){
                    emocion = "Hoy estás muy mal";
                }else if (diariosBean.getMal()){
                    emocion = "Hoy estás mal";
                }
                else if (diariosBean.getNormal()){
                    emocion = "Hoy estás normal";
                }
                else if (diariosBean.getBien()){
                    emocion = "Hoy estás bien";
                }
                else if (diariosBean.getExcelente()){
                    emocion = "Hoy estás excelente";
                }

                textViewEmocion.setText(""+emocion);

            }else {
                Toast.makeText(DiarioActivity.this, "Aun no tienes emociones el dia de hoy", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void updateSave(String emocion) {
        final UsuariosDao usuariosDao = new UsuariosDao();
        final UsuariosBean usuariosBean = usuariosDao.isLogin();

        if (usuariosBean != null) {

            final DiariosDao diariosDao = new DiariosDao();
            final DiariosBean diariosBean = diariosDao.emocionesPorUsuario(usuariosBean.getId(), Utils.fechaActual());

            //Actualizamos
            if (diariosBean != null) {
                if (emocion.compareToIgnoreCase("muymal") == 0) {
                    diariosBean.setMuy_mal(true);
                    diariosBean.setMal(false);
                    diariosBean.setNormal(false);
                    diariosBean.setBien(false);
                    diariosBean.setExcelente(false);
                    diariosDao.save(diariosBean);
                } else if (emocion.compareToIgnoreCase("mal") == 0) {
                    diariosBean.setMuy_mal(false);
                    diariosBean.setMal(true);
                    diariosBean.setNormal(false);
                    diariosBean.setBien(false);
                    diariosBean.setExcelente(false);
                    diariosDao.save(diariosBean);
                } else if (emocion.compareToIgnoreCase("normal") == 0) {
                    diariosBean.setMuy_mal(false);
                    diariosBean.setMal(false);
                    diariosBean.setNormal(true);
                    diariosBean.setBien(false);
                    diariosBean.setExcelente(false);
                    diariosDao.save(diariosBean);
                } else if (emocion.compareToIgnoreCase("bien") == 0) {
                    diariosBean.setMuy_mal(false);
                    diariosBean.setMal(false);
                    diariosBean.setNormal(false);
                    diariosBean.setBien(true);
                    diariosBean.setExcelente(false);
                    diariosDao.save(diariosBean);
                } else if (emocion.compareToIgnoreCase("excelente") == 0) {
                    diariosBean.setMuy_mal(false);
                    diariosBean.setMal(false);
                    diariosBean.setNormal(false);
                    diariosBean.setBien(false);
                    diariosBean.setExcelente(true);
                    diariosDao.save(diariosBean);
                }
            }else {

                final DiariosDao dao = new DiariosDao();
                final DiariosBean bean = new DiariosBean();
                if (emocion.compareToIgnoreCase("muymal") == 0) {
                    bean.setMuy_mal(true);
                    bean.setMal(false);
                    bean.setNormal(false);
                    bean.setBien(false);
                    bean.setExcelente(false);
                    bean.setFecha(Utils.fechaActual());
                    bean.setIdUsuario(usuariosBean.getId());
                    dao.save(bean);
                } else if (emocion.compareToIgnoreCase("mal") == 0) {
                    bean.setMuy_mal(false);
                    bean.setMal(true);
                    bean.setNormal(false);
                    bean.setBien(false);
                    bean.setExcelente(false);
                    bean.setFecha(Utils.fechaActual());
                    bean.setIdUsuario(usuariosBean.getId());
                    dao.save(bean);
                } else if (emocion.compareToIgnoreCase("normal") == 0) {
                    bean.setMuy_mal(false);
                    bean.setMal(false);
                    bean.setNormal(true);
                    bean.setBien(false);
                    bean.setExcelente(false);
                    bean.setFecha(Utils.fechaActual());
                    bean.setIdUsuario(usuariosBean.getId());
                    dao.save(bean);
                } else if (emocion.compareToIgnoreCase("bien") == 0) {
                    bean.setMuy_mal(false);
                    bean.setMal(false);
                    bean.setNormal(false);
                    bean.setBien(true);
                    bean.setExcelente(false);
                    bean.setFecha(Utils.fechaActual());
                    bean.setIdUsuario(usuariosBean.getId());
                    dao.save(bean);
                } else if (emocion.compareToIgnoreCase("excelente") == 0) {
                    bean.setMuy_mal(false);
                    bean.setMal(false);
                    bean.setNormal(false);
                    bean.setBien(false);
                    bean.setExcelente(true);
                    bean.setFecha(Utils.fechaActual());
                    bean.setIdUsuario(usuariosBean.getId());
                    dao.save(bean);
                }
            }


        }

    }


}