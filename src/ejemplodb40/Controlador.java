/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplodb40;

import javax.swing.table.DefaultTableModel;

public class Controlador extends Conexion {

    public Controlador() {

    }

    public boolean insertarPersona( String nombre, String apellidos, int id) {
        Persona persona = new Persona(nombre, apellidos, id);
        return this.Insertar(persona);
    }

    public boolean eliminarPersona(int id) {
        if (id > 0) {
            Persona persona = new Persona(null, null,id);
            return this.Eliminar(persona);
        } else {
            return false;
        }
    }

    public DefaultTableModel personas() {
        String titulos[] = {"Id", "Nombre", "Apellidos"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Persona persona = null;
        Persona[] p = this.Consultar(persona);
        if (p != null) {
            for (Persona per : p) {
                Object[] ta = new Object[3];
                ta[0] = per.getID();
                ta[1] = per.getNOMBRE();
                ta[2] = per.getAPELLIDOS();
                dtm.addRow(ta);
            }
        }
        return dtm;
    }
}
