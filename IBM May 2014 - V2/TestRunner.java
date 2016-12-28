public class TestRunner
{
  private Trial trial;  
  private int n;
  private long num_samples;
  private long num_valid_samples;
  
  public TestRunner(int n, long num_samples, long num_valid_samples)
  {
    this.n = n;
    this.num_samples = num_samples;
    this.num_valid_samples = num_valid_samples;
  }
  
  public void run()
  {

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
      
      if (num_samples % 1000000 == 0)
        System.out.println("Trial #" + num_samples + ": " + valid + " " + ((double) num_valid_samples / num_samples) + "   " + num_valid_samples); 
    }
  }
  
  public void print()
  {
    trial.print();
    
  }
}

