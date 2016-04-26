package com.pokemonspeedruns.gschelper.ui.pokes;

import com.pokemonspeedruns.gschelper.model.FoePokemon;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoePokemonActionListener implements ActionListener {
    private GSCDVCalculatorPanel dvPanel;
    private FoePokemonEventCallback callback;
    private FoePokemon foe;

    public FoePokemonActionListener(GSCDVCalculatorPanel dvPanel, FoePokemon foe, FoePokemonEventCallback callback) {
        this.dvPanel = dvPanel;
        this.callback = callback;
        this.foe = foe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean gainedLevel = dvPanel.getStarter().rekt(foe);
        if (gainedLevel) {
            dvPanel.updateStats();
        }
        callback.foeGotRekt();
    }
}
