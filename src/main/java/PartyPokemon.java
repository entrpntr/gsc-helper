public class PartyPokemon {
    private Species species;
    private int level;
    private int exp;
    private final int startLevel;
    private int hp_ev_used = 0;
    private int atk_ev_used = 0;
    private int def_ev_used = 0;
    private int spd_ev_used = 0;
    private int spc_ev_used = 0;
    private int hpStatExp = 0;
    private int atkStatExp = 0;
    private int defStatExp = 0;
    private int spdStatExp = 0;
    private int spcStatExp = 0;
    private int baseHP = 50;
    private int baseAtk = 65;
    private int baseDef = 64;
    private int baseSpA = 44;
    private int baseSpD = 48;
    private int baseSpe = 43;

    public PartyPokemon(Species species, int level) {
        this.species = species;
        this.level = level;
        this.startLevel = level;
        setExpForLevel(level);
    }

    public int getLevel() {
        return level;
    }

    public Species getSpecies() {
        return species;
    }

    public int getExp() {
        return exp;
    }

    public int getStartLevel() {
        return startLevel;
    }

    public int getHpStatExp() {
        return hpStatExp;
    }

    public int getAtkStatExp() {
        return atkStatExp;
    }

    public int getDefStatExp() {
        return defStatExp;
    }

    public int getSpdStatExp() {
        return spdStatExp;
    }

    public int getSpcStatExp() {
        return spcStatExp;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public int getBaseSpA() {
        return baseSpA;
    }

    public int getBaseSpD() {
        return baseSpD;
    }

    public int getBaseSpe() {
        return baseSpe;
    }

    private void setExpForLevel(int level) {
        exp = ExpCurve.lowestExpForLevel(species.getExpCurve(), level);
    }

    public static int expGiven(FoePokemon foe) {
        return (foe.getSpecies().getKillExp()) * foe.getLevel() / 7 * 3
                / (foe.getFoeType() == FoeType.WILD ? 3 : 2);
    }

    public boolean rekt(FoePokemon foe) {
        return rekt(foe, 1);
    }

    public boolean rekt(FoePokemon foe, int nrOfPokemon) {
        boolean gainedLevel = false;
        addStatExp(foe.getSpecies(), nrOfPokemon);
        exp += expGiven(foe);
        while(ExpCurve.lowestExpForLevel(species.getExpCurve(), level + 1) <= exp) {
            level++;
            hp_ev_used = hpStatExp;
            atk_ev_used = atkStatExp;
            def_ev_used = defStatExp;
            spc_ev_used = spcStatExp;
            spd_ev_used = spdStatExp;
            gainedLevel = true;
        }
        return gainedLevel;
    }

    public void addStatExp(Species species, int nrOfPokemon) {
        this.hpStatExp += (int)Math.floor(species.getBaseHP() / nrOfPokemon);
        this.atkStatExp += (int)Math.floor(species.getBaseAtk() / nrOfPokemon);
        this.defStatExp += (int)Math.floor(species.getBaseDef() / nrOfPokemon);
        this.spdStatExp += (int)Math.floor(species.getBaseSpd() / nrOfPokemon);
        this.spcStatExp += (int)Math.floor(species.getBaseSpcAtk() / nrOfPokemon);
    }

    public void reset() {
        this.level = startLevel;
        this.exp = ExpCurve.lowestExpForLevel(species.getExpCurve(), startLevel);
        this.hpStatExp = 0;
        this.atkStatExp = 0;
        this.defStatExp = 0;
        this.spdStatExp = 0;
        this.spcStatExp = 0;
        this.hp_ev_used = 0;
        this.atk_ev_used = 0;
        this.def_ev_used = 0;
        this.spc_ev_used = 0;
        this.spd_ev_used = 0;
        baseHP = species.getBaseHP();
        baseAtk = species.getBaseAtk();
        baseDef = species.getBaseDef();
        baseSpA = species.getBaseSpcAtk();
        baseSpD = species.getBaseSpcDef();
        baseSpe = species.getBaseSpd();
    }
}
