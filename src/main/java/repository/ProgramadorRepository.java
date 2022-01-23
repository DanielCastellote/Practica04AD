package repository;

import dao.Programador;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class ProgramadorRepository {
    @Override
    public List<Programador> findAll() {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Programador> query = hc.getManager().createNamedQuery("Programdador.findAll", Programador.class);
        List<Programador> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Programador getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Programador programador = hc.getManager().find(Programador.class, ID);
        hc.close();
        if (programador != null)
            return programador;
        throw new SQLException("Error ProgramadorRepository no existe programador con ID: " + ID);
    }

    @Override
    public Programador save(Programador programador) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(programador);
            hc.getTransaction().commit();
            return programador;
        } catch (Exception e) {
            throw new SQLException("Error ProgramadorRepository al insertar usuario en BD:" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Programador update(Programador programador) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(programador);
            hc.getTransaction().commit();
            return programador;
        } catch (Exception e) {
            throw new SQLException("Error ProgramadorRepository al actualizar usuario con id: " + programador.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }

    }

    @Override
    public Programador delete(Programador programador) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            // Ojo que borrar implica que estemos en la misma sesión y nos puede dar problemas, por eso lo recuperamos otra vez
            programador = hc.getManager().find(Programador.class, programador.getId());
            hc.getManager().remove(programador);
            hc.getTransaction().commit();
            return programador;
        } catch (Exception e) {
            throw new SQLException("Error ProgramadorRepository al eliminar usuario con id: " + programador.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    public Programador getByEmail(String programadorMail) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();

        Programador programador = hc.getManager().createNamedQuery("Programador.getByMail", Programador.class)
                .setParameter("email", programadorMail)
                .getSingleResult();
        hc.close();
        if (programador != null)
            return programador;

        throw new SQLException("Error UserRepository no existe usuario con Email: " + programadorMail);
    }
}