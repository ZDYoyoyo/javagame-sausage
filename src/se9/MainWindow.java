/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se9;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author User
 */
public class MainWindow extends JFrame{    
    int initWidth = 814;//800+14
    int initHeight = 639;//600+7+31
    MainPanel MP;
     SelectPanel SP;
     BuildPanel BP;
     GamePanel GP;
     GameSelectPanel GSP;
    MainWindow(String title, String version) {
        super(title + version);

        this.setSize(initWidth, initHeight);

        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - initWidth) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - initHeight) / 2);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);//鎖定視窗大小
        
        
        /*
        MP = new MainPanel(MainWindow.this);
        SP= new SelectPanel(MainWindow.this);
        this.add(MP);
        */
        MP = new MainPanel(MainWindow.this);
        SP= new SelectPanel(MainWindow.this);
        BP=new BuildPanel(MainWindow.this);
        //GP=new GamePanel(MainWindow.this);
        this.add(MP);
        
        this.revalidate();
        this.repaint();
    }
}
