package RepositoriosTest;

import dao.Departamento;
import dao.Proyecto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.DepartamentoRepository;
import repository.ProyectoRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProyectoTest {

    ProyectoRepository repository = new ProyectoRepository();

    List<Proyecto> proyectos = new ArrayList<>();
    Proyecto r1 = new Proyecto();
    Proyecto r2 = new Proyecto();
    Proyecto r3 = new Proyecto();
    Proyecto r4 = new Proyecto();


    @Test
    void findAllTest() {
        proyectos.add(r1);
        proyectos.add(r2);
        proyectos.add(r3);
        proyectos.add(r4);
        int numero = repository.findAll().size();
        Assertions.assertEquals(numero, proyectos.size());
    }

    @Test
    void findByIdTest() throws SQLException {
        Proyecto proyecto = repository.getById(7L);
        Proyecto proyectoNotFound = repository.getById(8L);
        assertTrue(proyecto!=null);
        assertFalse(proyectoNotFound==null);
    }

    @Test
    void saveTest() throws SQLException {
        Departamento d1 = new Departamento("Test",444,444);
        DepartamentoRepository departamentoRepository = new DepartamentoRepository();
        departamentoRepository.save(d1);
        Proyecto proyecto = new Proyecto("Hola",222,d1);
        Assertions.assertEquals(proyecto, repository.save(proyecto));
    }

    @Test
    void updateTest() throws SQLException {
        Departamento d1 = new Departamento("Test",444,444);
        DepartamentoRepository departamentoRepository = new DepartamentoRepository();
        departamentoRepository.save(d1);
        Proyecto proyecto = new Proyecto("Prueba",777,d1);
        Assertions.assertEquals(proyecto, repository.update(proyecto));
    }

    @Test
    void deleteTest() throws SQLException {
        Proyecto proyecto = repository.getById(6L);
        Proyecto proyectoOptional  = repository.delete(proyecto);
        Assertions.assertEquals(proyectoOptional.getId(),proyecto.getId());
    }
}
