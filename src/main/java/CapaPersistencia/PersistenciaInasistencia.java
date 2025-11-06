/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;

import CapaExcepciones.BDException;
import CapaExcepciones.UsuarioException;
import CapaLogica.Inasistencia;
import CapaLogica.Usuario;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manue
 */
public class PersistenciaInasistencia {
    
    private static final String SQLIngreso =("INSERT INTO proyecto_final_iti.licencias(FechaInicio,fechaFin,Materia,Profesor) VALUES (?,?,?,?)");
    private static final String SQL_CONSULTA_PERSONA = ("SELECT * FROM proyecto_final_iti.licencias");
    
    public Conexion cone = new Conexion();
        public PreparedStatement ps;
        public ResultSet rs;
        
        
         public void RegistrarInasistencia(Inasistencia In) throws Exception,SQLException{
            try{
               
                       Connection con = cone.getConnection();
                       ps =  con.prepareStatement(SQLIngreso);
                       
                       ps.setString(1,In.getFechaIn());
                       ps.setString(2,In.getFechaFin());
                       ps.setString(3,In.getMateria());
                       ps.setString(4,In.getProfesor());
                       
                        int resultado = ps.executeUpdate();
                       if(resultado <= 0){
                           throw new Exception("No se pudo registrar");     
                       }
                       con.close();
                       
            }catch (SQLException e){
                throw new Exception ("Tuve problemas en la base" + e.getMessage());
                
            }
             
        }
         
public java.util.List<Inasistencia> ImprimirInasistencias() throws Exception, BDException, SQLException {
    java.util.List<Inasistencia> lista = new java.util.ArrayList<Inasistencia>();

    try {
        Connection con = cone.getConnection();
        ps = (PreparedStatement) con.prepareStatement(SQL_CONSULTA_PERSONA);
        rs = ps.executeQuery();

        while (rs.next()) {
            Inasistencia ina = new Inasistencia();
            ina.setFechaIn(rs.getString("FechaInicio"));
            ina.setFechaFin(rs.getString("FechaFin"));
            ina.setMateria(rs.getString("Materia"));
            ina.setProfesor(rs.getString("Profesor"));
            lista.add(ina);
        }

        if (lista.isEmpty()) {
            throw new UsuarioException("No hay inasistencias registradas.");
        }

        con.close();

    } catch (Exception e) {
        System.out.println(e);
        throw new UsuarioException("No pude obtener las inasistencias");
    }

    return lista;
}
 
}
