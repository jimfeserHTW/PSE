package java_practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class PSE extends JFrame {

    // Liste der Elemente (vereinfacht)
    private static final String[][] ELEMENTS = {
        {"H", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "He"},
        {"Li", "Be", "", "", "", "", "", "", "", "", "", "", "B", "C", "N", "O", "F", "Ne"},
        {"Na", "Mg", "", "", "", "", "", "", "", "", "", "", "Al", "Si", "P", "S", "Cl", "Ar"},
        {"K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr"},
        {"Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe"},
        {"Cs", "Ba", "La", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn"},
        {"Fr", "Ra", "Ac", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og"}
    };

    public PSE() {
        setTitle("Periodensystem der Elemente");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int maxColumns = 0;
        for (String[] row : ELEMENTS) {
            maxColumns = Math.max(maxColumns, row.length);
        }
    
        // GridLayout mit der richtigen Anzahl an Zeilen und Spalten setHorizontalAlignment
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
    
        for (int i = 0; i < ELEMENTS.length-1; i++) {
            for (int j = 0; j < ELEMENTS[i].length; j++) {// Leere Felder, wenn die Zeile kürzer ist
                System.out.println(ELEMENTS[i][j]);
                System.out.println(i + " " + j);
                JTextField textField = new JTextField(ELEMENTS[i][j]);
                textField.setHorizontalAlignment(JTextField.CENTER);
                textField.setBackground(getElementColor(ELEMENTS[i][j]));
                textField.setEditable(false);
                gbc.gridx = j;
                gbc.gridy = i;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.weightx = 20;
                gbc.weighty = 20;
                add(textField, gbc);
            }
        }

        setVisible(true);

        Entry n = new Entry();
    }

    // Methode zur Farbgebung nach Elementgruppen
    private Color getElementColor(String element) {
        if (" ".contains(element)){
            return new Color(50, 50, 50);
        }
        if ("H He".contains(element)){
            return Color.CYAN;
        }
        if ("Li Be Na Mg K Ca Rb Sr Cs Ba Fr Ra".contains(element)){
            return Color.ORANGE;
        }
        if ("Sc Ti V Cr Mn Fe Co Ni Cu Zn Y Zr Nb Mo Tc Ru Rh Pd Ag Cd Hf Ta W Re Os Ir Pt Au Hg Rf Db Sg Bh Hs Mt Ds Rg Cn".contains(element)){
            return Color.LIGHT_GRAY;
        }
        if ("B C N O F Ne Al Si P S Cl Ar Ga Ge As Se Br Kr In Sn Sb Te I Xe Tl Pb Bi Po At Rn".contains(element)){
            return Color.YELLOW;
        }
        if ("La Ac".contains(element)){ 
            return Color.PINK;
        }
        return Color.WHITE; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PSE::new);
    }
}

class Entry extends JFrame {

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