import java.util.Scanner;
public class Program07 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		//Declare Number of Rounds Variable
		int numberOfRounds = 0;

		//Declare number of wins variable
		int numberOfWins = 0;

		//Declare number of losses variable
		int numberOfLosses = 0;

		//Declare number of ties variable
		int numberOfTies = 0;

		//Declare response variable
		String response;
		
		//Print starting statement with welcome and explain the rules
		System.out.println("\t Welcome to Opponent Dice");
		System.out.println("-----------------------------------------------------");
		System.out.println("High beats low, and same ties\r\n"
				+ "Triples beat Pairs and Junk\r\n"
				+ "Pairs beat Junk\r\n"
				+ "In the case of two identical Pairs - high card decides\r\n"
				+ "in the case of two Junks - its a tie");
		System.out.println("-----------------------------------------------------");
		System.out.println();

		//Do loop since all the actions below must be done at
		//least once, with user input to repeat or finish
		do {
			
			//Declare the three die variables for player
			int playerFirstDice = (int)(Math.random() * 6) + 1;
			int playerSecondDice = (int)(Math.random() * 6) + 1;
			int playerThirdDice = (int)(Math.random() * 6) + 1;

			//Declare the three die variables for opponent 
			int computerFirstDice = (int)(Math.random() * 6) + 1;
			int computerSecondDice = (int)(Math.random() * 6) + 1;
			int computerThirdDice = (int)(Math.random() * 6) + 1;

			//Declare player's boolean variables of triple, pair, or trash. Default all to false
			boolean playerTriple = false;
			boolean playerPair = false;
			boolean playerTrash = false;

			//Declare opponent's boolean variables of triple, pair, or trash. Default all to false
			boolean computerTriple = false;
			boolean computerPair = false;
			boolean computerTrash = false;

			//Create plan to check if player has triple, pair, or trash
			if (playerFirstDice == playerSecondDice && playerSecondDice == playerThirdDice) {
				playerTriple = true;
			} else if (playerFirstDice == playerSecondDice || playerFirstDice == playerThirdDice || playerSecondDice == playerThirdDice) {
				playerPair = true;
			} else {
				playerTrash = true;
			}

			//Create plan to check if opponent has triple, pair, or trash
			if (computerFirstDice == computerSecondDice && computerSecondDice == computerThirdDice) {
				computerTriple = true;
			} else if (computerFirstDice == computerSecondDice || computerFirstDice == computerThirdDice || computerSecondDice == computerThirdDice) {
				computerPair = true;
			} else {
				computerTrash = true;
			}

			//Print player's side and their three rolls
			System.out.println("Player");
			System.out.println("------------");
			System.out.println(playerFirstDice + " " + playerSecondDice + " " + playerThirdDice);
			System.out.println();
			//Print opponent's side and their three rolls
			System.out.println("Opponent");
			System.out.println("------------");
			System.out.println(computerFirstDice + " " + computerSecondDice + " " + computerThirdDice);
			System.out.println();

			//If statement first to check if player has triple and computer doesn't
			if (playerTriple == true && computerTriple == false) {
				System.out.println("Congrats! You win!");
				numberOfWins++;
				numberOfRounds++;
			}
			// Else if statement to check if computer has triple and player doesn't
			else if (playerTriple == false && computerTriple == true) {
				System.out.println("Sorry! You lose!");
				numberOfLosses++;
				numberOfRounds++;
			}
			// Else if statement to check if both player and computer have triples
			else if (playerTriple == true && computerTriple == true) {
				System.out.println("Sorry! It was a tie!");
				numberOfTies++;
				numberOfRounds++;
			}
			
			//If statement to check if player or computer has a pair and then figure out who wins
			if (playerPair == true && computerPair == false) {
				System.out.println("Congrats! You Win!");
				numberOfWins++;
				numberOfRounds++;
			} else if (playerPair == false && computerPair == true) {
				System.out.println("Sorry! You lose!");
				numberOfLosses++;
				numberOfRounds++;
			} 
			//Check to see if both player and opponent have pairs, if so then
			//check to see who's dice is higher or lower to determine if win, loss, or tie
			else if (playerPair == true && computerPair == true) {
				//Nested if statements to check which specific die is higher or lower to 
				//determine if the round is a win, loss, or a tie
				if(playerFirstDice > computerFirstDice) {
					System.out.println("Congrats! You Win!");
					numberOfWins++;
					numberOfRounds++;
				} else if (playerSecondDice > computerSecondDice) {
					System.out.println("Congrats! You Win!");
					numberOfWins++;
					numberOfRounds++;
				} else if (playerThirdDice > computerThirdDice) {
					System.out.println("Congrats! You Win!");
					numberOfWins++;
					numberOfRounds++;
				} else if (playerFirstDice < computerFirstDice) {
					System.out.println("Sorry! You lose!");
					numberOfLosses++;
					numberOfRounds++;
				} else if (playerSecondDice < computerSecondDice) {
					System.out.println("Sorry! You lose!");
					numberOfLosses++;
					numberOfRounds++;
				} else if (playerThirdDice < computerThirdDice) {
					System.out.println("Sorry! You lose!");
					numberOfLosses++;
					numberOfRounds++;
				} else {
					System.out.println("Sorry! It was a tie!");
					numberOfTies++;
					numberOfRounds++;
				}
			}

			//Check to see if both player's have trash, if so then compare to get results
			if (playerTrash == true && computerTrash == true) {
				System.out.println("Sorry! It was a tie!");
			}
			
			//Ask player if they want to play another round, if not, exit do loop
			System.out.println("Want to go again? [y, n]: ");
			response = stdIn.next();
			System.out.println();
			
		//END OF DO LOOP
		} while (response.equals("y"));

		//Since user decided they're done, print their statistics
		System.out.println();
		System.out.println("Players Dice Results");
		System.out.println("------------");
		System.out.println("You played " + numberOfRounds + " rounds");
		System.out.println();
		System.out.println("Rounds won: " + numberOfWins);
		System.out.println("Rounds loss: " + numberOfLosses);
		System.out.println("Rounds tied: " + numberOfTies);
		System.out.println("------------");
	}
}