import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TrainerPokeButtonGroup {
    public static final int LABEL_WIDTH = 124;
    public static final int LABEL_HEIGHT = 24;
    public static final Font TRAINER_FONT = new Font(GSCHelper.FONT, Font.BOLD, 11);

    private GSCDVCalculatorPanel dvPanel;
    private JLabel trainerLabel;
    private TrainerPokeButton[] pokeButtons;
    public TrainerPokeButtonGroup(GSCDVCalculatorPanel dvPanel, String trainerName, TrainerPokeButton... buttons) {
        this.dvPanel = dvPanel;
        this.trainerLabel = new JLabel(trainerName);
        this.trainerLabel.setFont(TRAINER_FONT);
        this.pokeButtons = Arrays.asList(buttons).toArray(new TrainerPokeButton[buttons.length]);
    }

    public void initialize(int labelX, int labelY) {
        this.trainerLabel.setBounds(labelX, labelY, LABEL_WIDTH, LABEL_HEIGHT);
        this.dvPanel.add(this.trainerLabel);
        int baseButtonX = labelX + 65;
        int buttonY = labelY - 13;
        for(int i=0; i<pokeButtons.length; i++) {
            this.pokeButtons[i].initialize(baseButtonX + i*TrainerPokeButton.WIDTH, buttonY);
            this.dvPanel.add(this.pokeButtons[i]);
        }
    }

    public void reset() {
        for(TrainerPokeButton btn : this.pokeButtons) {
            btn.setEnabled(true);
        }
    }
}
