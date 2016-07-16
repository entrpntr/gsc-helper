package com.pokemonspeedruns.gschelper.ui.dvs.impl;

import com.pokemonspeedruns.gschelper.model.Game;
import com.pokemonspeedruns.gschelper.model.PartyPokemon;
import com.pokemonspeedruns.gschelper.model.Species;
import com.pokemonspeedruns.gschelper.ui.HelperFrame;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.pokes.wild.WildPokeGroup;

public class SilverCyndaquilDVCalculatorPanel extends GSCDVCalculatorPanel {
    private static final long serialVersionUID = 4676900638647012572L;

    public SilverCyndaquilDVCalculatorPanel(HelperFrame parent, PartyPokemon cyndaquil) {
        super(parent, Game.SILVER, cyndaquil);
    }

    @Override
    public void initAction() {

        ////////////////
        // WILD POKES //
        ////////////////
        this.createWildPokePages(new WildPokeGroup[]{
                new WildPokeGroup(Species.BELLSPROUT, 6),
                new WildPokeGroup(Species.MAREEP, 6),
                new WildPokeGroup(Species.RATTATA, 4, 5, 6),
                new WildPokeGroup(Species.HOPPIP, 6),
                new WildPokeGroup(Species.EKANS, 4),
                new WildPokeGroup(Species.ZUBAT, 5, 6, 7)
        });

        //////////////
        // TRAINERS //
        //////////////
        this.createTrainerPages(
                new String[] {
                        "0x39A9E", "MIKEY", "DON", "NICO", "ABE", "ROD", "FALKNER", "ALBERT", "DANIEL", "RUSSELL"
                }
        );
    }
}

