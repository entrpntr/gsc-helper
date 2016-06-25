package com.pokemonspeedruns.gschelper.ui.dvs;

import com.pokemonspeedruns.gschelper.GSCHelper;
import com.pokemonspeedruns.gschelper.model.Game;
import com.pokemonspeedruns.gschelper.model.PartyPokemon;
import com.pokemonspeedruns.gschelper.ui.HelperFrame;
import com.pokemonspeedruns.gschelper.ui.stats.DVColumn;
import com.pokemonspeedruns.gschelper.ui.stats.StatButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class GSCDVCalculatorPanel extends JPanel {
    private static final long serialVersionUID = -4646462442805989745L;
    private static final Font DV_LABEL_FONT = new Font(GSCHelper.FONT, Font.BOLD, 19);

    private PartyPokemon starter;
    private Game game;
    private HelperFrame parent;
    private JLabel labelTotoLevel;
    private boolean[] redHP = new boolean[16];
    private boolean[] redAtk = new boolean[16];
    private boolean[] redDef = new boolean[16];
    private boolean[] redSpd = new boolean[16];
    private boolean[] redSpc = new boolean[16];
    private ArrayList<StatButton> hpStats;
    private ArrayList<StatButton> atkStats;
    private ArrayList<StatButton> defStats;
    private ArrayList<StatButton> spdStats;
    private ArrayList<StatButton> spcStats;

    private int hpdv;
    private int atkdv;
    private int defdv;
    private int spddv;
    private int spcdv;

    private JLabel labelHPDV;
    private JLabel labelAtkDV;
    private JLabel labelDefDV;
    private JLabel labelSpdDV;
    private JLabel labelSpcDV;

    private JPanel totodile;
    private JPanel totodileDVSPanel;

    private JLabel labelTitle;

    private JLabel labelHP;
    private JLabel labelAtk;
    private JLabel labelDef;
    private JLabel labelSpd;
    private JLabel labelSpc;

    public GSCDVCalculatorPanel(HelperFrame parent, Game game, PartyPokemon starter) {
        this.parent = parent;
        this.game = game;
        this.starter = starter;
        this.hpdv = -1;
        this.atkdv = -1;
        this.defdv = -1;
        this.spddv = -1;
        this.spcdv = -1;
        this.setLayout(null);
        this.setBounds(0, 0, 792, 594);
        this.setBackground(null);
        this.init();
        this.initStatButtons();
        this.updateStats();
    }

    public abstract void initAction();

    public abstract void resetAction();

    public PartyPokemon getStarter() {
        return starter;
    }

    public void init() {
        initTotodile();
        initMainPanel();
        initAction();
    }

    private void initTotodile() {
        this.totodile = new JPanel();
        this.totodile.setBackground(this.parent.getTotoBackgroundColor());
        this.totodile.setBounds(0, 612, this.parent.getTotoWidth(), this.parent.getTotoHeight());
        this.totodile.setLayout(new BorderLayout());
        this.totodile.setBorder(new EmptyBorder(5, 5, 0, 5));
        this.labelTitle = new JLabel(this.parent.getTotoTitleText(), SwingConstants.CENTER);
        this.labelTitle.setFont(new Font(this.parent.getTotoTitleFont(), this.parent.getTotoTitleFontExtra(), this.parent.getTotoTitleFontSize()));
        this.totodile.add(this.labelTitle, "North");
        this.totodileDVSPanel = new JPanel();
        this.totodileDVSPanel.setBackground(this.parent.getTotoBackgroundColor());
        this.totodileDVSPanel.setLayout(new GridLayout(2, 3));
        this.totodileDVSPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
        this.labelHP = new JLabel("HP", SwingConstants.CENTER);

        Font columnHeadersFont =
                new Font(this.parent.getTotoColumnHeadersFont(), this.parent.getTotoColumnHeadersFontExtra(), this.parent.getTotoColumnHeadersFontSize());
        this.labelHP.setFont(columnHeadersFont);
        this.totodileDVSPanel.add(this.labelHP);
        this.labelAtk = new JLabel("ATK", SwingConstants.CENTER);
        this.labelAtk.setFont(columnHeadersFont);
        this.totodileDVSPanel.add(this.labelAtk);
        this.labelDef = new JLabel("DEF", SwingConstants.CENTER);
        this.labelDef.setFont(columnHeadersFont);
        this.totodileDVSPanel.add(this.labelDef);
        this.labelSpd = new JLabel("SPD", SwingConstants.CENTER);
        this.labelSpd.setFont(columnHeadersFont);
        this.totodileDVSPanel.add(this.labelSpd);
        this.labelSpc = new JLabel("SPC", SwingConstants.CENTER);
        this.labelSpc.setFont(columnHeadersFont);
        this.totodileDVSPanel.add(this.labelSpc);

        Font dvNumbersFont =
                new Font(this.parent.getTotoDVNumbersFont(), this.parent.getTotoDVNumbersFontExtra(), this.parent.getTotoDVNumbersFontSizeBig());
        this.labelHPDV = new JLabel("?", SwingConstants.CENTER);
        this.labelHPDV.setFont(dvNumbersFont);
        this.totodileDVSPanel.add(this.labelHPDV);
        this.labelAtkDV = new JLabel("?", SwingConstants.CENTER);
        this.labelAtkDV.setFont(dvNumbersFont);
        this.totodileDVSPanel.add(this.labelAtkDV);
        this.labelDefDV = new JLabel("?", SwingConstants.CENTER);
        this.labelDefDV.setFont(dvNumbersFont);
        this.totodileDVSPanel.add(this.labelDefDV);
        this.labelSpdDV = new JLabel("?", SwingConstants.CENTER);
        this.labelSpdDV.setFont(dvNumbersFont);
        this.totodileDVSPanel.add(this.labelSpdDV);
        this.labelSpcDV = new JLabel("?", SwingConstants.CENTER);
        this.labelSpcDV.setFont(dvNumbersFont);
        this.totodileDVSPanel.add(this.labelSpcDV);
        this.totodile.add(this.totodileDVSPanel, "Center");
        this.parent.getMainPanel().add(this.totodile);
    }

    private void initMainPanel() {
        for (int i = 0; i < 16; ++i) {
            this.redHP[i] = false;
            this.redAtk[i] = false;
            this.redDef[i] = false;
            this.redSpd[i] = false;
            this.redSpc[i] = false;
        }
        JLabel labelHP = new JLabel("HP");
        labelHP.setBounds(14, 51, 70, 50);
        labelHP.setFont(DV_LABEL_FONT);
        labelHP.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelHP);
        JLabel labelAtk = new JLabel("Atk");
        labelAtk.setBounds(104, 51, 70, 50);
        labelAtk.setFont(DV_LABEL_FONT);
        labelAtk.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelAtk);
        JLabel labelDef = new JLabel("Def");
        labelDef.setBounds(194, 51, 70, 50);
        labelDef.setFont(DV_LABEL_FONT);
        labelDef.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelDef);
        JLabel labelSpd = new JLabel("Spd");
        labelSpd.setBounds(374, 51, 70, 50);
        labelSpd.setFont(DV_LABEL_FONT);
        labelSpd.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelSpd);
        JLabel labelSpc = new JLabel("Spc");
        labelSpc.setBounds(284, 51, 70, 50);
        labelSpc.setFont(DV_LABEL_FONT);
        labelSpc.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelSpc);
        JLabel labelTotoIcon = new JLabel(
                new ImageIcon(
                        getClass().getClassLoader().getResource(starter.getSpecies().getBackspriteFilename(game))));
        labelTotoIcon.setBounds(134, 4, 48, 48);
        this.add(labelTotoIcon);
        this.labelTotoLevel = new JLabel("Level: " + starter.getLevel());
        this.labelTotoLevel.setBounds(196, 4, 150, 48);
        this.labelTotoLevel.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(this.labelTotoLevel);
    }

    public void removeStat(int column, int index) {
        if (column == 0) {
            this.hpStats.get(index).setPossible(false);
            this.hpStats.get(index).getButton().setVisible(false);
            this.hpStats.get(index).getLabel().setVisible(false);
        } else if (column == 1) {
            this.atkStats.get(index).setPossible(false);
            this.atkStats.get(index).getButton().setVisible(false);
            this.atkStats.get(index).getLabel().setVisible(false);
        } else if (column == 2) {
            this.defStats.get(index).setPossible(false);
            this.defStats.get(index).getButton().setVisible(false);
            this.defStats.get(index).getLabel().setVisible(false);
        } else if (column == 3) {
            this.spdStats.get(index).setPossible(false);
            this.spdStats.get(index).getButton().setVisible(false);
            this.spdStats.get(index).getLabel().setVisible(false);
        } else if (column == 4) {
            this.spcStats.get(index).setPossible(false);
            this.spcStats.get(index).getButton().setVisible(false);
            this.spcStats.get(index).getLabel().setVisible(false);
        }
    }

    public void initStatButtons() {
        double extraStats;
        int i;
        StatButton stat;
        double statValue;
        this.hpStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getHpStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getHpStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseHP() + i + 50) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 10.0);
            stat = new StatButton(this, DVColumn.HP, i, (int) statValue, 30, 11 + i * 22);
            this.hpStats.add(stat);
            this.add(stat.getLabel());
            this.add(stat.getButton());
        }
        this.atkStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getAtkStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getAtkStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseAtk() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            stat = new StatButton(this, DVColumn.ATK, i, (int) statValue, 120, 11 + i * 22);
            this.atkStats.add(stat);
            this.add(stat.getLabel());
            this.add(stat.getButton());
        }
        this.defStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getDefStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getDefStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseDef() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            stat = new StatButton(this, DVColumn.DEF, i, (int) statValue, 210, 11 + i * 22);
            this.defStats.add(stat);
            this.add(stat.getLabel());
            this.add(stat.getButton());
        }
        this.spdStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getSpdStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getSpdStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseSpe() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            stat = new StatButton(this, DVColumn.SPD, i, (int) statValue, 390, 11 + i * 22);
            this.spdStats.add(stat);
            this.add(stat.getLabel());
            this.add(stat.getButton());
        }
        this.spcStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getSpcStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getSpcStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseSpA() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            double spcDefValue =
                    Math.floor(
                            ((double) ((starter.getBaseSpD() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            stat =
                    new StatButton(
                            this, DVColumn.SPC, i, (int) statValue * (int) spcDefValue, 300, 11 + i * 22);
            this.spcStats.add(stat);
            this.add(stat.getLabel());
            this.add(stat.getButton());
        }
    }

    public void reset() {
        resetStats();
        resetAction();
    }

    public Game getGame() {
        return game;
    }

    public void resetStats() {
        int i;
        this.hpdv = -1;
        this.atkdv = -1;
        this.defdv = -1;
        this.spddv = -1;
        this.spcdv = -1;
        starter.reset();
        Font dvNumbersFont =
                new Font(this.parent.getTotoDVNumbersFont(), this.parent.getTotoDVNumbersFontExtra(), this.parent.getTotoDVNumbersFontSizeBig());
        this.labelHPDV.setText("?");
        this.labelHPDV.setFont(dvNumbersFont);
        this.labelAtkDV.setText("?");
        this.labelAtkDV.setFont(dvNumbersFont);
        this.labelDefDV.setText("?");
        this.labelDefDV.setFont(dvNumbersFont);
        this.labelSpdDV.setText("?");
        this.labelSpdDV.setFont(dvNumbersFont);
        this.labelSpcDV.setText("?");
        this.labelSpcDV.setFont(dvNumbersFont);
        for (i = 0; i < 16; ++i) {
            this.hpStats.get(i).setPossible(true);
            this.hpStats.get(i).getLabel().setVisible(true);
            this.hpStats.get(i).getButton().setVisible(true);
            this.atkStats.get(i).setPossible(true);
            this.atkStats.get(i).getLabel().setVisible(true);
            this.atkStats.get(i).getButton().setVisible(true);
            this.defStats.get(i).setPossible(true);
            this.defStats.get(i).getLabel().setVisible(true);
            this.defStats.get(i).getButton().setVisible(true);
            this.spdStats.get(i).setPossible(true);
            this.spdStats.get(i).getLabel().setVisible(true);
            this.spdStats.get(i).getButton().setVisible(true);
            this.spcStats.get(i).setPossible(true);
            this.spcStats.get(i).getLabel().setVisible(true);
            this.spcStats.get(i).getButton().setVisible(true);
        }
        for (i = 0; i < 16; ++i) {
            this.redHP[i] = false;
            this.redAtk[i] = false;
            this.redDef[i] = false;
            this.redSpd[i] = false;
            this.redSpc[i] = false;
        }
        this.updateStats();
    }

    public void updateStats() {
        double extraStats;
        int i;
        double statValue;
        this.labelTotoLevel.setText("Level: " + starter.getLevel());

        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getHpStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getHpStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseHP() + i + 50) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 10.0);
            this.hpStats.get(i).getButton().setText("" + (int) statValue);
            this.hpStats.get(i).setValue((int) statValue);
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getAtkStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getAtkStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseAtk() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            this.atkStats.get(i).getButton().setText("" + (int) statValue);
            this.atkStats.get(i).setValue((int) statValue);
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getDefStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getDefStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseDef() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            this.defStats.get(i).getButton().setText("" + (int) statValue);
            this.defStats.get(i).setValue((int) statValue);
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getSpdStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getSpdStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseSpe() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            this.spdStats.get(i).getButton().setText("" + (int) statValue);
            this.spdStats.get(i).setValue((int) statValue);
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getSpcStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getSpcStatExp() - 1) + 1.0) / 4.0);
            }
            statValue =
                    Math.floor(
                            ((double) ((starter.getBaseSpA() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            double spcDefValue =
                    Math.floor(
                            ((double) ((starter.getBaseSpD() + i) * 2) + extraStats)
                                    * (double) starter.getLevel()
                                    / 100.0
                                    + 5.0);
            this.spcStats.get(i).getButton().setText("" + (int) statValue + "/" + (int) spcDefValue);
            this.spcStats.get(i).setValue((int) statValue * (int) spcDefValue);
        }
    }

    public HelperFrame getHelperFrame() {
        return parent;
    }

    public void updateButtons(DVColumn column, int value) {
        StatButton stat;
        int i;
        if (column == DVColumn.ATK) {
            for (i = 0; i < 16; ++i) {
                stat = this.atkStats.get(i);
                if (!stat.isPossible() || value == stat.getValue()) continue;
                this.redAtk[i] = true;
                stat.setPossible(false);
                stat.getLabel().setVisible(false);
                stat.getButton().setVisible(false);
            }
            if (!this.hasEven(this.atkStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i] = true;
                    stat = this.hpStats.get(i);
                    stat.setPossible(false);
                    stat.getLabel().setVisible(false);
                    stat.getButton().setVisible(false);
                }
            }
            if (!this.hasOdd(this.atkStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i + 8] = true;
                    stat = this.hpStats.get(i + 8);
                    stat.setPossible(false);
                    stat.getLabel().setVisible(false);
                    stat.getButton().setVisible(false);
                }
            }
        }
        if (column == DVColumn.DEF) {
            for (i = 0; i < 16; ++i) {
                stat = this.defStats.get(i);
                if (!stat.isPossible() || value == stat.getValue()) continue;
                this.redDef[i] = true;
                stat.setPossible(false);
                stat.getLabel().setVisible(false);
                stat.getButton().setVisible(false);
            }
            if (!this.hasEven(this.defStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i / 4 * 8 + i % 4] = true;
                    stat = this.hpStats.get(i / 4 * 8 + i % 4);
                    stat.setPossible(false);
                    stat.getLabel().setVisible(false);
                    stat.getButton().setVisible(false);
                }
            }
            if (!this.hasOdd(this.defStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i / 4 * 8 + i % 4 + 4] = true;
                    stat = this.hpStats.get(i / 4 * 8 + i % 4 + 4);
                    stat.setPossible(false);
                    stat.getLabel().setVisible(false);
                    stat.getButton().setVisible(false);
                }
            }
        }
        if (column == DVColumn.SPD) {
            for (i = 0; i < 16; ++i) {
                stat = this.spdStats.get(i);
                if (!stat.isPossible() || value == stat.getValue()) continue;
                this.redSpd[i] = true;
                stat.setPossible(false);
                stat.getLabel().setVisible(false);
                stat.getButton().setVisible(false);
            }
            if (!this.hasEven(this.spdStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i / 2 * 4 + i % 2] = true;
                    stat = this.hpStats.get(i / 2 * 4 + i % 2);
                    stat.setPossible(false);
                    stat.getLabel().setVisible(false);
                    stat.getButton().setVisible(false);
                }
            }
            if (!this.hasOdd(this.spdStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i / 2 * 4 + i % 2 + 2] = true;
                    stat = this.hpStats.get(i / 2 * 4 + i % 2 + 2);
                    stat.setPossible(false);
                    stat.getLabel().setVisible(false);
                    stat.getButton().setVisible(false);
                }
            }
        }
        if (column == DVColumn.SPC) {
            for (i = 0; i < 16; ++i) {
                stat = this.spcStats.get(i);
                if (!stat.isPossible() || value == stat.getValue()) continue;
                this.redSpc[i] = true;
                stat.setPossible(false);
                stat.getLabel().setVisible(false);
                stat.getButton().setVisible(false);
            }
            if (!this.hasEven(this.spcStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i * 2] = true;
                    stat = this.hpStats.get(i * 2);
                    stat.setPossible(false);
                    stat.getLabel().setVisible(false);
                    stat.getButton().setVisible(false);
                }
            }
            if (!this.hasOdd(this.spcStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i * 2 + 1] = true;
                    stat = this.hpStats.get(i * 2 + 1);
                    stat.setPossible(false);
                    stat.getLabel().setVisible(false);
                    stat.getButton().setVisible(false);
                }
            }
        }
        if (column == DVColumn.HP) {
            StatButton stat2;
            int i2;
            boolean removeEvenAtk = true;
            boolean removeOddAtk = true;
            boolean removeEvenDef = true;
            boolean removeOddDef = true;
            boolean removeEvenSpd = true;
            boolean removeOddSpd = true;
            boolean removeEvenSpc = true;
            boolean removeOddSpc = true;
            for (i2 = 0; i2 < 16; ++i2) {
                stat2 = this.hpStats.get(i2);
                if (!stat2.isPossible()) continue;
                if (value != stat2.getValue()) {
                    this.redHP[i2] = true;
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                    continue;
                }
                if (i2 < 8) {
                    removeEvenAtk = false;
                } else {
                    removeOddAtk = false;
                }
                if (i2 % 8 < 4) {
                    removeEvenDef = false;
                } else {
                    removeOddDef = false;
                }
                if (i2 % 4 < 2) {
                    removeEvenSpd = false;
                } else {
                    removeOddSpd = false;
                }
                if (i2 % 2 < 1) {
                    removeEvenSpc = false;
                    continue;
                }
                removeOddSpc = false;
            }
            if (removeEvenAtk) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redAtk[i2 * 2] = true;
                    stat2 = this.atkStats.get(i2 * 2);
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                }
            }
            if (removeOddAtk) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redAtk[i2 * 2 + 1] = true;
                    stat2 = this.atkStats.get(i2 * 2 + 1);
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                }
            }
            if (removeEvenDef) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redDef[i2 * 2] = true;
                    stat2 = this.defStats.get(i2 * 2);
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                }
            }
            if (removeOddDef) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redDef[i2 * 2 + 1] = true;
                    stat2 = this.defStats.get(i2 * 2 + 1);
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                }
            }
            if (removeEvenSpd) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redSpd[i2 * 2] = true;
                    stat2 = this.spdStats.get(i2 * 2);
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                }
            }
            if (removeOddSpd) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redSpd[i2 * 2 + 1] = true;
                    stat2 = this.spdStats.get(i2 * 2 + 1);
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                }
            }
            if (removeEvenSpc) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redSpc[i2 * 2] = true;
                    stat2 = this.spcStats.get(i2 * 2);
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                }
            }
            if (removeOddSpc) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redSpc[i2 * 2 + 1] = true;
                    stat2 = this.spcStats.get(i2 * 2 + 1);
                    stat2.setPossible(false);
                    stat2.getLabel().setVisible(false);
                    stat2.getButton().setVisible(false);
                }
            }
        }
        this.updateDVPanel(this.redHP, this.redAtk, this.redDef, this.redSpd, this.redSpc);
    }

    public void updateDVPanel(
            boolean[] redHP, boolean[] redAtk, boolean[] redDef, boolean[] redSpd, boolean[] redSpc) {
        this.externalRed(redHP, redAtk, redDef, redSpd, redSpc);
    }

    public void externalRed(
            boolean[] redHP, boolean[] redAtk, boolean[] redDef, boolean[] redSpd, boolean[] redSpc) {
        for (int i = 0; i < 16; ++i) {
            if (redHP[i]) {
                this.redHP[i] = redHP[i];
            }
            if (redAtk[i]) {
                this.redAtk[i] = redAtk[i];
            }
            if (redDef[i]) {
                this.redDef[i] = redDef[i];
            }
            if (redSpd[i]) {
                this.redSpd[i] = redSpd[i];
            }
            if (!redSpc[i]) continue;
            this.redSpc[i] = redSpc[i];
        }
        while (this.removeByRanges()) {
            // empty while loop
        }
        this.setOnlyDV();
        this.updateLabels();
    }

    private boolean removeByRanges() {
        boolean success = false;
        boolean[] hpPossible = new boolean[16];
        boolean[] atkPossible = new boolean[16];
        boolean[] defPossible = new boolean[16];
        boolean[] spdPossible = new boolean[16];
        boolean[] spcPossible = new boolean[16];
        if (this.hpdv == -1) {
            Arrays.fill(hpPossible, true);
        } else {
            Arrays.fill(hpPossible, false);
            hpPossible[this.hpdv] = true;
        }
        if (this.atkdv == -1) {
            Arrays.fill(atkPossible, true);
        } else {
            Arrays.fill(atkPossible, false);
            atkPossible[this.atkdv] = true;
        }
        if (this.defdv == -1) {
            Arrays.fill(defPossible, true);
        } else {
            Arrays.fill(defPossible, false);
            defPossible[this.defdv] = true;
        }
        if (this.spddv == -1) {
            Arrays.fill(spdPossible, true);
        } else {
            Arrays.fill(spdPossible, false);
            spdPossible[this.spddv] = true;
        }
        if (this.spcdv == -1) {
            Arrays.fill(spcPossible, true);
        } else {
            Arrays.fill(spcPossible, false);
            spcPossible[this.spcdv] = true;
        }
        for (int i = 0; i < 16; ++i) {
            if (this.redHP[i]) {
                hpPossible[i] = false;
            }
            if (this.redAtk[i]) {
                atkPossible[i] = false;
            }
            if (this.redDef[i]) {
                defPossible[i] = false;
            }
            if (this.redSpd[i]) {
                spdPossible[i] = false;
            }
            if (this.redSpc[i]) {
                spcPossible[i] = false;
            }
        }
        boolean[] newHPRed = new boolean[16];
        boolean[] newAtkRed = new boolean[16];
        boolean[] newDefRed = new boolean[16];
        boolean[] newSpdRed = new boolean[16];
        boolean[] newSpcRed = new boolean[16];
        Arrays.fill(newHPRed, false);
        Arrays.fill(newAtkRed, false);
        Arrays.fill(newDefRed, false);
        Arrays.fill(newSpdRed, false);
        Arrays.fill(newSpcRed, false);
        for (int i = 0; i < 16; ++i) {
            if (!atkPossible[i]) continue;
            for (int j = 0; j < 16; ++j) {
                if (!defPossible[j]) continue;
                for (int k = 0; k < 16; ++k) {
                    if (!spdPossible[k]) continue;
                    for (int l = 0; l < 16; ++l) {
                        if (!spcPossible[l]) continue;
                        if (!hpPossible[i % 2 * 8 + j % 2 * 4 + k % 2 * 2 + l % 2]) continue;
                        newHPRed[i % 2 * 8 + j % 2 * 4 + k % 2 * 2 + l % 2] = true;
                        newAtkRed[i] = true;
                        newDefRed[j] = true;
                        newSpdRed[k] = true;
                        newSpcRed[l] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 16; ++i) {
            if (hpPossible[i] && !newHPRed[i]) {
                success = true;
                this.redHP[i] = true;
                this.removeStat(0, i);
            }
            if (atkPossible[i] && !newAtkRed[i]) {
                success = true;
                this.redAtk[i] = true;
                this.removeStat(1, i);
            }
            if (defPossible[i] && !newDefRed[i]) {
                success = true;
                this.redDef[i] = true;
                this.removeStat(2, i);
            }
            if (spdPossible[i] && !newSpdRed[i]) {
                success = true;
                this.redSpd[i] = true;
                this.removeStat(3, i);
            }
            if (spcPossible[i] && !newSpcRed[i]) {
                success = true;
                this.redSpc[i] = true;
                this.removeStat(4, i);
            }
        }
        return success;
    }

    private void setOnlyDV() {
        boolean update = true;
        while (update) {
            int i;
            update = false;
            int possibleHP = 0;
            int possibleAtk = 0;
            int possibleDef = 0;
            int possibleSpd = 0;
            int possibleSpc = 0;
            int newHP = -1;
            int newAtk = -1;
            int newDef = -1;
            int newSpd = -1;
            int newSpc = -1;
            for (i = 0; i < 16; ++i) {
                if (!this.redHP[i]) {
                    ++possibleHP;
                    newHP = i;
                }
                if (!this.redAtk[i]) {
                    ++possibleAtk;
                    newAtk = i;
                }
                if (!this.redDef[i]) {
                    ++possibleDef;
                    newDef = i;
                }
                if (!this.redSpd[i]) {
                    ++possibleSpd;
                    newSpd = i;
                }
                if (!this.redSpc[i]) {
                    ++possibleSpc;
                    newSpc = i;
                }
            }
            if (possibleHP == 1) {
                if (this.hpdv != newHP) {
                    update = true;
                }
                this.hpdv = newHP;
            }
            if (possibleAtk == 1) {
                if (this.atkdv != newAtk) {
                    update = true;
                }
                this.atkdv = newAtk;
            }
            if (possibleDef == 1) {
                if (this.defdv != newDef) {
                    update = true;
                }
                this.defdv = newDef;
            }
            if (possibleSpd == 1) {
                if (this.spddv != newSpd) {
                    update = true;
                }
                this.spddv = newSpd;
            }
            if (possibleSpc == 1) {
                if (this.spcdv != newSpc) {
                    update = true;
                }
                this.spcdv = newSpc;
            }
            if (!update) continue;
            for (i = 0; i < 16; ++i) {
                if (this.redHP[i]) {
                    this.removeStat(0, i);
                }
                if (this.redAtk[i]) {
                    this.removeStat(1, i);
                }
                if (this.redDef[i]) {
                    this.removeStat(2, i);
                }
                if (this.redSpd[i]) {
                    this.removeStat(3, i);
                }
                if (this.redSpc[i]) {
                    this.removeStat(4, i);
                }
            }
        }
    }

    private void updateLabels() {
        int firstHP = -1;
        int firstAtk = -1;
        int firstDef = -1;
        int firstSpd = -1;
        int firstSpc = -1;
        int lastHP = -1;
        int lastAtk = -1;
        int lastDef = -1;
        int lastSpd = -1;
        int lastSpc = -1;
        int possibleHP = 0;
        int possibleAtk = 0;
        int possibleDef = 0;
        int possibleSpd = 0;
        int possibleSpc = 0;
        for (int i = 0; i < 16; ++i) {
            if (!this.redHP[i]) {
                if (firstHP == -1) {
                    firstHP = i;
                }
                lastHP = i;
                ++possibleHP;
            }
            if (!this.redAtk[i]) {
                if (firstAtk == -1) {
                    firstAtk = i;
                }
                lastAtk = i;
                ++possibleAtk;
            }
            if (!this.redDef[i]) {
                if (firstDef == -1) {
                    firstDef = i;
                }
                lastDef = i;
                ++possibleDef;
            }
            if (!this.redSpd[i]) {
                if (firstSpd == -1) {
                    firstSpd = i;
                }
                lastSpd = i;
                ++possibleSpd;
            }
            if (!this.redSpc[i]) {
                if (firstSpc == -1) {
                    firstSpc = i;
                }
                lastSpc = i;
                ++possibleSpc;
            }
        }
        this.updateToto(0, firstHP, lastHP, possibleHP);
        this.updateToto(1, firstAtk, lastAtk, possibleAtk);
        this.updateToto(2, firstDef, lastDef, possibleDef);
        this.updateToto(3, firstSpd, lastSpd, possibleSpd);
        this.updateToto(4, firstSpc, lastSpc, possibleSpc);
    }

    public void updateToto(
            final int column, final int first, final int last, final int possibilities) {
        if (first < 0 || first > 15 || last < 0 || last > 15) {
            return;
        }
        JLabel labelColumn;
        if (column == 0) {
            labelColumn = this.labelHPDV;
        } else if (column == 1) {
            labelColumn = this.labelAtkDV;
        } else if (column == 2) {
            labelColumn = this.labelDefDV;
        } else if (column == 3) {
            labelColumn = this.labelSpdDV;
        } else if (column == 4) {
            labelColumn = this.labelSpcDV;
        } else {
            return;
        }
        if (first == last) {
            labelColumn.setFont(
                    new Font(
                            this.parent.getTotoDVNumbersFont(), this.parent.getTotoDVNumbersFontExtra(), this.parent.getTotoDVNumbersFontSizeBig()));
            labelColumn.setText("" + first);
        } else if (possibilities == 2) {
            labelColumn.setFont(
                    new Font(
                            this.parent.getTotoDVNumbersFont(),
                            this.parent.getTotoDVNumbersFontExtra(),
                            this.parent.getTotoDVNumbersFontSizeSmall()));
            labelColumn.setText(String.valueOf(first) + "/" + last);
        } else if (last - first < 10) {
            labelColumn.setFont(
                    new Font(
                            this.parent.getTotoDVNumbersFont(),
                            this.parent.getTotoDVNumbersFontExtra(),
                            this.parent.getTotoDVNumbersFontSizeSmall()));
            labelColumn.setText(String.valueOf(first) + "-" + last);
        } else {
            labelColumn.setFont(
                    new Font(
                            this.parent.getTotoDVNumbersFont(), this.parent.getTotoDVNumbersFontExtra(), this.parent.getTotoDVNumbersFontSizeBig()));
            labelColumn.setText("?");
        }
    }

    private boolean hasEven(ArrayList<StatButton> list) {
        boolean even = false;
        for (int i = 0; i < 8; ++i) {
            if (!list.get((i * 2)).isPossible()) continue;
            even = true;
            break;
        }
        return even;
    }

    private boolean hasOdd(ArrayList<StatButton> list) {
        boolean odd = false;
        for (int i = 0; i < 8; ++i) {
            if (!list.get((i * 2 + 1)).isPossible()) continue;
            odd = true;
            break;
        }
        return odd;
    }

    public void manuallySelectDV(int column, int dv) {
        boolean[] redValues = new boolean[16];
        Arrays.fill(redValues, Boolean.TRUE);
        redValues[dv] = false;
        if (column == 0) {
            externalRed(redValues, redAtk, redDef, redSpd, redSpc);
        } else if (column == 1) {
            externalRed(redHP, redValues, redDef, redSpd, redSpc);
        } else if (column == 2) {
            externalRed(redHP, redAtk, redValues, redSpd, redSpc);
        } else if (column == 3) {
            externalRed(redHP, redAtk, redDef, redValues, redSpc);
        } else if (column == 4) {
            externalRed(redHP, redAtk, redDef, redSpd, redValues);
        }
    }

    public void updateTotoLookAndFeel() {
        this.totodile.setSize(this.parent.getTotoWidth(), this.parent.getTotoHeight());
        int borderLeftRight = this.parent.getTotoWidth() / 72;
        int borderTopBottom = this.parent.getTotoHeight() / 24;
        this.totodile.setBorder(new EmptyBorder(borderTopBottom, borderLeftRight, 0, borderLeftRight));
        this.totodile.setBackground(this.parent.getTotoBackgroundColor());
        this.totodileDVSPanel.setBackground(this.parent.getTotoBackgroundColor());
        this.totodileDVSPanel.setBorder(new EmptyBorder(borderTopBottom, 0, borderTopBottom, 0));
        this.labelTitle.setText(this.parent.getTotoTitleText());
        this.labelTitle.setFont(new Font(this.parent.getTotoTitleFont(), this.parent.getTotoTitleFontExtra(), this.parent.getTotoTitleFontSize()));
        this.labelTitle.setForeground(this.parent.getTotoTitleColor());

        Font columnHeadersFont =
                new Font(this.parent.getTotoColumnHeadersFont(), this.parent.getTotoColumnHeadersFontExtra(), this.parent.getTotoColumnHeadersFontSize());
        this.labelHP.setFont(columnHeadersFont);
        this.labelHP.setForeground(this.parent.getTotoColumnHeadersColor());
        this.labelAtk.setFont(columnHeadersFont);
        this.labelAtk.setForeground(this.parent.getTotoColumnHeadersColor());
        this.labelDef.setFont(columnHeadersFont);
        this.labelDef.setForeground(this.parent.getTotoColumnHeadersColor());
        this.labelSpd.setFont(columnHeadersFont);
        this.labelSpd.setForeground(this.parent.getTotoColumnHeadersColor());
        this.labelSpc.setFont(columnHeadersFont);
        this.labelSpc.setForeground(this.parent.getTotoColumnHeadersColor());
        this.labelHPDV.setForeground(this.parent.getTotoDVNumbersColor());
        this.labelAtkDV.setForeground(this.parent.getTotoDVNumbersColor());
        this.labelDefDV.setForeground(this.parent.getTotoDVNumbersColor());
        this.labelSpdDV.setForeground(this.parent.getTotoDVNumbersColor());
        this.labelSpcDV.setForeground(this.parent.getTotoDVNumbersColor());

        Font dvNumbersBig =
                new Font(this.parent.getTotoDVNumbersFont(), this.parent.getTotoDVNumbersFontExtra(), this.parent.getTotoDVNumbersFontSizeBig());
        Font dvNumbersSmall =
                new Font(this.parent.getTotoDVNumbersFont(), this.parent.getTotoDVNumbersFontExtra(), this.parent.getTotoDVNumbersFontSizeSmall());
        if (this.labelHPDV.getText().length() <= 2) {
            this.labelHPDV.setFont(dvNumbersBig);
        } else {
            this.labelHPDV.setFont(dvNumbersSmall);
        }
        if (this.labelAtkDV.getText().length() <= 2) {
            this.labelAtkDV.setFont(dvNumbersBig);
        } else {
            this.labelAtkDV.setFont(dvNumbersSmall);
        }
        if (this.labelDefDV.getText().length() <= 2) {
            this.labelDefDV.setFont(dvNumbersBig);
        } else {
            this.labelDefDV.setFont(dvNumbersSmall);
        }
        if (this.labelSpdDV.getText().length() <= 2) {
            this.labelSpdDV.setFont(dvNumbersBig);
        } else {
            this.labelSpdDV.setFont(dvNumbersSmall);
        }
        if (this.labelSpcDV.getText().length() <= 2) {
            this.labelSpcDV.setFont(dvNumbersBig);
        } else {
            this.labelSpcDV.setFont(dvNumbersSmall);
        }
    }
}
