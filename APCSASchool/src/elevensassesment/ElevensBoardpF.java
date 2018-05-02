package elevensassesment;

import java.util.List;

import elevens.Board;

import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoardpF extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoardpF()  {
		super(BOARD_SIZE,RANKS,SUITS,POINT_VALUES);
		System.out.println("Xavier Tao\nPeriod 4\nMarch 28, 2018\n28");
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		boolean eleven = containsPairSum11(selectedCards);
		boolean jqk = containsJQK(selectedCards);
		
		if(eleven||jqk)
			return true;
		else
			return false;
		
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		List<Integer> cardsleft = cardIndexes();
		boolean has11 = containsPairSum11(cardsleft);
		boolean JQK = containsJQK(cardsleft);
		
		if(has11||JQK)
			return true;
		else
			return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		
		for(int i=0;i<selectedCards.size();i++){
			for(int j=0;j<selectedCards.size();j++){
				for(int k=0;k<selectedCards.size();k++){
					if(i!=j&&j!=k&&i!=k&&cardAt(selectedCards.get(i)).pointValue()+cardAt(selectedCards.get(j)).pointValue()+cardAt(selectedCards.get(k)).pointValue()==11){
						return true;
					}
				}
			}
		}
		return false;
	}
	

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		int jack = 0;
		int queen = 0;
		int king = 0;
		
		for(int i=0;i<selectedCards.size();i++){
			if(cardAt(selectedCards.get(i)).rank().equals("jack"))
				jack++;
			if(cardAt(selectedCards.get(i)).rank().equals("queen"))
				queen++;
			if(cardAt(selectedCards.get(i)).rank().equals("king"))
				king++;
		}
		System.out.print(jack+queen+king);
		if(jack==2||queen==2||king==2)
			return true;
		else
			return false;
	}
}