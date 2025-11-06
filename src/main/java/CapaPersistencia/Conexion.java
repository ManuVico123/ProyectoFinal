/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;

import CapaExcepciones.BDException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 60578249
 */
public class Conexion {
   
    public static Connection getConnection() throws BDException{
        Connection con=null;
    try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_final_iti?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
    }catch(SQLException sqle){
        throw new BDException("Error con la conexion"); 
    }
    return con;
}
}
