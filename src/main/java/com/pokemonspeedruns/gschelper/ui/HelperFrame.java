package com.pokemonspeedruns.gschelper.ui;

import com.pokemonspeedruns.gschelper.model.Game;
import com.pokemonspeedruns.gschelper.model.PartyPokemon;
import com.pokemonspeedruns.gschelper.model.Species;
import com.pokemonspeedruns.gschelper.ui.dvs.GSCDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.dvs.impl.CrystalTotoDVCalculatorPanel;
import com.pokemonspeedruns.gschelper.ui.dvs.impl.GoldTotoDVCalculatorPanel;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public class HelperFrame extends JFrame {
    private static final long serialVersionUID = -768493274726718272L;
    private static final String version = "1.0";

    private JPanel main;
    private JPanel settings;

    private GSCDVCalculatorPanel calc;
    private final GoldTotoDVCalculatorPanel goldCalc;
    private final CrystalTotoDVCalculatorPanel crystalCalc;
    private String font = "";
    private JButton buttonOptions;
    private PreviewPane previewPane;
    private JColorChooser cc;
    private ActionListener okListener;
    private JLabel lastButtonPressed = null;
    private int baseWidth = 800;
    private int baseHeight = 740;

    private int maxWidth = 432;
    private int maxHeight = 108;

    private JSpinner spinnerTotoAreaWidth;
    private JSpinner spinnerTotoAreaHeight;
    private JSpinner spinnerTotoTitleSize;
    private JSpinner spinnerTotoColumnHeadersFontSize;
    private JSpinner spinnerTotototoDVNumbersFontSizeBig;
    private JSpinner spinnerTotototoDVNumbersFontSizeSmall;
    private JLabel labelButtonTotoBackgroundColor;
    private JLabel labelButtonTotoTitleColor;
    private JLabel labelButtonTotoColumnHeadersColor;
    private JLabel labelButtonTotoDVNumbersColor;
    private JComboBox<String> comboBoxTotoTitleFont;
    private JComboBox<String> comboBoxTotoTitleFontExtra;
    private JComboBox<String> comboBoxTotoColumnHeadersFont;
    private JComboBox<String> comboBoxTotoColumnHeadersFontExtra;
    private JComboBox<String> comboBoxTotoDVNumbersFont;
    private JComboBox<String> comboBoxTotoDVNumbersFontExtra;
    private JTextField textFieldTotoTitleText;
    private JDialog editTotoDialog;
    private JRadioButton radioGold;
    private JRadioButton radioCrystal;
    private ButtonGroup radioGSC;
    private Game game;
    private boolean initializing = true;
    private String executionPath;

    private int totoHeight = 80;
    private int totoWidth = 240;
    private Color totoBackgroundColor = new Color(255, 255, 255);
    private String totoTitleText = "Toto DVs (0-15)";
    private int totoTitleFontSize = 20;
    private String totoTitleFont = "";
    private int totoTitleFontExtra = Font.BOLD;
    private int totoColumnHeadersFontSize = 14;
    private String totoColumnHeadersFont = "";
    private int totoColumnHeadersFontExtra = Font.BOLD;
    private Color totoColumnHeadersColor = new Color(0, 0, 0);
    private int totoDVNumbersFontSizeBig = 16;
    private int totoDVNumbersFontSizeSmall = 14;
    private String totoDVNumbersFont = "";
    private int totoDVNumbersFontExtra = Font.BOLD;
    private Color totoDVNumbersColor = new Color(0, 0, 0);
    private Color totoTitleColor = new Color(0, 0, 0);

    public int getTotoTitleFontSize() {
        return totoTitleFontSize;
    }

    public String getTotoTitleFont() {
        return totoTitleFont;
    }

    public int getTotoTitleFontExtra() {
        return totoTitleFontExtra;
    }

    public int getTotoColumnHeadersFontSize() {
        return totoColumnHeadersFontSize;
    }

    public String getTotoColumnHeadersFont() {
        return totoColumnHeadersFont;
    }

    public int getTotoColumnHeadersFontExtra() {
        return totoColumnHeadersFontExtra;
    }

    public Color getTotoColumnHeadersColor() {
        return totoColumnHeadersColor;
    }

    public int getTotoDVNumbersFontSizeBig() {
        return totoDVNumbersFontSizeBig;
    }

    public int getTotoDVNumbersFontSizeSmall() {
        return totoDVNumbersFontSizeSmall;
    }

    public String getTotoDVNumbersFont() {
        return totoDVNumbersFont;
    }

    public int getTotoDVNumbersFontExtra() {
        return totoDVNumbersFontExtra;
    }

    public Color getTotoDVNumbersColor() {
        return totoDVNumbersColor;
    }

    public Color getTotoTitleColor() {
        return totoTitleColor;
    }

    public JPanel getMainPanel() {
        return main;
    }

    public JPanel getSettingsPanel() {
        return settings;
    }

    public Color getTotoBackgroundColor() {
        return totoBackgroundColor;
    }

    public String getTotoTitleText() {
        return totoTitleText;
    }

    public int getTotoHeight() {
        return totoHeight;
    }

    public int getTotoWidth() {
        return totoWidth;
    }

    public String getExecutionPath() {
        return this.executionPath;
    }

    private void setExecutionPath() {
        try {
            URL location = HelperFrame.class.getProtectionDomain().getCodeSource().getLocation();
            File fh = new File(URLDecoder.decode(location.getFile(), "UTF-8")).getParentFile();
            this.executionPath = String.valueOf(fh.getAbsolutePath()) + File.separator;
        } catch (Exception e) {
            e.printStackTrace();
            this.executionPath = "./";
        }
    }

    public HelperFrame() {
        super("Pok\u00e9mon GSC DV Helper");
        if (UIManager.getSystemLookAndFeelClassName().contains("windows")) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception exc) {
                // empty catch block
            }
        }
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(
                new WindowAdapter() {

                    @Override
                    public void windowClosing(WindowEvent e) {
                        HelperFrame.this.save();
                    }
                });
        this.setResizable(false);
        this.setBounds(0, 0, baseWidth, baseHeight + Math.max(0, this.totoHeight - 100));
        this.setLocationRelativeTo(null);
        this.setExecutionPath();
        this.font = font;
        this.main = new JPanel();
        this.main.setLayout(null);
        this.main.setBounds(0, 0, baseWidth, baseHeight + Math.max(0, this.totoHeight - 100));

        // TODO: Allow for other choices besides Totodile.
        goldCalc =
                new GoldTotoDVCalculatorPanel(HelperFrame.this, new PartyPokemon(Species.TOTODILE, 5));
        crystalCalc =
                new CrystalTotoDVCalculatorPanel(HelperFrame.this, new PartyPokemon(Species.TOTODILE, 5));

        this.calc = crystalCalc;
        this.settings = new JPanel();
        this.settings.setLayout(null);
        this.settings.setBounds(473, 590, 319, 160);
        this.settings.setBackground(null);
        this.initOptions();

        this.buttonOptions = new JButton("Options");
        this.buttonOptions.setMargin(new Insets(1, 1, 1, 1));
        this.buttonOptions.setFont(new Font(font, Font.BOLD, 13));
        this.buttonOptions.setBounds(115, 39, 80, 28);
        this.buttonOptions.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        editTotoDialog.setLocation(
                                HelperFrame.this.getLocation().x + 285, HelperFrame.this.getLocation().y + 140);
                        HelperFrame.this.editTotoDialog.setVisible(true);
                    }
                });
        this.settings.add(this.buttonOptions);
        JButton buttonAbout = new JButton("About");
        buttonAbout.setBounds(115, 71, 80, 28);
        buttonAbout.setFont(new Font(font, Font.BOLD, 13));
        buttonAbout.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        HelperFrame.this.about();
                    }
                });
        this.settings.add(buttonAbout);
        ImageIcon iconReset = new ImageIcon(getClass().getClassLoader().getResource("reset.png"));
        JButton buttonReset = new JButton(iconReset);
        buttonReset.setBounds(0, 10, 100, 100);
        buttonReset.setBorderPainted(false);
        buttonReset.setContentAreaFilled(false);
        buttonReset.setFocusPainted(false);
        buttonReset.setOpaque(false);
        buttonReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonReset.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        HelperFrame.this.reset();
                    }
                });
        this.settings.add(buttonReset);
        radioCrystal = new JRadioButton("Crystal");
        radioCrystal.setBounds(220, 39, 80, 28);
        radioCrystal.setSelected(true);
        radioCrystal.setFont(new Font(font, Font.BOLD, 14));
        Color crystal = new Color(113, 158, 179);
        radioCrystal.setForeground(crystal);
        radioCrystal.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (HelperFrame.this.game != Game.CRYSTAL) {
                            HelperFrame.this.goldCalc.reset();
                            HelperFrame.this.main.remove(calc);
                            HelperFrame.this.calc = crystalCalc;
                            HelperFrame.this.main.add(calc);
                            HelperFrame.this.reset();
                            HelperFrame.this.repaint();
                            HelperFrame.this.revalidate();
                            HelperFrame.this.game = Game.CRYSTAL;
                        }
                    }
                });
        radioGold = new JRadioButton("Gold");
        radioGold.setBounds(220, 71, 80, 28);
        radioGold.setFont(new Font(font, Font.BOLD, 14));
        Color gold = new Color(179, 151, 0);
        radioGold.setForeground(gold);
        radioGold.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (HelperFrame.this.game != Game.GOLD) {
                            HelperFrame.this.crystalCalc.reset();
                            HelperFrame.this.main.remove(calc);
                            HelperFrame.this.calc = goldCalc;
                            HelperFrame.this.main.add(calc);
                            HelperFrame.this.reset();
                            HelperFrame.this.repaint();
                            HelperFrame.this.revalidate();
                            HelperFrame.this.game = Game.GOLD;
                        }
                    }
                });
        radioGSC = new ButtonGroup();
        radioGSC.add(radioCrystal);
        radioGSC.add(radioGold);
        this.settings.add(radioCrystal);
        this.settings.add(radioGold);
        this.main.add(this.calc);
        this.main.add(this.settings);
        this.add(this.main);
        this.game = Game.CRYSTAL;
        this.load();
        this.initializing = false;
        this.updateTotoLookAndFeel();
    }



    private void initOptions() {
        this.editTotoDialog = new JDialog(this);
        this.editTotoDialog.setResizable(false);
        this.editTotoDialog.setLayout(null);
        this.editTotoDialog.setBackground(null);
        this.editTotoDialog.setModal(true);
        this.editTotoDialog.setAlwaysOnTop(true);
        this.editTotoDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        this.editTotoDialog.setBounds(this.getLocation().x, this.getLocation().y, 220, 440);
        this.editTotoDialog.setTitle("Toto look-and-feel");
        this.editTotoDialog.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        e.getWindow().dispose();
                    }
                });

        String[] fonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        String[] fontsExtra = new String[]{"Plain", "Bold", "Italic"};
        ChangeListener changeListenerToto =
                new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent changeEvent) {
                        HelperFrame.this.updateTotoLookAndFeel();
                    }
                };
        JLabel labelTotoAreaWidth = new JLabel("Width (max " + maxWidth + ")");
        labelTotoAreaWidth.setBounds(5, 5, 120, 20);
        labelTotoAreaWidth.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelTotoAreaWidth);
        JLabel labelTotoAreaHeight = new JLabel("Height (max " + maxHeight + ")");
        labelTotoAreaHeight.setBounds(5, 25, 120, 20);
        labelTotoAreaHeight.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelTotoAreaHeight);
        JLabel labelTotoAreaBackground = new JLabel("Background");
        labelTotoAreaBackground.setBounds(5, 45, 100, 20);
        labelTotoAreaBackground.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelTotoAreaBackground);
        SpinnerNumberModel widthModel = new SpinnerNumberModel(this.totoWidth, 0, maxWidth, 1);
        this.spinnerTotoAreaWidth = new JSpinner(widthModel);
        this.spinnerTotoAreaWidth.setFont(new Font(this.font, Font.PLAIN, 11));
        this.spinnerTotoAreaWidth.setBounds(120, 5, 40, 20);
        this.spinnerTotoAreaWidth.addChangeListener(changeListenerToto);
        this.editTotoDialog.add(this.spinnerTotoAreaWidth);
        SpinnerNumberModel heightModel = new SpinnerNumberModel(this.totoHeight, 0, maxHeight, 1);
        this.spinnerTotoAreaHeight = new JSpinner(heightModel);
        this.spinnerTotoAreaHeight.setFont(new Font(this.font, Font.PLAIN, 11));
        this.spinnerTotoAreaHeight.setBounds(120, 25, 40, 20);
        this.spinnerTotoAreaHeight.addChangeListener(changeListenerToto);
        this.editTotoDialog.add(this.spinnerTotoAreaHeight);
        this.labelButtonTotoBackgroundColor = new JLabel("");
        this.labelButtonTotoBackgroundColor.setBackground(this.totoBackgroundColor);
        this.labelButtonTotoBackgroundColor.setOpaque(true);
        this.labelButtonTotoBackgroundColor.setBounds(120, 45, 40, 20);
        this.labelButtonTotoBackgroundColor.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        HelperFrame.changeLastButtonPressed(
                                HelperFrame.this, HelperFrame.this.labelButtonTotoBackgroundColor);
                        HelperFrame.this.cc.setColor(
                                HelperFrame.this.labelButtonTotoBackgroundColor.getBackground());
                        HelperFrame.this.previewPane.setForeground(
                                HelperFrame.this.labelButtonTotoBackgroundColor.getBackground());
                        JDialog d =
                                JColorChooser.createDialog(
                                        HelperFrame.this.editTotoDialog,
                                        "Choose a color",
                                        true,
                                        HelperFrame.this.cc,
                                        HelperFrame.this.okListener,
                                        null);
                        d.setVisible(true);
                    }
                });
        this.editTotoDialog.add(this.labelButtonTotoBackgroundColor);
        JLabel labelTitle = new JLabel("Title");
        labelTitle.setBounds(5, 70, 150, 20);
        labelTitle.setFont(new Font(this.font, Font.BOLD, 14));
        this.editTotoDialog.add(labelTitle);
        JLabel labelTitleText = new JLabel("Text:");
        labelTitleText.setBounds(10, 90, 50, 20);
        labelTitleText.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelTitleText);
        JLabel labelTitleFont = new JLabel("Font:");
        labelTitleFont.setBounds(10, 110, 50, 20);
        labelTitleFont.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelTitleFont);
        JLabel labelTitleSize = new JLabel("Size:");
        labelTitleSize.setBounds(10, 130, 50, 20);
        labelTitleSize.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelTitleSize);
        JLabel labelTitleColor = new JLabel("Color:");
        labelTitleColor.setBounds(10, 150, 50, 20);
        labelTitleColor.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelTitleColor);
        this.textFieldTotoTitleText = new JTextField(this.totoTitleText);
        this.textFieldTotoTitleText.setFont(new Font(this.font, Font.PLAIN, 11));
        this.textFieldTotoTitleText.setBounds(50, 90, 150, 20);
        this.textFieldTotoTitleText
                .getDocument()
                .addDocumentListener(
                        new DocumentListener() {
                            @Override
                            public void changedUpdate(DocumentEvent e) {
                                this.update();
                            }

                            @Override
                            public void removeUpdate(DocumentEvent e) {
                                this.update();
                            }

                            @Override
                            public void insertUpdate(DocumentEvent e) {
                                this.update();
                            }

                            public void update() {
                                HelperFrame.this.updateTotoLookAndFeel();
                            }
                        });
        this.editTotoDialog.add(this.textFieldTotoTitleText);
        this.comboBoxTotoTitleFont = new JComboBox<String>(fonts);
        this.comboBoxTotoTitleFont.setFont(new Font(this.font, Font.PLAIN, 11));
        this.comboBoxTotoTitleFont.setBounds(50, 110, 150, 20);
        this.comboBoxTotoTitleFont.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent arg0) {
                        HelperFrame.this.updateTotoLookAndFeel();
                    }
                });
        this.comboBoxTotoTitleFont.setSelectedItem(this.totoTitleFont);
        this.editTotoDialog.add(this.comboBoxTotoTitleFont);
        this.comboBoxTotoTitleFontExtra = new JComboBox<String>(fontsExtra);
        this.comboBoxTotoTitleFontExtra.setFont(new Font(this.font, Font.PLAIN, 11));
        this.comboBoxTotoTitleFontExtra.setBounds(140, 130, 60, 20);
        this.comboBoxTotoTitleFontExtra.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent arg0) {
                        HelperFrame.this.updateTotoLookAndFeel();
                    }
                });
        this.comboBoxTotoTitleFontExtra.setSelectedIndex(this.totoTitleFontExtra);
        this.editTotoDialog.add(this.comboBoxTotoTitleFontExtra);
        SpinnerNumberModel totoTitleSizeModel =
                new SpinnerNumberModel(this.totoTitleFontSize, 0, 100, 1);
        this.spinnerTotoTitleSize = new JSpinner(totoTitleSizeModel);
        this.spinnerTotoTitleSize.setFont(new Font(this.font, Font.PLAIN, 11));
        this.spinnerTotoTitleSize.setBounds(80, 130, 40, 20);
        this.spinnerTotoTitleSize.addChangeListener(changeListenerToto);
        this.editTotoDialog.add(this.spinnerTotoTitleSize);
        this.labelButtonTotoTitleColor = new JLabel("");
        this.labelButtonTotoTitleColor.setBackground(this.totoTitleColor);
        this.labelButtonTotoTitleColor.setOpaque(true);
        this.labelButtonTotoTitleColor.setBounds(80, 150, 40, 20);
        this.labelButtonTotoTitleColor.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        HelperFrame.changeLastButtonPressed(
                                HelperFrame.this, HelperFrame.this.labelButtonTotoTitleColor);
                        HelperFrame.this.cc.setColor(
                                HelperFrame.this.labelButtonTotoTitleColor.getBackground());
                        HelperFrame.this.previewPane.setForeground(
                                HelperFrame.this.labelButtonTotoTitleColor.getBackground());
                        JDialog d =
                                JColorChooser.createDialog(
                                        HelperFrame.this.editTotoDialog,
                                        "Choose a color",
                                        true,
                                        HelperFrame.this.cc,
                                        HelperFrame.this.okListener,
                                        null);
                        d.setVisible(true);
                    }
                });
        this.editTotoDialog.add(this.labelButtonTotoTitleColor);
        JLabel labelColumnHeaders = new JLabel("DVColumn Headers");
        labelColumnHeaders.setBounds(5, 175, 150, 20);
        labelColumnHeaders.setFont(new Font(this.font, Font.BOLD, 14));
        this.editTotoDialog.add(labelColumnHeaders);
        JLabel labelColumnHeadersFont = new JLabel("Font:");
        labelColumnHeadersFont.setBounds(10, 195, 50, 20);
        labelColumnHeadersFont.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelColumnHeadersFont);
        JLabel labelColumnHeadersSize = new JLabel("Size:");
        labelColumnHeadersSize.setBounds(10, 215, 50, 20);
        labelColumnHeadersSize.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelColumnHeadersSize);
        JLabel labelColumnHeadersColor = new JLabel("Color:");
        labelColumnHeadersColor.setBounds(10, 235, 50, 20);
        labelColumnHeadersColor.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelColumnHeadersColor);
        this.comboBoxTotoColumnHeadersFont = new JComboBox<String>(fonts);
        this.comboBoxTotoColumnHeadersFont.setFont(new Font(this.font, Font.PLAIN, 11));
        this.comboBoxTotoColumnHeadersFont.setBounds(50, 195, 150, 20);
        this.comboBoxTotoColumnHeadersFont.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent arg0) {
                        HelperFrame.this.updateTotoLookAndFeel();
                    }
                });
        this.comboBoxTotoColumnHeadersFont.setSelectedItem(this.totoColumnHeadersFont);
        this.editTotoDialog.add(this.comboBoxTotoColumnHeadersFont);
        this.comboBoxTotoColumnHeadersFontExtra = new JComboBox<String>(fontsExtra);
        this.comboBoxTotoColumnHeadersFontExtra.setFont(new Font(this.font, Font.PLAIN, 11));
        this.comboBoxTotoColumnHeadersFontExtra.setBounds(140, 215, 60, 20);
        this.comboBoxTotoColumnHeadersFontExtra.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent arg0) {
                        HelperFrame.this.updateTotoLookAndFeel();
                    }
                });
        this.comboBoxTotoColumnHeadersFontExtra.setSelectedIndex(this.totoColumnHeadersFontExtra);
        this.editTotoDialog.add(this.comboBoxTotoColumnHeadersFontExtra);
        SpinnerNumberModel totoColumnHeadersSizeModel =
                new SpinnerNumberModel(this.totoColumnHeadersFontSize, 0, 100, 1);
        this.spinnerTotoColumnHeadersFontSize = new JSpinner(totoColumnHeadersSizeModel);
        this.spinnerTotoColumnHeadersFontSize.setFont(new Font(this.font, Font.PLAIN, 11));
        this.spinnerTotoColumnHeadersFontSize.setBounds(80, 215, 40, 20);
        this.spinnerTotoColumnHeadersFontSize.addChangeListener(changeListenerToto);
        this.editTotoDialog.add(this.spinnerTotoColumnHeadersFontSize);
        this.labelButtonTotoColumnHeadersColor = new JLabel("");
        this.labelButtonTotoColumnHeadersColor.setBackground(this.totoTitleColor);
        this.labelButtonTotoColumnHeadersColor.setOpaque(true);
        this.labelButtonTotoColumnHeadersColor.setBounds(80, 235, 40, 20);
        this.labelButtonTotoColumnHeadersColor.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        HelperFrame.changeLastButtonPressed(
                                HelperFrame.this, HelperFrame.this.labelButtonTotoColumnHeadersColor);
                        HelperFrame.this.cc.setColor(
                                HelperFrame.this.labelButtonTotoColumnHeadersColor.getBackground());
                        HelperFrame.this.previewPane.setForeground(
                                HelperFrame.this.labelButtonTotoColumnHeadersColor.getBackground());
                        JDialog d =
                                JColorChooser.createDialog(
                                        HelperFrame.this.editTotoDialog,
                                        "Choose a color",
                                        true,
                                        HelperFrame.this.cc,
                                        HelperFrame.this.okListener,
                                        null);
                        d.setVisible(true);
                    }
                });
        this.editTotoDialog.add(this.labelButtonTotoColumnHeadersColor);
        JLabel labelDVNumbers = new JLabel("DV Numbers");
        labelDVNumbers.setBounds(5, 260, 150, 20);
        labelDVNumbers.setFont(new Font(this.font, Font.BOLD, 14));
        this.editTotoDialog.add(labelDVNumbers);
        JLabel labelDVNumbersFont = new JLabel("Font:");
        labelDVNumbersFont.setBounds(10, 280, 100, 20);
        labelDVNumbersFont.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelDVNumbersFont);
        JLabel labelDVNumbersSizeBig = new JLabel("Size 1 DV:");
        labelDVNumbersSizeBig.setBounds(10, 300, 100, 20);
        labelDVNumbersSizeBig.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelDVNumbersSizeBig);
        JLabel labelDVNumbersSizeSmall = new JLabel("Size >1 DV:");
        labelDVNumbersSizeSmall.setBounds(10, 320, 100, 20);
        labelDVNumbersSizeSmall.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelDVNumbersSizeSmall);
        JLabel labelDVNumbersColor = new JLabel("Color:");
        labelDVNumbersColor.setBounds(10, 340, 100, 20);
        labelDVNumbersColor.setFont(new Font(this.font, Font.BOLD, 12));
        this.editTotoDialog.add(labelDVNumbersColor);
        this.comboBoxTotoDVNumbersFont = new JComboBox<String>(fonts);
        this.comboBoxTotoDVNumbersFont.setFont(new Font(this.font, Font.PLAIN, 11));
        this.comboBoxTotoDVNumbersFont.setBounds(50, 280, 150, 20);
        this.comboBoxTotoDVNumbersFont.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent arg0) {
                        HelperFrame.this.updateTotoLookAndFeel();
                    }
                });
        this.comboBoxTotoDVNumbersFont.setSelectedItem(this.totoDVNumbersFont);
        this.editTotoDialog.add(this.comboBoxTotoDVNumbersFont);
        this.comboBoxTotoDVNumbersFontExtra = new JComboBox<String>(fontsExtra);
        this.comboBoxTotoDVNumbersFontExtra.setFont(new Font(this.font, Font.PLAIN, 11));
        this.comboBoxTotoDVNumbersFontExtra.setBounds(140, 300, 60, 20);
        this.comboBoxTotoDVNumbersFontExtra.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent arg0) {
                        HelperFrame.this.updateTotoLookAndFeel();
                    }
                });
        this.comboBoxTotoDVNumbersFontExtra.setSelectedIndex(this.totoDVNumbersFontExtra);
        this.editTotoDialog.add(this.comboBoxTotoDVNumbersFontExtra);
        SpinnerNumberModel totoDVNumbersSizeBigModel =
                new SpinnerNumberModel(this.totoDVNumbersFontSizeBig, 0, 100, 1);
        this.spinnerTotototoDVNumbersFontSizeBig = new JSpinner(totoDVNumbersSizeBigModel);
        this.spinnerTotototoDVNumbersFontSizeBig.setFont(new Font(this.font, Font.PLAIN, 11));
        this.spinnerTotototoDVNumbersFontSizeBig.setBounds(80, 300, 40, 20);
        this.spinnerTotototoDVNumbersFontSizeBig.addChangeListener(changeListenerToto);
        this.editTotoDialog.add(this.spinnerTotototoDVNumbersFontSizeBig);
        SpinnerNumberModel totoDVNumbersSizeSmallModel =
                new SpinnerNumberModel(this.totoDVNumbersFontSizeSmall, 0, 100, 1);
        this.spinnerTotototoDVNumbersFontSizeSmall = new JSpinner(totoDVNumbersSizeSmallModel);
        this.spinnerTotototoDVNumbersFontSizeSmall.setFont(new Font(this.font, Font.PLAIN, 11));
        this.spinnerTotototoDVNumbersFontSizeSmall.setBounds(80, 320, 40, 20);
        this.spinnerTotototoDVNumbersFontSizeSmall.addChangeListener(changeListenerToto);
        this.editTotoDialog.add(this.spinnerTotototoDVNumbersFontSizeSmall);
        this.labelButtonTotoDVNumbersColor = new JLabel("");
        this.labelButtonTotoDVNumbersColor.setBackground(this.totoDVNumbersColor);
        this.labelButtonTotoDVNumbersColor.setOpaque(true);
        this.labelButtonTotoDVNumbersColor.setBounds(80, 340, 40, 20);
        this.labelButtonTotoDVNumbersColor.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        HelperFrame.changeLastButtonPressed(
                                HelperFrame.this, HelperFrame.this.labelButtonTotoDVNumbersColor);
                        HelperFrame.this.cc.setColor(
                                HelperFrame.this.labelButtonTotoDVNumbersColor.getBackground());
                        HelperFrame.this.previewPane.setForeground(
                                HelperFrame.this.labelButtonTotoDVNumbersColor.getBackground());
                        JDialog d =
                                JColorChooser.createDialog(
                                        HelperFrame.this.editTotoDialog,
                                        "Choose a color",
                                        true,
                                        HelperFrame.this.cc,
                                        HelperFrame.this.okListener,
                                        null);
                        d.setVisible(true);
                    }
                });
        this.editTotoDialog.add(this.labelButtonTotoDVNumbersColor);
        JButton buttonResetDefault = new JButton("Reset Default");
        buttonResetDefault.setFont(new Font(this.font, Font.BOLD, 12));
        buttonResetDefault.setMargin(new Insets(2, 0, 2, 0));
        buttonResetDefault.setBounds(10, 370, 110, 30);
        buttonResetDefault.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        HelperFrame.this.spinnerTotoAreaWidth.setValue(240);
                        HelperFrame.this.spinnerTotoAreaHeight.setValue(80);
                        HelperFrame.this.labelButtonTotoBackgroundColor.setBackground(new Color(255, 255, 255));
                        HelperFrame.this.textFieldTotoTitleText.setText("Toto DVs (0-15)");
                        HelperFrame.this.spinnerTotoTitleSize.setValue(20);
                        HelperFrame.this.comboBoxTotoTitleFont.setSelectedItem(HelperFrame.this.font);
                        HelperFrame.this.comboBoxTotoTitleFontExtra.setSelectedIndex(1);
                        HelperFrame.this.labelButtonTotoTitleColor.setBackground(new Color(0, 0, 0));
                        HelperFrame.this.spinnerTotoColumnHeadersFontSize.setValue(14);
                        HelperFrame.this.comboBoxTotoColumnHeadersFont.setSelectedItem(HelperFrame.this.font);
                        HelperFrame.this.comboBoxTotoColumnHeadersFontExtra.setSelectedIndex(1);
                        HelperFrame.this.labelButtonTotoColumnHeadersColor.setBackground(new Color(0, 0, 0));
                        HelperFrame.this.spinnerTotototoDVNumbersFontSizeBig.setValue(16);
                        HelperFrame.this.spinnerTotototoDVNumbersFontSizeSmall.setValue(14);
                        HelperFrame.this.comboBoxTotoDVNumbersFont.setSelectedItem(HelperFrame.this.font);
                        HelperFrame.this.comboBoxTotoDVNumbersFontExtra.setSelectedIndex(1);
                        HelperFrame.this.labelButtonTotoDVNumbersColor.setBackground(new Color(0, 0, 0));
                        HelperFrame.this.updateTotoLookAndFeel();
                    }
                });
        this.editTotoDialog.add(buttonResetDefault);
        this.okListener =
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if (HelperFrame.this.cc.getColor() != null) {
                            HelperFrame.this.lastButtonPressed.setBackground(HelperFrame.this.cc.getColor());
                            HelperFrame.this.lastButtonPressed.setForeground(HelperFrame.this.cc.getColor());
                            HelperFrame.changeTotoBackgroundColor(
                                    HelperFrame.this,
                                    HelperFrame.this.labelButtonTotoBackgroundColor.getBackground());
                            HelperFrame.changeTotoTitleColor(
                                    HelperFrame.this, HelperFrame.this.labelButtonTotoTitleColor.getBackground());
                            HelperFrame.changeTotoColumnHeadersColor(
                                    HelperFrame.this,
                                    HelperFrame.this.labelButtonTotoColumnHeadersColor.getBackground());
                            HelperFrame.changeTotoDVNumbersColor(
                                    HelperFrame.this, HelperFrame.this.labelButtonTotoDVNumbersColor.getBackground());
                            HelperFrame.this.updateTotoLookAndFeel();
                        }
                    }
                };
        this.cc = new JColorChooser();
        this.previewPane = new PreviewPane();
        this.cc.setPreviewPanel(this.previewPane);
        AbstractColorChooserPanel[] panels = this.cc.getChooserPanels();
        for (AbstractColorChooserPanel panel : panels) {
            if (panel.getDisplayName().contains("RGB") || panel.getDisplayName().contains("RVB"))
                continue;
            this.cc.removeChooserPanel(panel);
        }
        AbstractColorChooserPanel cp = this.cc.getChooserPanels()[0];
        try {
            Field f = cp.getClass().getDeclaredField("panel");
            f.setAccessible(true);
            Object colorPanel = f.get(cp);
            Field f2 = colorPanel.getClass().getDeclaredField("spinners");
            f2.setAccessible(true);
            Object spinners = f2.get(colorPanel);
            Object transpSlispinner = Array.get(spinners, 3);
            Field f3 = transpSlispinner.getClass().getDeclaredField("slider");
            f3.setAccessible(true);
            JSlider slider = (JSlider) f3.get(transpSlispinner);
            slider.setVisible(false);
            Field f4 = transpSlispinner.getClass().getDeclaredField("spinner");
            f4.setAccessible(true);
            JSpinner spinner = (JSpinner) f4.get(transpSlispinner);
            spinner.setVisible(false);
            Field f5 = transpSlispinner.getClass().getDeclaredField("label");
            f5.setAccessible(true);
            JLabel label = (JLabel) f5.get(transpSlispinner);
            label.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load() {
        this.comboBoxTotoTitleFont.setSelectedItem(this.font);
        this.comboBoxTotoTitleFontExtra.setSelectedItem(1);
        this.comboBoxTotoColumnHeadersFont.setSelectedItem(this.font);
        this.comboBoxTotoColumnHeadersFontExtra.setSelectedItem(1);
        this.comboBoxTotoDVNumbersFont.setSelectedItem(this.font);
        this.comboBoxTotoDVNumbersFontExtra.setSelectedItem(1);
        File file = new File(String.valueOf(this.getExecutionPath()) + "/settings.txt");
        BufferedReader br;
        try {
            String s;
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                String[] sp;
                Color c;
                if (s.equals("") || s.substring(0, 1).equals(";") || (sp = s.split("=")).length <= 1)
                    continue;
                if (sp[0].equals("Location")) {
                    String[] location = sp[1].split(",");
                    if (location.length != 2) continue;
                    this.setLocation(Integer.parseInt(location[0]), Integer.parseInt(location[1]));
                    continue;
                }
                if (sp[0].equals("Game")) {
                    try {
                        Game game = Game.valueOf(sp[1].toUpperCase());
                        if (game != Game.CRYSTAL) {
                            this.setGame(game);
                            this.crystalCalc.reset();
                            this.main.remove(calc);

                            // TODO: Support switching between multiple saved configurations.
                            this.calc = goldCalc;
                            this.main.add(calc);
                            this.radioGold.setSelected(true);
                            this.radioCrystal.setSelected(false);
                            this.reset();
                            this.repaint();
                            this.revalidate();
                        }
                    } catch (Exception e) {
                        // empty catch block
                    }
                    continue;
                }
                if (sp[0].equals("totoWidth") && HelperFrame.isInteger(sp[1], 0, this.maxWidth)) {
                    this.spinnerTotoAreaWidth.setValue(Integer.parseInt(sp[1]));
                    continue;
                }
                if (sp[0].equals("totoHeight") && HelperFrame.isInteger(sp[1], 0, this.maxHeight)) {
                    this.spinnerTotoAreaHeight.setValue(Integer.parseInt(sp[1]));
                    continue;
                }
                if (sp[0].equals("totoBackgroundColor")
                        && sp[1].split(",").length >= 3
                        && HelperFrame.isInteger(sp[1].split(",")[0], 0, 255)
                        && HelperFrame.isInteger(sp[1].split(",")[1], 0, 255)
                        && HelperFrame.isInteger(sp[1].split(",")[2], 0, 255)) {
                    c =
                            new Color(
                                    Integer.parseInt(sp[1].split(",")[0]),
                                    Integer.parseInt(sp[1].split(",")[1]),
                                    Integer.parseInt(sp[1].split(",")[2]));
                    this.labelButtonTotoBackgroundColor.setBackground(c);
                    continue;
                }
                if (sp[0].equals("totoTitleText")) {
                    this.textFieldTotoTitleText.setText(sp[1]);
                    continue;
                }
                if (sp[0].equals("totoTitleFontSize") && HelperFrame.isInteger(sp[1], 0, 500)) {
                    this.spinnerTotoTitleSize.setValue(Integer.parseInt(sp[1]));
                    continue;
                }
                if (sp[0].equals("totoTitleFont")) {
                    this.comboBoxTotoTitleFont.setSelectedItem(sp[1]);
                    continue;
                }
                if (sp[0].equals("totoTitleFontExtra") && HelperFrame.isInteger(sp[1], 0, 2)) {
                    this.comboBoxTotoTitleFontExtra.setSelectedItem(Integer.parseInt(sp[1]));
                    continue;
                }
                if (sp[0].equals("totoTitleColor")
                        && sp[1].split(",").length >= 3
                        && HelperFrame.isInteger(sp[1].split(",")[0], 0, 255)
                        && HelperFrame.isInteger(sp[1].split(",")[1], 0, 255)
                        && HelperFrame.isInteger(sp[1].split(",")[2], 0, 255)) {
                    c =
                            new Color(
                                    Integer.parseInt(sp[1].split(",")[0]),
                                    Integer.parseInt(sp[1].split(",")[1]),
                                    Integer.parseInt(sp[1].split(",")[2]));
                    this.labelButtonTotoTitleColor.setBackground(c);
                    continue;
                }
                if (sp[0].equals("totoColumnHeadersFontSize") && HelperFrame.isInteger(sp[1], 0, 500)) {
                    this.spinnerTotoColumnHeadersFontSize.setValue(Integer.parseInt(sp[1]));
                    continue;
                }
                if (sp[0].equals("totoColumnHeadersFont")) {
                    this.comboBoxTotoColumnHeadersFont.setSelectedItem(sp[1]);
                    continue;
                }
                if (sp[0].equals("totoColumnHeadersFontExtra") && HelperFrame.isInteger(sp[1], 0, 2)) {
                    this.comboBoxTotoColumnHeadersFontExtra.setSelectedItem(Integer.parseInt(sp[1]));
                    continue;
                }
                if (sp[0].equals("totoColumnHeadersColor")
                        && sp[1].split(",").length >= 3
                        && HelperFrame.isInteger(sp[1].split(",")[0], 0, 255)
                        && HelperFrame.isInteger(sp[1].split(",")[1], 0, 255)
                        && HelperFrame.isInteger(sp[1].split(",")[2], 0, 255)) {
                    c =
                            new Color(
                                    Integer.parseInt(sp[1].split(",")[0]),
                                    Integer.parseInt(sp[1].split(",")[1]),
                                    Integer.parseInt(sp[1].split(",")[2]));
                    this.labelButtonTotoColumnHeadersColor.setBackground(c);
                    continue;
                }
                if (sp[0].equals("totoDVNumbersFontSizeBig") && HelperFrame.isInteger(sp[1], 0, 500)) {
                    this.spinnerTotototoDVNumbersFontSizeBig.setValue(Integer.parseInt(sp[1]));
                    continue;
                }
                if (sp[0].equals("totoDVNumbersFontSizeSmall") && HelperFrame.isInteger(sp[1], 0, 500)) {
                    this.spinnerTotototoDVNumbersFontSizeSmall.setValue(Integer.parseInt(sp[1]));
                    continue;
                }
                if (sp[0].equals("totoDVNumbersFont")) {
                    this.comboBoxTotoDVNumbersFont.setSelectedItem(sp[1]);
                    continue;
                }
                if (sp[0].equals("totoDVNumbersFontExtra") && HelperFrame.isInteger(sp[1], 0, 2)) {
                    this.comboBoxTotoDVNumbersFontExtra.setSelectedItem(Integer.parseInt(sp[1]));
                    continue;
                }
                if (!sp[0].equals("totoDVNumbersColor")
                        || sp[1].split(",").length < 3
                        || !HelperFrame.isInteger(sp[1].split(",")[0], 0, 255)
                        || !HelperFrame.isInteger(sp[1].split(",")[1], 0, 255)
                        || !HelperFrame.isInteger(sp[1].split(",")[2], 0, 255)) continue;
                c =
                        new Color(
                                Integer.parseInt(sp[1].split(",")[0]),
                                Integer.parseInt(sp[1].split(",")[1]),
                                Integer.parseInt(sp[1].split(",")[2]));
                this.labelButtonTotoDVNumbersColor.setBackground(c);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isInteger(String s, int min, int max) {
        try {
            int i = Integer.parseInt(s);
            if (i < min || i > max) {
                System.out.println("false: " + i);
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    private void save() {
        block12:
        {
            File file = new File(String.valueOf(this.getExecutionPath()) + "/settings.txt");
            BufferedWriter out = null;
            try {
                try {
                    FileWriter fw = new FileWriter(file, false);
                    out = new BufferedWriter(fw);
                    out.write("Location=" + this.getLocation().x + "," + this.getLocation().y);
                    out.newLine();
                    String game = this.game.name().toLowerCase();
                    out.write("Game=" + game);
                    out.newLine();
                    out.write(";Toto Look-and-feel Settings:");
                    out.newLine();
                    out.write("totoWidth=" + this.totoWidth);
                    out.newLine();
                    out.write("totoHeight=" + this.totoHeight);
                    out.newLine();
                    out.write(
                            "totoBackgroundColor="
                                    + this.totoBackgroundColor.getRed()
                                    + ","
                                    + this.totoBackgroundColor.getGreen()
                                    + ","
                                    + this.totoBackgroundColor.getBlue());
                    out.newLine();
                    out.write("totoTitleText=" + this.totoTitleText);
                    out.newLine();
                    out.write("totoTitleFontSize=" + this.totoTitleFontSize);
                    out.newLine();
                    out.write("totoTitleFont=" + this.totoTitleFont);
                    out.newLine();
                    out.write("totoTitleFontExtra=" + this.totoTitleFontExtra);
                    out.newLine();
                    out.write(
                            "totoTitleColor="
                                    + this.totoTitleColor.getRed()
                                    + ","
                                    + this.totoTitleColor.getGreen()
                                    + ","
                                    + this.totoTitleColor.getBlue());
                    out.newLine();
                    out.write("totoColumnHeadersFontSize=" + this.totoColumnHeadersFontSize);
                    out.newLine();
                    out.write("totoColumnHeadersFont=" + this.totoColumnHeadersFont);
                    out.newLine();
                    out.write("totoColumnHeadersFontExtra=" + this.totoColumnHeadersFontExtra);
                    out.newLine();
                    out.write(
                            "totoColumnHeadersColor="
                                    + this.totoColumnHeadersColor.getRed()
                                    + ","
                                    + this.totoColumnHeadersColor.getGreen()
                                    + ","
                                    + this.totoColumnHeadersColor.getBlue());
                    out.newLine();
                    out.write("totoDVNumbersFontSizeBig=" + this.totoDVNumbersFontSizeBig);
                    out.newLine();
                    out.write("totoDVNumbersFontSizeSmall=" + this.totoDVNumbersFontSizeSmall);
                    out.newLine();
                    out.write("totoDVNumbersFont=" + this.totoDVNumbersFont);
                    out.newLine();
                    out.write("totoDVNumbersFontExtra=" + this.totoDVNumbersFontExtra);
                    out.newLine();
                    out.write(
                            "totoDVNumbersColor="
                                    + this.totoDVNumbersColor.getRed()
                                    + ","
                                    + this.totoDVNumbersColor.getGreen()
                                    + ","
                                    + this.totoDVNumbersColor.getBlue());
                    out.newLine();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    if (out == null) break block12;
                    try {
                        out.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void updateTotoLookAndFeel() {
        if (this.initializing) {
            return;
        }
        this.totoWidth = (Integer) this.spinnerTotoAreaWidth.getValue();
        this.totoHeight = (Integer) this.spinnerTotoAreaHeight.getValue();
        this.totoBackgroundColor = this.labelButtonTotoBackgroundColor.getBackground();
        this.totoTitleText = this.textFieldTotoTitleText.getText();
        this.totoTitleFontSize = (Integer) this.spinnerTotoTitleSize.getValue();
        this.totoTitleFont = (String) this.comboBoxTotoTitleFont.getSelectedItem();
        this.totoTitleFontExtra = this.comboBoxTotoTitleFontExtra.getSelectedIndex();
        this.totoTitleColor = this.labelButtonTotoTitleColor.getBackground();
        this.totoColumnHeadersFontSize = (Integer) this.spinnerTotoColumnHeadersFontSize.getValue();
        this.totoColumnHeadersFont = (String) this.comboBoxTotoColumnHeadersFont.getSelectedItem();
        this.totoColumnHeadersFontExtra = this.comboBoxTotoColumnHeadersFontExtra.getSelectedIndex();
        this.totoColumnHeadersColor = this.labelButtonTotoColumnHeadersColor.getBackground();
        this.totoDVNumbersFontSizeBig = (Integer) this.spinnerTotototoDVNumbersFontSizeBig.getValue();
        this.totoDVNumbersFontSizeSmall =
                (Integer) this.spinnerTotototoDVNumbersFontSizeSmall.getValue();
        this.totoDVNumbersFont = (String) this.comboBoxTotoDVNumbersFont.getSelectedItem();
        this.totoDVNumbersFontExtra = this.comboBoxTotoDVNumbersFontExtra.getSelectedIndex();
        this.totoDVNumbersColor = this.labelButtonTotoDVNumbersColor.getBackground();
        this.setSize(baseWidth, baseHeight + Math.max(0, this.totoHeight - 100));
        this.main.setSize(baseWidth, baseHeight + Math.max(0, this.totoHeight - 100));
        this.calc.updateTotoLookAndFeel();
    }

    public void reset() {
        this.calc.reset();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private void about() {
        String s =
                "<html><body><p style=\"FONT-family:'arial';FONT-size:9px;width:405px\">Pok\u00e9mon GSC DV Helper<br>Version: "
                        + version
                        + "<br><br>This is a GSC helper program developed by <a href='http://www.twitch.tv/entrpntr'>entrpntr</a>, derived from the Yellow Helper program designed by <a href='http://www.twitch.tv/Dailyleaf'>Dailyleaf</a>. The goal is making it easier for Pok\u00e9mon Gold & Crystal glitchless speedrunners to figure out DVs and plan ahead based on this knowledge."
                        + "<br><br>DV Calculation:"
                        + "<br><br>Stats Panel:"
                        + "<br>Click what you see ingame, the program will do the math and eliminate impossible combinations."
                        + "<br>Select (in order) the trainer Pokémon and wild encounters you killed and the program will keep track of your experience and stat experience automatically."
                        + "<br><br>Questions:"
                        + "<br>If you have any questions, feel free to contact entrpntr on the PSR forums or on discord. The thread for GSC DV Helper can be found <a href='http://forums.pokemonspeedruns.com/viewtopic.php?f=116&t=512'>here</a>."
                        + "<br><br>entrpntr's Credits:"
                        + "<br><a href='http://www.twitch.tv/Dailyleaf'>Dailyleaf</a> - For making the original Red Helper and Yellow Helper programs."
                        + "<br><a href='http://www.twitch.tv/HorouIchigo'>HorouIchigo</a> - For most of the early feedback on the original Gold Helper."
                        + "<br><br><em>Daily's Credits:"
                        + "<br><a href='http://www.twitch.tv/BobChao87'>BobChao87</a> - For giving me the idea of how to make the DV calculator."
                        + "<br><a href='http://www.twitch.tv/ExarionU'>ExarionU</a> - For providing the <a href='https://docs.google.com/spreadsheets/d/1mc4MIi2FWYsAoft1srthtEP--Oo36TXddMhQbG1NnB0/edit?pli=1#gid=0'>late-game strategy chart</a> that is used."
                        + "<br><a href='http://www.twitch.tv/Masteri_Mori'>Masteri_Mori</a> - For providing a <a href='http://pastebin.com/Dnw1PE2U'>full list</a> of all possible DV combinations. Which helped me test my code. There are 364 possibilities missing in that list."
                        + "<br><a href='http://www.twitch.tv/Masteri_Mori'>HRoll</a> - For making the amazing <a href='https://github.com/HRoll/poke-router'>RouteOne</a> pogram. It gave me a great insight in how all the calculations are done."
                        + "<br><br>Daily's Shoutouts:"
                        + "<br>Shoutouts to all the people in the Pok\u00e9mon Red skype-group for giving me feedback. Especially <a href='http://www.twitch.tv/dabomstew'>dabomstew</a> for some great help explaining how the calculations were done in RouteOne.</em>";
        JEditorPane ep = new JEditorPane();
        ep.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        ep.setEditable(false);
        ep.setBackground(null);
        int caretPosition = ep.getCaretPosition();
        ep.setText(s);
        ep.setAlignmentX(0.0f);
        ep.addHyperlinkListener(
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent e) {
                        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED
                                && Desktop.isDesktopSupported()) {
                            try {
                                Desktop.getDesktop().browse(e.getURL().toURI());
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            } catch (URISyntaxException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
        ep.setCaretPosition(Math.min(caretPosition, s.length()));
        JScrollPane sp = new JScrollPane(ep);
        sp.setPreferredSize(new Dimension(550, 300));
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.getVerticalScrollBar().setUnitIncrement(16);
        sp.setBorder(null);
        JOptionPane.showMessageDialog(this, sp, "About", JOptionPane.PLAIN_MESSAGE);
    }

    static void changeLastButtonPressed(HelperFrame helperFrame, JLabel jLabel) {
        helperFrame.lastButtonPressed = jLabel;
    }

    static void changeTotoBackgroundColor(HelperFrame helperFrame, Color color) {
        helperFrame.totoBackgroundColor = color;
    }

    static void changeTotoTitleColor(HelperFrame helperFrame, Color color) {
        helperFrame.totoTitleColor = color;
    }

    static void changeTotoColumnHeadersColor(HelperFrame helperFrame, Color color) {
        helperFrame.totoColumnHeadersColor = color;
    }

    static void changeTotoDVNumbersColor(HelperFrame helperFrame, Color color) {
        helperFrame.totoDVNumbersColor = color;
    }

    public class PreviewPane extends JPanel {
        private static final long serialVersionUID = 3424012701561505236L;
        private JLabel labelBackground;

        public PreviewPane() {
            super(new GridLayout(0, 1));
            this.setBounds(10, 365, 200, 100);
            this.labelBackground = new JLabel("N", SwingConstants.CENTER);
            this.labelBackground.setPreferredSize(new Dimension(50, 50));
            this.labelBackground.setOpaque(true);
            this.add(this.labelBackground);
        }

        @Override
        public void setForeground(Color c) {
            super.setForeground(c);
            if (this.labelBackground != null && c != null) {
                if (HelperFrame.this.lastButtonPressed == HelperFrame.this.labelButtonTotoBackgroundColor) {
                    this.labelBackground.setFont(
                            new Font(
                                    (String) HelperFrame.this.comboBoxTotoTitleFont.getSelectedItem(),
                                    HelperFrame.this.comboBoxTotoTitleFontExtra.getSelectedIndex(),
                                    (Integer) HelperFrame.this.spinnerTotoTitleSize.getValue()));
                    this.labelBackground.setForeground(
                            HelperFrame.this.labelButtonTotoTitleColor.getBackground());
                    this.labelBackground.setBackground(c);
                    this.labelBackground.setPreferredSize(this.getTextSize());
                    this.labelBackground.setText(HelperFrame.this.textFieldTotoTitleText.getText());
                } else if (HelperFrame.this.lastButtonPressed
                        == HelperFrame.this.labelButtonTotoTitleColor) {
                    this.labelBackground.setFont(
                            new Font(
                                    (String) HelperFrame.this.comboBoxTotoTitleFont.getSelectedItem(),
                                    HelperFrame.this.comboBoxTotoTitleFontExtra.getSelectedIndex(),
                                    (Integer) HelperFrame.this.spinnerTotoTitleSize.getValue()));
                    this.labelBackground.setForeground(c);
                    this.labelBackground.setBackground(
                            HelperFrame.this.labelButtonTotoBackgroundColor.getBackground());
                    this.labelBackground.setPreferredSize(this.getTextSize());
                    this.labelBackground.setText(HelperFrame.this.textFieldTotoTitleText.getText());
                } else if (HelperFrame.this.lastButtonPressed
                        == HelperFrame.this.labelButtonTotoColumnHeadersColor) {
                    this.labelBackground.setFont(
                            new Font(
                                    (String) HelperFrame.this.comboBoxTotoColumnHeadersFont.getSelectedItem(),
                                    HelperFrame.this.comboBoxTotoColumnHeadersFontExtra.getSelectedIndex(),
                                    (Integer) HelperFrame.this.spinnerTotoColumnHeadersFontSize.getValue()));
                    this.labelBackground.setForeground(c);
                    this.labelBackground.setBackground(
                            HelperFrame.this.labelButtonTotoBackgroundColor.getBackground());
                    this.labelBackground.setPreferredSize(this.getTextSize());
                    this.labelBackground.setText("SPC");
                } else if (HelperFrame.this.lastButtonPressed
                        == HelperFrame.this.labelButtonTotoDVNumbersColor) {
                    this.labelBackground.setFont(
                            new Font(
                                    (String) HelperFrame.this.comboBoxTotoDVNumbersFont.getSelectedItem(),
                                    HelperFrame.this.comboBoxTotoDVNumbersFontExtra.getSelectedIndex(),
                                    (Integer) HelperFrame.this.spinnerTotototoDVNumbersFontSizeSmall.getValue()));
                    this.labelBackground.setForeground(c);
                    this.labelBackground.setBackground(
                            HelperFrame.this.labelButtonTotoBackgroundColor.getBackground());
                    this.labelBackground.setPreferredSize(this.getTextSize());
                    this.labelBackground.setText("10/15");
                }
            }
        }

        private Dimension getTextSize() {
            Dimension size = new Dimension();
            FontMetrics fm = this.labelBackground.getFontMetrics(this.labelBackground.getFont());
            size.width = 0;
            size.width =
                    HelperFrame.this.lastButtonPressed == HelperFrame.this.labelButtonTotoBackgroundColor
                            || HelperFrame.this.lastButtonPressed
                            == HelperFrame.this.labelButtonTotoTitleColor
                            ? fm.stringWidth(HelperFrame.this.textFieldTotoTitleText.getText()) + 15
                            : (HelperFrame.this.lastButtonPressed
                            == HelperFrame.this.labelButtonTotoColumnHeadersColor
                            ? fm.stringWidth("SPC") + 15
                            : fm.stringWidth("10/15") + 15);
            size.height = fm.getHeight() + 5;
            return size;
        }
    }
}
