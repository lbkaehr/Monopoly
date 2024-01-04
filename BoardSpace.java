import java.util.HashMap;

public class BoardSpace {
	protected static String[] allNames = {
			"GO", "Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax", "Reading Railroad",
			"Oriental Avenue", "Chance", "Vermont Avenue", "Connecticut Avenue", "Jail", "St. Charles Place",
			"Electric Company", "States Avenue", "Virginia Avenue", "Pennsylvania Railroad", "St. James Place",
			"Community Chest", "Tennessee Avenue", "New York Avenue", "Free Parking", "Kentucky Avenue", "Chance",
			"Indiana Avenue", "Illinois Avenue", "B. & O. Railroad", "Atlantic Avenue", "Ventnor Avenue", "Water Works",
			"Marvin Gardens", "Go To Jail", "Pacific Avenue", "North Carolina Avenue", "Community Chest",
			"Pennsylvania Avenue", "Short Line", "Chance", "Park Place", "Luxury Tax", "Boardwalk"
	};
	private static HashMap<String,String> chanceCards = new HashMap<>();
	private static HashMap<String,String> comChstCards = new HashMap<>();
	public int location;
	public String name;
	public int ID;
	public void initChance() {
		chanceCards.put("L=39", "Advance to Boardwalk");
		chanceCards.put("L=0", "Advance to GO");
		chanceCards.put("L=24", "Advance to Illinois Avenue");
		chanceCards.put("L=11", "Advance to St. Charles Place");
		chanceCards.put("L=NRR", "Advance to the nearest Railroad. If owned, pay owner twice the rent they are entitled");
		chanceCards.put("L=NRR2", "Advance to the nearest Railroad. If owned, pay owner twice the rent they are entitled");
		chanceCards.put("L=NUT", "Advance to nearest Utility. If owned, roll dice and pay owner 10 times what you rolled");
		chanceCards.put("C+50", "Bank pays you dividend of $50");
		chanceCards.put("GOJF", "Get out of Jail Free");
		chanceCards.put("L-3", "Go back 3 spaces");
		chanceCards.put("L=JAIL", "Go to Jail");
		chanceCards.put("C-HR", "Make general repairs. For every house, pay $25. For every hotel, pay $100");
		chanceCards.put("C-15", "Speeding Fine $15");
		chanceCards.put("L-5", "Take a trip to Reading Railroad");
		chanceCards.put("CE-50", "You have been elected Chairman. Pay each player $50");
		chanceCards.put("C+150", "Your building loans mature. Collect $150");
	}
	public void initComChst() {
		comChstCards.put("L=0", "Advance to GO");
		comChstCards.put("C+200", "Bank Error in your favor. Collect $200");
		comChstCards.put("C-50", "Doctor's Fee. Pay $50");
		comChstCards.put("C+50", "From Sale of Stock you get $50");
		comChstCards.put("GOJF", "Get out of Jail Free");
		comChstCards.put("L=JAIL", "Go to Jail");
		comChstCards.put("C+100", "Holiday fund matures. Receive $100");
		comChstCards.put("C+20", "Income tax refund. Collect $20");
		comChstCards.put("CE+10", "It is your birthday. Collect $10 from each player");
		comChstCards.put("C+100", "Life insurance matures. Collect $100");
		comChstCards.put("C-100", "Pay hospital fees of $100");
		comChstCards.put("C-50", "Pay school fees of $50");
		comChstCards.put("C+25", "Receive $25 consultancy fee");



	}

}
