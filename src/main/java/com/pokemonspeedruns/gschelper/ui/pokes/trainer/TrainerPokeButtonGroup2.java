package com.pokemonspeedruns.gschelper.ui.pokes.trainer;

import com.pokemonspeedruns.gschelper.GSCHelper;
import com.pokemonspeedruns.gschelper.model.FoePokemon;
import com.pokemonspeedruns.gschelper.model.Trainer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TrainerPokeButtonGroup2 {
    public static final int LABEL_WIDTH = 124;
    public static final int LABEL_HEIGHT = 24;
    public static final Font TRAINER_FONT = new Font(GSCHelper.FONT, Font.BOLD, 11);

    private TrainerPokePage trainerPage;
    private JLabel trainerLabel;
//    private TrainerPokeButton2[] pokeButtons;
    private TrainerPokeButton2[] trainerPokeButtons;
    public TrainerPokeButtonGroup2(TrainerPokePage trainerPage, Trainer trainer) {
        this.trainerPage = trainerPage;
        this.trainerLabel = new JLabel(trainer.getPrettyName());
        this.trainerLabel.setFont(TRAINER_FONT);
        this.trainerPokeButtons = new TrainerPokeButton2[trainer.getPartySize()];
        for(int i=0; i<trainer.getPartySize(); i++) {
            FoePokemon poke = trainer.getPoke(i);
            trainerPokeButtons[i] = new TrainerPokeButton2(trainerPage.getDVPanel(), poke.getSpecies(), poke.getLevel());
        }
    }

    public void initialize(int labelY) {
        int numPokes = trainerPokeButtons.length;
        int adjLabelY = (numPokes > 3) ? labelY + 26 : labelY;
        this.trainerLabel.setBounds(0, adjLabelY, LABEL_WIDTH, LABEL_HEIGHT);
        this.trainerPage.add(this.trainerLabel);
        int baseButtonX = 65;
        int buttonY = labelY - 13;
        for(int i=0; i<numPokes; i++) {
            this.trainerPokeButtons[i].initialize(trainerPage, baseButtonX + (i%3)*TrainerPokeButton2.WIDTH, buttonY + (i/3)*(TrainerPokeButton2.VERTICAL_SPACING));
            this.trainerPage.add(this.trainerPokeButtons[i]);
        }
    }

    public void reset() {
        for(TrainerPokeButton2 btn : this.trainerPokeButtons) {
            btn.setEnabled(true);
        }
    }
}
