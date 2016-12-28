import java.util.*;

public class IBM_July 
{

  public static void print(int[] die)
  {    
    System.out.print(die.length + " sides; " + ((die.length * (die.length+1)) / 2) + " sums: {");
    
    for (int i=0; i<die.length; i++)
    {
      System.out.print(die[i] + " ");
    }
    System.out.println("}");
  }
  
  public static Boolean isValid(int[] die)
  {
    Set<Integer> set = new HashSet<Integer>();
     try
     {
        for(int i=0; i<die.length; i++)
        {
          for (int j=i; j<die.length; j++)
          {
            set.add(die[i] + die[j]);
          }
        }
        Boolean result = false;
        int target = ((die.length * (die.length+1)) / 2);
        if (set.size() == target)
          result = true;
        if (result)
          print(die);
        return result;
     }
     catch(Exception e){System.out.println(e.toString());}
     return false;
  }
  
  
  
  
  
  public static Boolean isValid3(int[] die)
  {
  //  Set<Integer> test = new HashSet<Integer>();
  //  for (int i=0; i<die.length; i++)
  //    test.add(die[i]);
  //  if (test.size() < die.length)
  //    return false;
    int l = die.length;
    int target = (l) + (l * ((l-1) * (l-2)) / 6) + (l * (l-1));
    //int die_cubed = die.length * die.length * die.length;
    Set<Integer> set = new HashSet<Integer>();
    try
    {
      for(int i=0; i<die.length; i++)
      {
        for (int j=i; j<die.length; j++)
        {
          for (int k=j; k<die.length; k++)
          {
            set.add(die[i] + die[j] + die[k]);
          }
        }
      }
      Boolean result = false;
      
      if (set.size() == target)
        result = true;
      //if (result && die.length == 8)
      //  print(die);
      return result;
    }
    catch(Exception e){System.out.println(e.toString());}
    return false;
  }
    
    

    
  public static void main(String args[]) 
  {
    /*
     int die[] = new int[args.length];
     for (int i=0; i<args.length; i++)
     {
       die[i] = Integer.parseInt(args[i]);
     }
     isValid3(die);
     */
    
    
     /*
     int count = 0;
     Set<Integer> set = new HashSet<Integer>();
     for(int i=0; i<die.length; i++)
     {
       for (int j=i; j<die.length; j++)
       {
         for (int k=j; k<die.length; k++)
         {
           if(!set.add(die[i] + die[j] + die[k]))
             System.out.print(die[i] + die[j] + die[k] + " ");
           count++;
         }
       }
     }
     System.out.println(count + " " + set.size());
     */
     int min = 10000;
     
     int a;int b; int c;int d;int e;int f;int g;int h;
     for ( a=1; a<2; a++)
     {
       for ( b=10; b<20; b++)
       {
         for ( c=b+1; c<40; c++)
         {
           int die3[] = new int[3];
           die3[0] = a;
           die3[1] = b;
           die3[2] = c;           
           if (isValid3(die3))
           {
             System.out.println("{" + a + " " + b + " " + c + "}");
             for (d=c+1; d<100; d++)
             {
               int die4[] = new int[4];
               die4[0] = a;
               die4[1] = b;
               die4[2] = c;  
               die4[3] = d;
               if (isValid3(die4))
               {
                 //System.out.println("{" + a + " " + b + " " + c + " " + d + "}");
                 for (e=d+1; e<127; e++)
                 {
                   int die5[] = new int[5];
                   die5[0] = a;
                   die5[1] = b;
                   die5[2] = c;
                   die5[3] = d;
                   die5[4] = e;
                   if (isValid3(die5))
                   {
                     //System.out.println("{" + a + " " + b + " " + c + " " + d + " " + e + "}");
                     for (f=e+1; f<128; f++)
                     {
                       int die6[] = new int[6];
                       die6[0] = a;
                       die6[1] = b;
                       die6[2] = c;
                       die6[3] = d;
                       die6[4] = e;
                       die6[5] = f;
                       if (isValid3(die6))
                       {
                         //System.out.println("{" + a + " " + b + " " + c + " " + d + " " + e + " " + f + "}");
                         for (g=f+1; g<129; g++)
                         {
                           int die7[] = new int[7];
                           die7[0] = a;
                           die7[1] = b;
                           die7[2] = c;
                           die7[3] = d;
                           die7[4] = e;
                           die7[5] = f;
                           die7[6] = g;
                           if (isValid3(die7))
                           {
                             //System.out.println("{" + a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + "}");
                             for (h=g+1; h<130; h++)
                             {
                               int die8[] = new int[8];
                               die8[0] = a;
                               die8[1] = b;
                               die8[2] = c;
                               die8[3] = d;
                               die8[4] = e;
                               die8[5] = f;
                               die8[6] = g;
                               die8[7] = h;
                               if (isValid3(die8) && h < min)
                               {
                                 min = h;
                                 System.out.print("Max (" + h + "): ");
                                 print(die8);
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
           }
         }
       }
     }
     
     
     
  }
} 
