package com.example.escolar.database.dao;

import com.example.escolar.database.bean.DiariosBean;
import com.example.escolar.database.bean.DiariosBeanDao;


import java.util.List;

public class DiariosDao extends Dao{

    public DiariosDao() {
        super("DiariosBean");
    }

    final public DiariosBean emocionesPorUsuario(long idUsuario, String fecha) {
        final List<DiariosBean> diariosBeans =dao.queryBuilder()
                .where(DiariosBeanDao.Properties.IdUsuario.eq(idUsuario), DiariosBeanDao.Properties.Fecha.eq(fecha))
                .list();
        return diariosBeans.size()>0?diariosBeans.get(0):null;
    }
}
