package com.example.escolar.database.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "usuarios")
public class UsuariosBean extends Bean{
    @Id(autoincrement = true)
    private Long id;
    private String nombre;
    private int edad;
    private String fecha_nacimiento;
    private String correo;
    private String contrasenia;
    private int isLogin;
    private String path_image;
    @Generated(hash = 1747530363)
    public UsuariosBean(Long id, String nombre, int edad, String fecha_nacimiento,
            String correo, String contrasenia, int isLogin, String path_image) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.isLogin = isLogin;
        this.path_image = path_image;
    }
    @Generated(hash = 687735935)
    public UsuariosBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return this.edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getCorreo() {
        return this.correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasenia() {
        return this.contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public int getIsLogin() {
        return this.isLogin;
    }
    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }
    public String getPath_image() {
        return this.path_image;
    }
    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }
   
}
