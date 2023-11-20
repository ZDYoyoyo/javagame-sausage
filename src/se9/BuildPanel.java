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
enum garState {  
    lact,inact;  
}

public class BuildPanel extends JPanel{
    MainWindow parent;
    JLayeredPane layeredPane =new JLayeredPane();
    private static Robot robot = null;
    ToolBar toolbar=null;
    garState state = garState.inact;
    int isplant=0;
    int isgg1=0;
    picob actpic =null;
    BuildPanel(MainWindow p) {
        super();
        parent = p;
        //JLayeredPane layeredPane=new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600);
        this.add(layeredPane);
        if(toolbar==null)
        {
            toolbar = new ToolBar(this.parent,this);
        }
        PanelInvisible SP = new PanelInvisible(this,"SP",this.parent);
        PanelInvisible temp = new PanelInvisible(this,"",this.parent);
        this.setBackground(new Color(235,206,126));      
        
        this.setVisible(true);        
        this.setLayout(null);
        
        
        toolbar.setBounds(543, 0, 257, 600);
        // layeredPane.add(jp1,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(toolbar,JLayeredPane.MODAL_LAYER);
        //this.add(toolbar);
      
        JButton hide = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\hide.jpg").getScaledInstance(30, 62, 0)));
        hide.setBounds(513, 238, 30, 62); 
        JButton show = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\show.jpg").getScaledInstance(30, 62, 0)));
        show.setBounds(770, 238, 30, 62);
        layeredPane.add(hide,JLayeredPane.MODAL_LAYER);
        hide.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
        {
            BuildPanel.this.layeredPane.remove(toolbar);            
            //BuildPanel.this.remove(e.getComponent());
            BuildPanel.this.layeredPane.remove(hide);
            BuildPanel.this.layeredPane.add(show);
            BuildPanel.this.revalidate();
            BuildPanel.this.repaint();
        }
        });
        show.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
        {
            BuildPanel.this.layeredPane.add(toolbar);            
            //BuildPanel.this.remove(e.getComponent());
            BuildPanel.this.layeredPane.add(hide);
            BuildPanel.this.layeredPane.remove(show);
            BuildPanel.this.revalidate();
            BuildPanel.this.repaint();
        }
        });
        
        /*
        JLabel back = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\gura_remove.png").getScaledInstance(200, 200, 0)));
        back.setBounds(200, 200, 200, 200);
        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked​(MouseEvent e) {
                //Point fp, lp;
                //fp=e.getPoint();
                System.out.println("x="+e.getX() + "   y="+e.getY());
	}
        });
        back.addMouseMotionListener(new MouseAdapter(){
            public void mouseMoved​(MouseEvent e) {     
                System.out.println("x="+e.getX() + "   y="+e.getY()+"   ");
	}
        });       
        this.add(back);*/
        
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e)
            {
                if(BuildPanel.this.actpic!=null)
                {
                    actpic.controlPs.show(false);
                }
            }
            
        });
        
        this.parent.repaint();
        this.parent.revalidate();
                
       /*
        JLabel background = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(".\\pictures\\背景.jpg").getScaledInstance(800, 600, 0)));
        background.setBounds(0, 0, 800, 600);
        this.add(background);*/
    }
     
}