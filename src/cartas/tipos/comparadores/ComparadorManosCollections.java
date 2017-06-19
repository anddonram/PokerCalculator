package cartas.tipos.comparadores;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import cartas.tipos.Figura;
import cartas.tipos.figuras.CartaAlta;
import cartas.tipos.figuras.CartaAltaImpl;
import cartas.tipos.figuras.ColorImpl;
import cartas.tipos.figuras.DoblePareja;
import cartas.tipos.figuras.DobleParejaImpl;
import cartas.tipos.figuras.Escalera;
import cartas.tipos.figuras.EscaleraColorImpl;
import cartas.tipos.figuras.EscaleraImpl;
import cartas.tipos.figuras.Full;
import cartas.tipos.figuras.FullImpl;
import cartas.tipos.figuras.Pareja;
import cartas.tipos.figuras.ParejaImpl;
import cartas.tipos.figuras.Poker;
import cartas.tipos.figuras.PokerImpl;
import cartas.tipos.figuras.Trio;
import cartas.tipos.figuras.TrioImpl;
import cartas.utiles.Figuras;

import com.google.common.collect.Lists;

public class ComparadorManosCollections implements
		Comparator<Collection<Integer>> {
	public int compare(Collection<Integer> mano1, Collection<Integer> mano2) {
		Figura f1 = Figuras.getFigura(mano1);
		Figura f2 = Figuras.getFigura(mano2);
		int res = f1.compareTo(f2);
		if (res == 0) {
			List<Integer> aux1 = Lists.newArrayList();
			List<Integer> aux2 = Lists.newArrayList();
			for (Integer i : mano1) {
				aux1.add(i % 13);
			}
			for (Integer i : mano2) {
				aux2.add(i % 13);
			}
			switch (f1) {
			case CARTA_MAS_ALTA:
				CartaAlta ca1 = new CartaAltaImpl(aux1);
				CartaAlta ca2 = new CartaAltaImpl(aux2);
				res = ca1.compareTo(ca2);
				break;
			case COLOR:
				CartaAlta c1 = new ColorImpl(aux1);
				CartaAlta c2 = new ColorImpl(aux2);
				res = c1.compareTo(c2);
				break;
			case DOBLE_PAREJA:
				DoblePareja dp1 = new DobleParejaImpl(aux1);
				DoblePareja dp2 = new DobleParejaImpl(aux2);
				res = dp1.compareTo(dp2);
				break;
			case ESCALERA:
				Escalera e1 = new EscaleraImpl(aux1);
				Escalera e2 = new EscaleraImpl(aux2);
				res = e1.compareTo(e2);
				break;
			case ESCALERA_DE_COLOR:
				Escalera ec1 = new EscaleraColorImpl(aux1);
				Escalera ec2 = new EscaleraColorImpl(aux2);
				res = ec1.compareTo(ec2);
				break;
			case FULL:
				Full fu1 = new FullImpl(aux1);
				Full fu2 = new FullImpl(aux2);
				res = fu1.compareTo(fu2);
				break;
			case PAREJA:
				Pareja p1 = new ParejaImpl(aux1);
				Pareja p2 = new ParejaImpl(aux2);
				res = p1.compareTo(p2);
				break;
			case POKER:
				Poker po1 = new PokerImpl(aux1);
				Poker po2 = new PokerImpl(aux2);
				res = po1.compareTo(po2);
				break;
			case TRIO:
				Trio t1 = new TrioImpl(aux1);
				Trio t2 = new TrioImpl(aux2);
				res = t1.compareTo(t2);
				break;
			}
		}
		return res;
	}
}
