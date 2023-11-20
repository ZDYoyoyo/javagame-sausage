/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se9;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author User
 */
public class GameSelectPanel extends JPanel {

    MainWindow parent;
    static int nowplace = 1;
    static int nowfile = 0;
    static int page = 1;
    Vector<Display> Displays = new Vector<Display>();
    JLayeredPane layeredPane =new JLayeredPane();
    GameSelectPanel(MainWindow p) {
        super();
        parent = p;
        PanelInvisible SP = new PanelInvisible(this, "SP", this.parent);
        PanelInvisible temp = new PanelInvisible(this, "", this.parent);
        layeredPane.setBounds(0, 0, 800, 600);
        this.add(layeredPane);
        
        JLabel background = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\gsp.jpg").getScaledInstance(800, 600, 0)));
        background.setBounds(0, 0, 800, 600);
        //this.add(background);
        layeredPane.add(background,JLayeredPane.DEFAULT_LAYER);
        
        this.setLayout(null);
        this.setVisible(true);

        JButton back = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\返回-去背.png").getScaledInstance(69, 63, 0)));
        back.setBounds(25, 514, 69, 63);
        back.setContentAreaFilled(false);
        back.setBorder(null);
        back.addMouseListener(SP);
        layeredPane.add(back,JLayeredPane.MODAL_LAYER);

        JLabel wb1 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\gsp-b1.jpg").getScaledInstance(59, 74, 0)));
        wb1.setBounds(50, 273, 59, 74);
        layeredPane.add(wb1,JLayeredPane.MODAL_LAYER);

        JLabel wb2 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\gsp-b2.jpg").getScaledInstance(59, 74, 0)));
        wb2.setBounds(710, 273, 59, 74);
        layeredPane.add(wb2,JLayeredPane.MODAL_LAYER);

        //建立一個顯示關卡物件 決定好8個位置 設置一個變數從1開始決定在第幾個位置放圖片 
        //                                再設置一個變數從0開始決定目前是第幾個檔案
        showpic();

        wb1.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {
                if (page == 1) {

                } else {
                    Display l;
                    for (int i = 0; i < Displays.size(); i++) {
                        l = Displays.elementAt(i);
                       layeredPane.remove(l);
                    }
                    Displays.clear();
                    nowplace = 1;
                    page--;
                    nowfile = (page - 1) * 8;
                    showpic();
                    
                    GameSelectPanel.this.parent.revalidate();
                    GameSelectPanel.this.parent.repaint();
                }
            }
        });

        wb2.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {

                Display l;
                for (int i = 0; i < Displays.size(); i++) {
                    l = Displays.elementAt(i);
                    layeredPane.remove(l);
                }
                Displays.clear();
                nowplace = 1;
                nowfile = page * 8;
                showpic();
                page++;
                GameSelectPanel.this.parent.revalidate();
                GameSelectPanel.this.parent.repaint();
            }
        });

        
    }

    public void showpic() {
        for (int i = 0; i < 8; i++) {
            System.out.println(nowfile);
            String s = Integer.toString(nowfile);
            File name = new File("build" + s + ".jpg");
            if (name.exists()) {
                Display display = new Display(nowplace, nowfile, this.parent, GameSelectPanel.this);
                switch (nowplace) {
                    case 1:
                        display.setBounds(168, 171, 97, 94);
                        break;
                    case 2:
                        display.setBounds(296, 171, 97, 94);
                        break;
                    case 3:
                        display.setBounds(424, 171, 97, 94);
                        break;
                    case 4:
                        display.setBounds(552, 171, 97, 94);
                        break;
                    case 5:
                        display.setBounds(168, 356, 97, 94);
                        break;
                    case 6:
                        display.setBounds(296, 356, 97, 94);
                        break;
                    case 7:
                        display.setBounds(424, 356, 97, 94);
                        break;
                    case 8:
                        display.setBounds(552, 356, 97, 94);
                        break;
                }
                
                Displays.add(display);
                GameSelectPanel.this.add(display);
                layeredPane.add(display,JLayeredPane.MODAL_LAYER);
                nowplace++;
                nowfile++;
                GameSelectPanel.this.parent.revalidate();
                GameSelectPanel.this.parent.repaint();

            } else {
                break;
            }
        }
    }

}

class Display extends JPanel {

    MainWindow parent;
    GameSelectPanel Gparent;

    public Display(int place, int file, MainWindow p, GameSelectPanel gp) {
        super();
        this.parent = p;
        this.Gparent = gp;

        this.setLayout(null);
        String s = Integer.toString(file);
        JLabel display = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\build" + s + ".jpg").getScaledInstance(97, 94, 0)));
        display.setBounds(0, 0, 97, 94);
        this.add(display);

        this.addMouseListener(new MouseAdapter() {

            public void mouseClicked​(MouseEvent e) {
                String s = Integer.toString(file);
                Display.this.parent.GP = new GamePanel(Display.this.parent, s, 0);
                Display.this.parent.add(Display.this.parent.GP);
                Display.this.parent.remove(Display.this.Gparent);
                Display.this.parent.revalidate();
                Display.this.parent.repaint();

            }

        });

    }

}
