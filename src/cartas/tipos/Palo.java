package cartas.tipos;

public enum Palo {
	PICAS, TREBOLES, CORAZONES, DIAMANTES;
	public static Palo fromInteger(Integer x) {
		return Palo.values()[x/13];
	}
	public static Palo fromByte(Byte x) {
		return Palo.values()[x/13];
	}
}
