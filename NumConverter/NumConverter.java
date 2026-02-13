package NumConverter;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

// work in progress

public class NumConverter {
    private static String toString(ArrayList<String> arr) {
        String str = "";

        for (int i = arr.size() - 1; i >= 0; i--) {
            str += arr.get(i);
        }

        return str;
    }

    public static String toBinary(Number num) {
        ArrayList<String> res = new ArrayList<>();

        if (num.intValue() == 0) {
            return "00000000";
        }

        while (num.intValue() >= 1) {
            if (num.intValue() % 2 == 1) {
                res.add("1");
                num = Math.round(num.intValue() / 2);
            } else {
                res.add("0");
                num = Math.round(num.intValue() / 2);
            }
        }

        return toString(res);
    }

    public static String toHex(Number num) {
        ArrayList<String> res = new ArrayList<>();

        if (num.intValue() <= 9) {
            return Integer.toString(num.intValue());
        } 

        while(num.intValue() >= 1) {
            if (num.intValue() % 16 == 10) {
                res.add("A");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 11) {
                res.add("B");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 12) {
                res.add("C");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 13) {
                res.add("D");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 14) {
                res.add("E");
                num = Math.round(num.intValue() / 16);
            } else if (num.intValue() % 16 == 15) {
                res.add("F");
                num = Math.round(num.intValue() / 16);
            } else {
                res.add(Integer.toString(num.intValue() % 16));
                num = Math.round(num.intValue() / 16);
            }
        }

        return toString(res);
    }

    public static void main(String[] args) throws ParseException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel inputPanel = new JPanel();
        JPanel outputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));

        // input components
        JLabel inputLabel = new JLabel("Number to Convert");
        JFormattedTextField numInput = new JFormattedTextField(NumberFormat.getIntegerInstance());

        // output componets
        JLabel binLabel = new JLabel("Binary: ");
        JLabel hexLabel = new JLabel("Hexadecimal: ");

        // buttons
        JButton inputButton = new JButton("Convert");
        inputButton.addActionListener(e -> {
            binLabel.setText("Binary: " + toBinary((Number) numInput.getValue()));
            hexLabel.setText("Hexadeciemal: " + toHex((Number) numInput.getValue()));
        });

        // input panel
        inputPanel.add(inputLabel);
        inputPanel.add(numInput);
        inputPanel.add(inputButton);

        // output panel
        outputPanel.add(binLabel);
        outputPanel.add(hexLabel);

        // frame
        frame.setSize(700, 700);
        frame.add(inputPanel);
        frame.add(outputPanel);
        frame.setVisible(true);

        // System.out.println(toBinary(87));
        // System.out.println(toBinary(20));
        // System.out.println(toBinary(255));
        // System.out.println(toBinary(0));
        // System.out.println(toBinary(4532));
        // System.out.println(toBinary(97644));
        // System.out.println("---------------------------------");
        // System.out.println(toHex(87));
        // System.out.println(toHex(20));
        // System.out.println(toHex(347));
        // System.out.println(toHex(2220));
    }
}