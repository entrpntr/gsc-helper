import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StatButton {
    public GSCDVCalculatorPanel dvCalcPanel;
    public int value;
    public int dv;
    public JButton button;
    public JLabel label;
    public DVColumn column;
    public boolean possible;

    public StatButton(GSCDVCalculatorPanel dvCalcPanel, DVColumn column, int dv, int value, int x, int y) {
        this.dvCalcPanel = dvCalcPanel;
        this.possible = true;
        this.column = column;
        this.value = value;
        this.dv = dv;
        this.label = new JLabel(Integer.toString(dv));
        this.label.setBounds(x - 29, y + 79, 22, 22);
        this.label.setFont(new Font(dvCalcPanel.font, Font.BOLD, 12));
        this.label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.label.setHorizontalAlignment(SwingConstants.RIGHT);
        this.makeButton("" + value, x - 6, y + 79);
        label.addMouseListener(new DVPanelMouseAdapter(dvCalcPanel.getHelperFrame(), label, button, column, dv));
    }

    private void makeButton(String text, int x, int y) {
        this.button = new JButton(text);
        this.button.setBounds(x, y, 50, 22);
        this.button.setFont(new Font(dvCalcPanel.font, Font.BOLD, 14));
        this.button.setMargin(new Insets(1, 0, 1, 0));
        this.button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                dvCalcPanel.updateButtons(column, value);
            }
        });
    }
}