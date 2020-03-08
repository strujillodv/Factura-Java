package View;


import Model.Login;
import MainClass.Variables;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class MainFrame extends JFrame {
    
    static JButton login, logout, newBill, bills, users, products;
    static JLabel img, titleName, titleIdUser, pass;
    static JTextField idUser;
    static JPasswordField password;
    
    public MainFrame() {
    
        super(Variables.title);
        
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/"+ Variables.img +".png"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon (imagen.getScaledInstance(150,150,Image.SCALE_SMOOTH));
        Font fuente = new Font("helvetica", Font.PLAIN, 18);
        
        img = new JLabel();        
        img.setIcon(iconoEscalado);        
        
        titleName = new JLabel("");
        titleName.setFont(fuente);
        
        titleIdUser = new JLabel("Usuario:");
        titleIdUser.setFont(fuente);
        
        idUser = new JTextField();
        idUser.setFont(fuente);

        pass = new JLabel("Contraseña:");
        pass.setFont(fuente);
        
        password = new JPasswordField();
        password.setFont(fuente);
        
        login = new JButton("Login");
        login.addActionListener(new ButtonListener());
        login.setFont(fuente);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setBackground(new Color(0,150,136));
        login.setForeground(Color.white);
        
        newBill = new JButton("<html><div style=\"text-align: center;\">Generar<br>Factura</div></html>");
        newBill.addActionListener(new ButtonListener());
        newBill.setFont(fuente);
        newBill.setBorder(BorderFactory.createEmptyBorder());
        newBill.setBackground(new Color(0,150,136));
        newBill.setForeground(Color.white);
        
        bills = new JButton("<html><div style=\"text-align: center;\">Listar<br>Facturas</div></html>");
        bills.addActionListener(new ButtonListener());
        bills.setFont(fuente);
        bills.setBorder(BorderFactory.createEmptyBorder());
        bills.setBackground(new Color(0,150,136));
        bills.setForeground(Color.white);
        
        users = new JButton("<html><div style=\"text-align: center;\">Usuarios</div></html>");
        users.addActionListener(new ButtonListener());
        users.setFont(fuente);
        users.setBorder(BorderFactory.createEmptyBorder());
        users.setBackground(new Color(0,150,136));
        users.setForeground(Color.white);
        
        products = new JButton("<html><div style=\"text-align: center;\">Productos</div></html>");
        products.addActionListener(new ButtonListener());
        products.setFont(fuente);
        products.setBorder(BorderFactory.createEmptyBorder());
        products.setBackground(new Color(0,150,136));
        products.setForeground(Color.white);
        
        logout = new JButton("Salir");
        logout.addActionListener(new ButtonListener());
        logout.setFont(fuente);
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setBackground(new Color(0,150,136));
        logout.setForeground(Color.white);
        
        initComponents();
        
        
    }
    
    private void initComponents() {
        
               
        if (Variables.title.equals("Login")) {
            
            //Posición de los elementos
            img.setBounds(325, 50,150,150);
            titleIdUser.setBounds(250, 200, 300, 30);
            idUser.setBounds(250, 240, 300, 30);
            pass.setBounds(250, 280, 300, 30);
            password.setBounds(250, 320, 300, 30);
            login.setBounds(300, 370, 200, 50);
   
            add(password);
            add(login);
            
        } else {
            
            img.setBounds(50, 50,150,150);
            titleName.setBounds(230, 140, 300, 30);
            titleIdUser.setBounds(230, 100, 300, 30);
            pass.setBounds(230, 180, 300, 30);
            newBill.setBounds(35, 300, 132, 100);
            bills.setBounds(180, 300, 132,100);
            users.setBounds(322, 300, 132,100);
            products.setBounds(464, 300, 132,100);
            logout.setBounds(606, 300, 132,100);
            
            titleName.setText("Nombre: " + Variables.cashiers.get(Variables.user).getName());
            titleIdUser.setText("Usuario: " + Variables.cashiers.get(Variables.user).getIdUser());
            pass.setText("Rol: " + Variables.cashiers.get(Variables.user).getRole());
            
            add(titleName);
            add(newBill);
            add(bills);
            add(users);
            add(products);
            add(logout);
            
        }
        
        add(img);
        add(titleIdUser);            
        add(idUser);
        add(pass);
        
        //Configuración del marco General
        Image icon = new ImageIcon(getClass().getResource("/img/cash-register.png")).getImage();
        setIconImage(icon);
        setLayout(null);
        setSize(800,520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     private class ButtonListener implements ActionListener {
        
        // Metodo para los eventos de los botones
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            
            if (e.getSource() == login) {
                Login login = new Login(idUser.getText().trim(), password.getText().trim());
                int response = login.loginUser();
                
                if (response >= 0) {
                    Variables.title = Variables.cashiers.get(response).getName();
                    Variables.img = Variables.cashiers.get(response).getImg();
                    
                    Variables.user = response;
                    
                    MainFrame userFrame = new MainFrame();
                    userFrame.setVisible(true);
                    dispose();
                    
                } else {
                    idUser.setText("");
                    password.setText("");
                }              
            } 
            else if (e.getSource() == newBill) {
                Variables.title = "Generar Factura";
                BillFrame billFrame = new BillFrame();
                billFrame.setVisible(true);
                dispose();
            
            } 
            else if (e.getSource() == logout) {
                Variables.title = "Login";
                Variables.img = "account";
                idUser.setText("");
                password.setText("");
                MainFrame loginFrame = new MainFrame();
                loginFrame.setVisible(true);
                dispose();
            
            } 
        }
     }
}
