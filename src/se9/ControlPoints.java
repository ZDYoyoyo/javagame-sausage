/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se9;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

/**
 *
 * @author junwu
 */
public class ControlPoints {
    
    picob parent;
    Point lp,cp;
    
    Panel E, W, N, S, NE, NW, SE, SW;
    
    
    ControlPoints(picob p)
    {
        parent=p;
        lp=null;
        cp=null;
        SE = new Panel();
        SE.setBackground(Color.red);
        SE.setSize(5, 5);
        parent.parent.layeredPane.add(SE,JLayeredPane.MODAL_LAYER);
        SE.setVisible(false);
        SE.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
        
//        SE.setLocation(parent.getX()+parent.getWidth(), 10);
        
        SE.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e)
            {
                
                    lp=e.getLocationOnScreen();
             
            }

            public void mouseReleased(MouseEvent e)
            {
                
                    lp=null;
                    cp=null;
                
            }

        });

        SE.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e)
            {
                    Point op=parent.getLocation();
                    cp=e.getLocationOnScreen();
                    Dimension osize=ControlPoints.this.parent.getSize();
                    /*
                    ControlPoints.this.parent.setIcon(
                            new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\wall-1.png")
                                    .getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));*/
                    
                    if (ControlPoints.this.parent.pic == "wall_1") {
                        ControlPoints.this.parent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\wall-1.png").getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));
                    } else if (ControlPoints.this.parent.pic == "wall_2") {
                        ControlPoints.this.parent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\wall-2.png").getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));
                    } else if (ControlPoints.this.parent.pic == "circle") {
                        ControlPoints.this.parent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\circle.png").getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));
                    } else if (ControlPoints.this.parent.pic == "semicircle") {
                        ControlPoints.this.parent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\semicircle.png").getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));
                    } else if (ControlPoints.this.parent.pic == "triangle") {
                        ControlPoints.this.parent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\triangle.png").getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));
                    } else if (ControlPoints.this.parent.pic == "square") {
                       ControlPoints.this.parent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\square.png").getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));
                    } else if (ControlPoints.this.parent.pic == "plant") {
                       ControlPoints.this.parent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\plant.png").getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));
                       // picob.this.parent.isplant = 1;
                    } else if (ControlPoints.this.parent.pic == "gg1") {
                       ControlPoints.this.parent.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\gg1.png").getScaledInstance(osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y), 0)));
                       // picob.this.parent.isgg1 = 1;
                    }
                    
                    ControlPoints.this.parent.setBounds(op.x, op.y, osize.width+(cp.x-lp.x), osize.height+(cp.y-lp.y));
                    SE.setLocation(op.x+osize.width-1-2, op.y+osize.height-1-2);
                    /*ControlPoints.this.parent.setSize(osize.width+(cp.x-lp.x),
                                                      osize.height+(cp.y-lp.y));*/
                    lp=cp;
                
            }
        });
        
    }
    
    public void show(boolean isShow)
    {
        if(isShow)
        {
            Point op=parent.getLocation();
            Dimension sp=parent.getSize();
            //SE.setBounds(op.x+sp.width-1-2, op.y+sp.height-1-2, 50, 50);
            SE.setLocation(op.x+sp.width-1-2, op.y+sp.height-1-2);
            
        }
        SE.setVisible(isShow);
        parent.parent.parent.revalidate();
        parent.parent.parent.repaint();
    }
    
}
