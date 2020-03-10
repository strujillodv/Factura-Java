/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import MainClass.Variables;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Users extends ConnectionDB {
    
    private PreparedStatement ps;
    private ResultSet response;
    
    
    //Metodo para consultar todos los usuarios en la DB
    public void getQuery() {
        
        try {
            
            openConnection("Obtener Datos de Usuarios");        
            ps = getConnectionDB().prepareStatement("SELECT * FROM Users");
            response = ps.executeQuery();
            
            while (response.next()) {
                
                String name = response.getString("name");
                String telephone = response.getString("telephone");
                String adress = response.getString("adress");
                String imgUrl = response.getString("imgUrl");                
                int documentNumber = response.getInt("idNumber");
                int idUser = response.getInt("idUser");
                
                Variables.users.add(new User(name, telephone, adress, imgUrl, documentNumber));
                
                Variables.users.get(Variables.users.size()-1).setIdUser(idUser);
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    public void getQueryUser(int idUser) {
        
        String sql = "SELECT * FROM Users WHERE idNumber =" + idUser;
        
        try {
            
            openConnection("Buscar Usuario por ID");        
            ps = getConnectionDB().prepareStatement(sql);
            response = ps.executeQuery();
            
            if (response.next()) {
                
                String name = response.getString("name");
                String telephone = response.getString("telephone");
                String adress = response.getString("adress");
                String imgUrl = response.getString("imgUrl");                
                int documentNumber = response.getInt("idNumber");
                
//                Variables.users.add(new User(name, telephone, adress, imgUrl, documentNumber));
//                Variables.users.get(Variables.users.size()-1).setIdUser(idUser);
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    
    
    public void SetData(String name, String telephone, String adress, String imgUrl, int idNumber) {
        
        String sql = "INSERT INTO Users (name, telephone, adress, imgUrl, idNumber) VALUES (?,?,?,?,?);";
        
        try {
            
            openConnection("Crear Usuario");        
            ps = getConnectionDB().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, name);
            ps.setString(2, telephone);
            ps.setString(3, adress);
            ps.setString(4, imgUrl);
            ps.setInt(5, idNumber);
            
            int res = ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                
                int idGenerado = generatedKeys.getInt(1);
                Variables.users.add(new User(name, telephone, adress, imgUrl, idNumber));
                Variables.users.get(Variables.users.size()-1).setIdUser(idGenerado);
                     
            }
            
            if(res > 0) {
                JOptionPane.showMessageDialog(null, "Usuario Guardado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario No guardado");
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    
}
