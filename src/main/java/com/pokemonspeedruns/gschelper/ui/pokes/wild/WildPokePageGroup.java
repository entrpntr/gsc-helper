package com.pokemonspeedruns.gschelper.ui.pokes.wild;

import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WildPokePageGroup extends JPanel {
    private static final long serialVersionUID = -6381633606154783714L;
    private int currentPage = 0;
    private ArrayList<WildPokePage> wildPokePages = new ArrayList<WildPokePage>();
    private GSCDVCalculatorPanel dvPanel;

    public WildPokePageGroup(GSCDVCalculatorPanel dvPanel) {
        super(new CardLayout());
        this.setBounds(0, 507, 448, 90);
        this.dvPanel = dvPanel;
    }

    public void addPage(WildPokePage page) {
        this.add(page);
        wildPokePages.add(page);
    }

    public void back() {
        CardLayout cards = (CardLayout) this.getLayout();
        cards.previous(this);
        dvPanel.togglePokeForward(true);
        currentPage--;
        if(currentPage == 0) {
            dvPanel.togglePokeBack(false);
        }
    }

    public void forward() {
        CardLayout cards = (CardLayout) this.getLayout();
        cards.next(this);
        dvPanel.togglePokeBack(true);
        currentPage++;
        if(currentPage == wildPokePages.size() - 1) {
            dvPanel.togglePokeForward(false);
        }
    }

    public void showFirst() {
        ((CardLayout) this.getLayout()).first(this);
        currentPage = 0;
        dvPanel.togglePokeBack(false);
        if(wildPokePages.size() < 2) {
            dvPanel.togglePokeForward(false);
        } else {
            dvPanel.togglePokeForward(true);
        }
    }

    public void reset() {
        for(WildPokePage page : wildPokePages) {
            page.reset();
        }
        showFirst();
    }
}
