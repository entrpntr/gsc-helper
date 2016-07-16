package com.pokemonspeedruns.gschelper.ui.pokes.wild;

import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

public class WildPokePage extends JPanel {
    private static final long serialVersionUID = -8586793959023940646L;
    private GSCDVCalculatorPanel dvPanel;
    private ArrayList<WildPokeButtonGroup> wildPokeButtonGroups = new ArrayList<WildPokeButtonGroup>();

    public WildPokePage(GSCDVCalculatorPanel dvPanel) {
        super();
        this.setLayout(null);
        this.dvPanel = dvPanel;
    }

    public void add(WildPokeButtonGroup wildPokeGroup) {
        wildPokeButtonGroups.add(wildPokeGroup);
    }

    public boolean addAll(Collection<WildPokeButtonGroup> wildPokeGroups) {
        return wildPokeButtonGroups.addAll(wildPokeGroups);
    }

    public int numPokeGroups() {
        return wildPokeButtonGroups.size();
    }

    public void reset() {
        for(WildPokeButtonGroup pokeGroup : wildPokeButtonGroups) {
            pokeGroup.reset();
        }
    }

    public GSCDVCalculatorPanel getDVPanel() {
        return dvPanel;
    }
}
