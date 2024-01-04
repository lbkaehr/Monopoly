import java.util.ArrayList;

public class Property extends BoardSpace {
	private Player owner;
	private int rent;
	public int getID() {
		return this.ID;
	}

	public int getLocation() {
		return this.location;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public Property(String name, Player owner, int ID, int location, int rent) {
		this.name = name;
		this.owner = owner;
		this.ID = ID;
		this.location = location;
		this.rent = rent;
	}






}
