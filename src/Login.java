
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Login {
    
    // Definimos variables
    private final String user;
    private final String password;
    
    // Constructor asignando valores
    public Login(String user, String password){
        this.user = user;
        this.password = password;
    }
    
    // Comprobar usuario
    public int loginUser() {
        
        int response;
        
        boolean isUser = Variables.cashiers.stream().anyMatch(
            i -> user.equals(Integer.toString(i.getIdUser())) &&
                 password.equals(i.getPassword())
        );
        
        if (isUser) {
            response = Variables.cashiers.indexOf(Variables.cashiers.stream().filter(userId-> user.equals(Integer.toString(userId.getIdUser())))
            .findFirst()
            .get());
        } else {
            JOptionPane.showMessageDialog(
                null, 
                "La contraseña o el usuario, son incorrectos!\n por favor intente nuevamente...",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            response = -1;
        }
        return response;
    }
    
}
