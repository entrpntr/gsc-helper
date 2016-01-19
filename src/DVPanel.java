import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DVPanel
extends JPanel {
    private static final long serialVersionUID = -39019383614299732L;
    private HelperFrame parent;
    private String font;
    private ButtonGroup hpButtonGroup;
    private ButtonGroup atkButtonGroup;
    private ButtonGroup defButtonGroup;
    private ButtonGroup spdButtonGroup;
    private ButtonGroup spcButtonGroup;
    private ArrayList<JRadioButton> hpButtons;
    private ArrayList<JRadioButton> atkButtons;
    private ArrayList<JRadioButton> defButtons;
    private ArrayList<JRadioButton> spdButtons;
    private ArrayList<JRadioButton> spcButtons;
    private int hpdv;
    private int atkdv;
    private int defdv;
    private int spddv;
    private int spcdv;
    private boolean useTopPanel;
    private boolean[] redHP = new boolean[16];
    private boolean[] redAtk = new boolean[16];
    private boolean[] redDef = new boolean[16];
    private boolean[] redSpd = new boolean[16];
    private boolean[] redSpc = new boolean[16];

    public DVPanel(HelperFrame parent, String font) {
        this.parent = parent;
        this.font = font;
        this.setLayout(null);
        this.setBounds(0, 0, 520, 160);
        this.initLabels();
        this.init();
    }

    @Override
    public void paintComponent(Graphics g) {
        int i;
        super.paintComponent(g);
        for (i = 0; i < 7; ++i) {
            g.drawLine(2, 2 + 26 * i, 515, 2 + 26 * i);
        }
        g.drawLine(2, 2, 2, 158);
        for (i = 0; i < 18; ++i) {
            g.drawLine(74 + 26 * i, 2, 74 + 26 * i, 158);
        }
    }

    private void initLabels() {
        JLabel dvLabel = new JLabel("DV");
        dvLabel.setFont(new Font(this.font, 1, 24));
        dvLabel.setBounds(5, 5, 70, 25);
        this.add(dvLabel);
        JLabel hpLabel = new JLabel("HP");
        hpLabel.setFont(new Font(this.font, 1, 16));
        hpLabel.setBounds(5, 29, 70, 30);
        this.add(hpLabel);
        JLabel atkLabel = new JLabel("Attack");
        atkLabel.setFont(new Font(this.font, 1, 16));
        atkLabel.setBounds(5, 55, 70, 30);
        this.add(atkLabel);
        JLabel defLabel = new JLabel("Defense");
        defLabel.setFont(new Font(this.font, 1, 16));
        defLabel.setBounds(5, 81, 75, 30);
        this.add(defLabel);
        JLabel spdLabel = new JLabel("Speed");
        spdLabel.setFont(new Font(this.font, 1, 16));
        spdLabel.setBounds(5, 107, 70, 30);
        this.add(spdLabel);
        JLabel spcLabel = new JLabel("Special");
        spcLabel.setFont(new Font(this.font, 1, 16));
        spcLabel.setBounds(5, 133, 70, 30);
        this.add(spcLabel);
        for (int i = 0; i < 17; ++i) {
            JLabel label = new JLabel("" + (i - 1));
            label.setFont(new Font(this.font, 1, 14));
            label.setBounds(70 + 26 * i, 5, 30, 30);
            label.setHorizontalAlignment(0);
            if (i == 0) {
                label.setText("?");
            }
            this.add(label);
        }
    }

    private void init() {
        JRadioButton button;
        int i;
        this.useTopPanel = false;
        for (int i2 = 0; i2 < 16; ++i2) {
            this.redHP[i2] = false;
            this.redAtk[i2] = false;
            this.redDef[i2] = false;
            this.redSpd[i2] = false;
            this.redSpc[i2] = false;
        }
        this.hpdv = -1;
        this.atkdv = -1;
        this.defdv = -1;
        this.spddv = -1;
        this.spcdv = -1;
        ActionListener actionListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton)e.getSource();
                int x = (int)button.getLocation().getX();
                int y = (int)button.getLocation().getY();
                int selectedColumn = (y - 29) / 26;
                int selectedDV = (x - 75) / 26 - 1;
                if (selectedDV != -1) {
                    for (int i = 0; i < 16; ++i) {
                        if (selectedDV == i) continue;
                        if (selectedColumn == 0) {
                            DVPanel.access$0((DVPanel)DVPanel.this)[i] = true;
                            DVPanel.this.parent.removeStat(0, i);
                        }
                        if (selectedColumn == 1) {
                            DVPanel.access$2((DVPanel)DVPanel.this)[i] = true;
                            DVPanel.this.parent.removeStat(1, i);
                        }
                        if (selectedColumn == 2) {
                            DVPanel.access$3((DVPanel)DVPanel.this)[i] = true;
                            DVPanel.this.parent.removeStat(2, i);
                        }
                        if (selectedColumn == 3) {
                            DVPanel.access$4((DVPanel)DVPanel.this)[i] = true;
                            DVPanel.this.parent.removeStat(3, i);
                        }
                        if (selectedColumn != 4) continue;
                        DVPanel.access$5((DVPanel)DVPanel.this)[i] = true;
                        DVPanel.this.parent.removeStat(4, i);
                    }
                }
                DVPanel.this.updateButtons();
                while (DVPanel.this.removeByRanges()) {
                    DVPanel.this.updateButtons();
                }
                DVPanel.this.setOnlyDV();
                DVPanel.this.updateLabels();
            }
        };
        this.hpButtonGroup = new ButtonGroup();
        this.hpButtons = new ArrayList(16);
        this.hpButtonGroup.add(new JRadioButton("", true));
        for (i = 0; i < 17; ++i) {
            button = new JRadioButton();
            button.setBounds(75 + 26 * i, 29, 25, 25);
            this.hpButtonGroup.add(button);
            this.hpButtons.add(button);
            this.add(button);
            if (i == 0) {
                this.hpButtonGroup.setSelected(button.getModel(), true);
            }
            button.addActionListener(actionListener);
        }
        this.atkButtonGroup = new ButtonGroup();
        this.atkButtons = new ArrayList(16);
        this.atkButtonGroup.add(new JRadioButton("", true));
        for (i = 0; i < 17; ++i) {
            button = new JRadioButton();
            button.setBounds(75 + 26 * i, 55, 25, 25);
            this.atkButtonGroup.add(button);
            this.atkButtons.add(button);
            this.add(button);
            if (i == 0) {
                this.atkButtonGroup.setSelected(button.getModel(), true);
            }
            button.addActionListener(actionListener);
        }
        this.defButtonGroup = new ButtonGroup();
        this.defButtons = new ArrayList(16);
        this.defButtonGroup.add(new JRadioButton("", true));
        for (i = 0; i < 17; ++i) {
            button = new JRadioButton();
            button.setBounds(75 + 26 * i, 81, 25, 25);
            this.defButtonGroup.add(button);
            this.defButtons.add(button);
            this.add(button);
            if (i == 0) {
                this.defButtonGroup.setSelected(button.getModel(), true);
            }
            button.addActionListener(actionListener);
        }
        this.spdButtonGroup = new ButtonGroup();
        this.spdButtons = new ArrayList(16);
        this.spdButtonGroup.add(new JRadioButton("", true));
        for (i = 0; i < 17; ++i) {
            button = new JRadioButton();
            button.setBounds(75 + 26 * i, 107, 25, 25);
            this.spdButtonGroup.add(button);
            this.spdButtons.add(button);
            this.add(button);
            if (i == 0) {
                this.spdButtonGroup.setSelected(button.getModel(), true);
            }
            button.addActionListener(actionListener);
        }
        this.spcButtonGroup = new ButtonGroup();
        this.spcButtons = new ArrayList(16);
        this.spcButtonGroup.add(new JRadioButton("", true));
        for (i = 0; i < 17; ++i) {
            button = new JRadioButton();
            button.setBounds(75 + 26 * i, 133, 25, 25);
            this.spcButtonGroup.add(button);
            this.spcButtons.add(button);
            this.add(button);
            if (i == 0) {
                this.spcButtonGroup.setSelected(button.getModel(), true);
            }
            button.addActionListener(actionListener);
        }
        for (i = 0; i < 17; ++i) {
            this.hpButtons.get(i).setEnabled(false);
            this.atkButtons.get(i).setEnabled(false);
            this.defButtons.get(i).setEnabled(false);
            this.spdButtons.get(i).setEnabled(false);
            this.spcButtons.get(i).setEnabled(false);
        }
    }

    private void updateButtons() {
        this.addExtraRed();
        if (this.hpdv != -1) {
            this.hpButtons.get(this.hpdv + 1).setBackground(null);
        }
        if (this.atkdv != -1) {
            this.atkButtons.get(this.atkdv + 1).setBackground(null);
        }
        if (this.defdv != -1) {
            this.defButtons.get(this.defdv + 1).setBackground(null);
        }
        if (this.spddv != -1) {
            this.spdButtons.get(this.spddv + 1).setBackground(null);
        }
        if (this.spcdv != -1) {
            this.spcButtons.get(this.spcdv + 1).setBackground(null);
        }
        if (this.useTopPanel) {
            if (this.hpdv != -1) {
                this.hpButtons.get(0).setEnabled(false);
                this.hpButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (this.atkdv != -1) {
                this.atkButtons.get(0).setEnabled(false);
                this.atkButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (this.defdv != -1) {
                this.defButtons.get(0).setEnabled(false);
                this.defButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (this.spddv != -1) {
                this.spdButtons.get(0).setEnabled(false);
                this.spdButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (this.spcdv != -1) {
                this.spcButtons.get(0).setEnabled(false);
                this.spcButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            for (int i = 0; i < 16; ++i) {
                if (this.redHP[i]) {
                    this.hpButtons.get(i + 1).setEnabled(false);
                }
                if (this.redAtk[i]) {
                    this.atkButtons.get(i + 1).setEnabled(false);
                }
                if (this.redDef[i]) {
                    this.defButtons.get(i + 1).setEnabled(false);
                }
                if (this.redSpd[i]) {
                    this.spdButtons.get(i + 1).setEnabled(false);
                }
                if (!this.redSpc[i]) continue;
                this.spcButtons.get(i + 1).setEnabled(false);
            }
        }
    }

    private void addExtraRed() {
        for (int i = 0; i < 16; ++i) {
            if (this.redHP[i]) {
                this.hpButtons.get(i + 1).setBackground(new Color(255, 175, 175));
            }
            if (this.redAtk[i]) {
                this.atkButtons.get(i + 1).setBackground(new Color(255, 175, 175));
            }
            if (this.redDef[i]) {
                this.defButtons.get(i + 1).setBackground(new Color(255, 175, 175));
            }
            if (this.redSpd[i]) {
                this.spdButtons.get(i + 1).setBackground(new Color(255, 175, 175));
            }
            if (!this.redSpc[i]) continue;
            this.spcButtons.get(i + 1).setBackground(new Color(255, 175, 175));
        }
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
                if (this.hpButtons.get(i + 1).getBackground().getRed() != 255) {
                    ++possibleHP;
                    newHP = i;
                }
                if (this.atkButtons.get(i + 1).getBackground().getRed() != 255 || this.atkButtons.get(i + 1).getBackground().getGreen() == 255) {
                    ++possibleAtk;
                    newAtk = i;
                }
                if (this.defButtons.get(i + 1).getBackground().getRed() != 255) {
                    ++possibleDef;
                    newDef = i;
                }
                if (this.spdButtons.get(i + 1).getBackground().getRed() != 255 || this.spdButtons.get(i + 1).getBackground().getGreen() == 255) {
                    ++possibleSpd;
                    newSpd = i;
                }
                if (this.spcButtons.get(i + 1).getBackground().getRed() == 255) continue;
                ++possibleSpc;
                newSpc = i;
            }
            if (possibleHP == 1) {
                if (this.hpdv != newHP) {
                    update = true;
                }
                this.hpdv = newHP;
                this.hpButtons.get(this.hpdv + 1).setSelected(true);
                this.hpButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (possibleAtk == 1) {
                if (this.atkdv != newAtk) {
                    update = true;
                }
                this.atkdv = newAtk;
                this.atkButtons.get(this.atkdv + 1).setSelected(true);
                this.atkButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (possibleDef == 1) {
                if (this.defdv != newDef) {
                    update = true;
                }
                this.defdv = newDef;
                this.defButtons.get(this.defdv + 1).setSelected(true);
                this.defButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (possibleSpd == 1) {
                if (this.spddv != newSpd) {
                    update = true;
                }
                this.spddv = newSpd;
                this.spdButtons.get(this.spddv + 1).setSelected(true);
                this.spdButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (possibleSpc == 1) {
                if (this.spcdv != newSpc) {
                    update = true;
                }
                this.spcdv = newSpc;
                this.spcButtons.get(this.spcdv + 1).setSelected(true);
                this.spcButtons.get(0).setBackground(new Color(255, 175, 175));
            }
            if (!update) continue;
            this.updateButtons();
            for (i = 0; i < 16; ++i) {
                if (this.hpButtons.get(i + 1).getBackground().getRed() == 255) {
                    this.parent.removeStat(0, i);
                }
                if (this.atkButtons.get(i + 1).getBackground().getRed() == 255 && this.atkButtons.get(i + 1).getBackground().getGreen() != 255) {
                    this.parent.removeStat(1, i);
                }
                if (this.defButtons.get(i + 1).getBackground().getRed() == 255) {
                    this.parent.removeStat(2, i);
                }
                if (this.spdButtons.get(i + 1).getBackground().getRed() == 255 && this.spdButtons.get(i + 1).getBackground().getGreen() != 255) {
                    this.parent.removeStat(3, i);
                }
                if (this.spcButtons.get(i + 1).getBackground().getRed() != 255) continue;
                this.parent.removeStat(4, i);
            }
        }
    }

    public void externalRed(boolean[] redHP, boolean[] redAtk, boolean[] redDef, boolean[] redSpd, boolean[] redSpc) {
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
        this.updateButtons();
        while (this.removeByRanges()) {
            this.updateButtons();
        }
        this.setOnlyDV();
        this.updateLabels();
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
            if (this.hpButtons.get(i + 1).getBackground().getRed() != 255) {
                if (firstHP == -1) {
                    firstHP = i;
                }
                lastHP = i;
                ++possibleHP;
            }
            if (this.atkButtons.get(i + 1).getBackground().getRed() != 255 || this.atkButtons.get(i + 1).getBackground().getGreen() == 255) {
                if (firstAtk == -1) {
                    firstAtk = i;
                }
                lastAtk = i;
                ++possibleAtk;
            }
            if (this.defButtons.get(i + 1).getBackground().getRed() != 255) {
                if (firstDef == -1) {
                    firstDef = i;
                }
                lastDef = i;
                ++possibleDef;
            }
            if (this.spdButtons.get(i + 1).getBackground().getRed() != 255 || this.spdButtons.get(i + 1).getBackground().getGreen() == 255) {
                if (firstSpd == -1) {
                    firstSpd = i;
                }
                lastSpd = i;
                ++possibleSpd;
            }
            if (this.spcButtons.get(i + 1).getBackground().getRed() == 255) continue;
            if (firstSpc == -1) {
                firstSpc = i;
            }
            lastSpc = i;
            ++possibleSpc;
        }
        this.parent.updateToto(0, firstHP, lastHP, possibleHP);
        this.parent.updateToto(1, firstAtk, lastAtk, possibleAtk);
        this.parent.updateToto(2, firstDef, lastDef, possibleDef);
        this.parent.updateToto(3, firstSpd, lastSpd, possibleSpd);
        this.parent.updateToto(4, firstSpc, lastSpc, possibleSpc);
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
            if (this.hpButtons.get(i + 1).getBackground().getRed() == 255) {
                hpPossible[i] = false;
            }
            if (this.atkButtons.get(i + 1).getBackground().getRed() == 255 && this.atkButtons.get(i + 1).getBackground().getGreen() != 255) {
                atkPossible[i] = false;
            }
            if (this.defButtons.get(i + 1).getBackground().getRed() == 255) {
                defPossible[i] = false;
            }
            if (this.spdButtons.get(i + 1).getBackground().getRed() == 255 && this.spdButtons.get(i + 1).getBackground().getGreen() != 255) {
                spdPossible[i] = false;
            }
            if (this.spcButtons.get(i + 1).getBackground().getRed() != 255) continue;
            spcPossible[i] = false;
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
                      if (!hpPossible[i % 2 * 8 + j % 2 * 4 + k % 2 * 2 + l % 2 * 1]) continue;
                        newHPRed[i % 2 * 8 + j % 2 * 4 + k % 2 * 2 + l % 2 * 1] = true;
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
                this.parent.removeStat(0, i);
            }
            if (atkPossible[i] && !newAtkRed[i]) {
                success = true;
                this.redAtk[i] = true;
                this.parent.removeStat(1, i);
            }
            if (defPossible[i] && !newDefRed[i]) {
                success = true;
                this.redDef[i] = true;
                this.parent.removeStat(2, i);
            }
            if (spdPossible[i] && !newSpdRed[i]) {
                success = true;
                this.redSpd[i] = true;
                this.parent.removeStat(3, i);
            }
            if (spcPossible[i] && !newSpcRed[i]) {
                success = true;
                this.redSpc[i] = true;
                this.parent.removeStat(4, i);
            }

        }
        return success;
    }

    public void useTopPanel(boolean enabled) {
        this.useTopPanel = enabled;
        if (this.useTopPanel) {
            for (int i = 0; i < 17; ++i) {
                this.hpButtons.get(i).setEnabled(true);
                this.atkButtons.get(i).setEnabled(true);
                this.defButtons.get(i).setEnabled(true);
                this.spdButtons.get(i).setEnabled(true);
                this.spcButtons.get(i).setEnabled(true);
            }
        } else {
            for (int i = 0; i < 17; ++i) {
                this.hpButtons.get(i).setEnabled(false);
                this.atkButtons.get(i).setEnabled(false);
                this.defButtons.get(i).setEnabled(false);
                this.spdButtons.get(i).setEnabled(false);
                this.spcButtons.get(i).setEnabled(false);
            }
        }
        this.updateButtons();
    }

    public void reset() {
        int i;
        for (i = 0; i < 16; ++i) {
            this.redHP[i] = false;
            this.redAtk[i] = false;
            this.redDef[i] = false;
            this.redSpd[i] = false;
            this.redSpc[i] = false;
        }
        for (i = 0; i < 17; ++i) {
            this.hpButtons.get(i).setBackground(null);
            this.atkButtons.get(i).setBackground(null);
            this.defButtons.get(i).setBackground(null);
            this.spdButtons.get(i).setBackground(null);
            this.spcButtons.get(i).setBackground(null);
        }
        for (i = 0; i < 17; ++i) {
            this.hpButtons.get(i).setEnabled(this.useTopPanel);
            this.atkButtons.get(i).setEnabled(this.useTopPanel);
            this.defButtons.get(i).setEnabled(this.useTopPanel);
            this.spdButtons.get(i).setEnabled(this.useTopPanel);
            this.spcButtons.get(i).setEnabled(this.useTopPanel);
        }
        this.hpButtons.get(0).setSelected(true);
        this.atkButtons.get(0).setSelected(true);
        this.defButtons.get(0).setSelected(true);
        this.spdButtons.get(0).setSelected(true);
        this.spcButtons.get(0).setSelected(true);
        this.hpdv = -1;
        this.atkdv = -1;
        this.defdv = -1;
        this.spddv = -1;
        this.spcdv = -1;
    }

    static /* synthetic */ boolean[] access$0(DVPanel dVPanel) {
        return dVPanel.redHP;
    }

    static /* synthetic */ boolean[] access$2(DVPanel dVPanel) {
        return dVPanel.redAtk;
    }

    static /* synthetic */ boolean[] access$3(DVPanel dVPanel) {
        return dVPanel.redDef;
    }

    static /* synthetic */ boolean[] access$4(DVPanel dVPanel) {
        return dVPanel.redSpd;
    }

    static /* synthetic */ boolean[] access$5(DVPanel dVPanel) {
        return dVPanel.redSpc;
    }

}

