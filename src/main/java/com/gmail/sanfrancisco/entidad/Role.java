package com.gmail.sanfrancisco.entidad;

public class Role {
    public static final String USUARIO = "usuario";
    public static final String CHOFER = "chofer";
    public static final String ADMIN = "admin";

    private Role() {
        // Static methods and fields only
    }

    public static String[] getAllRoles() {
        return new String[] { USUARIO, CHOFER, ADMIN };
    }




}
