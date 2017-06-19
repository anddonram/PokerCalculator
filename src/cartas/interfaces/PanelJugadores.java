package cartas.interfaces;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class PanelJugadores extends JPanel {
	private static final long serialVersionUID = 1L;
	private ButtonGroup bg;
	private Multimap<BotonSeleccionJugador, JToggleButton> mm = ArrayListMultimap
			.create();
	private BotonSeleccionJugador seleccionado;

	public PanelJugadores(Integer nJug) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		bg = new ButtonGroup();

		for (int i = 1; i <= nJug; i++) {
			BotonSeleccionJugador b = new BotonSeleccionJugador("Jugador " + i);
			b.addChangeListener(new AccionBloqueo());
			JPanel panaux = new JPanel();
			panaux.add(b);
			for (int ind = 0; ind < 5; ind++) {
				JToggleButton tb = new JToggleButton();
				tb.setEnabled(false);
				panaux.add(tb);
				mm.put(b, tb);
			}
			bg.add(b);
			add(panaux);
		}

	}

	public List<JToggleButton> getSeleccion() {
		return Lists.newArrayList(mm.get(seleccionado));
	}

	public BotonSeleccionJugador getSeleccionado() {
		return seleccionado;
	}

	public Integer getNBotonesActivos() {
		Integer res = 0;
		for (JToggleButton tb : mm.get(seleccionado))
			if (tb.isSelected())
				res++;
		return res;
	}

	public List<JToggleButton> getBotonesActivos() {
		List<JToggleButton> res = Lists.newArrayList();
		for (JToggleButton tb : getSeleccion())
			if (tb.isSelected())
				res.add(tb);
		return res;
	}

	private class AccionBloqueo implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			BotonSeleccionJugador sel = (BotonSeleccionJugador) e.getSource();
			for (JToggleButton b : mm.get(sel)) {
				b.setEnabled(sel.isSelected());
				if (!sel.equals(seleccionado))
					b.setSelected(false);
			}
			seleccionado = sel;
		}
	}

}
