public class TestRunner
{
  private Trial trial;  
  private int n;
  
  public TestRunner(int n)
  {
    this.n = n;
  }
  
  public void run()
  {
    Long num_valid_samples = 0L;
    Long num_samples = 0L;
    Boolean done = false;
    while (!done)
    {      
      Trial trial = new Trial(n);
      this.trial = trial;
      
      Graph graph = new Graph(trial);
      //graph.print();
      Boolean valid = graph.RunTrial();
      if(valid)
        num_valid_samples++;
      num_samples++;
      
      if (num_samples % 100000 == 0)
        System.out.println("Trial #" + num_samples + ": " + valid + " " + (double) num_valid_samples / num_samples); 
    }
  }
  
  public void print()
  {
    trial.print();
    
  }
}

