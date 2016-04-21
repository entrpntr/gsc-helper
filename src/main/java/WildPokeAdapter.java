import javax.swing.*;

public class WildPokeAdapter extends PokeAdapter {
    FoePokemon poke;
    private JLabel amountLabel;

    public WildPokeAdapter(FoePokemon poke, JLabel amountLabel) {
        super(poke);
        this.poke = poke;
        this.amountLabel = amountLabel;
    }

    @Override
    public void gotRekt() {
        int amount = Integer.parseInt(amountLabel.getText().substring(1));
        amountLabel.setText("×" + ++amount);
    }
}
