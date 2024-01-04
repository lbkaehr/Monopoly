public class User extends Player {
	private int location;
	private int[] roll;
	private String name;
	private int cash;

	public User(String name) {
		this.location = 0;
		this.type = 1;
		this.name = name;
		this.cash = 1500;
	}  // Constructor User

	public int getLocation() {
		return this.location;
	}  // Method getLocation

	public void setLocation(int location) {
		this.location = location;
	}  // Method setLocation

	public int[] getRoll() {
		return this.roll;
	}

	public String getName() {
		return this.name;
	}

	public void setRoll(int[] roll) {
		this.roll = roll;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}


	public boolean roll() {
		roll = Dice.roll();
		if (roll[0] == roll[1]) {
			return true;
		}
		return false;
	} // Method roll


} // Class User
