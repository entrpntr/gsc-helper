package com.pokemonspeedruns.gschelper.ui.pokes.trainer;

import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TrainerPokePageGroup extends JPanel {
    private static final long serialVersionUID = 3316576179698424442L;
    private int currentPage = 0;
    private ArrayList<TrainerPokePage> trainerPokePages = new ArrayList<TrainerPokePage>();
    private GSCDVCalculatorPanel dvPanel;

    public TrainerPokePageGroup(GSCDVCalculatorPanel dvPanel) {
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
        dvPanel.toggleTrainerForward(true);
        currentPage--;
        if(currentPage == 0) {
            dvPanel.toggleTrainerBack(false);
        }
    }

    public void forward() {
        CardLayout cards = (CardLayout) this.getLayout();
        cards.next(this);
        dvPanel.toggleTrainerBack(true);
        currentPage++;
        if(currentPage == trainerPokePages.size() - 1) {
            dvPanel.toggleTrainerForward(false);
        }
    }

    public void showFirst() {
        ((CardLayout) this.getLayout()).first(this);
        currentPage = 0;
        dvPanel.toggleTrainerBack(false);
        if(trainerPokePages.size() < 2) {
            dvPanel.toggleTrainerForward(false);
        } else {
            dvPanel.toggleTrainerForward(true);
        }
    }

    public void reset() {
        for(TrainerPokePage page : trainerPokePages) {
            page.reset();
        }
        showFirst();
    }
}
