/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.TDAListas.DynamicList;
import modelo.Rol;

/**
 *
 * @author mrbingus
 */
public class RolControl {
    
     private DynamicList<Rol> roles;

    public RolControl(){
        roles = new DynamicList<>();
        roles.add(new Rol(1,"Administrador", "es un admin"));
        roles.add(new Rol(2,"Cajero", "es un cajero"));
        roles.add(new Rol(3,"Cliente", "es un cliente"));
    }

    public DynamicList<Rol> getRoles() {
        return roles;
    }

    public void setRoles(DynamicList<Rol> roles) {
        this.roles = roles;
    }   
    
}