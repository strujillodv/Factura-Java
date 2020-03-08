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
public class Product {
    
    private final int idProduct;
    private final String codigo;
    private final String name;
    private final int valorUnitario;
    private final int price;
    private final int iva;

    public Product(int idProduct, String codigo, String name, int valorUnitario, int price, int iva) {
        this.idProduct = idProduct;
        this.codigo = codigo;
        this.name = name;
        this.valorUnitario = valorUnitario;
        this.price = price;
        this.iva = iva;
    }

    
    
    public int getIdProduct() {
        return idProduct;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public int getPrice() {
        return price;
    }

    public int getIva() {
        return iva;
    }
    
    
    
}
