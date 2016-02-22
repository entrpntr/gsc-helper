import javax.swing.*;

public abstract class GSCDVCalculatorPanel extends JPanel {
    abstract void removeStat(int column, int index);
    abstract void reset();
}
