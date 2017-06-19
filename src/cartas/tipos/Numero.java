package cartas.tipos;

public enum Numero {
	DOS,TRES,CUATRO,CINCO,SEIS,SIETE,OCHO,NUEVE,DIEZ,JOTA,REINA,REY,AS;
	public static Numero fromInteger(Integer x) {
		return Numero.values()[x%13];
	}
	public static Numero fromByte(Byte x) {
		return Numero.values()[x%13];
	}
}
