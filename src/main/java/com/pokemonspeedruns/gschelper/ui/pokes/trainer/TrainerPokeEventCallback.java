package com.pokemonspeedruns.gschelper.ui.pokes.trainer;

import com.pokemonspeedruns.gschelper.ui.pokes.FoePokemonEventCallback;

import javax.swing.*;

public class TrainerPokeEventCallback implements FoePokemonEventCallback {
    JButton pokeButton;

    public TrainerPokeEventCallback(JButton pokeButton) {
        this.pokeButton = pokeButton;
    }

    @Override
    public void foeGotRekt() {
        pokeButton.setEnabled(false);
    }
}
