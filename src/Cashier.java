/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Cashier extends User{
    
    private final String password;
    private final String role;
    
    public Cashier(String firstName, String lastName, String img, int idUser, String pass, String role) {
        super(firstName, lastName, img, idUser);
        this.password = pass;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    
    
    
}
