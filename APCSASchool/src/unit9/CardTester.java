package unit9;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card a = new Card("2", "spades", 2);
		Card b = new Card("5", "clubs", 5);
		Card c = new Card("10", "diamonds", 10);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}