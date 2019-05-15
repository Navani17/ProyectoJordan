package persistencia;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateLenteDAO;
import gradle.cucumber.Lente;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.InventarioService;
import service.runner.SessionFactoryProvider;

public class TestLenteDao {

    private InventarioService service;

    private Lente lente;

    @Before
    public void prepare(){
        lente = new Lente();
        lente.setModelo("ax200");
        lente.setPrecio(200);

        this.service = new InventarioService(new HibernateLenteDAO(), new HibernateDataDAO());
        this.service.guardarLente(lente);
    }

    @After
    public void cleanup() {
        SessionFactoryProvider.destroy();
    }

    @Test
    public void testUnLenteEnLaBase() {
        Lente lenteRecuperado = this.service.recuperarLente(lente.getId());

        Assert.assertEquals(lenteRecuperado.getModelo(), "ax200");
    }




}
