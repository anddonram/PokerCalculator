package cartas.tipos.figuras;

public interface CartaAlta extends Comparable<CartaAlta> {
	Integer getMasAlta();
	Integer getSegundaAlta();
	Integer getTerceraAlta();
	Integer getCuartaAlta();
	Integer getMasPequena();
}
