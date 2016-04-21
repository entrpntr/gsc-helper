import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

public class GSCHelper {
    public GSCHelper() {
        HelperFrame ui;
        ArrayList<String> fonts = new ArrayList<String>();
        for (Font f : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
            if (fonts.contains(f.getFamily())) continue;
            fonts.add(f.getFamily());
        }
        String font = "";
        if (fonts.contains("Arial")) {
            font = "Arial";
        } else if (fonts.contains("Helvetica")) {
            font = "Helvetica";
        } else if (fonts.contains("Gill Sans")) {
            font = "Gill Sans";
        } else if (fonts.contains("Tahoma")) {
            font = "Tahoma";
        } else if (fonts.contains("SansSerif")) {
            font = "SansSerif";
        } else if (fonts.contains("Ubuntu Condensed")) {
            font = "Ubuntu Condensed";
        } else if (fonts.contains("DejaVu Sans Condensed")) {
            font = "DejaVu Sans Condensed";
        } else if (fonts.contains("Liberation Sans")) {
            font = "Liberation Sans";
        } else if (fonts.contains("FreeSans")) {
            font = "FreeSans";
        } else if (fonts.contains("Phetsarath OT")) {
            font = "Phetsarath OT";
        } else if (fonts.contains("Bitstream Vera Sans")) {
            font = "Bitstream Vera Sans";
        } else if (fonts.contains("Garuda")) {
            font = "Garuda";
        }
        if (font.equals("")) {
            System.out.println("No usable font found! Using system default, this can get ugly!");
        } else {
            System.out.println("Selected font: " + font);
        }
        ui = new HelperFrame(font);
        ui.setVisible(true);
    }

    public static void main(String[] args) {
        new GSCHelper();
    }
}

