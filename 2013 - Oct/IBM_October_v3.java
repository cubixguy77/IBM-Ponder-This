import java.util.*;

public class IBM_October_v3
{
  
  public static int size = 8;
  public static int[][] board;
  public static int[] cols;
  public static int[][] bestboard;
  public static int bestscore = 0;
  public static int[][] perms;
  public static int[] sizes;
  
  public static int[] colCount; 
  public Diagonal_Manager diagManager;
  
  
  public IBM_October_v3()
  {
    run();
  }
  
 
  public void buildBoardSingleRow(int row, int perm)
  {
    for (int col=0; col<8; col++)
    {
      diagManager.update(row, col, board[row][col], perms[perm][col]);
      colCount[col] += (perms[perm][col] - board[row][col]);
    }
    board[row] = perms[perm];
    
    getScore(true, true);
  }
  
  
  
  public void runAll()
  {
    //BigInteger bi = BigInteger.valueOf(0);
         
    long count = 0;          
           
    for (int zero=0; zero<70; zero++)
    {
      for (int one=0; one<70; one++)
      {
        for (int two=0; two<70; two++)
        {
          for (int three=0; three<70; three++)
          {
            for (int five=0; five<70; five++)
            {
              for (int six=0; six<70; six++)
              {
                for (int seven=0; seven<70; seven++)
                {
                  for (int eight=0; eight<70; eight++)
                  {
                    buildBoardSingleRow(7, eight);
                    if (count % 70L == 0)
                      buildBoardSingleRow(6, seven);
                    if (count % 4900L == 0)
                      buildBoardSingleRow(5, six);
                    if (count % 343000L == 0)
                      buildBoardSingleRow(4, five);
                    if (count % 24010000L == 0)
                      buildBoardSingleRow(3, three);
                    if (count % 1680700000L == 0)
                      buildBoardSingleRow(2, two);
                    if (count % 117649000000L == 0)
                      buildBoardSingleRow(1, one);
                    if (count % 8235430000000L == 0)
                      buildBoardSingleRow(0, zero);
             
                    count++;
                    
                    if (count % 10000000L == 0)
                    {
                      System.out.println(zero + " " + one + " " + two + " " + three + " " + five + " " + six + " " + seven + " " + eight);
                    }                    
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  
  public int getScore(Boolean validateBoard, Boolean printScore)
  {
    if (validateBoard && !isBoardValid())
    {
      //System.out.println("Invalid Board");
      return -1;
    }
    
    int score = diagManager.getScore();
    
    if (score > bestscore)
    {
      bestscore = score;
      bestboard = board;
      if (printScore)
      {
        print();
        System.out.println("Score: " + score);
        diagManager.printScores();
      }
    }    
    return score;
  }
  
  
   public static int[] getEightBits(int i)
  {
    String string = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
    return new int[] {Character.getNumericValue(string.charAt(0)), Character.getNumericValue(string.charAt(1)), Character.getNumericValue(string.charAt(2)), Character.getNumericValue(string.charAt(3)), Character.getNumericValue(string.charAt(4)), Character.getNumericValue(string.charAt(5)), Character.getNumericValue(string.charAt(6)), Character.getNumericValue(string.charAt(7)) };
  }
  
  public static int countBits(int[] arr)
  {
    int result = 0;
    for (int i=0; i<arr.length; i++)
    {
      result += arr[i] * 1;
    }
    return result;
  }
  
  
  
  public static void print()
  {
    for (int row=0; row<size; row++)
    {
      for (int col=0; col<size; col++)
      {
        if (board[row][col] == 0)
          System.out.print("W");
        else
          System.out.print("B");
          
       // System.out.print(board[row][col] + " ");
      }
      System.out.println("");
    }
  }
  
  
  
  public static Boolean isBoardValid()
  {
    return colsValid();
  }
  
  public static Boolean colsValid()
  {
    Set<Integer> s = new HashSet<Integer>();
    for (int i=0; i<8; i++)
      s.add(colCount[i]);
    return s.size() == 8;
  } 
  
    
  
  
  public void initperms()
  {
    perms = new int[70][8];
    board = new int[size][size];
    int count = 0;
    
    diagManager = new Diagonal_Manager();
    colCount = new int[8];
    
    for (int i=0; i<256; i++)
    {
      int[] digits = getEightBits(i);
      int numOnes = countBits(digits);
      if (numOnes == 4)
      {
        perms[count++] = digits;
      }
    }
  }
  
  public void run()
  {
    initperms();
    runAll();
  }
  
 
}