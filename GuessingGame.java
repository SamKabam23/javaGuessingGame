/** This game allows users to guess secret number that is randomly generated
 *  from a specified range of values.
 */
public class GuessingGame
{
	
	// INSTANCE VARIABLES/CONSTANTS
	// ------------------------------------------------------------------------
	private int myMin;								// User-defined minimum
	private int myMax;								// User-defined maximum
	
	private int mySecret;							// The secret number
	
	
	
	// CLASS VARIABLES/CONSTANTS
	// ------------------------------------------------------------------------
	public static final String LOW = "Too low";		// Message if guess is too low
	public static final String HIGH = "Too high";	// Message if guess is too high
	public static final String CORRECT = "YES!";	// Message if guess is correct
	
	
	
	// CONSTRUCTORS
	// ------------------------------------------------------------------------
	
	/** precondition: 
	 * postcondition: 
	 */
	public GuessingGame(int min, int max) {
		this.setRange(min, max);
		mySecret = this.getSecretNumber();
		System.out.println(mySecret);
		System.out.print("A random number has been picked between ");
		System.out.println(min + " and " + max + ".");
		System.out.println();
	}
	
	
	
	// PUBLIC "MUTATOR" METHODS
	// ------------------------------------------------------------------------
	
	/** precondition: Parameters x and y are provided as parameters to represent 
	 *                  the desired range of values for this guessing game.
	 * postcondition: Instance variables myMin and myMax are initialized with
	 *                  the user's specified range.
	 *                myMin <= myMax
	 *     algorithm: Assign to myMin the value of parameter x.
	 *                Assign to myMax the value of parameter y.
	 *                If myMin is greater than myMax...
	 *                  ...declare an integer called temp and assign to it the
	 *                       value of myMin.
	 *                  ...reassign to myMin the value of myMax.
	 *                  ...reassign to myMax the value of myMin.
	 */
	public void setRange(int x, int y)
	{
		myMin = x;
		myMax = y;
		
		if (myMin > myMax) {
			int temp = myMin;
			myMin = myMax;
			myMax = temp;
		}
	}
	
	
	
	// PUBLIC "ACCESSOR" METHODS
	// ------------------------------------------------------------------------
	
	/** precondition: Instance variable myMin has been initialized with a value 
	 *                  representing the minimum value in the range for this
	 *                  guessing game.
	 * postcondition: Returns the minimum value in the range for this game.
	 *     algorithm: Return the value of myMax.
	 */
	public int getMin()
	{
		return myMin;
	}
	
	
	
	/** precondition: Instance variable myMax has been initialized with a value 
	 *                  representing the maximum value in the range for this
	 *                  guessing game.
	 * postcondition: Returns the maximum value in the range for this game.
	 *     algorithm: Return the value of myMax.
	 */
	public int getMax()
	{
		return myMax;
	}
	
	
	
	/** precondition: Parameter guess represents the number to be tested.
	 *                Instance variable mySecret has been initialized with a 
	 *                  random value within range of [myMin, myMax].
	 * postcondition: Prints and returns a message indicating whether guess was
	 *                  too low, too high, or correct.
	 *     algorithm: Declare a String variable called result and initialize it
	 *                  to the empty string (i.e., "").
	 *                If guess is less than mySecret...
	 *                  ...assign to result the value of GuessingGame.LOW.
	 *                Otherwise, if guess is greater than mySecret...
	 *                  ...assign to result the value of GuessingGame.HIGH.
	 *                Otherwise, assign to result the value of GuessingGame.CORRECT.
	 *                Print the value of result.
	 *                Print a blank line.
	 *                Return the value of result.
	 */
	public String testGuess(int guess)
	{
		String result = "";
	
	if (guess < mySecret)
	{
		result = GuessingGame.LOW;
	}
	else if (guess > mySecret)
	{
		result = GuessingGame.HIGH;
	}
		else 
		{
			result = GuessingGame.CORRECT;
		}
	
	System.out.println(result);
	System.out.println();
	
	return result;
	}
	
	// PRIVATE "HELPER" METHODS
	// ------------------------------------------------------------------------
	
	/** precondition: Instance variables myMin and myMax have been initialized 
	 *                  with the user's specified range.
	 *                myMin <= myMax
	 * postcondition: Returns a randome integer in the range of [myMin, myMax].
	 *     algorithm: Declare an integer called range and initialize it with
	 *                  the value of myMax - myMin + 1.
	 *                Return a randomly generated integer from the range of
	 *                  [myMin, myMax] using the following formula:
	 *                        (int)(Math.random() * range) + myMin
	 */
	private int getSecretNumber()
	{
		int range = myMax - myMin + 1;
		return ((int)(Math.random() * range) + myMin);

	}
	
}