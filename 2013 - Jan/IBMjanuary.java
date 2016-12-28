
public class IBMjanuary {
  
  private static int numRows = 6;
  private static int stringLen = 6;
  private static int numCols = ((stringLen * (stringLen - 1) * (stringLen - 2)) / 6);
  private static String[] classArray; 
  private static char[] charArray;
  
  private static int numMethods = 8;
  private static String[] permTypes;
    
  
  public static void load()
  {
    permTypes = new String[numMethods];
    permTypes[0] = "swap";
    permTypes[1] = "reverseWithinHalves";
    permTypes[2] = "swapHalves";
    permTypes[3] = "reverse";
    permTypes[4] = "oddswap";
    permTypes[5] = "swapThirds_acb";
    permTypes[6] = "swapThirds_bca";
    permTypes[7] = "swapThirds_cab";
    
    loadCharArray();
    loadClassArray();    
  }
  
  public static void loadCharArray() {
    charArray = new char[19];
    int i=0;
    for (char c='a'; c<'s'; c++)
      charArray[i++] = c;
  }
  
  public static void print(int[][] array)
  {
    for (int row=0; row<numRows; row++) {
      for (int col=0; col<numCols; col++) {
        if (array[row][col] == 0)
          System.out.print(" " + "|");
        else
          System.out.print(array[row][col] + "|");
      }
      System.out.println();
      for (int colb=0; colb<numCols; colb++)
        System.out.print("--");
      System.out.println();
    }
    System.out.println("\n");
  }
  
  
  
  public static String getStartPerm() {
    String startPer = "";
    for (int i=0; i<stringLen; i++)
    {
      startPer += Character.toString(getChar(i));
    }
    //return startPer;
    return "fedcba";
  }
  
  public static int mint(char c)  {   return Character.getNumericValue(c);  }
  
  public static int getRankByThreeCharacterCombo(char a, char b, char c)
  {
    if (a < b && b < c) return 0; // abc
    if (a < b && b > c && c > a) return 1; // acb
    if (a > b && b < c && a < c) return 2; // bac
    if (a > b && b < c && a > c) return 3; // bca
    if (a < b && b > c && c < a) return 4; // cab
    if (a > b && b > c) return 5; // cba
    return -1;
  }
  
  public static int getClassByThreeCharacterCombo(char a, char b, char c)
  {
    for (int i=0; i<classArray.length; i++) {
      if (classArray[i].indexOf(a) != -1 && classArray[i].indexOf(b) != -1 && classArray[i].indexOf(c) != -1)
        return i;
    }
    return -1;
  }
  
  public static int[][] getUpdatedArrayByPermutation(String perm, int[][] array)
  {
    for (int a=0; a<stringLen-2; a++) {
      for (int b=a+1; b<stringLen-1; b++) {
        for (int c=b+1; c<stringLen;   c++) {
          char x = perm.charAt(a);
          char y = perm.charAt(b);
          char z = perm.charAt(c);
          int row = getRankByThreeCharacterCombo(x, y, z);
          int col = getClassByThreeCharacterCombo(x, y, z);
          array[row][col]++;
        }
      }
    }
    return array;
  }
  
  public static char getChar(int i)  {    return charArray[i];  }
  
  public static void loadClassArray()
  {
    classArray = new String[numCols];
    int i=0;
       
    for (int a=0; a<stringLen-2; a++) {
      for (int b=a+1; b<stringLen-1; b++) {
        for (int c=b+1; c<stringLen;   c++) {
          String s = Character.toString(getChar(a)) + Character.toString(getChar(b)) + Character.toString(getChar(c));
          classArray[i] = s;
          i++;
        }
      }
    }
  }
  
  public static String mreplace(char c, int i, String s)
  {
    return s.substring(0,i) + c + s.substring(i+1);
  }
  
  public static String permuteString(String s, String option) 
  {
    String newString = "";
    
    
    if (option.equals("reverse")) 
    {
      for (int i=stringLen-1; i>=0; i--)
        newString += s.charAt(i);
    }
    
    else if(option.equals("nothing"))
      return s;
    
    
    
    else if(option.equals("reverseWithinHalves"))
    {
      int half=stringLen/2;
      String firsthalf="";
      String secondhalf="";
      for (int i=half-1; i>=0; i--)
      {
        firsthalf += s.charAt(i);
        secondhalf += s.charAt(i + half);
      }
      newString = firsthalf + secondhalf;
    }
    
    
    else if(option.equals("swapHalves"))
    {
      newString = s;
      int half=stringLen/2;
      for (int i=0; i<half; i++)
      {
        char a = s.charAt(i);
        char b = s.charAt(half+i);
        char temp = a;
        newString = mreplace(b, i, newString);
        newString = mreplace(temp, half+i, newString);
      }
    }
              
    
    else if(option.equals("swap"))
    {
      newString = s;
      for (int i=0; i<stringLen; i+=2)
      {
        char a = s.charAt(i);
        char b = s.charAt(i+1);
        char temp = a;
        newString = mreplace(b, i, newString);
        newString = mreplace(temp, i+1, newString);
      }
    }
    
    else if(option.equals("oddswap"))
    {
      newString = s;
      for (int i=1; i<stringLen-1; i+=2)
      {
        char a = s.charAt(i);
        char b = s.charAt(i+1);
        char temp = a;
        newString = mreplace(b, i, newString);
        newString = mreplace(temp, i+1, newString);
      }
      char a = s.charAt(0);
      char b = s.charAt(stringLen - 1);
      char temp = a;
      newString = mreplace(b, 0, newString);
      newString = mreplace(temp, stringLen - 1, newString);
    }
    
    
    
    else if(option.contains("swapThirds"))
    {
      newString = swapThirds(option.substring(11), s);
    }     

    
  //   System.out.println("Permutation Type: " + option);
  //   System.out.println("Before: " + s);
  //   System.out.println("After: " + newString);
    return newString;
  }
  
  public static String swapThirds(String type, String s)
  {
    int t = stringLen / 3;
    String a = s.substring(0  , t        );
    String b = s.substring(t  , 2 * t    );
    String c = s.substring(2*t);
    
    String newString = "";
    if (type.equals("acb"))
    {
      newString = a + c + b;
    }
    else if (type.equals("bca"))
    {
      newString = b + c + a;
    }
    else if (type.equals("cab"))
    {
      newString = c + a + b;
    }
    return newString;
  }
  
  
  public static int runSimByString(String order) 
  {
    String s = getStartPerm();
    int[][] array = new int[numRows][numCols];

    int count = 0;
    
    System.out.println("============================================================================");
    for (int i=0; i<order.length(); i++)
    {
      s = permuteString(s, permTypes[Character.getNumericValue(order.charAt(i))]);
      array = getUpdatedArrayByPermutation(s, array);
      System.out.println("Permutation " + (i) + ": " + s);
      print(array);
    }
    
    
    System.out.println("Ordering: " + order);
    count = count(array, true);
    System.out.println();
    
    return count;
  }
  
  
  public static int count(int[][] array, boolean debugCount)
  {
    int count = 0;
    int countByRow;
    int totalCountByRow;
    for (int row=0; row<numRows; row++) 
    {
      countByRow = 0;
      totalCountByRow = 0;
      for (int col=0; col<numCols; col++) 
      {
        if (array[row][col] > 0) 
        {
          count++;
          countByRow++;
        }
        totalCountByRow += array[row][col];
      }
      if (debugCount) 
      {
        double redundancy = (double) totalCountByRow / countByRow;
        if (redundancy > 3)
          System.out.println("Count on row (" + (row+1) + ") = " + countByRow + "    ->    Redundancy factor: " + redundancy + "         ***********************");
        else if (redundancy > 2.5)
          System.out.println("Count on row (" + (row+1) + ") = " + countByRow + "    ->    Redundancy factor: " + redundancy + "         +++++++++++++++++++++++");
        else
          System.out.println("Count on row (" + (row+1) + ") = " + countByRow + "    ->    Redundancy factor: " + redundancy);
      }
    }
    if (debugCount) {
      System.out.println("Final Count: " + count);
    }
    return count;
  }
  
  
  
  public static void start()
  {
    int maxCount = 0;
    String maxOrder = "";
        /*
runSimByString("0121513734521");
runSimByString("0121513734531");
runSimByString("0131513734521");
runSimByString("0131513734531");
runSimByString("0212513734521");
runSimByString("0212513734531");
runSimByString("0232513734521");
runSimByString("0232513734531");
runSimByString("0313513734521");
runSimByString("0313513734531");
runSimByString("0323513734521");
runSimByString("0323513734531");
runSimByString("1121513734521");
runSimByString("1121513734531");
runSimByString("1131513734521");
runSimByString("1131513734531");
runSimByString("1212513734521");
runSimByString("1212513734531");
runSimByString("1232513734521");
runSimByString("1232513734531");
runSimByString("1313513734521");
runSimByString("1313513734531");
runSimByString("1323513734521");
runSimByString("1323513734531");
runSimByString("2121513734521");
runSimByString("2121513734531");
runSimByString("2131513734521");
runSimByString("2131513734531");
runSimByString("2212513734521");
runSimByString("2212513734531");
runSimByString("2232513734521");
runSimByString("2232513734531");
runSimByString("2313513734521");
runSimByString("2313513734531");
runSimByString("2323513734521");
runSimByString("2323513734531");
runSimByString("3121513734521");
runSimByString("3121513734531");
runSimByString("3131513734521");
runSimByString("3131513734531");
runSimByString("3212513734521");
runSimByString("3212513734531");
runSimByString("3232513734521");
runSimByString("3232513734531");
runSimByString("3313513734521");
runSimByString("3313513734531");
runSimByString("3323513734521");
runSimByString("3323513734531");
runSimByString("4121513734521");
runSimByString("4121513734531");
runSimByString("4131513734521");
runSimByString("4131513734531");
runSimByString("4212513734521");
runSimByString("4212513734531");
runSimByString("4232513734521");
runSimByString("4232513734531");
runSimByString("4313513734521");
runSimByString("4313513734531");
runSimByString("4323513734521");
runSimByString("4323513734531");
runSimByString("5121513734521");
runSimByString("5121513734531");
runSimByString("5131513734521");
runSimByString("5131513734531");
runSimByString("5212513734521");
runSimByString("5212513734531");
runSimByString("5232513734521");
runSimByString("5232513734531");
runSimByString("5313513734521");
runSimByString("5313513734531");
runSimByString("5323513734521");
runSimByString("5323513734531");
runSimByString("6121513734521");
runSimByString("6121513734531");
runSimByString("6131513734521");
runSimByString("6131513734531");
runSimByString("6212513734521");
runSimByString("6212513734531");


    
    String s = "012345";
    for (int i=0; i<s.length(); i++) {
      for (int permType=0; permType<6; permType++) {
        runSimByString(s.substring(0, i) + Integer.toString(permType) + s.substring(i+1));
      }
    }
*/
    
    runSimByString("300305");

  }
    
  public static void main(String[] args) 
  {
    load();
    start();    
  }  
}