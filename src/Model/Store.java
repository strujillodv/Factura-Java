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

    /**
     *
     * @param name
     * @param nit
     * @param telephone
     * @param adress
     * @param imgUrl
     */
    public Store(String name, String nit, String telephone, String adress, String imgUrl) {
        this.name = name;
        this.nit = nit;
        this.telephone = telephone;
        this.adress = adress;
        this.imgUrl = imgUrl;
        this.idStore = 0;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getNit() {
        return nit;
    }

    /**
     *
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     *
     * @return
     */
    public String getAdress() {
        return adress;
    }

    /**
     *
     * @return
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     *
     * @return
     */
    public int getIdStore() {
        return idStore;
    }

    /**
     *
     * @param idStore
     */
    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }    
    
}
