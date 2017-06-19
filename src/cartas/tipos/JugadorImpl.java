package cartas.tipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

public class JugadorImpl implements Jugador {
	private SortedSet<Integer> mano = Sets.newTreeSet();

	public JugadorImpl(Baraja b, Set<Integer> manoInicial) {
		Preconditions.checkArgument(
				manoInicial.size() == 5 && b.contieneTodas(manoInicial),
				"JugadorImpl.JugadorImpl: La mano incial debe tener 5 cartas");
		b.retirarTodas(manoInicial);
		this.mano.addAll(manoInicial);
	}

	public JugadorImpl(Set<Carta> manoInicial, Baraja b) {
		Preconditions.checkArgument(manoInicial.size() == 5,
				"JugadorImpl.JugadorImpl: La mano incial debe tener 5 cartas");
		for (Carta c : manoInicial) {
			Integer i = c.getValor();
			Preconditions.checkArgument(b.contiene(i));
			b.retirar(i);
			this.mano.add(i);
		}
	}

	public JugadorImpl(Baraja b, Integer v, Integer w, Integer x, Integer y,
			Integer z) {
		Preconditions.checkArgument(v >= 0 && v < 52 && w >= 0 && w < 52
				&& x >= 0 && x < 52 && y >= 0 && y < 52 && z >= 0 && z < 52,
				"JugadorImpl.JugadorImpl: Los números, entre 0 y 51");

		Preconditions.checkArgument(
				b.contiene(v) && b.contiene(w) && b.contiene(x)
						&& b.contiene(y) && b.contiene(z),
				"JugadorImpl.JugadorImpl:Los números deben estar en la baraja");
		this.mano.add(v);
		b.retirar(v);
		this.mano.add(w);
		b.retirar(w);
		this.mano.add(x);
		b.retirar(x);
		this.mano.add(y);
		b.retirar(y);
		this.mano.add(z);
		b.retirar(z);
	}

	public SortedSet<Integer> getMano() {
		return mano;
	}

	public SortedSet<Integer> getManoInmutable() {
		return copia();
	}

	public void setCarta(Integer antigua, Integer nueva, Baraja b) {
		Preconditions.checkArgument(nueva >= 0 && nueva < 52,
				"JugadorImpl.setCarta: El número, entre 0 y 51");
		Preconditions.checkArgument(
				b.contiene(nueva) && mano.contains(antigua),
				"JugadorImpl.setCarta: Las cartas no cumplen las condiciones");
		b.retirar(nueva);
		this.mano.remove(antigua);
		this.mano.add(nueva);
	}

	public Boolean contieneNumero(Numero n) {
		Boolean res = false;
		for (Integer c : mano)
			if (c % 13 == n.ordinal()) {
				res = true;
				break;
			}
		return res;
	}

	public Boolean contienePalo(Palo p) {
		Boolean res = false;
		for (Integer c : mano)
			if (p.ordinal() == c / 13) {
				res = true;
				break;
			}
		return res;
	}

	public String toString() {
		List<String> res = new ArrayList<String>();
		for (Integer i : mano)
			res.add(new CartaImpl(i).toString());
		return res.toString();
	}

	private SortedSet<Integer> copia() {
		return Sets.newTreeSet(mano);
	}
}