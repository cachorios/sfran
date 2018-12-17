package com.gmail.cacho.backend.entidad;

import java.util.ArrayList;
import java.util.List;

public class Role {
    public static final String USUARIO = "USUARIO";
    public static final String ADMIN = "ADMIN";
    public static final String GERENTE = "GERENTE";
    public static final String ENCARGADO = "ENCARGADO";
    public static final String TRANSPORTISTA = "TRANSPORTISTA";

    private Role() {
        // Static methods and fields only
    }

    public static List<String> getAllRoles() {

        List<String> list = new ArrayList<>();

        list.add(USUARIO);
        list.add(ADMIN);
        list.add(GERENTE);
        list.add(ENCARGADO);
        list.add(TRANSPORTISTA);

        return list;
    }




}
