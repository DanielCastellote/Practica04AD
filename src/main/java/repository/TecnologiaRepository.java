package repository;

import dao.Repositorio;
import dao.Tecnologia;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class TecnologiaRepository implements CrudRepository<Tecnologia,Long>{
    @Override
    public List<Tecnologia> findAll() throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Tecnologia> query = hc.getManager().createNamedQuery("Tecnologia.findAll", Tecnologia.class);
        List<Tecnologia> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Tecnologia getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Tecnologia tecnologia = hc.getManager().find(Tecnologia.class, ID);
        hc.close();
        if (tecnologia != null)
            return tecnologia;
        throw new SQLException("Error TecnologiaRepository no existe tecnologia con ID: " + ID);
    }

    @Override
    public Tecnologia save(Tecnologia tecnologia) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(tecnologia);
            hc.getTransaction().commit();
            return tecnologia;
        } catch (Exception e) {
            throw new SQLException("Error TecnologiaRepository al insertar tecnologia en BD:" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Tecnologia update(Tecnologia tecnologia) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(tecnologia);
            hc.getTransaction().commit();
            return tecnologia;
        } catch (Exception e) {
            throw new SQLException("Error TecnologiaRepository al actualizar repositorio con id: " + tecnologia.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Tecnologia delete(Tecnologia tecnologia) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            tecnologia = hc.getManager().find(Tecnologia.class, tecnologia.getId());
            hc.getManager().remove(tecnologia);
            hc.getTransaction().commit();
            return tecnologia;
        } catch (Exception e) {
            throw new SQLException("Error TecnologiaRepository al eliminar repositorio con id: " + tecnologia.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
