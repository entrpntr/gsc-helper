package com.pokemonspeedruns.gschelper.ui.dvs.impl;

import com.pokemonspeedruns.gschelper.GSCHelper;
import com.pokemonspeedruns.gschelper.model.Game;
import com.pokemonspeedruns.gschelper.model.PartyPokemon;
import com.pokemonspeedruns.gschelper.model.Species;
import com.pokemonspeedruns.gschelper.ui.HelperFrame;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.pokes.trainer.TrainerPokeButton;
import com.pokemonspeedruns.gschelper.ui.pokes.trainer.TrainerPokeButtonGroup;
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

    private TrainerPokeButtonGroup rivalGroup;
    private TrainerPokeButtonGroup mikeyGroup;
    private TrainerPokeButtonGroup donGroup;
    private TrainerPokeButtonGroup nicoGroup;
    private TrainerPokeButtonGroup abeGroup;
    private TrainerPokeButtonGroup rodGroup;
    private TrainerPokeButtonGroup falknerGroup;
    private TrainerPokeButtonGroup albertGroup;
    private TrainerPokeButtonGroup danielGroup;
    private TrainerPokeButtonGroup russellGroup;

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
        JLabel labelTrainers = new JLabel("Trainers");
        labelTrainers.setBounds(498, 4, 150, 48);
        labelTrainers.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(labelTrainers);

        // RIVAL 1
        TrainerPokeButton rivalTotodileL5 = new TrainerPokeButton(this, Species.TOTODILE, 5);
        rivalGroup = new TrainerPokeButtonGroup(this, "RIVAL 1", rivalTotodileL5);
        rivalGroup.initialize(501, 75);
        // MIKEY
        TrainerPokeButton mikeyPidgeyL2 = new TrainerPokeButton(this, Species.PIDGEY, 2);
        TrainerPokeButton mikeyRattataL4 = new TrainerPokeButton(this, Species.RATTATA, 4);
        mikeyGroup = new TrainerPokeButtonGroup(this, "MIKEY", mikeyPidgeyL2, mikeyRattataL4);
        mikeyGroup.initialize(501, 127);
        // DON
        TrainerPokeButton donCaterpieL3_1 = new TrainerPokeButton(this, Species.CATERPIE, 3);
        TrainerPokeButton donCaterpieL3_2 = new TrainerPokeButton(this, Species.CATERPIE, 3);
        donGroup = new TrainerPokeButtonGroup(this, "DON", donCaterpieL3_1, donCaterpieL3_2);
        donGroup.initialize(501, 179);
        // NICO
        TrainerPokeButton nicoBellsproutL3_1 = new TrainerPokeButton(this, Species.BELLSPROUT, 3);
        TrainerPokeButton nicoBellsproutL3_2 = new TrainerPokeButton(this, Species.BELLSPROUT, 3);
        TrainerPokeButton nicoBellsproutL3_3 = new TrainerPokeButton(this, Species.BELLSPROUT, 3);
        nicoGroup = new TrainerPokeButtonGroup(this, "NICO", nicoBellsproutL3_1, nicoBellsproutL3_2, nicoBellsproutL3_3);
        nicoGroup.initialize(501, 231);
        // ABE
        TrainerPokeButton abeSpearowL9 = new TrainerPokeButton(this, Species.SPEAROW, 9);
        abeGroup = new TrainerPokeButtonGroup(this, "ABE", abeSpearowL9);
        abeGroup.initialize(501, 283);
        // ROD
        TrainerPokeButton rodPidgeyL7_1 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        TrainerPokeButton rodPidgeyL7_2 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        rodGroup = new TrainerPokeButtonGroup(this, "ROD", rodPidgeyL7_1, rodPidgeyL7_2);
        rodGroup.initialize(501, 335);
        // FALKNER
        TrainerPokeButton falknerPidgeyL7 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        TrainerPokeButton falknerPidgeottoL9 = new TrainerPokeButton(this, Species.PIDGEOTTO, 9);
        falknerGroup = new TrainerPokeButtonGroup(this, "FALKNER", falknerPidgeyL7, falknerPidgeottoL9);
        falknerGroup.initialize(501, 387);
        // ALBERT
        TrainerPokeButton albertRattataL6 = new TrainerPokeButton(this, Species.RATTATA, 6);
        TrainerPokeButton albertZubatL8 = new TrainerPokeButton(this, Species.ZUBAT, 8);
        albertGroup = new TrainerPokeButtonGroup(this, "ALBERT", albertRattataL6, albertZubatL8);
        albertGroup.initialize(501, 439);
        // DANIEL
        TrainerPokeButton danielOnixL11 = new TrainerPokeButton(this, Species.ONIX, 11);
        danielGroup = new TrainerPokeButtonGroup(this, "DANIEL", danielOnixL11);
        danielGroup.initialize(501, 491);
        // RUSSELL
        TrainerPokeButton russellGeodudeL4 = new TrainerPokeButton(this, Species.GEODUDE, 4);
        TrainerPokeButton russellGeodudeL6 = new TrainerPokeButton(this, Species.GEODUDE, 6);
        TrainerPokeButton russellGeodudeL8 = new TrainerPokeButton(this, Species.GEODUDE, 8);
        russellGroup =
                new TrainerPokeButtonGroup(this, "RUSSELL", russellGeodudeL4, russellGeodudeL6, russellGeodudeL8);
        russellGroup.initialize(501, 543);
    }

    @Override
    public void resetAction() {
        this.wildBellsproutGroup.reset();
        this.wildMareepGroup.reset();
        this.wildRattataGroup.reset();
        this.wildZubatGroup.reset();
        this.wildHoppipGroup.reset();
        rivalGroup.reset();
        mikeyGroup.reset();
        donGroup.reset();
        nicoGroup.reset();
        abeGroup.reset();
        rodGroup.reset();
        falknerGroup.reset();
        albertGroup.reset();
        danielGroup.reset();
        russellGroup.reset();
    }
}

