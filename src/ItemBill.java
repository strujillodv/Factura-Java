/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo
 */
public class ItemBill {
    
    private final String nombre;
    private final String cantidad;
    private final String valor;
    private final String total;

    public ItemBill(String nombre, String cantidad, String valor, String total) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
        this.total = total;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getValor() {
        return valor;
    }

    public String getTotal() {
        return total;
    }
    
    
    
}
