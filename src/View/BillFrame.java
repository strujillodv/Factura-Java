package View;

import DataBase.Bills;
import MainClass.Variables;
import Model.Bill;
import Model.ItemBill;
import Model.Product;
import Model.Store;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public final class BillFrame extends JFrame {
    
    static JTable table;
    static JButton addProduct, searchUser, saveUser, saveBill;
    static JLabel img, userNameTitle, telephoneTitle, idUserTitle, pass, productListTitle, cantTitle, totalTitle, number;
    static JTextField cant, userName, telephone, idUser;
    static DefaultTableModel cuadro;
    static DefaultTableCellRenderer alingCenter, alingRight;
    static JComboBox productList;
    public final String[] select;
    public Store store;
    
    public ArrayList<ItemBill> listProduct;
    public String[][] listJTable;
    
    public Stream<Product> productItem;
    
    public int numberBill;
    public int code;
    public int totalBill;
    public String productName;
    public String price;
    
    public String[] nombreColumnas = {"Codigo","Nombre","Cantidad","Valor U","Total Iva 19%","Total Neto","Total Venta"};
    
    public BillFrame() {
    
        super(Variables.title);
                
        this.listProduct = new ArrayList<>();        
        this.listJTable = new String[listProduct.size()][7];
        
        this.code = 0;
        this.productName = "";
        this.price = "";
        this.totalBill = 0;
        
        this.numberBill = Variables.bills.size() + 1 ;
        
        select = new String[Variables.products.size()];        
        this.setProducs();
        
        idUserTitle = new JLabel("Id Usuario: ");
        idUserTitle.setBounds(10,20,120,25);
        
        idUser = new JTextField(Variables.client.getIdNumber());
        idUser.setBounds(130,20,155,25);
        
        searchUser = new JButton("Buscar Usuario");
        
        searchUser.setBorder(BorderFactory.createEmptyBorder());
        searchUser.setBackground(new Color(0,150,136));
        searchUser.setForeground(Color.white);
        searchUser.addActionListener(new ButtonListener());
        
        userNameTitle = new JLabel("Nombre:");
        
        
        Font fuenteNumber = new Font("helvetica", Font.PLAIN, 28);
        number = new JLabel("<html><div style=\"text-align: center;\">No. <br>" + numberBill + "</div></html>");
        number.setFont(fuenteNumber);
        
        userName = new JTextField(Variables.client.getName());
        
        
        
        saveUser = new JButton("Guardar Usuario");
       
        saveUser.setBorder(BorderFactory.createEmptyBorder());
        saveUser.setBackground(new Color(0,150,136));
        saveUser.setForeground(Color.white);
        saveUser.addActionListener(new ButtonListener());
        
        telephoneTitle = new JLabel("Telefono:");
        
        telephone = new JTextField(Variables.client.getTelephone());        
        
        productListTitle = new JLabel("Selecione Producto");        
        
        productList = new JComboBox(select);        
        
        productList.addActionListener(new ComboBoxListener());
        
        cantTitle = new JLabel("Cantidad");
        
        cant = new JTextField("0");
        
        
        addProduct = new JButton("Agregar Item");
        
        addProduct.setBorder(BorderFactory.createEmptyBorder());
        addProduct.setForeground(Color.white);
        addProduct.addActionListener(new ButtonListener());
        addProduct.setBackground(new Color(0,150,136));
        
        // Creación de la tabla de valores
        cuadro= new DefaultTableModel(listJTable,nombreColumnas);
        
        alingCenter = new DefaultTableCellRenderer();
        alingRight = new DefaultTableCellRenderer();
        alingCenter.setHorizontalAlignment(SwingConstants.CENTER);
        alingRight.setHorizontalAlignment(SwingConstants.RIGHT);
        
        table = new JTable(cuadro);
        
        table.getColumnModel().getColumn(0).setCellRenderer(alingCenter);
        table.getColumnModel().getColumn(1).setCellRenderer(alingCenter);
        table.getColumnModel().getColumn(2).setCellRenderer(alingCenter);
        table.getColumnModel().getColumn(3).setCellRenderer(alingRight);
        table.getColumnModel().getColumn(4).setCellRenderer(alingRight);
        table.getColumnModel().getColumn(5).setCellRenderer(alingRight);
        table.getColumnModel().getColumn(6).setCellRenderer(alingRight);
        
        Font fuente = new Font("helvetica", Font.PLAIN, 24);
        totalTitle = new JLabel("TOTAL: $ -------");
        totalTitle.setFont(fuente);
        
        // Panel que muestra la tabla
        JScrollPane panelTabla = new JScrollPane();
        panelTabla.setViewportView(table);
        panelTabla.setViewportView(table);
        
        saveBill = new JButton("Guardar");
        saveBill.setFont(fuente);
        saveBill.setBorder(BorderFactory.createEmptyBorder());
        saveBill.setBackground(new Color(0,150,136));
        saveBill.setForeground(Color.white);
        saveBill.addActionListener(new ButtonListener());  
        
        
        // Ubicación de los elementos
                
        searchUser.setBounds(290,20,150,25);
        userNameTitle.setBounds(10,60,120,25);
        number.setBounds(670,20,100, 80);
        userName.setBounds(130,60,155,25);
        saveUser.setBounds(290,60,150,25);
        telephoneTitle.setBounds(10,90,120,25);
        telephone.setBounds(130,90,155,25);
        
        productListTitle.setBounds(10,125,115,25);
        productList.setBounds(130, 125, 255, 25);
        
        cantTitle.setBounds(390,125,50,25);
        cant.setBounds(450,125,30,25);
        
        addProduct.setBounds( 500, 125, 150, 25);
        
        panelTabla.setBounds(10, 155, 760, 250);
        totalTitle.setBounds(10, 420, 250, 50 );
        saveBill.setBounds( 620, 430, 150, 30);
        
        add(idUserTitle);
        add(idUser);
        add(searchUser);
        add(number);
        
        add(userNameTitle);
        add(userName);
        
        
        add(telephoneTitle);
        add(telephone);
        
        add(productListTitle);
        add(productList);
        add(cantTitle);
        add(cant);
        add(addProduct);
        add(panelTabla);
        
        add(totalTitle);
        add(saveBill);
        
        //Configuración del marco General        
        Image icon = new ImageIcon(getClass().getResource("/img/cash-register.png")).getImage();
        setIconImage(icon);
        setLayout(null);
        setSize(800,520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addItem() {
        
        Product io = Variables.products.get(code);
        System.out.println(io.getName());
        
        int cantidad = Integer.parseInt(cant.getText().trim());
        
        int vUnitario = io.getValorUnitario();
        int iva = cantidad*io.getIva();
        int vUnitarioTotal = cantidad*io.getPrice();
        int precio = io.getValorUnitario();
        
        if (cantidad > 0) {
            int valorTotal = cantidad*precio;
            
            listProduct.add(new ItemBill(io.getCodigo(), io.getName(), cantidad, vUnitario, iva, vUnitarioTotal, valorTotal));
            listJTable = new String[listProduct.size()][7];
            cant.setText("0");
            setTable();
        } else {
            JOptionPane.showMessageDialog(
                null, 
                "La cantidad no puede ser 0\n por favor intente nuevamente...",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );        
        }
    }
    
    public void setTable() {
        
        for(int i=0; i < listProduct.size(); i++) {
            this.listJTable[i][0] = listProduct.get(i).getCodigo();
            this.listJTable[i][1] = listProduct.get(i).getNombre();
            this.listJTable[i][2] = "" + listProduct.get(i).getCantidad();
            this.listJTable[i][3] = "$ " + listProduct.get(i).getValorUnitario();
            this.listJTable[i][4] = "$ " + listProduct.get(i).getTotalIva();
            this.listJTable[i][5] = "$ " + listProduct.get(i).getTotalNeto();
            this.listJTable[i][6] = "$ " + listProduct.get(i).getTotal();
        }
    }
    
    public String setTotal() {
        
        String total = "";
        int suma = 0;
        for(int i=0; i < listProduct.size(); i++) {
            suma = suma +listProduct.get(i).getTotal();
        }
        total = "$ " + suma;
        totalBill = suma;
        return total;
    }
    
    public void setProducs() {
        
        for(int i=0; i < Variables.products.size(); i++) {
            select[i]= Variables.products.get(i).getCodigo() + " - " + Variables.products.get(i).getName() + " - " + Variables.products.get(i).getValorUnitario();   
        }
    }
    
    
    public class ComboBoxListener implements ActionListener {
        // Metodo para los eventos de los botones
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            code = cb.getSelectedIndex();  
        }
    }
    
    public class ButtonListener implements ActionListener {
        
        // Metodo para los eventos de los botones
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            
            if(e.getSource() == addProduct) {
                
                addItem();
                totalTitle.setText("TOTAL: " + setTotal());
                cuadro.setDataVector(listJTable, nombreColumnas);
                table.getColumnModel().getColumn(0).setCellRenderer(alingCenter);
                table.getColumnModel().getColumn(1).setCellRenderer(alingCenter);
                table.getColumnModel().getColumn(2).setCellRenderer(alingCenter);
                table.getColumnModel().getColumn(3).setCellRenderer(alingRight);
                table.getColumnModel().getColumn(4).setCellRenderer(alingRight);
                table.getColumnModel().getColumn(5).setCellRenderer(alingRight);
                table.getColumnModel().getColumn(6).setCellRenderer(alingRight);
            }
            else if (e.getSource() == searchUser) {
                
                int index = -1;
                
                boolean isUser = Variables.users.stream().anyMatch(
                    user -> idUser.getText().equals(Integer.toString(user.getIdNumber()))
                );
                
                if (isUser) {
                    index = Variables.users.indexOf(
                        Variables.users
                        .stream().filter(userId-> idUser.getText().equals(Integer.toString(userId.getIdNumber())))
                        .findFirst().get()
                    );
                
                } 
                
                if (index >= 0) {
                    Variables.client = Variables.users.get(index);
                    userName.setText(Variables.client.getName());
                    telephone.setText(Variables.client.getTelephone());
                } else {
                    userName.setText("");
                    telephone.setText("");
                    JOptionPane.showMessageDialog(
                        null, 
                        "El usuario no existe, ingrese los datos \ny guardelo en el Sistema.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            else if (e.getSource() == saveBill) {
                
                Variables.title = "Factura No. " + numberBill;
                
                Variables.bills.add(
                    new Bill(
                        numberBill,
                        Variables.client,
                        Variables.store,
                        listJTable,                        
                        totalBill
                    )
                );
                
                Bills saveBillDB = new Bills();
                
                saveBillDB.SetData(
                        numberBill,
                        Variables.client.getIdUser(),
                        Variables.store.getIdStore(),
                        listJTable,
                        totalBill);
                
                PrintBill print = new PrintBill();
                print.setVisible(true);
                dispose();
            }
        }
    }
}
