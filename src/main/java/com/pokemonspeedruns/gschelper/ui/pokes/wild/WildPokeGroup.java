package com.pokemonspeedruns.gschelper.ui.pokes.wild;

import com.pokemonspeedruns.gschelper.model.Species;

public class WildPokeGroup {
    private Species species;
    private Integer[] levels;

    public WildPokeGroup(Species species, Integer... levels) {
        this.species = species;
        this.levels = levels;
    }

    public Species getSpecies() {
        return species;
    }

    public Integer[] getLevels() {
        return levels;
    }
}
