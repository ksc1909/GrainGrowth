package MultiscaleModelling.GrainGrowth;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author mswiader
 */
public class Board {

    private  int sizeX;
    private  int sizeY;
    private  Grain[][] grainsArray;
    private  Grain[][] grainsTemporaryArray;
    private  int[][] temporaryBoardArray;
 
    private int countGrainsCristal = 0;

    private int n;
    private final Random random = new Random();
    private boolean shouldEndSimulation;

    private boolean simulationComplete = false;
    private ArrayList<Integer> grainsToSkip;
   
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
        simulationComplete = false;
        shouldEndSimulation = false;
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

    public Grain[][] clearWithoutBoundaries() {
        n = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (!grainsArray[i][j].isBoundary()) {
                    grainsArray[i][j].setId(0);
                    grainsArray[i][j].setBoundary(false);
                }
            }
        }
        simulationComplete = false;
        return grainsArray;
    }
    public Grain[][] clearWithoutBoundariesWithSelectedGrains(ArrayList<Integer> selectedGrains) {
        n = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (!grainsArray[i][j].isBoundary() || !selectedGrains.contains((Object) grainsArray[i][j].getId())) {
                    grainsArray[i][j].setId(0);
                    grainsArray[i][j].setBoundary(false);
                }
            }
        }
        simulationComplete = false;
        return grainsArray;
    }
    public Grain[][] clear() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                grainsArray[i][j].setId(0);
                grainsArray[i][j].setBoundary(false);
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
                    grainsArray[i][j].setBoundary(true);
                }
            }
        }
        for (int i = 0; i < sizeX; i++) {
            for (int j = 1; j < sizeY; j++) {
                if (grainsArray[i][j].getId() != grainsArray[i][j - 1].getId() && !grainsArray[i][j].isBoundary()) {
                    grainsArray[i][j].setBoundary(true);
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
    
    /// One thread calculation
    public Grain[][] calculate(int neighborhoodType, int probability) {
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
                    if (neighborhoodType == 2)
                    {
                        temporaryBoardArray[i][j] = applyExtendedMoore(i,j, probability);
                    } else {
                        int tmpCellBoard[][] = new int[3][3];
                        tmpCellBoard = createSingleCellBoard(i, j, neighborhoodType);
                        temporaryBoardArray[i][j] = getDominatedNeighoorhoodId(tmpCellBoard);
                    }
                } else if (grainsArray[i][j].getId() == -2) {
                    continue;
                }
            }
        }
        // APPLY NEXT
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
            case 2: //for moor extended
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

    void setGrainsToSkip(ArrayList<Integer> selectedGrainList) {
        grainsToSkip = selectedGrainList;
    }
    // Checks neighborhood and return ID of the seed that dominate in this area 
    private int getDominatedNeighoorhoodId(int[][] tab) {                                
        List<Integer> list = new ArrayList<>();
        
        for ( int i=0;i<3; ++i) {
            for (int j =0;j < 3;++j) {
                if (tab[i][j] != 0 && tab[i][j] != -1  && tab[i][j] != -2 && !grainsToSkip.contains(tab[i][j])) {
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
      
    private int applyExtendedMoore(int x, int y, int probability) {
        int tmp[][] = new int[3][3];
        HashSet<Integer> uniqueIds = new HashSet<>();

        HashMap<Integer, Integer> configuration = new HashMap<>();
        // moore
        configuration.put(0, 5);
        //neumann
        configuration.put(1, 3);
        //extended moore
        configuration.put(2, 3);
        
     
        Iterator it = configuration.entrySet().iterator();
        while (it.hasNext()) { 
            Map.Entry conf = (Map.Entry)it.next(); 
            int neighborhood = (int) conf.getKey();
            int count = (int) conf.getValue();
            tmp = createSingleCellBoard(x ,y , neighborhood);
            uniqueIds = getIdsFromNeighbourhood(tmp);
            for(Integer id : uniqueIds)
                 if (getUniqueIdOccurance(id, tmp) > count)
                     return id;
        } 
        
                tmp = createSingleCellBoard(x ,y ,0);
        
        /// Applying propability
        if(random.nextInt(100)> (100 - probability))
            return getDominatedNeighoorhoodId(tmp);
        else 
            return 0;
    }
    // Unique ids
    private HashSet<Integer> getIdsFromNeighbourhood(int tmp[][]) {
        HashSet<Integer> uniqueIds = new HashSet<>();
        for(int i =0;i<3;i++)
            for(int j =0;j<3;j++)
                if(tmp[i][j] != 0) uniqueIds.add(tmp[i][j]);
        return uniqueIds;      
    }
    
    private int getUniqueIdOccurance(int id, int tmp[][]) {
        int count = 0;
        for(int i = 0;i < 3;i++)
            for(int j = 0;j < 3;j++)
                if (id == tmp[i][j]) count++;
        
        return count;
    }
    public Grain[][] removeAllGrainsExceptSelected(ArrayList<Integer> selectedGrains) {        
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(!selectedGrains.contains(grainsArray[i][j].getId()))
                {
                    grainsArray[i][j].setId(0);
                    grainsArray[i][j].setBoundary(false);
                }
            }
        }
        return grainsArray;
    }
    Grain[][] changeIDForDualPhase() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                 if (grainsArray[i][j].getId() != 0) {
                     grainsArray[i][j].setId(-2);
                     grainsArray[i][j].setBoundary(false);
                 }
            }
        }
        return grainsArray;
    }
    Grain[][] makeBoundariesGrow(int size , ArrayList<Integer> selectedGrainList) {
        grainsArray = markBorderGrains();
        ArrayList<Grain> grainToSet = new ArrayList<>();
        
        if(selectedGrainList.isEmpty()) {
            for (int k = 0; k < size; k++) {
                for (int i = 0; i < sizeX; i++) {
                    for (int j = 0; j < sizeY; j++) {
                        if (neighbourhoodBoundariesPresent(i,j)) {
                            grainToSet.add(grainsArray[i][j]);
                        }
                    }
                }
                grainToSet.forEach((grain) -> {
                    grain.setBoundary(true);
                });  
            }
            drawBoundaries();
        } else {
            for (int k = 0; k < size; k++) {
                for (int i = 0; i < sizeX; i++) {
                    for (int j = 0; j < sizeY; j++) {
                        if (neighbourhoodBoundariesPresent(i,j) && selectedGrainList.contains(grainsArray[i][j].getId()))
                        {
                            grainToSet.add(grainsArray[i][j]);
                        }
                    }
                }
                removeUnmarkedBorders(selectedGrainList);
                grainToSet.forEach((grain) -> {
                    grain.setBoundary(true);
                });
            }
        }
        drawBoundaries();
        return grainsArray;
    }
    boolean neighbourhoodBoundariesPresent(int x, int y) {
        for (int i = x-1; i <= x+1 && i>0 && i< sizeX; i++) {
            for (int j = y-1; j <= y+1 && j>0 && j< sizeY; j++) {
                if(grainsArray[i][j].isBoundary()) return true;
            }
        }
        return false;
    }
    void drawBoundaries() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
               // if(grainsArray[i][j].isBoundary()) grainsArray[i][j].setId(0);
            }
        }
    }
    private void removeUnmarkedBorders(ArrayList<Integer> selectedGrainList) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if(grainsArray[i][j].isBoundary() && !selectedGrainList.contains(grainsArray[i][j].getId()))
                    grainsArray[i][j].setBoundary(false);
                    grainsArray[i][j].setId(grainsArray[i][j].getId());
            }
        }
    }
}