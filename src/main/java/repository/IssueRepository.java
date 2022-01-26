package repository;

import dao.Commit;
import dao.Issue;
import dao.Repositorio;
import manager.HibernateController;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class IssueRepository implements CrudRepository<Issue,Long>{

    @Override
    public List<Issue> findAll() {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Issue> query = hc.getManager().createNamedQuery("Issue.findAll", Issue.class);
        List<Issue> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Issue getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Issue issue = hc.getManager().find(Issue.class, ID);
        hc.close();
        if (issue != null)
            return issue;
        throw new SQLException("Error IssueRepository no existe issue con ID: " + ID);
    }

    @Override
    public Issue save(Issue issue) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(issue);
            hc.getTransaction().commit();
            return issue;
        } catch (Exception e) {
            throw new SQLException("Error IssueRepository al insertar issue en BD:" + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Issue update(Issue issue) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(issue);
            hc.getTransaction().commit();
            return issue;
        } catch (Exception e) {
            throw new SQLException("Error IssueRepository al actualizar issue con id: " + issue.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }

    }

    @Override
    public Issue delete(Issue issue) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            issue = hc.getManager().find(Issue.class, issue.getId());
            hc.getManager().remove(issue);
            hc.getTransaction().commit();
            return issue;
        } catch (Exception e) {
            throw new SQLException("Error IssueRepository al eliminar issue con id: " + issue.getId() + ": " + e.getMessage());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }
}
