public class FoePokemon {
    private PokemonSpecies species;
    private int level;
	private FoeType foeType;
	public FoePokemon(PokemonSpecies species, int level, FoeType foeType) {
		this.species = species;
        this.level = level;
		this.foeType = foeType;
	}

    public PokemonSpecies getSpecies() {
        return species;
    }

    public int getLevel() {
        return level;
    }

    public FoeType getFoeType() {
        return foeType;
    }
}
