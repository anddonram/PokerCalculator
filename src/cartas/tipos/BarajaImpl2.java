package cartas.tipos;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;

import com.google.common.collect.Sets;

public class BarajaImpl2 implements Baraja {
	private SortedSet<Integer> baraja = Sets.newTreeSet();

	public BarajaImpl2() {
		Collections.addAll(baraja, 11, 31, 41, 61, 101, 131, 151, 181, 191,
				211, 241, 271, 281, 13, 23, 43, 73, 83, 103, 163, 173, 193,
				223, 233, 263, 283, 17, 37, 47, 67, 97, 107, 137, 167, 197,
				227, 257, 277, 307, 19, 29, 59, 79, 89, 109, 139, 179, 199,
				229, 239, 269, 349);

	}

	public SortedSet<Integer> getBaraja() {
		return baraja;
	}

	public SortedSet<Integer> getBarajaInmutable() {
		return copia();
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Baraja) {
			Baraja b = (Baraja) o;
			res = this.baraja.equals(b.getBaraja());
		}
		return res;
	}

	public int hashCode() {
		return baraja.hashCode();
	}

	public String toString() {
		return baraja.toString();
	}

	public Integer[] getCartasPorNumero() {
		Integer[] res = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (Integer i : getBaraja())
			res[rango(i)]++;
		return res;
	}

	public Integer[] getCartasPorPalo() {
		Integer[] res = { 0, 0, 0, 0 };
		for (Integer i : getBaraja())
			switch (i % 10) {
			case 1:
				res[0]++;
				break;
			case 3:
				res[1]++;
				break;
			case 7:
				res[2]++;
				break;
			case 9:
				res[3]++;
				break;
			}
		return null;
	}

	public void retirar(Integer i) {
		baraja.remove(i);
	}

	private Integer rango(Integer i) {
		Integer res = 0;
		if (i > 20 && i < 40)
			res = 1;
		else if (i > 40 && i < 60)
			res = 2;
		else if (i > 60 && i < 80)
			res = 3;
		else if (i > 80 && i < 102)
			res = 4;
		else if (i > 102 && i < 135)
			res = 5;
		else if (i > 135 && i < 165)
			res = 6;
		else if (i > 165 && i < 190)
			res = 7;
		else if (i > 190 && i < 200)
			res = 8;
		else if (i > 200 && i < 230)
			res = 9;
		else if (i > 230 && i < 260)
			res = 10;
		else if (i > 260 && i < 280)
			res = 11;
		else if (i > 280 && i < 350)
			res = 12;

		return res;
	}

	public void retirarTodas(Set<Integer> s) {
		baraja.removeAll(s);
	}

	public Boolean contiene(Integer i) {
		return baraja.contains(i);
	}

	public Boolean contieneTodas(Set<Integer> s) {
		return baraja.containsAll(s);
	}

	public Integer numCartas() {
		return baraja.size();
	}

	private SortedSet<Integer> copia() {
		return Sets.newTreeSet(baraja);
	}

}
