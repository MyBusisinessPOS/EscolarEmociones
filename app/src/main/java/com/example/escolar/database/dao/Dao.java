package com.example.escolar.database.dao;

import com.example.escolar.database.DaoHelper;
import com.example.escolar.database.bean.Bean;
import com.example.escolar.database.bean.DaoSession;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

public class Dao {


    protected AbstractDao dao;
    protected DaoSession daoSession;
    public static DaoSession daoExternalSession;

    public Dao(final String daoName) {

        if (daoExternalSession == null) {
            daoSession = DaoHelper.getSingleton().getDaoSession();
        } else {
            daoSession = daoExternalSession;
        }

        switch (daoName) {

            case "UsuariosBean":
                dao = daoSession.getUsuariosBeanDao();
                break;

            case "DiariosBean":
                dao = daoSession.getDiariosBeanDao();
                break;

            case "AgendaBean":
                dao = daoSession.getAgendaBeanDao();
                break;
            case "EmocionesBean":
                dao = daoSession.getEmocionesBeanDao();
                break;
            case "AlimentosBean":
                dao = daoSession.getAlimentoBeanDao();
                break;
            case "ActividadesBean":
                dao = daoSession.getActividadBeanDao();
                break;

        }
    }

    public List<Bean> list() {
        return dao.loadAll();
    }

    public void insert(Bean bean) {
        dao.insert(bean);
    }

    public void delete(Bean bean) {
        dao.delete(bean);
    }

    public Bean getByID(final long id) {
        return (Bean) dao.loadByRowId(id);
    }

    public void clear() {
        dao.deleteAll();
    }

    public void insertAll(List<Bean> list) {
        for (Bean bean : list) {
            this.dao.insert(bean);
        }
    }

    public void save(Bean bean) {
        dao.save(bean);
    }
}
