/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import MainClass.Variables;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Products extends ConnectionDB {
    
    private PreparedStatement ps;
    private ResultSet response;
    
    
    //Metodo para consultar todos los usuarios en la DB
    public void getQuery() {
        
        try {
            
            openConnection();        
            ps = getConnectionDB().prepareStatement("SELECT * FROM Products");
            response = ps.executeQuery();
            
            while (response.next()) {
                
                int idProduct = response.getInt("idProduct");
                String codigo = response.getString("codigo");
                String name = response.getString("name");
                int valorUnitario = response.getInt("valorUnitario");
                
                Variables.products.add(new Product(idProduct, codigo, name, valorUnitario));
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    
    
    public void SetData(String codigo, String name, int valorUnitario) {
        
        String sql = "INSERT INTO Products (codigo, name, valorUnitario) VALUES (?,?,?,?,?);";
        
        try {
            
            openConnection();        
            ps = getConnectionDB().prepareStatement(sql);
            
            ps.setString(1, codigo);
            ps.setString(2, name);
            ps.setInt(3, valorUnitario);
            
            int res = ps.executeUpdate();
            
            if(res > 0) {
                JOptionPane.showMessageDialog(null, "Producto creado Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Producto No Creado");
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    
}
