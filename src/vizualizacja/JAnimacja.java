package vizualizacja;

import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by shafe_000 on 2015-01-05.
 */
public class JAnimacja extends JLabel{
    private BufferedImage image;
    private Ellipse2D.Double[] circles;
    private Integer czas;
    private Timer autoplayTimer;
    private RuchSamochodow ruchSamochodow;

    public JAnimacja(RuchSamochodow ruchSamochodow) {
        this.ruchSamochodow = ruchSamochodow;
        try {
            image = ImageIO.read(new File("test/mapa.png"));
        } catch (IOException ex) {
            // handle exception...
        }
        this.setVisible(true);
        circles = new Ellipse2D.Double[ruchSamochodow.samochody.size()];

        for(int j=0; j<circles.length; j++){
            circles[j] = new Ellipse2D.Double(j*50, j*10, 20, 20);
        }
        czas = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, 0, 0, null);
        for(int j=0; j<circles.length; j++){
            switch (j){
                case 0: {g2d.setPaint(Color.ORANGE); break;}
                case 1: {g2d.setPaint(Color.YELLOW); break;}
                case 2: {g2d.setPaint(Color.pink); break;}
                case 3: {g2d.setPaint(Color.DARK_GRAY); break;}
                case 4: {g2d.setPaint(Color.CYAN); break;}
                case 5: {g2d.setPaint(Color.magenta); break;}
                case 6: {g2d.setPaint(Color.WHITE); break;}
                default: {g2d.setPaint(Color.LIGHT_GRAY); break;}
            }
            g2d.fill(circles[j]);
        }
        g2d.setPaint(Color.black);
        g2d.drawString(czas.toString(), 10, 20);
    }

    public void moveCircles(){
            circles = PozycjeSamochodow.setPozycjeSamochodow(czas, circles, ruchSamochodow);
            this.paintComponent(this.getGraphics());
            czas++;
    }

    public void initTimer() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                moveCircles();
            }
        };
        autoplayTimer = new Timer(50, listener);
        autoplayTimer.start();
    }

}
