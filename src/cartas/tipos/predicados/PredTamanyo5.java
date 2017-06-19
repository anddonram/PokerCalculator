package cartas.tipos.predicados;

import java.util.Set;

import com.google.common.base.Predicate;

public class PredTamanyo5 implements Predicate<Set<Integer>> {

	public boolean apply(Set<Integer> s) {
		return s.size()==5;
	}

}
