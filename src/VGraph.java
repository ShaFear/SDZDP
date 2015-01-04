import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.visualization.*;

import java.awt.*;
import javax.swing.*;

public class VGraph extends JFrame {
    public VGraph(){
        super("Mój pierwszy graf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Graph g = getGraph();
        VisualizationViewer<Integer,String> vv =
                new VisualizationViewer<Integer,String>(new FRLayout(g),
                        new Dimension (300,200));
        getContentPane().add(vv);

        pack();
        setSize (new Dimension (400, 300));
        setVisible(true);
    }

    public Graph getGraph() {
        Graph<Integer, String> g = new SparseGraph<Integer, String>();
        g.addVertex((Integer)1);
        g.addVertex((Integer)2);
        g.addVertex((Integer)3);
        g.addEdge("Edge-A", 1, 2);
        g.addEdge("Edge-B", 2, 3);
        g.addEdge("Edge-C", 3, 1);
        return g;
    }
}