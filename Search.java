import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Search
{
    // found path counter
    public static List<State> states_found = new ArrayList<State>();
    
    public static boolean solve(State state)
    {
        // get current position row, col
        int r = state.getRow();
        int c = state.getCol();
        
        if ((state.get(r, c) == 4)) { // finaly found
            state.set(r, c, 8); 
            state.addPath(r, c, "end found", 0);
            state.addTraveledCost(1, 0);
            // add found current state on states found list;
            Search.states_found.add(state);
            if(state.getStateDebug())
            {
                System.out.println("Path found!");
                System.out.println(state);
                System.out.println("Cost path: " + state.getCost());
                System.out.println("Traveled path: " + state.getTraveled() + "Km");
                System.out.println(state.getDebugPath());
                System.out.println("---------------------------------------------\n");
            }
        }
        
       /* based on the current partial state, gerates a new states
        * seach on north, south, west and east 
        */
        
        if (state.get(r - 1, c) == 0 || state.get(r - 1, c) == 4 || state.get(r - 1, c) == 9) 
        {
            // There is an unexplorated path north
            State n = new State(state); 
            if (n.get(r, c) == 9) { // mine
                n.set(r, c, 7);
                n.addPath(r, c, "mine down", 4);
                n.addTraveledCost(1, 4);
            } else {
                n.set(r, c, 3); 
                n.addPath(r, c, "free pass", 1);
                n.addTraveledCost(1, 1);
            }   
            n.setRow(r - 1);
            
            if (solve(n) == true) {
                return true;
            }
        }
        if (state.get(r + 1, c) == 0 || state.get(r + 1, c) == 4 || state.get(r + 1, c) == 9) 
        {
            // There is an unexplorated path south
            State s = new State(state); 
            if (s.get(r, c) == 9) { // mine
                s.set(r, c, 7);
                s.addPath(r, c, "mine down", 4);
                s.addTraveledCost(1, 4);
            } else {
                s.set(r, c, 3); 
                s.addPath(r, c, "free pass", 1);
                s.addTraveledCost(1, 1);
            }
            s.setRow(r + 1);
                
            if (solve(s) == true)
            {
                return true;
            }
        }
        if (state.get(r, c - 1) == 0 || state.get(r, c - 1) == 4 || state.get(r, c - 1) == 9)
        {
            // There is an unexplorated path west
            State o = new State(state); 
            if (o.get(r, c) == 9) { // mine found
                o.set(r, c, 7);
                o.addPath(r, c, "mine down", 4);
                o.addTraveledCost(1, 4);
            } else {
                o.set(r, c, 3); 
                o.addPath(r, c, "free pass", 1);
                o.addTraveledCost(1, 1);
            }
            o.setCol(c - 1);
            if (solve(o) == true) 
            { 
                return true; 
            }
        }
        if (state.get(r, c + 1) == 0 || state.get(r, c + 1) == 4 || state.get(r, c + 1) == 9)
        {
            // There is an unexplored path east
            State l = new State(state); 
            if (l.get(r, c) == 9) { // mine
                l.set(r, c, 7);
                l.addPath(r, c, "mine down", 4);
                l.addTraveledCost(1, 4);
            } else { 
                l.set(r, c, 3); 
                l.addPath(r, c, "free pass", 1);
                l.addTraveledCost(1, 1);
            }
            l.setCol(c + 1);
            
            if (solve(l) == true) 
            {
                return true; 
            }
        }
        return false; // all path fail, return false
    }
    
    public static void main(String[] args)
    {
        // get fisrt state and search recursive path
        State first = new State();
        //first.enableDebug();
        solve(first);
        
        System.out.println("We found "+Search.states_found.size()+" path(s)! For view, enable debug!\n");
        System.out.println(new FindBest(states_found));
        
    }
}

