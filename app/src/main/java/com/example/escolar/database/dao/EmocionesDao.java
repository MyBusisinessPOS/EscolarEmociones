package com.example.escolar.database.dao;

import android.database.Cursor;

import com.example.escolar.database.bean.DiariosBean;
import com.example.escolar.database.bean.DiariosBeanDao;
import com.example.escolar.database.bean.EmocionesBean;
import com.example.escolar.database.bean.EmocionesBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class EmocionesDao extends Dao{
    public EmocionesDao() {
        super("EmocionesBean");
    }



    final public EmocionesBean emocionesPorUsuario(long idUsuario, String fecha) {
        final List<EmocionesBean> diariosBeans =dao.queryBuilder()
                .where(EmocionesBeanDao.Properties.IdUsuario.eq(idUsuario), EmocionesBeanDao.Properties.Fecha.eq(fecha))
                .list();
        return diariosBeans.size()>0?diariosBeans.get(0):null;
    }

    public int getEmocionesPorMes(String emocion) {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -30); // Retrocede 30 días

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String startDate = sdf.format(calendar.getTime());
        String endDate = sdf.format(new Date());

        final Cursor cursor = dao.getDatabase().rawQuery("SELECT COUNT(*) FROM emociones WHERE emocion = '" + emocion + "'  AND DATE(FECHA) BETWEEN '" + startDate + "' AND '" + endDate + "'", null);

        cursor.moveToFirst();
        int result = cursor.getInt(0);

        return result;
    }

}
