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

    private int maxColumns;
    private int maxRows;
    private Color mainBackground;

    public PSE() {
        setTitle("Periodensystem der Elemente");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainBackground = new Color(64, 63, 60);
        setBackground(mainBackground);

        maxRows = 7;
        maxColumns = 0;
        for (String[] row : ELEMENTS) {
            maxColumns = Math.max(maxColumns, row.length);
        }
    
        // GridLayout mit der richtigen Anzahl an Zeilen und Spalten setHorizontalAlignment
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
    
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxColumns; j++) {// Leere Felder, wenn die Zeile kürzer ist
                JLabel label = new JLabel(ELEMENTS[i][j]);
                label.setBackground(getElementColor(ELEMENTS[i][j]));
                label.setOpaque(true);
                label.setBorder(BorderFactory.createLineBorder(mainBackground, 2));
                
                gbc.gridx = j;
                gbc.gridy = i;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.weightx = 20;
                gbc.weighty = 20;
    
                add(label, gbc);
            }
        }

        setVisible(true);

        new Entry();
    }

    // Methode zur Farbgebung nach Elementgruppen
    private Color getElementColor(String element) {

        
        // Nichtmetalle (Rot)
         String[] nichtmetalle = {"H", "C", "N", "O", "P", "S", "Se"};
        // Alkaliemetalle (Grün)
        
        // Erdalkalimetalle (Dunkelgrün)
        
        // Übergangsmetalle (Blau)
        
        // Andere Metalle (Lila)
        
        // Halbmetalle (hell Lila)
        
        // Halogene (orange/beige)
        
        // Edelgase (Gelb/Beige)
       // for (String[] elem: ELEMENTS){
           // for (String word: elem){
            //    if (Arrays.asList(nichtmetalle).contains(word)){
           //         return new Color(225, 130, 135);
         //       }
        //    }
      //  } //TODO Problem!!!

        if (element.equals("B")){
            return new Color(194, 156, 178);
        }
        if (element.equals("F")){
            return new Color(233, 165, 153);
        }
        if (element.equals("I")){
            return new Color(233, 165, 153);
        }
        if (" ".contains(element)){
            return mainBackground;
        }
        if ("H C N O P S Se".contains(element)){
            return new Color(225, 130, 135);
        }
        if ("Li Na K Rb Cs Fr".contains(element)){
            return new Color(183, 206, 143);
        }
        if ("Be Mg Ca Sr Ba Ra".contains(element)){
            return new Color(152, 173, 121);
        }
        if ("Sc Ti V Cr Mn Fe Co Ni Cu Zn Y Zr Nb Mo Tc Ru Rh Pd Ag Cd La Hf Ta W Re Os Ir Pt Au Hg Ac Rf Db Sg Bh Hs Mt Ds Rg Cn".contains(element)){
            return new Color(122, 149, 179);
        }
        if ("B Si Ge As Sb Te Po".contains(element)){ 
            return new Color(194, 156, 178);
        }
        if ("Al Ga In Sn Tl Pb Bi Nh Fl Mc Lv".contains(element)){ 
            return new Color(164, 131, 166);
        }
        if ("F Cl Br I At Ts".contains(element)){ 
            return new Color(233, 165, 153);
        }
        if ("He Ne Ar Kr Xe Rn Og".contains(element)){ 
            return new Color(241, 197, 169);
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