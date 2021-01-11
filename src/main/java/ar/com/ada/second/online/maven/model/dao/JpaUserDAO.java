package ar.com.ada.second.online.maven.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class JpaUserDAO extends JPA implements DAO<UserDAO>{

    private static JpaUserDAO jpaUserDAO;


    private JpaUserDAO(){

    }

    public static JpaUserDAO getInstance(){
        if (jpaUserDAO == null) jpaUserDAO = new JpaUserDAO();
        return jpaUserDAO;
    }
    
    public void findByEmailOrNickname(String email, String nickname) throws Exception {
    openConnection();
    // SELECT * FROM User WHERE email=? OR nickname=?
        TypedQuery<UserDAO> query = entityManager.createQuery(
                "SELECT u FROM UserDAO u WHERE u.email =:email OR u.nickname =:nickname",
                UserDAO.class
        );
        query.setParameter("email", email);
        query.setParameter("nickname", nickname);

        Optional<UserDAO> byEmailAndNickname = query.getResultList().stream().findFirst();

        closeConnection();

        if (byEmailAndNickname.isPresent()){
            throw new Exception("Ya existe un usuario con ese email y/o nickname");
        }
    }

    @Override
    public void save(UserDAO userDAO) {
        Consumer<EntityManager> persistUser = entityManager -> entityManager.persist(userDAO);
        executeInsideTransaction(persistUser);
    }

    @Override
    public Integer  getTotalRecords() {
        openConnection();
        Object singleResult = entityManager.createNativeQuery("SELECT COUNT(*) FROM User").getSingleResult();
        Integer count = singleResult != null ? Integer.parseInt(singleResult.toString()) : 0;

        closeConnection();
        return count;
    }

    public List<UserDAO> findAll(Integer from, Integer limit) {
        openConnection();
        TypedQuery<UserDAO> query = entityManager.createQuery("SELECT u FROM UserDAO u", UserDAO.class);
        query.setFirstResult(from);
        query.setMaxResults(limit);
        List<UserDAO> list = query.getResultList();

        closeConnection();
        return list;
    }
}
