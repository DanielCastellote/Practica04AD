package repository;

import dao.Departamento;
import dao.Repositorio;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class RepositorioRepository implements CrudRepository<Repositorio,Long>{

    @Override
    public List<Repositorio> findAll() {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Repositorio> query = hc.getManager().createNamedQuery("Repositorio.findAll", Repositorio.class);
        List<Repositorio> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Repositorio getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Repositorio repositorio = hc.getManager().find(Repositorio.class, ID);
        hc.close();
        if (repositorio != null)
            return repositorio;
        throw new SQLException("Error RepositorioRepository no existe repositorio con ID: " + ID);
    }

    @Override
    public Repositorio save(Repositorio repositorio) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(repositorio);
            hc.getTransaction().commit();
            return repositorio;
        } catch (Exception e) {
            throw new SQLException("Error RepositorioRepository al insertar repositorio en BD:" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Repositorio update(Repositorio repositorio) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(repositorio);
            hc.getTransaction().commit();
            return repositorio;
        } catch (Exception e) {
            throw new SQLException("Error RepositorioRepository al actualizar repositorio con id: " + repositorio.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }

    }

    @Override
    public Repositorio delete(Repositorio repositorio) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            repositorio = hc.getManager().find(Repositorio.class, repositorio.getId());
            hc.getManager().remove(repositorio);
            hc.getTransaction().commit();
            return repositorio;
        } catch (Exception e) {
            throw new SQLException("Error RepositorioRepository al eliminar repositorio con id: " + repositorio.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
