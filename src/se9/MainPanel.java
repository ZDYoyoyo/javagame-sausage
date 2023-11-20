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
public class MainPanel extends JPanel {

    MainWindow parent;

    MainPanel(MainWindow p) {
        super();
        parent = p;
        //PanelInvisible l = new PanelInvisible(this, "SP", this.parent);
        this.setLayout(null);
        /*
        Color NC = new Color(237, 230, 232);//皮膚偏粉?
        this.setBackground(NC);*/
        
        JLabel img = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\LINE_ALBUM_第八週UI介面初稿_211106.jpg").getScaledInstance(800, 600, 0)));//785,561
        img.setBounds(0, 0, 800, 600);
        this.add(img);
        this.setVisible(true);
        
        
        img.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e)
        {
        parent.add(parent.SP);
        parent.remove(parent.MP);
        parent.revalidate();
        parent.repaint();
        }
        });
        //addMouseListener(l);
        
        
        
    }
}

/*
public class MainPanel extends JPanel {

    MainWindow parent;

    MainPanel(MainWindow p) {
        super();
        parent = p;
        PanelInvisible l = new PanelInvisible(this, "SP", this.parent);
        this.setLayout(null);
        
        Color NC = new Color(237, 230, 232);//皮膚偏粉?
        this.setBackground(NC);
        
        
        Label L1 = new Label("腸直入");
        Label L2 = new Label("一");
        Label L3 = new Label("ㄤ");
        Label L4 = new Label("ˊ");
        Label L5 = new Label("－點擊畫面開始－");

        L1.setFont(new Font("標楷體", Font.PLAIN, 70));
        L2.setFont(new Font("標楷體", Font.PLAIN, 35));
        L3.setFont(new Font("標楷體", Font.PLAIN, 35));
        L4.setFont(new Font("標楷體", Font.PLAIN, 70));
        L5.setFont(new Font("標楷體", Font.PLAIN, 70));

        L1.setBounds(360, 25, 70 * 3, 70);
        L2.setBounds(300, 25, 35, 35);
        L3.setBounds(300, 60, 35, 35);
        L4.setBounds(335, 40, 35, 70);
        L5.setBounds(120, 450, 70 * 8, 70);

        this.add(L1);
        this.add(L2);
        this.add(L3);
        this.add(L4);
        this.add(L5);
        
        //JLabel L1 = new JLabel( new ImageIcon("C:.\\pictures\\20210225002165.jpg"));
        //JLabel​(Icon image)>>ImageIcon​(Image image)>>Tookit.getImage 和縮放
        
        
        JLabel img = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\20210225002165.jpg").getScaledInstance(200, 200, 200)));
        img.setBounds(300, 160, 200, 200);
        this.add(img);
        
        
       
        
        
        L1.addMouseListener(l);
        L2.addMouseListener(l);
        L3.addMouseListener(l);
        L4.addMouseListener(l);
        L5.addMouseListener(l);
        

        img.addMouseListener(l);
        addMouseListener(l);
        
        
        
    }
}
*/