package es.taw.tawebayspringbootgrupo21.dao.analista;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class SUSuarioRepositoryImpl implements SUSuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Object findSUSsuarioByUserId(Integer id) {
        final String jpql = "select u from Usuario u where u.userId=2";
        Query query = entityManager.createQuery(jpql);

        return query.getSingleResult();
    }
}