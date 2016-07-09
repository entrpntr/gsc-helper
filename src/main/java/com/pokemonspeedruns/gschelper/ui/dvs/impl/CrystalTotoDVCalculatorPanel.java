package com.pokemonspeedruns.gschelper.ui.dvs.impl;

import com.pokemonspeedruns.gschelper.GSCHelper;
import com.pokemonspeedruns.gschelper.model.*;
import com.pokemonspeedruns.gschelper.ui.HelperFrame;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.pokes.wild.WildPokeButtonGroup;

import javax.swing.*;
import java.awt.*;

public class CrystalTotoDVCalculatorPanel extends GSCDVCalculatorPanel {

    private static final long serialVersionUID = 7069756628960120967L;

    private WildPokeButtonGroup wildPidgeyGroup;
    private WildPokeButtonGroup wildSentretGroup;
    private WildPokeButtonGroup wildHoppipGroup;
    private WildPokeButtonGroup wildCaterpieGroup;
    private WildPokeButtonGroup wildRattataGroup;
    private WildPokeButtonGroup wildPoliwagGroup;



    public CrystalTotoDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile) {
        super(parent, Game.CRYSTAL, totodile);
    }

    @Override
    public void initAction() {
        ////////////////
        // WILD POKES //
        ////////////////
/*
        JLabel wildBack = new JLabel("<");
        wildBack.setBounds(122, 457, 42, 42);
        wildBack.setFont(new Font(GSCHelper.FONT, Font.BOLD, 22));
        this.add(wildBack);
        wildBack.setVisible(false);
*/
        JLabel labelWild = new JLabel("Wild Pokes");
        labelWild.setBounds(155, 457, 190, 42);
        labelWild.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(labelWild);
/*
        JLabel wildForward = new JLabel(">");
        wildForward.setBounds(326, 457, 42, 42);
        wildForward.setFont(new Font(GSCHelper.FONT, Font.BOLD, 22));
        this.add(wildForward);
*/
        // PIDGEY
        wildPidgeyGroup = new WildPokeButtonGroup(this, Species.PIDGEY, 2, 3, 4);
        wildPidgeyGroup.initialize(102, 503);
        // SENTRET
        wildSentretGroup = new WildPokeButtonGroup(this, Species.SENTRET, 2, 3);
        wildSentretGroup.initializeWithOffset(102, 549, 4);
        // HOPPIP
        wildHoppipGroup = new WildPokeButtonGroup(this, Species.HOPPIP, 3, 4);
        wildHoppipGroup.initialize(249, 503);
        // CATERPIE
        wildCaterpieGroup = new WildPokeButtonGroup(this, Species.CATERPIE, 3, 4);
        wildCaterpieGroup.initialize(249, 549);
        // RATTATA
        wildRattataGroup = new WildPokeButtonGroup(this, Species.RATTATA, 2);
        wildRattataGroup.initialize(368, 503);
        // POLIWAG
        wildPoliwagGroup = new WildPokeButtonGroup(this, Species.POLIWAG, 4);
        wildPoliwagGroup.initialize(368, 549);

        //////////////
        // TRAINERS //
        //////////////
        createTrainerPages(new String[] {"0x39AEF", "MIKEY", "ABE", "ROD", "FALKNER", "GORDON", "RUSSELL", "BILL", "ANTHONY", "0x3A791" }); // "0x3BA06")
    }

    @Override
    public void resetAction() {
        this.wildPidgeyGroup.reset();
        this.wildSentretGroup.reset();
        this.wildCaterpieGroup.reset();
        this.wildHoppipGroup.reset();
        this.wildRattataGroup.reset();
        this.wildPoliwagGroup.reset();
    }


}