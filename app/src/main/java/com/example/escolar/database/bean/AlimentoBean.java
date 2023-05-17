package com.example.escolar.database.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
@Entity(nameInDb = "alimentos")
public class AlimentoBean extends Bean{

    @Id(autoincrement = true)
    private Long id;
    private String categoria;
    private String alimento;
    private String fecha;
    private Long idUsuario;
    @ToOne(joinProperty = "idUsuario")
    private UsuariosBean usuario;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 870446804)
    private transient AlimentoBeanDao myDao;
    @Generated(hash = 1228512420)
    public AlimentoBean(Long id, String categoria, String alimento, String fecha,
            Long idUsuario) {
        this.id = id;
        this.categoria = categoria;
        this.alimento = alimento;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }
    @Generated(hash = 1989290542)
    public AlimentoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategoria() {
        return this.categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getAlimento() {
        return this.alimento;
    }
    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }
    public String getFecha() {
        return this.fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Long getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Generated(hash = 41136015)
    private transient Long usuario__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1711356615)
    public UsuariosBean getUsuario() {
        Long __key = this.idUsuario;
        if (usuario__resolvedKey == null || !usuario__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UsuariosBeanDao targetDao = daoSession.getUsuariosBeanDao();
            UsuariosBean usuarioNew = targetDao.load(__key);
            synchronized (this) {
                usuario = usuarioNew;
                usuario__resolvedKey = __key;
            }
        }
        return usuario;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2144258976)
    public void setUsuario(UsuariosBean usuario) {
        synchronized (this) {
            this.usuario = usuario;
            idUsuario = usuario == null ? null : usuario.getId();
            usuario__resolvedKey = idUsuario;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 392125670)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAlimentoBeanDao() : null;
    }
}
