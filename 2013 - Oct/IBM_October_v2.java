import java.util.*;


public class IBM_October_v2
{
  
  public static int size = 8;
  public static int[][] board;
  public static int[] cols;
  public static int[][] bestboard;
  public static int bestscore = 0;
  public static int[][] perms;
  public static int[] sizes;
  
  
  
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
  
  
  
  
  public static void buildBoard(int a, int b, int c, int d, int e, int f, int g, int h)
  {   
    board[0] = perms[a];
    board[1] = perms[b];
    board[2] = perms[c];
    board[3] = perms[d];
    board[4] = perms[e];
    board[5] = perms[f];
    board[6] = perms[g];
    board[7] = perms[h];
        
    getScore(true, true);
  }
  
  
  
  
  
  public static void runAll()
  {
    int count = 0;
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
                    buildBoard(zero, one, two, three, five, six, seven, eight);
                    count++;
                    if (count % 100000000 == 0)
                    {
                      System.out.println("Count: " + count);
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

  
  public static int getScore(Boolean validateBoard, Boolean printScore)
  {
    if (validateBoard && !isBoardValid())
    {
      //System.out.println("Invalid Board");
      return -1;
    }
    
    Set<Double> s = new HashSet<Double>();
    
    for (int i=0; i<size; i++)
    {
      s.add(numBlackDiagonal(i, 0, (size - 1), (size - 1) - i, 1) / (4 - i));
    }
    for (int i=1; i<size; i++)
    {
      s.add(numBlackDiagonal(0, i, (size - 1)-i, (size - 1), 1) / (4 - i));
    }
  
    for (int i=0; i<size; i++)
    {
      s.add(numBlackDiagonal(0, (size - i - 1), (size - i - 1), 0, -1) / (4 - i));
    }
    
    for (int i=1; i<size; i++)
    {
      s.add(numBlackDiagonal(i, (size - 1), (size - 1), i, -1) / (4 - i));
    }
    
    int score = s.size();
    if (score > bestscore)
    {
      bestscore = score;
      bestboard = board;
      if (printScore)
      {
        print();
        System.out.println("Score: " + s.size() + "\n");      
      }
    }    
    return score;
  }
  
  
  
  public static void print()
  {
    for (int row=0; row<size; row++)
    {
      for (int col=0; col<size; col++)
      {
        System.out.print(board[row][col] + " ");
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
    Boolean valid = true;
    int[] used = new int[size+1];
    int numBlack = 0;
    for (int col=0; col<size; col++)
    {
      numBlack = 0;
      for (int row=0; row<size; row++)
      {
        numBlack += board[row][col] * 1;
      }
      if (numBlack == 4)
        return false;
      
      if (col == 0)
      {
        used[numBlack] = 1;
      }
      else 
      {
        if (used[numBlack] > 0) 
        {
          return false;
        }
        else
          used[numBlack] = 1;
      }
    }
    return valid;
  }
    
  
  public static Boolean rowsValid()
  {
    Boolean valid = true;
    int numBlackCurrent = 0;
    int numBlackPrevious = 0;
    for (int row=0; row<size; row++)
    {
      numBlackCurrent = 0;
      for (int col=0; col<size; col++)
      {
        numBlackCurrent += board[row][col] * 1;
      }
      if (row == 0)
      {
        numBlackPrevious = numBlackCurrent;
      }
      else 
      {
        if (numBlackCurrent != numBlackPrevious || !valid) 
        {
          return false;
        }
      }
    }
    return valid;
  }
  
  
  public static double numBlackDiagonal(int row_1, int col_1, int row_2, int col_2, int vert_dir)
  {
    int numBlack = 0;
    for (int i=0; i<=Math.abs(row_2 - row_1); i++)
    {
      numBlack += 1 * board[row_1][col_1 + (i*vert_dir)];
      //System.out.println(row_1 + i + ", " + (col_1 + (i*vert_dir)));
    }
    return numBlack;
  }
  
  
  public static void initperms()
  {
    perms = new int[70][8];
    board = new int[size][size];
    int count = 0;
    
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
  
  public static void run()
  {
    initperms();
    runAll();
  }
  
  
  public static void main(String[] args)
  {
    run();
  }  
}