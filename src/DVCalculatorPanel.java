import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DVCalculatorPanel
extends JPanel {
    private static final long serialVersionUID = -7545905343679467024L;
    private HelperFrame parent;
    private String font;
    private boolean[] redHP = new boolean[16];
    private boolean[] redAtk = new boolean[16];
    private boolean[] redDef = new boolean[16];
    private boolean[] redSpd = new boolean[16];
    private boolean[] redSpc = new boolean[16];
    private ArrayList<Stat> hpStats;
    private ArrayList<Stat> atkStats;
    private ArrayList<Stat> defStats;
    private ArrayList<Stat> spdStats;
    private ArrayList<Stat> spcStats;
    private ArrayList<Pokemon> pokedex;
    private int level = 5;
    private int exp = lowestExpForLevel(5);
    private int hp_ev_used = 0;
    private int atk_ev_used = 0;
    private int def_ev_used = 0;
    private int spd_ev_used = 0;
    private int spc_ev_used = 0;
    private int hpStatExp = 0;
    private int atkStatExp = 0;
    private int defStatExp = 0;
    private int spdStatExp = 0;
    private int spcStatExp = 0;
    private int baseHP = 50;
    private int baseAtk = 65;
    private int baseDef = 64;
    private int baseSpA = 44;
    private int baseSpD = 48;
    private int baseSpe = 43;
    private int stage = 0;
    private JLabel labelTotoLevel;
    private JLabel labelSentretAmount;
    private JLabel labelPidgeyAmount;
    private JLabel labelRattataAmount;
    private JLabel labelCaterpieAmount;
    private JLabel labelGeodudeAmount;
    private JLabel labelSandshrewAmount;
    private JLabel labelOnixAmount;
    private JLabel labelZubatAmount;
    private JButton buttonPidgeyL2;
    private JButton buttonPidgeyL3;
    private JButton buttonPidgeyL4;
    private JButton buttonSentretL2;
    private JButton buttonSentretL3;
    private JButton buttonRattataL4;
    private JButton buttonCaterpieL3;
    private JButton buttonCaterpieL4;
    private JButton buttonGeodudeL6;
    private JButton buttonSandshrewL6;
    private JButton buttonOnixL6;
    private JButton buttonZubatL5;
    private JButton buttonZubatL6;

    private JButton buttonRivalChikoritaL5;
    private JButton buttonMikeyPidgeyL2;
    private JButton buttonMikeyRattataL4;
    private JButton buttonDonCaterpieL3_1;
    private JButton buttonDonCaterpieL3_2;
    private JButton buttonAbeSpearowL9;
    private JButton buttonRodPidgeyL7_1;
    private JButton buttonRodPidgeyL7_2;
    private JButton buttonFalknerPidgeyL7;
    private JButton buttonFalknerPidgeottoL9;
    private JButton buttonAlbertRattataL6;
    private JButton buttonAlbertZubatL8;
    private JButton buttonRalphGoldeenL10;
    private JButton buttonDanielOnixL11;
    private JButton buttonRussellGeodudeL4;
    private JButton buttonRussellGeodudeL6;
    private JButton buttonRussellGeodudeL8;
    private JButton buttonBillKoffingL6_1;
    private JButton buttonBillKoffingL6_2;
    private JButton buttonRayVulpixL9;
    private JButton buttonAnthonyGeodudeL11;
    private JButton buttonAnthonyMachopL11;
    private JButton buttonGrunt1RattataL9_1;
    private JButton buttonGrunt1RattataL9_2;
    private JButton buttonGrunt2ZubatL9;
    private JButton buttonGrunt2EkansL11;
    private JButton buttonGrunt3RattataL7;
    private JButton buttonGrunt3ZubatL9_1;
    private JButton buttonGrunt3ZubatL9_2;
    private JButton buttonGrunt4KoffingL14;

    public static int lowestExpForLevel(int level) {
        int n = level;
        return 6*n*n*n/5 - 15*n*n + 100*n - 140;
    }
    
	public int expGiven(FoePokemon foe) {
		int ret = (pokedex.get(foe.poke.ordinal()).expGiven) * foe.level / 7 * 3
                / (foe.isWild ? 3 : 2);
        return ret;
	}

    private String getExecutionPath() {
        return this.parent.getExecutionPath();
    }

    public DVCalculatorPanel(HelperFrame parent, String font) {
        this.parent = parent;
        this.font = font;
        this.setLayout(null);
        this.setBounds(0, 160, 1280, 518);
        this.setBackground(null);
        this.init();
        this.initStatButtons();
        this.initPokemon();
        this.updateStats();
    }

    private void init() {
        for (int i = 0; i < 16; ++i) {
            this.redHP[i] = false;
            this.redAtk[i] = false;
            this.redDef[i] = false;
            this.redSpd[i] = false;
            this.redSpc[i] = false;
        }
        JLabel labelHP = new JLabel("HP");
        labelHP.setBounds(14, 72, 70, 50);
        labelHP.setFont(new Font(this.font, 1, 19));
        labelHP.setHorizontalAlignment(0);
        this.add(labelHP);
        JLabel labelAtk = new JLabel("Atk");
        labelAtk.setBounds(104, 72, 70, 50);
        labelAtk.setFont(new Font(this.font, 1, 19));
        labelAtk.setHorizontalAlignment(0);
        this.add(labelAtk);
        JLabel labelDef = new JLabel("Def");
        labelDef.setBounds(194, 72, 70, 50);
        labelDef.setFont(new Font(this.font, 1, 19));
        labelDef.setHorizontalAlignment(0);
        this.add(labelDef);
        JLabel labelSpd = new JLabel("Spd");
        labelSpd.setBounds(284, 72, 70, 50);
        labelSpd.setFont(new Font(this.font, 1, 19));
        labelSpd.setHorizontalAlignment(0);
        this.add(labelSpd);
        JLabel labelSpc = new JLabel("Spc");
        labelSpc.setBounds(374, 72, 70, 50);
        labelSpc.setFont(new Font(this.font, 1, 19));
        labelSpc.setHorizontalAlignment(0);
        this.add(labelSpc);
        JLabel labelTotoIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/totodile.png"));
        labelTotoIcon.setBounds(134, 17, 48, 48);
        this.add(labelTotoIcon);
        this.labelTotoLevel = new JLabel("Level: " + this.level);
        this.labelTotoLevel.setBounds(196,17,150,48);
        this.labelTotoLevel.setFont(new Font(this.font,1,29));
        this.add(this.labelTotoLevel);

        JLabel labelWild = new JLabel("Wild Pokes");
        labelWild.setBounds(487,21,190,42);
        labelWild.setFont(new Font(this.font,1,29));
        this.add(labelWild);
        this.labelPidgeyAmount = new JLabel("×0");
        this.labelPidgeyAmount.setBounds(628, 87, 50, 24);
        this.labelPidgeyAmount.setFont(new Font(this.font, 1, 22));
        this.add(this.labelPidgeyAmount);
        JLabel labelPidgeyIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/pidgey.png"));
        labelPidgeyIcon.setBounds(585, 78, 40, 40);
        this.add(labelPidgeyIcon);
        this.buttonPidgeyL2 = new JButton("L2");
        this.buttonPidgeyL2.setBounds(489, 84, 28, 28);
        this.buttonPidgeyL2.setMargin(new Insets(1, 0, 1, 0));
        this.buttonPidgeyL2.setFont(new Font(this.font, 1, 15));
        this.buttonPidgeyL2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelPidgeyAmount.getText().substring(1));
                DVCalculatorPanel.this.labelPidgeyAmount.setText("×" + ++amount);
            	DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 2, true));
            	DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
            	while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
            		DVCalculatorPanel.this.level++;
            		DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
            		DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
            		DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
            		DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
            		DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
            		DVCalculatorPanel.this.updateStats();
            	}
            }
        });
        this.add(this.buttonPidgeyL2);
        this.buttonPidgeyL3 = new JButton("L3");
        this.buttonPidgeyL3.setBounds(519, 84, 28, 28);
        this.buttonPidgeyL3.setMargin(new Insets(1, 0, 1, 0));
        this.buttonPidgeyL3.setFont(new Font(this.font, 1, 15));
        this.buttonPidgeyL3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelPidgeyAmount.getText().substring(1));
                DVCalculatorPanel.this.labelPidgeyAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 3, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonPidgeyL3);
        this.buttonPidgeyL4 = new JButton("L4");
        this.buttonPidgeyL4.setBounds(549, 84, 28, 28);
        this.buttonPidgeyL4.setMargin(new Insets(1, 0, 1, 0));
        this.buttonPidgeyL4.setFont(new Font(this.font, 1, 15));
        this.buttonPidgeyL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelPidgeyAmount.getText().substring(1));
                DVCalculatorPanel.this.labelPidgeyAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 4, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonPidgeyL4);
        this.labelSentretAmount = new JLabel("×0");
        this.labelSentretAmount.setBounds(629, 133, 50, 24);
        this.labelSentretAmount.setFont(new Font(this.font, 1, 22));
        this.add(this.labelSentretAmount);
        JLabel labelSentretIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/sentret.png"));
        labelSentretIcon.setBounds(585, 124, 40, 40);
        this.add(labelSentretIcon);
        this.buttonSentretL2 = new JButton("L2");
        this.buttonSentretL2.setBounds(489, 130, 28, 28);
        this.buttonSentretL2.setMargin(new Insets(1, 0, 1, 0));
        this.buttonSentretL2.setFont(new Font(this.font, 1, 15));
        this.buttonSentretL2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelSentretAmount.getText().substring(1));
                DVCalculatorPanel.this.labelSentretAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.SENTRET, 2, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.SENTRET, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonSentretL2);
        this.buttonSentretL3 = new JButton("L3");
        this.buttonSentretL3.setBounds(519, 130, 28, 28);
        this.buttonSentretL3.setMargin(new Insets(1, 0, 1, 0));
        this.buttonSentretL3.setFont(new Font(this.font, 1, 15));
        this.buttonSentretL3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelSentretAmount.getText().substring(1));
                DVCalculatorPanel.this.labelSentretAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.SENTRET, 3, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.SENTRET, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonSentretL3);
        this.labelRattataAmount = new JLabel("×0");
        this.labelRattataAmount.setBounds(629, 179, 50, 24);
        this.labelRattataAmount.setFont(new Font(this.font, 1, 22));
        this.add(this.labelRattataAmount);
        JLabel labelRattataIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/rattata.png"));
        labelRattataIcon.setBounds(585, 170, 40, 40);
        this.add(labelRattataIcon);
        this.buttonRattataL4 = new JButton("L4");
        this.buttonRattataL4.setBounds(549, 176, 28, 28);
        this.buttonRattataL4.setMargin(new Insets(1, 0, 1, 0));
        this.buttonRattataL4.setFont(new Font(this.font, 1, 15));
        this.buttonRattataL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelRattataAmount.getText().substring(1));
                DVCalculatorPanel.this.labelRattataAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 4, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonRattataL4);
        this.labelCaterpieAmount = new JLabel("×0");
        this.labelCaterpieAmount.setBounds(629, 225, 50, 24);
        this.labelCaterpieAmount.setFont(new Font(this.font, 1, 22));
        this.add(this.labelCaterpieAmount);
        JLabel labelCaterpieIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/caterpie.png"));
        labelCaterpieIcon.setBounds(585, 216, 40, 40);
        this.add(labelCaterpieIcon);
        this.buttonCaterpieL3 = new JButton("L3");
        this.buttonCaterpieL3.setBounds(519, 222, 28, 28);
        this.buttonCaterpieL3.setMargin(new Insets(1, 0, 1, 0));
        this.buttonCaterpieL3.setFont(new Font(this.font, 1, 15));
        this.buttonCaterpieL3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelCaterpieAmount.getText().substring(1));
                DVCalculatorPanel.this.labelCaterpieAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CATERPIE, 3, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CATERPIE, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonCaterpieL3);
        this.buttonCaterpieL4 = new JButton("L4");
        this.buttonCaterpieL4.setBounds(549, 222, 28, 28);
        this.buttonCaterpieL4.setMargin(new Insets(1, 0, 1, 0));
        this.buttonCaterpieL4.setFont(new Font(this.font, 1, 15));
        this.buttonCaterpieL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelCaterpieAmount.getText().substring(1));
                DVCalculatorPanel.this.labelCaterpieAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CATERPIE, 4, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CATERPIE, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonCaterpieL4);
        this.labelGeodudeAmount = new JLabel("×0");
        this.labelGeodudeAmount.setBounds(629, 313, 50, 24);
        this.labelGeodudeAmount.setFont(new Font(this.font, 1, 22));
        this.add(this.labelGeodudeAmount);
        JLabel labelGeodudeIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/geodude.png"));
        labelGeodudeIcon.setBounds(585, 304, 40, 40);
        this.add(labelGeodudeIcon);
        this.buttonGeodudeL6 = new JButton("L6");
        this.buttonGeodudeL6.setBounds(549, 310, 28, 28);
        this.buttonGeodudeL6.setMargin(new Insets(1, 0, 1, 0));
        this.buttonGeodudeL6.setFont(new Font(this.font, 1, 15));
        this.buttonGeodudeL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelGeodudeAmount.getText().substring(1));
                DVCalculatorPanel.this.labelGeodudeAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GEODUDE, 6, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GEODUDE, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonGeodudeL6);
        this.labelSandshrewAmount = new JLabel("×0");
        this.labelSandshrewAmount.setBounds(629, 359, 50, 24);
        this.labelSandshrewAmount.setFont(new Font(this.font, 1, 22));
        this.add(this.labelSandshrewAmount);
        JLabel labelSandshrewIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/sandshrew.png"));
        labelSandshrewIcon.setBounds(585, 350, 40, 40);
        this.add(labelSandshrewIcon);
        this.buttonSandshrewL6 = new JButton("L6");
        this.buttonSandshrewL6.setBounds(549, 356, 28, 28);
        this.buttonSandshrewL6.setMargin(new Insets(1, 0, 1, 0));
        this.buttonSandshrewL6.setFont(new Font(this.font, 1, 15));
        this.buttonSandshrewL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelSandshrewAmount.getText().substring(1));
                DVCalculatorPanel.this.labelSandshrewAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.SANDSHREW, 6, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.SANDSHREW, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonSandshrewL6);
        this.labelOnixAmount = new JLabel("×0");
        this.labelOnixAmount.setBounds(629, 405, 50, 24);
        this.labelOnixAmount.setFont(new Font(this.font, 1, 22));
        this.add(this.labelOnixAmount);
        JLabel labelOnixIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/onix.png"));
        labelOnixIcon.setBounds(585, 396, 40, 40);
        this.add(labelOnixIcon);
        this.buttonOnixL6 = new JButton("L6");
        this.buttonOnixL6.setBounds(549, 402, 28, 28);
        this.buttonOnixL6.setMargin(new Insets(1, 0, 1, 0));
        this.buttonOnixL6.setFont(new Font(this.font, 1, 15));
        this.buttonOnixL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelOnixAmount.getText().substring(1));
                DVCalculatorPanel.this.labelOnixAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ONIX, 6, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ONIX, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonOnixL6);
        this.labelZubatAmount = new JLabel("×0");
        this.labelZubatAmount.setBounds(629, 451, 50, 24);
        this.labelZubatAmount.setFont(new Font(this.font, 1, 22));
        this.add(this.labelZubatAmount);
        JLabel labelZubatIcon = new JLabel(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/zubat.png"));
        labelZubatIcon.setBounds(585, 442, 40, 40);
        this.add(labelZubatIcon);
        this.buttonZubatL5 = new JButton("L5");
        this.buttonZubatL5.setBounds(519, 448, 28, 28);
        this.buttonZubatL5.setMargin(new Insets(1, 0, 1, 0));
        this.buttonZubatL5.setFont(new Font(this.font, 1, 15));
        this.buttonZubatL5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelZubatAmount.getText().substring(1));
                DVCalculatorPanel.this.labelZubatAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ZUBAT, 5, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ZUBAT, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonZubatL5);
        this.buttonZubatL6 = new JButton("L6");
        this.buttonZubatL6.setBounds(549, 448, 28, 28);
        this.buttonZubatL6.setMargin(new Insets(1, 0, 1, 0));
        this.buttonZubatL6.setFont(new Font(this.font, 1, 15));
        this.buttonZubatL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(DVCalculatorPanel.this.labelZubatAmount.getText().substring(1));
                DVCalculatorPanel.this.labelZubatAmount.setText("×" + ++amount);
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ZUBAT, 6, true));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ZUBAT, 1);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonZubatL6);
        JLabel labelTrainers = new JLabel("Trainers");
        labelTrainers.setBounds(716,21,150,42);
        labelTrainers.setFont(new Font(this.font,1,29));
        this.add(labelTrainers);
        JLabel labelRival = new JLabel("RIVAL 1");
        labelRival.setBounds(719,87,124,24);
        labelRival.setFont(new Font(this.font,1,13));
        this.add(labelRival);
        buttonRivalChikoritaL5 = new JButton("L5");
        buttonRivalChikoritaL5.setVerticalAlignment(JLabel.CENTER);
        buttonRivalChikoritaL5.setVerticalTextPosition(JLabel.CENTER);
        buttonRivalChikoritaL5.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRivalChikoritaL5.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/chikorita.png"));
        buttonRivalChikoritaL5.setBounds(790,72,77,52);
        buttonRivalChikoritaL5.setMargin(new Insets(1,0,1,0));
        buttonRivalChikoritaL5.setFont(new Font(this.font, 1, 12));
        buttonRivalChikoritaL5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CHIKORITA, 5, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CHIKORITA, 1);
                DVCalculatorPanel.this.buttonRivalChikoritaL5.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRivalChikoritaL5);
        JLabel labelMikey = new JLabel("MIKEY");
        labelMikey.setBounds(719,139,124,24);
        labelMikey.setFont(new Font(this.font,1,13));
        this.add(labelMikey);
        buttonMikeyPidgeyL2 = new JButton("L2");
        buttonMikeyPidgeyL2.setVerticalAlignment(JLabel.CENTER);
        buttonMikeyPidgeyL2.setVerticalTextPosition(JLabel.CENTER);
        buttonMikeyPidgeyL2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonMikeyPidgeyL2.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/pidgey.png"));
        buttonMikeyPidgeyL2.setBounds(790,124,77,52);
        buttonMikeyPidgeyL2.setMargin(new Insets(1,0,1,0));
        buttonMikeyPidgeyL2.setFont(new Font(this.font, 1, 12));
        buttonMikeyPidgeyL2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 2, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                DVCalculatorPanel.this.buttonMikeyPidgeyL2.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonMikeyPidgeyL2);
        buttonMikeyRattataL4 = new JButton("L4");
        buttonMikeyRattataL4.setVerticalAlignment(JLabel.CENTER);
        buttonMikeyRattataL4.setVerticalTextPosition(JLabel.CENTER);
        buttonMikeyRattataL4.setHorizontalTextPosition(JLabel.RIGHT);
        buttonMikeyRattataL4.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/rattata.png"));
        buttonMikeyRattataL4.setBounds(865,124,77,52);
        buttonMikeyRattataL4.setMargin(new Insets(1,0,1,0));
        buttonMikeyRattataL4.setFont(new Font(this.font, 1, 12));
        buttonMikeyRattataL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 4, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                DVCalculatorPanel.this.buttonMikeyRattataL4.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonMikeyRattataL4);
        JLabel labelDon = new JLabel("DON");
        labelDon.setBounds(719,191,124,24);
        labelDon.setFont(new Font(this.font,1,13));
        this.add(labelDon);
        buttonDonCaterpieL3_1 = new JButton("L3");
        buttonDonCaterpieL3_1.setVerticalAlignment(JLabel.CENTER);
        buttonDonCaterpieL3_1.setVerticalTextPosition(JLabel.CENTER);
        buttonDonCaterpieL3_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDonCaterpieL3_1.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/caterpie.png"));
        buttonDonCaterpieL3_1.setBounds(790,176,77,52);
        buttonDonCaterpieL3_1.setMargin(new Insets(1,0,1,0));
        buttonDonCaterpieL3_1.setFont(new Font(this.font, 1, 12));
        buttonDonCaterpieL3_1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CATERPIE, 3, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CATERPIE, 1);
                DVCalculatorPanel.this.buttonDonCaterpieL3_1.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonDonCaterpieL3_1);
        buttonDonCaterpieL3_2 = new JButton("L3");
        buttonDonCaterpieL3_2.setVerticalAlignment(JLabel.CENTER);
        buttonDonCaterpieL3_2.setVerticalTextPosition(JLabel.CENTER);
        buttonDonCaterpieL3_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDonCaterpieL3_2.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/caterpie.png"));
        buttonDonCaterpieL3_2.setBounds(865,176,77,52);
        buttonDonCaterpieL3_2.setMargin(new Insets(1,0,1,0));
        buttonDonCaterpieL3_2.setFont(new Font(this.font, 1, 12));
        buttonDonCaterpieL3_2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CATERPIE, 3, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CATERPIE, 1);
                DVCalculatorPanel.this.buttonDonCaterpieL3_2.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonDonCaterpieL3_2);
        JLabel labelAbe = new JLabel("ABE");
        labelAbe.setBounds(719,243,124,24);
        labelAbe.setFont(new Font(this.font,1,13));
        this.add(labelAbe);
        buttonAbeSpearowL9 = new JButton("L9");
        buttonAbeSpearowL9.setVerticalAlignment(JLabel.CENTER);
        buttonAbeSpearowL9.setVerticalTextPosition(JLabel.CENTER);
        buttonAbeSpearowL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAbeSpearowL9.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/spearow.png"));
        buttonAbeSpearowL9.setBounds(790,228,77,52);
        buttonAbeSpearowL9.setMargin(new Insets(1,0,1,0));
        buttonAbeSpearowL9.setFont(new Font(this.font, 1, 12));
        buttonAbeSpearowL9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.SPEAROW, 9, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.SPEAROW, 1);
                DVCalculatorPanel.this.buttonAbeSpearowL9.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonAbeSpearowL9);
        JLabel labelRod = new JLabel("ROD");
        labelRod.setBounds(719,295,124,24);
        labelRod.setFont(new Font(this.font,1,13));
        this.add(labelRod);
        buttonRodPidgeyL7_1 = new JButton("L7");
        buttonRodPidgeyL7_1.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_1.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_1.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/pidgey.png"));
        buttonRodPidgeyL7_1.setBounds(790,280,77,52);
        buttonRodPidgeyL7_1.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_1.setFont(new Font(this.font, 1, 12));
        buttonRodPidgeyL7_1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                DVCalculatorPanel.this.buttonRodPidgeyL7_1.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRodPidgeyL7_1);
        buttonRodPidgeyL7_2 = new JButton("L7");
        buttonRodPidgeyL7_2.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_2.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_2.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/pidgey.png"));
        buttonRodPidgeyL7_2.setBounds(865,280,77,52);
        buttonRodPidgeyL7_2.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_2.setFont(new Font(this.font, 1, 12));
        buttonRodPidgeyL7_2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                DVCalculatorPanel.this.buttonRodPidgeyL7_2.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRodPidgeyL7_2);
        JLabel labelFalkner = new JLabel("FALKNER");
        labelFalkner.setBounds(719,347,124,24);
        labelFalkner.setFont(new Font(this.font,1,13));
        this.add(labelFalkner);
        buttonFalknerPidgeyL7 = new JButton("L7");
        buttonFalknerPidgeyL7.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeyL7.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeyL7.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeyL7.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/pidgey.png"));
        buttonFalknerPidgeyL7.setBounds(790,332,77,52);
        buttonFalknerPidgeyL7.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeyL7.setFont(new Font(this.font, 1, 12));
        buttonFalknerPidgeyL7.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                DVCalculatorPanel.this.buttonFalknerPidgeyL7.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonFalknerPidgeyL7);
        buttonFalknerPidgeottoL9 = new JButton("L9");
        buttonFalknerPidgeottoL9.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeottoL9.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/pidgeotto.png"));
        buttonFalknerPidgeottoL9.setBounds(865,332,77,52);
        buttonFalknerPidgeottoL9.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeottoL9.setFont(new Font(this.font, 1, 12));
        buttonFalknerPidgeottoL9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEOTTO, 9, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEOTTO, 1);
                DVCalculatorPanel.this.buttonFalknerPidgeottoL9.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonFalknerPidgeottoL9);
        JLabel labelAlbert = new JLabel("ALBERT");
        labelAlbert.setBounds(719,399,124,24);
        labelAlbert.setFont(new Font(this.font,1,13));
        this.add(labelAlbert);
        buttonAlbertRattataL6 = new JButton("L6");
        buttonAlbertRattataL6.setVerticalAlignment(JLabel.CENTER);
        buttonAlbertRattataL6.setVerticalTextPosition(JLabel.CENTER);
        buttonAlbertRattataL6.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAlbertRattataL6.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/rattata.png"));
        buttonAlbertRattataL6.setBounds(790,384,77,52);
        buttonAlbertRattataL6.setMargin(new Insets(1,0,1,0));
        buttonAlbertRattataL6.setFont(new Font(this.font, 1, 12));
        buttonAlbertRattataL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 6, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                DVCalculatorPanel.this.buttonAlbertRattataL6.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonAlbertRattataL6);
        buttonAlbertZubatL8 = new JButton("L8");
        buttonAlbertZubatL8.setVerticalAlignment(JLabel.CENTER);
        buttonAlbertZubatL8.setVerticalTextPosition(JLabel.CENTER);
        buttonAlbertZubatL8.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAlbertZubatL8.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/zubat.png"));
        buttonAlbertZubatL8.setBounds(865,384,77,52);
        buttonAlbertZubatL8.setMargin(new Insets(1,0,1,0));
        buttonAlbertZubatL8.setFont(new Font(this.font, 1, 12));
        buttonAlbertZubatL8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ZUBAT, 8, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ZUBAT, 1);
                DVCalculatorPanel.this.buttonAlbertZubatL8.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonAlbertZubatL8);
        JLabel labelRalph = new JLabel("RALPH");
        labelRalph.setBounds(719,451,124,24);
        labelRalph.setFont(new Font(this.font,1,13));
        this.add(labelRalph);
        buttonRalphGoldeenL10 = new JButton("L10");
        buttonRalphGoldeenL10.setVerticalAlignment(JLabel.CENTER);
        buttonRalphGoldeenL10.setVerticalTextPosition(JLabel.CENTER);
        buttonRalphGoldeenL10.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRalphGoldeenL10.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/goldeen.png"));
        buttonRalphGoldeenL10.setBounds(790,436,77,52);
        buttonRalphGoldeenL10.setMargin(new Insets(1,0,1,0));
        buttonRalphGoldeenL10.setFont(new Font(this.font, 1, 12));
        buttonRalphGoldeenL10.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GOLDEEN, 10, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GOLDEEN, 1);
                DVCalculatorPanel.this.buttonRalphGoldeenL10.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRalphGoldeenL10);
        JLabel labelDaniel = new JLabel("DANIEL");
        labelDaniel.setBounds(965,35,124,24);
        labelDaniel.setFont(new Font(this.font,1,13));
        this.add(labelDaniel);
        buttonDanielOnixL11 = new JButton("L11");
        buttonDanielOnixL11.setVerticalAlignment(JLabel.CENTER);
        buttonDanielOnixL11.setVerticalTextPosition(JLabel.CENTER);
        buttonDanielOnixL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDanielOnixL11.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/onix.png"));
        buttonDanielOnixL11.setBounds(1036,20,77,52);
        buttonDanielOnixL11.setMargin(new Insets(1,0,1,0));
        buttonDanielOnixL11.setFont(new Font(this.font, 1, 12));
        buttonDanielOnixL11.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ONIX, 11, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ONIX, 1);
                DVCalculatorPanel.this.buttonDanielOnixL11.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonDanielOnixL11);
        JLabel labelRussell = new JLabel("RUSSELL");
        labelRussell.setBounds(965,87,124,24);
        labelRussell.setFont(new Font(this.font,1,13));
        this.add(labelRussell);
        buttonRussellGeodudeL4 = new JButton("L4");
        buttonRussellGeodudeL4.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL4.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL4.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL4.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/geodude.png"));
        buttonRussellGeodudeL4.setBounds(1036,72,77,52);
        buttonRussellGeodudeL4.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL4.setFont(new Font(this.font, 1, 12));
        buttonRussellGeodudeL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GEODUDE, 4, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GEODUDE, 1);
                DVCalculatorPanel.this.buttonRussellGeodudeL4.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRussellGeodudeL4);
        buttonRussellGeodudeL6 = new JButton("L6");
        buttonRussellGeodudeL6.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL6.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL6.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL6.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/geodude.png"));
        buttonRussellGeodudeL6.setBounds(1111,72,77,52);
        buttonRussellGeodudeL6.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL6.setFont(new Font(this.font, 1, 12));
        buttonRussellGeodudeL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GEODUDE, 6, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GEODUDE, 1);
                DVCalculatorPanel.this.buttonRussellGeodudeL6.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRussellGeodudeL6);
        buttonRussellGeodudeL8 = new JButton("L8");
        buttonRussellGeodudeL8.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL8.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL8.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL8.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/geodude.png"));
        buttonRussellGeodudeL8.setBounds(1186,72,77,52);
        buttonRussellGeodudeL8.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL8.setFont(new Font(this.font, 1, 12));
        buttonRussellGeodudeL8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GEODUDE, 8, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GEODUDE, 1);
                DVCalculatorPanel.this.buttonRussellGeodudeL8.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRussellGeodudeL8);
        JLabel labelBill = new JLabel("BILL");
        labelBill.setBounds(965,139,124,24);
        labelBill.setFont(new Font(this.font,1,13));
        this.add(labelBill);
        buttonBillKoffingL6_1 = new JButton("L6");
        buttonBillKoffingL6_1.setVerticalAlignment(JLabel.CENTER);
        buttonBillKoffingL6_1.setVerticalTextPosition(JLabel.CENTER);
        buttonBillKoffingL6_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonBillKoffingL6_1.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/koffing.png"));
        buttonBillKoffingL6_1.setBounds(1036,124,77,52);
        buttonBillKoffingL6_1.setMargin(new Insets(1,0,1,0));
        buttonBillKoffingL6_1.setFont(new Font(this.font, 1, 12));
        buttonBillKoffingL6_1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.KOFFING, 6, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.KOFFING, 1);
                DVCalculatorPanel.this.buttonBillKoffingL6_1.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonBillKoffingL6_1);
        buttonBillKoffingL6_2 = new JButton("L6");
        buttonBillKoffingL6_2.setVerticalAlignment(JLabel.CENTER);
        buttonBillKoffingL6_2.setVerticalTextPosition(JLabel.CENTER);
        buttonBillKoffingL6_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonBillKoffingL6_2.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/koffing.png"));
        buttonBillKoffingL6_2.setBounds(1111,124,77,52);
        buttonBillKoffingL6_2.setMargin(new Insets(1,0,1,0));
        buttonBillKoffingL6_2.setFont(new Font(this.font, 1, 12));
        buttonBillKoffingL6_2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.KOFFING, 6, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.KOFFING, 1);
                DVCalculatorPanel.this.buttonBillKoffingL6_2.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonBillKoffingL6_2);
        JLabel labelRay = new JLabel("RAY");
        labelRay.setBounds(965,191,124,24);
        labelRay.setFont(new Font(this.font,1,13));
        this.add(labelRay);
        buttonRayVulpixL9 = new JButton("L9");
        buttonRayVulpixL9.setVerticalAlignment(JLabel.CENTER);
        buttonRayVulpixL9.setVerticalTextPosition(JLabel.CENTER);
        buttonRayVulpixL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRayVulpixL9.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/vulpix.png"));
        buttonRayVulpixL9.setBounds(1036,176,77,52);
        buttonRayVulpixL9.setMargin(new Insets(1,0,1,0));
        buttonRayVulpixL9.setFont(new Font(this.font, 1, 12));
        buttonRayVulpixL9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.VULPIX, 9, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.VULPIX, 1);
                DVCalculatorPanel.this.buttonRayVulpixL9.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRayVulpixL9);
        JLabel labelAnthony = new JLabel("ANTHONY");
        labelAnthony.setBounds(965,243,124,24);
        labelAnthony.setFont(new Font(this.font,1,13));
        this.add(labelAnthony);
        buttonAnthonyGeodudeL11 = new JButton("L11");
        buttonAnthonyGeodudeL11.setVerticalAlignment(JLabel.CENTER);
        buttonAnthonyGeodudeL11.setVerticalTextPosition(JLabel.CENTER);
        buttonAnthonyGeodudeL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAnthonyGeodudeL11.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/geodude.png"));
        buttonAnthonyGeodudeL11.setBounds(1036,228,77,52);
        buttonAnthonyGeodudeL11.setMargin(new Insets(1,0,1,0));
        buttonAnthonyGeodudeL11.setFont(new Font(this.font, 1, 12));
        buttonAnthonyGeodudeL11.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GEODUDE, 11, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GEODUDE, 1);
                DVCalculatorPanel.this.buttonAnthonyGeodudeL11.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonAnthonyGeodudeL11);
        buttonAnthonyMachopL11 = new JButton("L11");
        buttonAnthonyMachopL11.setVerticalAlignment(JLabel.CENTER);
        buttonAnthonyMachopL11.setVerticalTextPosition(JLabel.CENTER);
        buttonAnthonyMachopL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAnthonyMachopL11.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/machop.png"));
        buttonAnthonyMachopL11.setBounds(1111,228,77,52);
        buttonAnthonyMachopL11.setMargin(new Insets(1,0,1,0));
        buttonAnthonyMachopL11.setFont(new Font(this.font, 1, 12));
        buttonAnthonyMachopL11.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.MACHOP, 11, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.MACHOP, 1);
                DVCalculatorPanel.this.buttonAnthonyMachopL11.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonAnthonyMachopL11);
        JLabel labelGrunt1 = new JLabel("GRUNT 1");
        labelGrunt1.setBounds(965,295,124,24);
        labelGrunt1.setFont(new Font(this.font,1,13));
        this.add(labelGrunt1);
        buttonGrunt1RattataL9_1 = new JButton("L9");
        buttonGrunt1RattataL9_1.setVerticalAlignment(JLabel.CENTER);
        buttonGrunt1RattataL9_1.setVerticalTextPosition(JLabel.CENTER);
        buttonGrunt1RattataL9_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGrunt1RattataL9_1.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/rattata.png"));
        buttonGrunt1RattataL9_1.setBounds(1036,280,77,52);
        buttonGrunt1RattataL9_1.setMargin(new Insets(1,0,1,0));
        buttonGrunt1RattataL9_1.setFont(new Font(this.font, 1, 12));
        buttonGrunt1RattataL9_1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 9, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                DVCalculatorPanel.this.buttonGrunt1RattataL9_1.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonGrunt1RattataL9_1);
        buttonGrunt1RattataL9_2 = new JButton("L9");
        buttonGrunt1RattataL9_2.setVerticalAlignment(JLabel.CENTER);
        buttonGrunt1RattataL9_2.setVerticalTextPosition(JLabel.CENTER);
        buttonGrunt1RattataL9_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGrunt1RattataL9_2.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/rattata.png"));
        buttonGrunt1RattataL9_2.setBounds(1111,280,77,52);
        buttonGrunt1RattataL9_2.setMargin(new Insets(1,0,1,0));
        buttonGrunt1RattataL9_2.setFont(new Font(this.font, 1, 12));
        buttonGrunt1RattataL9_2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 9, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                DVCalculatorPanel.this.buttonGrunt1RattataL9_2.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonGrunt1RattataL9_2);
        JLabel labelGrunt2 = new JLabel("GRUNT 2");
        labelGrunt2.setBounds(965,347,124,24);
        labelGrunt2.setFont(new Font(this.font,1,13));
        this.add(labelGrunt2);
        buttonGrunt2ZubatL9 = new JButton("L9");
        buttonGrunt2ZubatL9.setVerticalAlignment(JLabel.CENTER);
        buttonGrunt2ZubatL9.setVerticalTextPosition(JLabel.CENTER);
        buttonGrunt2ZubatL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGrunt2ZubatL9.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/zubat.png"));
        buttonGrunt2ZubatL9.setBounds(1036,332,77,52);
        buttonGrunt2ZubatL9.setMargin(new Insets(1,0,1,0));
        buttonGrunt2ZubatL9.setFont(new Font(this.font, 1, 12));
        buttonGrunt2ZubatL9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ZUBAT, 9, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ZUBAT, 1);
                DVCalculatorPanel.this.buttonGrunt2ZubatL9.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonGrunt2ZubatL9);
        buttonGrunt2EkansL11 = new JButton("L11");
        buttonGrunt2EkansL11.setVerticalAlignment(JLabel.CENTER);
        buttonGrunt2EkansL11.setVerticalTextPosition(JLabel.CENTER);
        buttonGrunt2EkansL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGrunt2EkansL11.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/ekans.png"));
        buttonGrunt2EkansL11.setBounds(1111,332,77,52);
        buttonGrunt2EkansL11.setMargin(new Insets(1,0,1,0));
        buttonGrunt2EkansL11.setFont(new Font(this.font, 1, 12));
        buttonGrunt2EkansL11.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.EKANS, 11, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.EKANS, 1);
                DVCalculatorPanel.this.buttonGrunt2EkansL11.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonGrunt2EkansL11);
        JLabel labelGrunt3 = new JLabel("GRUNT 3");
        labelGrunt3.setBounds(965,399,124,24);
        labelGrunt3.setFont(new Font(this.font,1,13));
        this.add(labelGrunt3);
        buttonGrunt3RattataL7 = new JButton("L7");
        buttonGrunt3RattataL7.setVerticalAlignment(JLabel.CENTER);
        buttonGrunt3RattataL7.setVerticalTextPosition(JLabel.CENTER);
        buttonGrunt3RattataL7.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGrunt3RattataL7.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/rattata.png"));
        buttonGrunt3RattataL7.setBounds(1036,384,77,52);
        buttonGrunt3RattataL7.setMargin(new Insets(1,0,1,0));
        buttonGrunt3RattataL7.setFont(new Font(this.font, 1, 12));
        buttonGrunt3RattataL7.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 7, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                DVCalculatorPanel.this.buttonGrunt3RattataL7.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonGrunt3RattataL7);
        buttonGrunt3ZubatL9_1 = new JButton("L9");
        buttonGrunt3ZubatL9_1.setVerticalAlignment(JLabel.CENTER);
        buttonGrunt3ZubatL9_1.setVerticalTextPosition(JLabel.CENTER);
        buttonGrunt3ZubatL9_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGrunt3ZubatL9_1.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/zubat.png"));
        buttonGrunt3ZubatL9_1.setBounds(1111,384,77,52);
        buttonGrunt3ZubatL9_1.setMargin(new Insets(1,0,1,0));
        buttonGrunt3ZubatL9_1.setFont(new Font(this.font, 1, 12));
        buttonGrunt3ZubatL9_1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ZUBAT, 9, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ZUBAT, 1);
                DVCalculatorPanel.this.buttonGrunt3ZubatL9_1.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonGrunt3ZubatL9_1);
        buttonGrunt3ZubatL9_2 = new JButton("L9");
        buttonGrunt3ZubatL9_2.setVerticalAlignment(JLabel.CENTER);
        buttonGrunt3ZubatL9_2.setVerticalTextPosition(JLabel.CENTER);
        buttonGrunt3ZubatL9_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGrunt3ZubatL9_2.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/zubat.png"));
        buttonGrunt3ZubatL9_2.setBounds(1186,384,77,52);
        buttonGrunt3ZubatL9_2.setMargin(new Insets(1,0,1,0));
        buttonGrunt3ZubatL9_2.setFont(new Font(this.font, 1, 12));
        buttonGrunt3ZubatL9_2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ZUBAT, 9, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ZUBAT, 1);
                DVCalculatorPanel.this.buttonGrunt3ZubatL9_2.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonGrunt3ZubatL9_2);
        JLabel labelGrunt4 = new JLabel("GRUNT 4");
        labelGrunt4.setBounds(965,451,124,24);
        labelGrunt4.setFont(new Font(this.font,1,13));
        this.add(labelGrunt4);
        buttonGrunt4KoffingL14 = new JButton("L14");
        buttonGrunt4KoffingL14.setVerticalAlignment(JLabel.CENTER);
        buttonGrunt4KoffingL14.setVerticalTextPosition(JLabel.CENTER);
        buttonGrunt4KoffingL14.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGrunt4KoffingL14.setIcon(new ImageIcon(String.valueOf(this.getExecutionPath()) + "/resources/koffing.png"));
        buttonGrunt4KoffingL14.setBounds(1036,436,77,52);
        buttonGrunt4KoffingL14.setMargin(new Insets(1,0,1,0));
        buttonGrunt4KoffingL14.setFont(new Font(this.font, 1, 12));
        buttonGrunt4KoffingL14.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                DVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.KOFFING, 14, false));
                DVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.KOFFING, 1);
                DVCalculatorPanel.this.buttonGrunt4KoffingL14.setEnabled(false);
                while(lowestExpForLevel(DVCalculatorPanel.this.level + 1) <= exp) {
                    DVCalculatorPanel.this.level++;
                    DVCalculatorPanel.this.hp_ev_used = DVCalculatorPanel.this.hpStatExp;
                    DVCalculatorPanel.this.atk_ev_used = DVCalculatorPanel.this.atkStatExp;
                    DVCalculatorPanel.this.def_ev_used = DVCalculatorPanel.this.defStatExp;
                    DVCalculatorPanel.this.spc_ev_used = DVCalculatorPanel.this.spcStatExp;
                    DVCalculatorPanel.this.spd_ev_used = DVCalculatorPanel.this.spdStatExp;
                    DVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonGrunt4KoffingL14);
    }

    private void initStatButtons() {
        double extraStats;
        int i;
        Stat stat;
        double statValue;
        this.hpStats = new ArrayList();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.hpStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.hpStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseHP + i + 50) * 2) + extraStats) * (double)this.level / 100.0 + 10.0);
            stat = new Stat(Column.HP, "" + i, (int)statValue, 30, 33 + i * 23);
            this.hpStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.atkStats = new ArrayList();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.atkStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.atkStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseAtk + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            stat = new Stat(Column.ATK, "" + i, (int)statValue, 120, 33 + i * 23);
            this.atkStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.defStats = new ArrayList();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.defStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.defStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseDef + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            stat = new Stat(Column.DEF, "" + i, (int)statValue, 210, 33 + i * 23);
            this.defStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.spdStats = new ArrayList();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.spdStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.spdStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseSpe + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            stat = new Stat(Column.SPD, "" + i, (int)statValue, 300, 33 + i * 23);
            this.spdStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.spcStats = new ArrayList();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.spcStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.spcStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseSpA + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            double spcDefValue = Math.floor(((double)((this.baseSpD + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            stat = new Stat(Column.SPC, "" + i, (int)statValue*(int)spcDefValue, 390, 33 + i * 23);
            this.spcStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
    }

    private void initPokemon() {
        this.pokedex = new ArrayList();
        FileInputStream fis = null;
        BufferedReader br = null;
        int lineNr = 0;
        int pokedexEntry = 0;
        try {
            try {
                File f = new File(String.valueOf(this.parent.getExecutionPath()) + "/resources/pokemon.txt");
                fis = new FileInputStream(f);
                br = new BufferedReader(new InputStreamReader(fis));
                String line = br.readLine();
                while (line != null) {
                    ++lineNr;
                    if (!line.equals("") && !line.substring(0, 2).equals("//")) {
                        String[] s = line.split(";");
                        Pokemon poke = new Pokemon(Pokemon.Pkmn.values()[pokedexEntry], s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6]));
                        this.pokedex.add(poke);
                        ++pokedexEntry;
                    }
                    line = br.readLine();
                }
                return;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                try {
                    br.close();
                    fis.close();
                    return;
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
                return;
            }
            catch (IOException e) {
                e.printStackTrace();
                try {
                    br.close();
                    fis.close();
                    return;
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
                return;
            }
            catch (Exception e) {
                System.out.println("Syntax error in pokemon.txt on line: " + lineNr);
                e.printStackTrace();

                try {
                    br.close();
                    fis.close();
                    return;
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
                return;
            }
        }
        finally {
            try {
                br.close();
                fis.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateStats() {
        double extraStats;
        int i;
        double statValue;
        this.labelTotoLevel.setText("Level: " + level);

        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.hpStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.hpStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseHP + i + 50) * 2) + extraStats) * (double)this.level / 100.0 + 10.0);
            this.hpStats.get((int)i).button.setText("" + (int)statValue);
            this.hpStats.get((int)i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.atkStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.atkStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseAtk + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            this.atkStats.get((int)i).button.setText("" + (int)statValue);
            this.atkStats.get((int)i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.defStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.defStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseDef + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            this.defStats.get((int)i).button.setText("" + (int)statValue);
            this.defStats.get((int)i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.spdStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.spdStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseSpe + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            this.spdStats.get((int)i).button.setText("" + (int)statValue);
            this.spdStats.get((int)i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (this.spcStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(this.spcStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((this.baseSpA + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            double spcDefValue = Math.floor(((double)((this.baseSpD + i) * 2) + extraStats) * (double)this.level / 100.0 + 5.0);
            this.spcStats.get((int)i).button.setText("" + (int)statValue + "/" + (int)spcDefValue);
            this.spcStats.get((int)i).value = (int)statValue*(int)spcDefValue;
        }
    }

    private void updateButtons(Column column, int value) {
        Stat stat;
        int i;
        if (column == Column.ATK) {
            for (i = 0; i < 16; ++i) {
                stat = this.atkStats.get(i);
                if (!stat.possible || value == stat.value) continue;
                this.redAtk[i] = true;
                stat.possible = false;
                stat.label.setVisible(false);
                stat.button.setVisible(false);
            }
            if (!this.hasEven(this.atkStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i] = true;
                    stat = this.hpStats.get(i);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
            if (!this.hasOdd(this.atkStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i + 8] = true;
                    stat = this.hpStats.get(i + 8);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
        }
        if (column == Column.DEF) {
            for (i = 0; i < 16; ++i) {
                stat = this.defStats.get(i);
                if (!stat.possible || value == stat.value) continue;
                this.redDef[i] = true;
                stat.possible = false;
                stat.label.setVisible(false);
                stat.button.setVisible(false);
            }
            if (!this.hasEven(this.defStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i / 4 * 8 + i % 4] = true;
                    stat = this.hpStats.get(i / 4 * 8 + i % 4);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
            if (!this.hasOdd(this.defStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i / 4 * 8 + i % 4 + 4] = true;
                    stat = this.hpStats.get(i / 4 * 8 + i % 4 + 4);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
        }
        if (column == Column.SPD) {
            for (i = 0; i < 16; ++i) {
                stat = this.spdStats.get(i);
                if (!stat.possible || value == stat.value) continue;
                this.redSpd[i] = true;
                stat.possible = false;
                stat.label.setVisible(false);
                stat.button.setVisible(false);
            }
            if (!this.hasEven(this.spdStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i / 2 * 4 + i % 2] = true;
                    stat = this.hpStats.get(i / 2 * 4 + i % 2);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
            if (!this.hasOdd(this.spdStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i / 2 * 4 + i % 2 + 2] = true;
                    stat = this.hpStats.get(i / 2 * 4 + i % 2 + 2);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
        }
        if (column == Column.SPC) {
            for (i = 0; i < 16; ++i) {
                stat = this.spcStats.get(i);
                if (!stat.possible || value == stat.value) continue;
                this.redSpc[i] = true;
                stat.possible = false;
                stat.label.setVisible(false);
                stat.button.setVisible(false);
            }
            if (!this.hasEven(this.spcStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i * 2 + i % 1] = true;
                    stat = this.hpStats.get(i * 2 + i % 1);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
            if (!this.hasOdd(this.spcStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i * 2 + i % 1 + 1] = true;
                    stat = this.hpStats.get(i * 2 + i % 1 + 1);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
        }
        if (column == Column.HP) {
            Stat stat2;
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
                if (!stat2.possible) continue;
                if (value != stat2.value) {
                    this.redHP[i2] = true;
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
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
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
                }
            }
            if (removeOddAtk) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redAtk[i2 * 2 + 1] = true;
                    stat2 = this.atkStats.get(i2 * 2 + 1);
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
                }
            }
            if (removeEvenDef) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redDef[i2 * 2] = true;
                    stat2 = this.defStats.get(i2 * 2);
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
                }
            }
            if (removeOddDef) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redDef[i2 * 2 + 1] = true;
                    stat2 = this.defStats.get(i2 * 2 + 1);
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
                }
            }
            if (removeEvenSpd) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redSpd[i2 * 2] = true;
                    stat2 = this.spdStats.get(i2 * 2);
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
                }
            }
            if (removeOddSpd) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redSpd[i2 * 2 + 1] = true;
                    stat2 = this.spdStats.get(i2 * 2 + 1);
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
                }
            }
            if (removeEvenSpc) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redSpc[i2 * 2] = true;
                    stat2 = this.spcStats.get(i2 * 2);
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
                }
            }
            if (removeOddSpc) {
                for (i2 = 0; i2 < 8; ++i2) {
                    this.redSpc[i2 * 2 + 1] = true;
                    stat2 = this.spcStats.get(i2 * 2 + 1);
                    stat2.possible = false;
                    stat2.label.setVisible(false);
                    stat2.button.setVisible(false);
                }
            }
        }
        this.parent.updateDVPanel(this.redHP, this.redAtk, this.redDef, this.redSpd, this.redSpc);
    }

    private boolean hasEven(ArrayList<Stat> list) {
        boolean even = false;
        for (int i = 0; i < 8; ++i) {
            if (!list.get((int)(i * 2)).possible) continue;
            even = true;
            break;
        }
        return even;
    }

    private boolean hasOdd(ArrayList<Stat> list) {
        boolean odd = false;
        for (int i = 0; i < 8; ++i) {
            if (!list.get((int)(i * 2 + 1)).possible) continue;
            odd = true;
            break;
        }
        return odd;
    }

    private void addStatExp(Pokemon.Pkmn name, int nrOfPokemon) {
        Pokemon poke = this.pokedex.get(name.ordinal());
        this.hpStatExp += (int)Math.floor(poke.hp / nrOfPokemon);
        this.atkStatExp += (int)Math.floor(poke.atk / nrOfPokemon);
        this.defStatExp += (int)Math.floor(poke.def / nrOfPokemon);
        this.spdStatExp += (int)Math.floor(poke.spd / nrOfPokemon);
        this.spcStatExp += (int)Math.floor(poke.spc / nrOfPokemon);
    }

    public void removeStat(int column, int index) {
        if (column == 0) {
            this.hpStats.get((int)index).possible = false;
            this.hpStats.get((int)index).button.setVisible(false);
            this.hpStats.get((int)index).label.setVisible(false);
        } else if (column == 1) {
            this.atkStats.get((int)index).possible = false;
            this.atkStats.get((int)index).button.setVisible(false);
            this.atkStats.get((int)index).label.setVisible(false);
        } else if (column == 2) {
            this.defStats.get((int)index).possible = false;
            this.defStats.get((int)index).button.setVisible(false);
            this.defStats.get((int)index).label.setVisible(false);
        } else if (column == 3) {
            this.spdStats.get((int)index).possible = false;
            this.spdStats.get((int)index).button.setVisible(false);
            this.spdStats.get((int)index).label.setVisible(false);
        } else if (column == 4) {
            this.spcStats.get((int)index).possible = false;
            this.spcStats.get((int)index).button.setVisible(false);
            this.spcStats.get((int)index).label.setVisible(false);
        }
    }

    public void reset() {
        int i;
        this.level = 5;
        this.exp = lowestExpForLevel(5);
        this.hpStatExp = 0;
        this.atkStatExp = 0;
        this.defStatExp = 0;
        this.spdStatExp = 0;
        this.spcStatExp = 0;
        this.hp_ev_used = 0;
        this.atk_ev_used = 0;
        this.def_ev_used = 0;
        this.spc_ev_used = 0;
        this.spd_ev_used = 0;
        this.labelTotoLevel.setText("Level: " + this.level);
        baseHP = 50;
        baseAtk = 65;
        baseDef = 64;
        baseSpA = 44;
        baseSpD = 48;
        baseSpe = 43;
        this.stage = 0;
        this.labelPidgeyAmount.setText("×0");
        this.labelSentretAmount.setText("×0");
        this.labelRattataAmount.setText("×0");
        this.labelCaterpieAmount.setText("×0");
        this.labelGeodudeAmount.setText("×0");
        this.labelSandshrewAmount.setText("×0");
        this.labelOnixAmount.setText("×0");
        this.labelZubatAmount.setText("×0");
        buttonRivalChikoritaL5.setEnabled(true);
        buttonMikeyPidgeyL2.setEnabled(true);
        buttonMikeyRattataL4.setEnabled(true);
        buttonDonCaterpieL3_1.setEnabled(true);
        buttonDonCaterpieL3_2.setEnabled(true);
        buttonAbeSpearowL9.setEnabled(true);
        buttonRodPidgeyL7_1.setEnabled(true);
        buttonRodPidgeyL7_2.setEnabled(true);
        buttonFalknerPidgeyL7.setEnabled(true);
        buttonFalknerPidgeottoL9.setEnabled(true);
        buttonAlbertRattataL6.setEnabled(true);
        buttonAlbertZubatL8.setEnabled(true);
        buttonRalphGoldeenL10.setEnabled(true);
        buttonDanielOnixL11.setEnabled(true);
        buttonRussellGeodudeL4.setEnabled(true);
        buttonRussellGeodudeL6.setEnabled(true);
        buttonRussellGeodudeL8.setEnabled(true);
        buttonBillKoffingL6_1.setEnabled(true);
        buttonBillKoffingL6_2.setEnabled(true);
        buttonRayVulpixL9.setEnabled(true);
        buttonAnthonyGeodudeL11.setEnabled(true);
        buttonAnthonyMachopL11.setEnabled(true);
        buttonGrunt1RattataL9_1.setEnabled(true);
        buttonGrunt1RattataL9_2.setEnabled(true);
        buttonGrunt2ZubatL9.setEnabled(true);
        buttonGrunt2EkansL11.setEnabled(true);
        buttonGrunt3RattataL7.setEnabled(true);
        buttonGrunt3ZubatL9_1.setEnabled(true);
        buttonGrunt3ZubatL9_2.setEnabled(true);
        buttonGrunt4KoffingL14.setEnabled(true);
        for (i = 0; i < 16; ++i) {
            this.hpStats.get((int)i).possible = true;
            this.hpStats.get((int)i).label.setVisible(true);
            this.hpStats.get((int)i).button.setVisible(true);
            this.atkStats.get((int)i).possible = true;
            this.atkStats.get((int)i).label.setVisible(true);
            this.atkStats.get((int)i).button.setVisible(true);
            this.defStats.get((int)i).possible = true;
            this.defStats.get((int)i).label.setVisible(true);
            this.defStats.get((int)i).button.setVisible(true);
            this.spdStats.get((int)i).possible = true;
            this.spdStats.get((int)i).label.setVisible(true);
            this.spdStats.get((int)i).button.setVisible(true);
            this.spcStats.get((int)i).possible = true;
            this.spcStats.get((int)i).label.setVisible(true);
            this.spcStats.get((int)i).button.setVisible(true);
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
/*
    public void setInternational(boolean international) {
        if (international) {
            this.buttonNidoPlus.setLocation(620, 70);
            this.buttonPidgeyL2.setLocation(480, 210);
            this.buttonSpearowPlus.setLocation(480, 250);
            this.buttonGeodudePlus.setLocation(480, 290);
            this.buttonClefairyPlus.setLocation(480, 330);
            this.buttonNidoMin.setLocation(655, 70);
            this.buttonPidgeyMin.setLocation(505, 210);
            this.buttonSpearowMin.setLocation(505, 250);
            this.buttonGeodudeMin.setLocation(505, 290);
            this.buttonClefairyMin.setLocation(505, 330);
        } else {
            this.buttonNidoMin.setLocation(620, 70);
            this.buttonSpearowMin.setLocation(480, 210);
            this.buttonPidgeyMin.setLocation(480, 250);
            this.buttonGeodudeMin.setLocation(480, 290);
            this.buttonClefairyMin.setLocation(480, 330);
            this.buttonNidoPlus.setLocation(655, 70);
            this.buttonSpearowPlus.setLocation(505, 210);
            this.buttonPidgeyL2.setLocation(505, 250);
            this.buttonGeodudePlus.setLocation(505, 290);
            this.buttonClefairyPlus.setLocation(505, 330);
        }

    }*/

    static /* synthetic */ void access$3(DVCalculatorPanel dVCalculatorPanel, int n) {
        dVCalculatorPanel.level = n;
    }

    static /* synthetic */ void access$6(DVCalculatorPanel dVCalculatorPanel, int n) {
        dVCalculatorPanel.stage = n;
    }

    static /* synthetic */ void access$9(DVCalculatorPanel dVCalculatorPanel, int n) {
        dVCalculatorPanel.baseHP = n;
    }

    static /* synthetic */ void access$10(DVCalculatorPanel dVCalculatorPanel, int n) {
        dVCalculatorPanel.baseAtk = n;
    }

    static /* synthetic */ void access$11(DVCalculatorPanel dVCalculatorPanel, int n) {
        dVCalculatorPanel.baseDef = n;
    }

    static /* synthetic */ void access$12(DVCalculatorPanel dVCalculatorPanel, int n) {
        dVCalculatorPanel.baseSpe = n;
    }

    static /* synthetic */ void access$13(DVCalculatorPanel dVCalculatorPanel, int n) {
        dVCalculatorPanel.baseSpA = n;
    }

    public static enum Column {
        HP,
        ATK,
        DEF,
        SPD,
        SPC;
    }

    class Stat {
        public int value;
        public JButton button;
        public JLabel label;
        public Column column;
        public boolean possible;

        public Stat(Column column, String dv, int value, int x, int y) {
            this.possible = true;
            this.column = column;
            this.value = value;
            this.label = new JLabel(dv);
            this.label.setBounds(x - 29, y + 79, 22, 22);
            this.label.setFont(new Font(DVCalculatorPanel.this.font, 1, 12));
            this.label.setHorizontalAlignment(4);
            this.makeButton("" + value, x - 6, y + 79);
        }

        private void makeButton(String text, int x, int y) {
            this.button = new JButton(text);
            this.button.setBounds(x, y, 50, 22);
            this.button.setFont(new Font(DVCalculatorPanel.this.font, 1, 14));
            this.button.setMargin(new Insets(1, 0, 1, 0));
            this.button.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent evt) {
                	DVCalculatorPanel.this.updateButtons(column, value);
                }
            });
        }

    }

}

