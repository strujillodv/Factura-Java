package Model;

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
    
    private final String codigo;
    private final String nombre;
    private final int cantidad;
    private final int valorUnitario;
    private final int totalNeto;
    private final int totalIva;
    private final int total;

    public ItemBill(String codigo, String nombre, int cantidad, int valorUnitario, int totalIva, int totalNeto, int total) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.totalNeto = totalNeto;
        this.totalIva = totalIva;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public int getTotalNeto() {
        return totalNeto;
    }

    public int getTotalIva() {
        return totalIva;
    }

    public int getTotal() {
        return total;
    }

    
}
