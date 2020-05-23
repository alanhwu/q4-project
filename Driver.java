import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel {

    int screen_width = 1600;
    int screen_height = 900;
    int balance = 0;
    
    Font font = new Font("Courier New", 1, 50);
    
    public void paint(Graphics g) {
    	 super.paintComponent(g);
         g.setFont(font);
         g.setColor(Color.RED);
         g.drawString("Money: " + balance, 30, 50);
}
    
    
    public static void main(String[] arg) {
        Driver d = new Driver();
    }

    public Driver() {
        JFrame f = new JFrame();
        f.setTitle("Adventure Capitalist");
        f.setSize(screen_width, screen_height);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        repaint();
    }

}
