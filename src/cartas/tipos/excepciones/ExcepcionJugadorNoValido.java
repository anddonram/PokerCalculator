package cartas.tipos.excepciones;

public class ExcepcionJugadorNoValido extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcepcionJugadorNoValido() {
		super();
	}

	public ExcepcionJugadorNoValido(String s) {
		super(s);
	}
}
