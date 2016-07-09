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

public class SilverCyndaquilDVCalculatorPanel extends GSCDVCalculatorPanel {
    private static final long serialVersionUID = 4676900638647012572L;

    private WildPokeButtonGroup wildBellsproutGroup;
    private WildPokeButtonGroup wildMareepGroup;
    private WildPokeButtonGroup wildRattataGroup;
    private WildPokeButtonGroup wildZubatGroup;
    private WildPokeButtonGroup wildHoppipGroup;
    private WildPokeButtonGroup wildEkansGroup;

    public SilverCyndaquilDVCalculatorPanel(HelperFrame parent, PartyPokemon cyndaquil) {
        super(parent, Game.SILVER, cyndaquil);
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
        wildBellsproutGroup = new WildPokeButtonGroup(this, Species.BELLSPROUT, 6);
        wildBellsproutGroup.initialize(53, 503);
        // SENTRET
        wildMareepGroup = new WildPokeButtonGroup(this, Species.MAREEP, 6);
        wildMareepGroup.initialize(53, 549);
        // RATTATA
        wildRattataGroup = new WildPokeButtonGroup(this, Species.RATTATA, 4, 5, 6);
        wildRattataGroup.initialize(235, 503);
        // CATERPIE
        wildZubatGroup = new WildPokeButtonGroup(this, Species.ZUBAT, 5, 6, 7);
        wildZubatGroup.initialize(235, 549);
        // HOPPIP
        wildHoppipGroup = new WildPokeButtonGroup(this, Species.HOPPIP, 6);
        wildHoppipGroup.initialize(361, 503);
        // EKANS
        wildEkansGroup = new WildPokeButtonGroup(this, Species.EKANS, 4);
        wildEkansGroup.initialize(361, 549);

        //////////////
        // TRAINERS //
        //////////////
        createTrainerPages(new String[] {"0x39A9E", "MIKEY", "DON", "NICO", "ABE", "ROD", "FALKNER", "ALBERT", "DANIEL", "RUSSELL"});
    }

    @Override
    public void resetAction() {
        this.wildBellsproutGroup.reset();
        this.wildMareepGroup.reset();
        this.wildRattataGroup.reset();
        this.wildZubatGroup.reset();
        this.wildHoppipGroup.reset();
        this.wildEkansGroup.reset();
    }
}

