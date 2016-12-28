import java.util.*;

public class IBM_May
{
  private static Map<String, Long> vars;
  private static String lastInsertedVar;
  
  public static Long getValue(String var) 
  {
    return (Long) vars.get(var);
  }
  public static void updateVariable(String var, Long value) 
  { 
    vars.put(var, value); 
    lastInsertedVar = var;
  }
  public static void addVariable(String var, Long value) 
  { 
    vars.put(var, value);
  }
  public static String getVarOne(String statement) 
  {
    return statement.substring(0, 1);
  }
  public static String getVarTwo(String statement) 
  {
    return statement.substring(2, 3);
  }
  public static String getVarThree(String statement) 
  {
    if (statement.contains("mod"))
      return statement.substring(statement.indexOf("mod") + 4);
    else
      return statement.substring(4);
  }
  public static Long parseVarThree(String var)
  {
    Long val;
    try 
    { 
      val = Long.parseLong(var); 
    } 
    catch(NumberFormatException e) 
    { 
      val = getValue(var); 
    }
    return val;
  }
  public static char getOperation(String statement) 
  {
    if (statement.substring(3, 4).equals("*"))
      return '*';
    else if (statement.substring(3, 4).equals("+"))
      return '+';
    else
      return '%';
  }
  public static Long calculate(String var2, String var3, char op) 
  {    
    Long val2 = getValue(var2);
    Long val3 = parseVarThree(var3);
    
   // System.out.println(var2 + " " + var3 + " " + op);
    if (op == '*')       return val2 * val3;
    else if (op == '+')  return val2 + val3;
    else if (op == '%')  return val2 % val3;
    else                 System.out.println("ERRRORRROROROROROROR OP GIVEN: " + op);
    return null;
  }
  
  public static void printVars(String var1, String var2, String var3, char op)
  {
    System.out.println(var1 + " = " + var2 + " " + op + " " + var3);
  }
  
  public static Long executeStatement(String statement) 
  {
    String var1 = getVarOne(statement);
    String var2 = getVarTwo(statement);
    String var3 = getVarThree(statement);
    char op = getOperation(statement);
    
    //printVars(var1, var2, var3, op);
    
    Long rightHandSideValue = calculate(var2, var3, op);
    updateVariable(var1, rightHandSideValue);
    printAllVars();
    return rightHandSideValue;
  }
  
  public static void executeAll(String[] statements) 
  {
    for (int i=1; i<statements.length; i++)
      executeStatement(statements[i]);
  }
  public static Long run(String[] statements)  
  {
    executeAll(statements);
    return getValue(lastInsertedVar);
  }
  public static void initialize(String args[]) 
  {
    vars = new HashMap<String, Long>();
    addVariable("x", Long.parseLong(args[0]));
  }
    
  public static void printAllVars()
  {
    System.out.println("--------------------------------------");
    Iterator iterator = vars.keySet().iterator();    
    while (iterator.hasNext()) 
    {  
      String key = iterator.next().toString();  
      String value = vars.get(key).toString();  
      
      System.out.println(key + " " + value);  
    }
    System.out.println("--------------------------------------");
  }
  
 public static void main(String args[])
 {
   initialize(args);
   System.out.println(run(args));
 } 
}