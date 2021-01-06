package ar.com.ada.second.online.maven.model.dao;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

public class JpaUserDAO extends JPA implements DAO<UserDAO>{

    private static JpaUserDAO jpaUserDAO;


    private JpaUserDAO(){

    }

    public static JpaUserDAO getInstance(){
        if (jpaUserDAO == null) jpaUserDAO = new JpaUserDAO();
        return jpaUserDAO;
    }
    @Override
    public void save(UserDAO userDAO) {
        Consumer<EntityManager> persistUser = entityManager -> entityManager.persist(userDAO);
        executeInsideTransaction(persistUser);
    }
}
