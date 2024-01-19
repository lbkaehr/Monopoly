public class FreeParking {
	private static int gamerule = 0; // 0 = normal, 1 = freeParking active

	public int getGamerule() {
		return gamerule;
	}

	public void setGamerule(int gamerule1) {
		gamerule = gamerule1;
	}

	public static boolean check() {
		return gamerule != 0;
	}


}

