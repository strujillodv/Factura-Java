package View;

import MainClass.Variables;
import Model.Bill;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio trujillo del Valle
 */
public final class PrintBill extends JFrame {
    
    static JButton newBill, logout;
    static JLabel number, name, idUser, list, total;
    
    public PrintBill() {
        
        super(Variables.title);
        
        Bill bill = Variables.bills.get(Variables.bills.size()-1);
        
        Font fuente = new Font("helvetica", Font.PLAIN, 18);
        Font fuenteTotal = new Font("helvetica", Font.PLAIN, 24);
        
        number = new JLabel("Factura " + bill.getNumber());
        number.setFont(fuente);
        //idUser = new JLabel("Documento No. " +bill.getIdUser());
        idUser.setFont(fuente);        
        //name = new JLabel("Nombre " + bill.getNpmbre());
        name.setFont(fuente);
                
        list = new JLabel("<html>" + setList(bill.getList()) + "<hr></html>");
        list.setFont(fuente);        
        
        //total = new JLabel(bill.getTotal());
        total.setFont(fuenteTotal);
        
        newBill = new JButton("Nueva Factura");
        newBill.setBounds(5, 320,135,50);
        newBill.setFont(fuente);
        newBill.setBorder(BorderFactory.createEmptyBorder());
        newBill.setBackground(new Color(0,150,136));
        newBill.setForeground(Color.white);
        newBill.addActionListener(new ButtonListener());  
        
        logout = new JButton("Salir");
        logout.setBounds(150, 320,135,50);
        logout.setFont(fuente);
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setBackground(new Color(0,150,136));
        logout.setForeground(Color.white);
        logout.addActionListener(new ButtonListener()); 
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 0, 10));
        JScrollPane scroll = new JScrollPane();
        
        panel.add(number);
        panel.add(name);
        panel.add(list);
        panel.add(total);
        
        scroll.setViewportView(panel);
        scroll.setBounds(0,0,300,300);
        
        //Configuración del marco General        
        Image icon = new ImageIcon(getClass().getResource("/img/cash-register.png")).getImage();
        setIconImage(icon);
        setLayout(null);
        setSize(300,420);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(scroll);
        add(newBill);
        add(logout);
    }
    
    public String setList(String[][] data) {
        
        String text = "";
        
        for (int i=0; i < data.length; i++) {
            text = text + data[i][1] + " - " + data[i][0] + " - " + data[i][3] + "<br>";
        }
        
        return text;
    }
    
    public class ButtonListener implements ActionListener {
        
        // Metodo para los eventos de los botones
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            
            if (e.getSource() == logout) {
                Variables.title = "Login";
                Variables.img = "account";
                MainFrame loginFrame = new MainFrame();
                loginFrame.setVisible(true);
                dispose();
            
            }
            else if (e.getSource() == newBill) {
                Variables.title = "Generar Factura";
                BillFrame billFrame = new BillFrame();
                billFrame.setVisible(true);
                dispose();
            
            } 
        }
    }
    
}
