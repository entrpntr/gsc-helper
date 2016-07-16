package com.pokemonspeedruns.gschelper.ui.pokes.wild;

import java.util.ArrayList;
import java.util.Arrays;

public class WildPokeRow {
    private ArrayList<WildPokeButtonGroup> row;
    private int[] iconX;

    public WildPokeRow(WildPokeButtonGroup... groups) {
        row = new ArrayList<WildPokeButtonGroup>(Arrays.asList(groups));
    }

    public WildPokeRow(ArrayList<WildPokeButtonGroup> group) {
        row = group;
    }

    public int size() {
        return row.size();
    }

    public int rowWidth() {
        if(row == null || row.isEmpty()) {
            return 0;
        }
        int width = row.get(0).coreWidth();
        for(int i=1; i<row.size(); i++) {
            width += row.get(i).groupWidth();
        }
        return width;
    }

    public static int calcWidth(WildPokeButtonGroup... groups) {
        if(groups == null || groups.length == 0) {
            return 0;
        }
        int width = groups[0].coreWidth();
        for(int i=1; i<groups.length; i++) {
            width += groups[i].groupWidth();
        }
        return width;
    }

    public void addToTopRow(WildPokePage pokePage) {
        int startX = 8;
        int rowWidth = rowWidth();
        int extraSpace = 434-rowWidth;
        if(size() == 1) {
            int x1 = startX + extraSpace/2 - 74;
            row.get(0).initialize(pokePage, x1, 0);
            iconX = new int[] { x1 };
        } else if(size() == 2) {
            int x1 = startX + extraSpace/3 + row.get(0).iconOffset();
            int x2 = x1 + 74 + 16 + (extraSpace - 2*(extraSpace/3)) + row.get(1).iconOffset();
            row.get(0).initialize(pokePage, x1, 0);
            row.get(1).initialize(pokePage, x2, 0);
            iconX = new int[] { x1, x2 };
        } else if(size() == 3) {
            int x1 = startX + extraSpace/4 + row.get(0).iconOffset();
            int x2 = x1 + 74 + 16 + extraSpace/4 + row.get(1).iconOffset();
            int x3 = x2 + 74 + 16 + extraSpace/4 + row.get(2).iconOffset();
            row.get(0).initialize(pokePage, x1, 0);
            row.get(1).initialize(pokePage, x2, 0);
            row.get(2).initialize(pokePage, x3, 0);
            iconX = new int[] { x1, x2, x3 };
        }
    }

    public void addToBottomRow(WildPokePage pokePage, WildPokeRow other) {
        for(int i=0; i<size(); i++) {
            row.get(i).initialize(pokePage, other.getIconLocs()[i], 46);
        }
    }

    public int[] getIconLocs() {
        return iconX;
    }
}
