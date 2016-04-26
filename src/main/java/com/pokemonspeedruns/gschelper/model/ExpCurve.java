package com.pokemonspeedruns.gschelper.model;

public enum ExpCurve {
    SLOW,
    MEDIUM_SLOW,
    MEDIUM,
    FAST,
    NONE;

    public static int expToNextLevel(ExpCurve curve, int currLevel, int totalExp) {
        if (curve == NONE) return 0;

        int n = currLevel + 1; //next level
        int nextExp = lowestExpForLevel(curve, n);

        return nextExp - totalExp;
    }

    public static int lowestExpForLevel(ExpCurve curve, int level) {
        int exp = 0;
        switch (curve) {
            case SLOW:
                exp = 5 * level * level * level / 4;
                break;
            case MEDIUM_SLOW:
                exp = 6 * level * level * level / 5 - 15 * level * level + 100 * level - 140;
                break;
            case MEDIUM:
                exp = level * level * level;
                break;
            case FAST:
                exp = 4 * level * level * level / 5;
                break;
            default:
                break;
        }
        return exp;
    }

    public static int expForLevel(ExpCurve curve, int level) {
        return lowestExpForLevel(curve, level + 1) - lowestExpForLevel(curve, level);
    }
}
