

public class Node
{
  private int value;
  private int Node_No;
  
  public Node(int value, int Node_No)
  {
    this.value = value;
    this.Node_No = Node_No;
  }
  public void setNode(int value)
  {
    this.value = value;
  }
  public int getNode()
  {
    return value;
  }
  public void setNodeNo(int Node_No)
  {
    this.Node_No = Node_No;
  }
  public int getNodeNo()
  {
    return Node_No;
  }
  
}