

public class Graph 
{
  
  private Node[] nodes;
  private Edge[] edges;
  private int numChars;
  private int numBitsPerVertex;
  
  public Graph(int numNodes, int numChars, int numBitsPerVertex)
  {
    this.numChars = numChars;
    this.numBitsPerVertex = numBitsPerVertex;
    
    String binary = "";
    for (int i=0; i<numBitsPerVertex; i++)
      binary += "0";    
    
    for (int i=0; i<numNodes; i++)
    {
      String binaryString = Integer.toBinaryString(i);
      Node n = new Node(i, i);
      for (int bitIndex=0; bitIndex<5; bitIndex++)
      {
        ;
      }
    }
    
    
  }
  
  public int binaryToInt(String s)
  {
    return Integer.parseInt(s, 2);
  }
  
  public int replaceAtIndex(String s, int index, String bit)
  {
    return binaryToInt(s.substring(0, index) + bit + s.substring(index + 1, s.length()));
  }
}