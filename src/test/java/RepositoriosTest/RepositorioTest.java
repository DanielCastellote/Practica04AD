package RepositoriosTest;

import dao.Repositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.RepositorioRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepositorioTest {

    RepositorioRepository repository = new RepositorioRepository();

    List<Repositorio> repositorios = new ArrayList<>();
    Repositorio r1 = new Repositorio();
    Repositorio r2 = new Repositorio();
    Repositorio r3 = new Repositorio();
    Repositorio r4 = new Repositorio();


    @Test
    void findAllTest() {
        repositorios.add(r1);
        repositorios.add(r2);
        repositorios.add(r3);
        repositorios.add(r4);
        int numero = repository.findAll().size();
        Assertions.assertEquals(numero, repositorios.size());
    }

    @Test
    void findByIdTest() throws SQLException {
        Repositorio repositorio = repository.getById(15L);
        Repositorio repositorioNotFound = repository.getById(14L);
        assertTrue(repositorio!=null);
        assertFalse(repositorioNotFound==null);
    }

    @Test
    void saveTest() throws SQLException {
        Repositorio repositorio = new Repositorio();
        Assertions.assertEquals(repositorio, repository.save(repositorio));
    }

    @Test
    void updateTest() throws SQLException {
        Repositorio repositorio = new Repositorio();
        Assertions.assertEquals(repositorio, repository.update(repositorio));
    }

    @Test
    void deleteTest() throws SQLException {
        Repositorio repositorio = repository.getById(15L);
        Repositorio repositorioOptional  = repository.delete(repositorio);
        Assertions.assertEquals(repositorioOptional.getId(),repositorio.getId());
    }
}
