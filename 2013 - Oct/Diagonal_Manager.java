import java.util.*;

public class Diagonal_Manager 
{
  
  public Diagonal[] diags;
  private int score = 0;
  private int[][] indexer1;
  private int[][] indexer2;
  
  
  public Diagonal_Manager()
  {
    diags = new Diagonal[30];
    for (int i=0; i<30; i++)
    {
      diags[i] = new Diagonal(i);
    }       
    initIndexerOne();
    initIndexerTwo();
  }
  
  // down and to the right
  private void initIndexerOne()
  {
    indexer1 = new int[][] 
    {
      {7, 8, 9, 10, 11, 12, 13, 14},
      {6, 7, 8, 9, 10, 11, 12, 13},
      {5, 6, 7, 8, 9, 10, 11, 12},
      {4, 5, 6, 7, 8, 9, 10, 11},
      {3, 4, 5, 6, 7, 8, 9, 10},
      {2, 3, 4, 5, 6, 7, 8, 9},
      {1, 2, 3, 4, 5, 6, 7, 8},
      {0, 1, 2, 3, 4, 5, 6, 7}
    };           
  }
  
  // down and to the left
  private void initIndexerTwo()
  {
    indexer2 = new int[][] 
    {
      {29, 28, 27, 26, 25, 24, 23, 22},
      {28, 27, 26, 25, 24, 23, 22, 21},
      {27, 26, 25, 24, 23, 22, 21, 20},
      {26, 25, 24, 23, 22, 21, 20, 19},
      {25, 24, 23, 22, 21, 20, 19, 18},
      {24, 23, 22, 21, 20, 19, 18, 17},
      {23, 22, 21, 20, 19, 18, 17, 16},
      {22, 21, 20, 19, 18, 17, 16, 15}
    };             
  }
  
  
  public int getIndexOne(int row, int col)
  {
    return indexer1[row][col];
  }
  
  public int getIndexTwo(int row, int col)
  {
    return indexer2[row][col];
  }
  
  
  public void update(int row, int col, int before, int after)
  {
    int index1 = getIndexOne(row, col);
    int index2 = getIndexTwo(row, col);
    if (after != before)
    {
      diags[index1].update(after - before); // before 0, after 1: (1 - 0) = 1 ->  implies flip to black
      diags[index2].update(after - before);
    }
  }
   
  public int getScore()
  {
    Set<Double> s = new HashSet<Double>();
    //System.out.println("***");
    for (int i=0; i<30; i++)
    {
      s.add(diags[i].getPercentage());
      //System.out.println(diags[i].getPercentage());
    }
    score = s.size();
    //System.out.println("***");
    return s.size();
  }
  
  
  public void printScores()
  {
    System.out.println("*****Top******");
    for (int i=0; i<30; i++)
    {
      System.out.println(i + ": " + diags[i].getPercentage());
    }
    System.out.println("*****Bottom******\n");
  }
  
  
}