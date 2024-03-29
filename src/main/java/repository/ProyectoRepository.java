package repository;

import dao.Departamento;
import dao.Proyecto;
import dao.Repositorio;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class ProyectoRepository implements CrudRepository<Proyecto,Long>{

    @Override
    public List<Proyecto> findAll() {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Proyecto> query = hc.getManager().createNamedQuery("Proyecto.findAll", Proyecto.class);
        List<Proyecto> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Proyecto getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Proyecto proyecto = hc.getManager().find(Proyecto.class, ID);
        hc.close();
        if (proyecto != null)
            return proyecto;
        throw new SQLException("Error ProyectoRepository no existe proyecto con ID: " + ID);
    }

    @Override
    public Proyecto save(Proyecto proyecto) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(proyecto);
            hc.getTransaction().commit();
            return proyecto;
        } catch (Exception e) {
            throw new SQLException("Error ProyectoRepository al insertar proyecto en BD:" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Proyecto update(Proyecto proyecto) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(proyecto);
            hc.getTransaction().commit();
            return proyecto;
        } catch (Exception e) {
            throw new SQLException("Error ProyectoRepository al actualizar proyecto con id: " + proyecto.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }

    }

    @Override
    public Proyecto delete(Proyecto proyecto) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            proyecto = hc.getManager().find(Proyecto.class, proyecto.getId());
            hc.getManager().remove(proyecto);
            hc.getTransaction().commit();
            return proyecto;
        } catch (Exception e) {
            throw new SQLException("Error ProyectoRepository al eliminar proyecto con id: " + proyecto.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
