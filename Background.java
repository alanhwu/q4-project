import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background {
    private int x, y;
    private Image img;

    public Background(String fileName) {
        x = 0;
        y = 0;
        img = getImage("adcap_banner.jpg");
        init(x, y);
    }

    private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, tx, null);
    }

    private void init(double a, double b) {
        tx.setToTranslation(a, b);
    }

    private Image getImage(String path) {
        Image tempImage = null;
        try {
            URL imageURL = Driver.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempImage;
    }
}