package com.example.escolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.escolar.R;
import com.example.escolar.database.Utils;
import com.example.escolar.database.bean.ActividadBean;
import com.example.escolar.database.bean.AlimentoBean;
import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.dao.ActividadesDao;
import com.example.escolar.database.dao.AlimentosDao;
import com.example.escolar.database.dao.UsuariosDao;

public class AlimentoActivity extends AppCompatActivity {

    private ImageView ImageViewDesayuno, ImageViewAlmuerzo, ImageViewCena, ImageViewMerienda;
    private ImageView ImageViewSoleado, ImageViewNublado, ImageViewLluvioso, ImageViewViento, ImageViewNevado;

    private ImageView ImageViewFamiliar, ImageViewAmigable, ImageViewAmado, ImageViewColega, ImageViewDesconocido;

    private ImageView ImageViewHogar, ImageViewTrabajo, ImageViewEscuela, ImageViewRestaurante, ImageViewParque, ImageViewGim, ImageViewCine;
    private Button btSave;

    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimento);
        iniciaControles();
    }

    private void iniciaControles(){

        btSave = findViewById(R.id.btnSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count >= 3){
                    Intent intent = new Intent(AlimentoActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(AlimentoActivity.this, "Debe se selecionar almenos 4 elementos", Toast.LENGTH_SHORT).show();

                }
            }
        });
        ImageViewDesayuno  = findViewById(R.id.ImageViewDesayuno);
        ImageViewDesayuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Desayuno", Toast.LENGTH_SHORT).show();
                guardaActualiza("Desayuno", "Alimento");
            }
        });

        ImageViewAlmuerzo  = findViewById(R.id.ImageViewAlmuerzo);
        ImageViewAlmuerzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Almuerzo", Toast.LENGTH_SHORT).show();
                guardaActualiza("Almuerzo", "Alimento");
            }
        });

        ImageViewCena  = findViewById(R.id.ImageViewCena);
        ImageViewCena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Cena", Toast.LENGTH_SHORT).show();
                guardaActualiza("Cena", "Alimento");
            }
        });

        ImageViewMerienda  = findViewById(R.id.ImageViewMerienda);
        ImageViewMerienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Merienda", Toast.LENGTH_SHORT).show();
                guardaActualiza("Merienda", "Alimento");
            }
        });

        //Clima
        //private ImageView ImageViewSoleado, ImageViewNublado, ImageViewLluvioso, ImageViewViento, ImageViewNevado;

        ImageViewSoleado  = findViewById(R.id.ImageViewSoleado);
        ImageViewSoleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Soleado", Toast.LENGTH_SHORT).show();
                guardaActualiza("Merienda", "Clima");
            }
        });
        ImageViewNublado  = findViewById(R.id.ImageViewNublado);
        ImageViewNublado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Nublado", Toast.LENGTH_SHORT).show();
                guardaActualiza("Nublado", "Clima");
            }
        });

        ImageViewLluvioso  = findViewById(R.id.ImageViewLluvioso);
        ImageViewLluvioso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Lluvioso", Toast.LENGTH_SHORT).show();
                guardaActualiza("Lluvioso", "Clima");
            }
        });
        ImageViewViento  = findViewById(R.id.ImageViewViento);
        ImageViewViento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Viento", Toast.LENGTH_SHORT).show();
                guardaActualiza("Viento", "Clima");
            }
        });

        ImageViewNevado  = findViewById(R.id.ImageViewNevado);
        ImageViewNevado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Nevado", Toast.LENGTH_SHORT).show();
                guardaActualiza("Nevado", "Clima");
            }
        });

        //    private ImageView ImageViewFamiliar, ImageViewAmigable, ImageViewAmado, ImageViewColega, ImageViewDesconocido;

        ImageViewFamiliar  = findViewById(R.id.ImageViewFamiliar);
        ImageViewFamiliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Familiar", Toast.LENGTH_SHORT).show();
                guardaActualiza("Familiar", "Social");
            }
        });

        ImageViewAmigable  = findViewById(R.id.ImageViewAmigable);
        ImageViewAmigable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Amigable", Toast.LENGTH_SHORT).show();
                guardaActualiza("Amigable", "Social");
            }
        });

        ImageViewAmado  = findViewById(R.id.ImageViewAmado);
        ImageViewAmado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Amado", Toast.LENGTH_SHORT).show();
                guardaActualiza("Amado", "Social");
            }
        });

        ImageViewColega  = findViewById(R.id.ImageViewColega);
        ImageViewColega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Colega", Toast.LENGTH_SHORT).show();
                guardaActualiza("Colega", "Social");
            }
        });

        ImageViewDesconocido  = findViewById(R.id.ImageViewDesconocido);
        ImageViewDesconocido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Desconocido", Toast.LENGTH_SHORT).show();
                guardaActualiza("Desconocido", "Social");
            }
        });

        //    private ImageView ImageViewHogar, ImageViewTrabajo, ImageViewEscuela, ImageViewRestaurante, ImageViewParque, ImageViewGim, ImageViewCine;


        ImageViewHogar  = findViewById(R.id.ImageViewDesconocido);
        ImageViewHogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Hogar", Toast.LENGTH_SHORT).show();
                guardaActualiza("Hogar", "Ubicación");
            }
        });

        ImageViewTrabajo  = findViewById(R.id.ImageViewTrabajo);
        ImageViewTrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Trabajo", Toast.LENGTH_SHORT).show();
                guardaActualiza("Trabajo", "Ubicación");
            }
        });


        ImageViewEscuela = findViewById(R.id.ImageViewEscuela);
        ImageViewEscuela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Escuele", Toast.LENGTH_SHORT).show();
                guardaActualiza("Escuele", "Ubicación");
            }
        });


        ImageViewRestaurante  = findViewById(R.id.ImageViewRestaurante);
        ImageViewRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Restaurante", Toast.LENGTH_SHORT).show();
                guardaActualiza("Restaurante", "Ubicación");
            }
        });


        ImageViewParque  = findViewById(R.id.ImageViewParque);
        ImageViewParque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Parque", Toast.LENGTH_SHORT).show();
                guardaActualiza("Parque", "Ubicación");
            }
        });

        ImageViewGim  = findViewById(R.id.ImageViewGim);
        ImageViewGim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Gim", Toast.LENGTH_SHORT).show();
                guardaActualiza("Gim", "Ubicación");
            }
        });

        ImageViewCine  = findViewById(R.id.ImageViewCine);
        ImageViewCine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                Toast.makeText(AlimentoActivity.this, "Cine", Toast.LENGTH_SHORT).show();
                guardaActualiza("Cine", "Ubicación");
            }
        });
    }


    private void guardaActualiza(String alimento, String categoria){
        final UsuariosDao usuariosDao = new UsuariosDao();
        final UsuariosBean usuariosBean = usuariosDao.isLogin();

        if (usuariosBean != null) {
            final AlimentosDao alimentosDao = new AlimentosDao();
            final AlimentoBean alimentoBean = alimentosDao.alimentoPorUsuario(usuariosBean.getId(), Utils.fechaActual(), categoria);
            if (alimentoBean == null){
                final AlimentoBean bean = new AlimentoBean();
                final AlimentosDao dao = new AlimentosDao();
                bean.setFecha(Utils.fechaActual());
                bean.setAlimento(alimento);
                bean.setCategoria(categoria);
                bean.setIdUsuario(usuariosBean.getId());
                dao.save(bean);
            }else{
                alimentoBean.setAlimento(alimento);
                alimentosDao.save(alimentoBean);
            }
        }
    }
}