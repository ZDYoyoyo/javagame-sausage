/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se9;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author User
 */
public class GamePanel extends JPanel {

    int initWidth = 814;//800+14
    int initHeight = 639;//600+7+31
    MainWindow parent;
    //private static Robot myRobot = null;
    static int enter = 0;
    static int start = 0;
    Point gg1;
    int isgg1 = 0;

    GamePanel(MainWindow p, String choose, int test) {
        super();
        gg1 = null;
        parent = p;
        Cursor mousetemp = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("").getImage(), new Point(0, 0), "temp");

        Cursor cu = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(".\\pictures\\GG1.png").getImage(), new Point(0, 0), "GG1");
        // 32寬 12高

        setCursor(mousetemp);
        PanelInvisible temp = new PanelInvisible(this, "", this.parent);
        this.setLayout(null);
        this.setVisible(true);

        JLabel background = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\build" + choose + ".jpg").getScaledInstance(800, 600, 0)));
        background.setBounds(0, 0, 800, 600);

        this.add(background);
        background.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                if (enter == 0) {
                    try {

                        Robot myRobot = new Robot();
                        //尋找香腸的圖片取得點 之後新增一個畫布蓋過去 並將鼠標指過去

                        for (int height = 0; height < 600; height += 9) {
                            if (isgg1 == 1) {
                                break;
                            }
                            for (int weight = 0; weight < 800; weight += 24) {
                                if (isgg1 == 1) {
                                    break;
                                }
                                Color c = myRobot.getPixelColor​(GamePanel.this.getLocationOnScreen().x + weight,
                                        GamePanel.this.getLocationOnScreen().y + height);
                                if (200 <= c.getRed() && c.getRed() <= 260
                                        && 80 <= c.getGreen() && c.getGreen() <= 140
                                        && 0 <= c.getBlue() && c.getBlue() <= 60) {
                                    gg1 = new Point(weight, height);
                                    isgg1 = 1;
                                    enter = 1;
                                }
                                System.out.println("weight = " + weight + "  height = " + height + "   " + c);

                            }
                            myRobot.mouseMove(GamePanel.this.getLocationOnScreen().x + 400,
                                    GamePanel.this.getLocationOnScreen().y + 300);
                        }

                        JPanel J1 = new JPanel();
                        J1.setSize(64, 24);
                        J1.setBounds(gg1.x - 24, gg1.y - 9, 64, 24);
                        J1.setBackground(new Color(235, 206, 126));
                        //J1.setBackground(new Color(0, 0, 0));
                        J1.setVisible(true);
                        //GamePanel.this.add(J1);
                        background.add(J1);
                        GamePanel.this.parent.revalidate();
                        GamePanel.this.parent.repaint();
                        //myRobot.mouseMove((Toolkit.getDefaultToolkit().getScreenSize().width - initWidth) / 2 + 50 + 44,
                        //      (Toolkit.getDefaultToolkit().getScreenSize().height - initHeight) / 2 + 39 + 50 - 33);
                        setCursor(cu);
                        myRobot.mouseMove(GamePanel.this.getLocationOnScreen().x + gg1.x,
                                GamePanel.this.getLocationOnScreen().y + gg1.y);

                        myRobot.delay(200);

                    } catch (AWTException e1) {
                        e1.printStackTrace();
                    }

                }

            }

            public void mouseExited(MouseEvent e) {
                try {
                    Robot myRobot = new Robot();

                    if (test == 0) {
                        lose(myRobot);
                    } else {
                        lose_test(myRobot, choose);
                    }
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });

        background.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved​(MouseEvent e) {
                try {
                    Robot myRobot = new Robot();

                    int quit = 0;

                    for (int height = 0; height < 12; height += 5) {
                        if (start == 0) {
                            start = 1;
                            break;
                        }
                        if (quit == 1) {
                            break;
                        }
                        for (int weight = 0; weight < 32; weight += 15) {
                            if (quit == 1) {
                                break;
                            }
                            Color c = myRobot.getPixelColor​(e.getLocationOnScreen().x + weight, e.getLocationOnScreen().y + height);
                            System.out.println(c);//235 206 126
                            if (200 <= c.getRed() && c.getRed() <= 270
                                    && 180 <= c.getGreen() && c.getGreen() <= 240
                                    && 100 <= c.getBlue() && c.getBlue() <= 210) {

                            } else if (200 <= c.getRed() && c.getRed() <= 260 //GG
                                    && 80 <= c.getGreen() && c.getGreen() <= 140
                                    && 0 <= c.getBlue() && c.getBlue() <= 60) {

                            } else if (200 <= c.getRed() && c.getRed() <= 260
                                    && 200 <= c.getGreen() && c.getGreen() <= 260
                                    && 181 <= c.getBlue() && c.getBlue() <= 260) {
                                if (test == 0) {
                                    win(myRobot);
                                } else {
                                    win_test(myRobot);
                                }
                                quit = 1;
                            } else {
                                if (test == 0) {
                                    lose(myRobot);
                                } else {
                                    lose_test(myRobot, choose);
                                }
                                quit = 1;
                            }

                            if (weight == 15) {
                                weight = 16;
                            }
                        }
                        if (height == 5) {
                            height = 6;
                        }
                    }
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    public void lose(Robot myRobot) {
        JDialog JD = new JDialog(parent, "新遊戲/繼續遊戲", true);
        JD.setUndecorated(true);//關閉標題                ;
        JD.setLayout(null);
        JD.setSize(372, 526);
        JD.setLocation(parent.getLocation().x + parent.getSize().width / 2 - 372 / 2,
                parent.getLocation().y + parent.getSize().height / 2 - 526 / 2);

        JButton B1 = new JButton("重　玩");
        JButton B2 = new JButton("選　擇　關　卡");
        JButton B3 = new JButton("返　回　主　頁　面");
        B1.setFont(new Font("標楷體", Font.PLAIN, 30));
        B2.setFont(new Font("標楷體", Font.PLAIN, 30));
        B3.setFont(new Font("標楷體", Font.PLAIN, 30));
        B1.setBackground(new Color(209, 208, 206));
        B2.setBackground(new Color(209, 208, 206));
        B3.setBackground(new Color(209, 208, 206));
        B1.setBounds(32, 281, 308, 40);
        B2.setBounds(32, 345, 308, 40);
        B3.setBounds(32, 409, 308, 40);
        B1.setFocusPainted(false);
        B2.setFocusPainted(false);
        B3.setFocusPainted(false);
        JD.add(B1);
        JD.add(B2);
        JD.add(B3);

        B1.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {
                JD.setVisible(false);
                myRobot.mouseMove(GamePanel.this.getLocationOnScreen().x + gg1.x,
                        GamePanel.this.getLocationOnScreen().y + gg1.y);
                myRobot.delay(200);
            }
        });

        B3.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {

                GamePanel.this.parent.add(GamePanel.this.parent.MP);
                GamePanel.this.parent.remove(GamePanel.this);
                JD.setVisible(false);
                enter = 0;
                GamePanel.this.parent.revalidate();
                GamePanel.this.parent.repaint();
            }
        });

        JLabel background = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\Game over-1.png").getScaledInstance(372, 526, 0)));
        background.setBounds(0, 0, 372, 526);
        JD.add(background);
        JD.setVisible(true);
    }

    public void win(Robot myRobot) {
        JDialog JD = new JDialog(parent, "新遊戲/繼續遊戲", true);
        JD.setUndecorated(true);//關閉標題                ;
        JD.setLayout(null);
        JD.setSize(372, 526);
        JD.setLocation(parent.getLocation().x + parent.getSize().width / 2 - 372 / 2,
                parent.getLocation().y + parent.getSize().height / 2 - 526 / 2);

        JButton B1 = new JButton("下　一　關");
        JButton B2 = new JButton("選　擇　關　卡");
        JButton B3 = new JButton("返　回　主　頁　面");
        B1.setFont(new Font("標楷體", Font.PLAIN, 30));
        B2.setFont(new Font("標楷體", Font.PLAIN, 30));
        B3.setFont(new Font("標楷體", Font.PLAIN, 30));
        B1.setBackground(new Color(209, 208, 206));
        B2.setBackground(new Color(209, 208, 206));
        B3.setBackground(new Color(209, 208, 206));
        B1.setBounds(32, 281, 308, 40);
        B2.setBounds(32, 345, 308, 40);
        B3.setBounds(32, 409, 308, 40);
        B1.setFocusPainted(false);
        B2.setFocusPainted(false);
        B3.setFocusPainted(false);
        JD.add(B1);
        JD.add(B2);
        JD.add(B3);

        B1.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {
                JD.setVisible(false);
                myRobot.mouseMove(GamePanel.this.getLocationOnScreen().x + gg1.x,
                        GamePanel.this.getLocationOnScreen().y + gg1.y);
                myRobot.delay(200);
            }
        });

        B3.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {

                GamePanel.this.parent.add(GamePanel.this.parent.MP);
                GamePanel.this.parent.remove(GamePanel.this);
                JD.setVisible(false);
                enter = 0;
                GamePanel.this.parent.revalidate();
                GamePanel.this.parent.repaint();
            }
        });

        JLabel background = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\win-1.jpg").getScaledInstance(372, 526, 0)));
        background.setBounds(0, 0, 372, 526);
        JD.add(background);
        JD.setVisible(true);
    }

    public void lose_test(Robot myRobot, String choose) {
        JDialog JD = new JDialog(parent, "新遊戲/繼續遊戲", true);
        JD.setUndecorated(true);//關閉標題                ;
        JD.setLayout(null);
        JD.setSize(372, 526);
        JD.setLocation(parent.getLocation().x + parent.getSize().width / 2 - 372 / 2,
                parent.getLocation().y + parent.getSize().height / 2 - 526 / 2);

        JButton B1 = new JButton("重　玩");
        JButton B2 = new JButton("返　回　建　造");
        JButton B3 = new JButton("返　回　主　頁　面");
        B1.setFont(new Font("標楷體", Font.PLAIN, 30));
        B2.setFont(new Font("標楷體", Font.PLAIN, 30));
        B3.setFont(new Font("標楷體", Font.PLAIN, 30));
        B1.setBackground(new Color(209, 208, 206));
        B2.setBackground(new Color(209, 208, 206));
        B3.setBackground(new Color(209, 208, 206));
        B1.setBounds(32, 281, 308, 40);
        B2.setBounds(32, 345, 308, 40);
        B3.setBounds(32, 409, 308, 40);
        B1.setFocusPainted(false);
        B2.setFocusPainted(false);
        B3.setFocusPainted(false);
        JD.add(B1);
        JD.add(B2);
        JD.add(B3);

        B1.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {
                JD.setVisible(false);
                myRobot.mouseMove(GamePanel.this.getLocationOnScreen().x + gg1.x,
                        GamePanel.this.getLocationOnScreen().y + gg1.y);
                myRobot.delay(200);
            }
        });

        B2.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {
                File name = new File("build" + choose + ".jpg");
                name.delete();
                JD.setVisible(false);
                GamePanel.this.parent.add(GamePanel.this.parent.BP);
                GamePanel.this.parent.remove(GamePanel.this);

                enter = 0;
                GamePanel.this.parent.revalidate();
                GamePanel.this.parent.repaint();
            }
        });

        B3.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {

                File name = new File("build" + choose + ".jpg");
                name.delete();

                GamePanel.this.parent.add(GamePanel.this.parent.MP);
                GamePanel.this.parent.remove(GamePanel.this);
                JD.setVisible(false);
                enter = 0;
                GamePanel.this.parent.BP = new BuildPanel(GamePanel.this.parent);

                GamePanel.this.parent.revalidate();
                GamePanel.this.parent.repaint();
            }
        });

        JLabel background = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\Game over-1.png").getScaledInstance(372, 526, 0)));
        background.setBounds(0, 0, 372, 526);
        JD.add(background);
        JD.setVisible(true);
    }

    public void win_test(Robot myRobot) {
        JDialog JD = new JDialog(parent, "新遊戲/繼續遊戲", true);
        JD.setUndecorated(true);//關閉標題                ;
        JD.setLayout(null);
        JD.setSize(372, 526);
        JD.setLocation(parent.getLocation().x + parent.getSize().width / 2 - 372 / 2,
                parent.getLocation().y + parent.getSize().height / 2 - 526 / 2);

        JButton B1 = new JButton("測　試　成　功");
        JButton B2 = new JButton("請　點　下　面");
        JButton B3 = new JButton("返　回　主　頁　面");
        B1.setFont(new Font("標楷體", Font.PLAIN, 30));
        B2.setFont(new Font("標楷體", Font.PLAIN, 30));
        B3.setFont(new Font("標楷體", Font.PLAIN, 30));
        B1.setBackground(new Color(209, 208, 206));
        B2.setBackground(new Color(209, 208, 206));
        B3.setBackground(new Color(209, 208, 206));
        B1.setBounds(32, 281, 308, 40);
        B2.setBounds(32, 345, 308, 40);
        B3.setBounds(32, 409, 308, 40);
        B1.setFocusPainted(false);
        B2.setFocusPainted(false);
        B3.setFocusPainted(false);
        JD.add(B1);
        JD.add(B2);
        JD.add(B3);

        B3.addMouseListener(new MouseAdapter() {
            public void mouseClicked​(MouseEvent e) {
                GamePanel.this.parent.BP = new BuildPanel(GamePanel.this.parent);
                GamePanel.this.parent.add(GamePanel.this.parent.MP);
                GamePanel.this.parent.remove(GamePanel.this);
                JD.setVisible(false);
                enter = 0;
                GamePanel.this.parent.revalidate();
                GamePanel.this.parent.repaint();
            }
        });

        JLabel background = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\win-1.jpg").getScaledInstance(372, 526, 0)));
        background.setBounds(0, 0, 372, 526);
        JD.add(background);
        JD.setVisible(true);
    }

}
