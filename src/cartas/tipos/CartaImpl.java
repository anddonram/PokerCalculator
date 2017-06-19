package cartas.tipos;

public class CartaImpl implements Carta {
	private Palo palo;
	private Numero numero;

	public CartaImpl(Palo p, Numero n) {
		this.palo = p;
		this.numero = n;
	}
	public CartaImpl(Integer n){
		if(n<0||n>51)
			throw new IllegalArgumentException("CartaImpl.CartaImpl: El número, entre 0 y 51");
	this.palo=Palo.fromInteger(n);
	this.numero=Numero.fromInteger(n);
	}

	public Palo getPalo() {
		return palo;
	}

	public Numero getNumero() {
		return numero;
	}

	public void setPalo(Palo p) {
		this.palo = p;
	}

	public void setNumero(Numero n) {
		this.numero = n;
	}

	public String toString() {
		return this.getNumero() + " de " + this.getPalo();
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Carta) {
			Carta c = (Carta) o;
			res = this.getNumero().equals(c.getNumero())
					&& this.getPalo().equals(c.getPalo());
		}
		return res;
	}

	public int hashCode() {
		return this.getNumero().hashCode() * 31 + this.getPalo().hashCode();
	}

	public int compareTo(Carta c) {
		int res=this.getPalo().compareTo(c.getPalo());
		if(res==0)
			res=this.getNumero().compareTo(c.getNumero());
			return res;
		
	}

	public Integer getValor() {
		return numero.ordinal()+13*palo.ordinal();
	}
}
