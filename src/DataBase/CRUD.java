/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class CRUD extends ConnectionDB {
    
    private PreparedStatement ps;
    private ResultSet response;
    
    
    //Metodo para realizar consultas en la DB
    public void getQuery(String query) {
        
        try {
            
            openConnection();        
            ps = getConnectionDB().prepareStatement(query);
            response = ps.executeQuery();
            
            if (response.next()) {
                System.out.print(response.getArray("name"));
            }
            
            closeConnection();
            
        } catch (SQLException e){
            System.out.println("Error de MySQL: \n" + e);
        }
        
    }
    
    //Metodo para realizar consultas en la DB
    public void getOpenInto(String into) {
        
        try {
            
            openConnection();        
            ps = getConnectionDB().prepareStatement(into);
            response = ps.executeQuery();
            
            closeConnection();
            
        } catch (SQLException e){
            System.out.println("Error de MySQL: \n" + e);
        }
        
    }
    
    public void getCloseInto() {
        
        try {
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                System.out.println("Datos Guardados");
            } else {
                System.out.println("Error al guardar los datos");                
            }
            closeConnection();
            
        } catch (SQLException e){
            System.out.println("Error de MySQL: \n" + e);
        }
        
    }

    public void setPsString(int column, String data) {
        try {
            this.ps.setString(column, data);
        } catch (SQLException e){
            System.out.println("Error de MySQL: \n" + e);
        }
    }
    
    public void setPsInt(int column, String data) {
        try {
            this.ps.setDouble(column, Double.parseDouble(data));
        } catch (SQLException e){
            System.out.println("Error de MySQL: \n" + e);
        }
    }
    
    public void setPsDouble(int column, String data) {
        try {
            this.ps.setDouble(column, Double.parseDouble(data));
        } catch (SQLException e){
            System.out.println("Error de MySQL: \n" + e);
        }
    }

    
    // Metodo para conocer el resultado de la consulta
    public ResultSet getResponse() {
        return response;
    }
    
    
    
}
