/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Bill {
    
    private final String number;
    private final int idUser;
    private final String nombre;
    private final String total;
    private final String[][] list;

    public Bill(String number, int idUser, String nombre, String[][] list, String total) {
        this.number = number;
        this.idUser = idUser;
        this.nombre = nombre;
        this.total = total;
        this.list = list;
    }

    public String getNumber() {
        return number;
    }
    
    public int getIdUser() {
        return idUser;
    }

    public String getNpmbre() {
        return nombre;
    }

    public String getTotal() {
        return total;
    }

    public String[][] getList() {
        return list;
    }
    
    
    
}
