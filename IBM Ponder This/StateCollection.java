import java.util.ArrayList;

public class StateCollection
{  
  public static ArrayList<State> getNextRoundStates(State state)
  {
    ArrayList<State> states = new ArrayList<State>();
    if (state.finished())
    {
      return states;
    }
    
    int a = state.a;
    int b = state.b;
    int c = state.c;
    
    // choose a
    states.add(new State(a, 
                         b < c ? 2*b : b - c, 
                         b < c ? c - b : 2*c,    
                         state.round+1));
    
    // choose b
    states.add(new State(a < c ? 2*a : a - c, 
                         b, 
                         a < c ? c - a : 2*c,    
                         state.round+1));
    
    // choose c
    states.add(new State(a < b ? 2*a : a-b, 
                         a < b ? b-a : 2*b,
                         c,    
                         state.round+1));
    
    return states;
  }
  
  public static Boolean finished(ArrayList<State> states)
  {
    for (State state : states)
    {
      if (state.finished())
        return true;
    }
    
    return false;
  }  
  
  public static void print(ArrayList<State> states)
  {
    for (State state : states)
    {
      state.print();
    }
  }
}