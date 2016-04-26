package com.pokemonspeedruns.gschelper.ui.stats;

import com.pokemonspeedruns.gschelper.ui.HelperFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DVPanelMouseAdapter extends MouseAdapter {
    private HelperFrame parent;
    private JLabel label;
    private JButton button;
    private DVColumn column;
    private int dv;

    DVPanelMouseAdapter(HelperFrame parent, JLabel label, JButton button, DVColumn column, int dv) {
        this.parent = parent;
        this.label = label;
        this.button = button;
        this.column = column;
        this.dv = dv;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setForeground(Color.GREEN);
        button.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1, true));
        button.setBackground(Color.GREEN);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setForeground(Color.BLACK);
        button.setBorder(UIManager.getBorder("Button.border"));
        button.setBackground((Color) UIManager.getBorder("Button.background"));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setForeground(Color.BLACK);
        button.setBorder(UIManager.getBorder("Button.border"));
        button.setBackground((Color) UIManager.getBorder("Button.background"));
        parent.manuallySelectDV(column.ordinal(), dv);
    }
}
