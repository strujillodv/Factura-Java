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
        Variables.cashiers.add(new Cashier("Sergio", "Trujillo", "User-men-1", 1075660396, "password", "Cajero"));
        Variables.cashiers.add(new Cashier("Yury", "Tavera", "User-women-1", 35423813, "password", "Cajera"));
        
        // Ingresamos los datos de los usuarios
        Variables.users.add(new User("Antonio", "Trujillo", "User-men-2", 20625006));
        Variables.users.add(new User("Maria", "Malaver", "User-women-2", 627812));
        Variables.users.add(new User("Tatiana", "Gomez", "User-women-1", 1024652123));
        Variables.users.add(new User("Emiliano", "Segura", "User-men-1", 8032145));
        
        // Ingresamos los datos de los Productos
        Variables.products.add(new Product("", ""));
        Variables.products.add(new Product("Mouse", "$ 70000"));
        Variables.products.add(new Product("Portatil", "$ 1200000"));
        Variables.products.add(new Product("Teclado", "$ 110000"));
        Variables.products.add(new Product("Web Cam", "$ 80000"));
        Variables.products.add(new Product("Altavoces", "$ 60000"));
        
    }
}
