import javax.swing.*;
import java.awt.*;

public class GoldTotoDVCalculatorPanel extends GSCDVCalculatorPanel {
    private static final long serialVersionUID = -7545905343679467024L;

    private WildPokeButtonGroup wildPidgeyGroup;
    private WildPokeButtonGroup wildSentretGroup;
    private WildPokeButtonGroup wildRattataGroup;
    private WildPokeButtonGroup wildCaterpieGroup;
    private WildPokeButtonGroup wildHoppipGroup;

    private TrainerPokeButtonGroup rivalGroup;
    private TrainerPokeButtonGroup mikeyGroup;
    private TrainerPokeButtonGroup donGroup;
    private TrainerPokeButtonGroup abeGroup;
    private TrainerPokeButtonGroup rodGroup;
    private TrainerPokeButtonGroup falknerGroup;
    private TrainerPokeButtonGroup albertGroup;
    private TrainerPokeButtonGroup ralphGroup;
    private TrainerPokeButtonGroup danielGroup;
    private TrainerPokeButtonGroup russellGroup;

    public GoldTotoDVCalculatorPanel(HelperFrame parent, PartyPokemon totodile) {
        super(parent, Game.GOLD, totodile);
    }

    @Override
    public void initAction() {
        ////////////////
        // WILD POKES //
        ////////////////
        JLabel labelWild = new JLabel("Wild Pokes");
        labelWild.setBounds(155, 459, 190, 42);
        labelWild.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(labelWild);

        // PIDGEY
        wildPidgeyGroup = new WildPokeButtonGroup(this, Species.PIDGEY, 2, 3, 4);
        wildPidgeyGroup.initialize(102, 503);
        // SENTRET
        wildSentretGroup = new WildPokeButtonGroup(this, Species.SENTRET, 2, 3);
        wildSentretGroup.initializeWithOffset(102, 549, 4);
        // RATTATA
        wildRattataGroup = new WildPokeButtonGroup(this, Species.RATTATA, 4);
        wildRattataGroup.initialize(249, 503);
        // CATERPIE
        wildCaterpieGroup = new WildPokeButtonGroup(this, Species.CATERPIE, 3, 4);
        wildCaterpieGroup.initialize(249, 549);
        // HOPPIP
        wildHoppipGroup = new WildPokeButtonGroup(this, Species.HOPPIP, 6);
        wildHoppipGroup.initialize(368, 503);

        //////////////
        // TRAINERS //
        //////////////
        JLabel labelTrainers = new JLabel("Trainers");
        labelTrainers.setBounds(498, 4, 150, 48);
        labelTrainers.setFont(new Font(GSCHelper.FONT, Font.BOLD, 29));
        this.add(labelTrainers);

        // RIVAL 1
        TrainerPokeButton rivalChikoritaL5 = new TrainerPokeButton(this, Species.CHIKORITA, 5);
        rivalGroup = new TrainerPokeButtonGroup(this, "RIVAL 1", rivalChikoritaL5);
        rivalGroup.initialize(501, 75);
        // MIKEY
        TrainerPokeButton mikeyPidgeyL2 = new TrainerPokeButton(this, Species.PIDGEY, 2);
        TrainerPokeButton mikeyRattataL4 = new TrainerPokeButton(this, Species.RATTATA, 4);
        mikeyGroup = new TrainerPokeButtonGroup(this, "MIKEY", mikeyPidgeyL2, mikeyRattataL4);
        mikeyGroup.initialize(501, 127);
        // DON
        TrainerPokeButton donCaterpieL3_1 = new TrainerPokeButton(this, Species.CATERPIE, 3);
        TrainerPokeButton donCaterpieL3_2 = new TrainerPokeButton(this, Species.CATERPIE, 3);
        donGroup = new TrainerPokeButtonGroup(this, "DON", donCaterpieL3_1, donCaterpieL3_2);
        donGroup.initialize(501, 179);
        // ABE
        TrainerPokeButton abeSpearowL9 = new TrainerPokeButton(this, Species.SPEAROW, 9);
        abeGroup = new TrainerPokeButtonGroup(this, "ABE", abeSpearowL9);
        abeGroup.initialize(501, 231);
        // ROD
        TrainerPokeButton rodPidgeyL7_1 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        TrainerPokeButton rodPidgeyL7_2 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        rodGroup = new TrainerPokeButtonGroup(this, "ROD", rodPidgeyL7_1, rodPidgeyL7_2);
        rodGroup.initialize(501, 283);
        // FALKNER
        TrainerPokeButton falknerPidgeyL7 = new TrainerPokeButton(this, Species.PIDGEY, 7);
        TrainerPokeButton falknerPidgeottoL9 = new TrainerPokeButton(this, Species.PIDGEOTTO, 9);
        falknerGroup = new TrainerPokeButtonGroup(this, "FALKNER", falknerPidgeyL7, falknerPidgeottoL9);
        falknerGroup.initialize(501, 335);
        // ALBERT
        TrainerPokeButton albertRattataL6 = new TrainerPokeButton(this, Species.RATTATA, 6);
        TrainerPokeButton albertZubatL8 = new TrainerPokeButton(this, Species.ZUBAT, 8);
        albertGroup = new TrainerPokeButtonGroup(this, "ALBERT", albertRattataL6, albertZubatL8);
        albertGroup.initialize(501, 387);
        // RALPH
        TrainerPokeButton ralphGoldeenL10 = new TrainerPokeButton(this, Species.GOLDEEN, 10);
        ralphGroup = new TrainerPokeButtonGroup(this, "RALPH", ralphGoldeenL10);
        ralphGroup.initialize(501, 439);
        // DANIEL
        TrainerPokeButton danielOnixL11 = new TrainerPokeButton(this, Species.ONIX, 11);
        danielGroup = new TrainerPokeButtonGroup(this, "DANIEL", danielOnixL11);
        danielGroup.initialize(501, 491);
        // RUSSELL
        TrainerPokeButton russellGeodudeL4 = new TrainerPokeButton(this, Species.GEODUDE, 4);
        TrainerPokeButton russellGeodudeL6 = new TrainerPokeButton(this, Species.GEODUDE, 6);
        TrainerPokeButton russellGeodudeL8 = new TrainerPokeButton(this, Species.GEODUDE, 8);
        russellGroup = new TrainerPokeButtonGroup(this, "RUSSELL", russellGeodudeL4, russellGeodudeL6, russellGeodudeL8);
        russellGroup.initialize(501, 543);
    }

    @Override
    public void resetAction() {
        this.wildPidgeyGroup.reset();
        this.wildSentretGroup.reset();
        this.wildRattataGroup.reset();
        this.wildCaterpieGroup.reset();
        this.wildHoppipGroup.reset();
        rivalGroup.reset();
        mikeyGroup.reset();
        donGroup.reset();
        abeGroup.reset();
        rodGroup.reset();
        falknerGroup.reset();
        albertGroup.reset();
        ralphGroup.reset();
        danielGroup.reset();
        russellGroup.reset();
    }
}