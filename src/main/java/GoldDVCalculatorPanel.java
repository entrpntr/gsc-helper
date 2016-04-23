import java.awt.Font;
import java.awt.Insets;

import javax.swing.*;

public class GoldDVCalculatorPanel extends GSCDVCalculatorPanel {
    private static final long serialVersionUID = -7545905343679467024L;

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

    public GoldDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile, String font) {
        super(parent, Game.GOLD, totodile, font);
    }

    public void init() {
        super.init();

        JLabel labelWild = new JLabel("Wild Pokes");
        labelWild.setBounds(155,459,190,42);
        labelWild.setFont(new Font(this.font,Font.BOLD,29));
        this.add(labelWild);

        // PIDGEY
        this.labelPidgeyAmount = new JLabel("×0");
        this.labelPidgeyAmount.setBounds(145, 512, 50, 24);
        this.labelPidgeyAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelPidgeyAmount);
        JLabel labelPidgeyIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        labelPidgeyIcon.setBounds(102, 503, 40, 40);
        this.add(labelPidgeyIcon);
        this.buttonPidgeyL2 = new JButton("L2");
        this.buttonPidgeyL2.setBounds(14, 509, 26, 26);
        this.buttonPidgeyL2.setMargin(new Insets(1, 1, 1, 1));
        this.buttonPidgeyL2.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL2 = new FoePokemon(Species.PIDGEY, 2, FoeType.WILD);
        buttonPidgeyL2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(pidgeyL2, labelPidgeyAmount)));
        this.add(this.buttonPidgeyL2);

        this.buttonPidgeyL3 = new JButton("L3");
        this.buttonPidgeyL3.setBounds(42, 509, 26, 26);
        this.buttonPidgeyL3.setMargin(new Insets(1, 1, 1, 1));
        this.buttonPidgeyL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL3 = new FoePokemon(Species.PIDGEY, 3, FoeType.WILD);
        buttonPidgeyL3.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(pidgeyL3, labelPidgeyAmount)));
        this.add(this.buttonPidgeyL3);

        this.buttonPidgeyL4 = new JButton("L4");
        this.buttonPidgeyL4.setBounds(70, 509, 26, 26);
        this.buttonPidgeyL4.setMargin(new Insets(1, 1, 1, 1));
        this.buttonPidgeyL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL4 = new FoePokemon(Species.PIDGEY, 4, FoeType.WILD);
        buttonPidgeyL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(pidgeyL4, labelPidgeyAmount)));
        this.add(this.buttonPidgeyL4);

        // SENTRET
        this.labelSentretAmount = new JLabel("×0");
        this.labelSentretAmount.setBounds(145, 558, 50, 24);
        this.labelSentretAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelSentretAmount);
        JLabel labelSentretIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/sentret.png")));
        labelSentretIcon.setBounds(102, 549, 40, 40);
        this.add(labelSentretIcon);
        this.buttonSentretL2 = new JButton("L2");
        this.buttonSentretL2.setBounds(14, 555, 26, 26);
        this.buttonSentretL2.setMargin(new Insets(1, 1, 1, 1));
        this.buttonSentretL2.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon sentretL2 = new FoePokemon(Species.SENTRET, 2, FoeType.WILD);
        buttonSentretL2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(sentretL2, labelSentretAmount)));
        this.add(this.buttonSentretL2);

        this.buttonSentretL3 = new JButton("L3");
        this.buttonSentretL3.setBounds(42, 555, 26, 26);
        this.buttonSentretL3.setMargin(new Insets(1, 1, 1, 1));
        this.buttonSentretL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon sentretL3 = new FoePokemon(Species.SENTRET, 3, FoeType.WILD);
        buttonSentretL3.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(sentretL3, labelSentretAmount)));
        this.add(this.buttonSentretL3);

        // RATTATA
        this.labelRattataAmount = new JLabel("×0");
        this.labelRattataAmount.setBounds(292, 512, 50, 24);
        this.labelRattataAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelRattataAmount);
        JLabel labelRattataIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/rattata.png")));
        labelRattataIcon.setBounds(249, 503, 40, 40);
        this.add(labelRattataIcon);
        this.buttonRattataL4 = new JButton("L4");
        this.buttonRattataL4.setBounds(217, 509, 26, 26);
        this.buttonRattataL4.setMargin(new Insets(1, 1, 1, 1));
        this.buttonRattataL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon rattataL4 = new FoePokemon(Species.RATTATA, 4, FoeType.WILD);
        buttonRattataL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(rattataL4, labelRattataAmount)));
        this.add(this.buttonRattataL4);

        // CATERPIE
        this.labelCaterpieAmount = new JLabel("×0");
        this.labelCaterpieAmount.setBounds(292, 558, 50, 24);
        this.labelCaterpieAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelCaterpieAmount);
        JLabel labelCaterpieIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/caterpie.png")));
        labelCaterpieIcon.setBounds(249, 549, 40, 40);
        this.add(labelCaterpieIcon);
        this.buttonCaterpieL3 = new JButton("L3");
        this.buttonCaterpieL3.setBounds(189, 555, 26, 26);
        this.buttonCaterpieL3.setMargin(new Insets(1, 1, 1, 1));
        this.buttonCaterpieL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon caterpieL3 = new FoePokemon(Species.CATERPIE, 3, FoeType.WILD);
        buttonCaterpieL3.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(caterpieL3, labelCaterpieAmount)));
        this.add(this.buttonCaterpieL3);

        this.buttonCaterpieL4 = new JButton("L4");
        this.buttonCaterpieL4.setBounds(217, 555, 26, 26);
        this.buttonCaterpieL4.setMargin(new Insets(1, 1, 1, 1));
        this.buttonCaterpieL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon caterpieL4 = new FoePokemon(Species.CATERPIE, 4, FoeType.WILD);
        buttonCaterpieL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(caterpieL4, labelCaterpieAmount)));
        this.add(this.buttonCaterpieL4);

        // HOPPIP
        this.labelHoppipAmount = new JLabel("×0");
        this.labelHoppipAmount.setBounds(411, 512, 50, 24);
        this.labelHoppipAmount.setFont(new Font(this.font, Font.BOLD, 20));
        this.add(this.labelHoppipAmount);
        JLabel labelHoppipIcon = new JLabel(new ImageIcon(getClass().getResource("/gold/hoppip.png")));
        labelHoppipIcon.setBounds(368, 503, 40, 40);
        this.add(labelHoppipIcon);
        this.buttonHoppipL6 = new JButton("L6");
        this.buttonHoppipL6.setBounds(336, 509, 26, 26);
        this.buttonHoppipL6.setMargin(new Insets(1, 1, 1, 1));
        this.buttonHoppipL6.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon hoppipL6 = new FoePokemon(Species.HOPPIP, 6, FoeType.WILD);
        buttonHoppipL6.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(hoppipL6, labelHoppipAmount)));
        this.add(this.buttonHoppipL6);

        // TRAINERS
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
        buttonRivalChikoritaL5.setIcon(new ImageIcon(getClass().getResource("/gold/chikorita.png")));
        buttonRivalChikoritaL5.setBounds(566,62,73,50);
        buttonRivalChikoritaL5.setMargin(new Insets(1,0,1,0));
        buttonRivalChikoritaL5.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon rivalChikoritaL5 = new FoePokemon(Species.CHIKORITA, 5, FoeType.TRAINER);
        buttonRivalChikoritaL5.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(rivalChikoritaL5, buttonRivalChikoritaL5)));
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
        buttonMikeyPidgeyL2.setIcon(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        buttonMikeyPidgeyL2.setBounds(566,114,73,50);
        buttonMikeyPidgeyL2.setMargin(new Insets(1,0,1,0));
        buttonMikeyPidgeyL2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon mikeyPidgeyL2 = new FoePokemon(Species.PIDGEY, 2, FoeType.TRAINER);
        buttonMikeyPidgeyL2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(mikeyPidgeyL2, buttonMikeyPidgeyL2)));
        this.add(buttonMikeyPidgeyL2);

        buttonMikeyRattataL4 = new JButton("L4");
        buttonMikeyRattataL4.setVerticalAlignment(JLabel.CENTER);
        buttonMikeyRattataL4.setVerticalTextPosition(JLabel.CENTER);
        buttonMikeyRattataL4.setHorizontalTextPosition(JLabel.RIGHT);
        buttonMikeyRattataL4.setIcon(new ImageIcon(getClass().getResource("/gold/rattata.png")));
        buttonMikeyRattataL4.setBounds(639,114,73,50);
        buttonMikeyRattataL4.setMargin(new Insets(1,0,1,0));
        buttonMikeyRattataL4.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon mikeyRattataL4 = new FoePokemon(Species.RATTATA, 4, FoeType.TRAINER);
        buttonMikeyRattataL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(mikeyRattataL4, buttonMikeyRattataL4)));
        this.add(buttonMikeyRattataL4);

        // DON
        JLabel labelDon = new JLabel("DON");
        labelDon.setBounds(501,179,124,24);
        labelDon.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelDon);
        buttonDonCaterpieL3_1 = new JButton("L3");
        buttonDonCaterpieL3_1.setVerticalAlignment(JLabel.CENTER);
        buttonDonCaterpieL3_1.setVerticalTextPosition(JLabel.CENTER);
        buttonDonCaterpieL3_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDonCaterpieL3_1.setIcon(new ImageIcon(getClass().getResource("/gold/caterpie.png")));
        buttonDonCaterpieL3_1.setBounds(566,166,73,50);
        buttonDonCaterpieL3_1.setMargin(new Insets(1,0,1,0));
        buttonDonCaterpieL3_1.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon donCaterpieL3_1 = new FoePokemon(Species.CATERPIE, 3, FoeType.TRAINER);
        buttonDonCaterpieL3_1.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(donCaterpieL3_1, buttonDonCaterpieL3_1)));
        this.add(buttonDonCaterpieL3_1);

        buttonDonCaterpieL3_2 = new JButton("L3");
        buttonDonCaterpieL3_2.setVerticalAlignment(JLabel.CENTER);
        buttonDonCaterpieL3_2.setVerticalTextPosition(JLabel.CENTER);
        buttonDonCaterpieL3_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDonCaterpieL3_2.setIcon(new ImageIcon(getClass().getResource("/gold/caterpie.png")));
        buttonDonCaterpieL3_2.setBounds(639,166,73,50);
        buttonDonCaterpieL3_2.setMargin(new Insets(1,0,1,0));
        buttonDonCaterpieL3_2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon donCaterpieL3_2 = new FoePokemon(Species.CATERPIE, 3, FoeType.TRAINER);
        buttonDonCaterpieL3_2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(donCaterpieL3_2, buttonDonCaterpieL3_2)));
        this.add(buttonDonCaterpieL3_2);

        // ABE
        JLabel labelAbe = new JLabel("ABE");
        labelAbe.setBounds(501,231,124,24);
        labelAbe.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelAbe);
        buttonAbeSpearowL9 = new JButton("L9");
        buttonAbeSpearowL9.setVerticalAlignment(JLabel.CENTER);
        buttonAbeSpearowL9.setVerticalTextPosition(JLabel.CENTER);
        buttonAbeSpearowL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAbeSpearowL9.setIcon(new ImageIcon(getClass().getResource("/gold/spearow.png")));
        buttonAbeSpearowL9.setBounds(566,218,73,50);
        buttonAbeSpearowL9.setMargin(new Insets(1,0,1,0));
        buttonAbeSpearowL9.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon abeSpearowL9 = new FoePokemon(Species.SPEAROW, 9, FoeType.TRAINER);
        buttonAbeSpearowL9.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(abeSpearowL9, buttonAbeSpearowL9)));
        this.add(buttonAbeSpearowL9);

        // ROD
        JLabel labelRod = new JLabel("ROD");
        labelRod.setBounds(501,283,124,24);
        labelRod.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelRod);
        buttonRodPidgeyL7_1 = new JButton("L7");
        buttonRodPidgeyL7_1.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_1.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_1.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_1.setIcon(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        buttonRodPidgeyL7_1.setBounds(566,270,73,50);
        buttonRodPidgeyL7_1.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_1.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon rodPidgeyL7_1 = new FoePokemon(Species.PIDGEY, 7, FoeType.TRAINER);
        buttonRodPidgeyL7_1.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(rodPidgeyL7_1, buttonRodPidgeyL7_1)));
        this.add(buttonRodPidgeyL7_1);

        buttonRodPidgeyL7_2 = new JButton("L7");
        buttonRodPidgeyL7_2.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_2.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_2.setIcon(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        buttonRodPidgeyL7_2.setBounds(639,270,73,50);
        buttonRodPidgeyL7_2.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon rodPidgeyL7_2 = new FoePokemon(Species.PIDGEY, 7, FoeType.TRAINER);
        buttonRodPidgeyL7_2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(rodPidgeyL7_2, buttonRodPidgeyL7_2)));
        this.add(buttonRodPidgeyL7_2);

        // FALKNER
        JLabel labelFalkner = new JLabel("FALKNER");
        labelFalkner.setBounds(501,335,124,24);
        labelFalkner.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelFalkner);
        buttonFalknerPidgeyL7 = new JButton("L7");
        buttonFalknerPidgeyL7.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeyL7.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeyL7.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeyL7.setIcon(new ImageIcon(getClass().getResource("/gold/pidgey.png")));
        buttonFalknerPidgeyL7.setBounds(566,322,73,50);
        buttonFalknerPidgeyL7.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeyL7.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon falknerPidgeyL7 = new FoePokemon(Species.PIDGEY, 7, FoeType.TRAINER);
        buttonFalknerPidgeyL7.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(falknerPidgeyL7, buttonFalknerPidgeyL7)));
        this.add(buttonFalknerPidgeyL7);

        buttonFalknerPidgeottoL9 = new JButton("L9");
        buttonFalknerPidgeottoL9.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeottoL9.setIcon(new ImageIcon(getClass().getResource("/gold/pidgeotto.png")));
        buttonFalknerPidgeottoL9.setBounds(639,322,73,50);
        buttonFalknerPidgeottoL9.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeottoL9.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon falknerPidgeottoL9 = new FoePokemon(Species.PIDGEOTTO, 9, FoeType.TRAINER);
        buttonFalknerPidgeottoL9.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(falknerPidgeottoL9, buttonFalknerPidgeottoL9)));
        this.add(buttonFalknerPidgeottoL9);

        // ALBERT
        JLabel labelAlbert = new JLabel("ALBERT");
        labelAlbert.setBounds(501,387,124,24);
        labelAlbert.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelAlbert);
        buttonAlbertRattataL6 = new JButton("L6");
        buttonAlbertRattataL6.setVerticalAlignment(JLabel.CENTER);
        buttonAlbertRattataL6.setVerticalTextPosition(JLabel.CENTER);
        buttonAlbertRattataL6.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAlbertRattataL6.setIcon(new ImageIcon(getClass().getResource("/gold/rattata.png")));
        buttonAlbertRattataL6.setBounds(566,374,73,50);
        buttonAlbertRattataL6.setMargin(new Insets(1,0,1,0));
        buttonAlbertRattataL6.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon albertRattataL6 = new FoePokemon(Species.RATTATA, 6, FoeType.TRAINER);
        buttonAlbertRattataL6.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(albertRattataL6, buttonAlbertRattataL6)));
        this.add(buttonAlbertRattataL6);

        buttonAlbertZubatL8 = new JButton("L8");
        buttonAlbertZubatL8.setVerticalAlignment(JLabel.CENTER);
        buttonAlbertZubatL8.setVerticalTextPosition(JLabel.CENTER);
        buttonAlbertZubatL8.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAlbertZubatL8.setIcon(new ImageIcon(getClass().getResource("/gold/zubat.png")));
        buttonAlbertZubatL8.setBounds(639,374,73,50);
        buttonAlbertZubatL8.setMargin(new Insets(1,0,1,0));
        buttonAlbertZubatL8.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon albertZubatL8 = new FoePokemon(Species.ZUBAT, 8, FoeType.TRAINER);
        buttonAlbertZubatL8.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(albertZubatL8, buttonAlbertZubatL8)));
        this.add(buttonAlbertZubatL8);

        // RALPH
        JLabel labelRalph = new JLabel("RALPH");
        labelRalph.setBounds(501,439,124,24);
        labelRalph.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelRalph);
        buttonRalphGoldeenL10 = new JButton("L10");
        buttonRalphGoldeenL10.setVerticalAlignment(JLabel.CENTER);
        buttonRalphGoldeenL10.setVerticalTextPosition(JLabel.CENTER);
        buttonRalphGoldeenL10.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRalphGoldeenL10.setIcon(new ImageIcon(getClass().getResource("/gold/goldeen.png")));
        buttonRalphGoldeenL10.setBounds(566,426,73,50);
        buttonRalphGoldeenL10.setMargin(new Insets(1,0,1,0));
        buttonRalphGoldeenL10.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon ralphGoldeenL10 = new FoePokemon(Species.GOLDEEN, 10, FoeType.TRAINER);
        buttonRalphGoldeenL10.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(ralphGoldeenL10, buttonRalphGoldeenL10)));
        this.add(buttonRalphGoldeenL10);

        // DANIEL
        JLabel labelDaniel = new JLabel("DANIEL");
        labelDaniel.setBounds(501,491,124,24);
        labelDaniel.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelDaniel);
        buttonDanielOnixL11 = new JButton("L11");
        buttonDanielOnixL11.setVerticalAlignment(JLabel.CENTER);
        buttonDanielOnixL11.setVerticalTextPosition(JLabel.CENTER);
        buttonDanielOnixL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonDanielOnixL11.setIcon(new ImageIcon(getClass().getResource("/gold/onix.png")));
        buttonDanielOnixL11.setBounds(566,478,73,50);
        buttonDanielOnixL11.setMargin(new Insets(1,0,1,0));
        buttonDanielOnixL11.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon danielOnixL11 = new FoePokemon(Species.ONIX, 11, FoeType.TRAINER);
        buttonDanielOnixL11.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(danielOnixL11, buttonDanielOnixL11)));
        this.add(buttonDanielOnixL11);

        // RUSSELL
        JLabel labelRussell = new JLabel("RUSSELL");
        labelRussell.setBounds(501,543,124,24);
        labelRussell.setFont(new Font(this.font,Font.BOLD,11));
        this.add(labelRussell);
        buttonRussellGeodudeL4 = new JButton("L4");
        buttonRussellGeodudeL4.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL4.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL4.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL4.setIcon(new ImageIcon(getClass().getResource("/gold/geodude.png")));
        buttonRussellGeodudeL4.setBounds(566,530,73,50);
        buttonRussellGeodudeL4.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL4.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon russellGeodudeL4 = new FoePokemon(Species.GEODUDE, 4, FoeType.TRAINER);
        buttonRussellGeodudeL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(russellGeodudeL4, buttonRussellGeodudeL4)));
        this.add(buttonRussellGeodudeL4);

        buttonRussellGeodudeL6 = new JButton("L6");
        buttonRussellGeodudeL6.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL6.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL6.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL6.setIcon(new ImageIcon(getClass().getResource("/gold/geodude.png")));
        buttonRussellGeodudeL6.setBounds(639,530,73,50);
        buttonRussellGeodudeL6.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL6.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon russellGeodudeL6 = new FoePokemon(Species.GEODUDE, 6, FoeType.TRAINER);
        buttonRussellGeodudeL6.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(russellGeodudeL6, buttonRussellGeodudeL6)));
        this.add(buttonRussellGeodudeL6);

        buttonRussellGeodudeL8 = new JButton("L8");
        buttonRussellGeodudeL8.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL8.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL8.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL8.setIcon(new ImageIcon(getClass().getResource("/gold/geodude.png")));
        buttonRussellGeodudeL8.setBounds(712,530,73,50);
        buttonRussellGeodudeL8.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL8.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon russellGeodudeL8 = new FoePokemon(Species.GEODUDE, 8, FoeType.TRAINER);
        buttonRussellGeodudeL8.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(russellGeodudeL8, buttonRussellGeodudeL8)));
        this.add(buttonRussellGeodudeL8);
    }

    public void resetAction() {
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
    }
}

