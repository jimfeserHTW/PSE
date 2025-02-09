package src;

import java.awt.*;
import javax.swing.*;

public class PSE extends JFrame {

    // List of Elements
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

    private static void setElementObjects(){
        ChemicalElement h = new ChemicalElement(1, "h", new String[] {"Hydrogen", "Wasserstoff"}, 1.008, 2.20, "1s^1", -259, -253, new int[] {1, -1}, 0.00);
        ChemicalElement he = new ChemicalElement(2, "He", new String[]{"Helium", "Helium"}, 4.0026, "1s^2", -272, -269);
        ChemicalElement li = new ChemicalElement(3, "Li", new String[]{"Lithium", "Lithium"}, 6.94, 0.98, "[He] 2s^1", 181, 1347, new int[]{1}, 0.98);
        ChemicalElement be = new ChemicalElement(4, "Be", new String[]{"Beryllium", "Beryllium"}, 9.0122, 1.57, "[He] 2s^2", 1287, 2470, new int[]{2}, 1.57);
        ChemicalElement b = new ChemicalElement(5, "B", new String[]{"Boron", "Bor"}, 10.81, 2.04, "[He] 2s^2 2p^1", 2076, 3927, new int[]{3}, 2.04);
        ChemicalElement c = new ChemicalElement(6, "C", new String[]{"Carbon", "Kohlenstoff"}, 12.011, 2.55, "[He] 2s^2 2p^2", 3550, 4827, new int[]{4, 2, -4}, 2.55);
        ChemicalElement n = new ChemicalElement(7, "N", new String[]{"Nitrogen", "Stickstoff"}, 14.007, 3.04, "[He] 2s^2 2p^3", -210, -196, new int[]{3, 5, -3}, 3.04);
        ChemicalElement o = new ChemicalElement(8, "O", new String[]{"Oxygen", "Sauerstoff"}, 15.999, 3.44, "[He] 2s^2 2p^4", -219, -183, new int[]{-2}, 3.44);
        ChemicalElement f = new ChemicalElement(9, "F", new String[]{"Fluorine", "Fluor"}, 18.998, 3.98, "[He] 2s^2 2p^5", -220, -188, new int[]{-1}, 3.98);
        ChemicalElement ne = new ChemicalElement(10, "Ne", new String[]{"Neon", "Neon"}, 20.180, "[He] 2s^2 2p^6", -249, -246);
        ChemicalElement na = new ChemicalElement(11, "Na", new String[]{"Sodium", "Natrium"}, 22.990, 0.93, "[Ne] 3s^1", 98, 883, new int[]{1}, 0.93);
        ChemicalElement mg = new ChemicalElement(12, "Mg", new String[]{"Magnesium", "Magnesium"}, 24.305, 1.31, "[Ne] 3s^2", 650, 1091, new int[]{2}, 1.31);
        ChemicalElement al = new ChemicalElement(13, "Al", new String[]{"Aluminum", "Aluminium"}, 26.982, 1.61, "[Ne] 3s^2 3p^1", 660, 2470, new int[]{3}, 1.61);
        ChemicalElement si = new ChemicalElement(14, "Si", new String[]{"Silicon", "Silicium"}, 28.085, 1.90, "[Ne] 3s^2 3p^2", 1414, 3265, new int[]{4, -4}, 1.90);
        ChemicalElement p = new ChemicalElement(15, "P", new String[]{"Phosphorus", "Phosphor"}, 30.974, 2.19, "[Ne] 3s^2 3p^3", 44, 280, new int[]{5, 3, -3}, 2.19);
        ChemicalElement s = new ChemicalElement(16, "S", new String[]{"Sulfur", "Schwefel"}, 32.06, 2.58, "[Ne] 3s^2 3p^4", 115, 445, new int[]{-2, 2, 4, 6}, 2.58);
        ChemicalElement cl = new ChemicalElement(17, "Cl", new String[]{"Chlorine", "Chlor"}, 35.45, 3.16, "[Ne] 3s^2 3p^5", -101, -35, new int[]{-1, 1, 3, 5, 7}, 3.16);
        ChemicalElement ar = new ChemicalElement(18, "Ar", new String[]{"Argon", "Argon"}, 39.948, "[Ne] 3s^2 3p^6", -189, -186);
        ChemicalElement k = new ChemicalElement(19, "K", new String[]{"Potassium", "Kalium"}, 39.098, 0.82, "[Ar] 4s^1", 64, 774, new int[]{1}, 0.82);
        ChemicalElement ca = new ChemicalElement(20, "Ca", new String[]{"Calcium", "Calcium"}, 40.078, 1.00, "[Ar] 4s^2", 842, 1484, new int[]{2}, 1.00);
        ChemicalElement sc = new ChemicalElement(21, "Sc", new String[]{"Scandium", "Scandium"}, 44.956, 1.36, "[Ar] 3d^1 4s^2", 1541, 2836, new int[]{3}, 1.36);
        ChemicalElement ti = new ChemicalElement(22, "Ti", new String[]{"Titanium", "Titan"}, 47.867, 1.54, "[Ar] 3d^2 4s^2", 1668, 3287, new int[]{4, 3, 2}, 1.54);
        ChemicalElement v = new ChemicalElement(23, "V", new String[]{"Vanadium", "Vanadium"}, 50.942, 1.63, "[Ar] 3d^3 4s^2", 1910, 3407, new int[]{5, 4, 3, 2}, 1.63);
        ChemicalElement cr = new ChemicalElement(24, "Cr", new String[]{"Chromium", "Chrom"}, 51.996, 1.66, "[Ar] 3d^5 4s^1", 1907, 2671, new int[]{6, 3, 2, 0}, 1.66);
        ChemicalElement mn = new ChemicalElement(25, "Mn", new String[]{"Manganese", "Mangan"}, 54.938, 1.55, "[Ar] 3d^5 4s^2", 1246, 2061, new int[]{7, 4, 2}, 1.55);
        ChemicalElement fe = new ChemicalElement(26, "Fe", new String[]{"Iron", "Eisen"}, 55.845, 1.83, "[Ar] 3d^6 4s^2", 1538, 2862, new int[]{3, 2}, 1.83);
        ChemicalElement co = new ChemicalElement(27, "Co", new String[]{"Cobalt", "Cobalt"}, 58.933, 1.88, "[Ar] 3d^7 4s^2", 1495, 2927, new int[]{3, 2}, 1.88);
        ChemicalElement ni = new ChemicalElement(28, "Ni", new String[]{"Nickel", "Nickel"}, 58.693, 1.91, "[Ar] 3d^8 4s^2", 1455, 2730, new int[]{2, 3}, 1.91);
        ChemicalElement cu = new ChemicalElement(29, "Cu", new String[]{"Copper", "Kupfer"}, 63.546, 1.90, "[Ar] 3d^10 4s^1", 1085, 2562, new int[]{2, 1}, 1.90);
        ChemicalElement zn = new ChemicalElement(30, "Zn", new String[]{"Zinc", "Zink"}, 65.38, 1.65, "[Ar] 3d^10 4s^2", 419, 907, new int[]{2}, 1.65);
        ChemicalElement ga = new ChemicalElement(31, "Ga", new String[]{"Gallium", "Gallium"}, 69.723, 1.81, "[Ar] 3d^10 4s^2 4p^1", 30, 2400, new int[]{3}, 1.81);
        ChemicalElement ge = new ChemicalElement(32, "Ge", new String[]{"Germanium", "Germanium"}, 72.630, 2.01, "[Ar] 3d^10 4s^2 4p^2", 938, 2833, new int[]{4, 2}, 2.01);
        ChemicalElement as = new ChemicalElement(33, "As", new String[]{"Arsenic", "Arsen"}, 74.922, 2.18, "[Ar] 3d^10 4s^2 4p^3", 817, 614, new int[]{-3, 3, 5}, 2.18);
        ChemicalElement se = new ChemicalElement(34, "Se", new String[]{"Selenium", "Selen"}, 78.971, 2.55, "[Ar] 3d^10 4s^2 4p^4", 221, 685, new int[]{-2, 2, 4, 6}, 2.55);
        ChemicalElement br = new ChemicalElement(35, "Br", new String[]{"Bromine", "Brom"}, 79.904, 2.96, "[Ar] 3d^10 4s^2 4p^5", -7, 59, new int[]{-1, 1, 3, 5, 7}, 2.96);
        ChemicalElement kr = new ChemicalElement(36, "Kr", new String[]{"Krypton", "Krypton"}, 83.798, "[Ar] 3d^10 4s^2 4p^6", -157, -153);
        ChemicalElement rb = new ChemicalElement(37, "Rb", new String[]{"Rubidium", "Rubidium"}, 85.468, 0.82, "[Kr] 5s^1", 39, 688, new int[]{1}, 0.82);
        ChemicalElement sr = new ChemicalElement(38, "Sr", new String[]{"Strontium", "Strontium"}, 87.62, 0.95, "[Kr] 5s^2", 777, 1382, new int[]{2}, 0.95);
        ChemicalElement y = new ChemicalElement(39, "Y", new String[]{"Yttrium", "Yttrium"}, 88.906, 1.22, "[Kr] 4d^1 5s^2", 1526, 3345, new int[]{3}, 1.22);
        ChemicalElement zr = new ChemicalElement(40, "Zr", new String[]{"Zirconium", "Zirconium"}, 91.224, 1.33, "[Kr] 4d^2 5s^2", 1855, 4409, new int[]{4}, 1.33);
        ChemicalElement nb = new ChemicalElement(41, "Nb", new String[]{"Niobium", "Niob"}, 92.906, 1.6, "[Kr] 4d^4 5s^1", 2477, 4744, new int[]{5, 3}, 1.6);
        ChemicalElement mo = new ChemicalElement(42, "Mo", new String[]{"Molybdenum", "Molybdän"}, 95.95, 2.16, "[Kr] 4d^5 5s^1", 2623, 4639, new int[]{6, 4, 2}, 2.16);
        ChemicalElement tc = new ChemicalElement(43, "Tc", new String[]{"Technetium", "Technetium"}, 98, 1.9, "[Kr] 4d^5 5s^2", 2157, 4265, new int[]{7, 4}, 1.9);
        ChemicalElement ru = new ChemicalElement(44, "Ru", new String[]{"Ruthenium", "Ruthenium"}, 101.07, 2.2, "[Kr] 4d^7 5s^1", 2334, 4150, new int[]{8, 6, 4, 3, 2}, 2.2);
        ChemicalElement rh = new ChemicalElement(45, "Rh", new String[]{"Rhodium", "Rhodium"}, 102.91, 2.28, "[Kr] 4d^8 5s^1", 1964, 3695, new int[]{3}, 2.28);
        ChemicalElement pd = new ChemicalElement(46, "Pd", new String[]{"Palladium", "Palladium"}, 106.42, 2.20, "[Kr] 4d^10", 1555, 2963, new int[]{2, 4}, 2.20);
        ChemicalElement ag = new ChemicalElement(47, "Ag", new String[]{"Silver", "Silber"}, 107.87, 1.93, "[Kr] 4d^10 5s^1", 962, 2162, new int[]{1}, 1.93);
        ChemicalElement cd = new ChemicalElement(48, "Cd", new String[]{"Cadmium", "Cadmium"}, 112.41, 1.69, "[Kr] 4d^10 5s^2", 321, 767, new int[]{2}, 1.69);
        ChemicalElement in = new ChemicalElement(49, "In", new String[]{"Indium", "Indium"}, 114.82, 1.78, "[Kr] 4d^10 5s^2 5p^1", 157, 2072, new int[]{3}, 1.78);
        ChemicalElement sn = new ChemicalElement(50, "Sn", new String[]{"Tin", "Zinn"}, 118.71, 1.96, "[Kr] 4d^10 5s^2 5p^2", 232, 2602, new int[]{4, 2}, 1.96);
        ChemicalElement sb = new ChemicalElement(51, "Sb", new String[]{"Antimony", "Antimon"}, 121.76, 2.05, "[Kr] 4d^10 5s^2 5p^3", 630, 1587, new int[]{-3, 3, 5}, 2.05);
        ChemicalElement te = new ChemicalElement(52, "Te", new String[]{"Tellurium", "Tellur"}, 127.60, 2.1, "[Kr] 4d^10 5s^2 5p^4", 449, 988, new int[]{-2, 2, 4, 6}, 2.1);
        ChemicalElement i = new ChemicalElement(53, "I", new String[]{"Iodine", "Iod"}, 126.90, 2.66, "[Kr] 4d^10 5s^2 5p^5", 114, 184, new int[]{-1, 1, 3, 5, 7}, 2.66);
        ChemicalElement xe = new ChemicalElement(54, "Xe", new String[]{"Xenon", "Xenon"}, 131.29, "[Kr] 4d^10 5s^2 5p^6", -112, -108);
        ChemicalElement cs = new ChemicalElement(55, "Cs", new String[]{"Cesium", "Cäsium"}, 132.91, 0.79, "[Xe] 6s^1", 28, 671, new int[]{1}, 0.79);
        ChemicalElement ba = new ChemicalElement(56, "Ba", new String[]{"Barium", "Barium"}, 137.33, 0.89, "[Xe] 6s^2", 727, 1870, new int[]{2}, 0.89);
        ChemicalElement la = new ChemicalElement(57, "La", new String[]{"Lanthanum", "Lanthan"}, 138.91, 1.10, "[Xe] 5d^1 6s^2", 920, 3464, new int[]{3}, 1.10, true);
        ChemicalElement ce = new ChemicalElement(58, "Ce", new String[]{"Cerium", "Cer"}, 140.12, 1.12, "[Xe] 4f^1 5d^1 6s^2", 795, 3443, new int[]{3, 4}, 1.12, true);
        ChemicalElement pr = new ChemicalElement(59, "Pr", new String[]{"Praseodymium", "Praseodym"}, 140.91, 1.13, "[Xe] 4f^3 6s^2", 931, 3520, new int[]{3}, 1.13, true);
        ChemicalElement nd = new ChemicalElement(60, "Nd", new String[]{"Neodymium", "Neodym"}, 144.24, 1.14, "[Xe] 4f^4 6s^2", 1021, 3100, new int[]{3}, 1.14, true);
        ChemicalElement pm = new ChemicalElement(61, "Pm", new String[]{"Promethium", "Promethium"}, 145, 1.13, "[Xe] 4f^5 6s^2", 1042, 3000, new int[]{3}, 1.13, true);
        ChemicalElement sm = new ChemicalElement(62, "Sm", new String[]{"Samarium", "Samarium"}, 150.36, 1.17, "[Xe] 4f^6 6s^2", 1072, 1794, new int[]{3, 2}, 1.17, true);
        ChemicalElement eu = new ChemicalElement(63, "Eu", new String[]{"Europium", "Europium"}, 151.96, 1.2, "[Xe] 4f^7 6s^2", 822, 1529, new int[]{3, 2}, 1.2, true);
        ChemicalElement gd = new ChemicalElement(64, "Gd", new String[]{"Gadolinium", "Gadolinium"}, 157.25, 1.2, "[Xe] 4f^7 5d^1 6s^2", 1312, 3250, new int[]{3}, 1.2, true);
        ChemicalElement tb = new ChemicalElement(65, "Tb", new String[]{"Terbium", "Terbium"}, 158.93, 1.2, "[Xe] 4f^9 6s^2", 1356, 3230, new int[]{3}, 1.2, true);
        ChemicalElement dy = new ChemicalElement(66, "Dy", new String[]{"Dysprosium", "Dysprosium"}, 162.50, 1.22, "[Xe] 4f^10 6s^2", 1412, 2567, new int[]{3}, 1.22, true);
        ChemicalElement ho = new ChemicalElement(67, "Ho", new String[]{"Holmium", "Holmium"}, 164.93, 1.23, "[Xe] 4f^11 6s^2", 1474, 2700, new int[]{3}, 1.23, true);
        ChemicalElement er = new ChemicalElement(68, "Er", new String[]{"Erbium", "Erbium"}, 167.26, 1.24, "[Xe] 4f^12 6s^2", 1529, 2868, new int[]{3}, 1.24, true);
        ChemicalElement tm = new ChemicalElement(69, "Tm", new String[]{"Thulium", "Thulium"}, 168.93, 1.25, "[Xe] 4f^13 6s^2", 1545, 1950, new int[]{3}, 1.25, true);
        ChemicalElement yb = new ChemicalElement(70, "Yb", new String[]{"Ytterbium", "Ytterbium"}, 173.05, 1.1, "[Xe] 4f^14 6s^2", 824, 1196, new int[]{3, 2}, 1.1, true);
        ChemicalElement lu = new ChemicalElement(71, "Lu", new String[]{"Lutetium", "Lutetium"}, 174.97, 1.27, "[Xe] 4f^14 5d^1 6s^2", 1663, 3402, new int[]{3}, 1.27, true);
        ChemicalElement hf = new ChemicalElement(72, "Hf", new String[]{"Hafnium", "Hafnium"}, 178.49, 1.3, "[Xe] 4f^14 5d^2 6s^2", 2233, 4603, new int[]{4}, 1.3);
        ChemicalElement ta = new ChemicalElement(73, "Ta", new String[]{"Tantalum", "Tantal"}, 180.95, 1.5, "[Xe] 4f^14 5d^3 6s^2", 3017, 5458, new int[]{5}, 1.5);
        ChemicalElement w = new ChemicalElement(74, "W", new String[]{"Tungsten", "Wolfram"}, 183.84, 2.36, "[Xe] 4f^14 5d^4 6s^2", 3422, 5555, new int[]{6, 5, 4, 3, 2}, 2.36);
        ChemicalElement re = new ChemicalElement(75, "Re", new String[]{"Rhenium", "Rhenium"}, 186.21, 1.9, "[Xe] 4f^14 5d^5 6s^2", 3186, 5596, new int[]{7, 6, 4, 2}, 1.9);
        ChemicalElement os = new ChemicalElement(76, "Os", new String[]{"Osmium", "Osmium"}, 190.23, 2.2, "[Xe] 4f^14 5d^6 6s^2", 3033, 5012, new int[]{8, 6, 4, 3, 2}, 2.2);
        ChemicalElement ir = new ChemicalElement(77, "Ir", new String[]{"Iridium", "Iridium"}, 192.22, 2.2, "[Xe] 4f^14 5d^7 6s^2", 2466, 4428, new int[]{6, 4, 3}, 2.2);
        ChemicalElement pt = new ChemicalElement(78, "Pt", new String[]{"Platinum", "Platin"}, 195.08, 2.28, "[Xe] 4f^14 5d^9 6s^1", 1768, 3825, new int[]{4, 2}, 2.28);
        ChemicalElement au = new ChemicalElement(79, "Au", new String[]{"Gold", "Gold"}, 196.97, 2.54, "[Xe] 4f^14 5d^10 6s^1", 1064, 2856, new int[]{3, 1}, 2.54);
        ChemicalElement hg = new ChemicalElement(80, "Hg", new String[]{"Mercury", "Quecksilber"}, 200.59, 2.00, "[Xe] 4f^14 5d^10 6s^2", -39, 357, new int[]{2, 1}, 2.00);
        ChemicalElement tl = new ChemicalElement(81, "Tl", new String[]{"Thallium", "Thallium"}, 204.38, 1.62, "[Xe] 4f^14 5d^10 6s^2 6p^1", 304, 1473, new int[]{3, 1}, 1.62);
        ChemicalElement pb = new ChemicalElement(82, "Pb", new String[]{"Lead", "Blei"}, 207.2, 2.33, "[Xe] 4f^14 5d^10 6s^2 6p^2", 327, 1749, new int[]{4, 2}, 2.33);
        ChemicalElement bi = new ChemicalElement(83, "Bi", new String[]{"Bismuth", "Wismut"}, 208.98, 2.02, "[Xe] 4f^14 5d^10 6s^2 6p^3", 271, 1564, new int[]{5, 3}, 2.02);
        ChemicalElement po = new ChemicalElement(84, "Po", new String[]{"Polonium", "Polonium"}, 209, 2.00, "[Xe] 4f^14 5d^10 6s^2 6p^4", 254, 962, new int[]{6, 4, 2}, 2.00);
        ChemicalElement at = new ChemicalElement(85, "At", new String[]{"Astatine", "Astat"}, 210, 2.20, "[Xe] 4f^14 5d^10 6s^2 6p^5", 302, 337, new int[]{-1, 1, 3, 5, 7}, 2.20);
        ChemicalElement rn = new ChemicalElement(86, "Rn", new String[]{"Radon", "Radon"}, 222, "[Xe] 4f^14 5d^10 6s^2 6p^6", -71, -62);
        ChemicalElement fr = new ChemicalElement(87, "Fr", new String[]{"Francium", "Francium"}, 223, 0.79, "[Rn] 7s^1", 27, 677, new int[]{1}, 0.70);
        ChemicalElement ra = new ChemicalElement(88, "Ra", new String[]{"Radium", "Radium"}, 226, 0.90, "[Rn] 7s^2", 700, 1737, new int[]{2}, 0.90);
        ChemicalElement ac = new ChemicalElement(89, "Ac", new String[]{"Actinium", "Actinium"}, 227, 1.10, "[Rn] 6d^1 7s^2", 1050, 3200, new int[]{3}, 1.10, true);
        ChemicalElement th = new ChemicalElement(90, "Th", new String[]{"Thorium", "Thorium"}, 232.04, 1.30, "[Rn] 6d^2 7s^2", 1750, 4788, new int[]{4}, 1.30, true);
        ChemicalElement pa = new ChemicalElement(91, "Pa", new String[]{"Protactinium", "Protactinium"}, 231.04, 1.5, "[Rn] 5f^2 6d^1 7s^2", 1572, 4000, new int[]{5, 4}, 1.5, true);
        ChemicalElement u = new ChemicalElement(92, "U", new String[]{"Uranium", "Uran"}, 238.03, 1.38, "[Rn] 5f^3 6d^1 7s^2", 1135, 4131, new int[]{6, 5, 4, 3}, 1.38, true);
        ChemicalElement np = new ChemicalElement(93, "Np", new String[]{"Neptunium", "Neptunium"}, 237, 1.36, "[Rn] 5f^4 6d^1 7s^2", 644, 4000, new int[]{6, 5, 4, 3}, 1.36, true);
        ChemicalElement pu = new ChemicalElement(94, "Pu", new String[]{"Plutonium", "Plutonium"}, 244, 1.28, "[Rn] 5f^6 7s^2", 640, 3228, new int[]{6, 5, 4, 3}, 1.28, true);
        ChemicalElement am = new ChemicalElement(95, "Am", new String[]{"Americium", "Americium"}, 243, 1.3, "[Rn] 5f^7 7s^2", 1176, 2607, new int[]{6, 5, 4, 3}, 1.3, true);
        ChemicalElement cm = new ChemicalElement(96, "Cm", new String[]{"Curium", "Curium"}, 247, 1.3, "[Rn] 5f^7 6d^1 7s^2", 1340, 3110, new int[]{6, 5, 4, 3}, 1.3, true);
        ChemicalElement bk = new ChemicalElement(97, "Bk", new String[]{"Berkelium", "Berkelium"}, 247, 1.3, "[Rn] 5f^9 7s^2", 986, 2627, new int[]{4, 3}, 1.3, true);
        ChemicalElement cf = new ChemicalElement(98, "Cf", new String[]{"Californium", "Californium"}, 251, 1.3, "[Rn] 5f^10 7s^2", 900, 1472, new int[]{4, 3}, 1.3, true);
        ChemicalElement es = new ChemicalElement(99, "Es", new String[]{"Einsteinium", "Einsteinium"}, 252, 1.3, "[Rn] 5f^11 7s^2", 860, 996, new int[]{3}, 1.3, true);
        ChemicalElement fm = new ChemicalElement(100, "Fm", new String[]{"Fermium", "Fermium"}, 257, 1.3, "[Rn] 5f^12 7s^2", new int[]{3}, 1.3, true);
        ChemicalElement md = new ChemicalElement(101, "Md", new String[]{"Mendelevium", "Mendelevium"}, 258, 1.3, "[Rn] 5f^13 7s^2", 1100, 1100, new int[]{3}, 1.3, true);
        ChemicalElement no = new ChemicalElement(102, "No", new String[]{"Nobelium", "Nobelium"}, 259, 1.3, "[Rn] 5f^14 7s^2", 827, 1500, new int[]{3}, 1.3, true);
        ChemicalElement lr = new ChemicalElement(103, "Lr", new String[]{"Lawrencium", "Lawrencium"}, 262, 1.3, "[Rn] 5f^14 6d^1 7s^2", 1627, 3327, new int[]{3}, 1.3, true);
        ChemicalElement rf = new ChemicalElement(104, "Rf", new String[]{"Rutherfordium", "Rutherfordium"}, 267, "[Rn] 5f^14 6d^2 7s^2", 2410, 5800, new int[]{4}, 1.3);
        ChemicalElement db = new ChemicalElement(105, "Db", new String[]{"Dubnium", "Dubnium"}, 270, "[Rn] 5f^14 6d^3 7s^2", 2830, 5850, new int[]{5}, 1.3);
        ChemicalElement sg = new ChemicalElement(106, "Sg", new String[]{"Seaborgium", "Seaborgium"}, 271, "[Rn] 5f^14 6d^4 7s^2", 2900, 5860, new int[]{6}, 1.3);
        ChemicalElement bh = new ChemicalElement(107, "Bh", new String[]{"Bohrium", "Bohrium"}, 270, "[Rn] 5f^14 6d^5 7s^2", 2800, 5780, new int[]{7}, 1.3);
        ChemicalElement hs = new ChemicalElement(108, "Hs", new String[]{"Hassium", "Hassium"}, 277, "[Rn] 5f^14 6d^6 7s^2", 2870, 5800, new int[]{8}, 1.3);
        ChemicalElement mt = new ChemicalElement(109, "Mt", new String[]{"Meitnerium", "Meitnerium"}, 278, "[Rn] 5f^14 6d^7 7s^2", 2900, 5700, new int[]{9}, 1.3);
        ChemicalElement ds = new ChemicalElement(110, "Ds", new String[]{"Darmstadtium", "Darmstadtium"}, 281,  "[Rn] 5f^14 6d^8 7s^2", 2800, 5700, new int[]{10}, 1.3);
        ChemicalElement rg = new ChemicalElement(111, "Rg", new String[]{"Roentgenium", "Roentgenium"}, 280, "[Rn] 5f^14 6d^9 7s^2", 2800, 5700, new int[]{11}, 1.3);
        ChemicalElement cn = new ChemicalElement(112, "Cn", new String[]{"Copernicium", "Copernicium"}, 285, "[Rn] 5f^14 6d^10 7s^2", 2830, 5770, new int[]{12}, 1.3);
        ChemicalElement nh = new ChemicalElement(113, "Nh", new String[]{"Nihonium", "Nihonium"}, 284, "[Rn] 5f^14 6d^10 7s^2 7p^1", 2700, 4600, new int[]{3}, 1.3);
        ChemicalElement fl = new ChemicalElement(114, "Fl", new String[]{"Flerovium", "Flerovium"}, 289, "[Rn] 5f^14 6d^10 7s^2 7p^2", 2000, 4000, new int[]{2, 4}, 1.3);
        ChemicalElement mc = new ChemicalElement(115, "Mc", new String[]{"Moscovium", "Moscovium"}, 288, "[Rn] 5f^14 6d^10 7s^2 7p^3", 1500, 3000, new int[]{3}, 1.3);
        ChemicalElement lv = new ChemicalElement(116, "Lv", new String[]{"Livermorium", "Livermorium"}, 293, "[Rn] 5f^14 6d^10 7s^2 7p^4", 1300, 2800, new int[]{2}, 1.3);
        ChemicalElement ts = new ChemicalElement(117, "Ts", new String[]{"Tennessine", "Tennessine"}, 294, "[Rn] 5f^14 6d^10 7s^2 7p^5", 1200, 2500, new int[]{-1, 1, 3, 5, 7}, 1.3);
        ChemicalElement og = new ChemicalElement(118, "Og", new String[]{"Oganesson", "Oganesson"}, 294, "[Rn] 5f^14 6d^10 7s^2 7p^6", 123, 350, new int[]{2}, 1.3);

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
