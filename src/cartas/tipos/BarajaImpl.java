package cartas.tipos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import com.google.common.collect.Sets;

public class BarajaImpl implements Baraja {
	private SortedSet<Integer> baraja = Sets.newTreeSet();
	private BitSet bs = new BitSet(52);

	public BarajaImpl() {
		for (Integer i = 0; i < 52; i++)
			this.baraja.add(i);
		bs.set(0, 52);
	}

	public BarajaImpl(Baraja b) {
		baraja = b.getBarajaInmutable();
		bs.set(0, 52);

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

	public SortedSet<Integer> getBaraja() {
		return baraja;
	}

	public SortedSet<Integer> getBarajaInmutable() {
		return copia();
	}

	public Integer[] getCartasPorNumero() {
		Integer[] res = new Integer[13];
		Arrays.fill(res, 0);
		for (Integer c : this.baraja)
			res[c % 13]++;
		return res;
	}

	public Integer[] getCartasPorPalo() {
		Integer[] res = new Integer[4];
		Arrays.fill(res, 0);
		for (Integer c : this.baraja)
			res[c / 13]++;
		return res;
	}

	public String toString() {
		List<String> res = new ArrayList<String>();
		for (Integer i : baraja)
			res.add(new CartaImpl(i).toString());
		return res.toString();
	}

	public void retirar(Integer i) {
		this.baraja.remove(i);
		this.bs.clear(i);

	}

	public void retirarTodas(Set<Integer> s) {
		this.baraja.removeAll(s);
		for (Integer i : s)
			this.bs.clear(i);
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
