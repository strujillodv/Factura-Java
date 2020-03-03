
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    static JLabel img, fisrtNameTitle, lastNameTitle, idUserTitle, pass, productListTitle, cantTitle, totalTitle, number;
    static JTextField cant, fisrtName, lastName, idUser;
    static DefaultTableModel cuadro;
    static DefaultTableCellRenderer alingCenter, alingRight;
    static JComboBox productList;
    public final String[] select;
    
    public ArrayList<ItemBill> listProduct;
    public String[][] listJTable;
    
    public String product;
    public String price;
    
    public String[] nombreColumnas = {"Nombre Producto","Cantidad","Valor Unitario","Total Venta"};
    
    public int numberBill;
    
    public BillFrame() {
    
        super(Variables.title);
                
        this.listProduct = new ArrayList<>();        
        this.listJTable = new String[listProduct.size()][4];
        
        this.product = "";
        this.price = "";
        
        this.numberBill = Variables.bills.size() + 1 ;
        
        select = new String[Variables.products.size()];        
        this.setProducs();
        
        idUserTitle = new JLabel("Id Usuario: ");
        idUserTitle.setBounds(10,20,120,25);
        
        idUser = new JTextField("");
        idUser.setBounds(130,20,155,25);
        
        searchUser = new JButton("Buscar Usuario");
        searchUser.setBounds(290,20,150,25);
        searchUser.setBorder(BorderFactory.createEmptyBorder());
        searchUser.setBackground(new Color(0,150,136));
        searchUser.setForeground(Color.white);
        searchUser.addActionListener(new ButtonListener());
        
        fisrtNameTitle = new JLabel("Nombre:");
        fisrtNameTitle.setBounds(10,60,120,25);
        
        Font fuenteNumber = new Font("helvetica", Font.PLAIN, 28);
        number = new JLabel("<html><div style=\"text-align: center;\">No. <br>" + numberBill + "</div></html>");
        number.setBounds(450,20,100, 80);
        number.setFont(fuenteNumber);
        
        fisrtName = new JTextField("");
        fisrtName.setBounds(130,60,155,25);
        
        saveUser = new JButton("Guardar Usuario");
        saveUser.setBounds(290,60,150,25);
        saveUser.setBorder(BorderFactory.createEmptyBorder());
        saveUser.setBackground(new Color(0,150,136));
        saveUser.setForeground(Color.white);
        saveUser.addActionListener(new ButtonListener());
        
        lastNameTitle = new JLabel("Apellido:");
        lastNameTitle.setBounds(10,90,120,25);
        
        lastName = new JTextField("");
        lastName.setBounds(130,90,155,25);
        
        productListTitle = new JLabel("Selecione Producto");
        productListTitle.setBounds(10,125,115,25);
        
        productList = new JComboBox(select);        
        productList.setBounds(130, 125, 155, 25);
        productList.addActionListener(new ComboBoxListener());
        
        cantTitle = new JLabel("Cantidad");
        cantTitle.setBounds(290,125,50,25);
        
        cant = new JTextField("0");
        cant.setBounds(345,125,30,25);
        
        addProduct = new JButton("Agregar Item");
        addProduct.setBounds( 380, 125, 150, 25);
        addProduct.setBorder(BorderFactory.createEmptyBorder());
        addProduct.setBackground(new Color(0,150,136));
        addProduct.setForeground(Color.white);
        addProduct.addActionListener(new ButtonListener());
        
        // Creación de la tabla de valores
        cuadro= new DefaultTableModel(listJTable,nombreColumnas);
        
        alingCenter = new DefaultTableCellRenderer();
        alingRight = new DefaultTableCellRenderer();
        alingCenter.setHorizontalAlignment(SwingConstants.CENTER);
        alingRight.setHorizontalAlignment(SwingConstants.RIGHT);
        
        table = new JTable(cuadro);
        
        table.getColumnModel().getColumn(1).setCellRenderer(alingCenter);
        table.getColumnModel().getColumn(2).setCellRenderer(alingRight);
        table.getColumnModel().getColumn(3).setCellRenderer(alingRight);
        
        Font fuente = new Font("helvetica", Font.PLAIN, 24);
        totalTitle = new JLabel("TOTAL: $ -------");
        totalTitle.setBounds(10, 300, 250, 50 );
        totalTitle.setFont(fuente);
        
        // Panel que muestra la tabla
        JScrollPane panelTabla = new JScrollPane();
        panelTabla.setViewportView(table);
        panelTabla.setViewportView(table);
        panelTabla.setBounds(10, 155, 525, 150);
        
        saveBill = new JButton("Guardar");
        saveBill.setBounds( 380, 310, 150, 30);
        saveBill.setFont(fuente);
        saveBill.setBorder(BorderFactory.createEmptyBorder());
        saveBill.setBackground(new Color(0,150,136));
        saveBill.setForeground(Color.white);
        saveBill.addActionListener(new ButtonListener());  
        
        //Configuración del marco General        
        Image icon = new ImageIcon(getClass().getResource("/img/cash-register.png")).getImage();
        setIconImage(icon);
        setLayout(null);
        setSize(550,380);
        setLocation(Variables.positionX, Variables.positionY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(idUserTitle);
        add(idUser);
        add(searchUser);
        add(number);
        
        add(fisrtNameTitle);
        add(fisrtName);
        
        add(saveUser);
        
        add(lastNameTitle);
        add(lastName);
        
        add(productListTitle);
        add(productList);
        add(cantTitle);
        add(cant);
        add(addProduct);
        add(panelTabla);
        add(totalTitle);
        
        add(saveBill);
    }
    
    public void addItem() {
        int cantidad = Integer.parseInt(cant.getText().trim());
        int precio = Integer.parseInt(this.price.trim());        
        if (cantidad > 0) {
            int valorTotal = cantidad*precio;
            String total = "$ "+valorTotal;
            listProduct.add(new ItemBill(this.product, cant.getText().trim(), "$ "+this.price, total));
            listJTable = new String[listProduct.size()][4];
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
            this.listJTable[i][0] = listProduct.get(i).getNombre();
            this.listJTable[i][1] = listProduct.get(i).getCantidad();
            this.listJTable[i][2] = listProduct.get(i).getValor();
            this.listJTable[i][3] = listProduct.get(i).getTotal();
        }
    }
    
    public String setTotal() {
        
        String total = "";
        int suma = 0;
        for(int i=0; i < listProduct.size(); i++) {
            suma = suma + Integer.parseInt(listProduct.get(i).getTotal().replaceAll("[$ ]", ""));
        }
        total = "$ " + suma;
        return total;
    }
    
    public void setProducs() {
        
        for(int i=0; i < Variables.products.size(); i++) {
            select[i]= Variables.products.get(i).getName() + " - " + Variables.products.get(i).getPrice();   
        }
    }
    
    
    public class ComboBoxListener implements ActionListener {
        // Metodo para los eventos de los botones
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            String item = (String)cb.getSelectedItem();
            
            String[] value = item.split("-");
            
            product = value[0];
            price = value[1].replaceAll("[$ ]", "");
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
                table.getColumnModel().getColumn(1).setCellRenderer(alingCenter);
                table.getColumnModel().getColumn(2).setCellRenderer(alingRight);
                table.getColumnModel().getColumn(3).setCellRenderer(alingRight);
            }
            else if (e.getSource() == searchUser) {
                
                int index = -1;
                
                boolean isUser = Variables.users.stream().anyMatch(
                    i -> idUser.getText().equals(Integer.toString(i.getIdUser()))
                );
                
                if (isUser) {
                    index = Variables.users.indexOf(
                        Variables.users
                            .stream().filter(userId-> idUser.getText().equals(Integer.toString(userId.getIdUser())))
                            .findFirst().get()
                            );
                
                } 
                
                if (index >= 0) {
                    fisrtName.setText(Variables.users.get(index).getFirstName());
                    lastName.setText(Variables.users.get(index).getLastName());
                } else {
                    fisrtName.setText("");
                    lastName.setText("");
                    JOptionPane.showMessageDialog(
                        null, 
                        "El usuario no existe, ingrese los datos \ny guardelo en el Sistema.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            else if (e.getSource() == saveUser) {
                Variables.users.add(new User(fisrtName.getText(),lastName.getText(), "User-men-2", Integer.parseInt(idUser.getText().trim())));
                JOptionPane.showMessageDialog(
                    null, 
                    "El usuario fue guardado en el Sistema."
                );
            }
            else if (e.getSource() == saveBill) {
                
                Variables.title = "Factura No. " + numberBill;
                
                Variables.bills.add(
                    new Bill(
                        "No. " + numberBill,
                        Integer.parseInt(idUser.getText().trim()),
                        fisrtName.getText() + " " +lastName.getText(),
                        listJTable,
                        totalTitle.getText()
                    )
                );
                
                PrintBill print = new PrintBill();
                print.setVisible(true);
                dispose();
            }
        }
    }
}
