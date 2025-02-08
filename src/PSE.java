package src;

import java.awt.*;
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

    private static int maxColumns;
    private static final int MAX_ROWS = 7;
    private static final Color MAIN_BG = new Color(64, 63, 60);

    public PSE() {
        setTitle("Periodensystem der Elemente");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(MAIN_BG);

        maxColumns = 0;
        for (String[] row : ELEMENTS) {
            maxColumns = Math.max(maxColumns, row.length);
        }
    
        // GridLayout mit der richtigen Anzahl an Zeilen und Spalten setHorizontalAlignment
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbl);
    
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < maxColumns; j++) {// Leere Felder, wenn die Zeile kürzer ist
                JLabel label = new JLabel(" " + ELEMENTS[i][j]);
                label.setBackground(getElementColor(ELEMENTS[i][j]));
                label.setOpaque(true);
                label.setBorder(BorderFactory.createLineBorder(MAIN_BG, 2));
                
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

        configureElements();

        new Entry();
    }

    private static void configureElements(){
        for (int i = 0; i < MAX_ROWS; i++) {
            for (int j = 0; j < maxColumns; j++) {
                
            }
        }
    }

    // Color Scheme
    private Color getElementColor(String element) {

        // default
        if (" ".contains(element)){
            return MAIN_BG;
        }

        // Nichtmetalle (Rot)
        for (String elem: new String[] {"H", "C", "N", "O", "P", "S", "Se"}) {
            if (element.equals(elem)){
                return new Color(225, 130, 135);      
            }
        }
        // Alkaliemetalle (Grün)
        for (String elem: new String[] {"Li", "Na", "K", "Rb", "Cs", "Fr"}) {
            if (element.equals(elem)){
                return new Color(183, 206, 143);     
            }
        }
        // Erdalkalimetalle (Dunkelgrün)
        for (String elem: new String[] {"Be", "Mg", "Ca", "Sr", "Ba", "Ra"}) {
            if (element.equals(elem)){
                return new Color(152, 173, 121);     
            }
        }
        // Übergangsmetalle (Blau)
        for (String elem: new String[] {"Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "La", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Ac", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn"}) {
            if (element.equals(elem)){
                return new Color(122, 149, 179);    
            }
        }
        // Andere Metalle (Lila)
        for (String elem: new String[] {"B", "Si", "Ge", "As", "Sb", "Te", "Po"}) {
            if (element.equals(elem)){
                return new Color(194, 156, 178);    
            }
        }
        // Halbmetalle (hell Lila)
        for (String elem: new String[] {"Al", "Ga", "In", "Sn", "Tl", "Pb", "Bi", "Nh", "Fl", "Mc", "Lv"}) {
            if (element.equals(elem)){
                return new Color(164, 131, 166);   
            }
        }
        // Halogene (orange/beige)
        for (String elem: new String[] {"F", "Cl", "Br", "I", "At", "Ts"}) {
            if (element.equals(elem)){
                return new Color(233, 165, 153);   
            }
        }
        // Edelgase (Gelb/Beige)
        for (String elem: new String[] {"He", "Ne", "Ar", "Kr", "Xe", "Rn", "Og"}) {
            if (element.equals(elem)){
                return new Color(241, 197, 169);  
            }
        }
        
        return Color.WHITE; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PSE::new);
    }
}
