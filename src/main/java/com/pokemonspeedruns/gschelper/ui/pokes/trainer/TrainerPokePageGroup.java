package com.pokemonspeedruns.gschelper.ui.pokes.trainer;

import com.pokemonspeedruns.gschelper.ui.dvs.impl.CrystalTotoDVCalculatorPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrainerPokePageGroup extends JPanel {
    private int currentPage = 0;
    private ArrayList<TrainerPokePage> trainerPokePages = new ArrayList<TrainerPokePage>();
    private CrystalTotoDVCalculatorPanel dvPanel;

    public TrainerPokePageGroup(CrystalTotoDVCalculatorPanel dvPanel) {
        super(new CardLayout());
        this.setBounds(501, 62, 299, 517);
        this.dvPanel = dvPanel;
    }

    public void addPage(TrainerPokePage page) {
        this.add(page);
        trainerPokePages.add(page);
    }

    public void back() {
        CardLayout cards = (CardLayout) this.getLayout();
        cards.previous(this);
        dvPanel.toggleForward(true);
        currentPage--;
        if(currentPage == 0) {
            dvPanel.toggleBack(false);
        }
    }

    public void forward() {
        CardLayout cards = (CardLayout) this.getLayout();
        cards.next(this);
        dvPanel.toggleBack(true);
        currentPage++;
        if(currentPage == trainerPokePages.size() - 1) {
            dvPanel.toggleForward(false);
        }
    }

    public void showFirst() {
        ((CardLayout) this.getLayout()).first(this);
        currentPage = 0;
        dvPanel.toggleBack(false);
        if(trainerPokePages.size() < 2) {
            dvPanel.toggleForward(false);
        } else {
            dvPanel.toggleForward(true);
        }
    }

    public void reset() {
        for(TrainerPokePage page : trainerPokePages) {
            page.reset();
        }
        showFirst();
    }
}
