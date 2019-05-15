package dao.impl;

import dao.DataDAO;
import service.runner.TransactionRunner;
import org.hibernate.Session;

import java.util.List;

public class HibernateDataDAO implements DataDAO {

    public void clear(){
        Session session = TransactionRunner.getCurrentSession();
        List<String> nombreDeTablas = session.createNativeQuery("show tables").getResultList();
        session.createNativeQuery("SET FOREIGN_KEY_CHECKS=0;").executeUpdate();
        nombreDeTablas.forEach(tabla->{
            session.createNativeQuery("truncate table " + tabla).executeUpdate();
        });
        session.createNativeQuery("SET FOREIGN_KEY_CHECKS=1;").executeUpdate();
    }
}
