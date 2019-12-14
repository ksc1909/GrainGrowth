package MultiscaleModelling.GrainGrowth;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author mswiader
 */
public class Board {

    /// MARK: Variables
    private  int sizeX;
    private  int sizeY;
    private   Grain[][] grainsArray;
    private  Grain[][] grainsTemporaryArray;
    private  int[][] temporaryBoardArray;
 
    private int countGrainsCristal = 0;
    private int countGrainsRecristal = 0;

    private int n;
    private final Random random = new Random();
    private boolean isPeriodic;
    private boolean shouldEndSimulation;

    private final double reA = 86710969050178.5;
    private final double reB = 9.41268203527779;
    private final double roMax = 28105600.95;
    private double ro = 0;
    private double roSr = 0;
    private double recrystalizationPercentage;
    private boolean contentGrains;
    private boolean simulationComplete;

    public void changeContentGrains() {
        contentGrains = !contentGrains;
    }
   
    public void setRecrystalPercent(double recrystalPercent) {
        this.recrystalizationPercentage = recrystalPercent;
    }

    public int getCountGrainsRecristal() {
        return countGrainsRecristal;
    }

    public int getCountGrainsCristal() {
        return countGrainsCristal;
    }

    public boolean shouldEndSimulation() {
        return shouldEndSimulation;
    }
    
    boolean isSimulationComplete() {
        return simulationComplete;
    }

    public Board(int size_x, int size_y) {
        contentGrains = false;
        simulationComplete = false;
        recrystalizationPercentage = 10;
        shouldEndSimulation = false;
        isPeriodic = false;
        this.sizeX = size_x;
        this.sizeY = size_y;
        n = 0;
        grainsArray = new Grain[size_x][size_y];
        grainsTemporaryArray = new Grain[size_x][size_y];
        temporaryBoardArray = new int[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                grainsArray[i][j] = new Grain();
                grainsTemporaryArray[i][j] = new Grain();
            }
        }
    }
    
    public void resizeXandY(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
        grainsArray = new Grain[x][y];
        grainsTemporaryArray = new Grain[x][y];
        temporaryBoardArray = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grainsArray[i][j] = new Grain();
                grainsTemporaryArray[i][j] = new Grain();
            }
        }
    }
    
    public void changePeriodic() {
        isPeriodic = !isPeriodic;
    }

    public Grain[][] createRandomBoard(int count) {
        for (int i = 0; i < count; i++) {
            int x = random.nextInt(sizeX);
            int y = random.nextInt(sizeY);
            Grain g = grainsArray[x][y];
            if (g.getId() == 0) {
                n++;
                grainsArray[x][y].setId(n);
            } else {
                --i;
            }
        }
        countGrainsCristal = n;
        return grainsArray;
    };
    
    public Grain[][] randomBoard(int randomSetup, int countX, int countY, int randomSize, int ringSize, int countRing) {
        switch (randomSetup) {
            case 0:

                for (int i = 0; i < sizeX; i++) {
                    for (int j = 0; j < sizeY; j++) {
                        if (random.nextInt(1000) > 998) {
                            n++;
                            grainsArray[i][j].setId(n);
                        }
                    }
                }

                break;
            case 1:

                for (int i = countX; i < sizeX; i += countX) {
                    for (int j = countY; j < sizeY; j += countY) {
                        n++;
                        grainsArray[i][j].setId(n);
                    }
                }

                break;
            case 2:

                for (int i = 0; i < randomSize; i++) {
                    n++;
                    grainsArray[random.nextInt(sizeX)][random.nextInt(sizeY)].setId(n);
                }

                break;
            case 3:

                ArrayList<Point> points = new ArrayList<>();

                for (int i = 0; i < countRing; i++) {
                    int spr = 0;
                    int randX = random.nextInt(sizeX);
                    int randY = random.nextInt(sizeY);
                    boolean findOk = false;
                    while (spr < 100) {
                        spr++;
                        findOk = true;

                        for (Point p : points) {
                            findOk = true;

                            if (!p.point2point(randX, randY, ringSize)) {
                                findOk = false;
                                randX = random.nextInt(sizeX);
                                randY = random.nextInt(sizeY);
                                break;
                            }
                        }
                        if (findOk) {
                            n++;
                            points.add(new Point(randX, randY, 0, n));
                            break;
                        }
                    }
                }
                for (Point p : points) {
                    grainsArray[p.getX()][p.getY()].setId(p.getId());
                }

                break;
            default:
                break;
        }
        countGrainsCristal = n;
        return grainsArray;
    }

    public Grain[][] clear() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                grainsArray[i][j].setId(0);
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 1; j < sizeY; j++) {
                grainsArray[i][j].setB(false);
            }
        }
        n = 0;
        simulationComplete = false;
        return grainsArray;
    }

    public Grain[][] markBorderGrains() {
        for (int i = 1; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (grainsArray[i][j].getId() != grainsArray[i - 1][j].getId() && !grainsArray[i][j].isBoundary()) {
                    grainsArray[i][j].setB(true);
                }
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 1; j < sizeY; j++) {
                if (grainsArray[i][j].getId() != grainsArray[i][j - 1].getId() && !grainsArray[i][j].isBoundary()) {
                    grainsArray[i][j].setB(true);
                }
            }
        }
        simulationComplete = true;
        return grainsArray;
    }

    public Grain[][] addGrain(int i, int j) {
        n++;
        grainsArray[i][j].setId(n);
        countGrainsCristal = n;
        return grainsArray;
    }

    public int recrystal() {
        int sum = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (grainsArray[i][j].isR()) {
                    sum++;
                }
            }
        }
        return sum;
    }
    
    public ArrayList<Grain> getBorderGrains(){
        ArrayList<Grain> grains = new ArrayList();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(grainsArray[i][j].isBoundary())
                    grains.add(grainsArray[i][j]);
            }
        }
        return grains;
    }

    public int getNucleonsCount() {
        int sum = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (grainsArray[i][j].getId() != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public void clearRecrystal() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                grainsArray[i][j].setR(false);
                grainsArray[i][j].setRo(0);
            }
        }
        countGrainsRecristal = 0;
    }
    
    /// One thread calculation
    public Grain[][] calculate(int neighborhoodType, int r) {
        shouldEndSimulation = true;
        // COPY OF PREVIUS STEP
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                temporaryBoardArray[i][j] = grainsArray[i][j].getId();
            }
        }

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (grainsArray[i][j].getId() == 0) {
                    shouldEndSimulation = false;
//                    if (neighborhoodType == 7) {
//                        temporaryBoardArray[i][j] = randomArea(i, j, r);
//                    } 
//                    else if (neighborhoodType == 8)
//                    {
//                        temporaryBoardArray[i][j] = extendedMoorArea(i,j);
//                    }
//                    else {
                        int tmpCellBoard[][] = new int[3][3];
                        tmpCellBoard = createSingleCellBoard(i, j, neighborhoodType);
                        temporaryBoardArray[i][j] = getDominatedNeighoorhoodId(tmpCellBoard);
//                    }
                }
            }
        }
        // APPLY NEXT NEXT
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                grainsArray[i][j].setId(temporaryBoardArray[i][j]);
            }
        }
        return grainsArray;
    }

    private int[][] createSingleCellBoard(int i, int j, int neighborhoodType) {
        int[][] area = new int[3][3];

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int l_x = (sizeX + (i - 1 + k)) % sizeX;
                int l_y = (sizeY + (j - 1 + l)) % sizeY;
                    area[k][l] = grainsArray[l_x][l_y].getId();
            }
        }
        if (i == 0) {
            for (int k = 0; k < 3; k++) {
                area[0][k] = 0;
            }
        }
        if (j == 0) {
            for (int k = 0; k < 3; k++) {
                area[k][0] = 0;
            }
        }
        if (i == sizeX - 1) {
            for (int k = 0; k < 3; k++) {
                area[2][k] = 0;
            }
        }
        if (j == sizeY - 1) {
            for (int k = 0; k < 3; k++) {
                area[k][2] = 0;
            }
        }
        switch (neighborhoodType) {
            case 0: //moore
            {
                break;
            }
            case 1: //neumann
            {
                area[0][0] = 0;
                area[2][0] = 0;
                area[0][2] = 0;
                area[2][2] = 0;
                break;
            }
            case 2: //hex L
            {
//                area[0][2] = 0;
//                area[2][0] = 0;
                break;
            }
            case 3: //hex P
            {
//                area[0][0] = 0;
//                area[2][2] = 0;
                break;
            }
            case 4: //hex R
            {
  // NOT USED FOR MAGISTERKA

//                if (random.nextBoolean()) {
//                    area[0][2] = 0;
//                    area[2][0] = 0;
//                } else {
//                    area[0][0] = 0;
//                    area[2][2] = 0;
//                }
                break;
            }
            case 5: //pen L
            {
                // NOT USED FOR MAGISTERKA
//                int randPent = random.nextInt(4);
//                if (randPent == 0) {
//                    for (int k = 0; k < 3; k++) {
//                        area[0][k] = 0;
//                    }
//                } else if (randPent == 1) {
//                    for (int k = 0; k < 3; k++) {
//                        area[k][0] = 0;
//                    }
//                } else if (randPent == 2) {
//                    for (int k = 0; k < 3; k++) {
//                        area[2][k] = 0;
//                    }
//                } else {
//                    for (int k = 0; k < 3; k++) {
//                        area[k][2] = 0;
//                    }
//                }
                break;
            }
            case 7: //for moor extended
            {
                area[0][1] = 0;
                area[1][0] = 0;
                area[1][2] = 0;
                area[2][1] = 0;
                break;
            }
            default:
                break;
        }
        return area;
    }
    
    // Checks neighborhood and return ID of the seed that dominate in this area 
    private int getDominatedNeighoorhoodId(int[][] tab) {                                

        List<Integer> list = new ArrayList<>();
        
        for ( int i=0;i<3; ++i) {
            for (int j =0;j < 3;++j) {
                if (tab[i][j] != 0 && tab[i][j] != -1) {
                    list.add(tab[i][j]);
                }
            }
        }
        
        if (list.isEmpty()) {
            return 0;
        } else {
            int maxCnt = 0;
            int dominatedId = 0;
            Set<Integer> idSet = new HashSet<>(list);
            for(Integer id: idSet){
             int idCnt = Collections.frequency(list,id);
             if (idCnt > maxCnt) {
                 maxCnt = idCnt;
                 dominatedId = id;
             }
            }
            return dominatedId;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private int extendedMoorArea(int x, int y) {
        int tmp[][] = new int[3][3];
        HashSet<Integer> uniqueIds = new HashSet<>();
        
        /// Applying rules
        LinkedHashMap<Integer, Integer> configurations = new LinkedHashMap<Integer, Integer>(){{put(0,5); put(1,3); put(7,3);}};
        Set<Map.Entry<Integer,Integer>> configurationsSet = configurations.entrySet(); 

        for (Map.Entry<Integer, Integer> it : configurationsSet){
            tmp = createSingleCellBoard(x ,y ,it.getKey());
            uniqueIds = getUniqueIdsFromNeighborhood(tmp);
            for(Integer id : uniqueIds)
                 if (countOccurrence(id, tmp) > it.getValue()) return id;
        }
        
        tmp = createSingleCellBoard(x ,y ,0);
        
        /// Applying propability
        if(random.nextInt(100)> 80) return getDominatedNeighoorhoodId(tmp);
        else return 0;
    }
    
    private HashSet<Integer> getUniqueIdsFromNeighborhood(int tmp[][]) {
        HashSet<Integer> uniqueIds = new HashSet<>();
        for(int i =0;i<3;i++)
            for(int j =0;j<3;j++)
                if(tmp[i][j] != 0) uniqueIds.add(tmp[i][j]);
        return uniqueIds;      
    }
    
    private int countOccurrence(int id, int tmp[][]) {
        int count = 0;
        for(int i =0;i<3;i++)
            for(int j =0;j<3;j++)
                if (id == tmp[i][j]) count++;
        
        return count;
    }
}