import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class WildPokeButtonGroup {
    public static final int AMOUNT_WIDTH = 50;
    public static final int AMOUNT_HEIGHT = 24;
    public static final int ICON_WIDTH = 40;
    public static final int ICON_HEIGHT = 40;
    public static final int BUTTON_WIDTH = 26;
    public static final int BUTTON_HEIGHT = 26;

    private GSCDVCalculatorPanel dvPanel;
    private JLabel amountLabel;
    private JLabel iconLabel;
    private Integer[] levelsArray;
    private JButton[] foeButtons;
    private int numButtons;

    public WildPokeButtonGroup(GSCDVCalculatorPanel dvPanel, Species species, Integer... levels) {
        this.numButtons = levels.length;
        Set<Integer> levelList = new LinkedHashSet<Integer>(Arrays.asList(levels));
        this.dvPanel = dvPanel;
        this.amountLabel = new JLabel("×0");
        this.amountLabel.setFont(new Font(GSCHelper.FONT, Font.BOLD, 20));
        this.iconLabel =
                new JLabel(
                        new ImageIcon(getClass().getResource(species.getSpriteFilename(dvPanel.getGame()))));
        this.levelsArray = levelList.toArray(new Integer[numButtons]);
        Arrays.sort(levelsArray);
        this.foeButtons = new JButton[numButtons];
        for (int i = 0; i < numButtons; i++) {
            int level = levelsArray[i];
            FoePokemon foe = new FoePokemon(species, level, FoeType.WILD);
            JButton button = new JButton("L" + Integer.toString(level));
            button.setMargin(new Insets(1, 1, 1, 1));
            button.setFont(new Font(GSCHelper.FONT, Font.BOLD, 14));
            button.addActionListener(
                    new FoePokemonActionListener(dvPanel, foe, new WildPokeEventCallback(this.amountLabel)));
            this.foeButtons[i] = button;
        }
    }

    public void initialize(int iconX, int iconY) {
        initializeWithOffset(iconX, iconY, levelsArray[levelsArray.length - 1]);
    }

    // Convoluted way of lining up buttons when you don't want them right aligned with the icon.
    // For example, L2-L3 Sentret lined up below L2-L4 Pidgey. Aligning L2 and L3 with Pidgey's will cause a gap.
    // So, rightmostLevel in this exmample would be 4 for the Sentret group.
    public void initializeWithOffset(int iconX, int iconY, int rightmostLevel) {
        this.amountLabel.setBounds(iconX + 43, iconY + 9, AMOUNT_WIDTH, AMOUNT_HEIGHT);
        this.dvPanel.add(this.amountLabel);
        this.iconLabel.setBounds(iconX, iconY, ICON_WIDTH, ICON_HEIGHT);
        this.dvPanel.add(this.iconLabel);
        int buttonY = iconY + 6;
        for (int i = numButtons - 1; i >= 0; i--) {
            int rightIndex =
                    (rightmostLevel - levelsArray[numButtons - 1]) + (this.foeButtons.length - 1) - i;
            int buttonX = iconX - rightIndex * 28 - 32;
            this.foeButtons[i].setBounds(buttonX, buttonY, BUTTON_WIDTH, BUTTON_HEIGHT);
            this.dvPanel.add(this.foeButtons[i]);
        }
    }

    public void reset() {
        this.amountLabel.setText("×0");
    }
}
