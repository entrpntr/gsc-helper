package com.pokemonspeedruns.gschelper.ui.dvs.impl;

import com.pokemonspeedruns.gschelper.model.Game;
import com.pokemonspeedruns.gschelper.model.PartyPokemon;
import com.pokemonspeedruns.gschelper.model.Species;
import com.pokemonspeedruns.gschelper.ui.HelperFrame;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.pokes.wild.WildPokeGroup;

public class GoldTotoDVCalculatorPanel extends GSCDVCalculatorPanel {
    private static final long serialVersionUID = 4676900638647012572L;

    public GoldTotoDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile) {
        super(parent, Game.GOLD, totodile);
    }

    @Override
    public void initAction() {

        ////////////////
        // WILD POKES //
        ////////////////
        this.createWildPokePages(new WildPokeGroup[]{
                new WildPokeGroup(Species.PIDGEY, 2, 3, 4),
                new WildPokeGroup(Species.SENTRET, 2, 3),
                new WildPokeGroup(Species.RATTATA, 4),
                new WildPokeGroup(Species.CATERPIE, 3, 4),
                new WildPokeGroup(Species.HOPPIP, 6)
        });

        //////////////
        // TRAINERS //
        //////////////
        this.createTrainerPages(
                new String[] {
                        "0x39A92", "MIKEY", "DON", "ABE", "ROD", "FALKNER", "ALBERT", "RALPH", "DANIEL", "RUSSELL"
                }
        );
    }
}