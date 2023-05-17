package com.example.escolar.database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {


    public static String fechaActual(){
        final Calendar calendarFechaFin = Calendar.getInstance();
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        final String fecha = format.format(calendarFechaFin.getTime());
        return  fecha;
    }

    public static String getHoraActual(){
        final Calendar calendarFechaFin = Calendar.getInstance();
        final SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        final String hora = format.format(calendarFechaFin.getTime());
        return  hora;
    }

}
