package com.example.escolar.database.dao;

import com.example.escolar.database.bean.ActividadBean;
import com.example.escolar.database.bean.ActividadBeanDao;
import com.example.escolar.database.bean.AlimentoBean;
import com.example.escolar.database.bean.AlimentoBeanDao;

import java.util.List;

public class AlimentosDao extends Dao{
    public AlimentosDao() {
        super("AlimentosBean");
    }


    final public AlimentoBean alimentoPorUsuario(long idUsuario, String fecha, String categoria) {
        final List<AlimentoBean> alimentoBeans =dao.queryBuilder()
                .where(AlimentoBeanDao.Properties.IdUsuario.eq(idUsuario), AlimentoBeanDao.Properties.Fecha.eq(fecha), AlimentoBeanDao.Properties.Categoria.eq(categoria))
                .list();
        return alimentoBeans.size()>0?alimentoBeans.get(0):null;
    }
}
