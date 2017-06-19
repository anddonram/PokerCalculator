package cartas.tipos.figuras;

import java.util.Collections;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.collect.Lists;

public class PokerImpl implements Poker {
	public static Figura f=Figura.POKER;

	private Integer poker, quinta;

	public PokerImpl(List<Integer> l) {
		List<Integer> aux = Lists.newArrayList(l);
		Collections.sort(l);
		poker = l.get(2);
		aux.remove(poker);
		aux.remove(poker);
		aux.remove(poker);
		aux.remove(poker);
		quinta = l.get(0);
	}

	public int compareTo(Poker p) {
		int res = poker.compareTo(p.getPoker());
		if (res == 0)
			res = quinta.compareTo(p.getQuinta());
		return res;
	}

	public Integer getPoker() {
		return poker;
	}

	public Integer getQuinta() {
		return quinta;
	}

}
