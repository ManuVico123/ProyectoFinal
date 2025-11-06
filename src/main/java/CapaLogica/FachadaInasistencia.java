/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaExcepciones.UsuarioException;
import CapaPersistencia.PersistenciaInasistencia;


/**
 *
 * @author manue
 */
public class FachadaInasistencia {
    public void RegistrarInasistencia(Inasistencia In)throws Exception{
       PersistenciaInasistencia ina = new PersistenciaInasistencia();
        ina.RegistrarInasistencia(In);        
    }
     public java.util.List<Inasistencia> imprimirInasistencias() throws UsuarioException, Exception {
    PersistenciaInasistencia ina = new PersistenciaInasistencia();
    java.util.List<Inasistencia> lista = ina.ImprimirInasistencias();
    return lista;
}

}
