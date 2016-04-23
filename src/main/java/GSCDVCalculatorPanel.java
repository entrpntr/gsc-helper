import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class GSCDVCalculatorPanel extends JPanel {
    private PartyPokemon starter;
    private Game game;
    private HelperFrame parent;
    private JLabel labelTotoLevel;
    boolean[] redHP = new boolean[16];
    boolean[] redAtk = new boolean[16];
    boolean[] redDef = new boolean[16];
    boolean[] redSpd = new boolean[16];
    boolean[] redSpc = new boolean[16];
    ArrayList<StatButton> hpStats;
    ArrayList<StatButton> atkStats;
    ArrayList<StatButton> defStats;
    ArrayList<StatButton> spdStats;
    ArrayList<StatButton> spcStats;
    String font;
    public GSCDVCalculatorPanel(HelperFrame parent, Game game, PartyPokemon starter, String font) {
        this.parent = parent;
        this.game = game;
        this.starter = starter;
        this.font = font;
        this.setLayout(null);
        this.setBounds(0, 0, 792, 594);
        this.setBackground(null);
        this.init();
        this.initStatButtons();
        this.updateStats();
    }
    public PartyPokemon getStarter() {
        return starter;
    }
    public void init() {
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
        JLabel labelTotoIcon = new JLabel(new ImageIcon(getClass().getResource("/" + game.name().toLowerCase() + "/" + starter.getSpecies().getBackspriteFilename())));
        labelTotoIcon.setBounds(134, 4, 48, 48);
        this.add(labelTotoIcon);
        this.labelTotoLevel = new JLabel("Level: " + starter.getLevel());
        this.labelTotoLevel.setBounds(196,4,150,48);
        this.labelTotoLevel.setFont(new Font(this.font,Font.BOLD,29));
        this.add(this.labelTotoLevel);
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
            statValue = Math.floor(((double)((starter.getBaseHP() + i + 50) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 10.0);
            stat = new StatButton(this, DVColumn.HP, i, (int)statValue, 30, 11 + i * 22);
            this.hpStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.atkStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getAtkStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getAtkStatExp() - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((starter.getBaseAtk() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            stat = new StatButton(this, DVColumn.ATK, i, (int)statValue, 120, 11 + i * 22);
            this.atkStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.defStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getDefStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getDefStatExp() - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((starter.getBaseDef() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            stat = new StatButton(this, DVColumn.DEF, i, (int)statValue, 210, 11 + i * 22);
            this.defStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.spdStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getSpdStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getSpdStatExp() - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((starter.getBaseSpe() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            stat = new StatButton(this, DVColumn.SPD, i, (int)statValue, 390, 11 + i * 22);
            this.spdStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
        this.spcStats = new ArrayList<StatButton>();
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getSpcStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getSpcStatExp() - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((starter.getBaseSpA() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            double spcDefValue = Math.floor(((double)((starter.getBaseSpD() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            stat = new StatButton(this, DVColumn.SPC, i, (int)statValue*(int)spcDefValue, 300, 11 + i * 22);
            this.spcStats.add(stat);
            this.add(stat.label);
            this.add(stat.button);
        }
    }
    public abstract void resetAction();
    public void reset() {
        resetStats();
        resetAction();
    }
    public void resetStats() {
        int i;
        starter.reset();
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
            statValue = Math.floor(((double)((starter.getBaseHP() + i + 50) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 10.0);
            this.hpStats.get(i).button.setText("" + (int)statValue);
            this.hpStats.get(i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getAtkStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getAtkStatExp() - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((starter.getBaseAtk() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            this.atkStats.get(i).button.setText("" + (int)statValue);
            this.atkStats.get(i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getDefStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getDefStatExp() - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((starter.getBaseDef() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            this.defStats.get(i).button.setText("" + (int)statValue);
            this.defStats.get(i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getSpdStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getSpdStatExp() - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((starter.getBaseSpe() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            this.spdStats.get(i).button.setText("" + (int)statValue);
            this.spdStats.get(i).value = (int)statValue;
        }
        for (i = 0; i < 16; ++i) {
            extraStats = 0.0;
            if (starter.getSpcStatExp() - 1 >= 0) {
                extraStats = Math.floor(Math.floor(Math.sqrt(starter.getSpcStatExp() - 1) + 1.0) / 4.0);
            }
            statValue = Math.floor(((double)((starter.getBaseSpA() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            double spcDefValue = Math.floor(((double)((starter.getBaseSpD() + i) * 2) + extraStats) * (double) starter.getLevel() / 100.0 + 5.0);
            this.spcStats.get(i).button.setText("" + (int)statValue + "/" + (int)spcDefValue);
            this.spcStats.get(i).value = (int)statValue*(int)spcDefValue;
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
        if (column == DVColumn.DEF) {
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
        if (column == DVColumn.SPD) {
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
        if (column == DVColumn.SPC) {
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
                    this.redHP[i * 2 ] = true;
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

    private boolean hasEven(ArrayList<StatButton> list) {
        boolean even = false;
        for (int i = 0; i < 8; ++i) {
            if (!list.get((i * 2)).possible) continue;
            even = true;
            break;
        }
        return even;
    }

    private boolean hasOdd(ArrayList<StatButton> list) {
        boolean odd = false;
        for (int i = 0; i < 8; ++i) {
            if (!list.get((i * 2 + 1)).possible) continue;
            odd = true;
            break;
        }
        return odd;
    }
}
