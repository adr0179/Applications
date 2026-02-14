package NumConverter;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;

import javax.swing.*;

public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 20, 20, 20);
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setOpaque(false);

        JPanel inputPanel = new JPanel();
        JPanel outputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setOpaque(false);
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
        outputPanel.setOpaque(false);

        // input components
        JLabel inputLabel = new JLabel("Number to Convert:");
        inputLabel.setOpaque(true);
        JFormattedTextField numInput = new JFormattedTextField(NumberFormat.getIntegerInstance());
        
        // colour
        JColorChooser colour = new JColorChooser();
        colour.setVisible(false);

        colour.getSelectionModel().addChangeListener(e -> {
            frame.getContentPane().setBackground(colour.getColor());
        });

        // output componets
        JLabel decimalLabel = new JLabel("Decimal: ");
        JLabel binLabel = new JLabel("Binary: ");
        JLabel hexLabel = new JLabel("Hexadecimal: ");
        decimalLabel.setOpaque(true);
        binLabel.setOpaque(true);
        hexLabel.setOpaque(true);

        // buttons
        JButton inputButton = new JButton("Convert");
        inputButton.addActionListener(e -> {
            if ((Number) numInput.getValue() == null) {
                JOptionPane.showMessageDialog(frame, "Input Must Be A Number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                decimalLabel.setText("Decimal: " + (Number)numInput.getValue());
                binLabel.setText("Binary: " + NumConverter.toBinary((Number) numInput.getValue()));
                hexLabel.setText("Hexadeciemal: " + NumConverter.toHex((Number) numInput.getValue()));
            }
        });

        JButton colourChangeButton = new JButton("Change Background Colour");
        colourChangeButton.setBackground(Color.LIGHT_GRAY);
        colourChangeButton.addActionListener(e -> {
            // set colour visable
            if (!colour.isVisible()) {
                colour.setVisible(true);
            } else {
                colour.setVisible(false);
            }
        });

        // reset input field on click
        inputButton.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                numInput.setValue(null);
            }
        });

        // input panel
        inputPanel.add(inputLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(numInput);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(inputButton);

        // output panel
        outputPanel.add(decimalLabel);
        outputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        outputPanel.add(binLabel);
        outputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        outputPanel.add(hexLabel);

        // frame
        frame.setSize(550, 550);
        mainPanel.add(inputPanel, c);
        mainPanel.add(outputPanel, c);
        frame.add(colour, BorderLayout.PAGE_END);
        frame.add(colourChangeButton, BorderLayout.PAGE_START);
        frame.add(mainPanel, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
}