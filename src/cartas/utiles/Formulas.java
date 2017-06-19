package cartas.utiles;

import cartas.tipos.Baraja;

public class Formulas {
	public static Double combinatoria(Integer a, Integer b) {
		Double res = 1.0;
		for (Integer i = a; i > a - b; i--)
			res *= i;
		for (Integer i = b; i > 0; i--)
			res /= i;
		return res;
	}
	public static Double escalerasColorPosibles(Baraja b) {
		Double res = 0d;
		Double[] aux = { 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d };
		for (int x = 0; x < aux.length - 1; x++) {
			for (int i = 0; i < 4; i++)
				if (b.contiene(x + (i * 13))
						&& b.contiene(x + 1 + (i * 13))
						&& b.contiene(x + 2 + (i * 13))
						&& b.contiene(x + 3 + (i * 13))
						&& b.contiene(x + 4 + (i * 13)))
					aux[x]++;
		}
		for (int i = 0; i < 4; i++)
			if (b.contiene(i * 13)
					&& b.contiene(1 + i * 13)
					&& b.contiene(2 + i * 13)
					&& b.contiene(3 + i * 13)
					&& b.contiene(12 + i * 13))
				aux[9]++;
		for (Double d : aux)
			res += d;
		return res;
	}

	public static Double pokerPosibles(Baraja b) {
		Double res = 0d;
		Integer[] a = b.getCartasPorNumero();
		for (Integer k : a)
			if (k == 4)
				res += b.numCartas() - 4;
		return res;
	}

	public static Double coloresPosibles(Baraja b) {
		Double res = 0d;
		Integer[] a = b.getCartasPorPalo();
		for (Integer k : a)
			res += combinatoria(k, 5);
		res-=escalerasColorPosibles(b);
		return res;
	}

	public static Double fullPosibles(Baraja b) {
		Double res = 0d;
		Double[] aux = { 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d };
		Double q = 0d;
		Integer[] a = b.getCartasPorNumero();
		for (int x = 0; x < a.length; x++) {
			q = 0d;
			for (int i = 0; i < a.length; i++)
				if (x != i)
					q += combinatoria(a[i], 2);
			aux[x] = combinatoria(a[x], 3) * q;
		}
		for (Double d : aux)
			res += d;
		return res;
	}

	public static Double escalerasPosibles(Baraja b) {
		Double res = 0d;
		Double[] aux = { 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d };
		Double q = 1d;
		Integer[] a = b.getCartasPorNumero();
		for (int x = 0; x < aux.length - 1; x++) {
			q = 1d;
			for (int i = 0; i < 5; i++)
				q *= a[x + i];
			aux[x] = q;
		}
		aux[9] = (double) (a[0] * a[1] * a[2] * a[3] * a[12]);
		for (Double d : aux)
			res += d;
		res -= escalerasColorPosibles(b);
		return res;
	}

	public static Double triosPosibles(Baraja b) {
		Double res = 0d;
		Integer[] a = b.getCartasPorNumero();
		for (int x = 0; x < a.length; x++)
			res += combinatoria(b.numCartas() - a[x], 2)
					* combinatoria(a[x], 3);
		res -= fullPosibles(b);
		return res;
	}

	public static Double dobleParejasPosibles(Baraja b) {
		Double res = 0d;
		Integer[] a = b.getCartasPorNumero();
		for (int x = 0; x < a.length; x++)
			for (int y = x + 1; y < a.length; y++)
				res += (b.numCartas() - a[x] - a[y])
						* combinatoria(a[y], 2)
						* combinatoria(a[x], 2);
		return res;
	}

	public static Double parejasPosibles(Baraja b) {
		Double res = 0d;
		Double[] aux = { 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d, 0d };
		Integer[] a = b.getCartasPorNumero();
		for (int i = 0; i < a.length; i++)
			for (int x = 0; x < a.length; x++)
				for (int y = x + 1; y < a.length; y++)
					for (int z = y + 1; z < a.length; z++)
						if (x != i && y != i && z != i)
							aux[i] += (double) (a[x] * a[y] * a[z]);
		for (int i = 0; i < a.length; i++)
			res += aux[i] * combinatoria(a[i], 2);
		return res;
	}

	public static Double[] probabilidad(Baraja b) {
		Double[] res = new Double[9];
		Double aux = combinatoria(b.numCartas(), 5);
		res[0] = 0d;
		res[1] = parejasPosibles(b);
		res[2] = dobleParejasPosibles(b);
		res[3] = triosPosibles(b);
		res[4] = escalerasPosibles(b);
		res[5] = coloresPosibles(b);
		res[6] = fullPosibles(b);
		res[7] = pokerPosibles(b);
		res[8] = escalerasColorPosibles(b);
		for (Double d : res)
			res[0] -= d;
		res[0] += aux;
		for (int i=0;i<res.length;i++) 
			res[i] = res[i]*100d/aux;
		
		return res;
	}
}
