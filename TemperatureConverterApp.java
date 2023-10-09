 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp {
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JLabel outputLabel;
    private JButton celsiusToFahrenheitButton;
    private JButton fahrenheitToCelsiusButton;

    public TemperatureConverterApp() {
        frame = new JFrame("Temperature Converter");
        panel = new JPanel();
        inputField = new JTextField(10);
        outputLabel = new JLabel("");
        celsiusToFahrenheitButton = new JButton("Celsius to Fahrenheit");
        fahrenheitToCelsiusButton = new JButton("Fahrenheit to Celsius");

        // Set up the GUI layout
        panel.setLayout(new GridLayout(4, 1));
        panel.add(inputField);
        panel.add(outputLabel);
        panel.add(celsiusToFahrenheitButton);
        panel.add(fahrenheitToCelsiusButton);

        // Add action listeners to the buttons
        celsiusToFahrenheitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCelsiusToFahrenheit();
            }
        });

        fahrenheitToCelsiusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertFahrenheitToCelsius();
            }
        });

        // Add the panel to the frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(inputField.getText());
            double fahrenheit = (celsius * 9 / 5) + 32;
            outputLabel.setText("Result: " + fahrenheit + " °F");
        } catch (NumberFormatException e) {
            outputLabel.setText("Invalid input");
        }
    }

    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(inputField.getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            outputLabel.setText("Result: " + celsius + " °C");
        } catch (NumberFormatException e) {
            outputLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverterApp();
            }
        });
    }
}
