package cartas.tipos;

public interface Carta extends Comparable<Carta>{
	Palo getPalo();
	Numero getNumero();
	void setPalo(Palo p);
	void setNumero(Numero n);
	Integer getValor();
}
