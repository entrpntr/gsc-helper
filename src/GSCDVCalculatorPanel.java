import javax.swing.*;

public abstract class GSCDVCalculatorPanel extends JPanel {
    private HelperFrame parent;
    String font;
    abstract void removeStat(int column, int index);
    abstract void reset();
    abstract void updateButtons(Column column, int value);
    public GSCDVCalculatorPanel(HelperFrame parent) {
        this.parent = parent;
    }
    public HelperFrame getHelperFrame() {
        return parent;
    }
}
