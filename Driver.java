import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.util.Timer; 
import java.util.TimerTask;
public class Driver extends JPanel {

    int screen_width = 1600;
    int screen_height = 900;
    int balance = 0;
    int numLemons = 0;
    int numNews = 0;
    int numCars = 0;
    int numPizzas = 0;
    int numDonuts = 0;
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
           g.drawString("Newspapers", 385, 275);
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
    

    public void mouseClicked(MouseEvent e) {

        if (SwingUtilities.isLeftMouseButton(e)) {

            PointerInfo a = MouseInfo.getPointerInfo();
            Point b = a.getLocation();
            int clickX = (int) b.getX();
            int clickY = (int) b.getY();
            if(clickX <775 && clickX > 300 && clickY >195 && clickY <345) {
            	income(1);
            }
        }
    }
    
    public void income(int asset) {
    	Timer timer = new Timer();
    	if(asset ==1) {
    		balance += numLemons * 5;
    	}
    	if(asset ==2) {
    		balance += numNews * 30;
    	}
    	if(asset ==3) {
    		balance += numLemons * 60;
    	}
    	if(asset ==4) {
    		balance += numLemons * 120;
    	}
    	if(asset ==5) {
    		balance += numLemons * 240;
    	}
    }
    
    
  public void upgrade(int asset) {
	  if(asset ==1) {
		  if(balance>numLemons*30*Math.pow(2,numLemons)){
			  balance -=numLemons*30*Math.pow(2,numLemons);
			  numLemons++;
		  }
	  }
	  if(asset ==2) {
		  if(balance>numNews*100*Math.pow(2,numNews)){
			  balance -=numNews*100*Math.pow(2,numNews);
			  numNews++;
		  }
	  }
	  if(asset ==3) {
		  if(balance>numCars*250*Math.pow(2,numCars)){
			  balance -=numCars*20*Math.pow(2,numCars);
			  numCars++;
		  }
	  }
	  if(asset ==4) {
		  if(balance>numPizzas*400*Math.pow(2,numPizzas)){
			  balance -=numPizzas*30*Math.pow(2,numPizzas);
			  numPizzas++;
		  }
	  }
	  if(asset ==5) {
		  if(balance>numDonuts*40*Math.pow(2,numDonuts)){
			  balance -=numDonuts*40*Math.pow(2,numDonuts);
			  numDonuts++;
		  }
	  }
  }
}
