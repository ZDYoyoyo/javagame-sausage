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
public class picob extends JLabel {

    BuildPanel parent;
    Point fp, lp;
    ControlPoints controlPs;
    String pic;
    picob(BuildPanel p, String pic) {
        super();
        this.parent = p;
        controlPs = new ControlPoints(this);
        fp = null;
        lp = null;
        this.pic =pic;
        if (pic == "wall_1") {
            setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\wall-1.png").getScaledInstance(10, 100, 0)));
        }else if (pic == "wall_2") {
            setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\wall-2.png").getScaledInstance(100, 10, 0)));
        }else if (pic == "circle") {
            setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\circle.png").getScaledInstance(100, 100, 0)));
        } else if (pic == "semicircle") {
            setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\semicircle.png").getScaledInstance(50, 100, 0)));
        } else if (pic == "triangle") {
            setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\triangle.png").getScaledInstance(100, 100, 0)));
        } else if (pic == "square") {
            setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\square.png").getScaledInstance(100, 100, 0)));
        } else if (pic == "plant") {
            setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\plant.png").getScaledInstance(49, 38, 0)));
            picob.this.parent.isplant = 1;
        } else if (pic == "gg1") {
            setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\gg1.png").getScaledInstance(32, 32, 0)));
            picob.this.parent.isgg1 = 1;
        }

        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (picob.this.parent.state == garState.inact) {
                    lp = e.getLocationOnScreen();
                    picob.this.controlPs.show(false);
                    picob.this.parent.actpic.controlPs.show(false);
                    picob.this.parent.actpic= picob.this;
                    picob.this.parent.parent.revalidate();
                    picob.this.parent.parent.repaint();
                } else if (picob.this.parent.state == garState.lact) {
                    picob.this.parent.remove(picob.this);
                    if (pic == "plant") {
                        picob.this.parent.isplant = 0;
                    }
                    if (pic == "gg1") {
                        picob.this.parent.isgg1 = 0;
                    }
                    picob.this.parent.parent.revalidate();
                    picob.this.parent.parent.repaint();
                }
            }
            
            public void mouseReleased(MouseEvent e) {
                if (picob.this.parent.state == garState.inact) {
                    picob.this.controlPs.show(true);
                    picob.this.parent.parent.revalidate();
                    picob.this.parent.parent.repaint();
            }
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (picob.this.parent.state == garState.inact) {
                    if (lp != null) {
                        Point loc = picob.this.getLocation();

                        picob.this.setLocation(
                                loc.x + e.getXOnScreen() - lp.x,
                                loc.y + e.getYOnScreen() - lp.y);
                        lp = e.getLocationOnScreen();
                        picob.this.parent.parent.revalidate();
                        picob.this.parent.parent.repaint();
                    }
                }
            }
        });

    }

}
