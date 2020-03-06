package MainClass;

import DataBase.Bills;
import DataBase.Products;
import DataBase.Users;
import Model.Cashier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Data {
    
    public Data(){
        
        // Ingresamos los datos de los trabajadores
        Variables.cashiers.add(new Cashier("Sergio Antonio Trujillo del valle", "3144000233", "Cra 9 No. 4-08, of 2-09", "User-men-1", 1075660396, "password", "Cajero"));
        Variables.cashiers.add(new Cashier("Yury Tavera Gomez", "3213850184", "Cra 5 No 2-08", "User-women-1", 35423813, "password", "Cajera"));
        
        // Cargamos la información de los Productos
        //Variables.products.add(new Product("", "", "", 0.0));
        Products productsDb = new Products();
        productsDb.getQuery();
        
        // Cargamos la información de los Usuarios
        Users usersDb = new Users();
        usersDb.getQuery();
        
        // Cargamos la información de las Facturas
        Bills billDb = new Bills();        
        billDb.getQuery();
        
    }
}
