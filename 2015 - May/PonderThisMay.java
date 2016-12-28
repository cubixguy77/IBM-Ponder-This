import java.util.ArrayList;

public class PonderThisMay
{
  private static int maxRound = 10;
  
  public static void main(String[] args)
  {
   
  //  RunTest();
    
    if (true)
    {
      for (int a=1; a<=253; a++)
      {
        for (int b=a+1; b<=254; b++)
        {
          for (int c=b+1; c<=255; c++)
          {
            //StartGame(a, b, c);
            State state = new State(a, b, c, 0);
            if (!state.finished())
            {
              if (RunFromNode(state))
                state.print();
            }
            
          }
        }
      }
    }
  }
  
  public static void RunTest()
  {
    /*
    int a = 209;
    int b = 217;
    int c = 225;
    */
    int a = 1;
    int b = 4;
    int c = 6;
    int round = 0;
    State state = new State(a, b, c, round);
    
    System.out.println(RunFromNode(state));
  }
  

  
  public static Boolean RunFromNode(State state)
  {
    //state.print();
    
    if (state.finished())
    {
     // state.print();
      return false;
    }
    
    if (state.round >= maxRound)
      return true;
    
    ArrayList<State> states = StateCollection.getNextRoundStates(state);
    
    //StateCollection.print(states);
    
    if (StateCollection.finished(states))
    {
     // StateCollection.print(states);
      return false;
    }
    
    for (State childState : states)
    {
      if (!RunFromNode(childState))
        return false;
    }
    
    return true;
  }
}