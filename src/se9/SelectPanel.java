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
 * @author User
 */
public class SelectPanel extends JPanel {

    MainWindow parent;

    SelectPanel(MainWindow p) {
        super();
        parent = p;
        PanelInvisible MP = new PanelInvisible(this, "MP", this.parent);
        PanelInvisible BP = new PanelInvisible(this, "BP", this.parent);
        PanelInvisible GP = new PanelInvisible(this, "GP", this.parent);
        PanelInvisible GSP = new PanelInvisible(this, "GSP", this.parent);
        
        PanelInvisible temp = new PanelInvisible(this, "", this.parent);

        this.setLayout(null);
        this.setVisible(true);
        //addMouseListener(l);

        JButton back = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\返回-去背.png").getScaledInstance(69, 63, 0)));
        back.setBounds(25, 514, 69, 63);
        back.setContentAreaFilled(false);
        back.setBorder(null);
        back.addMouseListener(MP);
        this.add(back);

        JLabel Developer = new JLabel("－軟體工程第九組");
        Developer.setFont(new Font("標楷體", Font.PLAIN, 30));
        Developer.setBounds(520, 539, 35 * 11, 35);
        this.add(Developer);

        JButton B1 = new JButton("－ 新遊戲/繼續遊戲");
        JButton B2 = new JButton("－ 關卡選擇       ");
        JButton B3 = new JButton("－ 建造關卡       ");
        JButton B4 = new JButton("－ 設定           ");

        B1.setFont(new Font("標楷體", Font.PLAIN, 40));
        B2.setFont(new Font("標楷體", Font.PLAIN, 40));
        B3.setFont(new Font("標楷體", Font.PLAIN, 40));
        B4.setFont(new Font("標楷體", Font.PLAIN, 40));
        B1.setContentAreaFilled(false);
        B1.setFocusPainted(false);
        B1.setBorder(null);
        B2.setContentAreaFilled(false);
        B2.setFocusPainted(false);
        B2.setBorder(null);
        B3.setContentAreaFilled(false);
        B3.setFocusPainted(false);
        B3.setBorder(null);
        B4.setContentAreaFilled(false);
        B4.setFocusPainted(false);
        B4.setBorder(null);
        B1.setBounds(50 + 14, 100 + 39, 60 * 9, 50);
        B2.setBounds(50 + 14, 160 + 39, 60 * 9, 50);
        B3.setBounds(50 + 14, 220 + 39, 60 * 9, 50);
        B4.setBounds(50 + 14, 280 + 39, 60 * 9, 50);
        B1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JDialog JD = new JDialog(parent, "新遊戲/繼續遊戲", true);
                //JD.setUndecorated(true);//關閉標題
                //JD.getContentPane().setBackground(new Color(244,186,122));
                JD.getContentPane().setBackground(new Color(247, 143, 20));
                JD.setLayout(null);
                JD.setSize(300, 200);
                JD.setLocation(parent.getLocation().x + parent.getSize().width / 2 - 300 / 2,
                        parent.getLocation().y + parent.getSize().height / 2 - 200 / 2);

                JButton B1 = new JButton("新遊戲");
                JButton B2 = new JButton("繼續遊戲");
                B1.setFont(new Font("標楷體", Font.PLAIN, 40));
                B2.setFont(new Font("標楷體", Font.PLAIN, 40));
                B1.setBackground(new Color(244, 186, 122));
                B2.setBackground(new Color(244, 186, 122));
                B1.setBounds(50, 20, 200, 50);
                B2.setBounds(50, 80, 200, 50);
                B1.setFocusPainted(false);
                B2.setFocusPainted(false);
                JD.add(B1);
                JD.add(B2);

                B1.addMouseListener(new MouseAdapter() {
                    public void mouseClicked​(MouseEvent e) {
                        JD.setVisible(false);
                        SelectPanel.this.parent.GP=new GamePanel(SelectPanel.this.parent,"0",0);
                        SelectPanel.this.parent.add(SelectPanel.this.parent.GP);
                        SelectPanel.this.parent.remove(SelectPanel.this);
                        SelectPanel.this.parent.revalidate();
                        SelectPanel.this.parent.repaint();
                    }
                });

                JD.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                JButton btn = (JButton) e.getComponent();
                //btn.setForeground(new Color(0x33, 0x66, 0xcc));// 设置字体颜色
                btn.setBorderPainted(true);// 显示边框
                Border etchedBorder = new EtchedBorder(EtchedBorder.LOWERED);// 设置边框凹显
                btn.setBorder(etchedBorder);
                btn.setRolloverEnabled(true);
            }

            public void mouseExited(MouseEvent e) {
                JButton btn = (JButton) e.getComponent();
                //btn.setForeground(Color.black);// 设置字体颜色
                btn.setBorderPainted(false);// 隐藏边框
            }
        });
        B2.addMouseListener(GSP);
        B3.addMouseListener(BP);
        B4.addMouseListener(temp);
        this.add(B1);
        this.add(B2);
        this.add(B3);
        this.add(B4);
        //15 & 39
        JLabel background = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\背景.jpg").getScaledInstance(800, 600, 0)));
        background.setBounds(0, 0, 800, 600);
        this.add(background);
    }
}
