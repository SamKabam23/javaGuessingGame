/** This game implements a bot that can guess a secret number that is randomly 
 *  generated from a specified range of values.
 */
public class GuessingGameBot
{
	
	// CLASS VARIABLES/CONSTANTS
	// ------------------------------------------------------------------------
	private static final int MIN = -10000;
	private static final int MAX = 10000;
	
	
	
	// MAIN METHOD
	// ------------------------------------------------------------------------
	
	/** Instantiates a GuessingGameBot that automatically plays the guessing 
	 *  game. Which algorithm/strategy the bot uses is up to the student to  
	 *  determine and implement.
	 */
	public static void main(String[] args)
	{
		System.out.println("GUESSING GAME BOT");
		System.out.println("=================");
		new GuessingGameBot();
	}
	
	
	
	// CONSTRUCTORS
	// ------------------------------------------------------------------------
	
	/** precondition: Class constants MIN and MAX are initialized integers that
	 *                  represent the range of values for the guessing game this 
	 *                  bot will play.
	 * postcondition: Instantiates and plays a GuessingGame.
	 *                Upon guessing the secret number, a message should be 
	 *                  printed indicating the total number of guesses made by
	 *                  the bot.
	 *     algorithm: Declare a GuessingGame variable called game and initialize
	 *                  it with a new GuessingGame object, passing class 
	 *                  constants MIN and MAX as parameters.
	 *                Declare an integer variable called numGuesses and initialize
	 *                  it with the result of invoking the playGame() method on
	 *                  this object (i.e., use the keyword 'this' when an object
	 *                  references itself), passing game as a parameter. For 
	 *                  example:
	 *                        this.playGame(game)
	 *                Print a message indicating the total number of guesses.
	 */
	public GuessingGameBot()
	{
		GuessingGame game = new GuessingGame(GuessingGameBot.MIN, GuessingGameBot.MAX);
		int numGuesses = this.playGame(game);
		System.out.println("The BOT took " + numGuesses + " guesses to play the game");
		
	}
	
	
	
	// PRIVATE "HELPER" METHODS
	// ------------------------------------------------------------------------
	
	/** precondition: Parameter game has been instantiated as a GuessingGame
	 *                  object.
	 *                The GuessingGame class has a method for testing a guess:
	 *                        public String testGuess(int guess)
	 *                The testGuess() method will return 1 of 3 String values:
	 *                        GuessingGame.LOW
	 *                        GuessingGame.HIGH
	 *                        GuessingGame.CORRECT
	 * postcondition: Plays the guessing game to completion until the bot 
	 *                  correctly guesses the secret number.
	 *                Each guess should be printed to the console.
	 *                The GuessingGame will print to the console a response for 
	 *                  each guess.
	 *                Returns the total number of guesses made during the game.
	 *     algorithm: To be determined by the student.
	 */
	private int playGame(GuessingGame game)
	{
		boolean isDone = false;
		int numGuesses = 0;
		int min = GuessingGameBot.MIN;
		int max = GuessingGameBot.MAX;
		int guess = 0;
		
		
		while (isDone != true) {
			
			guess = (max - min) / 2 + min;
			
			if (game.testGuess(guess).equals(GuessingGame.HIGH))
			{
				max = guess - 1;
			}
			else if (game.testGuess(guess).equals(GuessingGame.LOW))
			{
				min = guess++;
			}
				else 
				{
					isDone = true;
				}

			numGuesses++;
		}
		return numGuesses; 
	}
}
