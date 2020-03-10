/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import MainClass.Variables;
import Model.Bill;
import Model.ItemBill;
import Model.Store;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Bills extends ConnectionDB {
    
    private PreparedStatement ps, psItem;
    private ResultSet response, responseProducts;
    
    //Metodo para consultar todos los usuarios en la DB
    public void getQuery() {
        
        String sql = "SELECT idBill, number, total, Store.name AS nameStore, Store.nit, Store.telephone AS telephoneStore, Store.adress AS adressStore, Store.imgUrl AS logo, Users.name As nameUser, Users.idNumber, Users.telephone AS telephoneUser, Users.adress AS adressUser, Users.imgUrl FROM Bills INNER JOIN Store ON Store.idStore = Bills.idStore INNER JOIN Users ON Users.idUser = Bills.idUser";
        String sqlProducts = "SELECT codigo, name, valorUnitario, cantidad, totalNeto, totalIva, total FROM itemBill WHERE idBill =";
        
        try {
            
            openConnection("Optener todas las Facturas");
            
            
            
            ps = getConnectionDB().prepareStatement(sql);
            
            response = ps.executeQuery();
            
            while (response.next()) {
                
                int idBill = response.getInt("idBill");
                int number = response.getInt("number");
                int total = response.getInt("total");
                
                String nameStore = response.getString("nameStore");
                String nit = response.getString("nit");
                String telephoneStore = response.getString("telephoneStore");
                String adressStore = response.getString("adressStore");
                String logo = response.getString("logo");
                
                String nameUser = response.getString("nameUser");
                int idNumber = response.getInt("idNumber");
                String telephoneUser = response.getString("telephoneUser");
                String adressUser = response.getString("adressUser");
                String imgUrl = response.getString("imgUrl");
                
                psItem = getConnectionDB().prepareStatement(sqlProducts + idBill);
                
                responseProducts = psItem.executeQuery();
                
                ArrayList<ItemBill> listProduct = new ArrayList<>(); 
                
                while (responseProducts.next()) {
                    
                    String codigo =  responseProducts.getString("codigo");
                    String nameProduct =  responseProducts.getString("name");
                    int cantidad =  responseProducts.getInt("cantidad");
                    int valorUnitario =  responseProducts.getInt("valorUnitario");
                    int totalNeto =  responseProducts.getInt("totalNeto");
                    int totalIva =  responseProducts.getInt("totalIva");
                    int totalItem = responseProducts.getInt("total");
                    
                    listProduct.add(new ItemBill(codigo, nameProduct, cantidad, valorUnitario, totalNeto, totalIva, totalItem));
                }
                
                String [][] list = new String[listProduct.size()][7];
                
                for(int i=0; i < listProduct.size(); i++) {
                    list[i][0] = listProduct.get(i).getCodigo();
                    list[i][1] = listProduct.get(i).getNombre();
                    list[i][2] = " " + listProduct.get(i).getCantidad();
                    list[i][3] = " " + listProduct.get(i).getValorUnitario();
                    list[i][4] = " " + listProduct.get(i).getTotalIva();
                    list[i][5] = " " + listProduct.get(i).getTotalNeto();
                    list[i][6] = " " + listProduct.get(i).getTotal();
                }
                
               Variables.bills.add(new Bill(
                       number,
                       new User(nameUser,telephoneUser, adressUser, imgUrl, idNumber),
                       new Store(nameStore, nit, telephoneStore, adressStore, logo),
                       list,
                       total
               ));
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    
    
    public void SetData(int number, int idUser, int idStore, String[][] list, int total) {
        
        String sql = "INSERT INTO Bills (idUser, idStore, number, total) VALUES (?,?,?,?);";
        
        try {
            
            openConnection("Crear Factura");     
            
            ps = getConnectionDB().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, idUser);
            ps.setInt(2, idStore);
            ps.setInt(3, number);
            ps.setInt(4, total);
            
            int res = ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                
                int idGenerado = generatedKeys.getInt(1);
                System.out.println(idGenerado);
                setItemsBill(idGenerado, list);
                     
            }
            
            if(res > 0) {
                JOptionPane.showMessageDialog(null, "Factura creada Correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Factura No Creada, error desconocido");
            }
            
            closeConnection();
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
        
    }
    
    public void setItemsBill(int idBill, String[][] list) {
        
        String sql = "INSERT INTO itemBill (idBill, codigo, name, cantidad, totalNeto, totalIva, valorUnitario, total) VALUES (?,?,?,?,?,?,?,?);";
        
        for (String[] list1 : list) {
            try {
                psItem = getConnectionDB().prepareStatement(sql);
                psItem.setInt(1,idBill);
                psItem.setString(2, list1[0]);
                psItem.setString(3, list1[1]);
                psItem.setInt(4, Integer.parseInt(list1[2].replaceAll("[$ ]", "")));
                psItem.setInt(5, Integer.parseInt(list1[5].replaceAll("[$ ]", "")));
                psItem.setInt(6, Integer.parseInt(list1[4].replaceAll("[$ ]", "")));
                psItem.setInt(7, Integer.parseInt(list1[3].replaceAll("[$ ]", "")));
                psItem.setInt(8, Integer.parseInt(list1[6].replaceAll("[$ ]", "")));
                int res = psItem.executeUpdate();
                if(res > 0) {
                    System.out.println("Item Agregado Correctamente");
                } else {
                    System.out.println("Item No Agregado Correctamente");
                }
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
            } 
        }
    }
    
    public void Delete(int numberBill) {
        
        String sql = "DELETE FROM Bills WHERE Number = " + numberBill;
        
        try {
            
            openConnection("Optener todas las Facturas");
            psItem = getConnectionDB().prepareStatement(sql);
            closeConnection();
            
        }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Error de MySQL: \n" + e);
        }
    }
    
}
