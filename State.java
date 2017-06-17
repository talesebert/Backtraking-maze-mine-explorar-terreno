
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tales Igor Ebert
 * Create on 2017-06-16
 */
public class State
{
    /*private int[][] m = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, // maze_mine_big
                         {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                         {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                         {1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                         {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                         {1, 0, 9, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                         {1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                         {1, 0, 0, 9, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                         {1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 4, 1, 1, 9, 1},
                         {1, 0, 9, 9, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                         {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                         {1, 0, 1, 0, 0, 0, 9, 0, 0, 9, 0, 0, 0, 0, 1},
                         {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                         {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    
    */
    int[][] m =    {{1, 1, 1, 1}, // maze_min_little
                    {1, 0, 0, 1},
                    {1, 9, 0, 1},
                    {1, 0, 4, 1},
                    {1, 1, 1, 1},
                    };
    
    private String debug_path = "";
    private int cost_path = 0;
    private int traveled = 0;
    private boolean enable_debug = false;
    private int best_cost = 0;
    
    private int row = 1, col = 1; // initial position
    
    public State()
    {
    }
    
    public void setLand(int[][] land)
    {
        this.m = land;
    }
    
    public void addTraveledCost(int traveled, int cost)
    {
        this.traveled += traveled;
        this.cost_path += cost;
    }
    
    public void addPath(int y, int x, String land, int cost)
    {
        if (this.enable_debug){
            this.debug_path += "y(" +y+ "), x(" +x+ "), land: "+land+", cost: "+cost+"\n";
        }
    }
    
    public String getDebugPath()
    {
        return this.debug_path;
    }
            
    public State(State s)
    {
        for (int r=0; r<m.length; r++) {
            for (int c=0; c<m[0].length; c++) {
                this.m[r][c] = s.m[r][c]; } } 
        this.row = s.row;
        this.col = s.col;
        this.enable_debug = s.enable_debug;
        this.debug_path = s.debug_path;
        this.cost_path = s.cost_path;
        this.traveled = s.traveled;
    }
    
    public int getCost()
    {
        return this.cost_path;
    }
    
    public int getTraveled()
    {
        return this.traveled;
    }
   
    public int get(int r, int c)
    { 
        return this.m[r][c]; 
    }
    
    public int getRow() 
    { 
        return this.row; 
    }
    
    public int getCol() 
    {
        return this.col; 
    }

    public void set(int r, int c, int v)
    {
        this.m[r][c] = v;
    }
    
    public void enableDebug()
    {
        this.enable_debug = true;
    }
    
    public boolean getStateDebug()
    {
        return this.enable_debug;
    }
    
    public void setRow(int r)
            
    {
       this.row = r; 
    }
    
    public void setCol(int c)
    {
        this.col = c;
    }
    
    public String toString() 
    {
        String s = "";
        for (int r=0; r<m.length; r++) {
            for (int c=0; c<m[0].length; c++) {
                s += this.m[r][c] + " ";
            }
            s += '\n';
        }
        return s;
    }        
}

