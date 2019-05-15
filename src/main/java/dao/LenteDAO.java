package dao;

import gradle.cucumber.Lente;


/**
 * Tiene la responsabilidad de guardar y recuperar items desde
 * el medio persistente
 */
public interface LenteDAO {


	void guardar(Lente personaje);

	Lente recuperar(Long id);
}
