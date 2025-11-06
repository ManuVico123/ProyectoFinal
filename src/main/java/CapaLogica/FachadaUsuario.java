/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaPersistencia.PersistenciaUsuario;

/**
 *
 * @author 60578249
 */
public class FachadaUsuario {
    public void RegistrarUsuario(Usuario Us)throws Exception{
       PersistenciaUsuario Usu = new PersistenciaUsuario();
        Usu.RegistrarUsuario(Us);        
    }
    
    
    public boolean iniciarSesion(String usuario, String contrasenia) throws Exception {
        PersistenciaUsuario usu = new PersistenciaUsuario();
        return usu.IniciarSesion(usuario, contrasenia);
    }
}


