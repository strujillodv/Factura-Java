
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
    
    static JButton login, bills, newBill, addProduct, logout;
    static JLabel img, titleIdUser, pass;
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
        img.setBounds(75,10,150,150);
        
        titleIdUser = new JLabel("Usuario:");
        titleIdUser.setBounds(10, 160, 275, 30);
        titleIdUser.setFont(fuente);
        
        idUser = new JTextField();
        idUser.setBounds(10, 200, 275, 30);
        idUser.setFont(fuente);

        pass = new JLabel("Contraseña:");
        pass.setBounds(10, 240, 275, 30);
        pass.setFont(fuente);
        
        password = new JPasswordField();
        password.setBounds(10, 280, 275, 30);
        password.setFont(fuente);
        
        login = new JButton("Login");
        login.addActionListener(new ButtonListener());
        login.setBounds(50, 320, 200, 50);
        login.setFont(fuente);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setBackground(new Color(0,150,136));
        login.setForeground(Color.white);
        
        newBill = new JButton("<html><div style=\"text-align: center;\">Generar<br>Factura</div></html>");
        newBill.addActionListener(new ButtonListener());
        newBill.setBounds(75, 200, 150, 80);
        newBill.setFont(fuente);
        newBill.setBorder(BorderFactory.createEmptyBorder());
        newBill.setBackground(new Color(0,150,136));
        newBill.setForeground(Color.white);
        
        logout = new JButton("Salir");
        logout.addActionListener(new ButtonListener());
        logout.setBounds(75, 295, 150,80);
        logout.setFont(fuente);
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setBackground(new Color(0,150,136));
        logout.setForeground(Color.white);
        
        if (Variables.title.equals("Login")) {
            add(img);
            add(titleIdUser);
            add(idUser);
            add(pass);
            add(password);
            add(login);
        } else {
            add(img);
            titleIdUser.setText(
                Variables.cashiers.get(Variables.user).getFirstName() +
                Variables.cashiers.get(Variables.user).getLastName() + " - " + 
                Variables.cashiers.get(Variables.user).getRole()
            );
            add(titleIdUser);
            
            add(newBill);
            add(logout);
            
        }
        
        //Configuración del marco General
        Image icon = new ImageIcon(getClass().getResource("/img/cash-register.png")).getImage();
        setIconImage(icon);
        setLayout(null);
        setSize(300,420);
        setLocation(Variables.positionX, Variables.positionY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     private class ButtonListener implements ActionListener {
        
        // Metodo para los eventos de los botones
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            
            Variables.positionX = getLocation().x;
            Variables.positionY = getLocation().y; 
            
            if (e.getSource() == login) {
                Login login = new Login(idUser.getText().trim(), password.getText().trim());
                int response = login.loginUser();
                
                if (response >= 0) {
                    Variables.title = Variables.cashiers.get(response).getFirstName();
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
