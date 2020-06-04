import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.TimerTask;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class Driver extends JPanel implements MouseListener {

	int screen_width = 1600;
	int screen_height = 900;
	int balance = 0;

	// create variables to keep track of how many assets the player has
	// start off the game with 1 lemonade stand
	int numLemons = 1;
	int numNews = 0;
	int numCars = 0;
	int numPizzas = 0;
	int numDonuts = 0;

	// create variables to keep track of how much money upgrading each asset costs
	int LemonCost = 30 * numLemons;
	int NewsCost = 200 * (numNews + 1);
	int CarsCost = 500 * (numCars + 1);
	int PizzasCost = 1000 * (numPizzas + 1);
	int DonutsCost = 2000 * (numDonuts + 1);

	Background background;
	Font font = new Font("Courier New", 1, 50);

	public void paint(Graphics g) {
		// continuously update the prices of the upgrades so that they are displayed
		// correctly.
		LemonCost = 30 * numLemons;
		NewsCost = 200 * (numNews + 1);
		CarsCost = 500 * (numCars + 1);
		PizzasCost = 1000 * (numPizzas + 1);
		DonutsCost = 2000 * (numDonuts + 1);

		super.paintComponent(g);

		// initialize the background image
		background.paint(g);

		// create a font to display the instructions
		Font myFont = new Font("Ubuntu", 1, 30);
		g.setColor(Color.RED);
		g.setFont(myFont);

		// instructions to player part 1
		g.drawString("Money: " + balance, 30, 50);
		g.drawString("Click Run on your", 10, 100);
		g.drawString("Lemonade Stand", 10, 130);
		g.drawString("to start making", 10, 160);
		g.drawString("money!", 10, 190);

		// instructions to player part 2
		g.drawString("When you have", 10, 250);
		g.drawString("enough, click", 10, 280);
		g.drawString("upgrade to buy more", 10, 310);
		g.drawString("Lemonade Stands!", 10, 340);

		// instructions to player part 3
		g.setColor(Color.BLUE);
		g.drawString("The blue number", 10, 400);
		g.drawString("tells you how many", 10, 430);
		g.drawString("of each asset", 10, 460);
		g.drawString("you have!", 10, 490);

		// instructions to player part 4
		g.drawString("Please don't", 10, 550);
		g.drawString("adjust window size", 10, 580);
		g.drawString("or location!", 10, 610);

		// draw 10 boxes to hold info for 10 assets
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 5; i++) {
			g.fillRect(300, 25 + i * 170, 475, 150);
			g.fillRect(900, 25 + i * 170, 475, 150);
		}

		// In each box, make two white boxes for "run" and "upgrade", then draw "run"
		// inside the "run" boxes
		for (int i = 0; i < 5; i++) {
			g.setColor(Color.white);
			g.fillRect(400, 120 + i * 170, 225, 45);
			g.fillRect(675, 80 + i * 170, 70, 70);
			g.fillRect(1000, 120 + i * 170, 225, 45);
			g.setColor(Color.black);
			g.drawString("Run", 675, 120 + i * 170);
		}

		// Column 1 Assets
		g.setColor(Color.DARK_GRAY);
		g.drawString("Lemonade Stand", 385, 100);
		// display how much income this asset generates (in this case, it's number of
		// lemons * 5)
		g.drawString("Income:" + numLemons * 5, 390, 50);
		// display how much it costs to upgrade this asset (this cost is kept track in a
		// handy variable)
		g.drawString("Upgrade" + "($" + LemonCost + ")", 400, 150);

		g.drawString("Newspapers", 385, 275);
		g.drawString("Income:" + numNews * 30, 390, 225);
		g.drawString("Upgrade" + "($" + NewsCost + ")", 400, 325);

		g.drawString("Car Wash", 385, 450);
		g.drawString("Pizzeria", 385, 625);
		g.drawString("Donut Shop", 385, 790);

		// Column 2 Assets
		g.drawString("Shrimp Boat", 1000, 100);
		g.drawString("Cryptocurrency Mining Rig", 930, 275);
		g.drawString("Movie Studio", 1000, 450);
		g.drawString("Bank", 1000, 625);
		g.drawString("Tech Company", 1000, 790);

		// display how many of each asset the player has in Blue
		g.setColor(Color.BLUE);
		g.drawString("#:" + numLemons, 325, 100);
		g.drawString("#:" + numNews, 325, 290);
		g.drawString("#:" + numCars, 325, 450);
		g.drawString("#:" + numPizzas, 325, 630);
		g.drawString("#:" + numDonuts, 325, 800);

		repaint();
	}

	public void actionPerformed(ActionEvent arg0) {
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
		f.addMouseListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background = new Background("adcap_banner.jpg");
		f.setVisible(true);
		repaint();
	}

	public void income(int asset) {
//these numbers must match the numbers displayed in the Upgrade cost string
// this is where it actually increments the player's balance
		if (asset == 1) {
			balance += numLemons * 5;
		}
		if (asset == 2) {
			balance += numNews * 30;
		}
		if (asset == 3) {
			balance += numLemons * 60;
		}
		if (asset == 4) {
			balance += numLemons * 120;
		}
		if (asset == 5) {
			balance += numLemons * 240;
		}
	}

	public void upgrade(int asset) {
		// simple checker. if player has enough money to cover the cost of the upgrade
		// then subtract the cost and give them 1 more of that asset.
		if (asset == 1) {
			if (balance > LemonCost) {
				balance -= LemonCost;
				numLemons++;
			}
		}
		if (asset == 2) {
			if (balance > NewsCost) {
				balance -= NewsCost;
				numNews++;
			}
		}
		if (asset == 3) {
			if (balance > CarsCost) {
				balance -= CarsCost;
				numCars++;
			}
		}
		if (asset == 4) {
			if (balance > PizzasCost) {
				balance -= PizzasCost;
				numPizzas++;
			}
		}
		if (asset == 5) {
			if (balance > DonutsCost) {
				balance -= DonutsCost;
				numDonuts++;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isLeftMouseButton(e)) {
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			int clickX = (int) b.getX();
			int clickY = (int) b.getY();

			// print coordinates for debugging
			System.out.println(clickX + " , " + clickY);

			// detect clicks in the "run" for Lemons (asset 1)
			if ((clickX < 750 && clickX > 680) && (clickY > 110 && clickY < 180)) {
				income(1);
				repaint();
			}

			// detect clicks in the "upgrade" for Lemons (asset 1)
			if ((clickX < 625 && clickX > 400) && (clickY > 145 && clickY < 190)) {
				upgrade(1);
				repaint();
			}

			// detect clicks in the "run" for Newspapers (asset 2)
			if ((clickX < 750 && clickX > 680) && (clickY > 275 && clickY < 345)) {
				income(2);
				repaint();
			}

			// detect clicks in the "upgrade" for Newspapers (asset 2)
			if ((clickX < 625 && clickX > 400) && (clickY > 315 && clickY < 360)) {
				upgrade(2);
				repaint();
			}

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}