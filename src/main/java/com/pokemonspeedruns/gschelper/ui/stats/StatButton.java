package com.pokemonspeedruns.gschelper.ui.stats;

import com.pokemonspeedruns.gschelper.GSCHelper;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatButton {
    private static final Font LABEL_FONT = new Font(GSCHelper.FONT, Font.BOLD, 12);
    private static final Font BUTTON_FONT = new Font(GSCHelper.FONT, Font.BOLD, 14);

    private GSCDVCalculatorPanel dvCalcPanel;
    private int value;
    private int dv;
    private JButton button;
    private JLabel label;
    private DVColumn column;
    private boolean possible;

    public int getDv() {
        return dv;
    }

    public boolean isPossible() {
        return possible;
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButton() {
        return button;
    }

    public int getValue() {
        return value;
    }

    public void setPossible(boolean possible) {
        this.possible = possible;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public StatButton(
            GSCDVCalculatorPanel dvCalcPanel, DVColumn column, int dv, int value, int x, int y) {
        this.dvCalcPanel = dvCalcPanel;
        this.possible = true;
        this.column = column;
        this.value = value;
        this.dv = dv;
        this.label = new JLabel(Integer.toString(dv));
        this.label.setBounds(x - 29, y + 79, 22, 22);
        this.label.setFont(LABEL_FONT);
        this.label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.label.setHorizontalAlignment(SwingConstants.RIGHT);
        this.makeButton("" + value, x - 6, y + 79);
        label.addMouseListener(new DVPanelMouseAdapter(dvCalcPanel, label, button, column, dv));
    }

    private void makeButton(String text, int x, int y) {
        this.button = new JButton(text);
        this.button.setBounds(x, y, 50, 22);
        this.button.setFont(BUTTON_FONT);
        this.button.setMargin(new Insets(1, 0, 1, 0));
        this.button.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        dvCalcPanel.updateButtons(column, value);
                    }
                });
    }
}
