package com.example.escolar.database.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "emociones")
public class EmocionesBean extends Bean{

    @Id(autoincrement = true)
    private Long id;
    private Long idUsuario;
    @ToOne(joinProperty = "idUsuario")
    private UsuariosBean usuario;
    private String fecha;
    private String emocion;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1891541422)
    private transient EmocionesBeanDao myDao;
    @Generated(hash = 987809377)
    public EmocionesBean(Long id, Long idUsuario, String fecha, String emocion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.emocion = emocion;
    }
    @Generated(hash = 523702016)
    public EmocionesBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getFecha() {
        return this.fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getEmocion() {
        return this.emocion;
    }
    public void setEmocion(String emocion) {
        this.emocion = emocion;
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
    @Generated(hash = 1889226040)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEmocionesBeanDao() : null;
    }
}
