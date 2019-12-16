package MultiscaleModelling.GrainGrowth;

/**
 *
 * @author mswiader
 */
public class Grain {

    /// Id of the grain
    private int id = 0;
    
    /// Variable indicating if it is boundary or not
    private boolean isBoundary = false;
    
    private boolean r = false;
    
    /// Red color, part of RGB color palette
    private int R;
    
    /// Green Color, part of RGB color palette
    private int G;
    
    /// Blue color, part of RGB color palette
    private int B;
    
    /// X position of the grain
    private int x;
    
    /// Y position of the grain
    private int y;

    /// - MARK: Setters and Getters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
   
    public int getId() {
        return id;
    }

    public boolean isBoundary() {
        return isBoundary;
    }

    public void setBoundary(boolean isBoundary) {
        this.isBoundary = isBoundary;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }
    
    public void setRGB(int R, int G, int B) {
      this.R = R;
      this.G = G;
      this.B = B;
    }
    
    public int getR() {
        return R;
    }
    
    public int getG() {
        return G;
    }
    
    public int getB() {
        return B;
    }
}
