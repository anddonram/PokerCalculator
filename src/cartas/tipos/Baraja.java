package cartas.tipos;

import java.util.Set;
import java.util.SortedSet;

public interface Baraja {
	SortedSet<Integer> getBaraja();
	SortedSet<Integer> getBarajaInmutable();
	Integer[] getCartasPorNumero();
	Integer[] getCartasPorPalo();
	void retirar(Integer i);
	void retirarTodas(Set<Integer> s);
	Boolean contiene(Integer i);
	Boolean contieneTodas(Set<Integer> s);
	Integer numCartas();
}