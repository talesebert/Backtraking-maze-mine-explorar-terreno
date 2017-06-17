import java.util.List;

/**
 *
 * @author Tales Igor Ebert
 * Create on 2017-06-16
 */
public class FindBest {
    private State best_state;
    FindBest(List<State> states_found) {
        State best_state = Search.states_found.get(0);
        for (int i = 0; i < Search.states_found.size(); i++) {
            if (states_found.get(i).getCost() < best_state.getCost())
                this.best_state = Search.states_found.get(i);
        }
        System.out.print(this.best_state);
    }
    
    public String toString()
    { 
        return "The best path :) with only: cost " + this.best_state.getCost() +
               " and travaled " + this.best_state.getTraveled() + "Km";
        
    }
    
}