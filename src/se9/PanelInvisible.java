/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author user
 */
public class PanelInvisible extends MouseAdapter {

    JPanel p;
    String who;
    MainWindow main;

    PanelInvisible(JPanel parent, String who, MainWindow main) {
        this.p = parent;
        this.who = who;
        this.main = main;
    }

    public void mouseClicked​(MouseEvent e) {
        boolean isInstance = e.getComponent() instanceof JButton;
        if (isInstance) {
            JButton btn = (JButton) e.getComponent();
            btn.setBorderPainted(false);
        }
        if (who != "") {
            if (who == "SP") {
                this.main.add(this.main.SP);
            } else if (who == "MP") {
                this.main.add(this.main.MP);
            } else if (who == "BP") {
                this.main.add(this.main.BP);
            } else if (who == "GP") {
                this.main.add(this.main.GP);
            } else if (who == "GSP") {
                if(this.main.GSP==null) this.main.GSP=new GameSelectPanel(this.main);
                this.main.add(this.main.GSP);
            }
            
            this.main.remove(this.p);
            this.main.revalidate();
            this.main.repaint();
        }
        //this.p.parent.remove(this.p.parent.MP);

    }

    public void mouseEntered(MouseEvent e) {
        boolean isInstance = e.getComponent() instanceof JButton;
        if (isInstance) {
            JButton btn = (JButton) e.getComponent();
            //btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
            btn.setBorderPainted(true);// 显示边框
            Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
            btn.setBorder(etchedBorder);
            btn.setRolloverEnabled(true);
        }
    }

    public void mouseExited(MouseEvent e) {
        boolean isInstance = e.getComponent() instanceof JButton;
        if (isInstance) {
            JButton btn = (JButton) e.getComponent();
            //btn.setForeground(Color.black);// 设置字体颜色
            btn.setBorderPainted(false);// 隐藏边框
        }
    }

}
