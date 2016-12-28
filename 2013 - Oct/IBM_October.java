import java.util.*;


public class IBM_October
{
  
  public static int size = 8;
  public static int[][] board;
  public static int[] cols;
  public static int[][] bestboard;
  public static int bestscore = 0;
  public static int[][][] perms;
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
  
  public static void initperms()
  {
    perms = new int[size+1][56][size];
    sizes = new int[] {1,8,28,56,0,56,28,8,1};
    board = new int[size][size];
    int[] count = new int[size+1];
    for (int i=0; i<256; i++)
    {
      int[] digits = getEightBits(i);
      int numOnes = countBits(digits);
      if (numOnes != 4)
      {
        perms[numOnes][count[numOnes]] = digits;
        count[numOnes]++;
      }
    }
  }
  
  public static void buildBoard(int a, int one, int b, int two, int c, int three, int d, int four, int e, int five, int f, int six, int g, int seven, int h, int eight)
  {    
    for (int row=0; row<size; row++)
    {
      board[row][0] = perms[a][one][row];
    }
    for (int row=0; row<size; row++)
    {
      board[row][1] = perms[b][two][row];
    }
    for (int row=0; row<size; row++)
    {
      board[row][2] = perms[c][three][row];
    }
    for (int row=0; row<size; row++)
    {
      board[row][3] = perms[d][four][row];
    }
    for (int row=0; row<size; row++)
    {
      board[row][4] = perms[e][five][row];
    }
    for (int row=0; row<size; row++)
    {
      board[row][5] = perms[f][six][row];
    }
    for (int row=0; row<size; row++)
    {
      board[row][6] = perms[g][seven][row];
    }
    for (int row=0; row<size; row++)
    {
      board[row][7] = perms[h][eight][row];
    }
    
    getScore(true, true);
  }
  
  
  public static void run()
  {
    initperms();
    permutation("01235678");
  }
  
  public static void permutation(String str) 
  { 
    permutation("", str); 
  }
  
  public static void permutation(String prefix, String s) 
  {
    int n = s.length();
    if (n == 0) 
      runAll(Character.getNumericValue(prefix.charAt(0)),  Character.getNumericValue(prefix.charAt(1)), Character.getNumericValue(prefix.charAt(2)), Character.getNumericValue(prefix.charAt(3)), Character.getNumericValue(prefix.charAt(4)), Character.getNumericValue(prefix.charAt(5)), Character.getNumericValue(prefix.charAt(6)), Character.getNumericValue(prefix.charAt(7)));
    else 
    {
      for (int i = 0; i < n; i++)
        permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
    }
  }
  
  public static void runAll(int a, int b, int c, int d, int e, int f, int g, int h)
  {
    for (int zero=0; zero<sizes[a]; zero++)
    {
      for (int one=0; one<sizes[b]; one++)
      {
        for (int two=0; two<sizes[c]; two++)
        {
          for (int three=0; three<sizes[d]; three++)
          {
            for (int five=0; five<sizes[e]; five++)
            {
              for (int six=0; six<sizes[f]; six++)
              {
                for (int seven=0; seven<sizes[g]; seven++)
                {
                  for (int eight=0; eight<sizes[h]; eight++)
                  {
                    buildBoard(a, zero, b, one, c, two, d, three, e, five, f, six, g, seven, h, eight);
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
    return rowsValid();// && colsValid();
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
      if (col == 0)
      {
        used[numBlack] = 1;
      }
      else 
      {
        if (used[numBlack] > 0 || !valid) 
        {
          valid = false;
          break;
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
        if (numBlackCurrent != numBlackPrevious) 
        {
          return false;
        }
      }
    }
    return valid;
  }
  
  
  
  public static void init()
  {
    board = new int[][] {{0,1,1,0},{1,0,1,0},{1,0,1,0},{1,0,1,0}};
    cols = new int[] {3,1,4,0};    
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
  
  
  public static void doSwap(int row_1, int col_1, int row_2, int col_2)
  {
    if (board[row_1][col_1] != board[row_2][col_2])
    {
      int temp = board[row_2][col_2];
      board[row_2][col_2] = board[row_1][col_1];
      board[row_1][col_1] = temp;
      cols[col_1] += board[row_1][col_1] * 1;
      cols[col_1] += board[row_1][col_1] * 1;
      if (temp == 1)
      {
        cols[col_1]++;
        cols[col_2]--;
      }
      else
      {
        cols[col_1]--;
        cols[col_2]++;
      }
    }
  }
  
  
  
  public static void main(String[] args)
  {
    /*init();    
    print();
    getScore(true, true);
    
    doSwap(0,0, 0,2);
    print();
    getScore(true, true);*/
    run();
  }  
}