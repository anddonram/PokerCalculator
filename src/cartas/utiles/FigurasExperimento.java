package cartas.utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import cartas.tipos.Baraja;
import cartas.tipos.Figura;
import cartas.tipos.Jugador;

public class FigurasExperimento {
	public static final Integer MAX = 51;

	public static List<Integer[]> todasLasPosibilidades() {
		Integer[] n = new Integer[5];
		List<Integer[]> total = new ArrayList<Integer[]>();
		for (Integer e = 0; e <= MAX; e++) {
			n[0] = e;
			for (Integer d = e + 1; d <= MAX; d++) {
				n[1] = d;
				for (Integer c = d + 1; c <= MAX; c++) {
					n[2] = c;
					for (Integer b = c + 1; b <= MAX; b++) {
						n[3] = b;
						for (Integer a = b + 1; a <= MAX; a++) {
							n[4] = a;
							Integer[] k = n.clone();
							total.add(k);
						}
					}
				}
			}
		}
		return total;
	}

	public static List<Integer[]> posibilidadesDeBaraja(Baraja baraja) {
		List<Integer[]> total = new ArrayList<Integer[]>();
		Integer[] n = new Integer[5];
		for (Integer e = 0; e <= MAX; e++) {
			if (baraja.contiene(e)) {
				n[0] = e;
				for (Integer d = e + 1; d <= MAX; d++) {
					if (baraja.contiene(d)) {
						n[1] = d;
						for (Integer c = d + 1; c <= MAX; c++) {
							if (baraja.contiene(c)) {
								n[2] = c;
								for (Integer b = c + 1; b <= MAX; b++) {
									if (baraja.contiene(b)) {
										n[3] = b;
										for (Integer a = b + 1; a <= MAX; a++) {
											if (baraja.contiene(a)) {
												n[4] = a;
												Integer[] k = n.clone();
												total.add(k);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return total;
	}

	public static List<Integer[]> estadisticaFigura(Figura f, Baraja b) {
		// Comunes
		List<Integer[]> todas = FigurasExperimento.posibilidadesDeBaraja(b);
		List<Integer[]> posibilidades = new ArrayList<Integer[]>();
		// Auxiliares
		Boolean esColor = true;
		Boolean esEscalera = true;
		Boolean esDoblePareja = false;
		List<Integer[]> posibilidadesAux = new ArrayList<Integer[]>();
		switch (f) {
		case PAREJA:// pareja+doble pareja+full
			for (Integer[] aint : todas) {
				Integer[] aux = { aint[0] % 13, aint[1] % 13, aint[2] % 13,
						aint[3] % 13, aint[4] % 13 };
				List<Integer> aux2 = Arrays.asList(aux);
				for (Integer i : aux2) {
					if (Collections.frequency(aux2, i) == 2) {
						posibilidades.add(aint.clone());
						break;
					}
				}
			}
			break;
		case DOBLE_PAREJA: // correcto
			for (Integer[] aint : todas) {
				Integer[] aux = { aint[0] % 13, aint[1] % 13, aint[2] % 13,
						aint[3] % 13, aint[4] % 13 };
				List<Integer> aux2 = Arrays.asList(aux);
				for (Integer i : aux2) {
					for (Integer k : aux2) {
						esDoblePareja = i != k
								&& Collections.frequency(aux2, i) == 2
								&& Collections.frequency(aux2, k) == 2;
						if (esDoblePareja)
							break;
					}
					if (esDoblePareja) {
						posibilidades.add(aint.clone());
						break;
					}
				}
			}
			break;
		case TRIO:// Trio+Full
			for (Integer[] aint : todas) {
				Integer[] aux = { aint[0] % 13, aint[1] % 13, aint[2] % 13,
						aint[3] % 13, aint[4] % 13 };
				List<Integer> aux2 = Arrays.asList(aux);
				for (Integer i : aux2) {
					if (Collections.frequency(aux2, i) == 3) {
						posibilidades.add(aint.clone());
						break;
					}
				}
			}
			break;
		case ESCALERA:// escalera+escalera de color
			for (Integer[] aint : todas) {
				Integer[] aux = { aint[0] % 13, aint[1] % 13, aint[2] % 13,
						aint[3] % 13, aint[4] % 13 };
				Arrays.sort(aux);
				if (aux[0] == 0 && aux[1] == 1 && aux[2] == 2 && aux[3] == 3
						&& aux[4] == 12) {
					esEscalera = true;
				} else
					for (Integer i = 0; i < 4; i++) {
						esEscalera = (aux[i].equals(aux[i + 1] - 1));
						if (!esEscalera)
							break;
					}
				if (esEscalera) {
					posibilidades.add(aint.clone());
				}
			}
			break;
		case COLOR:// Color+escalera de color
			for (Integer[] aint : todas) {
				Integer[] aux = { aint[0] / 13, aint[1] / 13, aint[2] / 13,
						aint[3] / 13, aint[4] / 13 };
				for (Integer i = 0; i < 4; i++) {
					esColor = aux[i].equals(aux[i + 1]);
					if (!esColor)
						break;
				}
				if (esColor)
					posibilidades.add(aint.clone());
			}
			break;
		case FULL:// correcto
			for (Integer[] aint : todas) {
				Integer[] aux = { aint[0] % 13, aint[1] % 13, aint[2] % 13,
						aint[3] % 13, aint[4] % 13 };
				List<Integer> aux2 = Arrays.asList(aux);
				for (Integer i : aux2) {
					if (Collections.frequency(aux2, i) == 2) {
						posibilidadesAux.add(aint.clone());
						break;
					}
				}
			}
			for (Integer[] aint : posibilidadesAux) {
				Integer[] aux = { aint[0] % 13, aint[1] % 13, aint[2] % 13,
						aint[3] % 13, aint[4] % 13 };
				List<Integer> aux2 = Arrays.asList(aux);
				for (Integer i : aux2) {
					if (Collections.frequency(aux2, i) == 3) {
						posibilidades.add(aint.clone());
						break;
					}
				}
			}
			break;
		case POKER:// Correcto, dos soluciones efectivas
			for (Integer[] aint : todas) {
				List<Integer> aux = Arrays.asList(aint);
				for (int i = 0; i <= 12; i++)
					if (aux.contains(i) && aux.contains(i + 13)
							&& aux.contains(i + 26) && aux.contains(i + 39)) {
						posibilidades.add(aint.clone());
					}
			}
			// for (Integer[] aint : todas) {
			// Integer[] aux = { aint[0] % 13, aint[1] % 13, aint[2] % 13,
			// aint[3] % 13, aint[4] % 13 };
			// List<Integer> aux2 = Arrays.asList(aux);
			// for (Integer i : aux2) {
			// if (Collections.frequency(aux2, i) == 4) {
			// posibilidades.add(aint.clone());
			// break;
			// } } }
			break;
		case ESCALERA_DE_COLOR:// correcto
			for (Integer[] aint : todas) {
				Integer[] aux = { aint[0] / 13, aint[1] / 13, aint[2] / 13,
						aint[3] / 13, aint[4] / 13 };
				for (Integer i = 0; i < 4; i++) {
					esColor = aux[i].equals(aux[i + 1]);
					if (!esColor)
						break;
				}
				if (esColor)
					posibilidadesAux.add(aint.clone());
			}
			for (Integer[] aint : posibilidadesAux) {
				Integer[] aux = { aint[0] % 13, aint[1] % 13, aint[2] % 13,
						aint[3] % 13, aint[4] % 13 };
				Arrays.sort(aux);
				if (aux[0] == 0 && aux[1] == 1 && aux[2] == 2 && aux[3] == 3
						&& aux[4] == 12) {
					esEscalera = true;
				} else
					for (Integer i = 0; i < 4; i++) {
						esEscalera = (aux[i].equals(aux[i + 1] - 1));
						if (!esEscalera)
							break;
					}
				if (esEscalera) {
					posibilidades.add(aint.clone());
				}
			}
			break;
		default:
			break;
		}
		return posibilidades;
	}

	public static List<List<Integer[]>> posibilidadesDescarte(Baraja baraja,
			Jugador j, Integer numeroDescarte) {
		List<List<Integer[]>> res = new ArrayList<List<Integer[]>>();
		List<Integer[]> total = new ArrayList<Integer[]>();
		Integer[] n = new Integer[5];
		List<SortedSet<Integer>> totalAux = new ArrayList<SortedSet<Integer>>();
		Set<Integer> naux = new HashSet<Integer>();
		System.out.println("Empieza");
		Long inicio = System.currentTimeMillis();
		switch (numeroDescarte) {
		case 5:
			for (Integer e = 0; e <= MAX; e++) {
				if (baraja.getBaraja().contains(e)) {
					n[0] = e;
					for (Integer d = e + 1; d <= MAX; d++) {
						if (baraja.getBaraja().contains(d)) {
							n[1] = d;
							for (Integer c = d + 1; c <= MAX; c++) {
								if (baraja.getBaraja().contains(c)) {
									n[2] = c;
									for (Integer b = c + 1; b <= MAX; b++) {
										if (baraja.getBaraja().contains(b)) {
											n[3] = b;
											for (Integer a = b + 1; a <= MAX; a++) {
												if (baraja.getBaraja()
														.contains(a)) {
													n[4] = a;
													Integer[] k = n.clone();
													total.add(k);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			break;
		case 4:
			for (Integer e : j.getMano()) {
				naux.add(e);
				for (Integer d = 0; d <= MAX; d++) {
					if (baraja.getBaraja().contains(d)) {
						naux.add(d);
						for (Integer c = d + 1; c <= MAX; c++) {
							if (baraja.getBaraja().contains(c)
									&& naux.size() == 2) {
								naux.add(c);
								for (Integer b = c + 1; b <= MAX; b++) {
									if (baraja.getBaraja().contains(b)
											&& naux.size() == 3) {
										naux.add(b);
										for (Integer a = b + 1; a <= MAX; a++) {
											if (baraja.getBaraja().contains(a)
													&& naux.size() == 4) {
												naux.add(a);
												if (totalAux
														.add(new TreeSet<Integer>(
																naux))) {
													Integer[] k = { a, b, c, d,
															e };
													Arrays.sort(k);
													total.add(k);
												}
												naux.remove(a);
											}
										}
										naux.remove(b);
									}
								}
								naux.remove(c);
							}
						}
						naux.remove(d);
					}
				}
				naux.remove(e);
			}
			break;
		case 3:
			for (Integer e : j.getMano()) {
				naux.add(e);
				for (Integer d : j.getMano()) {
					naux.add(d);
					for (Integer c = 0; c <= MAX; c++) {
						if (baraja.getBaraja().contains(c) && naux.size() == 2) {
							naux.add(c);
							for (Integer b = c + 1; b <= MAX; b++) {
								if (baraja.getBaraja().contains(b)
										&& naux.size() == 3) {
									naux.add(b);
									for (Integer a = b + 1; a <= MAX; a++) {
										if (baraja.getBaraja().contains(a)
												&& naux.size() == 4) {
											naux.add(a);
											if (totalAux
													.add(new TreeSet<Integer>(
															naux))) {
												Integer[] k = { a, b, c, d, e };
												Arrays.sort(k);
												total.add(k);
											}
											naux.remove(a);
										}
									}
									naux.remove(b);
								}
							}
							naux.remove(c);
						}
					}
					naux.remove(d);
				}
				naux.remove(e);
			}
			break;
		case 2:
			for (Integer e : j.getMano()) {
				naux.add(e);
				for (Integer d : j.getMano()) {
					naux.add(d);
					for (Integer c : j.getMano()) {
						if (naux.size() == 2) {
							naux.add(c);
							for (Integer b = 0; b <= MAX; b++) {
								if (baraja.getBaraja().contains(b)
										&& naux.size() == 3) {
									naux.add(b);
									for (Integer a = b + 1; a <= MAX; a++) {
										if (baraja.getBaraja().contains(a)
												&& naux.size() == 4) {
											naux.add(a);
											if (totalAux
													.add(new TreeSet<Integer>(
															naux))) {
												Integer[] k = { a, b, c, d, e };
												Arrays.sort(k);
												total.add(k);
											}
											naux.remove(a);
										}
									}
									naux.remove(b);
								}
							}
							naux.remove(c);
						}
					}
					naux.remove(d);
				}
				naux.remove(e);
			}
			break;
		case 1:
			for (Integer e : j.getMano()) {
				naux.add(e);
				for (Integer d : j.getMano()) {
					naux.add(d);
					for (Integer c : j.getMano()) {
						if (naux.size() == 2) {
							naux.add(c);
							for (Integer b : j.getMano()) {
								if (naux.size() == 3) {
									naux.add(b);
									for (Integer a = 0; a <= MAX; a++) {
										if (baraja.getBaraja().contains(a)
												&& naux.size() == 4) {
											naux.add(a);
											if (totalAux
													.add(new TreeSet<Integer>(
															naux))) {
												Integer[] k = { a, b, c, d, e };
												Arrays.sort(k);
												total.add(k);
											}
											naux.remove(a);
										}
									}
									naux.remove(b);
								}
							}
							naux.remove(c);
						}
					}
					naux.remove(d);
				}
				naux.remove(e);
			}
			break;
		default:
			break;
		}
		Double fin = (System.currentTimeMillis() - inicio) / 1000d;
		System.out.println(total.size() + " tiempo empleado en segundos: "
				+ fin);
		return res;
	}
}