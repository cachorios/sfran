package com.gmail.cacho.backend.entidad;

import com.gmail.cacho.slbase.security.enums.ETipoPermiso;
import com.gmail.cacho.slbase.security.excepciones.SecurityErrorException;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario extends AbstractEntidad {

    @NotNull
    @Column(unique = true)
    @Size(min=3, max = 60, message = "La cantidad de caracteres debe estar entre 3 y 60")
    private String nombre;

    @NotNull
    @Size(min=4, max = 30, message = "La cantidad de caracteres debe estar entre 4 y 30")
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min=4, max = 1024, message = "La cantidad de caracteres debe estar entre 4 y 30")
    private String password;

    @NotNull
    @Email
    @Size(max = 255)
    @Column(unique = true)
    private String email;


    @NotNull
    private String salt;

    @NotNull
    private String role;

    @Size(max = 1024)
    private String photoUrl;

    private boolean locked = false;

    public Usuario() {
        this.role= Role.USUARIO;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPasswordOK(String password) {
        ////todo: ver como veridicar ... hay un usuarioService
//        SimpleByteSource sbs = new SimpleByteSource(username.concat(Sistema.getSistema().getPreSalt()));
//        return new Sha256Hash(password, sbs, 1024).toBase64().equals(
//                CDI.current().select(ServUsuario.class).get().getPasswordString(getId()));
        return true;
    }

    public boolean poseePermiso(Parametro recurso, ETipoPermiso tipo) throws SecurityErrorException {
        //todo: ver como dar permiso
        return true;
    }

}
