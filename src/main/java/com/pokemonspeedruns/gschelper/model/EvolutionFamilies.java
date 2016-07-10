package com.pokemonspeedruns.gschelper.model;

import java.util.LinkedHashMap;

public class EvolutionFamilies extends LinkedHashMap<Species, EvolutionFamily> {
    public EvolutionFamilies() {
        super();
    }

    public void addFamily(Species... speciesList) {
        this.put(speciesList[speciesList.length-1], new EvolutionFamily(speciesList));
    }

    public EvolutionFamily getFamily(Species species) {
        return get(species);
    }
}
