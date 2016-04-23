import javax.swing.*;

public class TrainerPokeAdapter extends PokeAdapter {
    private JButton pokeButton;

    public TrainerPokeAdapter(FoePokemon poke, JButton pokeButton) {
        super(poke);
        this.pokeButton = pokeButton;
    }

    @Override
    public void gotRekt() {
        pokeButton.setEnabled(false);
    }
}
