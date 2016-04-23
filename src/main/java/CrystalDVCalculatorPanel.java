import java.awt.Font;
import java.awt.Insets;

import javax.swing.*;

public class CrystalDVCalculatorPanel extends GSCDVCalculatorPanel {
    private static final long serialVersionUID = -7545905343679467024L;

    private JLabel labelSentretAmount;
    private JLabel labelPidgeyAmount;
    private JLabel labelRattataAmount;
    private JLabel labelCaterpieAmount;
    private JLabel labelHoppipAmount;
    private JLabel labelPoliwagAmount;
    private JButton buttonPidgeyL2;
    private JButton buttonPidgeyL3;
    private JButton buttonPidgeyL4;
    private JButton buttonSentretL2;
    private JButton buttonSentretL3;
    private JButton buttonRattataL2;
    private JButton buttonCaterpieL3;
    private JButton buttonCaterpieL4;
    private JButton buttonHoppipL3;
    private JButton buttonHoppipL4;
    private JButton buttonPoliwagL4;

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

    public CrystalDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile, String font) {
        super(parent, Game.CRYSTAL, totodile, font);
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
        JLabel labelPidgeyIcon = new JLabel(new ImageIcon(getClass().getResource("/crystal/pidgey.png")));
        labelPidgeyIcon.setBounds(102, 503, 40, 40);
        this.add(labelPidgeyIcon);
        buttonPidgeyL2 = new JButton("L2");
        buttonPidgeyL2.setBounds(14, 509, 26, 26);
        buttonPidgeyL2.setMargin(new Insets(1, 1, 1, 1));
        buttonPidgeyL2.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL2 = new FoePokemon(Species.PIDGEY, 2, FoeType.WILD);
        buttonPidgeyL2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(pidgeyL2, labelPidgeyAmount)));
        this.add(buttonPidgeyL2);

        buttonPidgeyL3 = new JButton("L3");
        buttonPidgeyL3.setBounds(42, 509, 26, 26);
        buttonPidgeyL3.setMargin(new Insets(1, 1, 1, 1));
        buttonPidgeyL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL3 = new FoePokemon(Species.PIDGEY, 3, FoeType.WILD);
        buttonPidgeyL3.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(pidgeyL3, labelPidgeyAmount)));
        this.add(buttonPidgeyL3);

        buttonPidgeyL4 = new JButton("L4");
        buttonPidgeyL4.setBounds(70, 509, 26, 26);
        buttonPidgeyL4.setMargin(new Insets(1, 1, 1, 1));
        buttonPidgeyL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon pidgeyL4 = new FoePokemon(Species.PIDGEY, 4, FoeType.WILD);
        buttonPidgeyL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(pidgeyL4, labelPidgeyAmount)));
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
        FoePokemon sentretL2 = new FoePokemon(Species.SENTRET, 2, FoeType.WILD);
        buttonSentretL2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(sentretL2, labelSentretAmount)));
        this.add(buttonSentretL2);

        buttonSentretL3 = new JButton("L3");
        buttonSentretL3.setBounds(42, 555, 26, 26);
        buttonSentretL3.setMargin(new Insets(1, 1, 1, 1));
        buttonSentretL3.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon sentretL3 = new FoePokemon(Species.SENTRET, 3, FoeType.WILD);
        buttonSentretL3.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(sentretL3, labelSentretAmount)));
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
        FoePokemon hoppipL3 = new FoePokemon(Species.HOPPIP, 3, FoeType.WILD);
        buttonHoppipL3.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(hoppipL3, labelHoppipAmount)));
        this.add(buttonHoppipL3);

        buttonHoppipL4 = new JButton("L4");
        buttonHoppipL4.setBounds(217, 509, 26, 26);
        buttonHoppipL4.setMargin(new Insets(1, 1, 1, 1));
        buttonHoppipL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon hoppipL4 = new FoePokemon(Species.HOPPIP, 4, FoeType.WILD);
        buttonHoppipL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(hoppipL4, labelHoppipAmount)));
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
        FoePokemon caterpieL3 = new FoePokemon(Species.CATERPIE, 3, FoeType.WILD);
        buttonCaterpieL3.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(caterpieL3, labelCaterpieAmount)));
        this.add(buttonCaterpieL3);

        buttonCaterpieL4 = new JButton("L4");
        buttonCaterpieL4.setBounds(217, 555, 26, 26);
        buttonCaterpieL4.setMargin(new Insets(1, 1, 1, 1));
        buttonCaterpieL4.setFont(new Font(this.font, Font.BOLD, 14));
        FoePokemon caterpieL4 = new FoePokemon(Species.CATERPIE, 4, FoeType.WILD);
        buttonCaterpieL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(caterpieL4, labelCaterpieAmount)));
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
        FoePokemon rattataL2 = new FoePokemon(Species.RATTATA, 2, FoeType.WILD);
        buttonRattataL2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(rattataL2, labelRattataAmount)));
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
        FoePokemon poliwagL4 = new FoePokemon(Species.POLIWAG, 4, FoeType.WILD);
        buttonPoliwagL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new WildPokeAdapter(poliwagL4, labelPoliwagAmount)));
        this.add(buttonPoliwagL4);

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
        buttonRivalChikoritaL5.setIcon(new ImageIcon(getClass().getResource("/crystal/chikorita.png")));
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
        buttonMikeyPidgeyL2.setIcon(new ImageIcon(getClass().getResource("/crystal/pidgey.png")));
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
        buttonMikeyRattataL4.setIcon(new ImageIcon(getClass().getResource("/crystal/rattata.png")));
        buttonMikeyRattataL4.setBounds(639,114,73,50);
        buttonMikeyRattataL4.setMargin(new Insets(1,0,1,0));
        buttonMikeyRattataL4.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon mikeyRattataL4 = new FoePokemon(Species.RATTATA, 4, FoeType.TRAINER);
        buttonMikeyRattataL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(mikeyRattataL4, buttonMikeyRattataL4)));
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
        FoePokemon abeSpearowL9 = new FoePokemon(Species.SPEAROW, 9, FoeType.TRAINER);
        buttonAbeSpearowL9.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(abeSpearowL9, buttonAbeSpearowL9)));
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
        FoePokemon rodPidgeyL7_1 = new FoePokemon(Species.PIDGEY, 7, FoeType.TRAINER);
        buttonRodPidgeyL7_1.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(rodPidgeyL7_1, buttonRodPidgeyL7_1)));
        this.add(buttonRodPidgeyL7_1);

        buttonRodPidgeyL7_2 = new JButton("L7");
        buttonRodPidgeyL7_2.setVerticalAlignment(JLabel.CENTER);
        buttonRodPidgeyL7_2.setVerticalTextPosition(JLabel.CENTER);
        buttonRodPidgeyL7_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRodPidgeyL7_2.setIcon(new ImageIcon(getClass().getResource("/crystal/pidgey.png")));
        buttonRodPidgeyL7_2.setBounds(639,218,73,50);
        buttonRodPidgeyL7_2.setMargin(new Insets(1,0,1,0));
        buttonRodPidgeyL7_2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon rodPidgeyL7_2 = new FoePokemon(Species.PIDGEY, 7, FoeType.TRAINER);
        buttonRodPidgeyL7_2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(rodPidgeyL7_2, buttonRodPidgeyL7_2)));
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
        FoePokemon falknerPidgeyL7 = new FoePokemon(Species.PIDGEY, 7, FoeType.TRAINER);
        buttonFalknerPidgeyL7.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(falknerPidgeyL7, buttonFalknerPidgeyL7)));
        this.add(buttonFalknerPidgeyL7);

        buttonFalknerPidgeottoL9 = new JButton("L9");
        buttonFalknerPidgeottoL9.setVerticalAlignment(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setVerticalTextPosition(JLabel.CENTER);
        buttonFalknerPidgeottoL9.setHorizontalTextPosition(JLabel.RIGHT);
        buttonFalknerPidgeottoL9.setIcon(new ImageIcon(getClass().getResource("/crystal/pidgeotto.png")));
        buttonFalknerPidgeottoL9.setBounds(639,270,73,50);
        buttonFalknerPidgeottoL9.setMargin(new Insets(1,0,1,0));
        buttonFalknerPidgeottoL9.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon falknerPidgeottoL9 = new FoePokemon(Species.PIDGEOTTO, 9, FoeType.TRAINER);
        buttonFalknerPidgeottoL9.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(falknerPidgeottoL9, buttonFalknerPidgeottoL9)));
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
        FoePokemon gordonWooperL10 = new FoePokemon(Species.WOOPER, 10, FoeType.TRAINER);
        buttonGordonWooperL10.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(gordonWooperL10, buttonGordonWooperL10)));
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
        FoePokemon russellGeodudeL4 = new FoePokemon(Species.GEODUDE, 4, FoeType.TRAINER);
        buttonRussellGeodudeL4.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(russellGeodudeL4, buttonRussellGeodudeL4)));
        this.add(buttonRussellGeodudeL4);

        buttonRussellGeodudeL6 = new JButton("L6");
        buttonRussellGeodudeL6.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL6.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL6.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL6.setIcon(new ImageIcon(getClass().getResource("/crystal/geodude.png")));
        buttonRussellGeodudeL6.setBounds(639,374,73,50);
        buttonRussellGeodudeL6.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL6.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon russellGeodudeL6 = new FoePokemon(Species.GEODUDE, 6, FoeType.TRAINER);
        buttonRussellGeodudeL6.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(russellGeodudeL6, buttonRussellGeodudeL6)));
        this.add(buttonRussellGeodudeL6);

        buttonRussellGeodudeL8 = new JButton("L8");
        buttonRussellGeodudeL8.setVerticalAlignment(JLabel.CENTER);
        buttonRussellGeodudeL8.setVerticalTextPosition(JLabel.CENTER);
        buttonRussellGeodudeL8.setHorizontalTextPosition(JLabel.RIGHT);
        buttonRussellGeodudeL8.setIcon(new ImageIcon(getClass().getResource("/crystal/geodude.png")));
        buttonRussellGeodudeL8.setBounds(712,374,73,50);
        buttonRussellGeodudeL8.setMargin(new Insets(1,0,1,0));
        buttonRussellGeodudeL8.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon russellGeodudeL8 = new FoePokemon(Species.GEODUDE, 8, FoeType.TRAINER);
        buttonRussellGeodudeL8.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(russellGeodudeL8, buttonRussellGeodudeL8)));
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
        buttonBillKoffingL6_1.setIcon(new ImageIcon(getClass().getResource("/crystal/koffing.png")));
        buttonBillKoffingL6_1.setBounds(566,426,73,50);
        buttonBillKoffingL6_1.setMargin(new Insets(1,0,1,0));
        buttonBillKoffingL6_1.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon billKoffingL6_1 = new FoePokemon(Species.KOFFING, 6, FoeType.TRAINER);
        buttonBillKoffingL6_1.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(billKoffingL6_1, buttonBillKoffingL6_1)));
        this.add(buttonBillKoffingL6_1);

        buttonBillKoffingL6_2 = new JButton("L6");
        buttonBillKoffingL6_2.setVerticalAlignment(JLabel.CENTER);
        buttonBillKoffingL6_2.setVerticalTextPosition(JLabel.CENTER);
        buttonBillKoffingL6_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonBillKoffingL6_2.setIcon(new ImageIcon(getClass().getResource("/crystal/koffing.png")));
        buttonBillKoffingL6_2.setBounds(639,426,73,50);
        buttonBillKoffingL6_2.setMargin(new Insets(1,0,1,0));
        buttonBillKoffingL6_2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon billKoffingL6_2 = new FoePokemon(Species.KOFFING, 6, FoeType.TRAINER);
        buttonBillKoffingL6_2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(billKoffingL6_2, buttonBillKoffingL6_2)));
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
        FoePokemon anthonyGeodudeL11 = new FoePokemon(Species.GEODUDE, 11, FoeType.TRAINER);
        buttonAnthonyGeodudeL11.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(anthonyGeodudeL11, buttonAnthonyGeodudeL11)));
        this.add(buttonAnthonyGeodudeL11);

        buttonAnthonyMachopL11 = new JButton("L11");
        buttonAnthonyMachopL11.setVerticalAlignment(JLabel.CENTER);
        buttonAnthonyMachopL11.setVerticalTextPosition(JLabel.CENTER);
        buttonAnthonyMachopL11.setHorizontalTextPosition(JLabel.RIGHT);
        buttonAnthonyMachopL11.setIcon(new ImageIcon(getClass().getResource("/crystal/machop.png")));
        buttonAnthonyMachopL11.setBounds(639,478,73,50);
        buttonAnthonyMachopL11.setMargin(new Insets(1,0,1,0));
        buttonAnthonyMachopL11.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon anthonyMachopL11 = new FoePokemon(Species.MACHOP, 11, FoeType.TRAINER);
        buttonAnthonyMachopL11.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(anthonyMachopL11, buttonAnthonyMachopL11)));
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
        FoePokemon gruntRattataL9_1 = new FoePokemon(Species.RATTATA, 9, FoeType.TRAINER);
        buttonGruntRattataL9_1.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(gruntRattataL9_1, buttonGruntRattataL9_1)));
        this.add(buttonGruntRattataL9_1);

        buttonGruntRattataL9_2 = new JButton("L9");
        buttonGruntRattataL9_2.setVerticalAlignment(JLabel.CENTER);
        buttonGruntRattataL9_2.setVerticalTextPosition(JLabel.CENTER);
        buttonGruntRattataL9_2.setHorizontalTextPosition(JLabel.RIGHT);
        buttonGruntRattataL9_2.setIcon(new ImageIcon(getClass().getResource("/crystal/rattata.png")));
        buttonGruntRattataL9_2.setBounds(639,530,73,50);
        buttonGruntRattataL9_2.setMargin(new Insets(1,0,1,0));
        buttonGruntRattataL9_2.setFont(new Font(this.font, Font.BOLD, 12));
        FoePokemon gruntRattataL9_2 = new FoePokemon(Species.RATTATA, 9, FoeType.TRAINER);
        buttonGruntRattataL9_2.addActionListener(new DVPanelActionListener(this, this.getStarter(), new TrainerPokeAdapter(gruntRattataL9_2, buttonGruntRattataL9_2)));
        this.add(buttonGruntRattataL9_2);
    }

    public void resetAction() {
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
    }
}