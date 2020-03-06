package MainClass;

import DataBase.Bills;
import View.MainFrame;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Antonio Trujillo del Valle
 */
public class Main {

    /**
     * @param args the command line arguments
     */    
    
    public static void main(String[] args) {        
//        Data data = new Data();      
//        MainFrame login = new MainFrame();
//        login.setVisible(true);

          Bills bills = new Bills();
          String[][] list = new String[2][7];
          list[0][0] = "1-789";
          list[0][1] = "Mouse";
          list[0][2] = "2";
          list[0][3] = "106920";
          list[0][4] = "25080";
          list[0][5] = "66000";
          list[0][6] = "132000";
          
          list[1][0] = "3-879";
          list[1][1] = "Portatíl";
          list[1][2] = "1";
          list[1][3] = "931500";
          list[1][4] = "218500";
          list[1][5] = "1150000";
          list[1][6] = "1150000";
          
          bills.SetData(2, 3, 2, list, 0);
        
    }
    
}
