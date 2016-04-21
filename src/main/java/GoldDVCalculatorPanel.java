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

public class GoldDVCalculatorPanel extends GSCDVCalculatorPanel {
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
    private JLabel labelTotoLevel;
    private JLabel labelSentretAmount;
    private JLabel labelPidgeyAmount;
    private JLabel labelRattataAmount;
    private JLabel labelCaterpieAmount;
    private JLabel labelHoppipAmount;
    private JButton buttonPidgeyL2;
    private JButton buttonPidgeyL3;
    private JButton buttonPidgeyL4;
    private JButton buttonSentretL2;
    private JButton buttonSentretL3;
    private JButton buttonRattataL4;
    private JButton buttonCaterpieL3;
    private JButton buttonCaterpieL4;
    private JButton buttonHoppipL6;

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

    public static int lowestExpForLevel(int n) {
        return 6*n*n*n/5 - 15*n*n + 100*n - 140;
    }
    
	public int expGiven(FoePokemon foe) {
		return (pokedex.get(foe.poke.ordinal()).expGiven) * foe.level / 7 * 3
                / (foe.isWild ? 3 : 2);
	}

    public GoldDVCalculatorPanel(HelperFrame parent, String font) {
        super(parent);
        this.parent = parent;
        this.font = font;
        this.setLayout(null);
        this.setBounds(0, 0, 792, 594);
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
        labelHP.setBounds(14, 51, 70, 50);
        labelHP.setFont(new Font(this.font, 1, 19));
        labelHP.setHorizontalAlignment(0);
        this.add(labelHP);
        JLabel labelAtk = new JLabel("Atk");
        labelAtk.setBounds(104, 51, 70, 50);
        labelAtk.setFont(new Font(this.font, 1, 19));
        labelAtk.setHorizontalAlignment(0);
        this.add(labelAtk);
        JLabel labelDef = new JLabel("Def");
        labelDef.setBounds(194, 51, 70, 50);
        labelDef.setFont(new Font(this.font, 1, 19));
        labelDef.setHorizontalAlignment(0);
        this.add(labelDef);
        JLabel labelSpd = new JLabel("Spd");
        labelSpd.setBounds(374, 51, 70, 50);
        labelSpd.setFont(new Font(this.font, 1, 19));
        labelSpd.setHorizontalAlignment(0);
        this.add(labelSpd);
        JLabel labelSpc = new JLabel("Spc");
        labelSpc.setBounds(284, 51, 70, 50);
        labelSpc.setFont(new Font(this.font, 1, 19));
        labelSpc.setHorizontalAlignment(0);
        this.add(labelSpc);
        JLabel labelTotoIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/totodile.png")));
        labelTotoIcon.setBounds(134, 4, 48, 48);
        this.add(labelTotoIcon);
        this.labelTotoLevel = new JLabel("Level: " + this.level);
        this.labelTotoLevel.setBounds(196,4,150,48);
        this.labelTotoLevel.setFont(new Font(this.font,1,29));
        this.add(this.labelTotoLevel);

        JLabel labelWild = new JLabel("Wild Pokes");
        labelWild.setBounds(155,459,190,42);
        labelWild.setFont(new Font(this.font,1,29));
        this.add(labelWild);
        this.labelPidgeyAmount = new JLabel("×0");
        this.labelPidgeyAmount.setBounds(145, 512, 50, 24);
        this.labelPidgeyAmount.setFont(new Font(this.font, 1, 20));
        this.add(this.labelPidgeyAmount);
        JLabel labelPidgeyIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        labelPidgeyIcon.setBounds(102, 503, 40, 40);
        this.add(labelPidgeyIcon);
        this.buttonPidgeyL2 = new JButton("L2");
        this.buttonPidgeyL2.setBounds(14, 509, 26, 26);
        this.buttonPidgeyL2.setMargin(new Insets(1, 1, 1, 1));
        this.buttonPidgeyL2.setFont(new Font(this.font, 1, 14));
        this.buttonPidgeyL2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelPidgeyAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelPidgeyAmount.setText("×" + ++amount);
            	GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 2, true));
            	GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
            	while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
            		GoldDVCalculatorPanel.this.level++;
            		GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
            		GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
            		GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
            		GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
            		GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
            		GoldDVCalculatorPanel.this.updateStats();
            	}
            }
        });
        this.add(this.buttonPidgeyL2);
        this.buttonPidgeyL3 = new JButton("L3");
        this.buttonPidgeyL3.setBounds(42, 509, 26, 26);
        this.buttonPidgeyL3.setMargin(new Insets(1, 1, 1, 1));
        this.buttonPidgeyL3.setFont(new Font(this.font, 1, 14));
        this.buttonPidgeyL3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelPidgeyAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelPidgeyAmount.setText("×" + ++amount);
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 3, true));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonPidgeyL3);
        this.buttonPidgeyL4 = new JButton("L4");
        this.buttonPidgeyL4.setBounds(70, 509, 26, 26);
        this.buttonPidgeyL4.setMargin(new Insets(1, 1, 1, 1));
        this.buttonPidgeyL4.setFont(new Font(this.font, 1, 14));
        this.buttonPidgeyL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelPidgeyAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelPidgeyAmount.setText("×" + ++amount);
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 4, true));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonPidgeyL4);
        this.labelSentretAmount = new JLabel("×0");
        this.labelSentretAmount.setBounds(145, 558, 50, 24);
        this.labelSentretAmount.setFont(new Font(this.font, 1, 20));
        this.add(this.labelSentretAmount);
        JLabel labelSentretIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/sentret.png")));
        labelSentretIcon.setBounds(102, 549, 40, 40);
        this.add(labelSentretIcon);
        this.buttonSentretL2 = new JButton("L2");
        this.buttonSentretL2.setBounds(14, 555, 26, 26);
        this.buttonSentretL2.setMargin(new Insets(1, 1, 1, 1));
        this.buttonSentretL2.setFont(new Font(this.font, 1, 14));
        this.buttonSentretL2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelSentretAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelSentretAmount.setText("×" + ++amount);
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.SENTRET, 2, true));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.SENTRET, 1);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonSentretL2);
        this.buttonSentretL3 = new JButton("L3");
        this.buttonSentretL3.setBounds(42, 555, 26, 26);
        this.buttonSentretL3.setMargin(new Insets(1, 1, 1, 1));
        this.buttonSentretL3.setFont(new Font(this.font, 1, 14));
        this.buttonSentretL3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelSentretAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelSentretAmount.setText("×" + ++amount);
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.SENTRET, 3, true));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.SENTRET, 1);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonSentretL3);
        this.labelRattataAmount = new JLabel("×0");
        this.labelRattataAmount.setBounds(292, 512, 50, 24);
        this.labelRattataAmount.setFont(new Font(this.font, 1, 20));
        this.add(this.labelRattataAmount);
        JLabel labelRattataIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/rattata.png")));
        labelRattataIcon.setBounds(249, 503, 40, 40);
        this.add(labelRattataIcon);
        this.buttonRattataL4 = new JButton("L4");
        this.buttonRattataL4.setBounds(217, 509, 26, 26);
        this.buttonRattataL4.setMargin(new Insets(1, 1, 1, 1));
        this.buttonRattataL4.setFont(new Font(this.font, 1, 14));
        this.buttonRattataL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelRattataAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelRattataAmount.setText("×" + ++amount);
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 4, true));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonRattataL4);
        this.labelCaterpieAmount = new JLabel("×0");
        this.labelCaterpieAmount.setBounds(292, 558, 50, 24);
        this.labelCaterpieAmount.setFont(new Font(this.font, 1, 20));
        this.add(this.labelCaterpieAmount);
        JLabel labelCaterpieIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/caterpie.png")));
        labelCaterpieIcon.setBounds(249, 549, 40, 40);
        this.add(labelCaterpieIcon);
        this.buttonCaterpieL3 = new JButton("L3");
        this.buttonCaterpieL3.setBounds(189, 555, 26, 26);
        this.buttonCaterpieL3.setMargin(new Insets(1, 1, 1, 1));
        this.buttonCaterpieL3.setFont(new Font(this.font, 1, 14));
        this.buttonCaterpieL3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelCaterpieAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelCaterpieAmount.setText("×" + ++amount);
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CATERPIE, 3, true));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CATERPIE, 1);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonCaterpieL3);
        this.buttonCaterpieL4 = new JButton("L4");
        this.buttonCaterpieL4.setBounds(217, 555, 26, 26);
        this.buttonCaterpieL4.setMargin(new Insets(1, 1, 1, 1));
        this.buttonCaterpieL4.setFont(new Font(this.font, 1, 14));
        this.buttonCaterpieL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelCaterpieAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelCaterpieAmount.setText("×" + ++amount);
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CATERPIE, 4, true));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CATERPIE, 1);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonCaterpieL4);
        this.labelHoppipAmount = new JLabel("×0");
        this.labelHoppipAmount.setBounds(411, 512, 50, 24);
        this.labelHoppipAmount.setFont(new Font(this.font, 1, 20));
        this.add(this.labelHoppipAmount);
        JLabel labelHoppipIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/hoppip.png")));
        labelHoppipIcon.setBounds(368, 503, 40, 40);
        this.add(labelHoppipIcon);
        this.buttonHoppipL6 = new JButton("L6");
        this.buttonHoppipL6.setBounds(336, 509, 26, 26);
        this.buttonHoppipL6.setMargin(new Insets(1, 1, 1, 1));
        this.buttonHoppipL6.setFont(new Font(this.font, 1, 14));
        this.buttonHoppipL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                int amount = Integer.parseInt(GoldDVCalculatorPanel.this.labelHoppipAmount.getText().substring(1));
                GoldDVCalculatorPanel.this.labelHoppipAmount.setText("×" + ++amount);
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.HOPPIP, 6, true));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.HOPPIP, 1);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(this.buttonHoppipL6);

        JLabel labelTrainers = new JLabel("Trainers");
        labelTrainers.setBounds(498,4,150,48);
        labelTrainers.setFont(new Font(this.font,1,29));
        this.add(labelTrainers);
        JLabel labelRival = new JLabel("RIVAL 1");
        labelRival.setBounds(501,75,124,24);
        labelRival.setFont(new Font(this.font,1,11));
        this.add(labelRival);
        buttonRivalChikoritaL5 = new JButton("L5");
        buttonRivalChikoritaL5.setVerticalAlignment(JLabel.CENTER);
        buttonRivalChikoritaL5.setVerticalTextPosition(JLabel.CENTER);
        buttonRivalChikoritaL5.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRivalChikoritaL5.setIcon(new ImageIcon(getClass().getResource("/gold/chikorita.png")));
        buttonRivalChikoritaL5.setBounds(566,62,73,50);
        buttonRivalChikoritaL5.setMargin(new Insets(1,0,1,0));
        buttonRivalChikoritaL5.setFont(new Font(this.font, 1, 12));
        buttonRivalChikoritaL5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CHIKORITA, 5, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CHIKORITA, 1);
                GoldDVCalculatorPanel.this.buttonRivalChikoritaL5.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRivalChikoritaL5);
        JLabel labelMikey = new JLabel("MIKEY");
        labelMikey.setBounds(501,127,124,24);
        labelMikey.setFont(new Font(this.font,1,11));
        this.add(labelMikey);
        buttonMikeyPidgeyL2 = new JButton("L2");
        buttonMikeyPidgeyL2.setVerticalAlignment(JLabel.CENTER);
        buttonMikeyPidgeyL2.setVerticalTextPosition(JLabel.CENTER);
        buttonMikeyPidgeyL2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonMikeyPidgeyL2.setIcon(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        buttonMikeyPidgeyL2.setBounds(566,114,73,50);
        buttonMikeyPidgeyL2.setMargin(new Insets(1,0,1,0));
        buttonMikeyPidgeyL2.setFont(new Font(this.font, 1, 12));
        buttonMikeyPidgeyL2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 2, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                GoldDVCalculatorPanel.this.buttonMikeyPidgeyL2.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonMikeyPidgeyL2);
        buttonMikeyRattataL4 = new JButton("L4");
        buttonMikeyRattataL4.setVerticalAlignment(JLabel.CENTER);
        buttonMikeyRattataL4.setVerticalTextPosition(JLabel.CENTER);
        buttonMikeyRattataL4.setHorizontalTextPosition(JLabel.RIGHT);
        buttonMikeyRattataL4.setIcon(new ImageIcon(getClass().getResource("/gold/rattata.png")));
        buttonMikeyRattataL4.setBounds(639,114,73,50);
        buttonMikeyRattataL4.setMargin(new Insets(1,0,1,0));
        buttonMikeyRattataL4.setFont(new Font(this.font, 1, 12));
        buttonMikeyRattataL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 4, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                GoldDVCalculatorPanel.this.buttonMikeyRattataL4.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonMikeyRattataL4);
        JLabel labelDon = new JLabel("DON");
        labelDon.setBounds(501,179,124,24);
        labelDon.setFont(new Font(this.font,1,11));
        this.add(labelDon);
        buttonDonCaterpieL3_1 = new JButton("L3");
        buttonDonCaterpieL3_1.setVerticalAlignment(JLabel.CENTER);
        buttonDonCaterpieL3_1.setVerticalTextPosition(JLabel.CENTER);
        buttonDonCaterpieL3_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDonCaterpieL3_1.setIcon(new ImageIcon(getClass().getResource("/gold/caterpie.png")));
        buttonDonCaterpieL3_1.setBounds(566,166,73,50);
        buttonDonCaterpieL3_1.setMargin(new Insets(1,0,1,0));
        buttonDonCaterpieL3_1.setFont(new Font(this.font, 1, 12));
        buttonDonCaterpieL3_1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CATERPIE, 3, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CATERPIE, 1);
                GoldDVCalculatorPanel.this.buttonDonCaterpieL3_1.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonDonCaterpieL3_1);
        buttonDonCaterpieL3_2 = new JButton("L3");
        buttonDonCaterpieL3_2.setVerticalAlignment(JLabel.CENTER);
        buttonDonCaterpieL3_2.setVerticalTextPosition(JLabel.CENTER);
        buttonDonCaterpieL3_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDonCaterpieL3_2.setIcon(new ImageIcon(getClass().getResource("/gold/caterpie.png")));
        buttonDonCaterpieL3_2.setBounds(639,166,73,50);
        buttonDonCaterpieL3_2.setMargin(new Insets(1,0,1,0));
        buttonDonCaterpieL3_2.setFont(new Font(this.font, 1, 12));
        buttonDonCaterpieL3_2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.CATERPIE, 3, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.CATERPIE, 1);
                GoldDVCalculatorPanel.this.buttonDonCaterpieL3_2.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonDonCaterpieL3_2);
        JLabel labelAbe = new JLabel("ABE");
        labelAbe.setBounds(501,231,124,24);
        labelAbe.setFont(new Font(this.font,1,11));
        this.add(labelAbe);
        buttonAbeSpearowL9 = new JButton("L9");
        buttonAbeSpearowL9.setVerticalAlignment(JLabel.CENTER);
        buttonAbeSpearowL9.setVerticalTextPosition(JLabel.CENTER);
        buttonAbeSpearowL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAbeSpearowL9.setIcon(new ImageIcon(getClass().getResource("/gold/spearow.png")));
        buttonAbeSpearowL9.setBounds(566,218,73,50);
        buttonAbeSpearowL9.setMargin(new Insets(1,0,1,0));
        buttonAbeSpearowL9.setFont(new Font(this.font, 1, 12));
        buttonAbeSpearowL9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.SPEAROW, 9, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.SPEAROW, 1);
                GoldDVCalculatorPanel.this.buttonAbeSpearowL9.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonAbeSpearowL9);
        JLabel labelRod = new JLabel("ROD");
        labelRod.setBounds(501,283,124,24);
        labelRod.setFont(new Font(this.font,1,11));
        this.add(labelRod);
        buttonRodPidgeyL7_1 = new JButton("L7");
        buttonRodPidgeyL7_1.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_1.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_1.setIcon(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        buttonRodPidgeyL7_1.setBounds(566,270,73,50);
        buttonRodPidgeyL7_1.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_1.setFont(new Font(this.font, 1, 12));
        buttonRodPidgeyL7_1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                GoldDVCalculatorPanel.this.buttonRodPidgeyL7_1.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRodPidgeyL7_1);
        buttonRodPidgeyL7_2 = new JButton("L7");
        buttonRodPidgeyL7_2.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_2.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_2.setIcon(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        buttonRodPidgeyL7_2.setBounds(639,270,73,50);
        buttonRodPidgeyL7_2.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_2.setFont(new Font(this.font, 1, 12));
        buttonRodPidgeyL7_2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                GoldDVCalculatorPanel.this.buttonRodPidgeyL7_2.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRodPidgeyL7_2);
        JLabel labelFalkner = new JLabel("FALKNER");
        labelFalkner.setBounds(501,335,124,24);
        labelFalkner.setFont(new Font(this.font,1,11));
        this.add(labelFalkner);
        buttonFalknerPidgeyL7 = new JButton("L7");
        buttonFalknerPidgeyL7.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeyL7.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeyL7.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeyL7.setIcon(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        buttonFalknerPidgeyL7.setBounds(566,322,73,50);
        buttonFalknerPidgeyL7.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeyL7.setFont(new Font(this.font, 1, 12));
        buttonFalknerPidgeyL7.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEY, 1);
                GoldDVCalculatorPanel.this.buttonFalknerPidgeyL7.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonFalknerPidgeyL7);
        buttonFalknerPidgeottoL9 = new JButton("L9");
        buttonFalknerPidgeottoL9.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeottoL9.setIcon(new ImageIcon(getClass().getResource("/gold/pidgeotto.png")));
        buttonFalknerPidgeottoL9.setBounds(639,322,73,50);
        buttonFalknerPidgeottoL9.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeottoL9.setFont(new Font(this.font, 1, 12));
        buttonFalknerPidgeottoL9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.PIDGEOTTO, 9, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.PIDGEOTTO, 1);
                GoldDVCalculatorPanel.this.buttonFalknerPidgeottoL9.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonFalknerPidgeottoL9);
        JLabel labelAlbert = new JLabel("ALBERT");
        labelAlbert.setBounds(501,387,124,24);
        labelAlbert.setFont(new Font(this.font,1,11));
        this.add(labelAlbert);
        buttonAlbertRattataL6 = new JButton("L6");
        buttonAlbertRattataL6.setVerticalAlignment(JLabel.CENTER);
        buttonAlbertRattataL6.setVerticalTextPosition(JLabel.CENTER);
        buttonAlbertRattataL6.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAlbertRattataL6.setIcon(new ImageIcon(getClass().getResource("/gold/rattata.png")));
        buttonAlbertRattataL6.setBounds(566,374,73,50);
        buttonAlbertRattataL6.setMargin(new Insets(1,0,1,0));
        buttonAlbertRattataL6.setFont(new Font(this.font, 1, 12));
        buttonAlbertRattataL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.RATTATA, 6, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.RATTATA, 1);
                GoldDVCalculatorPanel.this.buttonAlbertRattataL6.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonAlbertRattataL6);
        buttonAlbertZubatL8 = new JButton("L8");
        buttonAlbertZubatL8.setVerticalAlignment(JLabel.CENTER);
        buttonAlbertZubatL8.setVerticalTextPosition(JLabel.CENTER);
        buttonAlbertZubatL8.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAlbertZubatL8.setIcon(new ImageIcon(getClass().getResource("/gold/zubat.png")));
        buttonAlbertZubatL8.setBounds(639,374,73,50);
        buttonAlbertZubatL8.setMargin(new Insets(1,0,1,0));
        buttonAlbertZubatL8.setFont(new Font(this.font, 1, 12));
        buttonAlbertZubatL8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ZUBAT, 8, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ZUBAT, 1);
                GoldDVCalculatorPanel.this.buttonAlbertZubatL8.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonAlbertZubatL8);
        JLabel labelRalph = new JLabel("RALPH");
        labelRalph.setBounds(501,439,124,24);
        labelRalph.setFont(new Font(this.font,1,11));
        this.add(labelRalph);
        buttonRalphGoldeenL10 = new JButton("L10");
        buttonRalphGoldeenL10.setVerticalAlignment(JLabel.CENTER);
        buttonRalphGoldeenL10.setVerticalTextPosition(JLabel.CENTER);
        buttonRalphGoldeenL10.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRalphGoldeenL10.setIcon(new ImageIcon(getClass().getResource("/gold/goldeen.png")));
        buttonRalphGoldeenL10.setBounds(566,426,73,50);
        buttonRalphGoldeenL10.setMargin(new Insets(1,0,1,0));
        buttonRalphGoldeenL10.setFont(new Font(this.font, 1, 12));
        buttonRalphGoldeenL10.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GOLDEEN, 10, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GOLDEEN, 1);
                GoldDVCalculatorPanel.this.buttonRalphGoldeenL10.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRalphGoldeenL10);
        JLabel labelDaniel = new JLabel("DANIEL");
        labelDaniel.setBounds(501,491,124,24);
        labelDaniel.setFont(new Font(this.font,1,11));
        this.add(labelDaniel);
        buttonDanielOnixL11 = new JButton("L11");
        buttonDanielOnixL11.setVerticalAlignment(JLabel.CENTER);
        buttonDanielOnixL11.setVerticalTextPosition(JLabel.CENTER);
        buttonDanielOnixL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDanielOnixL11.setIcon(new ImageIcon(getClass().getResource("/gold/onix.png")));
        buttonDanielOnixL11.setBounds(566,478,73,50);
        buttonDanielOnixL11.setMargin(new Insets(1,0,1,0));
        buttonDanielOnixL11.setFont(new Font(this.font, 1, 12));
        buttonDanielOnixL11.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.ONIX, 11, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.ONIX, 1);
                GoldDVCalculatorPanel.this.buttonDanielOnixL11.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonDanielOnixL11);
        JLabel labelRussell = new JLabel("RUSSELL");
        labelRussell.setBounds(501,543,124,24);
        labelRussell.setFont(new Font(this.font,1,11));
        this.add(labelRussell);
        buttonRussellGeodudeL4 = new JButton("L4");
        buttonRussellGeodudeL4.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL4.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL4.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL4.setIcon(new ImageIcon(getClass().getResource("/gold/geodude.png")));
        buttonRussellGeodudeL4.setBounds(566,530,73,50);
        buttonRussellGeodudeL4.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL4.setFont(new Font(this.font, 1, 12));
        buttonRussellGeodudeL4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GEODUDE, 4, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GEODUDE, 1);
                GoldDVCalculatorPanel.this.buttonRussellGeodudeL4.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRussellGeodudeL4);
        buttonRussellGeodudeL6 = new JButton("L6");
        buttonRussellGeodudeL6.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL6.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL6.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL6.setIcon(new ImageIcon(getClass().getResource("/gold/geodude.png")));
        buttonRussellGeodudeL6.setBounds(639,530,73,50);
        buttonRussellGeodudeL6.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL6.setFont(new Font(this.font, 1, 12));
        buttonRussellGeodudeL6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GEODUDE, 6, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GEODUDE, 1);
                GoldDVCalculatorPanel.this.buttonRussellGeodudeL6.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRussellGeodudeL6);
        buttonRussellGeodudeL8 = new JButton("L8");
        buttonRussellGeodudeL8.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL8.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL8.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL8.setIcon(new ImageIcon(getClass().getResource("/gold/geodude.png")));
        buttonRussellGeodudeL8.setBounds(712,530,73,50);
        buttonRussellGeodudeL8.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL8.setFont(new Font(this.font, 1, 12));
        buttonRussellGeodudeL8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                GoldDVCalculatorPanel.this.exp += expGiven(new FoePokemon(Pokemon.Pkmn.GEODUDE, 8, false));
                GoldDVCalculatorPanel.this.addStatExp(Pokemon.Pkmn.GEODUDE, 1);
                GoldDVCalculatorPanel.this.buttonRussellGeodudeL8.setEnabled(false);
                while(lowestExpForLevel(GoldDVCalculatorPanel.this.level + 1) <= exp) {
                    GoldDVCalculatorPanel.this.level++;
                    GoldDVCalculatorPanel.this.hp_ev_used = GoldDVCalculatorPanel.this.hpStatExp;
                    GoldDVCalculatorPanel.this.atk_ev_used = GoldDVCalculatorPanel.this.atkStatExp;
                    GoldDVCalculatorPanel.this.def_ev_used = GoldDVCalculatorPanel.this.defStatExp;
                    GoldDVCalculatorPanel.this.spc_ev_used = GoldDVCalculatorPanel.this.spcStatExp;
                    GoldDVCalculatorPanel.this.spd_ev_used = GoldDVCalculatorPanel.this.spdStatExp;
                    GoldDVCalculatorPanel.this.updateStats();
                }
            }
        });
        this.add(buttonRussellGeodudeL8);
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
            stat = new Stat(this, Column.HP, i, (int)statValue, 30, 11 + i * 22);
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
            stat = new Stat(this, Column.ATK, i, (int)statValue, 120, 11 + i * 22);
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
            stat = new Stat(this, Column.DEF, i, (int)statValue, 210, 11 + i * 22);
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
            stat = new Stat(this, Column.SPD, i, (int)statValue, 390, 11 + i * 22);
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
            stat = new Stat(this, Column.SPC, i, (int)statValue*(int)spcDefValue, 300, 11 + i * 22);
            this.spcStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
    }

    private void initPokemon() {
        this.pokedex = new ArrayList();
        BufferedReader br = null;
        int lineNr = 0;
        int pokedexEntry = 0;
        try {
            try {
                br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("pokemon.txt")));
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
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateStats() {
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

    public void updateButtons(Column column, int value) {
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
        this.labelPidgeyAmount.setText("×0");
        this.labelSentretAmount.setText("×0");
        this.labelRattataAmount.setText("×0");
        this.labelCaterpieAmount.setText("×0");
        this.labelHoppipAmount.setText("×0");
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
}

