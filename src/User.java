/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class User {

    private final String firstName;    
    private final String lastName;
    private final String img;
    private final int idUser;

    public User(String firstName, String lastName, String img, int idUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
        this.idUser = idUser;
    }

    User(String sergio, String trujillo, String user) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImg() {
        return img;
    }

    public int getIdUser() {
        return idUser;
    }
    
       
    
}
