package GUI;

import world.World;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow {
    JFrame frame;
    JPanel fieldsPanel, buttonPanel;
    JLabel rowsLabel, colsLabel, cowsLabel;
    JTextField rowsField, colsField, cowsField;
    JButton startButton;

    public WelcomeWindow(){
        frame = new JFrame("Welcome to Nature!");
        fieldsPanel = new JPanel();
        buttonPanel = new JPanel();
        rowsLabel = new JLabel("Number of rows: ");
        colsLabel = new JLabel("Number of columns: ");
        cowsLabel = new JLabel("Number of cows: ");
        rowsField = new JTextField("");
        colsField = new JTextField("");
        cowsField = new JTextField("");
        startButton = new JButton("Start!");

        //add functionality to fields and buttons

        startButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            World world = new World(getStartRows(), getStartCols(), getStartCows());
            frame.setVisible(false);
            frame.dispose();
        }));

        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.setLayout(new FlowLayout());

        fieldsPanel.add(rowsLabel);
        fieldsPanel.add(rowsField);
        fieldsPanel.add(colsLabel);
        fieldsPanel.add(colsField);
        fieldsPanel.add(cowsLabel);
        fieldsPanel.add(cowsField);
        buttonPanel.add(startButton);

        frame.add(fieldsPanel, BorderLayout.PAGE_START);
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public int getStartRows() {
        return Integer.parseInt(rowsField.getText());
    }

    public int getStartCols() {
        return Integer.parseInt(colsField.getText());
    }

    public int getStartCows() {
        return Integer.parseInt(cowsField.getText());
    }
}
