import java.util.Stack;

public class BoardSpace {
	protected int location;
	protected String name;
	public int AVAILABLE = 0;
	public int OWNED = 1;
	public int MORTGAGED = 2;
	public int status;  // Used to determine what status a board space is under when a player lands on it
	private static Stack<Card> chanceStack = Card.getChanceStack();
	private static Stack<Card> communityStack = Card.getCommunityStack();
	public static Card drawChance() {
		Card currentCard = chanceStack.pop();
		chanceStack.addLast(currentCard);
		return currentCard;
	}

	public static Card drawCommunity() {
		Card currentCard = communityStack.pop();
		communityStack.addLast(currentCard);
		return currentCard;
	}
	public BoardSpace(String name, int location) {
		this.location = location;
		this.name = name;
	}
	public int getStatus() {
		return this.status;
	}

	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}
}
