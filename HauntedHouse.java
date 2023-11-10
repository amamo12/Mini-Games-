import java.util.Scanner;

public class HauntedHouse {

	public static void start (Scanner scnr) {

		System.out.println("\n");
		System.out.println("Escape the Haunted House.");

	}

  //Definition of Node Class for Each Room:
  
  private class RoomNode {
    //Field Members:
    private char roomLetter; 
    private RoomNode nextNorth;
    private RoomNode nextSouth;
    private RoomNode nextWest;
    private RoomNode nextEast;
    private int numOptions;

    //Constructor:
    public RoomNode(char roomLetter) {
      this.roomLetter = roomLetter;
      this.nextNorth = null;
      this.nextSouth = null;
      this.nextWest = null;
      this.nextEast = null;
      this.numOptions = 0;
    }

    public char getRoomLetter() {
      return this.roomLetter;
    }

    public int getNumOptions() {
      return numOptions;
    }

    
    public void setNorth(RoomNode nextRoom) {
      this.nextNorth = nextRoom;
      ++numOptions;
      
    }

    public void setSouth(RoomNode nextRoom) {
      this.nextSouth = nextRoom;
      ++numOptions;
    }

    public void setWest(RoomNode nextRoom) {
      this.nextWest = nextRoom;
      ++numOptions;
      
    }

    public void setEast(RoomNode nextRoom) {
      this.nextEast = nextRoom;
      ++numOptions;
    }

    
    public RoomNode getNorth() {
      return nextNorth;
    }
    
    public RoomNode getSouth() {
      return nextSouth;
    }
    
    public RoomNode getWest() {
      return nextWest;
    }
    
    public RoomNode getEast() {
      return nextEast;
    }
    
  }
  

  
  //HauntedHouse Class Field Members:
  private RoomNode RoomA;
  private RoomNode RoomB;
  private RoomNode RoomC;
  private RoomNode RoomD;
  private RoomNode RoomE;
  private RoomNode RoomF;
  private RoomNode RoomG;
  private RoomNode RoomH;
  private RoomNode RoomI;
  private RoomNode RoomJ;
  private RoomNode RoomK;
  private RoomNode RoomL;


  //Constructor:
  public HauntedHouse() {
    RoomA = new RoomNode('A'); 
    RoomB = new RoomNode('B');
    RoomC = new RoomNode('C');
    RoomD = new RoomNode('D');
    RoomE = new RoomNode('E');
    RoomF = new RoomNode('F');
    RoomG = new RoomNode('G');
    RoomH = new RoomNode('H');
    RoomI = new RoomNode('I');
    RoomJ = new RoomNode('J');
    RoomK = new RoomNode('K');
    RoomL = new RoomNode('L');

    RoomA.setSouth(RoomE);
    RoomA.setEast(RoomB);

    RoomB.setSouth(RoomF);
    RoomB.setWest(RoomA);
    RoomB.setEast(RoomC);

    RoomC.setWest(RoomB);
    RoomC.setEast(RoomD);

    RoomD.setSouth(RoomH);
    RoomD.setWest(RoomC);

    RoomE.setNorth(RoomA);
    RoomE.setSouth(RoomI);

    RoomF.setNorth(RoomB);
    RoomF.setEast(RoomG);

    RoomG.setSouth(RoomK);
    RoomG.setWest(RoomF);

    RoomH.setNorth(RoomD);

    RoomI.setNorth(RoomE);
    RoomI.setEast(RoomJ);

    RoomJ.setWest(RoomI);

    RoomK.setNorth(RoomG);
    RoomK.setEast(RoomL);

    RoomL.setWest(RoomK);

    
  }

  

  public void startGame(Scanner scnr) {
    System.out.println();
    System.out.println();
    
    RoomNode currRoom;
    currRoom = RoomA;

    char userChoice;
    userChoice = ' ';

    while (true) {
      String direction1 = " ";
      String direction2 = " ";
      String direction3 = " ";
      char d1 = ' ';
      char d2 = ' ';
      char d3 = ' ';

      
      if (currRoom.getRoomLetter() == 'L') {
        System.out.println("You are in room L of the Haunted House.  You made it out alive!");
        return;
          
      }

      System.out.print("You are in room " + currRoom.getRoomLetter() + " of the Haunted House.  ");

      
      if (currRoom.getNumOptions() == 1) { 
        if (currRoom.getNorth() != null) {
          direction1 = "north";
          d1 = 'N';
        }
        if (currRoom.getSouth() != null) {
          direction1 = "south";
          d1 = 'S';
        }
        if (currRoom.getWest() != null) {
          direction1 = "west";
          d1 = 'W';
        }
        if (currRoom.getEast() != null) {
          direction1 = "east";
          d1 = 'E';
        }

        System.out.println("You can go " + direction1 + ".");
      }
      else if (currRoom.getNumOptions() == 2) { 
        if (currRoom.getSouth() != null) {
          direction1 = "south";
          d1 = 'S';
        }
        if (currRoom.getEast() != null) {
          direction1 = "east";
          d1 = 'E';
        }
        if (currRoom.getWest() != null) {
         direction1 = "west";
          d1 = 'W';
        }
        if (currRoom.getNorth() != null) {
          direction1 = "north";
          d1 = 'N';
        }

        
        if ((currRoom.getEast() != null) && (!(direction1.equals("east")))) {
          direction2 = "east";
          d2 = 'E';
        }
        if ((currRoom.getSouth() != null) && (!(direction1.equals("south")))) {
          direction2 = "south";
          d2 = 'S';
        }
        if ((currRoom.getWest() != null) && (!(direction1.equals("west")))) {
          direction2 = "west";
          d2 = 'W';
        }
        if ((currRoom.getNorth() != null) && (!(direction1.equals("north")))) {
          direction2 = "north";
          d2 = 'N';
        }

        System.out.println("You can go " + direction1 + " or " + direction2 + ".");
        
        
      }
      else { 
        
        if (currRoom.getEast() != null) {
          direction1 = "east";
          d1 = 'E';
        }
        if (currRoom.getSouth() != null) {
          direction1 = "south";
          d1 = 'S';
        }
        if (currRoom.getWest() != null) {
          direction1 = "west";
          d1 = 'W';
        }
        if (currRoom.getNorth() != null) {
          direction1 = "north";
          d1 = 'N';
        }

        
        if ((currRoom.getEast() != null) && (!(direction1.equals("east")))) {
          direction2 = "east";
          d2 = 'E';
        }
        if ((currRoom.getSouth() != null) && (!(direction1.equals("south")))) {
          direction2 = "south";
          d2 = 'S';
        }
        if ((currRoom.getWest() != null) && (!(direction1.equals("west")))) {
          direction2 = "west";
          d2 = 'W';
        }
        if ((currRoom.getNorth() != null) && (!(direction1.equals("north")))) {
          direction2 = "north";
          d2 = 'N';
        }

        
        if ((currRoom.getEast() != null) && (!(direction1.equals("east"))) && (!(direction2.equals("east")))) {
          direction3 = "east";
          d3 = 'E';
        }
        if ((currRoom.getSouth() != null) && (!(direction1.equals("south"))) && (!(direction2.equals("south")))) {
          direction3 = "south";
          d3 = 'S';
        }
        if ((currRoom.getWest() != null) && (!(direction1.equals("west"))) && (!(direction2.equals("west")))) {
          direction3 = "west";
          d3 = 'W';
        }
        if ((currRoom.getNorth() != null) && (!(direction1.equals("north"))) && (!(direction1.equals("north")))) {
          direction3 = "north";
          d3 = 'N';
        }

        System.out.println("You can go " + direction1 + ", " + direction2 + " or " + direction3 + "."); 
        
      }
      
      
      userChoice = scnr.next().charAt(0);
      
      if ((userChoice != d1) && (userChoice != d2) && (userChoice != d3)) {
        System.out.println("You can't go in that direction!");
      }
      else { 
        if (userChoice == 'N') {
          currRoom = currRoom.nextNorth;
        }
        if (userChoice == 'W') {
          currRoom = currRoom.nextWest;
        }
        if (userChoice == 'S') {
          currRoom = currRoom.nextSouth;
        }
        if (userChoice == 'E') {
          currRoom = currRoom.nextEast;
        }
        
      }
  
    } 
    
  }
  
}




