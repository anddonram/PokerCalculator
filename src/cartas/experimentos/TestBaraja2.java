package cartas.experimentos;

import java.util.List;

import cartas.tipos.Baraja;
import cartas.tipos.BarajaImpl2;
import cartas.utiles.Cartas;

import com.google.common.collect.Lists;

public class TestBaraja2 {

	public static void main(String[] args) {
		Baraja b = new BarajaImpl2();
		Long l = System.currentTimeMillis();
		List<Long> ll = productorio(b);
		l = Cartas.temporizador(l);
		System.out.println(ll.size());
		System.out.println(ll.get(0));
		System.out.println(ll.get(ll.size() - 1));
		List<Long> ll2 = binario();
		l = Cartas.temporizador(l);

		System.out.println(ll2.size());
		// List<Long[]> res = Lists.newArrayList();
		// l = System.currentTimeMillis();
		// for (Long l1 : ll)
		// for (Long l2 : ll)
		// for (Long l3 : ll)
		// res.add(new Long[] { l1, l2, l3 });
		List<Long> ll3 = binario3();
		l = Cartas.temporizador(l);
		System.out.println(ll3.size());
		if (ll2.equals(ll3))
			System.out.println("ta bien hecho");
		List<Long> ll4 = binario2();
		l = Cartas.temporizador(l);
		if (ll3.equals(ll4))
			System.out.println("ta bien hecho");
	}

	private static List<Long> productorio(Baraja bar) {
		List<Long> res = Lists.newArrayList();
		for (Integer a : bar.getBaraja())
			for (Integer b : bar.getBaraja())
				if (b > a)
					for (Integer c : bar.getBaraja())
						if (c > b)
							for (Integer d : bar.getBaraja())
								if (d > c)
									for (Integer e : bar.getBaraja())
										if (e > d) {
											Long l = (long) (a * b)
													* (c * d * e);
											res.add(l);
										}
		return res;

	}

	private static List<Long> binario() {
		List<Long> list = Lists.newArrayList();
		for (int i = 0; i < 52; i++)
			for (int j = i + 1; j < 52; j++)
				for (int k = j + 1; k < 52; k++)
					for (int l = k + 1; l < 52; l++)
						for (int m = l + 1; m < 52; m++) {
							list.add((long) (Math.pow(2, i) + Math.pow(2, j)
									+ Math.pow(2, k) + Math.pow(2, l) + Math
									.pow(2, m)));
						}
		return list;

	}

	private static List<Long> binario2() {
		List<Long> list = Lists.newArrayList();
		long uno = 1L;
		for (int i = 0; i < 52; i++)
			for (int j = i + 1; j < 52; j++)
				for (int k = j + 1; k < 52; k++)
					for (int l = k + 1; l < 52; l++)
						for (int m = l + 1; m < 52; m++) {
							list.add((uno << i) + (uno << j) + (uno << k)
									+ (uno << l) + (uno << m));
						}
		return list;

	}

	private static List<Long> binario3() {
		List<Long> list = Lists.newArrayList();
		for (int i = 0; i < 52; i++) {
			long uno = 1L << i;
			for (int j = i + 1; j < 52; j++) {
				long dos = 1L << j;
				for (int k = j + 1; k < 52; k++) {
					long tres = 1L << k;
					for (int l = k + 1; l < 52; l++) {
						long cuatro = 1L << l;
						for (int m = l + 1; m < 52; m++) {
							list.add(uno + dos + tres + cuatro + (1L << m));
						}
					}
				}
			}
		}
		return list;
	}
}
