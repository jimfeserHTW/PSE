package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Entry extends JFrame {

    public Entry() {
        setTitle("Eingabe");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2, 5, 5));
    

        JTextField inputField = new JTextField("Gib etwas ein...");
        inputField.setHorizontalAlignment(JTextField.CENTER);
        add(inputField);

        setVisible(true);

        JButton confirmButton = new JButton("Bestätigen");
        confirmButton.addActionListener((ActionEvent e) -> {
            String inputText = inputField.getText();
            JOptionPane.showMessageDialog(null, "Du hast folgendes eingegeben: " + inputText);
        });
        add(confirmButton);
    }
}