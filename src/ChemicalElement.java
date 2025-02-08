package src;

public class ChemicalElement {
    private final int atomicNumber;
    private final String symbol;
    private final String[] names;
    private final double atomicWeight;
    private final double electronegativity;
    private final String electronConfig;
    private final int meltingPoint;
    private final int boilingPoint;
    private final int[] oxidationNums;
    private final double standardElectrodePotential;

    public ChemicalElement(int num, String letter, String[] elementNames, double weight, double negativity, String eConfig, int melt, int boil, int[] oxidation, double electrodePotential){
        this.atomicNumber = num;
        this.symbol = letter;
        this.names = elementNames;
        this.atomicWeight = weight;
        this.electronegativity = negativity;
        this.electronConfig = eConfig;
        this.meltingPoint = melt;
        this.boilingPoint = boil;
        this.oxidationNums =oxidation;
        this.standardElectrodePotential = electrodePotential;
    }
}