package com.example.escolar.database.dao;

import com.example.escolar.database.bean.ActividadBean;
import com.example.escolar.database.bean.ActividadBeanDao;
import com.example.escolar.database.bean.EmocionesBean;
import com.example.escolar.database.bean.EmocionesBeanDao;

import java.util.List;

public class ActividadesDao extends Dao{
    public ActividadesDao() {
        super("ActividadesBean");
    }



    final public ActividadBean actividadesPorUsuario(long idUsuario, String fecha, String categoria) {
        final List<ActividadBean> diariosBeans =dao.queryBuilder()
                .where(ActividadBeanDao.Properties.IdUsuario.eq(idUsuario), ActividadBeanDao.Properties.Fecha.eq(fecha), ActividadBeanDao.Properties.Categoria.eq(categoria))
                .list();
        return diariosBeans.size()>0?diariosBeans.get(0):null;
    }
}
