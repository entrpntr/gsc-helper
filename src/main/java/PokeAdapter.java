public abstract class PokeAdapter {
    FoePokemon poke;
    public PokeAdapter(FoePokemon poke) {
        this.poke = poke;
    }
    abstract void gotRekt();
    public FoePokemon getPoke() {
        return poke;
    }
}
