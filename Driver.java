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
    int balance = 200000;

    // create variables to keep track of how many assets the player has
    // start off the game with 1 lemonade stand
    int numLemons = 1;
    int numNews = 0;
    int numCars = 0;
    int numPizzas = 0;
    int numDonuts = 0;
    int numShrimp = 0;
    int numCrypto = 0;
    int numMovies = 0;
    int numBanks = 0;
    int numTech = 0;

    // create variables to keep track of how much money upgrading each asset costs
    int LemonCost = 30 * numLemons;
    int NewsCost = 200 * (numNews + 1);
    int CarsCost = 500 * (numCars + 1);
    int PizzasCost = 1000 * (numPizzas + 1);
    int DonutsCost = 2000 * (numDonuts + 1);

    int ShrimpCost = 2000 * (numShrimp + 1);
    int CryptoCost = 3000 * (numCrypto + 1);
    int MovieCost = 4000 * (numMovies + 1);
    int BankCost = 5000 * (numBanks + 1);
    int TechCost = 10000 * (numTech + 1);

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

        ShrimpCost = 2000 * (numShrimp + 1);
        CryptoCost = 3000 * (numCrypto + 1);
        MovieCost = 4000 * (numMovies + 1);
        BankCost = 5000 * (numBanks + 1);
        TechCost = 10000 * (numTech + 1);

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
            g.fillRect(1275, 80 + i * 170, 70, 70);
            g.fillRect(1000, 120 + i * 170, 225, 45);
            g.setColor(Color.black);
            g.drawString("Run", 675, 120 + i * 170);
            g.drawString("Run", 1275, 120 + i * 170);

        }

        // --------------- Column 1 Assets --------------- //

        g.drawString("Lemonade Stand", 385, 100);
        // display how much income this asset generates (in this case, it's number of
        // lemons * 5)
        g.setColor(Color.red);
        g.drawString("Income:" + numLemons * 5, 390, 50);
        g.setColor(Color.black);
        // display how much it costs to upgrade this asset (this cost is kept track in a
        // handy variable)
        g.drawString("Upgrade" + "($" + LemonCost + ")", 400, 150);

        g.drawString("Newspapers", 385, 275);
        g.setColor(Color.red);
        g.drawString("Income:" + numNews * 30, 390, 225);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + NewsCost + ")", 400, 325);

        g.drawString("Car Wash", 385, 450);
        g.setColor(Color.red);
        g.drawString("Income:" + numCars * 30, 390, 405);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + CarsCost + ")", 400, 490);

        g.drawString("Pizzeria", 385, 625);
        g.setColor(Color.red);
        g.drawString("Income:" + numPizzas * 30, 390, 575);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + PizzasCost + ")", 400, 660);

        g.drawString("Donut Shop", 385, 790);
        g.setColor(Color.red);
        g.drawString("Income:" + numDonuts * 30, 390, 750);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + DonutsCost + ")", 400, 840);

        // --------------- Column 2 Assets --------------- //

        g.drawString("Shrimp Boat", 1000, 100);
        g.setColor(Color.red);
        g.drawString("Income:" + numShrimp * 30, 990, 50);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + ShrimpCost + ")", 1000, 150);

        g.drawString("Cryptocurrency", 1000, 275);
        g.setColor(Color.red);
        g.drawString("Income:" + numCrypto * 50, 990, 225);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + CryptoCost + ")", 1000, 325);

        g.drawString("Movie Studio", 1000, 450);
        g.setColor(Color.red);
        g.drawString("Income:" + numMovies * 100, 990, 405);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + MovieCost + ")", 1000, 490);

        g.drawString("Bank", 1000, 625);
        g.setColor(Color.red);
        g.drawString("Income:" + numBanks * 150, 990, 575);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + BankCost + ")", 1000, 660);

        g.drawString("Tech Company", 1000, 790);
        g.setColor(Color.red);
        g.drawString("Income:" + numTech * 200, 990, 750);
        g.setColor(Color.black);
        g.drawString("Upgrade" + "($" + TechCost + ")", 1000, 840);

        // display how many of each asset the player has in Blue
        g.setColor(Color.BLUE);
        g.drawString("#:" + numLemons, 325, 100);
        g.drawString("#:" + numNews, 325, 290);
        g.drawString("#:" + numCars, 325, 450);
        g.drawString("#:" + numPizzas, 325, 630);
        g.drawString("#:" + numDonuts, 325, 800);

        g.drawString("#:" + numShrimp, 925, 100);
        g.drawString("#:" + numCrypto, 925, 290);
        g.drawString("#:" + numMovies, 925, 450);
        g.drawString("#:" + numBanks, 925, 630);
        g.drawString("#:" + numTech, 925, 800);

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
        // these numbers must match the numbers displayed in the Upgrade cost string
        // this is where it actually increments the player's balance
        if (asset == 1) {
            balance += numLemons * 5;
        }
        if (asset == 2) {
            balance += numNews * 30;
        }
        if (asset == 3) {
            balance += numCars * 60;
        }
        if (asset == 4) {
            balance += numPizzas * 120;
        }
        if (asset == 5) {
            balance += numDonuts * 240;
        }
        if (asset == 6) {
            balance += numShrimp * 5;
        }
        if (asset == 7) {
            balance += numCrypto * 30;
        }
        if (asset == 8) {
            balance += numMovies * 60;
        }
        if (asset == 9) {
            balance += numBanks * 120;
        }
        if (asset == 10) {
            balance += numTech * 240;
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
        if (asset == 6) {
            if (balance > ShrimpCost) {
                balance -= ShrimpCost;
                numShrimp++;
            }
        }
        if (asset == 7) {
            if (balance > CryptoCost) {
                balance -= CryptoCost;
                numCrypto++;
            }
        }
        if (asset == 8) {
            if (balance > MovieCost) {
                balance -= MovieCost;
                numMovies++;
            }
        }
        if (asset == 9) {
            if (balance > BankCost) {
                balance -= BankCost;
                numBanks++;
            }
        }
        if (asset == 10) {
            if (balance > TechCost) {
                balance -= TechCost;
                numTech++;
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

            // ------------------- COLUMN ONE ASSETS ------------------- //

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

            // detect clicks in the "run" for Car Wash (asset 3)
            if ((clickX < 750 && clickX > 680) && (clickY > 465 && clickY < 535)) {
                income(3);
                repaint();
            }

            // detect clicks in the "upgrade" for Car Wash (asset 3)
            if ((clickX < 625 && clickX > 400) && (clickY > 500 && clickY < 550)) {
                upgrade(3);
                repaint();
            }

            // detect clicks in the "run" for Pizza (asset 4)
            if ((clickX < 750 && clickX > 680) && (clickY > 630 && clickY < 700)) {
                income(4);
                repaint();
            }

            // detect clicks in the "upgrade" for Pizza (asset 4)
            if ((clickX < 625 && clickX > 400) && (clickY > 720 && clickY < 675)) {
                upgrade(4);
                repaint();
            }

            // detect clicks in the "run" for Donut (asset 5)
            if ((clickX < 750 && clickX > 680) && (clickY > 800 && clickY < 875)) {
                income(5);
                repaint();
            }

            // detect clicks in the "upgrade" for Donut (asset 5)
            if ((clickX < 625 && clickX > 400) && (clickY > 845 && clickY < 890)) {
                upgrade(5);
                repaint();
            }

            // ------------------- COLUMN TWO ASSETS ------------------- //

            // detect clicks in the "run" for shrimp (asset 6)
            if ((clickX < 1345 && clickX > 1275) && (clickY > 110 && clickY < 180)) {
                income(6);
                repaint();
            }

            // detect clicks in the "upgrade" for shrimp (asset 6)
            if ((clickX < 1225 && clickX > 1000) && (clickY > 145 && clickY < 190)) {
                upgrade(6);
                repaint();
            }

            // detect clicks in the "run" for crypto (asset 7)
            if ((clickX < 1345 && clickX > 1275) && (clickY > 275 && clickY < 345)) {
                income(7);
                repaint();
            }

            // detect clicks in the "upgrade" for crypto (asset 7)
            if ((clickX < 1225 && clickX > 1000) && (clickY > 315 && clickY < 360)) {
                upgrade(7);
                repaint();
            }

            // detect clicks in the "run" for theater (asset 8)
            if ((clickX < 1345 && clickX > 1275) && (clickY > 465 && clickY < 535)) {
                income(8);
                repaint();
            }

            // detect clicks in the "upgrade" for theater (asset 8)
            if ((clickX < 1225 && clickX > 1000) && (clickY > 500 && clickY < 550)) {
                upgrade(8);
                repaint();
            }

            // detect clicks in the "run" for bank (asset 9)
            if ((clickX < 1345 && clickX > 1275) && (clickY > 630 && clickY < 725)) {
                income(9);
                repaint();
            }

            // detect clicks in the "upgrade" for bank (asset 9)
            if ((clickX < 1225 && clickX > 1000) && (clickY > 720 && clickY < 675)) {
                upgrade(9);
                repaint();
            }

            // detect clicks in the "run" for tech (asset 10)
            if ((clickX < 1345 && clickX > 1275) && (clickY > 800 && clickY < 875)) {
                income(10);
                repaint();
            }

            // detect clicks in the "upgrade" for tech (asset 10)
            if ((clickX < 1225 && clickX > 1000) && (clickY > 845 && clickY < 890)) {
                upgrade(10);
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