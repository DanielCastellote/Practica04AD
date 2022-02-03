package manager;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

    @Getter
    public class HibernateController {
        private static HibernateController controller;

        private EntityManagerFactory entityManagerFactory;
        private EntityManager manager;
        private EntityTransaction transaction;

        private HibernateController() {
        }

        public static HibernateController getInstance() {
            if (controller == null)
                controller = new HibernateController();
            return controller;
        }

        public void open() {
            if(entityManagerFactory == null || !entityManagerFactory.isOpen())
                entityManagerFactory = Persistence.createEntityManagerFactory("default");
            if(manager == null || !manager.isOpen())
                manager = entityManagerFactory.createEntityManager();

            transaction = manager.getTransaction();
        }

        public void close() {
            manager.close();
            entityManagerFactory.close();
        }
    }