package RepositoriosTest;

import dao.Repositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.RepositorioRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioTest {

    RepositorioRepository repository = new RepositorioRepository();

    @Test
    void findAllTest() {
        List<Repositorio> repositorios = new ArrayList<>();
        Assertions.assertEquals(repositorios, repository.findAll());
    }

    @Test
    void findByIdTest() throws SQLException {
        Repositorio repositorio = new Repositorio();
        Assertions.assertEquals(repositorio.getId(), repository.getById(repositorio.getId()));
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
        Repositorio repositorio = new Repositorio();
        Assertions.assertEquals(repositorio, repository.delete(repositorio));
    }
}
