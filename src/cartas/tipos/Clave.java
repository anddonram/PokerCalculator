package cartas.tipos;

import java.util.Arrays;

public class Clave implements Comparable<Clave> {
	private Integer[] clave;

	public Clave(Integer[] clave) {
		this.clave = clave;
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Clave) {
			Clave c = (Clave) o;
			res = clave[0].equals(c.getClave()[0])
					&& clave[1].equals(c.getClave()[1]);
		}
		return res;
	}

	public int hashCode() {
		return clave[0].hashCode() * 31 + clave[1].hashCode();
	}

	public String toString() {
		return Arrays.toString(clave);
	}

	public Integer[] getClave() {
		return clave;
	}

	public int compareTo(Clave o) {
		int res = clave[0].compareTo(o.getClave()[0]);
		if (res == 0)
			res = clave[1].compareTo(o.getClave()[1]);
		return res;
	}

}
