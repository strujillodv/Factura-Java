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
public class Bill {
    
    private final int number;
    private final User user;
    private final Store store;
    private final String[][] list;
    private final int total;

    public Bill(int number, User user, Store store, String[][] list, int total) {
        this.number = number;
        this.user = user;
        this.store = store;
        this.list = list;
        this.total = total;
    }

    public int getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }

    public Store getStore() {
        return store;
    }

    public String[][] getList() {
        return list;
    }

    public int getTotal() {
        return total;
    }    
    
}
