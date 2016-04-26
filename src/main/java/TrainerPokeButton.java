import javax.swing.*;
import java.awt.*;

public class TrainerPokeButton extends JButton {
    public static final Font LEVEL_FONT = new Font(GSCHelper.FONT, Font.BOLD, 12);
    public static final int WIDTH = 73;
    public static final int HEIGHT = 50;

    private GSCDVCalculatorPanel dvPanel;

    public TrainerPokeButton(GSCDVCalculatorPanel dvPanel, Species species, int level) {
        this.dvPanel = dvPanel;
        this.setText("L" + Integer.toString(level));
        this.setVerticalAlignment(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setHorizontalTextPosition(JLabel.RIGHT);
        this.setIcon(
                new ImageIcon(getClass().getResource(species.getSpriteFilename(dvPanel.getGame()))));
        this.setMargin(new Insets(1, 0, 1, 0));
        this.setFont(LEVEL_FONT);

        FoePokemon foe = new FoePokemon(species, level, FoeType.TRAINER);
        this.addActionListener(
                new FoePokemonActionListener(dvPanel, foe, new TrainerPokeEventCallback(this)));
    }

    public void initialize(int x, int y) {
        this.setBounds(x, y, WIDTH, HEIGHT);
        this.dvPanel.add(this);
    }
}
