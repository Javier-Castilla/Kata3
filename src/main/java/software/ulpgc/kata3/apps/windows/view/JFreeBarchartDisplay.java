package software.ulpgc.kata3.apps.windows.view;

import org.jfree.chart.ChartPanel;
import software.ulpgc.kata3.architecture.model.Barchart;
import software.ulpgc.kata3.architecture.view.BarchartDisplay;

import javax.swing.*;
import java.awt.*;

public class JFreeBarchartDisplay extends JPanel implements BarchartDisplay {
    public JFreeBarchartDisplay() {
        setLayout(new BorderLayout());
    }

    @Override
    public void show(Barchart barchart) {
        removeAll();
        add(new ChartPanel(JFreeBarchartAdapter.adapt(barchart)));
        revalidate();
    }
}
