package com.example.escolar.database.dao;

import com.example.escolar.database.bean.UsuariosBean;
import com.example.escolar.database.bean.UsuariosBeanDao;

import java.util.List;

public class UsuariosDao extends Dao{
    public UsuariosDao() {
        super("UsuariosBean");
    }



    final public UsuariosBean login(final String email, final String password) {
        final List<UsuariosBean> usuarioBeans =dao.queryBuilder()
                .where(UsuariosBeanDao.Properties.Correo.eq(email.trim()), UsuariosBeanDao.Properties.Contrasenia.eq(password))
                .list();
        return usuarioBeans.size()>0?usuarioBeans.get(0):null;
    }



    final public UsuariosBean isLogin() {
        final List<UsuariosBean> usuarioBeans =dao.queryBuilder()
                .where(UsuariosBeanDao.Properties.IsLogin.eq(1))
                .list();
        return usuarioBeans.size()>0?usuarioBeans.get(0):null;
    }



}
