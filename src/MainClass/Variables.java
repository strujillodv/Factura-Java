package MainClass;


import Model.User;
import Model.Bill;
import Model.Cashier;
import Model.Product;
import Model.Store;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sergio Antonio TRujillo del Valle
 */
public class Variables {
    
    public static int user = 0;
    public static int bill = 0;
    public static int product = 0;
    public static String title = "Login";
    public static String img = "account";
    public static Store store;
    public static User client = new User("", "", "", "", 0);
    public static  ArrayList<User> users = new  ArrayList<User>();
    public static  ArrayList<Cashier> cashiers = new  ArrayList<Cashier>();
    public static  ArrayList<Product> products = new  ArrayList<Product>();
    public static  ArrayList<Bill> bills = new  ArrayList<Bill>();

}
