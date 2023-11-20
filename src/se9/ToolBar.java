/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se9;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Vector;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
enum State {
    wall, trap, special;
}

public class ToolBar extends JPanel {

    //private String path = System.getProperty("user.dir");
    MainWindow parent;
    BuildPanel Bparent;
    State state = State.wall;
    Vector<picob> picobs = new Vector<picob>();
    int picnum = 0;

    ToolBar(MainWindow p, BuildPanel Bp) {
        super();
        this.parent = p;
        this.Bparent = Bp;
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(257, 600);
        this.setBackground(new Color(188, 188, 188));

        /*
        JLabel Developer = new JLabel("－軟體工程第九組");
        Developer.setFont(new Font("標楷體", Font.PLAIN, 30));
        Developer.setBounds(520, 539, 35 * 11, 35);
        this.add(Developer);*/
        //final JButton b =  new TriangleButton(15,15,30,0,30,30);
        JLabel wb1 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\關卡牆-2.png").getScaledInstance(32, 37, 0)));
        wb1.setBounds(27, 35, 32, 37);
        this.add(wb1);

        JLabel wb2 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\關卡牆-3.png").getScaledInstance(32, 37, 0)));
        wb2.setBounds(210, 35, 32, 37);
        this.add(wb2);

        JButton gar = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\gar.png").getScaledInstance(52, 53, 0)));
        gar.setBounds(195, 540, 52, 53);
        gar.setContentAreaFilled(false);
        gar.setFocusPainted(false);
        this.add(gar);

        JLabel t1 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\t1.jpg").getScaledInstance(223, 69, 0)));
        t1.setBounds(20, 470, 223, 69);
        this.add(t1);

        JButton save = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\save.png").getScaledInstance(52, 53, 0)));
        save.setBounds(125, 540, 52, 53);
        save.setContentAreaFilled(false);
        save.setFocusPainted(false);
        this.add(save);

        JLabel t2 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\t2.jpg").getScaledInstance(123, 54, 0)));
        t2.setBounds(5, 540, 123, 54);
        this.add(t2);

        JLabel text = new JLabel("關卡牆");
        text.setFont(new Font("新細明體", Font.PLAIN, 36));
        text.setForeground(Color.white);
        text.setBounds(77, 36, 36 * 3, 40);
        this.add(text);

        JLabel wall_1 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\wall-1.png").getScaledInstance(10, 100, 0)));
        wall_1.setBounds(50, 150, 10, 100);
        this.add(wall_1);
        
        JLabel wall_2 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\wall-2.png").getScaledInstance(100, 10, 0)));
        wall_2.setBounds(125, 200, 100, 10);
        this.add(wall_2);

        JLabel circle = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\circle.png").getScaledInstance(100, 100, 0)));
        circle.setBounds(25, 150, 100, 100);

        JLabel semicircle = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\semicircle.png").getScaledInstance(50, 100, 0)));
        semicircle.setBounds(150, 150, 50, 100);

        JLabel square = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\square.png").getScaledInstance(100, 100, 0)));
        square.setBounds(25, 275, 100, 100);

        JLabel triangle = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\triangle.png").getScaledInstance(100, 100, 0)));
        triangle.setBounds(150, 275, 100, 100);

        JLabel plant = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\plant.png").getScaledInstance(49, 38, 0)));
        plant.setBounds(150, 150, 90, 66);

        JLabel gg1 = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\gg1.png").getScaledInstance(32, 32, 0)));
        gg1.setBounds(50, 150, 32, 32);

        wb1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                switch (ToolBar.this.state) {
                    case wall:
                        text.setText("特殊區");
                        ToolBar.this.remove(wall_1);
                        ToolBar.this.remove(wall_2);
                        ToolBar.this.add(plant);
                        ToolBar.this.add(gg1);
                        ToolBar.this.state = State.special;
                        break;
                    case trap:
                        text.setText("關卡牆");
                        ToolBar.this.remove(circle);
                        ToolBar.this.remove(semicircle);
                        ToolBar.this.remove(square);
                        ToolBar.this.remove(triangle);
                        ToolBar.this.add(wall_1);
                        ToolBar.this.add(wall_2);
                        ToolBar.this.state = State.wall;
                        break;
                    case special:
                        text.setText("障礙物");
                        ToolBar.this.remove(plant);
                        ToolBar.this.remove(gg1);
                        ToolBar.this.add(circle);
                        ToolBar.this.add(semicircle);
                        ToolBar.this.add(square);
                        ToolBar.this.add(triangle);
                        ToolBar.this.state = State.trap;
                        break;
                }
                ToolBar.this.parent.revalidate();
                ToolBar.this.parent.repaint();
            }
        });

        wb2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                switch (ToolBar.this.state) {
                    case wall:
                        text.setText("障礙物");
                        ToolBar.this.remove(wall_1);
                        ToolBar.this.remove(wall_2);
                        ToolBar.this.add(circle);
                        ToolBar.this.add(semicircle);
                        ToolBar.this.add(square);
                        ToolBar.this.add(triangle);
                        ToolBar.this.state = State.trap;
                        break;
                    case trap:
                        text.setText("特殊區");
                        ToolBar.this.remove(circle);
                        ToolBar.this.remove(semicircle);
                        ToolBar.this.remove(square);
                        ToolBar.this.remove(triangle);
                        ToolBar.this.add(plant);
                        ToolBar.this.add(gg1);
                        ToolBar.this.state = State.special;
                        break;
                    case special:
                        text.setText("關卡牆");
                        ToolBar.this.remove(plant);
                        ToolBar.this.remove(gg1);
                        ToolBar.this.add(wall_1);
                        ToolBar.this.add(wall_2);
                        ToolBar.this.state = State.wall;
                        break;
                }
                ToolBar.this.parent.revalidate();
                ToolBar.this.parent.repaint();
            }
        });

        JLabel wall = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\關卡牆-1.png").getScaledInstance(257, 117, 0)));
        wall.setBounds(0, 0, 257, 117);
        this.add(wall);

        //wall_1.addMouseListener(addpicture("wall_1"));
        wall_1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addpicture("wall_1");
            }
        });
        wall_2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addpicture("wall_2");
            }
        });
        circle.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addpicture("circle");
            }
        });
        semicircle.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addpicture("semicircle");
            }
        });
        square.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addpicture("square");
            }
        });
        triangle.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addpicture("triangle");
            }
        });
        triangle.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                addpicture("triangle");
            }
        });
        plant.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (ToolBar.this.Bparent.isplant == 0) {
                    addpicture("plant");
                }
            }
        });
        gg1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (ToolBar.this.Bparent.isgg1 == 0) {
                    addpicture("gg1");
                }
            }
        });

        gar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ToolBar.this.Bparent.actpic.controlPs.show(false);
                int c = e.getButton();// 得到按下的滑鼠鍵
                if (c == MouseEvent.BUTTON1) { // 判斷是滑鼠左鍵按下
                    switch (ToolBar.this.Bparent.state) {
                        case inact:
                            ToolBar.this.Bparent.state = garState.lact;
                            break;
                        case lact:
                            ToolBar.this.Bparent.state = garState.inact;
                            break;
                    }
                }
                if (c == MouseEvent.BUTTON3) {// 判斷是滑鼠右鍵按下

                    picob l;
                    for (int i = 0; i < picobs.size(); i++) {
                        l = picobs.elementAt(i);
                        ToolBar.this.Bparent.remove(l);
                    }
                    ToolBar.this.Bparent.isplant = 0;
                    ToolBar.this.Bparent.isgg1 = 0;

                    ToolBar.this.parent.revalidate();
                    ToolBar.this.parent.repaint();
                }

            }
        });

        save.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ToolBar.this.Bparent.actpic.controlPs.show(false);
                //移除工具欄>儲存圖片>遊玩>成功回桌面 >失敗選擇重來 回桌面(刪除) 繼續建造
                if ((ToolBar.this.Bparent.isplant == 1) && (ToolBar.this.Bparent.isgg1 == 1)) {
                    ToolBar.this.Bparent.remove(ToolBar.this.Bparent.layeredPane);
                    ToolBar.this.parent.revalidate();
                    ToolBar.this.parent.repaint();
                    
                    for (int i = 0; i <= 1000; i++) {
                        File name = new File("build" + i + ".jpg");
                        if (!name.exists()) {
                            picnum = i;
                            break;
                        }
                    }
                    Timer t = new Timer();
                    t.schedule(new TimerTask() {
                        public void run() {
                            savePic("build" + picnum + ".jpg");
                        }
                    }, 1);
                    t.schedule(new TimerTask() {
                        public void run() {
                            String s = Integer.toString(picnum);
                            ToolBar.this.parent.GP = new GamePanel(ToolBar.this.parent,s,1);
                            ToolBar.this.parent.add(ToolBar.this.parent.GP);
                            ToolBar.this.Bparent.add(ToolBar.this.Bparent.layeredPane);
                            ToolBar.this.parent.remove(ToolBar.this.parent.BP);
                            
                            ToolBar.this.parent.revalidate();
                            ToolBar.this.parent.repaint();
                            
                        }
                    }, 1);
                }
            }
        });
    }

    private void addpicture(String pic) {
        if(ToolBar.this.Bparent.actpic != null)
        ToolBar.this.Bparent.actpic.controlPs.show(false);
        picob newpic = null;
        
        if (pic == "wall_1") {
            newpic = new picob(ToolBar.this.parent.BP, "wall_1");
            newpic.setBounds(50, 50, 10, 100);
        } else if (pic == "wall_2") {
            newpic = new picob(ToolBar.this.parent.BP, "wall_2");
            newpic.setBounds(50, 50, 100, 10);
        }else if (pic == "circle") {
            newpic = new picob(ToolBar.this.parent.BP, "circle");
            newpic.setBounds(50, 50, 100, 100);
        } else if (pic == "semicircle") {
            newpic = new picob(ToolBar.this.parent.BP, "semicircle");
            newpic.setBounds(50, 50, 50, 100);
        } else if (pic == "square") {
            newpic = new picob(ToolBar.this.parent.BP, "square");
            newpic.setBounds(50, 50, 100, 100);
        } else if (pic == "triangle") {
            newpic = new picob(ToolBar.this.parent.BP, "triangle");
            newpic.setBounds(50, 50, 100, 100);
        } else if (pic == "plant") {
            newpic = new picob(ToolBar.this.parent.BP, "plant");
            newpic.setBounds(50, 50, 49, 38);
        } else if (pic == "gg1") {
            newpic = new picob(ToolBar.this.parent.BP, "gg1");
            newpic.setBounds(50, 50, 32, 32);
        }
        
        picobs.add(newpic);
        ToolBar.this.Bparent.actpic=newpic;
        ToolBar.this.Bparent.add(newpic);

        ToolBar.this.parent.revalidate();
        ToolBar.this.parent.repaint();

    }

    public void savePic(String path) {
        BufferedImage myImage = null;
        try {
            myImage = new Robot().createScreenCapture(
                    new Rectangle(ToolBar.this.Bparent.getLocationOnScreen().x, ToolBar.this.Bparent.getLocationOnScreen().y,
                            800 - 1, 600));

            ImageIO.write(myImage, "jpg", new File(path));
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
