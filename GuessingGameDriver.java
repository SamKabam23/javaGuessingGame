import java.util.Scanner;


/** This game allows users to guess a secret number that is randomly generated
 *  from a specified range of values.
 */
public class GuessingGameDriver
{
	
	// MAIN METHOD
	// ------------------------------------------------------------------------
	
	
	/** precondition: Parameter args will not be used in this project.
	 * postcondition: The guessing game is initialized and played to completion.
	 *     algorithm: Print the name of the program to the console as a header.
	 *                Declare a Scanner variable called kin and initialize it
	 *                  with a new Scanner() object that reads input from the 
	 *                  keyboard (i.e., System.in).
	 *                Declare an integer variable called min and initialize it 
	 *                  with the result of invoking the GuessingGameDriver class'
	 *                  choseMin() method, passing it a reference to kin as a 
	 *                  parameter.
	 *                Declare an integer variable called max and initialize it 
	 *                  with the result of invoking the GuessingGameDriver class'
	 *                  choseMax() method, passing it a reference to kin as a 
	 *                  parameter.
	 *                Declare a GuessingGame variable called game and initialize
	 *                  it with a new GuessingGame object that uses min and max
	 *                  as the constructor's input parameters.
	 *                Invoke the GuessingGameDriver class' playGame() method, 
	 *                  passing it references to game and kin as parameters.
	 */
	public static void main(String[] args)
	{
		System.out.println("GUESSING GAME");
		System.out.println("=============");
		
		Scanner kin = new Scanner(System.in);
		int min = chooseMin(kin);
		int max = chooseMax(kin);
		
		GuessingGame game = new GuessingGame(min, max);
		playGame(game, kin);
		
	}
	
	
	
	// PRIVATE "HELPER" METHODS
	// ------------------------------------------------------------------------
	
	/** precondition: Parameter kin has been initialized as a Scanner that reads 
	 *                  input from the keyboard (i.e., System.in).
	 * postcondition: Returns the integer value provided by the user.
	 *     algorithm: Print a message prompting the user to enter a minimum
	 *                  value for the game's range.
	 *                Return the integer value entered by the user by invoking 
	 *                  the nextInt() method of kin.
	 */
	private static int chooseMin(Scanner kin)
	{
		System.out.println("Input a minimum number: ");
		return kin.nextInt();
	}
	
	
	
	/** precondition: Parameter kin has been initialized as a Scanner that reads  
	 *                  input from the keyboard (i.e., System.in).
	 * postcondition: Returns the integer value provided by the user.
	 *     algorithm: Print a message prompting the user to enter a maximum
	 *                  value for the game's range.
	 *                Return the integer value entered by the user by invoking 
	 *                  the nextInt() method of kin.
	 */
	private static int chooseMax(Scanner kin)
	{
		System.out.println("Input a maximum number: ");
		return kin.nextInt();
	}
	
	
	
	/** precondition: Parameter game is an initialized GuessingGame object.
	 *                Parameter kin has been initialized as a Scanner that reads  
	 *                  input from the keyboard (i.e., System.in).
	 *                The GuessingGame class has a method for testing a guess:
	 *                        public String testGuess(int guess)
	 *                The testGuess() method will return 1 of 3 String values:
	 *                        GuessingGame.LOW
	 *                        GuessingGame.HIGH
	 *                        GuessingGame.CORRECT
	 * postcondition: As the user plays the game, each guess will result in a
	 *                  message indicating that the guess was too low, too high,
	 *                  or correct.
	 *                After the user guesses the secret number, a message is
	 *                  printed indicating the total number of guesses.
	 *     algorithm: Declare a boolean variable called isDone and initialize
	 *                  it to a value of false.
	 *                Declare an integer variable called numGuesses and 
	 *                  initialize it to a value of 0.
	 *                Declare an integer variable called min and initialize it
	 *                  with the result of invoking the game object's getMin()
	 *                  method.
	 *                Declare an integer variable called max and initialize it
	 *                  with the result of invoking the game object's getMax()
	 *                  method.
	 *                While isOver is not true...
	 *                  ...print a message prompting the user to enter a number.
	 *                  ...declare an integer variable called guess and 
	 *                       initialize it with a value entered by the user by
	 *                       invoking the nextInt() method of kin.
	 *                  ...declare a String variable called answer and initialize
	 *                       it with the result of invoking the testGuess() 
	 *                       method of game (NOTE: pass guess to the method as a
	 *                       parameter).
	 *                  ...assign to isDone the result of comparing answer for
	 *                       equivalence with GuessingGame.CORRECT (HINT: use
	 *                       the equals() method when comparing objects for 
	 *                       equivalence).
	 *                  ...increment the value of numGuesses.
	 *                Print a message indicating the total number of guesses.
	 */
	private static void playGame(GuessingGame game, Scanner kin)
	{
		boolean isDone = false;
		int numGuesses = 0;
		
		while (isDone != true) {
			System.out.println("Input a guess: ");
			int guess = kin.nextInt();
			String answer = game.testGuess(guess);
			isDone = (answer.equals(GuessingGame.CORRECT));
			numGuesses++;
		}
		
		System.out.println("Great Job! You guessed the secret number in " + numGuesses +" guesses");
	}
	
}