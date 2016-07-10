package com.pokemonspeedruns.gschelper.model;

import java.util.ArrayList;
import java.util.Arrays;

public class EvolutionFamily extends ArrayList<Species> {
    public EvolutionFamily(Species... speciesList) {
        super(Arrays.asList(speciesList));
    }

    public int numStages() {
        return this.size();
    }
}
