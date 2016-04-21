import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class CrystalDVCalculatorPanel extends GSCDVCalculatorPanel {
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
    private PartyPokemon totodile;

    private JLabel labelTotoLevel;
    private JLabel labelSentretAmount;
    private JLabel labelPidgeyAmount;
    private JLabel labelRattataAmount;
    private JLabel labelCaterpieAmount;
    private JLabel labelHoppipAmount;
    private JLabel labelPoliwagAmount;

    private JButton buttonRivalChikoritaL5;
    private JButton buttonMikeyPidgeyL2;
    private JButton buttonMikeyRattataL4;
    private JButton buttonAbeSpearowL9;
    private JButton buttonRodPidgeyL7_1;
    private JButton buttonRodPidgeyL7_2;
    private JButton buttonFalknerPidgeyL7;
    private JButton buttonFalknerPidgeottoL9;
    private JButton buttonGordonWooperL10;
    private JButton buttonRussellGeodudeL4;
    private JButton buttonRussellGeodudeL6;
    private JButton buttonRussellGeodudeL8;
    private JButton buttonBillKoffingL6_1;
    private JButton buttonBillKoffingL6_2;
    private JButton buttonAnthonyGeodudeL11;
    private JButton buttonAnthonyMachopL11;
    private JButton buttonGruntRattataL9_1;
    private JButton buttonGruntRattataL9_2;

    public CrystalDVCalculatorPanel(HelperFrame parent, String font) {
        super(parent);
        this.totodile = new PartyPokemon();
        this.parent = parent;
        this.font = font;
        this.setLayout(null);
        this.setBounds(0, 0, 792, 594);
        this.setBackground(null);
        this.init();
        this.initStatButtons();
        this.updateStats();
    }

    private void init() {
        JButton buttonPidgeyL2;
        JButton buttonPidgeyL3;
        JButton buttonPidgeyL4;
        JButton buttonSentretL2;
        JButton buttonSentretL3;
        JButton buttonRattataL2;
        JButton buttonCaterpieL3;
        JButton buttonCaterpieL4;
        JButton buttonHoppipL3;
        JButton buttonHoppipL4;
        JButton buttonPoliwagL4;
        for (int i = 0; i < 16; ++i) {
            this.redHP[i] = false;
            this.redAtk[i] = false;
            this.redDef[i] = false;
            this.redSpd[i] = false;
            this.redSpc[i] = false;
        }
        JLabel labelHP = new JLabel("HP");
        labelHP.setBounds(14, 51, 70, 50);
        labelHP.setFont(new Font(this.font, Font.BOLD, 19));
        labelHP.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelHP);
        JLabel labelAtk = new JLabel("Atk");
        labelAtk.setBounds(104, 51, 70, 50);
        labelAtk.setFont(new Font(this.font, Font.BOLD, 19));
        labelAtk.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelAtk);
        JLabel labelDef = new JLabel("Def");
        labelDef.setBounds(194, 51, 70, 50);
        labelDef.setFont(new Font(this.font, Font.BOLD, 19));
        labelDef.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelDef);
        JLabel labelSpd = new JLabel("Spd");
        labelSpd.setBounds(374, 51, 70, 50);
        labelSpd.setFont(new Font(this.font, Font.BOLD, 19));
        labelSpd.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelSpd);
        JLabel labelSpc = new JLabel("Spc");
        labelSpc.setBounds(284, 51, 70, 50);
        labelSpc.setFont(new Font(this.font, Font.BOLD, 19));
        labelSpc.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(labelSpc);
        JLabel labelTotoIcon = new JLabel(new ImageIcon(getClass().getResource("/crystal/totodile.png")));
        labelTotoIcon.setBounds(134, 4, 48, 48);
        this.add(labelTotoIcon);
        this.labelTotoLevel = new JLabel("Level: " + this.totodile.level);
        this.labelTotoLevel.setBounds(196,4,150,48);
        this.labelTotoLevel.setFont(new Font(this.font,Font.BOLD,29));
        this.add(this.labelTotoLevel);

        JLabel labelWild = new JLabel("Wild Pokes");
        labelWild.setBounds(155,459,190,42);
        labelWild.setFont(new Font(this.font,Font.BOLD,29));
        this.add(labelWild);

        // PIDGEY
        this.labelPidgeyAmount = new JLabel("×0");
        this.labelPidgeyAmount.setBounds(145, 512, 50, 24);
        this.labelPidgeyAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelPidgeyAmount);
        JLabel labelPidgeyIcon = new JLabel(new ImageIcon(getClass().getResource("/crystal/pidgey.png")));
        labelPidgeyIcon.setBounds(102, 503, 40, 40);
        this.add(labelPidgeyIcon);
        buttonPidgeyL2 = new JButton("L2");
        buttonPidgeyL2.setBounds(14, 509, 26, 26);
        buttonPidgeyL2.setMargin(new Insets(1, 1, 1, 1));
        buttonPidgeyL2.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL2 = new FoePokemon(Pokemon.Pkmn.PIDGEY, 2, true);
        buttonPidgeyL2.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(pidgeyL2, labelPidgeyAmount)));
        this.add(buttonPidgeyL2);

        buttonPidgeyL3 = new JButton("L3");
        buttonPidgeyL3.setBounds(42, 509, 26, 26);
        buttonPidgeyL3.setMargin(new Insets(1, 1, 1, 1));
        buttonPidgeyL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL3 = new FoePokemon(Pokemon.Pkmn.PIDGEY, 3, true);
        buttonPidgeyL3.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(pidgeyL3, labelPidgeyAmount)));
        this.add(buttonPidgeyL3);

        buttonPidgeyL4 = new JButton("L4");
        buttonPidgeyL4.setBounds(70, 509, 26, 26);
        buttonPidgeyL4.setMargin(new Insets(1, 1, 1, 1));
        buttonPidgeyL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL4 = new FoePokemon(Pokemon.Pkmn.PIDGEY, 4, true);
        buttonPidgeyL4.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(pidgeyL4, labelPidgeyAmount)));
        this.add(buttonPidgeyL4);

        // SENTRET
        this.labelSentretAmount = new JLabel("×0");
        this.labelSentretAmount.setBounds(145, 558, 50, 24);
        this.labelSentretAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelSentretAmount);
        JLabel labelSentretIcon = new JLabel(new ImageIcon(getClass().getResource("/crystal/sentret.png")));
        labelSentretIcon.setBounds(102, 549, 40, 40);
        this.add(labelSentretIcon);
        buttonSentretL2 = new JButton("L2");
        buttonSentretL2.setBounds(14, 555, 26, 26);
        buttonSentretL2.setMargin(new Insets(1, 1, 1, 1));
        buttonSentretL2.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon sentretL2 = new FoePokemon(Pokemon.Pkmn.SENTRET, 2, true);
        buttonSentretL2.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(sentretL2, labelSentretAmount)));
        this.add(buttonSentretL2);

        buttonSentretL3 = new JButton("L3");
        buttonSentretL3.setBounds(42, 555, 26, 26);
        buttonSentretL3.setMargin(new Insets(1, 1, 1, 1));
        buttonSentretL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon sentretL3 = new FoePokemon(Pokemon.Pkmn.SENTRET, 3, true);
        buttonSentretL3.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(sentretL3, labelSentretAmount)));
        this.add(buttonSentretL3);

        // HOPPIP
        this.labelHoppipAmount = new JLabel("×0");
        this.labelHoppipAmount.setBounds(292, 512, 50, 24);
        this.labelHoppipAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelHoppipAmount);
        JLabel labelHoppipIcon = new JLabel(new ImageIcon(getClass().getResource("/crystal/hoppip.png")));
        labelHoppipIcon.setBounds(249, 503, 40, 40);
        this.add(labelHoppipIcon);
        buttonHoppipL3 = new JButton("L3");
        buttonHoppipL3.setBounds(189, 509, 26, 26);
        buttonHoppipL3.setMargin(new Insets(1, 1, 1, 1));
        buttonHoppipL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon hoppipL3 = new FoePokemon(Pokemon.Pkmn.HOPPIP, 3, true);
        buttonHoppipL3.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(hoppipL3, labelHoppipAmount)));
        this.add(buttonHoppipL3);

        buttonHoppipL4 = new JButton("L4");
        buttonHoppipL4.setBounds(217, 509, 26, 26);
        buttonHoppipL4.setMargin(new Insets(1, 1, 1, 1));
        buttonHoppipL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon hoppipL4 = new FoePokemon(Pokemon.Pkmn.HOPPIP, 4, true);
        buttonHoppipL4.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(hoppipL4, labelHoppipAmount)));
        this.add(buttonHoppipL4);

        // CATERPIE
        this.labelCaterpieAmount = new JLabel("×0");
        this.labelCaterpieAmount.setBounds(292, 558, 50, 24);
        this.labelCaterpieAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelCaterpieAmount);
        JLabel labelCaterpieIcon = new JLabel(new ImageIcon(getClass().getResource("/crystal/caterpie.png")));
        labelCaterpieIcon.setBounds(249, 549, 40, 40);
        this.add(labelCaterpieIcon);
        buttonCaterpieL3 = new JButton("L3");
        buttonCaterpieL3.setBounds(189, 555, 26, 26);
        buttonCaterpieL3.setMargin(new Insets(1, 1, 1, 1));
        buttonCaterpieL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon caterpieL3 = new FoePokemon(Pokemon.Pkmn.CATERPIE, 3, true);
        buttonCaterpieL3.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(caterpieL3, labelCaterpieAmount)));
        this.add(buttonCaterpieL3);

        buttonCaterpieL4 = new JButton("L4");
        buttonCaterpieL4.setBounds(217, 555, 26, 26);
        buttonCaterpieL4.setMargin(new Insets(1, 1, 1, 1));
        buttonCaterpieL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon caterpieL4 = new FoePokemon(Pokemon.Pkmn.CATERPIE, 4, true);
        buttonCaterpieL4.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(caterpieL4, labelCaterpieAmount)));
        this.add(buttonCaterpieL4);

        // RATTATA
        this.labelRattataAmount = new JLabel("×0");
        this.labelRattataAmount.setBounds(411, 512, 50, 24);
        this.labelRattataAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelRattataAmount);
        JLabel labelRattataIcon = new JLabel(new ImageIcon(getClass().getResource("/crystal/rattata.png")));
        labelRattataIcon.setBounds(368, 503, 40, 40);
        this.add(labelRattataIcon);
        buttonRattataL2 = new JButton("L2");
        buttonRattataL2.setBounds(336, 509, 26, 26);
        buttonRattataL2.setMargin(new Insets(1, 1, 1, 1));
        buttonRattataL2.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon rattataL2 = new FoePokemon(Pokemon.Pkmn.RATTATA, 2, true);
        buttonRattataL2.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(rattataL2, labelRattataAmount)));
        this.add(buttonRattataL2);

        // POLIWAG
        this.labelPoliwagAmount = new JLabel("×0");
        this.labelPoliwagAmount.setBounds(411, 558, 50, 24);
        this.labelPoliwagAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelPoliwagAmount);
        JLabel labelPoliwagIcon = new JLabel(new ImageIcon(getClass().getResource("/crystal/poliwag.png")));
        labelPoliwagIcon.setBounds(368, 549, 40, 40);
        this.add(labelPoliwagIcon);
        buttonPoliwagL4 = new JButton("L4");
        buttonPoliwagL4.setBounds(336, 555, 26, 26);
        buttonPoliwagL4.setMargin(new Insets(1, 1, 1, 1));
        buttonPoliwagL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon poliwagL4 = new FoePokemon(Pokemon.Pkmn.POLIWAG, 4, true);
        buttonPoliwagL4.addActionListener(new DVPanelActionListener(this, totodile, new WildPokeAdapter(poliwagL4, labelPoliwagAmount)));
        this.add(buttonPoliwagL4);

        JLabel labelTrainers = new JLabel("Trainers");
        labelTrainers.setBounds(498,4,150,48);
        labelTrainers.setFont(new Font(this.font,Font.BOLD,29));
        this.add(labelTrainers);

        // RIVAL 1
        JLabel labelRival = new JLabel("RIVAL 1");
        labelRival.setBounds(501,75,124,24);
        labelRival.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelRival);
        buttonRivalChikoritaL5 = new JButton("L5");
        buttonRivalChikoritaL5.setVerticalAlignment(JLabel.CENTER);
        buttonRivalChikoritaL5.setVerticalTextPosition(JLabel.CENTER);
        buttonRivalChikoritaL5.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRivalChikoritaL5.setIcon(new ImageIcon(getClass().getResource("/crystal/chikorita.png")));
        buttonRivalChikoritaL5.setBounds(566,62,73,50);
        buttonRivalChikoritaL5.setMargin(new Insets(1,0,1,0));
        buttonRivalChikoritaL5.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon rivalChikoritaL5 = new FoePokemon(Pokemon.Pkmn.CHIKORITA, 5, false);
        buttonRivalChikoritaL5.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(rivalChikoritaL5, buttonRivalChikoritaL5)));
        this.add(buttonRivalChikoritaL5);

        // MIKEY
        JLabel labelMikey = new JLabel("MIKEY");
        labelMikey.setBounds(501,127,124,24);
        labelMikey.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelMikey);
        buttonMikeyPidgeyL2 = new JButton("L2");
        buttonMikeyPidgeyL2.setVerticalAlignment(JLabel.CENTER);
        buttonMikeyPidgeyL2.setVerticalTextPosition(JLabel.CENTER);
        buttonMikeyPidgeyL2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonMikeyPidgeyL2.setIcon(new ImageIcon(getClass().getResource("/crystal/pidgey.png")));
        buttonMikeyPidgeyL2.setBounds(566,114,73,50);
        buttonMikeyPidgeyL2.setMargin(new Insets(1,0,1,0));
        buttonMikeyPidgeyL2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon mikeyPidgeyL2 = new FoePokemon(Pokemon.Pkmn.PIDGEY, 2, false);
        buttonMikeyPidgeyL2.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(mikeyPidgeyL2, buttonMikeyPidgeyL2)));
        this.add(buttonMikeyPidgeyL2);

        buttonMikeyRattataL4 = new JButton("L4");
        buttonMikeyRattataL4.setVerticalAlignment(JLabel.CENTER);
        buttonMikeyRattataL4.setVerticalTextPosition(JLabel.CENTER);
        buttonMikeyRattataL4.setHorizontalTextPosition(JLabel.RIGHT);
        buttonMikeyRattataL4.setIcon(new ImageIcon(getClass().getResource("/crystal/rattata.png")));
        buttonMikeyRattataL4.setBounds(639,114,73,50);
        buttonMikeyRattataL4.setMargin(new Insets(1,0,1,0));
        buttonMikeyRattataL4.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon mikeyRattataL4 = new FoePokemon(Pokemon.Pkmn.RATTATA, 4, false);
        buttonMikeyRattataL4.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(mikeyRattataL4, buttonMikeyRattataL4)));
        this.add(buttonMikeyRattataL4);

        // ABE
        JLabel labelAbe = new JLabel("ABE");
        labelAbe.setBounds(501,179,124,24);
        labelAbe.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelAbe);
        buttonAbeSpearowL9 = new JButton("L9");
        buttonAbeSpearowL9.setVerticalAlignment(JLabel.CENTER);
        buttonAbeSpearowL9.setVerticalTextPosition(JLabel.CENTER);
        buttonAbeSpearowL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAbeSpearowL9.setIcon(new ImageIcon(getClass().getResource("/crystal/spearow.png")));
        buttonAbeSpearowL9.setBounds(566,166,73,50);
        buttonAbeSpearowL9.setMargin(new Insets(1,0,1,0));
        buttonAbeSpearowL9.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon abeSpearowL9 = new FoePokemon(Pokemon.Pkmn.SPEAROW, 9, false);
        buttonAbeSpearowL9.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(abeSpearowL9, buttonAbeSpearowL9)));
        this.add(buttonAbeSpearowL9);

        // ROD
        JLabel labelRod = new JLabel("ROD");
        labelRod.setBounds(501,231,124,24);
        labelRod.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelRod);
        buttonRodPidgeyL7_1 = new JButton("L7");
        buttonRodPidgeyL7_1.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_1.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_1.setIcon(new ImageIcon(getClass().getResource("/crystal/pidgey.png")));
        buttonRodPidgeyL7_1.setBounds(566,218,73,50);
        buttonRodPidgeyL7_1.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_1.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon rodPidgeyL7_1 = new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false);
        buttonRodPidgeyL7_1.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(rodPidgeyL7_1, buttonRodPidgeyL7_1)));
        this.add(buttonRodPidgeyL7_1);

        buttonRodPidgeyL7_2 = new JButton("L7");
        buttonRodPidgeyL7_2.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_2.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_2.setIcon(new ImageIcon(getClass().getResource("/crystal/pidgey.png")));
        buttonRodPidgeyL7_2.setBounds(639,218,73,50);
        buttonRodPidgeyL7_2.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon rodPidgeyL7_2 = new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false);
        buttonRodPidgeyL7_2.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(rodPidgeyL7_2, buttonRodPidgeyL7_2)));
        this.add(buttonRodPidgeyL7_2);

        // FALKNER
        JLabel labelFalkner = new JLabel("FALKNER");
        labelFalkner.setBounds(501,283,124,24);
        labelFalkner.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelFalkner);
        buttonFalknerPidgeyL7 = new JButton("L7");
        buttonFalknerPidgeyL7.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeyL7.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeyL7.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeyL7.setIcon(new ImageIcon(getClass().getResource("/crystal/pidgey.png")));
        buttonFalknerPidgeyL7.setBounds(566,270,73,50);
        buttonFalknerPidgeyL7.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeyL7.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon falknerPidgeyL7 = new FoePokemon(Pokemon.Pkmn.PIDGEY, 7, false);
        buttonFalknerPidgeyL7.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(falknerPidgeyL7, buttonFalknerPidgeyL7)));
        this.add(buttonFalknerPidgeyL7);

        buttonFalknerPidgeottoL9 = new JButton("L9");
        buttonFalknerPidgeottoL9.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeottoL9.setIcon(new ImageIcon(getClass().getResource("/crystal/pidgeotto.png")));
        buttonFalknerPidgeottoL9.setBounds(639,270,73,50);
        buttonFalknerPidgeottoL9.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeottoL9.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon falknerPidgeottoL9 = new FoePokemon(Pokemon.Pkmn.PIDGEOTTO, 9, false);
        buttonFalknerPidgeottoL9.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(falknerPidgeottoL9, buttonFalknerPidgeottoL9)));
        this.add(buttonFalknerPidgeottoL9);

        // GORDON
        JLabel labelGordon = new JLabel("GORDON");
        labelGordon.setBounds(501,335,124,24);
        labelGordon.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelGordon);
        buttonGordonWooperL10 = new JButton("L10");
        buttonGordonWooperL10.setVerticalAlignment(JLabel.CENTER);
        buttonGordonWooperL10.setVerticalTextPosition(JLabel.CENTER);
        buttonGordonWooperL10.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGordonWooperL10.setIcon(new ImageIcon(getClass().getResource("/crystal/wooper.png")));
        buttonGordonWooperL10.setBounds(566,322,73,50);
        buttonGordonWooperL10.setMargin(new Insets(1,0,1,0));
        buttonGordonWooperL10.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon gordonWooperL10 = new FoePokemon(Pokemon.Pkmn.WOOPER, 10, false);
        buttonGordonWooperL10.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(gordonWooperL10, buttonGordonWooperL10)));
        this.add(buttonGordonWooperL10);

        // RUSSELL
        JLabel labelRussell = new JLabel("RUSSELL");
        labelRussell.setBounds(501,387,124,24);
        labelRussell.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelRussell);
        buttonRussellGeodudeL4 = new JButton("L4");
        buttonRussellGeodudeL4.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL4.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL4.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL4.setIcon(new ImageIcon(getClass().getResource("/crystal/geodude.png")));
        buttonRussellGeodudeL4.setBounds(566,374,73,50);
        buttonRussellGeodudeL4.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL4.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon russellGeodudeL4 = new FoePokemon(Pokemon.Pkmn.GEODUDE, 4, false);
        buttonRussellGeodudeL4.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(russellGeodudeL4, buttonRussellGeodudeL4)));
        this.add(buttonRussellGeodudeL4);

        buttonRussellGeodudeL6 = new JButton("L6");
        buttonRussellGeodudeL6.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL6.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL6.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL6.setIcon(new ImageIcon(getClass().getResource("/crystal/geodude.png")));
        buttonRussellGeodudeL6.setBounds(639,374,73,50);
        buttonRussellGeodudeL6.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL6.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon russellGeodudeL6 = new FoePokemon(Pokemon.Pkmn.GEODUDE, 6, false);
        buttonRussellGeodudeL6.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(russellGeodudeL6, buttonRussellGeodudeL6)));
        this.add(buttonRussellGeodudeL6);

        buttonRussellGeodudeL8 = new JButton("L8");
        buttonRussellGeodudeL8.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL8.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL8.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL8.setIcon(new ImageIcon(getClass().getResource("/crystal/geodude.png")));
        buttonRussellGeodudeL8.setBounds(712,374,73,50);
        buttonRussellGeodudeL8.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL8.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon russellGeodudeL8 = new FoePokemon(Pokemon.Pkmn.GEODUDE, 8, false);
        buttonRussellGeodudeL8.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(russellGeodudeL8, buttonRussellGeodudeL8)));
        this.add(buttonRussellGeodudeL8);

        // BILL
        JLabel labelBill = new JLabel("BILL");
        labelBill.setBounds(501,439,124,24);
        labelBill.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelBill);
        buttonBillKoffingL6_1 = new JButton("L6");
        buttonBillKoffingL6_1.setVerticalAlignment(JLabel.CENTER);
        buttonBillKoffingL6_1.setVerticalTextPosition(JLabel.CENTER);
        buttonBillKoffingL6_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonBillKoffingL6_1.setIcon(new ImageIcon(getClass().getResource("/crystal/geodude.png")));
        buttonBillKoffingL6_1.setBounds(566,426,73,50);
        buttonBillKoffingL6_1.setMargin(new Insets(1,0,1,0));
        buttonBillKoffingL6_1.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon billKoffingL6_1 = new FoePokemon(Pokemon.Pkmn.KOFFING, 6, false);
        buttonBillKoffingL6_1.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(billKoffingL6_1, buttonBillKoffingL6_1)));
        this.add(buttonBillKoffingL6_1);

        buttonBillKoffingL6_2 = new JButton("L6");
        buttonBillKoffingL6_2.setVerticalAlignment(JLabel.CENTER);
        buttonBillKoffingL6_2.setVerticalTextPosition(JLabel.CENTER);
        buttonBillKoffingL6_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonBillKoffingL6_2.setIcon(new ImageIcon(getClass().getResource("/crystal/koffing.png")));
        buttonBillKoffingL6_2.setBounds(639,426,73,50);
        buttonBillKoffingL6_2.setMargin(new Insets(1,0,1,0));
        buttonBillKoffingL6_2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon billKoffingL6_2 = new FoePokemon(Pokemon.Pkmn.KOFFING, 6, false);
        buttonBillKoffingL6_2.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(billKoffingL6_2, buttonBillKoffingL6_2)));
        this.add(buttonBillKoffingL6_2);

        // ANTHONY
        JLabel labelAnthony = new JLabel("ANTHONY");
        labelAnthony.setBounds(501,491,124,24);
        labelAnthony.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelAnthony);
        buttonAnthonyGeodudeL11 = new JButton("L11");
        buttonAnthonyGeodudeL11.setVerticalAlignment(JLabel.CENTER);
        buttonAnthonyGeodudeL11.setVerticalTextPosition(JLabel.CENTER);
        buttonAnthonyGeodudeL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAnthonyGeodudeL11.setIcon(new ImageIcon(getClass().getResource("/crystal/geodude.png")));
        buttonAnthonyGeodudeL11.setBounds(566,478,73,50);
        buttonAnthonyGeodudeL11.setMargin(new Insets(1,0,1,0));
        buttonAnthonyGeodudeL11.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon anthonyGeodudeL11 = new FoePokemon(Pokemon.Pkmn.GEODUDE, 11, false);
        buttonAnthonyGeodudeL11.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(anthonyGeodudeL11, buttonAnthonyGeodudeL11)));
        this.add(buttonAnthonyGeodudeL11);

        buttonAnthonyMachopL11 = new JButton("L11");
        buttonAnthonyMachopL11.setVerticalAlignment(JLabel.CENTER);
        buttonAnthonyMachopL11.setVerticalTextPosition(JLabel.CENTER);
        buttonAnthonyMachopL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAnthonyMachopL11.setIcon(new ImageIcon(getClass().getResource("/crystal/machop.png")));
        buttonAnthonyMachopL11.setBounds(639,478,73,50);
        buttonAnthonyMachopL11.setMargin(new Insets(1,0,1,0));
        buttonAnthonyMachopL11.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon anthonyMachopL11 = new FoePokemon(Pokemon.Pkmn.MACHOP, 11, false);
        buttonAnthonyMachopL11.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(anthonyMachopL11, buttonAnthonyMachopL11)));
        this.add(buttonAnthonyMachopL11);

        // GRUNT
        JLabel labelGrunt = new JLabel("GRUNT");
        labelGrunt.setBounds(501,543,124,24);
        labelGrunt.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelGrunt);
        buttonGruntRattataL9_1 = new JButton("L9");
        buttonGruntRattataL9_1.setVerticalAlignment(JLabel.CENTER);
        buttonGruntRattataL9_1.setVerticalTextPosition(JLabel.CENTER);
        buttonGruntRattataL9_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGruntRattataL9_1.setIcon(new ImageIcon(getClass().getResource("/crystal/rattata.png")));
        buttonGruntRattataL9_1.setBounds(566,530,73,50);
        buttonGruntRattataL9_1.setMargin(new Insets(1,0,1,0));
        buttonGruntRattataL9_1.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon gruntRattataL9_1 = new FoePokemon(Pokemon.Pkmn.RATTATA, 9, false);
        buttonGruntRattataL9_1.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(gruntRattataL9_1, buttonGruntRattataL9_1)));
        this.add(buttonGruntRattataL9_1);

        buttonGruntRattataL9_2 = new JButton("L9");
        buttonGruntRattataL9_2.setVerticalAlignment(JLabel.CENTER);
        buttonGruntRattataL9_2.setVerticalTextPosition(JLabel.CENTER);
        buttonGruntRattataL9_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGruntRattataL9_2.setIcon(new ImageIcon(getClass().getResource("/crystal/rattata.png")));
        buttonGruntRattataL9_2.setBounds(639,530,73,50);
        buttonGruntRattataL9_2.setMargin(new Insets(1,0,1,0));
        buttonGruntRattataL9_2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon gruntRattataL9_2 = new FoePokemon(Pokemon.Pkmn.RATTATA, 9, false);
        buttonGruntRattataL9_2.addActionListener(new DVPanelActionListener(this, totodile, new TrainerPokeAdapter(gruntRattataL9_2, buttonGruntRattataL9_2)));
        this.add(buttonGruntRattataL9_2);
    }

    private void initStatButtons() {
        double extraStats;
        int i;
        Stat stat;
        double statValue;
        this.hpStats = new ArrayList<Stat>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.hpStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.hpStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseHP + i + 50) * 2) + extraStats) * (double)totodile.level / 100.0 + 10.0);
            stat = new Stat(this, Column.HP, i, (int)statValue, 30, 11 + i * 22);
            this.hpStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.atkStats = new ArrayList<Stat>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.atkStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.atkStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseAtk + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            stat = new Stat(this, Column.ATK, i, (int)statValue, 120, 11 + i * 22);
            this.atkStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.defStats = new ArrayList<Stat>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.defStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.defStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseDef + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            stat = new Stat(this, Column.DEF, i, (int)statValue, 210, 11 + i * 22);
            this.defStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.spdStats = new ArrayList<Stat>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.spdStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.spdStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseSpe + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            stat = new Stat(this, Column.SPD, i, (int)statValue, 390, 11 + i * 22);
            this.spdStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.spcStats = new ArrayList<Stat>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.spcStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.spcStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseSpA + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            double spcDefValue = Math.floor(((double)((totodile.baseSpD + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            stat = new Stat(this, Column.SPC, i, (int)statValue*(int)spcDefValue, 300, 11 + i * 22);
            this.spcStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
    }

    @Override
    public void updateStats() {
        double extraStats;
        int i;
        double statValue;
        this.labelTotoLevel.setText("Level: " + totodile.level);

        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.hpStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.hpStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseHP + i + 50) * 2) + extraStats) * (double)totodile.level / 100.0 + 10.0);
            this.hpStats.get(i).button.setText("" + (int)statValue);
            this.hpStats.get(i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.atkStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.atkStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseAtk + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            this.atkStats.get(i).button.setText("" + (int)statValue);
            this.atkStats.get(i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.defStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.defStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseDef + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            this.defStats.get(i).button.setText("" + (int)statValue);
            this.defStats.get(i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.spdStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.spdStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseSpe + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            this.spdStats.get(i).button.setText("" + (int)statValue);
            this.spdStats.get(i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (totodile.spcStatExp - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(totodile.spcStatExp - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((totodile.baseSpA + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            double spcDefValue = Math.floor(((double)((totodile.baseSpD + i) * 2) + extraStats) * (double)totodile.level / 100.0 + 5.0);
            this.spcStats.get(i).button.setText("" + (int)statValue + "/" + (int)spcDefValue);
            this.spcStats.get(i).value = (int)statValue*(int)spcDefValue;
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
                    this.redHP[i * 2] = true;
                    stat = this.hpStats.get(i * 2);
                    stat.possible = false;
                    stat.label.setVisible(false);
                    stat.button.setVisible(false);
                }
            }
            if (!this.hasOdd(this.spcStats)) {
                for (i = 0; i < 8; ++i) {
                    this.redHP[i * 2 + 1] = true;
                    stat = this.hpStats.get(i * 2 + 1);
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
            if (!list.get((i * 2)).possible) continue;
            even = true;
            break;
        }
        return even;
    }

    private boolean hasOdd(ArrayList<Stat> list) {
        boolean odd = false;
        for (int i = 0; i < 8; ++i) {
            if (!list.get((i * 2 + 1)).possible) continue;
            odd = true;
            break;
        }
        return odd;
    }

    public void removeStat(int column, int index) {
        if (column == 0) {
            this.hpStats.get(index).possible = false;
            this.hpStats.get(index).button.setVisible(false);
            this.hpStats.get(index).label.setVisible(false);
        } else if (column == 1) {
            this.atkStats.get(index).possible = false;
            this.atkStats.get(index).button.setVisible(false);
            this.atkStats.get(index).label.setVisible(false);
        } else if (column == 2) {
            this.defStats.get(index).possible = false;
            this.defStats.get(index).button.setVisible(false);
            this.defStats.get(index).label.setVisible(false);
        } else if (column == 3) {
            this.spdStats.get(index).possible = false;
            this.spdStats.get(index).button.setVisible(false);
            this.spdStats.get(index).label.setVisible(false);
        } else if (column == 4) {
            this.spcStats.get(index).possible = false;
            this.spcStats.get(index).button.setVisible(false);
            this.spcStats.get(index).label.setVisible(false);
        }
    }

    public void reset() {
        int i;
        totodile.reset();
        this.labelTotoLevel.setText("Level: " + totodile.level);
        this.labelPidgeyAmount.setText("×0");
        this.labelSentretAmount.setText("×0");
        this.labelRattataAmount.setText("×0");
        this.labelCaterpieAmount.setText("×0");
        this.labelHoppipAmount.setText("×0");
        this.labelPoliwagAmount.setText("×0");
        buttonRivalChikoritaL5.setEnabled(true);
        buttonMikeyPidgeyL2.setEnabled(true);
        buttonMikeyRattataL4.setEnabled(true);
        buttonAbeSpearowL9.setEnabled(true);
        buttonRodPidgeyL7_1.setEnabled(true);
        buttonRodPidgeyL7_2.setEnabled(true);
        buttonFalknerPidgeyL7.setEnabled(true);
        buttonFalknerPidgeottoL9.setEnabled(true);
        buttonGordonWooperL10.setEnabled(true);
        buttonRussellGeodudeL4.setEnabled(true);
        buttonRussellGeodudeL6.setEnabled(true);
        buttonRussellGeodudeL8.setEnabled(true);
        buttonBillKoffingL6_1.setEnabled(true);
        buttonBillKoffingL6_2.setEnabled(true);
        buttonAnthonyGeodudeL11.setEnabled(true);
        buttonAnthonyMachopL11.setEnabled(true);
        buttonGruntRattataL9_1.setEnabled(true);
        buttonGruntRattataL9_2.setEnabled(true);
        for (i = 0; i < 16; ++i) {
            this.hpStats.get(i).possible = true;
            this.hpStats.get(i).label.setVisible(true);
            this.hpStats.get(i).button.setVisible(true);
            this.atkStats.get(i).possible = true;
            this.atkStats.get(i).label.setVisible(true);
            this.atkStats.get(i).button.setVisible(true);
            this.defStats.get(i).possible = true;
            this.defStats.get(i).label.setVisible(true);
            this.defStats.get(i).button.setVisible(true);
            this.spdStats.get(i).possible = true;
            this.spdStats.get(i).label.setVisible(true);
            this.spdStats.get(i).button.setVisible(true);
            this.spcStats.get(i).possible = true;
            this.spcStats.get(i).label.setVisible(true);
            this.spcStats.get(i).button.setVisible(true);
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