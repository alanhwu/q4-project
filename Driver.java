import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel {

    int screen_width = 1600;
    int screen_height = 900;
    int balance = 0;
    Background background;
    Font font = new Font("Courier New", 1, 50);
    
    public void paint(Graphics g) {
    	super.paintComponent(g);
    //	background.paint(g);
        Font myFont = new Font("Ubuntu", 1, 30);
        g.setColor(Color.green);
        g.setFont(myFont);
        g.drawString("Money: " + balance, 30, 50);
        g.setColor(Color.DARK_GRAY);
        for(int i=0; i<5; i++) {
        	g.drawRect(300, 25 + i*170, 475, 150);
        	g.drawRect(900, 25 + i*170, 475, 150);
        }

        //Column 1 Assets
           g.drawString("Lemonade Stand", 385, 100);
           g.drawString("Fake News Media", 385, 275);
           g.drawString("Car Wash", 385, 450);
           g.drawString("Pizzeria", 385, 625);
           g.drawString("Donut Shop", 385, 800);
           
        //Column 2 Assets
           g.drawString("Shrimp Boat", 1000, 100);
           g.drawString("Cryptocurrency Mining Rig", 1000, 275);
           g.drawString("Movie Studio", 1000, 450);
           g.drawString("Bank", 1000, 625);
           g.drawString("Tech Company", 1000, 800);
   }
    
    
    public void update() {
    }


    public void actionPerformed(ActionEvent arg0) {
        update();
        repaint();
    }
    

    public static void main(String[] arg) {
        Driver d = new Driver();
       
    }
    
    public Driver() {
        JFrame f = new JFrame();
        f.setTitle("Adventure Capitalist");
        f.setSize(screen_width, screen_height);
        f.setResizable(false);

        f.add(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        repaint();
    }
   
}
