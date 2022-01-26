package repository;

import dao.Commit;
import dao.Departamento;
import dao.Repositorio;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class CommitRepository implements CrudRepository<Commit,Long>{

    @Override
    public List<Commit> findAll() {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Commit> query = hc.getManager().createNamedQuery("Commit.findAll", Commit.class);
        List<Commit> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Commit getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Commit commit = hc.getManager().find(Commit.class, ID);
        hc.close();
        if (commit != null)
            return commit;
        throw new SQLException("Error CommitRepository no existe commit con ID: " + ID);
    }

    @Override
    public Commit save(Commit commit) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(commit);
            hc.getTransaction().commit();
            return commit;
        } catch (Exception e) {
            throw new SQLException("Error CommitRepository al insertar commit en BD:" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Commit update(Commit commit) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(commit);
            hc.getTransaction().commit();
            return commit;
        } catch (Exception e) {
            throw new SQLException("Error CommitRepository al actualizar commit con id: " + commit.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }

    }

    @Override
    public Commit delete(Commit commit) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            commit = hc.getManager().find(Commit.class, commit.getId());
            hc.getManager().remove(commit);
            hc.getTransaction().commit();
            return commit;
        } catch (Exception e) {
            throw new SQLException("Error CommitRepository al eliminar commit con id: " + commit.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
