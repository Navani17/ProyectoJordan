package dao.impl;

import dao.LenteDAO;
import gradle.cucumber.Lente;



public class HibernateLenteDAO extends HibernateDAO<Lente> implements LenteDAO {

    public HibernateLenteDAO() {
        super(Lente.class);
    }

}
