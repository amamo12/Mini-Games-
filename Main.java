import java.util.Scanner;
import java.io.IOException;

public class Main {

	final static String author = "Abbel Mamo - ABB2158558"; 

	public static void main (String[] args) throws IOException {

		Scanner scnr = new Scanner(System.in);
		String  menuOption;
		char    selectOption;

		do {
			System.out.println("\nWelcome to the CSC205 final project of " + author);

			System.out.println("\n");
			System.out.println("1. Select the Suitor.");
			System.out.println("2. Escape the Haunted House.");
			System.out.println("3. Sentiment Analysis.");
			System.out.println("\nQ. Quit.");

			do {
				System.out.print("\nYour option ==>");
				menuOption = scnr.nextLine();
			} while (menuOption.length()<1);

			switch (menuOption.charAt(0)) {

				case '1':
				   // select the suitor
				   Suitor.start(scnr);
           Suitor SuitorGame = new Suitor();
           SuitorGame.createSuitorList(scnr);
           SuitorGame.chooseSuitor();
          
				   break;

				case '2':
				   // escape the haunted house
				   HauntedHouse.start(scnr);
           HauntedHouse HauntedHouseGame = new HauntedHouse(); 
           HauntedHouseGame.startGame(scnr);
				   break;

				case '3':
				   // sentiment analysis
				   Sentiment.start(scnr);
           //MAKE SURE TO ADD NECESSARY IMPORT AND EXCEPTION(THROWS) STATEMENTS IN MAIN AND SENTIMENT FILES
           Sentiment newAnalysis = new Sentiment();
           newAnalysis.readPositive();
           newAnalysis.readNegative();
           newAnalysis.DetermineSentiment(scnr);
				   break;
			}

		} while (menuOption.toUpperCase().charAt(0) != 'Q');
	}
}