package unit9;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		String[] ranks1 = {"A","2","3"};
		String[] suits1 = {"Clubs","Hearts"};
		int[] values1 = {1,2,3};
		
		Deck deck1 = new Deck(ranks1, suits1, values1);
		System.out.println("Dealt card: " + deck1.deal());
		
		String[] ranks2 = {"5","6","7"};
		String[] suits2 = {"Diamonds","Spades"};
		int[] values2 = {5,6,7};
		
		Deck deck2 = new Deck(ranks2, suits2, values2);
		System.out.println("Is deck empty? "+ deck2.isEmpty());
		
		String[] ranks3 = {"J","Q","K"};
		String[] suits3 = {"Clubs","Diamonds","Spades"};
		int[] values3 = {11,12,13};
		
		Deck deck3 = new Deck(ranks3, suits3, values3);
		System.out.println("Deck size should be 9: " + deck3.size());
		
	}
}