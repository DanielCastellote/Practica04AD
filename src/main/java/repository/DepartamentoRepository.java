package repository;

import dao.Departamento;
import dao.Programador;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class DepartamentoRepository implements CrudRepository<Departamento,Long>{

    @Override
    public List<Departamento> findAll() {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Departamento> query = hc.getManager().createNamedQuery("Departamento.findAll", Departamento.class);
        List<Departamento> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Departamento getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Departamento departamento = hc.getManager().find(Departamento.class, ID);
        hc.close();
        if (departamento != null)
            return departamento;
        throw new SQLException("Error DepartamentoRepository no existe departamento con ID: " + ID);
    }

    @Override
    public Departamento save(Departamento departamento) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(departamento);
            hc.getTransaction().commit();
            return departamento;
        } catch (Exception e) {
            throw new SQLException("Error DepartamentoRepository al insertar departamento en BD:" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Departamento update(Departamento departamento) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(departamento);
            hc.getTransaction().commit();
            return departamento;
        } catch (Exception e) {
            throw new SQLException("Error DepartamentoRepository al actualizar departamento con id: " + departamento.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }

    }

    @Override
    public Departamento delete(Departamento departamento) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            departamento = hc.getManager().find(Departamento.class, departamento.getId());
            hc.getManager().remove(departamento);
            hc.getTransaction().commit();
            return departamento;
        } catch (Exception e) {
            throw new SQLException("Error DepartamentoRepository al eliminar departamento con id: " + departamento.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
