package software.ulpgc.kata3.apps.windows.view;

import software.ulpgc.kata3.architecture.control.Command;
import software.ulpgc.kata3.architecture.view.BarchartDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final BarchartDisplay display;
    private final Map<String, Command> commands;

    public MainFrame() throws HeadlessException {
        setTitle("Kata3");
        setSize(800, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, createToolbar());
        add(BorderLayout.CENTER, (Component) (this.display = createBarchartDisplay()));
        commands = new HashMap<>();
    }

    private JFreeBarchartDisplay createBarchartDisplay() {
        return new JFreeBarchartDisplay();
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Toggle"));
        return panel;
    }

    private JButton createButton(String name) {
        JButton button = new JButton(name);
        button.addActionListener(e -> commands.get(name.toLowerCase()).execute());
        return button;
    }

    public MainFrame add(String name, Command command) {
        commands.put(name, command);
        return this;
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        commands.get("toggle").execute();
    }

    public BarchartDisplay display() {
        return display;
    }
}
