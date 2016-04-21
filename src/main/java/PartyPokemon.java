import java.io.*;
import java.util.ArrayList;

public class PartyPokemon {
    int level = 5;
    int exp = lowestExpForLevel(5);
    int hp_ev_used = 0;
    int atk_ev_used = 0;
    int def_ev_used = 0;
    int spd_ev_used = 0;
    int spc_ev_used = 0;
    int hpStatExp = 0;
    int atkStatExp = 0;
    int defStatExp = 0;
    int spdStatExp = 0;
    int spcStatExp = 0;
    int baseHP = 50;
    int baseAtk = 65;
    int baseDef = 64;
    int baseSpA = 44;
    int baseSpD = 48;
    int baseSpe = 43;
    private static ArrayList<Pokemon> pokedex;

    public PartyPokemon() {
        initPokemon();
    }

    public static int lowestExpForLevel(int n) {
        return 6*n*n*n/5 - 15*n*n + 100*n - 140;
    }

    public static int expGiven(FoePokemon foe) {
        return (pokedex.get(foe.poke.ordinal()).expGiven) * foe.level / 7 * 3
                / (foe.isWild ? 3 : 2);
    }

    public boolean rekt(FoePokemon foe) {
        return rekt(foe, 1);
    }

    public boolean rekt(FoePokemon foe, int nrOfPokemon) {
        boolean gainedLevel = false;
        addStatExp(foe.poke, nrOfPokemon);
        exp += expGiven(foe);
        while(lowestExpForLevel(level + 1) <= exp) {
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

    public void addStatExp(Pokemon.Pkmn name, int nrOfPokemon) {
        Pokemon poke = this.pokedex.get(name.ordinal());
        this.hpStatExp += (int)Math.floor(poke.hp / nrOfPokemon);
        this.atkStatExp += (int)Math.floor(poke.atk / nrOfPokemon);
        this.defStatExp += (int)Math.floor(poke.def / nrOfPokemon);
        this.spdStatExp += (int)Math.floor(poke.spd / nrOfPokemon);
        this.spcStatExp += (int)Math.floor(poke.spc / nrOfPokemon);
    }

    public void reset() {
        this.level = 5;
        this.exp = lowestExpForLevel(5);
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
        baseHP = 50;
        baseAtk = 65;
        baseDef = 64;
        baseSpA = 44;
        baseSpD = 48;
        baseSpe = 43;
    }

    private void initPokemon() {
        this.pokedex = new ArrayList();
        BufferedReader br = null;
        int lineNr = 0;
        int pokedexEntry = 0;
        try {
            try {
                br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("pokemon.txt")));
                String line = br.readLine();
                while (line != null) {
                    ++lineNr;
                    if (!line.equals("") && !line.substring(0, 2).equals("//")) {
                        String[] s = line.split(";");
                        Pokemon poke = new Pokemon(Pokemon.Pkmn.values()[pokedexEntry], s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6]));
                        this.pokedex.add(poke);
                        ++pokedexEntry;
                    }
                    line = br.readLine();
                }
                return;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                try {
                    br.close();
                    return;
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
                return;
            }
            catch (IOException e) {
                e.printStackTrace();
                try {
                    br.close();
                    return;
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
                return;
            }
            catch (Exception e) {
                System.out.println("Syntax error in pokemon.txt on line: " + lineNr);
                e.printStackTrace();

                try {
                    br.close();
                    return;
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
                return;
            }
        }
        finally {
            try {
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
