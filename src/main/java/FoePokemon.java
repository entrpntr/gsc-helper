public class FoePokemon {
    private Species species;
    private int level;
    private FoeType foeType;

    public FoePokemon(Species species, int level, FoeType foeType) {
        this.species = species;
        this.level = level;
        this.foeType = foeType;
    }

    public Species getSpecies() {
        return species;
    }

    public int getLevel() {
        return level;
    }

    public FoeType getFoeType() {
        return foeType;
    }
}
