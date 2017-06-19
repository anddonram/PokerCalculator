package cartas.interfaces.copy;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class PanelJugadores extends JPanel  implements ChangeListener{
	private static final long serialVersionUID = 1L;
	private ButtonGroup bg;
	private Multimap<BotonSeleccionJugador, BotonCarta> mm = ArrayListMultimap
			.create();
	private BotonSeleccionJugador seleccionado;

	public PanelJugadores(Integer nJug) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		bg = new ButtonGroup();

		for (int i = 1; i <= nJug; i++) {
			BotonSeleccionJugador b = new BotonSeleccionJugador("Jugador " + i);
			b.addChangeListener(this);
			JPanel panaux = new JPanel();
			panaux.add(b);
			for (int ind = 0; ind < 5; ind++) {
				BotonCarta tb = new BotonCarta();
				tb.setEnabled(false);
				panaux.add(tb);
				mm.put(b, tb);
			}
			bg.add(b);
			add(panaux);
		}

	}

	public List<BotonCarta> getSeleccion() {
		return Lists.newArrayList(mm.get(seleccionado));
	}

	public BotonSeleccionJugador getSeleccionado() {
		return seleccionado;
	}

	public Integer getNBotonesActivos() {
		Integer res = 0;
		for (BotonCarta tb : mm.get(seleccionado))
			if (tb.isSelected())
				res++;
		return res;
	}

	public List<BotonCarta> getBotonesActivos() {
		List<BotonCarta> res = Lists.newArrayList();
		for (BotonCarta tb : getSeleccion())
			if (tb.isSelected())
				res.add(tb);
		return res;
	}

		public void stateChanged(ChangeEvent e) {
			BotonSeleccionJugador sel = (BotonSeleccionJugador) e.getSource();
			for (BotonCarta b : mm.get(sel)) {
				b.setEnabled(sel.isSelected());
				if (!sel.equals(seleccionado))
					b.setSelected(false);
			}
			if (sel.isSelected())
				seleccionado = sel;
		}
	

}
