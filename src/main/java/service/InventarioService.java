package service;

import dao.DataDAO;
import dao.LenteDAO;
import dao.impl.HibernateLenteDAO;
import gradle.cucumber.Lente;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.Collection;

import static service.runner.TransactionRunner.run;

public class InventarioService {
	
	private LenteDAO lenteDAO;
	private DataDAO dataDAO;
	
	public InventarioService(HibernateLenteDAO lenteDao, DataDAO dataDAO) {
		this.lenteDAO = lenteDao;
		this.dataDAO = dataDAO;
	}

	public void guardarLente(Lente lente) {
		run(() -> {
			this.lenteDAO.guardar(lente);
		});
	}

	public Lente recuperarLente(Long lenteID) {
		return run(() ->
				this.lenteDAO.recuperar(lenteID));
	}


	public void clear() {
		run(() -> this.dataDAO.clear());
	}
	
	
}
