package repository;

import dao.Login;
import dao.Repositorio;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class LoginRepository implements CrudRepository<Login,Long>{

    @Override
    public List<Login> findAll() {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Login> query = hc.getManager().createNamedQuery("Login.findAll", Login.class);
        List<Login> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Login getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Login login = hc.getManager().find(Login.class, ID);
        hc.close();
        if (login != null)
            return login;
        throw new SQLException("Error LoginRepository no existe login con ID: " + ID);
    }

    @Override
    public Login save(Login login) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(login);
            hc.getTransaction().commit();
            return login;
        } catch (Exception e) {
            throw new SQLException("Error LoginRepository al insertar login en BD:" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Login update(Login login) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(login);
            hc.getTransaction().commit();
            return login;
        } catch (Exception e) {
            throw new SQLException("Error LoginRepository al actualizar login con id: " + login.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }

    }

    @Override
    public Login delete(Login login) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            login = hc.getManager().find(Login.class, login.getId());
            hc.getManager().remove(login);
            hc.getTransaction().commit();
            return login;
        } catch (Exception e) {
            throw new SQLException("Error LoginRepository al eliminar login con id: " + login.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
