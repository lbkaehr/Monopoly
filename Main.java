import javax.swing.*;
import java.util.ArrayList;

public class Main {
	public static ArrayList<User> allUsers = new ArrayList<>();
	private static final Integer[] numLst = {2,3,4};
	private static int currentIndex = 0;
	private static int playerCount;
	public static void main(String[] args) {
		String players = String.valueOf(JOptionPane.showInputDialog(null,
				"Choose how many players:", "Player Count", JOptionPane.QUESTION_MESSAGE,
				null , numLst, numLst[0]));
		if (players == null) {
			return;
		}
		playerCount = Integer.parseInt(players);
		System.out.printf("Player count: %d\n", playerCount);

		for (int i = 0; i < playerCount; i++) {
			allUsers.add(new User(String.format("Player %d", (i + 1))));
		}
		User currentUser = allUsers.get(0);
		Board board = new Board(currentUser);
		board.displayBoard();
	}

	public static User getNextUser() {
		if (currentIndex == allUsers.size() - 1) {
			currentIndex = 0;
			return allUsers.get(0);
		} else {
			currentIndex++;
			return allUsers.get(currentIndex);
		}


	}
	public static int getPlayerCount() {
		return playerCount;
	}
}
