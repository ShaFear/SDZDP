import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import gko.Gko;

import java.awt.*;
import javax.swing.*;

public class VGraph extends JFrame {
    public VGraph(Gko gko){
        super("graf");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Graph g = getGraph(gko);
        VisualizationViewer<Integer,String> vv =
                new VisualizationViewer<Integer,String>(new FRLayout<Integer, String>(g),
                        new Dimension (600,600));

        DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
        gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
        vv.setGraphMouse(gm);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<String>());

        getContentPane().add(vv);

        pack();
        setSize(new Dimension(700, 700));
        setVisible(true);
    }

    public Graph getGraph(Gko gko) {
        Graph<String, String> g = new SparseGraph<String, String>();
        for(int j=0; j<gko.getKmip().getMiasta().size(); j++){
            g.addVertex(gko.getKmip().getMiasta().get(j).toString());
        }
        for(int j=0; j<gko.getKmip().getMiasta().size(); j++){
            g.addVertex(gko.getKmip().getMiasta().get(j).toString());
            for(int i=0; i<gko.getKmip().getMiasta().get(j).getW().polaczenia.size(); i++){
                g.addEdge(gko.getKmip().getMiasta().get(j).toString() + "-" + gko.getKmip().getMiasta().get(j).getW().polaczenia.get(i).cel.getMiasto().toString() +": "
                        + gko.getKmip().getMiasta().get((j)).getW().polaczenia.get(i).odleglosc,
                        gko.getKmip().getMiasta().get(j).toString(),
                        gko.getKmip().getMiasta().get(j).getW().polaczenia.get(i).cel.getMiasto().toString());
            }
        }

        return g;
    }
}