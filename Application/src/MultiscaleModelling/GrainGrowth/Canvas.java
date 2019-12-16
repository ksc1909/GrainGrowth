package MultiscaleModelling.GrainGrowth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author mswiader
 */

/// Main element of the application that presents the grains and simulation container
public class Canvas extends JComponent {
    private Grain[][] grainsArray;
    private  int sizeX = BoardSizeConstatnts.boardWidth;
    private  int sizeY = BoardSizeConstatnts.boardHeight;
    private int maximumX = BoardSizeConstatnts.boardWidth;
    private int maximumY = BoardSizeConstatnts.boardHeight;
    private boolean showBoundaries = false;

    /// Initializes Canvas
    public Canvas(){
        grainsArray = new Grain[sizeX][sizeY];
        for(int i=0;i<sizeX;i++){
            for(int j=0;j<sizeY;j++){
                grainsArray[i][j] = new Grain();
            } 
        }
    }
    public void setShowBoundaries(boolean showBoundaries) {
        this.showBoundaries = showBoundaries;
    }
    /// Sets RGB color to the grains
    public void setRGB(Grain[][] grains) {
        for(int j=0;j<sizeY;j++){
            for(int i=0;i<sizeX;i++){
                    int R=0;
                    int G=0;
                    int B=0;
                    int grainId = grains[i][j].getId();
                    
                switch (grainId) {
                    // INCLUSION
                    case -1:
                        grains[i][j].setRGB(255,255,255);
                        break;
                    // NORMAL
                    case 0:
                        grains[i][j].setRGB(0, 0, 0);
                        break;
                    case -2:
                        grains[i][j].setRGB(255,105,180);
                        break;
                    default:
                        switch(grainId % 3) {
                            case 0:
                                R=(grainId * 10 + 100) % 254;
                                G=(grainId * 5 + 100) % 254;
                                B=(grainId * 2 + 100) % 254;
                                break;
                            case 1:
                                R=(grainId * 2 + 100) % 254;
                                G=(grainId * 10 + 100) % 254;
                                B=(grainId * 5 + 100) % 254;
                                break;
                            case 2:
                                R=(grainId * 5 + 100) % 254;
                                G=(grainId * 2 + 100) % 254;
                                B=(grainId * 10 + 100) % 254;
                                break;
                            default:
                                break;
                        }
                        grains[i][j].setRGB(R, G, B);
                        break;
                }
                grains[i][j].setX(i);
                grains[i][j].setY(j);
            }
        }
    }
        
    @Override
    public void paint(Graphics g){
        for(int j = 0; j < sizeY; ++j) {
            for(int i = 0; i < sizeX; ++i) {
                if (grainsArray[i][j].isBoundary() && showBoundaries){
                   g.setColor(Color.BLACK);
                } else if(grainsArray[i][j].getId() == 0){
                    g.setColor(Color.WHITE);
                }else {
                    g.setColor(new Color(grainsArray[i][j].getR(),grainsArray[i][j].getG(),grainsArray[i][j].getB()));
                }
                g.fillRect(Math.round((maximumX/sizeX)*i),Math.round((maximumY/sizeY)*j),Math.round(maximumX/sizeX),Math.round(maximumY/sizeY));
            } 
        }
    }
    
    public void setGrains(Grain[][] grains){
        setRGB(grains);
        this.grainsArray = grains;
    }
    public void setGrainBoardSize(int x, int y) {
        sizeX = x;
        sizeY = y;
        setSize(x, y);
        setMinimumSize(new Dimension(x, y));
        setMaximumSize(new Dimension(x, y));
        maximumX = x;
        maximumY = y;
    }
}
