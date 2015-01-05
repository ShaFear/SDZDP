package vizualizacja;

import javax.swing.*;
import java.awt.*;

/**
 * Created by shafe_000 on 2015-01-05.
 */
class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
