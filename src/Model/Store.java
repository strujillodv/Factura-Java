/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Store {
    
    private final String name;
    private final String nit;
    private final String telephone;
    private final String adress;
    private final String imgUrl;
    private int idStore;

    public Store(String name, String nit, String telephone, String adress, String imgUrl) {
        this.name = name;
        this.nit = nit;
        this.telephone = telephone;
        this.adress = adress;
        this.imgUrl = imgUrl;
        this.idStore = 0;
    }

    public String getName() {
        return name;
    }

    public String getNit() {
        return nit;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdress() {
        return adress;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }    
    
}
