import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverter extends JFrame implements ActionListener {

    private JTextField temperatureField;
    private JComboBox<String> conversionBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public TemperatureConverter() {

        setTitle("Temperature Converter");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Temperature Converter");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        temperatureField = new JTextField(10);

        String[] conversions = {
                "Celsius to Fahrenheit",
                "Fahrenheit to Celsius",
                "Celsius to Kelvin",
                "Kelvin to Celsius",
                "Fahrenheit to Kelvin",
                "Kelvin to Fahrenheit"
        };

        conversionBox = new JComboBox<>(conversions);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);

        resultLabel = new JLabel("Result: ");

        add(titleLabel);
        add(new JLabel("Enter Temperature:"));
        add(temperatureField);
        add(conversionBox);
        add(convertButton);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            double temp = Double.parseDouble(temperatureField.getText());
            double result = 0;

            String conversion =
                    (String) conversionBox.getSelectedItem();

            switch (conversion) {

                case "Celsius to Fahrenheit":
                    result = (temp * 9 / 5) + 32;
                    break;

                case "Fahrenheit to Celsius":
                    result = (temp - 32) * 5 / 9;
                    break;

                case "Celsius to Kelvin":
                    result = temp + 273.15;
                    break;

                case "Kelvin to Celsius":
                    result = temp - 273.15;
                    break;

                case "Fahrenheit to Kelvin":
                    result = (temp - 32) * 5 / 9 + 273.15;
                    break;

                case "Kelvin to Fahrenheit":
                    result = (temp - 273.15) * 9 / 5 + 32;
                    break;
            }

            resultLabel.setText(
                    "Result: " + String.format("%.2f", result));

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number!",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new TemperatureConverter());
    }
}
