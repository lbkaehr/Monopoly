import java.util.*;

public class Card {
	private String text;  // Text on the card
	private int value;  // Value associated with the card
	private String type;  // Cash, Location, Jail
	private String operation; // "=" , "+", "-"
	static String LOCATION = "L";
	static String CASH = "C";
	static String JAIL = "J";
	static String SET = "=";
	static String ADD = "+";
	static String SUBTRACT = "-";
	static int NEARESTRR = 0;  // Nearest railroad
	static int NEARESTUTIL = 0; // Nearest Utility
	static int GENREPAIR = 0; // Make General Repairs
	static int STREETREPAIR = 0; // Assesed for street repairs
	private static int CHAIRMAN = (50 * Main.getPlayerCount());
	private static int BIRTHDAY = (10 * Main.getPlayerCount());
	private static Stack<Card> chanceStack = new Stack<>();
	private static Stack<Card> communityStack = new Stack<>();

	private static Card[] allChance = new Card[16];
	private static Card[] allCommunity = new Card[16];
	private Card(String text, int value, String type, String operation) {
		this.text = text;
		this.value = value;
		this.type = type;
		this.operation = operation;
	}

	private static void fillChance() {
		allChance[0] = new Card("Advance to Boardwalk", 39, LOCATION, SET);
		allChance[1] = new Card("Advance to GO", 0, LOCATION, SET);
		allChance[2] = new Card("Advance to Illinois Avenue", 24, LOCATION, SET);
		allChance[3] = new Card("Advance to St. Charles Place", 11, LOCATION, SET);
		allChance[4] = new Card(
				"Advance to the nearest Railroad. If Owned, pay owner twice the rent they are entitled",
				NEARESTRR, LOCATION, SET);
		allChance[5] = new Card(
				"Advance to the nearest Railroad. If Owned, pay owner twice the rent they are entitled",
				NEARESTRR, LOCATION, SET);
		allChance[6] = new Card(
				"Advance to the nearest Utility. If owned, roll dice and pay owner 10 times what you rolled",
				NEARESTUTIL, LOCATION, SET);
		allChance[7] = new Card("Bank pays you dividend of $50", 50, CASH, ADD);
		allChance[8] = new Card("Get out of Jail Free", -1, JAIL, null);
		allChance[9] = new Card("Go back 3 spaces", 3, LOCATION, SUBTRACT);
		allChance[10] = new Card("Go to Jail", 40, LOCATION, SET);
		allChance[11] = new Card("Make general repairs. For every house, pay $25. For every hotel, pay $100",
				GENREPAIR, CASH, SUBTRACT);
		allChance[12] = new Card("Speeding Fine $15", 15, CASH, SUBTRACT);
		allChance[13] = new Card("Take a trip to Reading Railroad", 5, LOCATION, SET);
		allChance[14] = new Card("You have been elected Chairman. Pay each player $50",
				CHAIRMAN, CASH, SUBTRACT);
		allChance[15] = new Card("Your building loans mature. Collect $150", 150, CASH, ADD);
	}

	private static void fillCommunity() {
		allCommunity[0] = new Card("Advance to GO", 0, LOCATION, SET);
		allCommunity[1] = new Card("Bank error in your favor. Collect $200", 200, CASH, ADD);
		allCommunity[2] = new Card("Doctor's fee. pay $50", 50, CASH, SUBTRACT);
		allCommunity[3] = new Card("From Sale of Stock you get $50", 50, CASH, ADD);
		allCommunity[4] = new Card("Get out of Jail Free", -1, JAIL, null);
		allCommunity[5] = new Card("Go to Jail", 40, LOCATION, SET);
		allCommunity[6] = new Card("Holiday fund matures. Receive $100", 100, CASH, ADD);
		allCommunity[7] = new Card("Income tax refund. Collect $20", 20, CASH, ADD);
		allCommunity[8] = new Card("It is your birthday. Collect $10 from each player", BIRTHDAY, CASH, ADD);
		allCommunity[9] = new Card("Life insurance matures. Collect $100", 100, CASH, ADD);
		allCommunity[10] = new Card("Pay hospital fees of $100", 100, CASH, ADD);
		allCommunity[11] = new Card("Pay school fees of $50", 50, CASH, SUBTRACT);
		allCommunity[12] = new Card("Receive $25 consultancy fee", 25, CASH, ADD);
		allCommunity[13] = new Card("You are assessed for street repair. $40 per house. $115 per hotel",
				STREETREPAIR, CASH, SUBTRACT);
		allCommunity[14] = new Card("You have won second prize in a beauty contest. Collect $10",
				10, CASH, ADD);
		allCommunity[15] = new Card("You inherit $100", 100, CASH, ADD);
	}

	public static void initCards() {
		fillChance();
		fillCommunity();
		Collections.addAll(chanceStack, allChance);
		Collections.addAll(communityStack, allCommunity);

		Collections.shuffle(chanceStack);
		Collections.shuffle(communityStack);
	}

	public static Stack<Card> getChanceStack() {
		return chanceStack;
	}

	public static Stack<Card> getCommunityStack() {
		return communityStack;
	}

}
