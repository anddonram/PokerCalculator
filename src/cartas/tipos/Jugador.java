package cartas.tipos;

import java.util.SortedSet;

public interface Jugador {
	SortedSet<Integer> getMano();
	SortedSet<Integer> getManoInmutable();
	void setCarta(Integer antigua, Integer nueva,Baraja b);
	public Boolean contieneNumero(Numero n);
	public Boolean contienePalo(Palo p);
}
