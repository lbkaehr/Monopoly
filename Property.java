import java.util.ArrayList;

public class Property extends BoardSpace {
	private Player owner;
	private int rent;

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

	public Property(String name, Player owner, int location, int rent) {
		super(name,location);
		this.owner = owner;
		this.rent = rent;
	}






}
