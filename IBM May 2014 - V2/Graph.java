public class Graph
{
  
  private Trial trial;
  private double[][] collisions;
  private int n;
  private Boolean valid = false;
  private Boolean[] live;
  private int numLive;
  
 public Graph(Trial trial)
 {
    this.trial = trial;
    this.n = trial.getTrialSize();
    collisions = new double[n][n];
    valid = loadCollisions();
 }
  
 public Boolean loadCollisions()
 {
   Boolean All_Zero = true;
   live = new Boolean[n];
   for (int i=0; i<n; i++)
     live[i] = true;
   numLive = n;
   
   for (int i=0; i<n; i++)
   {
     All_Zero = true;
     for (int j=0; j<n; j++)
     {       
       double collisiontime = getCollisionTime(i, j);
       if (collisiontime > 0)
         All_Zero = false;
       
       collisions[i][j] = collisiontime;       
     }
     if (All_Zero == true && i > 0)
     {
      // System.out.println("*******Rejecting for All Zeros at row " + (i+1));
       //print();
       return false;
     }
   }
   return true;
 }
 
 public Boolean RunTrial()
 {
   if (!valid)
     return false;
   
   for (int i = 0; i < (n/2); i++) // collision counter
   {
     double lowest_time = 0.0;
     int lowest_index = 0;
     int target_index = 0;
     for (int j = 0; j < n; j++) // bullet being fired
     {       
       SomeData col = getNextCollisionTime(j);
    //   System.out.println("Bullet " + (j+1) + " collides with " + (getNextCollisionTime(j).index+1) + " at time " + getNextCollisionTime(j).time);
       double this_time = col.time;       
       if (this_time == 0.0 && live[j] && j > 0)
       {
         //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$Rejecting bullet " + (j+1) + " for not hitting anything after it after " + (i+1) + " collisions.");
         //print();
         return false;
       }
       
       if ((lowest_time == 0.0 && this_time > 0) || (this_time < lowest_time && this_time > 0))
       {
         lowest_time = this_time;
         lowest_index = j;
         target_index = col.index;
       }
     }
    // System.out.println(lowest_time + " " + lowest_index + " " + target_index);
     if (lowest_time == 0.0)
     {
    //   System.out.println("No More collisions after " + i  + " collisions.");
       return false;
     }
     else
     {
       MakeCollision(lowest_index, target_index); // i + 1 successful collisions now occurred
      // System.out.println();
      // System.out.println("Collision " + (i + 1) + ": bullet " + (lowest_index+1) + " collides with bullet " + (target_index+1) + " at time " + lowest_time);
    //   print();
     }
   }
   valid = true;
 //  System.out.println("Valid Config!!!!!!!!!!!!!!!!");
  // print();
   return true;   
 }
 
 public void MakeCollision(int i, int j)
 {
   for (int k=0; k<n; k++)
   {
     collisions[i][k] = 0.0;
     collisions[j][k] = 0.0;
     collisions[k][j] = 0.0;
   }
   live[i] = false;
   live[j] = false;
   numLive -= 2;
 }
 
 
 public Boolean isValidTrial()
 {
   return valid;
 }
 
 
 public double getCollisionTime(int i, int j)
 {
   if (i <= j)
     return 0.0;
   
   double i_speed = trial.getSpeed(i);
   double j_speed = trial.getSpeed(j);
   
   if (i_speed <= j_speed) // they can never meet
     return 0.0;
   
   double j_dist = j_speed * (i - j);
   double speed_delta =  i_speed - j_speed;
   double collision_time = j_dist / speed_delta;
   
   return collision_time + (double) i;
 }
 
 
 
 
 
 
 private SomeData getNextCollisionTime(int i)
 {
   double time = 0;
   int j = i-1;
   SomeData zero = new SomeData(0.0, 0); 
   
   if (i == 0)
     return zero;
   
   while (j >= 0)
   {
     if (collisions[i][j] > 0)
       return new SomeData(collisions[i][j], j);
     else
       j--;
   }
   return zero;
 }
 
 
 private class SomeData 
 {
    public double time;
    public int index;
    public SomeData(double time, int index)
    {
      this.time = time;
      this.index = index;
    }
}
 
 
 
 
 
 
 
 public void print()
 {
  
   //System.out.println("**GRAPH valid: " + valid + "**");
   for (int i=0; i<n; i++)
   {
     for (int j=0; j<n; j++)
     {
       System.out.print(collisions[i][j] + " ");
     }
     System.out.println();
   }
  System.out.println();
  System.out.println();
  System.out.println();
   /*
   for (int i=0; i<n; i++)
   {
     for (int j=0; j<n; j++)
     {
       if (j > i && trial.getSpeed(i) > trial.getSpeed(j) && collisions[i][j] == 0)
         System.out.println("Collision Time Error: " + i + " " + j);
     }     
   }
   */
   
   
  // for (int i=0; i<n; i++)
 //    System.out.println("Collision time for bullet " + i + ": " + getNextCollisionTime(i).time);
   
   
   System.out.println();
   System.out.println();
   System.out.println("**************************************************************************************************************************************************************");
   System.out.println();
   System.out.println();
 }
 
 
 
 
 
 
}