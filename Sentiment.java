import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.FileInputStream;
import java.io.IOException;


public class Sentiment {

	public static void start (Scanner scnr) {

		System.out.println("\n");
		System.out.println("Sentiment Analysis.");

	}


  //Field Variables for Sentiment class 
  String fileName;
  boolean needInput;
  FileInputStream positiveFileStream;
  FileInputStream negativeFileStream;
  FileInputStream userFileStream;
  Scanner positiveinFS;
  Scanner negativeinFS;
  Scanner userinFS;
  HashSet<String> positiveWords;
  HashSet<String> negativeWords;
  ArrayList<String> userWords;
  int numPositive;
  int numNegative;
  int posUserWords;
  int negUserWords;
  int totalWords;
  int percentPositive;
  int percentNegative;
  int percentDifference;
  
  

  //Constructor:
  public Sentiment() {
    fileName = " ";
    needInput = true;
    positiveFileStream = null;
    negativeFileStream = null;
    userFileStream = null;
    positiveinFS = null;
    negativeinFS = null;
    userinFS = null;

    positiveWords = new HashSet<String>();
    negativeWords = new HashSet<String>();
    userWords = new ArrayList<String>();

    numPositive = 0; //number of words in positive.txt
    numNegative = 0; //number of words in negative.txt
    posUserWords = 0; //number of positive words in the user's file
    negUserWords = 0; //number of negative words in the user's file

    totalWords = 0;
    percentPositive = 0;
    percentNegative = 0;
    percentDifference = 0;
    
  }
  
  
  
  public void readPositive() throws IOException {
    String currString;
    positiveFileStream = new FileInputStream("positive.txt");
    positiveinFS = new Scanner(positiveFileStream);
    

    while (positiveinFS.hasNextLine()) {
      currString = positiveinFS.nextLine();
      
      if (currString.isEmpty() || (currString.charAt(0) == ';')) {
        continue;
      }

      positiveWords.add(currString);
      ++numPositive;
      
    }

    System.out.println();
    System.out.println();
    System.out.println(positiveWords.size() + " Positive Words Successfully Loaded.");
    
    positiveinFS.close();
    
  }

  
  
  public void readNegative() throws IOException {
    String currString;
    negativeFileStream = new FileInputStream("negative.txt");
    negativeinFS = new Scanner(negativeFileStream);

    while (negativeinFS.hasNextLine()) {
      currString = negativeinFS.nextLine();

      if (currString.isEmpty() || (currString.charAt(0) == ';')) {
        continue;
      }

      negativeWords.add(currString);
      ++numNegative;
      
    }

    System.out.println();
    System.out.println(negativeWords.size() + " Negative Words Successfully Loaded.");

    negativeinFS.close();
    
  }
  
  
  
  public void DetermineSentiment(Scanner scnr) throws IOException {
    String currString;
    String currWord;
    Scanner currStringinFS;
    char userChoice;
    boolean anotherFile = true;
    
    
    while (anotherFile) {
      totalWords = 0;
      posUserWords = 0;
      negUserWords = 0;
      userWords.clear();
    
      System.out.println();
      System.out.println();
      
      System.out.print("Enter the name of the text file to perform sentiment analysis:  ");

      while (needInput) {
        try {
          fileName = scnr.next();
          userFileStream = new FileInputStream(fileName);
          userinFS = new Scanner(userFileStream);
          needInput = false;
        }
        catch (IOException e) {
          System.out.println();
          System.out.print("File not found. Please enter a new file name:  ");
        }
      }
      needInput = true;
      

      System.out.println();
      System.out.println();
      
      System.out.println("Sentiment Report for " + fileName + ":");
      System.out.println();

      while (userinFS.hasNextLine()) {
        currString = userinFS.nextLine(); 

        if (currString.isEmpty()) { 
          continue;
        }

        currStringinFS = new Scanner(currString);

        while (currStringinFS.hasNext()) { 
          currWord = currStringinFS.next();
          currWord = currWord.replaceAll("[^a-zA-Z-+0-9*#]",""); 
          userWords.add(currWord);
          ++totalWords;
        
        }
        currStringinFS.close();
      
      }
  
      
      String word = " ";

      for (int i = 0; i < userWords.size(); ++i) { 
        word = userWords.get(i);

        if (positiveWords.contains(word)) { 
          ++posUserWords;
        }
        if (negativeWords.contains(word)) { 
          ++negUserWords;
        }

      }

      
      String sentiment;
      percentPositive = (int)(Math.round(100 * (posUserWords/((double)totalWords))));
      percentNegative = (int)(Math.round(100 * (negUserWords/((double)totalWords))));
      percentDifference = percentPositive - percentNegative;

      if ((percentPositive > percentNegative) && (Math.abs(percentDifference) >= 5)) {
        sentiment = "positive";
      }
      else if ((percentPositive < percentNegative) && (Math.abs(percentDifference) >= 5)) {
        sentiment = "negative";
      }
      else {
        sentiment = "neutral";
      }

    
      System.out.print("There were " + posUserWords + " positive words, ");
      System.out.print(negUserWords + " negative words and ");
      System.out.print(totalWords + " total words.\n");
      
      System.out.println();
      
      System.out.print("That's " + percentPositive + "% positive and ");
      System.out.print(percentNegative + "% negative.  ");
      System.out.println("Overall the file's sentiment was " + sentiment + ".");

      System.out.println();
      System.out.println();

      userChoice = ' ';

      System.out.print("Would you like to analyze another file Y/N? ");
      
      while ((userChoice != 'Y') && userChoice != 'N' ) {
        
        userChoice = scnr.next().charAt(0);

        if (userChoice == 'Y') {
          anotherFile = true;
        }
        else if (userChoice == 'N') {
          anotherFile = false;
        }
        else {
          System.out.println("Please type 'Y' OR 'N': ");
          
        } 
      } 
    }
    
    userinFS.close();
       
  }

}




