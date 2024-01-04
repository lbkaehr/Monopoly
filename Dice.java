
import java.util.Random;

public class Dice {
	public static int[] roll() {
		Random random = new Random();
		int[] roll = new int[2];
		int die1 = random.nextInt(1,7);
		int die2 = random.nextInt(1,7);
		roll[0] = die1;
		roll[1] = die2;
		return roll;


	}
}
