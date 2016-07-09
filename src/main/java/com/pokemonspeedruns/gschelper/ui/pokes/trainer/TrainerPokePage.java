package com.pokemonspeedruns.gschelper.ui.pokes.trainer;

import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;

import javax.swing.*;
import java.util.ArrayList;

public class TrainerPokePage extends JPanel {
    private GSCDVCalculatorPanel dvPanel;
    private ArrayList<TrainerPokeButtonGroup2> trainerPokeButtonGroups = new ArrayList<TrainerPokeButtonGroup2>();
    public TrainerPokePage(GSCDVCalculatorPanel dvPanel) {
        super();
        this.setLayout(null);
        this.dvPanel = dvPanel;
    }

    public void add(TrainerPokeButtonGroup2 trainerPokeGroup) {
        trainerPokeButtonGroups.add(trainerPokeGroup);
    }

    public void reset() {
        for(TrainerPokeButtonGroup2 pokeGroup : trainerPokeButtonGroups) {
            pokeGroup.reset();
        }
    }
    public GSCDVCalculatorPanel getDVPanel() {
        return dvPanel;
    }
}
