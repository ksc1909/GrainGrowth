package MultiscaleModelling.GrainGrowth;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author mswiader
 */
public class Main extends javax.swing.JFrame {

    /// Array X size
    static  int sizeX = BoardSizeConstatnts.boardWidth;
    
    /// Array Y size
    static  int sizeY = BoardSizeConstatnts.boardHeight;              
    double dT = 0;
    HandlerClass handler = new HandlerClass();
    Thread thread;
    Grain[][] grainGrowthBoard;
    boolean shouldRunSimulationLoop;
    private final Board board;
    private int iterCount;
    ArrayList<Integer> selectedGrainList = new ArrayList();
    
    public Main() {
        iterCount = 0;
        board = new Board(sizeX, sizeY);
        grainGrowthBoard = new Grain[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                grainGrowthBoard[i][j] = new Grain(); /// Filling the board             
            }
        }
        initComponents();
        ConditionsComboBox.setVisible(false);
        jLabel10.setVisible(false);
        recrystallizationSlider.setVisible(false);
        recrystalButton.setVisible(false);
        jLabel11.setVisible(false);
        MonteCarloToogleButton.setVisible(false);
        
        this.jLabel14.setVisible(false);
        this.jPanel5.setVisible(false);
        this.jPanel6.setVisible(false);
        this.jPanel7.setVisible(false);
        this.jPanel8.setVisible(false);
        
        /// Sets numebr of grians
        jLabel9.setText("" + board.getCountGrainsCristal());    
        canvas.addMouseListener(handler);
        canvas.addMouseMotionListener(handler);
        jLabel11.setText(recrystallizationSlider.getValue() + " %");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        xLabelSize = new javax.swing.JLabel();
        YLabelSize = new javax.swing.JLabel();
        countXText = new javax.swing.JTextField();
        countYText = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        ringSizeField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        amountRingsField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        MonteCarloToogleButton = new javax.swing.JToggleButton();
        StartButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        NeighborhoodComboBox = new javax.swing.JComboBox();
        ConditionsComboBox = new javax.swing.JComboBox();
        GenerateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        NeighborhoodLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        BCsButton = new javax.swing.JToggleButton();
        recrystalButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        recrystallizationSlider = new javax.swing.JSlider();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        randomSeedsCountText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inclusionsCount = new javax.swing.JTextField();
        inclusionsSize = new javax.swing.JTextField();
        inclusionShapeComboBox = new javax.swing.JComboBox<>();
        addInclusionsButton = new javax.swing.JButton();
        radiusLabel = new javax.swing.JLabel();
        radiusText = new javax.swing.JTextField();
        canvas = new MultiscaleModelling.GrainGrowth.Canvas();
        widthField = new javax.swing.JTextField();
        heightField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        boardResizeButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        structureSelectionTypeComboBox = new javax.swing.JComboBox<>();
        structureSelectionTypeButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        ImportMenu = new javax.swing.JMenu();
        FromBitmapImport = new javax.swing.JMenuItem();
        FromTextFileImport = new javax.swing.JMenuItem();
        ExportMenu = new javax.swing.JMenu();
        ToBitmapExport = new javax.swing.JMenuItem();
        ToTextFileExport = new javax.swing.JMenuItem();
        showGrainsBorders = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 650));
        setSize(new java.awt.Dimension(950, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(950, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(950, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1150, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel8.setText("Nucleons count");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 2);
        jPanel9.add(jLabel8, gridBagConstraints);

        jLabel9.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel9, gridBagConstraints);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSeparator2.setMinimumSize(new java.awt.Dimension(1, 20));
        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel9.add(jSeparator2, gridBagConstraints);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSeparator1.setMinimumSize(new java.awt.Dimension(1, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 20));
        jPanel9.add(jSeparator1, new java.awt.GridBagConstraints());

        jLabel12.setText("Iteration: 0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel9.add(jLabel12, gridBagConstraints);

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, -1, -1));

        jPanel2.setLayout(new java.awt.GridBagLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel6.setLayout(new java.awt.GridBagLayout());

        xLabelSize.setText("X:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(xLabelSize, gridBagConstraints);

        YLabelSize.setText("Y:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel6.add(YLabelSize, gridBagConstraints);

        countXText.setText("10");
        countXText.setMinimumSize(new java.awt.Dimension(40, 22));
        countXText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(countXText, gridBagConstraints);

        countYText.setText("10");
        countYText.setMinimumSize(new java.awt.Dimension(40, 22));
        countYText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel6.add(countYText, gridBagConstraints);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 210, -1, -1));

        jPanel5.setLayout(new java.awt.GridBagLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, -1, -1));

        jPanel4.setLayout(new java.awt.GridBagLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        jPanel7.setLayout(new java.awt.GridBagLayout());

        ringSizeField.setText("5");
        ringSizeField.setMinimumSize(new java.awt.Dimension(40, 22));
        ringSizeField.setName(""); // NOI18N
        ringSizeField.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 5, 5);
        jPanel7.add(ringSizeField, gridBagConstraints);

        jLabel4.setText("Promień:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel7.add(jLabel4, gridBagConstraints);

        amountRingsField.setText("5");
        amountRingsField.setMinimumSize(new java.awt.Dimension(40, 22));
        amountRingsField.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel7.add(amountRingsField, gridBagConstraints);

        jLabel5.setText("Ilość pkt:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 2, 5);
        jPanel7.add(jLabel5, gridBagConstraints);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, -1, -1));

        jPanel8.setLayout(new java.awt.GridBagLayout());
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, -1, -1));

        MonteCarloToogleButton.setText("Monte Carlo");
        MonteCarloToogleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonteCarloToogleButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MonteCarloToogleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 150, 140));

        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
        jPanel1.add(StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, 60));

        StopButton.setText("Stop");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });
        jPanel1.add(StopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 60));

        NeighborhoodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Moore", "von Neumann", "Extended Moore" }));
        NeighborhoodComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                NeighborhoodComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        NeighborhoodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NeighborhoodComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(NeighborhoodComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 190, -1));

        ConditionsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Losowe", "Stała odległość", "Stała ilość ziaren" }));
        ConditionsComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ConditionsComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(ConditionsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, 160, 30));

        GenerateButton.setText("Generate");
        GenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(GenerateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 100, 60));

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 100, 60));

        NeighborhoodLabel.setText("Neighborhood");
        jPanel1.add(NeighborhoodLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, 20));

        jLabel14.setText("Conditions");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 290, -1, -1));

        BCsButton.setText("Perdiodic BC");
        BCsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCsButtonActionPerformed(evt);
            }
        });
        BCsButton.setVisible(false);
        jPanel10.add(BCsButton);

        recrystalButton.setText("Rekrystalizacja");
        recrystalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recrystalButtonActionPerformed(evt);
            }
        });
        jPanel10.add(recrystalButton);

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 380, 230, 40));

        jLabel10.setText("Recristalize: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, -1, -1));

        recrystallizationSlider.setMinimumSize(new java.awt.Dimension(100, 16));
        recrystallizationSlider.setPreferredSize(new java.awt.Dimension(100, 16));
        recrystallizationSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                recrystallizationSliderStateChanged(evt);
            }
        });
        jPanel1.add(recrystallizationSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 360, -1, -1));

        jLabel11.setText("0 %");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 360, -1, -1));

        jLabel3.setText("Nucleons count");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        randomSeedsCountText.setText("10");
        randomSeedsCountText.setMinimumSize(new java.awt.Dimension(40, 22));
        randomSeedsCountText.setPreferredSize(new java.awt.Dimension(40, 22));
        randomSeedsCountText.setVisible(true);
        randomSeedsCountText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomSeedsCountTextActionPerformed(evt);
            }
        });
        jPanel1.add(randomSeedsCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel1.setText("Inclusions count");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, -1, -1));

        jLabel2.setText("Size");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, -1, -1));

        jLabel6.setText("Shape");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, -1, -1));

        inclusionsCount.setText("10");
        inclusionsCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inclusionsCountActionPerformed(evt);
            }
        });
        jPanel1.add(inclusionsCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 50, -1));

        inclusionsSize.setText("5");
        inclusionsSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inclusionsSizeActionPerformed(evt);
            }
        });
        jPanel1.add(inclusionsSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, 30, 20));

        inclusionShapeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "square", "circular" }));
        inclusionShapeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inclusionShapeComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(inclusionShapeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, 130, -1));

        addInclusionsButton.setText("Add Inclusions");
        addInclusionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInclusionsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addInclusionsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 170, 60));

        radiusLabel.setText("Promień:");
        radiusLabel.setVisible(false);
        jPanel1.add(radiusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 170, -1, 22));

        radiusText.setText("10");
        radiusText.setMinimumSize(new java.awt.Dimension(40, 22));
        radiusText.setVisible(false);
        radiusText.setPreferredSize(new java.awt.Dimension(40, 22));
        radiusText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiusTextActionPerformed(evt);
            }
        });
        jPanel1.add(radiusText, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 170, -1, -1));

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.setForeground(new java.awt.Color(200, 100, 100));
        canvas.setToolTipText("");
        canvas.setPreferredSize(new java.awt.Dimension(630, 55));
        jPanel1.add(canvas, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 630, 490));

        widthField.setText("0");
        widthField.setText(String.valueOf(MultiscaleModelling.GrainGrowth.BoardSizeConstatnts.boardWidth));
        widthField.setToolTipText("");
        widthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widthFieldActionPerformed(evt);
            }
        });
        jPanel1.add(widthField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 80, -1));

        heightField.setText("0");
        heightField.setText(String.valueOf(MultiscaleModelling.GrainGrowth.BoardSizeConstatnts.boardHeight));
        heightField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightFieldActionPerformed(evt);
            }
        });
        jPanel1.add(heightField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 80, -1));

        jLabel7.setText("Width");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel13.setText("Height");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        boardResizeButton.setText("Rearrange");
        boardResizeButton.setToolTipText("");
        boardResizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boardResizeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(boardResizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 120, -1));

        jLabel16.setText("Extended Moore probability (0-100):");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 300, 30));

        jTextField1.setText("50");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 60, -1));

        structureSelectionTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Substructure", "Dual Phase", "Grow Boundaries" }));
        jPanel1.add(structureSelectionTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        structureSelectionTypeButton.setText("Generate");
        structureSelectionTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                structureSelectionTypeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(structureSelectionTypeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, -1, -1));

        jCheckBox1.setText("Select grains");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        jTextField2.setText("1");
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 40, -1));

        jLabel15.setText("Grain Boundary Size");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        jLabel17.setText("Selected grains:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, -1, -1));

        jCheckBox2.setText("Clear without boundaries");
        jCheckBox2.setToolTipText("");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel18.setText("% of GB:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 500, 60, 20));

        jLabel19.setText("0");
        jLabel19.setToolTipText("");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, -1, -1));

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        ImportMenu.setText("Import");
        ImportMenu.setToolTipText("");

        FromBitmapImport.setText("Bitmap");
        FromBitmapImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FromBitmapImportActionPerformed(evt);
            }
        });
        ImportMenu.add(FromBitmapImport);

        FromTextFileImport.setText("Text File");
        FromTextFileImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FromTextFileImportActionPerformed(evt);
            }
        });
        ImportMenu.add(FromTextFileImport);

        jMenuBar1.add(ImportMenu);

        ExportMenu.setText("Export");

        ToBitmapExport.setText("Bitmap");
        ToBitmapExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToBitmapExportActionPerformed(evt);
            }
        });
        ExportMenu.add(ToBitmapExport);

        ToTextFileExport.setText("Text File");
        ToTextFileExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToTextFileExportActionPerformed(evt);
            }
        });
        ExportMenu.add(ToTextFileExport);

        showGrainsBorders.setSelected(true);
        showGrainsBorders.setVisible(false);
        showGrainsBorders.setText("Show grains boarders");
        ExportMenu.add(showGrainsBorders);

        jMenuBar1.add(ExportMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private BufferedImage map( int sizeX, int sizeY, boolean showBoundary){
    final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
            for(int j=0;j<Main.sizeY;j++){
            for(int i=0;i<Main.sizeX;i++){
                if(grainGrowthBoard[i][j].getId() == 0 || (grainGrowthBoard[i][j].isBoundary()) && showBoundary ){
                    res.setRGB(i,j, Color.BLACK.getRGB() );
                }else{
                    int R = grainGrowthBoard[i][j].getR();
                    int G = grainGrowthBoard[i][j].getG();
                    int B = grainGrowthBoard[i][j].getB();
                    int grain = grainGrowthBoard[i][j].getId();
              
                    res.setRGB(i,j, new Color(R,G,B).getRGB() );
                }
            } 
        }
        return res;
    }
    
    private static void saveBMP( final BufferedImage bi, final String path ){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    private void ToBitmapExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToBitmapExportActionPerformed
        BufferedImage img = map(sizeX, sizeY, false);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            saveBMP( img, fileToSave.getAbsolutePath() + ".bmp" );
        }
    }//GEN-LAST:event_ToBitmapExportActionPerformed

    private void recrystallizationSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_recrystallizationSliderStateChanged
        jLabel11.setText(recrystallizationSlider.getValue() + " %");
        board.setRecrystalPercent(recrystallizationSlider.getValue());
    }//GEN-LAST:event_recrystallizationSliderStateChanged

    private void recrystalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recrystalButtonActionPerformed
        iterCount = 0;
        jLabel12.setText("Iteration: " + iterCount);
        if (thread != null) {
            thread.stop();
        }

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
               // startRecristalizationSimulation();
            }
        });
        thread.start();
    }//GEN-LAST:event_recrystalButtonActionPerformed

    private void BCsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCsButtonActionPerformed
        board.changePeriodic();
    }//GEN-LAST:event_BCsButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        iterCount = 0;
        if (jCheckBox2.isSelected()) {
            if (!selectedGrainList.isEmpty()) {
                grainGrowthBoard = board.clearWithoutBoundariesWithSelectedGrains(selectedGrainList);
            } else {
                grainGrowthBoard = board.clearWithoutBoundaries();
            }
            jLabel19.setText(String.format("%.2f", calculatePercenatageOfBorderGrains()));

        } else {
            canvas.setShowBoundaries(false);
            grainGrowthBoard = board.clear();
            jLabel19.setText("0");
        }
        jLabel12.setText("Iteration: " + iterCount);
        canvas.setGrains(grainGrowthBoard);
        canvas.repaint();
        jLabel9.setText("" + board.getCountGrainsCristal());
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void GenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButtonActionPerformed

            grainGrowthBoard = board.createRandomBoard(Integer.parseInt(randomSeedsCountText.getText()));
            canvas.setGrains(grainGrowthBoard);                                  
            canvas.repaint();                                              
            jLabel9.setText("" + board.getCountGrainsCristal());
    }//GEN-LAST:event_GenerateButtonActionPerformed

    private void ConditionsComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ConditionsComboBoxPopupMenuWillBecomeInvisible
        switch (ConditionsComboBox.getSelectedIndex()) {
            case 0:
            this.jPanel5.setVisible(false);
            this.jPanel6.setVisible(false);
            this.jPanel7.setVisible(false);
            break;
            case 2:
            this.jPanel5.setVisible(true);
            this.jPanel6.setVisible(false);
            this.jPanel7.setVisible(false);
            break;
            case 1:
            this.jPanel5.setVisible(false);
            this.jPanel6.setVisible(true);
            this.jPanel7.setVisible(false);
            break;
            case 3:
            this.jPanel5.setVisible(false);
            this.jPanel6.setVisible(false);
            this.jPanel7.setVisible(true);
            break;
            default:
            break;
        }
    }//GEN-LAST:event_ConditionsComboBoxPopupMenuWillBecomeInvisible

    private void NeighborhoodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeighborhoodComboBoxActionPerformed

    }//GEN-LAST:event_NeighborhoodComboBoxActionPerformed

    private void NeighborhoodComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_NeighborhoodComboBoxPopupMenuWillBecomeInvisible
        switch (NeighborhoodComboBox.getSelectedIndex()) {
            case 7:
            this.jPanel8.setVisible(true);
            break;
            default:
            this.jPanel8.setVisible(false);
            break;
        }
    }//GEN-LAST:event_NeighborhoodComboBoxPopupMenuWillBecomeInvisible

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        if (thread != null) {
            thread.stop();
        }
    }//GEN-LAST:event_StopButtonActionPerformed

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        iterCount = 0;
        jLabel12.setText("Iteration: " + iterCount);
        if (thread != null) {          
            thread.stop();
        }
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runSimulation();
            }
        });
        thread.start();
    }//GEN-LAST:event_StartButtonActionPerformed

    private void MonteCarloToogleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonteCarloToogleButtonActionPerformed
//        isMonteCarlo = !isMonteCarlo;
//        this.jPanel5.setVisible(isMonteCarlo);
    }//GEN-LAST:event_MonteCarloToogleButtonActionPerformed
    
    private void FromBitmapImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FromBitmapImportActionPerformed
        try {
            //openFile; 
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to import");   
            int userSelection = fileChooser.showOpenDialog(this);
           
            File bmpFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            BufferedImage image = ImageIO.read(bmpFile);
            sizeX = image.getWidth();
            sizeY = image.getHeight();
            System.out.print(sizeX + " " + sizeY);
            board.resizeXandY(sizeX, sizeY);
            canvas.setGrainBoardSize(sizeX, sizeY);
            for(int y = 0; y < sizeY; y++){
                for(int x = 0; x < sizeX; x++){
                    int clr =  image.getRGB(x,y); 
                    int  red   = (clr & 0x00ff0000) >> 16;
                    int  green = (clr & 0x0000ff00) >> 8;
                    int  blue  =  clr & 0x000000ff;
                    grainGrowthBoard[x][y].setRGB(red, green, blue);
                    if( red == 255 && blue == 255 && green == 255) {
                        grainGrowthBoard[x][y].setId(-1);
                        continue;
                    }
                    grainGrowthBoard[x][y].setId(red+green+blue);
                }
            }
            board.markBorderGrains();
            canvas.setGrains(grainGrowthBoard);
            canvas.repaint();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_FromBitmapImportActionPerformed

    private void ToTextFileExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToTextFileExportActionPerformed
        PrintWriter writer = null;
        try {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file that should be saved");   
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            writer = new PrintWriter(fileToOpen, "UTF-8");
            
            for(int y=0;y<50;y++){    
                for(int x=0;x<50;x++){
                    writer.println(grainGrowthBoard[x][y].getId() + "," 
                            + x + "," + y+ ","
                            + grainGrowthBoard[x][y].getR()+ "," 
                            + grainGrowthBoard[x][y].getG() + "," 
                            + grainGrowthBoard[x][y].getB());
                }
            }
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }//GEN-LAST:event_ToTextFileExportActionPerformed

    private void FromTextFileImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FromTextFileImportActionPerformed
  try {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file that should be saved");            
                int userSelection = fileChooser.showOpenDialog(this);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fileChooser.getSelectedFile();
                BufferedReader in = new BufferedReader(new FileReader(fileToOpen));
                while(true){
                    String line = in.readLine();
                    if(line == null ) break;
                    String[] propperties = line.split(",");
                    int id = Integer.parseInt(propperties[0]);
                    int x = Integer.parseInt(propperties[1]);		
                    int y = Integer.parseInt(propperties[2]);
                    int R = Integer.parseInt(propperties[3]);
                    int G = Integer.parseInt(propperties[4]);
                    int B = Integer.parseInt(propperties[5]);
                    grainGrowthBoard[x][y].setId(id);
                    grainGrowthBoard[x][y].setRGB(R,G,B); 
                }          
            }
        } catch (HeadlessException headlessException) {
        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
        grainGrowthBoard = board.markBorderGrains();
        canvas.setGrains(grainGrowthBoard);
        canvas.repaint(); 
    }//GEN-LAST:event_FromTextFileImportActionPerformed

    private void inclusionsCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inclusionsCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inclusionsCountActionPerformed

    private void inclusionsSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inclusionsSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inclusionsSizeActionPerformed

    private void inclusionShapeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inclusionShapeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inclusionShapeComboBoxActionPerformed

    private void addInclusionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInclusionsButtonActionPerformed
        int size = Integer.parseInt(inclusionsSize.getText());
        int count = Integer.parseInt(inclusionsCount.getText());
        int shapeID = inclusionShapeComboBox.getSelectedIndex();
        int x0 = 0;
        int y0 = 0;
        Random rand = new Random();
       
        ArrayList<Grain> borderGrainsList = board.getBorderGrains();

        for(int attempt = 0; attempt < count; attempt++)
        {
            if(board.isSimulationComplete()){
                int randomGrainIndex = rand.nextInt(borderGrainsList.size());
                Grain randomGrain = borderGrainsList.get(randomGrainIndex);  
                x0 = randomGrain.getX();
                y0 = randomGrain.getY();
            }
            else {
                x0 = rand.nextInt(sizeX);
                y0 = rand.nextInt(sizeY);
            }
            // square 
            if (shapeID == 0) {
                // center of square
                int a = (int) ((size/1.44)/ 2);
                for(int dx = -a; dx < a; dx++) {
                    for(int dY = -a; dY <a; dY++) {
                        if(x0+dx < sizeX && x0+dx >= 0 && y0+dY < sizeY && y0+dY >=0 ) {
                            grainGrowthBoard[x0+dx][y0+dY].setId(-1);
                            grainGrowthBoard[x0+dx][y0+dY].setRGB(255,255,255);
                        }
                    }
                }
            }
            // circle
            else {
                for(int y=-size; y<=size; y++)
                    for(int x=-size; x<=size; x++)
                        if(x*x+y*y <= size*size && x0+x < sizeX && x0+x>=0 && y0+y < sizeY && y0+y>=0)
                            grainGrowthBoard[x0+x][y0+y].setId(-1);
            }       
        }
        grainGrowthBoard = board.markBorderGrains();
        canvas.setGrains(grainGrowthBoard);
        canvas.repaint();
        
    }//GEN-LAST:event_addInclusionsButtonActionPerformed

    private void radiusTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiusTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radiusTextActionPerformed

    private void widthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_widthFieldActionPerformed

    private void boardResizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boardResizeButtonActionPerformed
        int newWidth = Integer.parseInt(widthField.getText());
        int newHeight = Integer.parseInt(heightField.getText());
        if (newHeight > BoardSizeConstatnts.boardHeight || newHeight <= 300) {
            newHeight = 300;
        }
        if (newWidth > BoardSizeConstatnts.boardWidth || newWidth <= 300) {
            newWidth = 300;
        }
        sizeX = newWidth;
        sizeY = newHeight;
        board.resizeXandY(newWidth, newHeight);
        canvas.setGrainBoardSize(newWidth, newHeight);
        grainGrowthBoard = board.clear();
        canvas.setGrains(grainGrowthBoard);
        canvas.repaint(); 
        widthField.setText(String.valueOf(newWidth));
        heightField.setText(String.valueOf(newHeight));
    }//GEN-LAST:event_boardResizeButtonActionPerformed

    private void heightFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heightFieldActionPerformed

    private void randomSeedsCountTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomSeedsCountTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_randomSeedsCountTextActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void structureSelectionTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_structureSelectionTypeButtonActionPerformed

        if (this.structureSelectionTypeComboBox.getSelectedIndex() == 1 ||
            this.structureSelectionTypeComboBox.getSelectedIndex() == 0 )
            grainGrowthBoard = board.removeAllGrainsExceptSelected(selectedGrainList);
            jLabel19.setText("0");

        if (this.structureSelectionTypeComboBox.getSelectedIndex() == 1) 
        {
            grainGrowthBoard = board.dualPhaseIdChange();
            selectedGrainList.clear();
        }

        if ( this.structureSelectionTypeComboBox.getSelectedIndex() == 2)
        {
            int size = Integer.parseInt(jTextField2.getText());
            grainGrowthBoard = board.growBoundaries(size, selectedGrainList);
            canvas.setShowBoundaries(true);
            jLabel19.setText(String.format("%.2f", calculatePercenatageOfBorderGrains()));
        }
       canvas.setGrains(grainGrowthBoard);
       canvas.repaint();
    }//GEN-LAST:event_structureSelectionTypeButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (!jCheckBox1.isSelected()) {
            selectedGrainList.clear();
            jLabel17.setText("Selected grains: " + selectedGrainList);
        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed
    private double calculatePercenatageOfBorderGrains() {
        int borderGrainsCnt = 0;
        for (int i = 0;i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                if (grainGrowthBoard[i][j].isBoundary()) {
                    borderGrainsCnt++;
                }
            }
        }
        return ((double) borderGrainsCnt / ((double) sizeX * (double) sizeY)) * 100;
    }
    private void runSimulation() {
            while (true) {
                iterCount++;
                jLabel12.setText("Iteration: " + iterCount);
                int probability = Integer.parseInt(jTextField1.getText());
                if (probability > 100 ) {
                    probability = 100;
                } else if (probability < 0) {
                    probability = 0;
                }
                jTextField1.setText(String.valueOf(probability));
                board.setGrainsToSkip(selectedGrainList);
                grainGrowthBoard = board.calculate(
                    NeighborhoodComboBox.getSelectedIndex(),
                    Integer.parseInt(radiusText.getText()),
                    probability);

                if (board.getNucleonsCount() >= (sizeX * sizeY)) {
                    grainGrowthBoard = board.markBorderGrains();
                    jLabel9.setText("" + board.getCountGrainsCristal());
                    canvas.setGrains(grainGrowthBoard);
                    canvas.repaint();
                    thread.stop();
                }
            }
    }

    private void addGrainToListOnMouseClick(int x, int y) {
        if (selectedGrainList.contains(grainGrowthBoard[x][y].getId())) {
            selectedGrainList.remove((Object) grainGrowthBoard[x][y].getId());
        } else {
            selectedGrainList.add(grainGrowthBoard[x][y].getId());
        }
        System.out.println(selectedGrainList);
        jLabel17.setText("Selected grains: " + selectedGrainList);
    }
    public class HandlerClass implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (jCheckBox1.isSelected()) {
                addGrainToListOnMouseClick(e.getX(), e.getY());
            } else {
                mouseC(e.getX(), e.getY());
            }
        }

        int xPres, yPres;

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
           // mauseM(e.getX(), e.getY());
        }

    }

    private void mauseM(int i, int j) {
//
//        int R = grainGrowthBoard[i][j].getR();
//        int G = grainGrowthBoard[i][j].getG();
//        int B = grainGrowthBoard[i][j].getB();
//        idLabel.setText("" + grainGrowthBoard[i][j].getId());
//        colorValueLabel.setText("(" + R + "," + G + "," + B + ")" + "     " + grainGrowthBoard[i][j].isBoundary());
//        colorPanel.setBackground(new Color(R, G, B));
//        colorPanel.setVisible(false);
    }

    private void mouseC(int x, int y) {
//        if (x < sizeX && y < sizeY) {
//            int xp = (int) Math.floor(x / (BoardSizeConstatnts.boardWidth / sizeX));
//            int yp = (int) Math.floor(y / (BoardSizeConstatnts.boardHeight / sizeY));
//            grainGrowthBoard = board.addGrain(xp, yp);
//            canvas.setGrains(grainGrowthBoard);
//            canvas.repaint();
//            jLabel9.setText("" + board.getCountGrainsCristal());
//        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BCsButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JComboBox ConditionsComboBox;
    private javax.swing.JMenu ExportMenu;
    private javax.swing.JMenuItem FromBitmapImport;
    private javax.swing.JMenuItem FromTextFileImport;
    private javax.swing.JButton GenerateButton;
    private javax.swing.JMenu ImportMenu;
    private javax.swing.JToggleButton MonteCarloToogleButton;
    private javax.swing.JComboBox NeighborhoodComboBox;
    private javax.swing.JLabel NeighborhoodLabel;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton StopButton;
    private javax.swing.JMenuItem ToBitmapExport;
    private javax.swing.JMenuItem ToTextFileExport;
    private javax.swing.JLabel YLabelSize;
    private javax.swing.JButton addInclusionsButton;
    private javax.swing.JTextField amountRingsField;
    private javax.swing.JButton boardResizeButton;
    private MultiscaleModelling.GrainGrowth.Canvas canvas;
    private javax.swing.JTextField countXText;
    private javax.swing.JTextField countYText;
    private javax.swing.JTextField heightField;
    private javax.swing.JComboBox<String> inclusionShapeComboBox;
    private javax.swing.JTextField inclusionsCount;
    private javax.swing.JTextField inclusionsSize;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel radiusLabel;
    private javax.swing.JTextField radiusText;
    private javax.swing.JTextField randomSeedsCountText;
    private javax.swing.JButton recrystalButton;
    private javax.swing.JSlider recrystallizationSlider;
    private javax.swing.JTextField ringSizeField;
    private javax.swing.JRadioButtonMenuItem showGrainsBorders;
    private javax.swing.JButton structureSelectionTypeButton;
    private javax.swing.JComboBox<String> structureSelectionTypeComboBox;
    private javax.swing.JTextField widthField;
    private javax.swing.JLabel xLabelSize;
    // End of variables declaration//GEN-END:variables
}
