package Model;

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

    private final String name, telephone, adress, img;
    private final int idNumber;
    private int idUser;

    public User(String name, String telephone, String adress, String img, int idNumber) {
        this.name = name;
        this.telephone = telephone;
        this.adress = adress;
        this.img = img;
        this.idNumber = idNumber;
        this.idUser = 0;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdress() {
        return adress;
    }

    public String getImg() {
        return img;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
}
