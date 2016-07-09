package com.pokemonspeedruns.gschelper.ui.pokes.trainer;

import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;

import javax.swing.*;
import java.util.ArrayList;

public class TrainerPokePage extends JPanel {
    private GSCDVCalculatorPanel dvPanel;
    private ArrayList<TrainerPokeButtonGroup> trainerPokeButtonGroups = new ArrayList<TrainerPokeButtonGroup>();
    public TrainerPokePage(GSCDVCalculatorPanel dvPanel) {
        super();
        this.setLayout(null);
        this.dvPanel = dvPanel;
    }

    public void add(TrainerPokeButtonGroup trainerPokeGroup) {
        trainerPokeButtonGroups.add(trainerPokeGroup);
    }

    public void reset() {
        for(TrainerPokeButtonGroup pokeGroup : trainerPokeButtonGroups) {
            pokeGroup.reset();
        }
    }
    public GSCDVCalculatorPanel getDVPanel() {
        return dvPanel;
    }
}
