package com.gmail.cacho.backend.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario extends AbstractEntidad {
    @NotNull
    //@Size(min=4, max = 30, message = "La cantidad de caracteres debe estar entre 4 y 30")
    //@Column(unique = true)
    private String username;

    @NotNull
    //@Email
    //@Size(max = 255)
    @Column(unique = true)
    private String email;

    @NotNull
    //@Size(min=3, max = 30, message = "La cantidad de caracteres debe estar entre 4 y 30")
    private String password;

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
}
