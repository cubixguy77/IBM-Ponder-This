import java.util.Random;


public class Trial
{
 
  private double[] trial;
  private int n; // number of builets
  private static Random random = new Random();
  
 public Trial(int n)
 {
   this.n = n;
   trial = new double[n];
   trial = this.runTrial(trial);
 }
  
 
 // Takes a blank trial, fills each slot in the array with double from 0 to 1
 public double[] runTrial(double[] trial)
 {
   for (int i = 0; i < n; i++)
   {
     //Random r = new Random();
    // double zeroToOne = r.nextInt(1001) / 1000;
     double zeroToOne = randomInRange(0.0, 1.0);
     trial[i] = zeroToOne;
   }
   return trial;
 }
  
 public double getSpeed(int i)
 {
   return trial[i];
 }
  
  public int getTrialSize()
  {
    return n;
  }
  
  public Boolean trialIsValid()
  {
    return Mapper.ValidTrial(this);
  }
  
  
  public void print()
  {
    for (int i = 0; i < n; i++)
      System.out.println(trial[i]);
    System.out.println();
  }
  
  
  
  public static double randomInRange(double min, double max) 
  {
    double range = max - min;
    double scaled = random.nextDouble() * range;
    double shifted = scaled + min;
    return shifted; // == (rand.nextDouble() * (max-min)) + min;
  }
  
  
  
  
}