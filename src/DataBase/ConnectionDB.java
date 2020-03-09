/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Sergio Trujillo del valle
 */
public class ConnectionDB {
    
    private final String host, user, password;    
    
    private Connection connectionDB = null;

    public ConnectionDB() {
        this.host = "jdbc:mysql://db4free.net:3306/facturatest1234?serverTimezone=UTC";
        this.user = "adminfactura1234";
        this.password = "adminfactura1234";
    }

    
    public void openConnection() {
        
        try{
            
            Properties properties = new Properties();

            properties.setProperty("user", this.user);
            properties.setProperty("password", this.password);
            properties.setProperty("useSSL", "false");
                  
            //obtenemos el driver mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtenemos la conexión
            connectionDB = (Connection) DriverManager.getConnection(this.host, properties);

            if (connectionDB!=null){
                System.out.println("Conexión a Base de Datos Establecida");
            }
        }catch(SQLException e){
            System.out.println("Error de MySQL: \n" + e);
        }
        catch(ClassNotFoundException e){
            System.out.println("Clase no encontrada: \n"+e);
        }
        catch(Exception e){
            System.out.println("Se ha encontrado el siguiente error: \n"+e);
        }
    }
    
    public void closeConnection() {
        
        try {
            if (connectionDB != null) {
                connectionDB.close();
                System.out.println("Conexión Cerrada");
            }
        } catch (SQLException e){
            System.out.println("Error de MySQL: \n" + e);
        }
        
    }

    public Connection getConnectionDB() {
        return connectionDB;
    }    
    
}
