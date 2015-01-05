package vizualizacja;
import javax.swing.*;
import java.awt.*;

/**
 * Created by shafe_000 on 2015-01-05.
 */
public class JRuchSamochodow extends JFrame{
    public void uruchom(RuchSamochodow ruchSamochodow){
        this.setSize(730, 546);
        this.setResizable(false);

        JAnimacja jPanel = new JAnimacja(ruchSamochodow);
        jPanel.setBackground(Color.DARK_GRAY);
        this.add(jPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel.initTimer();
        this.setVisible(true);
    }
}
