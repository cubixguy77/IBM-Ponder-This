
public class State
{
  public int a;
  public int b;
  public int c;
  public int round;
  
  public State(int a, int b, int c, int round)
  {
    this.a = a;
    this.b = b;
    this.c = c;
    this.round = round;
  }
  
  public Boolean finished()
  {
    return a == b || a == c || b == c;
  }
  
  public void print()
  {
    System.out.println("*** Round " + round + " ***");
    System.out.println("a: " + a);
    System.out.println("b: " + b);
    System.out.println("c: " + c);
    System.out.println("********************");
    System.out.println("");
  }
}