package com.pokemonspeedruns.gschelper.ui.dvs.impl;

import com.pokemonspeedruns.gschelper.GSCHelper;
import com.pokemonspeedruns.gschelper.model.Game;
import com.pokemonspeedruns.gschelper.model.PartyPokemon;
import com.pokemonspeedruns.gschelper.model.Species;
import com.pokemonspeedruns.gschelper.ui.HelperFrame;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.pokes.wild.WildPokeButtonGroup;

import javax.swing.*;
import java.awt.*;

public class GoldTotoDVCalculatorPanel extends GSCDVCalculatorPanel {
    private static final long serialVersionUID = 4676900638647012572L;

    private WildPokeButtonGroup wildPidgeyGroup;
    private WildPokeButtonGroup wildSentretGroup;
    private WildPokeButtonGroup wildRattataGroup;
    private WildPokeButtonGroup wildCaterpieGroup;
    private WildPokeButtonGroup wildHoppipGroup;

    public GoldTotoDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile) {
        super(parent, Game.GOLD, totodile);
    }

    @Override
    public void initAction() {
        ////////////////
        // WILD POKES //
        ////////////////
        JLabel labelWild = new JLabel("Wild Pokes");
        labelWild.setBounds(155, 457, 190, 42);
        labelWild.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(labelWild);

        // PIDGEY
        wildPidgeyGroup = new WildPokeButtonGroup(this, Species.PIDGEY, 2, 3, 4);
        wildPidgeyGroup.initialize(102, 503);
        // SENTRET
        wildSentretGroup = new WildPokeButtonGroup(this, Species.SENTRET, 2, 3);
        wildSentretGroup.initializeWithOffset(102, 549, 4);
        // RATTATA
        wildRattataGroup = new WildPokeButtonGroup(this, Species.RATTATA, 4);
        wildRattataGroup.initialize(249, 503);
        // CATERPIE
        wildCaterpieGroup = new WildPokeButtonGroup(this, Species.CATERPIE, 3, 4);
        wildCaterpieGroup.initialize(249, 549);
        // HOPPIP
        wildHoppipGroup = new WildPokeButtonGroup(this, Species.HOPPIP, 6);
        wildHoppipGroup.initialize(368, 503);

        //////////////
        // TRAINERS //
        //////////////
        createTrainerPages(new String[] {"0x39A92", "MIKEY", "DON", "ABE", "ROD", "FALKNER", "ALBERT", "RALPH", "DANIEL", "RUSSELL"});
    }

    @Override
    public void resetAction() {
        this.wildPidgeyGroup.reset();
        this.wildSentretGroup.reset();
        this.wildRattataGroup.reset();
        this.wildCaterpieGroup.reset();
        this.wildHoppipGroup.reset();
    }
}