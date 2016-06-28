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

public class CrystalTotoDVCalculatorPanel extends GSCDVCalculatorPanel {
    private static final long serialVersionUID = 7069756628960120967L;

    private WildPokeButtonGroup wildPidgeyGroup;
    private WildPokeButtonGroup wildSentretGroup;
    private WildPokeButtonGroup wildHoppipGroup;
    private WildPokeButtonGroup wildCaterpieGroup;
    private WildPokeButtonGroup wildRattataGroup;
    private WildPokeButtonGroup wildPoliwagGroup;

    private TrainerPokeButtonGroup rivalGroup;
    private TrainerPokeButtonGroup mikeyGroup;
    private TrainerPokeButtonGroup abeGroup;
    private TrainerPokeButtonGroup rodGroup;
    private TrainerPokeButtonGroup falknerGroup;
    private TrainerPokeButtonGroup gordonGroup;
    private TrainerPokeButtonGroup russellGroup;
    private TrainerPokeButtonGroup billGroup;
    private TrainerPokeButtonGroup anthonyGroup;
    private TrainerPokeButtonGroup gruntGroup;

    public CrystalTotoDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile) {
        super(parent, Game.CRYSTAL, totodile);
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
        JLabel labelTrainers = new JLabel("Trainers");
        labelTrainers.setBounds(498, 4, 150, 48);
        labelTrainers.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(labelTrainers);

        // RIVAL 1
        TrainerPokeButton rivalChikoritaL5 = new TrainerPokeButton(this, Species.CHIKORITA, 5);
        rivalGroup = new TrainerPokeButtonGroup(this, "RIVAL 1", rivalChikoritaL5);
        rivalGroup.initialize(501, 75);
        // MIKEY
        TrainerPokeButton mikeyPidgeyL2 = new TrainerPokeButton(this, Species.PIDGEY, 2);
        TrainerPokeButton mikeyRattataL4 = new TrainerPokeButton(this, Species.RATTATA, 4);
        mikeyGroup = new TrainerPokeButtonGroup(this, "MIKEY", mikeyPidgeyL2, mikeyRattataL4);
        mikeyGroup.initialize(501, 127);
        // ABE
        TrainerPokeButton abeSpearowL9 = new TrainerPokeButton(this, Species.SPEAROW, 9);
        abeGroup = new TrainerPokeButtonGroup(this, "ABE", abeSpearowL9);
        abeGroup.initialize(501, 179);
        // ROD
        TrainerPokeButton rodPidgeyL7_1 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        TrainerPokeButton rodPidgeyL7_2 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        rodGroup = new TrainerPokeButtonGroup(this, "ROD", rodPidgeyL7_1, rodPidgeyL7_2);
        rodGroup.initialize(501, 231);
        // FALKNER
        TrainerPokeButton falknerPidgeyL7 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        TrainerPokeButton falknerPidgeottoL9 = new TrainerPokeButton(this, Species.PIDGEOTTO, 9);
        falknerGroup = new TrainerPokeButtonGroup(this, "FALKNER", falknerPidgeyL7, falknerPidgeottoL9);
        falknerGroup.initialize(501, 283);
        // GORDON
        TrainerPokeButton gordonWooperL10 = new TrainerPokeButton(this, Species.WOOPER, 10);
        gordonGroup = new TrainerPokeButtonGroup(this, "GORDON", gordonWooperL10);
        gordonGroup.initialize(501, 335);
        // RUSSELL
        TrainerPokeButton russellGeodudeL4 = new TrainerPokeButton(this, Species.GEODUDE, 4);
        TrainerPokeButton russellGeodudeL6 = new TrainerPokeButton(this, Species.GEODUDE, 6);
        TrainerPokeButton russellGeodudeL8 = new TrainerPokeButton(this, Species.GEODUDE, 8);
        russellGroup =
                new TrainerPokeButtonGroup(this, "RUSSELL", russellGeodudeL4, russellGeodudeL6, russellGeodudeL8);
        russellGroup.initialize(501, 387);
        // BILL
        TrainerPokeButton billKoffingL6_1 = new TrainerPokeButton(this, Species.KOFFING, 6);
        TrainerPokeButton billKoffingL6_2 = new TrainerPokeButton(this, Species.KOFFING, 6);
        billGroup = new TrainerPokeButtonGroup(this, "BILL", billKoffingL6_1, billKoffingL6_2);
        billGroup.initialize(501, 439);
        // ANTHONY
        TrainerPokeButton anthonyGeodudeL11 = new TrainerPokeButton(this, Species.GEODUDE, 11);
        TrainerPokeButton anthonyMachopL11 = new TrainerPokeButton(this, Species.MACHOP, 11);
        anthonyGroup = new TrainerPokeButtonGroup(this, "ANTHONY", anthonyGeodudeL11, anthonyMachopL11);
        anthonyGroup.initialize(501, 491);
        // GRUNT
        TrainerPokeButton gruntRattataL9_1 = new TrainerPokeButton(this, Species.RATTATA, 9);
        TrainerPokeButton gruntRattataL9_2 = new TrainerPokeButton(this, Species.RATTATA, 9);
        gruntGroup = new TrainerPokeButtonGroup(this, "GRUNT", gruntRattataL9_1, gruntRattataL9_2);
        gruntGroup.initialize(501, 543);
    }

    @Override
    public void resetAction() {
        this.wildPidgeyGroup.reset();
        this.wildSentretGroup.reset();
        this.wildCaterpieGroup.reset();
        this.wildHoppipGroup.reset();
        this.wildRattataGroup.reset();
        this.wildPoliwagGroup.reset();
        this.rivalGroup.reset();
        this.mikeyGroup.reset();
        this.abeGroup.reset();
        this.rodGroup.reset();
        this.falknerGroup.reset();
        this.gordonGroup.reset();
        this.russellGroup.reset();
        this.billGroup.reset();
        this.anthonyGroup.reset();
        this.gruntGroup.reset();
    }
}