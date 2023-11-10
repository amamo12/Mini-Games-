import java.util.Scanner;

public class Suitor {

	public static void start (Scanner scnr) {

		System.out.println("\n");
		System.out.println("Select the suitor.");

	}
  
  //Definition of Node Class For Each Suitor:

  private class SuitorNode {
    //Field Members:
    private String name;
    private int num;
    private SuitorNode next;

    //Constructor:
    public SuitorNode (String name, int num) { 
      this.name = name;
      this.num = num;
      
    }
    
  }

  //Suitor Class Field Members:
  private SuitorNode last;
  private int length;
  private int numSuitors;

  //Constructor:
  public Suitor() {
    last = null;
    length = 0;
  }
  
  

  public void createSuitorList(Scanner scnr) {
    
    String name;
    
    System.out.println();

    System.out.print("Enter the number of suitors: ");
    numSuitors = scnr.nextInt();
    System.out.println();

    for (int i = 0; i < numSuitors; ++i) {
      System.out.print("Enter name of Suitor #" + (i+1) + ":  ");
      name = scnr.next();
      System.out.println();
      SuitorNode newSuitor = new SuitorNode(name, (i+1));

      
      if (i == 0) { 
        last = newSuitor;
        last.next = last;
      }
      else {
        
        newSuitor.next = last.next;
        last.next = newSuitor;
        last = newSuitor;
         
      }
      ++length;
    }
    
  }


  
  public void chooseSuitor(){

    SuitorNode currNode = last.next;

    while (length > 1) {
      for (int i = 1; i < 2; ++i) {
        currNode = currNode.next; 
      }

      SuitorNode nodeToRemove = currNode.next;


      if (nodeToRemove == last.next) {  
        System.out.println("Suitor #" + nodeToRemove.num + ", " + nodeToRemove.name + ", eliminated.");
        SuitorNode nodeAfter = nodeToRemove.next;
        last.next = nodeAfter;

        currNode = currNode.next; 
      }
      else if (nodeToRemove == last) { 
        System.out.println("Suitor #" + nodeToRemove.num + ", " + nodeToRemove.name + ", eliminated.");
        SuitorNode nodeAfter = nodeToRemove.next;
        currNode.next = nodeAfter;
        last = currNode;

        currNode = currNode.next;
      }
      else {
        System.out.println("Suitor #" + nodeToRemove.num + ", " + nodeToRemove.name + ", eliminated.");
        SuitorNode nodeAfter = nodeToRemove.next;
        currNode.next = nodeAfter;

        currNode = currNode.next; 
        
      }

      --length;

    }
    
    System.out.println();
    System.out.println("The correct suitor was #" + currNode.num + ", " + currNode.name + ".");
 
  }
  
}




