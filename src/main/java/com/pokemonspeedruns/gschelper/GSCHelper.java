package com.pokemonspeedruns.gschelper;

import com.pokemonspeedruns.gschelper.ui.HelperFrame;

import java.awt.*;
import java.util.ArrayList;

public class GSCHelper {
    public static String FONT = "";

    public GSCHelper() {
        HelperFrame ui;
        ArrayList<String> fonts = new ArrayList<String>();
        for (Font f : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
            if (fonts.contains(f.getFamily())) continue;
            fonts.add(f.getFamily());
        }
        if (fonts.contains("Arial")) {
            FONT = "Arial";
        } else if (fonts.contains("Helvetica")) {
            FONT = "Helvetica";
        } else if (fonts.contains("Gill Sans")) {
            FONT = "Gill Sans";
        } else if (fonts.contains("Tahoma")) {
            FONT = "Tahoma";
        } else if (fonts.contains("SansSerif")) {
            FONT = "SansSerif";
        } else if (fonts.contains("Ubuntu Condensed")) {
            FONT = "Ubuntu Condensed";
        } else if (fonts.contains("DejaVu Sans Condensed")) {
            FONT = "DejaVu Sans Condensed";
        } else if (fonts.contains("Liberation Sans")) {
            FONT = "Liberation Sans";
        } else if (fonts.contains("FreeSans")) {
            FONT = "FreeSans";
        } else if (fonts.contains("Phetsarath OT")) {
            FONT = "Phetsarath OT";
        } else if (fonts.contains("Bitstream Vera Sans")) {
            FONT = "Bitstream Vera Sans";
        } else if (fonts.contains("Garuda")) {
            FONT = "Garuda";
        }
        if (FONT.equals("")) {
            System.out.println("No usable font found! Using system default, this can get ugly!");
        } else {
            System.out.println("Selected font: " + FONT);
        }
        ui = new HelperFrame();
        ui.setVisible(true);
    }

    public static void main(String[] args) {
        new GSCHelper();
    }
}