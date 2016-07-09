package com.pokemonspeedruns.gschelper.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Trainer implements Iterable<FoePokemon> {
    private String className, name;
    private ArrayList<FoePokemon> pokes;
    private int offset;
//    private IVs dvs;
    private static HashMap<Integer, Trainer> allCrystalTrainers;
    private static HashMap<String, Trainer> crystalTrainersByName;
    private static HashMap<Integer, Trainer> allGSTrainers;
    private static HashMap<String, Trainer> gsTrainersByName;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Trainer)) {
            return false;
        } else {
            return offset == ((Trainer) o).offset; // TODO check for more?
        }
    }

    public String toString() {
        return String.format("%s %s (0x%X: %s)", className, name, offset,
                allPokes());
    }

    public ArrayList<FoePokemon> getPokes() {
        return pokes;
    }

    public FoePokemon getPoke(int idx) {
        return pokes.get(idx);
    }

    public int getPartySize() {
        return pokes.size();
    }

    public String allPokes() {
        StringBuilder sb = new StringBuilder();
        for (FoePokemon p : pokes) {
            sb.append("L" + p.getLevel() + " " + p.getSpecies().getName() + ", ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<FoePokemon> iterator() {
        return pokes.iterator();
    }

    private static Trainer getTrainerFromOffset(Game game, int offset) {
        Trainer trainer = null;
        switch(game) {
            case CRYSTAL:
                if (allCrystalTrainers.containsKey(offset)) {
                    trainer = allCrystalTrainers.get(offset);
                }
                break;
            case GOLD: default:
                if (allGSTrainers.containsKey(offset)) {
                    trainer = allGSTrainers.get(offset);
                }
                break;
        }
        return trainer;
    }

    public static Trainer getTrainer(Game game, String trainerName) {
        Trainer trainer;
        if(trainerName.startsWith("0x") || trainerName.startsWith("0X")) {
            trainer = getTrainerFromOffset(game, Integer.parseInt(trainerName.substring(2), 16));
        } else {
            switch(game) {
                case CRYSTAL:
                    trainer = crystalTrainersByName.get(trainerName);
                    break;
                case GOLD:
                default:
                    trainer = gsTrainersByName.get(trainerName);
            }
        }
        return trainer;
    }

    public static void initTrainers() {
        allCrystalTrainers = new HashMap<Integer, Trainer>();
        crystalTrainersByName = new HashMap<String, Trainer>();
        allGSTrainers = new HashMap<Integer, Trainer>();
        gsTrainersByName = new HashMap<String, Trainer>();

        List<Trainer> gsTrainerList = getData("trainer_data_gs.txt");
        List<Trainer> crystalTrainerList = getData("trainer_data_c.txt");

        for (Trainer t : crystalTrainerList) {
            allCrystalTrainers.put(new Integer(t.offset), t);
            if (t.name.equals("GRUNT") == false
                    && t.name.equals("EXECUTIVE") == false
                    && t.name.equals("?") == false
                    && crystalTrainersByName.containsKey(t.name) == false) {
                crystalTrainersByName.put(t.name, t);
            }
        }

        for (Trainer t : gsTrainerList) {
            allGSTrainers.put(new Integer(t.offset), t);
            if (t.name.equals("GRUNT") == false
                    && t.name.equals("EXECUTIVE") == false
                    && t.name.equals("?") == false
                    && gsTrainersByName.containsKey(t.name) == false) {
                gsTrainersByName.put(t.name, t);
            }
        }
    }

    private static List<Trainer> getData(String filename) {
        ArrayList<Trainer> trainers = new ArrayList<Trainer>();
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(Trainer.class.getClassLoader().getResource(filename).openStream()));

            String currentClassName = "";
//            IVs currentIVs = new IVs();
            Trainer t;
            while (in.ready()) {
                String text = in.readLine();
                // names are formatted as [NAME]
                if (text.startsWith("[")) {
                    // TODO: error checking is for noobs
                    currentClassName = text.substring(1, text.length() - 1);
                    continue;
                } else if (text.startsWith("0x")) { // line is a 0x(pointer):
                    // list of pokes
                    String[] parts = text.split(" "); // this should be length
                    // 2+numpokes*7
                    int offset = Integer.parseInt(parts[0].substring(2), 16);

                    t = new Trainer();
                    t.name = parts[1];
                    t.className = currentClassName;
                    t.offset = offset;
                    t.pokes = new ArrayList<FoePokemon>();
//                    t.dvs = currentIVs;

                    // read off pokemon
                    int pokecount = (parts.length - 2) / 7;
                    for (int i = 0; i < pokecount; i++) {
                        int pokoffset = 2 + i * 7;
                        int number = Integer.parseInt(parts[pokoffset]);
                        int level = Integer.parseInt(parts[pokoffset + 1]);
/*
                        int move1 = Integer.parseInt(parts[pokoffset + 3]);
                        int move2 = Integer.parseInt(parts[pokoffset + 4]);
                        int move3 = Integer.parseInt(parts[pokoffset + 5]);
                        int move4 = Integer.parseInt(parts[pokoffset + 6]);
*/
//                        Species s = Species.getSpecies(number);
                        Species s = Species.values()[number - 1];
/*                        Moveset m = new Moveset();
                        if (move1 != 0)
                            m.addMove(move1);
                        if (move2 != 0)
                            m.addMove(move2);
                        if (move3 != 0)
                            m.addMove(move3);
                        if (move4 != 0)
                            m.addMove(move4);
                        Pokemon pk = new Pokemon(s, level, m, currentIVs, false);
*/
                        FoePokemon pk = new FoePokemon(s, level, FoeType.TRAINER);
                        t.pokes.add(pk);
                    }
                    trainers.add(t);
                } else {
                    // new set of DVs
/*                    String[] parts = text.split(" "); // this should be length 4
                    // error checking is indeed for scrubs
                    int atkIV = Integer.parseInt(parts[0]);
                    int defIV = Integer.parseInt(parts[1]);
                    int spdIV = Integer.parseInt(parts[2]);
                    int spcIV = Integer.parseInt(parts[3]);
                    currentIVs = new IVs(atkIV, defIV, spdIV, spcIV);
*/                }
            }
            in.close();
            return trainers;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public int getOffset() {
        return offset;
    }

    public String getPrettyName() {
        if(name.equals("?")) {
            return "RIVAL";
        } else {
            return name;
        }
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }
}
