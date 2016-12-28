

public class Diagonal
{
  
  private int score = 0;
  private int length;
  private int numBlack = 0;
  
 public Diagonal(int index)
 {  
   switch (index)
   {
     case 0:   length = 1; break;
     case 1:   length = 2; break;
     case 2:   length = 3; break;
     case 3:   length = 4; break;
     case 4:   length = 5; break;
     case 5:   length = 6; break;
     case 6:   length = 7; break;
     case 7:   length = 8; break;
     case 8:   length = 7; break;
     case 9:   length = 6; break;
     case 10:  length = 5; break;
     case 11:  length = 4; break;
     case 12:  length = 3; break;
     case 13:  length = 2; break;
     case 14:  length = 1; break;
     case 15:  length = 1; break;
     case 16:  length = 2; break;
     case 17:  length = 3; break;
     case 18:  length = 4; break;
     case 19:  length = 5; break;
     case 20:  length = 6; break;
     case 21:  length = 7; break;
     case 22:  length = 8; break;
     case 23:  length = 7; break;
     case 24:  length = 6; break;
     case 25:  length = 5; break;
     case 26:  length = 4; break;
     case 27:  length = 3; break;
     case 28:  length = 2; break;
     case 29:  length = 1; break;
   }                     
 }
  
  
 
 public void update(int deltaBlack)
 {
   numBlack += deltaBlack; // -1, 0, or 1   
 }
 
  
 public int getScore() { return score; }
 public void setScore(int score) { this.score = score; }
 
  public double getPercentage() { return (double) numBlack / length; }
}