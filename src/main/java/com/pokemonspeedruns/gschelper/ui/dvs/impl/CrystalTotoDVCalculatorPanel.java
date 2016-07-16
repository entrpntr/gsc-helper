package com.pokemonspeedruns.gschelper.ui.dvs.impl;

import com.pokemonspeedruns.gschelper.model.*;
import com.pokemonspeedruns.gschelper.ui.HelperFrame;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.pokes.wild.WildPokeGroup;

public class CrystalTotoDVCalculatorPanel extends GSCDVCalculatorPanel {

    private static final long serialVersionUID = 7069756628960120967L;

    public CrystalTotoDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile) {
        super(parent, Game.CRYSTAL, totodile);
    }

    @Override
    public void initAction() {

        ////////////////
        // WILD POKES //
        ////////////////
        this.createWildPokePages(new WildPokeGroup[]{
                new WildPokeGroup(Species.PIDGEY, 2, 3, 4),
                new WildPokeGroup(Species.HOPPIP, 3, 4),
                new WildPokeGroup(Species.RATTATA, 2),
                new WildPokeGroup(Species.SENTRET, 2, 3),
                new WildPokeGroup(Species.CATERPIE, 3, 4),
                new WildPokeGroup(Species.POLIWAG, 4),
                new WildPokeGroup(Species.HOOTHOOT, 3, 4, 5),
                new WildPokeGroup(Species.ZUBAT, 3, 4)
        });

        //////////////
        // TRAINERS //
        //////////////
        this.createTrainerPages(
                new String[] {
                        "0x39AEF", "MIKEY", "ABE", "ROD", "FALKNER", "GORDON", "RUSSELL", "BILL", "ANTHONY", "0x3A791"
                }
        ); // "0x3BA06")
    }
}