package RepositoriosTest;

import dao.Departamento;
import dao.Programador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.DepartamentoRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepartamentoTest {

    DepartamentoRepository repository = new DepartamentoRepository();

    List<Departamento> departamentos = new ArrayList<>();
    Departamento r1 = new Departamento();
    Departamento r2 = new Departamento();
    Departamento r3 = new Departamento();
    Departamento r4 = new Departamento();



    @Test
    void findAllTest() {
        departamentos.add(r1);
        departamentos.add(r2);
        departamentos.add(r3);
        departamentos.add(r4);
        int numero = repository.findAll().size();
        Assertions.assertEquals(numero, departamentos.size());
    }

    @Test
    void findByIdTest() throws SQLException {
        Departamento departamento = repository.getById(2L);
        Departamento departamentoNotFound = repository.getById(3L);
        assertTrue(departamento!=null);
        assertFalse(departamentoNotFound==null);
    }

    @Test
    void saveTest() throws SQLException {
        Departamento departamento = new Departamento("Hola",222,333);
        Assertions.assertEquals(departamento, repository.save(departamento));
    }

    @Test
    void updateTest() throws SQLException {
        Departamento departamento = new Departamento("Prueba",777,888);
        Assertions.assertEquals(departamento, repository.update(departamento));
    }

    @Test
    void deleteTest() throws SQLException {
        Departamento departamento = repository.getById(1L);
        Departamento departamentoOptional  = repository.delete(departamento);
        Assertions.assertEquals(departamentoOptional.getId(),departamento.getId());
    }
}
