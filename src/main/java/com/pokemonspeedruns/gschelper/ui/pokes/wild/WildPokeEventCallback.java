package com.pokemonspeedruns.gschelper.ui.pokes.wild;

import com.pokemonspeedruns.gschelper.ui.pokes.FoePokemonEventCallback;

import javax.swing.*;

public class WildPokeEventCallback implements FoePokemonEventCallback {
    JLabel amountLabel;

    public WildPokeEventCallback(JLabel amountLabel) {
        this.amountLabel = amountLabel;
    }

    @Override
    public void foeGotRekt() {
        int amount = Integer.parseInt(amountLabel.getText().substring(1));
        amountLabel.setText("×" + ++amount);
    }
}
