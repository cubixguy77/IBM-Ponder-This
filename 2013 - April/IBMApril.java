

public class IBMApril
{
  
    
  
 public static void print(Fraction L1, Fraction L2, Fraction R1, Fraction R2, Fraction R3)
 {
   Fraction leftSum = L1.add(L1, L2);
   Fraction rightSum = R1.add(R1, R2, R3);
   if (leftSum.equals(rightSum))
   {     
     System.out.println("=============================================================================");
     System.out.println("L1: " + L1.toString());
     System.out.println("L2: " + L2.toString());
     System.out.println("R1: " + R1.toString());
     System.out.println("R2: " + R2.toString());
     System.out.println("R3: " + R3.toString());     
     System.out.println("=============================================================================");     
     System.out.println("Left Side Sum: " + L1.add(L1, L2).toString());
     System.out.println("Right Side Sum: " + R1.add(R1, R2, R3).toString());   
     System.out.println();
   }
 }
  
  
 public static void main(String[] args) 
 {
   for (int d=0; d<10; d++) {
     for (int o=1; o<10; o++) {
       for (int n=0; n<10; n++) {
         for (int t=1; t<10; t++) {
           for (int p=0; p<10; p++) {
             for (int e=1; e<10; e++) {
               for (int r=0; r<10; r++) {
                 for (int i=1; i<10; i++) {
                   for (int s=0; s<10; s++) {
                     for (int h=1; h<10; h++) {
                       if (d != o && d != n && d != t && d != p && d != e && d != r && d != i && d != s && d != h 
                                  && o != n && o != t && o != p && o != e && o != r && o != i && o != s && o != h 
                                            && n != t && n != p && n != e && n != r && n != i && n != s && n != h 
                                                      && t != p && t != e && t != r && t != i && t != s && t != h
                                                                && p != e && p != r && p != i && p != s && p != h 
                                                                          && e != r && e != i && e != s && e != h 
                                                                                    && r != i && r != s && r != h 
                                                                                              && i != s && i != h 
                                                                                                        && s != h )
                       {
                         Fraction L1 = new Fraction(d, o);
                         Fraction L2 = new Fraction(n, t);
                         Fraction R1 = new Fraction(p, e);
                         Fraction R2 = new Fraction(r, i);
                         Fraction R3 = new Fraction(s, h);
                         
                         print(L1, L2, R1, R2, R3);
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