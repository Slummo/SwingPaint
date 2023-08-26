package application;

import javax.swing.*;
import java.awt.*;

public class MenuBar extends JMenuBar {
    private DrawPanel panel;
    private final JSpinner spinner;

    public MenuBar(DrawPanel panel) {
        super();
        this.panel = panel;
        spinner = new JSpinner();
        spinner.setValue(panel.getCurrentStrokeWidth());
        spinner.addChangeListener(e -> panel.setCurrentStrokeWidth((int) spinner.getValue()));

        JMenu tools = new JMenu("Tools");
        JMenuItem t_clear = new JMenuItem("Clear");
        t_clear.addActionListener(e -> panel.clear());
        tools.add(t_clear);

        JMenu format = new JMenu("Format");
        JMenuItem f_color = new JMenuItem("Color");
        f_color.addActionListener(e -> {
            System.out.println("Ciao");
            Color c = JColorChooser.showDialog(panel, "Choose color", Color.black);
            panel.setCurrentStrokeColor(c);
        });
        format.add(f_color);
        JMenuItem f_width = new JMenuItem("Width");
        f_width.add(spinner);
        format.add(f_width);


        add(tools);
        add(format);
    }
}
