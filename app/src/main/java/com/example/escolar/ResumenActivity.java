package com.example.escolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.escolar.database.dao.EmocionesDao;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class ResumenActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        final EmocionesDao emocionesDao = new EmocionesDao();
        int totalEmociones = 0; //emocionesDao.getEmocionesPorMes("");


        int emocionesTristeza = emocionesDao.getEmocionesPorMes("Tristeza");
        int emocionesFelicidad = emocionesDao.getEmocionesPorMes("Felicidad");
        int emocionesEnojo = emocionesDao.getEmocionesPorMes("Enojo");
        int emocionesAngustia = emocionesDao.getEmocionesPorMes("Angustia");
        int emocionesMiedo = emocionesDao.getEmocionesPorMes("Miedo");
        int emocionesAmor = emocionesDao.getEmocionesPorMes("Amor");
        int emocionesCalma = emocionesDao.getEmocionesPorMes("Calma");
        int emocionesAnciedad = emocionesDao.getEmocionesPorMes("Anciedad");

        totalEmociones = emocionesTristeza + emocionesFelicidad + emocionesEnojo+emocionesAngustia+emocionesMiedo+emocionesAmor+emocionesCalma+emocionesAnciedad;

        LinearProgressIndicator progressIndicatorTristeza = findViewById(R.id.progressIndicatorTristesa);
        int porcentajeTristeza = (int) ((emocionesTristeza / (float) totalEmociones) * 100);
        progressIndicatorTristeza.setProgressCompat(porcentajeTristeza, true);

        LinearProgressIndicator progressIndicatorFelicidad = findViewById(R.id.progressIndicatorFelicidad);
        int porcentajeFelicidad = (int) ((emocionesFelicidad / (float) totalEmociones) * 100);
        progressIndicatorFelicidad.setProgressCompat(porcentajeFelicidad, true);

        LinearProgressIndicator progressIndicatorEnojo = findViewById(R.id.progressIndicatorEnojo);
        int porcentajeEnojo = (int) ((emocionesEnojo / (float) totalEmociones) * 100);
        progressIndicatorEnojo.setProgressCompat(porcentajeEnojo, true);

        LinearProgressIndicator progressIndicatorAngustia = findViewById(R.id.progressIndicatorAngustia);
        int porcentajeAngustia = (int) ((emocionesAngustia / (float) totalEmociones) * 100);
        progressIndicatorAngustia.setProgressCompat(porcentajeAngustia, true);

        LinearProgressIndicator progressIndicatorMiedo = findViewById(R.id.progressIndicatorMiedo);
        int porcentajeMiedo = (int) ((emocionesMiedo / (float) totalEmociones) * 100);
        progressIndicatorMiedo.setProgressCompat(porcentajeMiedo, true);

        LinearProgressIndicator progressIndicatorAmor = findViewById(R.id.progressIndicatorAmor);
        int porcentajeAmor = (int) ((emocionesAmor / (float) totalEmociones) * 100);
        progressIndicatorAmor.setProgressCompat(porcentajeAmor, true);

        LinearProgressIndicator progressIndicatorCalma = findViewById(R.id.progressIndicatorCalma);
        int porcentajeCalma = (int) ((emocionesCalma / (float) totalEmociones) * 100);
        progressIndicatorCalma.setProgressCompat(porcentajeCalma, true);

        LinearProgressIndicator progressIndicatorAnciedad = findViewById(R.id.progressIndicatorAnciedad);
        int porcentajeAnciedad = (int) ((emocionesAnciedad / (float) totalEmociones) * 100);
        progressIndicatorAnciedad.setProgressCompat(porcentajeAnciedad, true);


    }
}