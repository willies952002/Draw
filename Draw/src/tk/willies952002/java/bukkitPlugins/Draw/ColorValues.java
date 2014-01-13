package tk.willies952002.java.bukkitPlugins.Draw;

/**
 * @author William Surgeon ( willies952002 )
 * @version 1.0dev
 */
public enum ColorValues {
	WHITE(0),
	ORANGE(1),
	MAGENTA(2),
	LIGHT_BLUE(3),
	YELLOW(4),
	LIME(5),
	PINK(6),
	GRAY(7),
	SILVER(8),
	CYAN(9),
	PURPLE(10),
	BLUE(11),
	BROWN(12),
	GREEN(13),
	RED(14),
	BLACK(15);

	private short dmgValue = 0;
	
	ColorValues(int damage) {
		this.dmgValue = (short) damage;
	}
	
	public static ColorValues getByID(int id) {
		switch( id ) {
			case 0: return WHITE;
			case 1: return ORANGE;
			case 2: return MAGENTA;
			case 3: return LIGHT_BLUE;
			case 4: return YELLOW;
			case 5: return LIME;
			case 6: return PINK;
			case 7: return GRAY;
			case 8: return SILVER;
			case 9: return CYAN;
			case 10: return PURPLE;
			case 11: return BLUE;
			case 12: return BROWN;
			case 13: return GREEN;
			case 14: return RED;
			case 15: return BLACK;
			default: return WHITE;
		}
	}

	public short getDmgValue() {
		return dmgValue;
	}

}
