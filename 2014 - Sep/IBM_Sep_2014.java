public class IBM_Sep_2014
{
    
  public static void main(String[] args)
  {
     long a = 3486784401L;
     long b = 2416854776L;
     double e = Math.E;
     
     long num=0L;
     long den=0L;
     
     double q = 1.00000000000;
     
     
     while (num < a || den < b)
     {
       if (q <= 1 && num < a)
       {
         q *= 2;
         num++;
       }
       if (q > 1 && den < b)
       {
         q /= e;
         den++;
       }
       
       if (num % 100000000 == 0)
         System.out.println(num + " " + den + " " + q);
     }
     System.out.println(num + " " + den + " " + q);
  }    
}

