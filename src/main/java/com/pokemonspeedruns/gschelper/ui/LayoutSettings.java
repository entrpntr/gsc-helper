package com.pokemonspeedruns.gschelper.ui;

import java.awt.*;

public class LayoutSettings {
    public String getDvNumbersFontName() {
        return dvNumbersFontName;
    }

    public void setDvNumbersFontName(String dvNumbersFontName) {
        this.dvNumbersFontName = dvNumbersFontName;
    }

    public int getDvNumbersFontExtra() {
        return dvNumbersFontExtra;
    }

    public void setDvNumbersFontExtra(int dvNumbersFontExtra) {
        this.dvNumbersFontExtra = dvNumbersFontExtra;
    }

    public int getDvNumbersFontSizeBig() {
        return dvNumbersFontSizeBig;
    }

    public void setDvNumbersFontSizeBig(int dvNumbersFontSizeBig) {
        this.dvNumbersFontSizeBig = dvNumbersFontSizeBig;
    }

    public int getDvNumbersFontSizeSmall() {
        return dvNumbersFontSizeSmall;
    }

    public void setDvNumbersFontSizeSmall(int dvNumbersFontSizeSmall) {
        this.dvNumbersFontSizeSmall = dvNumbersFontSizeSmall;
    }

    public LayoutSettings(LayoutSettings other) {
        this(
                other.getDvWidth(), other.getDvHeight(), other.getDvBackgroundColor(), other.getDvTitleText(),
                other.getDvTitleFont().getSize(), other.getDvTitleFont().getName(),
                other.getDvTitleFont().getStyle(), other.getDvTitleColor(), other.getDvColumnHeadersFont().getSize(),
                other.getDvColumnHeadersFont().getName(), other.getDvColumnHeadersFont().getStyle(),
                other.getDvColumnHeadersColor(), other.getDvNumbersFontSizeBig(), other.getDvNumbersFontSizeSmall(),
                other.getDvNumbersFontName(), other.getDvNumbersFontExtra(), other.getDvNumbersColor()
        );
    }
    public LayoutSettings(
            int width, int height, Color bgColor, String dvTitleText, int titleFontSize,
            String titleFontFamily, int titleFontExtra, Color titleColor, int columnHeadersFontSize,
            String columnHeadersFontFamily, int columnHeadersFontExtra, Color columnHeadersColor, int numbersFontSizeBig,
            int numbersFontSizeSmall, String numbersFontFamily, int dvNumbersFontExtra, Color numbersColor)
    {
        this.dvWidth = width;
        this.dvHeight = height;
        this.dvBackgroundColor = bgColor;
        this.dvTitleText = dvTitleText;
        this.dvTitleFont = new Font(titleFontFamily, titleFontExtra, titleFontSize);
        this.dvTitleColor = titleColor;
        this.dvColumnHeadersFont = new Font(columnHeadersFontFamily, columnHeadersFontExtra, columnHeadersFontSize);
        this.dvColumnHeadersColor = columnHeadersColor;
        this.dvNumbersFontName = numbersFontFamily;
        this.dvNumbersFontExtra = dvNumbersFontExtra;
        this.dvNumbersFontSizeBig = numbersFontSizeBig;
        this.dvNumbersFontSizeSmall = numbersFontSizeSmall;

//        this.dvNumbersFontBig = new Font(numbersFontFamily, dvNumbersFontExtra, numbersFontSizeBig);
//        this.dvNumbersFontSmall = new Font(numbersFontFamily, dvNumbersFontExtra, numbersFontSizeSmall);
        this.dvNumbersColor = numbersColor;
    }

    public int getDvHeight() {
        return dvHeight;
    }

    public void setDvHeight(int dvHeight) {
        this.dvHeight = dvHeight;
    }

    public Color getDvBackgroundColor() {
        return dvBackgroundColor;
    }

    public void setDvBackgroundColor(Color dvBackgroundColor) {
        this.dvBackgroundColor = dvBackgroundColor;
    }

    public String getDvTitleText() {
        return dvTitleText;
    }

    public void setDvTitleText(String dvTitleText) {
        this.dvTitleText = dvTitleText;
    }

    public Font getDvTitleFont() {
        return dvTitleFont;
    }

    public void setDvTitleFont(Font dvTitleFont) {
        this.dvTitleFont = dvTitleFont;
    }

    public Color getDvTitleColor() {
        return dvTitleColor;
    }

    public void setDvTitleColor(Color dvTitleColor) {
        this.dvTitleColor = dvTitleColor;
    }

    public Font getDvColumnHeadersFont() {
        return dvColumnHeadersFont;
    }

    public void setDvColumnHeadersFont(Font dvColumnHeadersFont) {
        this.dvColumnHeadersFont = dvColumnHeadersFont;
    }

    public Color getDvColumnHeadersColor() {
        return dvColumnHeadersColor;
    }

    public void setDvColumnHeadersColor(Color dvColumnHeadersColor) {
        this.dvColumnHeadersColor = dvColumnHeadersColor;
    }
/*
    public Font getDvNumbersFontBig() {
        return dvNumbersFontBig;
    }

    public void setDvNumbersFontBig(Font dvNumbersFontBig) {
        this.dvNumbersFontBig = dvNumbersFontBig;
    }

    public Font getDvNumbersFontSmall() {
        return dvNumbersFontSmall;
    }

    public void setDvNumbersFontSmall(Font dvNumbersFontSmall) {
        this.dvNumbersFontSmall = dvNumbersFontSmall;
    }
*/
    public Color getDvNumbersColor() {
        return dvNumbersColor;
    }

    public void setDvNumbersColor(Color dvNumbersColor) {
        this.dvNumbersColor = dvNumbersColor;
    }

    public int getDvWidth() {
        return dvWidth;
    }

    public void setDvWidth(int dvWidth) {
        this.dvWidth = dvWidth;
    }

    private int dvWidth;
    private int dvHeight;
    private Color dvBackgroundColor;
    private String dvTitleText;
    private Font dvTitleFont;
    private Color dvTitleColor;
    private Font dvColumnHeadersFont;
    private Color dvColumnHeadersColor;
    private String dvNumbersFontName;
    private int dvNumbersFontExtra;
    private int dvNumbersFontSizeBig;
    private int dvNumbersFontSizeSmall;
//    private Font dvNumbersFontBig;
//    private Font dvNumbersFontSmall;
    private Color dvNumbersColor;
}
