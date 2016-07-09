package com.pokemonspeedruns.gschelper.ui.dvs.impl;

import com.pokemonspeedruns.gschelper.GSCHelper;
import com.pokemonspeedruns.gschelper.model.*;
import com.pokemonspeedruns.gschelper.ui.HelperFrame;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.pokes.trainer.*;
import com.pokemonspeedruns.gschelper.ui.pokes.wild.WildPokeButtonGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CrystalTotoDVCalculatorPanel extends GSCDVCalculatorPanel {
    Cursor handCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    Cursor defaultCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);

    private static final long serialVersionUID = 7069756628960120967L;

    private WildPokeButtonGroup wildPidgeyGroup;
    private WildPokeButtonGroup wildSentretGroup;
    private WildPokeButtonGroup wildHoppipGroup;
    private WildPokeButtonGroup wildCaterpieGroup;
    private WildPokeButtonGroup wildRattataGroup;
    private WildPokeButtonGroup wildPoliwagGroup;

    private TrainerPokePageGroup trainerPage;
    private JLabel trainerBack;
    private JLabel trainerForward;

    private PreviousPageListener previousPageListener;
    private NextPageListener nextPageListener;

    public CrystalTotoDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile) {
        super(parent, Game.CRYSTAL, totodile);
    }

    private void createTrainerGroup(TrainerPokePage pokePage, Trainer trainer, int labelY) {
        TrainerPokeButtonGroup2 group = new TrainerPokeButtonGroup2(pokePage, trainer);
        pokePage.add(group);
        group.initialize(labelY);
    }

    private void createTrainerPages() {
        int idx = -1;
        TrainerPokePage currPage = null;
        String[] trainers = {"0x39AEF", "MIKEY", "ABE", "ROD", "FALKNER", "GORDON", "RUSSELL", "BILL", "ANTHONY", "0x3A791" }; // "0x3BA06"
        for(int i=0; i<trainers.length; i++) {
            String trainerName = trainers[i];
            Trainer trainer = Trainer.getTrainer(getGame(), trainerName);
            if(idx == -1 || idx == 10 || (idx == 9 && trainer.getPartySize() > 3)) {
                idx = 0;
                TrainerPokePage newPage = new TrainerPokePage(this);
                trainerPage.addPage(newPage);
                currPage = newPage;
            }
            createTrainerGroup(currPage, trainer, idx*TrainerPokeButton2.VERTICAL_SPACING + 13);
            idx += (1 + (trainer.getPartySize()-1)/3);
        }
        trainerPage.showFirst();
        this.add(trainerPage);
    }

    @Override
    public void initAction() {
        ////////////////
        // WILD POKES //
        ////////////////
/*
        JLabel wildBack = new JLabel("<");
        wildBack.setBounds(122, 457, 42, 42);
        wildBack.setFont(new Font(GSCHelper.FONT, Font.BOLD, 22));
        this.add(wildBack);
        wildBack.setVisible(false);
*/
        JLabel labelWild = new JLabel("Wild Pokes");
        labelWild.setBounds(155, 457, 190, 42);
        labelWild.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(labelWild);
/*
        JLabel wildForward = new JLabel(">");
        wildForward.setBounds(326, 457, 42, 42);
        wildForward.setFont(new Font(GSCHelper.FONT, Font.BOLD, 22));
        this.add(wildForward);
*/
        // PIDGEY
        wildPidgeyGroup = new WildPokeButtonGroup(this, Species.PIDGEY, 2, 3, 4);
        wildPidgeyGroup.initialize(102, 503);
        // SENTRET
        wildSentretGroup = new WildPokeButtonGroup(this, Species.SENTRET, 2, 3);
        wildSentretGroup.initializeWithOffset(102, 549, 4);
        // HOPPIP
        wildHoppipGroup = new WildPokeButtonGroup(this, Species.HOPPIP, 3, 4);
        wildHoppipGroup.initialize(249, 503);
        // CATERPIE
        wildCaterpieGroup = new WildPokeButtonGroup(this, Species.CATERPIE, 3, 4);
        wildCaterpieGroup.initialize(249, 549);
        // RATTATA
        wildRattataGroup = new WildPokeButtonGroup(this, Species.RATTATA, 2);
        wildRattataGroup.initialize(368, 503);
        // POLIWAG
        wildPoliwagGroup = new WildPokeButtonGroup(this, Species.POLIWAG, 4);
        wildPoliwagGroup.initialize(368, 549);

        //////////////
        // TRAINERS //
        //////////////
        trainerPage = new TrainerPokePageGroup(this);
        previousPageListener = new PreviousPageListener(trainerPage);
        nextPageListener = new NextPageListener(trainerPage);

        trainerBack = new JLabel("<", SwingConstants.CENTER);
        trainerBack.setBounds(489, 13, 30, 30);
        trainerBack.setFont(new Font(GSCHelper.FONT, Font.BOLD, 22));
        this.add(trainerBack);
        trainerBack.addMouseListener(previousPageListener);
        JLabel labelTrainers = new JLabel("Trainers");
        labelTrainers.setBounds(530, 4, 150, 48);
        labelTrainers.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(labelTrainers);
        trainerForward = new JLabel(">", SwingConstants.CENTER);
        trainerForward.setBounds(652, 13, 30, 30);
        trainerForward.setFont(new Font(GSCHelper.FONT, Font.BOLD, 22));
        this.add(trainerForward);
        createTrainerPages();
    }

    public void toggleForward(boolean isEnabled) {
        trainerForward.setEnabled(isEnabled);
        if(isEnabled && trainerForward.getMouseListeners().length == 0) {
            trainerForward.addMouseListener(nextPageListener);
        } else if(!isEnabled) {
            trainerForward.setForeground(Color.BLACK);
            trainerForward.removeMouseListener(nextPageListener);
            setCursor(defaultCursor);
        }
    }

    public void toggleBack(boolean isEnabled) {
        trainerBack.setEnabled(isEnabled);
        if(isEnabled && trainerBack.getMouseListeners().length == 0) {
            trainerBack.addMouseListener(previousPageListener);
        } else if(!isEnabled) {
            trainerBack.setForeground(Color.BLACK);
            trainerBack.removeMouseListener(previousPageListener);
            setCursor(defaultCursor);
        }
    }

    @Override
    public void resetAction() {
        this.wildPidgeyGroup.reset();
        this.wildSentretGroup.reset();
        this.wildCaterpieGroup.reset();
        this.wildHoppipGroup.reset();
        this.wildRattataGroup.reset();
        this.wildPoliwagGroup.reset();
        trainerPage.reset();
    }

    private class PreviousPageListener extends MouseAdapter {
        TrainerPokePageGroup trainerPageGroup;

        PreviousPageListener(TrainerPokePageGroup trainerPageGroup) {
            this.trainerPageGroup = trainerPageGroup;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            trainerPageGroup.back();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setCursor(handCursor);
            trainerBack.setForeground(Color.GREEN);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setCursor(defaultCursor);
            trainerBack.setForeground(Color.BLACK);
        }
    }

    private class NextPageListener extends MouseAdapter {
        TrainerPokePageGroup trainerPageGroup;

        NextPageListener(TrainerPokePageGroup trainerPageGroup) {
            this.trainerPageGroup = trainerPageGroup;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            trainerPageGroup.forward();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            setCursor(handCursor);
            trainerForward.setForeground(Color.GREEN);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setCursor(defaultCursor);
            trainerForward.setForeground(Color.BLACK);
        }
    }
}