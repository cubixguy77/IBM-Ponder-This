public class Fraction
  {
    public int n;
    public int d;
    
    public Fraction(int n, int d)
    {
      this.n = n;
      this.d = d;
    }
    
    public int lcm(int x1, int x2)
    {
      int max,min;
      if (x1>x2) 
      {
        max = x1;
        min = x2;
      } 
      else 
      {
        max = x2;
        min = x1;
      }
      for(int i=1; i<=min; i++) 
      {
        if( (max*i)%min == 0 ) 
        {
          return i*max;
        }
      }
      return -1;
    }
    
    public Fraction reduce()
    {
      Fraction f = new Fraction(n, d);
      int i=2;
      while (i <= n) 
      {
        if (f.n % i == 0 && f.d % i == 0)
        {
          f.n /= i;
          f.d /= i;
          i = 2;
        }
        else
          i++;
      }
      return f;
    }
    
    public String toString()
    {
      return "( " + n + " / " + d + " )";
    }
    
    public void set(int n, int d)
    {
      this.n = n;
      this.d = d;
    }
    
    public Fraction add(Fraction f1, Fraction f2)
    {
      if (f1.n == 0) return f2;
      if (f2.n == 0) return f1;
      
      int LCM = lcm(f1.d, f2.d);
      int n1 = f1.n * (LCM / f1.d);
      int n2 = f2.n * (LCM / f2.d);
      
      Fraction f = new Fraction(n1 + n2, LCM);
      return f.reduce();
    }
    
    public Fraction add(Fraction f1, Fraction f2, Fraction f3)
    {
      Fraction f = add(f1, f2);
      f = add(f, f3);
      return f;
    }
    
    public Boolean equals(Fraction f2)
    {
      return this.n == f2.n && this.d == f2.d;
    }
}