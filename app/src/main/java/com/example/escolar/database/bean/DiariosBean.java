package com.example.escolar.database.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(nameInDb = "diarios")
public class DiariosBean extends Bean{

    @Id(autoincrement = true)
    private Long id;
    private boolean muy_mal;
    private boolean mal;
    private boolean normal;
    private boolean bien;
    private boolean excelente;
    private Long idUsuario;
    private String fecha;
    private String hora;
    @ToOne(joinProperty = "idUsuario")
    private UsuariosBean usuario;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1104865409)
    private transient DiariosBeanDao myDao;
    @Generated(hash = 907415959)
    public DiariosBean(Long id, boolean muy_mal, boolean mal, boolean normal,
            boolean bien, boolean excelente, Long idUsuario, String fecha,
            String hora) {
        this.id = id;
        this.muy_mal = muy_mal;
        this.mal = mal;
        this.normal = normal;
        this.bien = bien;
        this.excelente = excelente;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.hora = hora;
    }
    @Generated(hash = 1502419177)
    public DiariosBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean getMuy_mal() {
        return this.muy_mal;
    }
    public void setMuy_mal(boolean muy_mal) {
        this.muy_mal = muy_mal;
    }
    public boolean getMal() {
        return this.mal;
    }
    public void setMal(boolean mal) {
        this.mal = mal;
    }
    public boolean getNormal() {
        return this.normal;
    }
    public void setNormal(boolean normal) {
        this.normal = normal;
    }
    public boolean getBien() {
        return this.bien;
    }
    public void setBien(boolean bien) {
        this.bien = bien;
    }
    public boolean getExcelente() {
        return this.excelente;
    }
    public void setExcelente(boolean excelente) {
        this.excelente = excelente;
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
    public String getHora() {
        return this.hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
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
    @Generated(hash = 261571061)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDiariosBeanDao() : null;
    }
}
