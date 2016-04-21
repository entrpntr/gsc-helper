import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DVPanelActionListener implements ActionListener {
    private GSCDVCalculatorPanel dvPanel;
    private PartyPokemon partyPoke;
    private PokeAdapter foePoke;

    public DVPanelActionListener(GSCDVCalculatorPanel dvPanel, PartyPokemon partyPoke, PokeAdapter foePoke) {
        this.dvPanel = dvPanel;
        this.partyPoke = partyPoke;
        this.foePoke = foePoke;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean gainedLevel = partyPoke.rekt(foePoke.getPoke());
        foePoke.gotRekt();
        if(gainedLevel) {
            dvPanel.updateStats();
        }
    }
}
