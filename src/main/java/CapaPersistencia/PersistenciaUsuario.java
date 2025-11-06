/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;

import CapaLogica.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 60578249
 */
public class PersistenciaUsuario {
     private static final String SQLRegistro = ("INSERT INTO proyecto_final_iti.usuarios(ciPer,nombre,apellido,contrasenia) VALUES (?,?,?,?)");
     private static final String SQLIniciar = ("SELECT * FROM proyecto_final_iti.usuarios WHERE ciPer = ? AND contrasenia = ?");
     
     
     public Conexion cone = new Conexion();
        public PreparedStatement ps;
        public ResultSet rs;
        
        
        
    public void RegistrarUsuario(Usuario Us) throws Exception,SQLException{
            try{
               
                       Connection con = cone.getConnection();
                       ps =  con.prepareStatement(SQLRegistro);
                       
                       ps.setString(1,Us.getCi());
                       ps.setString(2,Us.getNombre());
                       ps.setString(3,Us.getApellido());
                       ps.setString(4,Us.getContrasenia());
                       
                        int resultado = ps.executeUpdate();
                       if(resultado <= 0){
                           throw new Exception("No se pudo registrar");     
                       }
                       con.close();
                       
            }catch (SQLException e){
                throw new Exception ("Tuve problemas en la base" + e.getMessage());
                
            }
             
        }
    public boolean IniciarSesion(String cedula,String contrasenia)throws Exception{
        boolean valido = false;
        try {
            Connection con = cone.getConnection();
            ps = con.prepareStatement(SQLIniciar);
            ps.setString(1, cedula);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();

            if (rs.next()) {
                valido = true;
            }
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al validar inicio de sesión: " + e.getMessage());
        }
        return valido;
    }    
    }

