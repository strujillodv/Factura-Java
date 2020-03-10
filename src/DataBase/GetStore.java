/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import MainClass.Variables;
import Model.Store;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class GetStore extends ConnectionDB {
    
    private PreparedStatement ps;
    private ResultSet response;
    
    
    //Metodo para consultar todos los usuarios en la DB
    public void getQuery() {
        
        try {
            
            openConnection("Optener datos de la tienda");        
            ps = getConnectionDB().prepareStatement("SELECT * FROM Store");
            response = ps.executeQuery();
            
            while (response.next()) {
                
                String name = response.getString("name");
                String nit = response.getString("nit");
                String telephone = response.getString("telephone");
                String adress = response.getString("adress");
                String imgUrl = response.getString("imgUrl");
                int idStore = response.getInt("idStore");
                
                Variables.store = new Store(name, nit, telephone, adress, imgUrl);
                
                Variables.store.setIdStore(idStore);
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    
    
    public void SetData(String name, String nit, String telephone, String adress, String imgUrl) {
        
        String sql = "INSERT INTO Store (name, nit, telephone, adress, imgUrl) VALUES (?,?,?,?,?);";
        
        try {
            
            openConnection("Crear nueva tienda");        
            ps = getConnectionDB().prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, nit);
            ps.setString(3, telephone);
            ps.setString(4, adress);
            ps.setString(5, imgUrl);
            
            int res = ps.executeUpdate();
            
            if(res > 0) {
                JOptionPane.showMessageDialog(null, "Tienda Guardada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Tienda No Guardada");
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    
}
