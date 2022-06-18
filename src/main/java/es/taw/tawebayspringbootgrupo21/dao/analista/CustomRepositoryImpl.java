package es.taw.tawebayspringbootgrupo21.dao.analista;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CustomRepositoryImpl implements CustomRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String CheckQuery(String strq) {
        String respuesta;
        String keyword = strq.split(" ")[0].toUpperCase();

        if(!"SELECT".equals(keyword)) {
            respuesta = "ERROR: Solo puedes usar sentencias del tipo SELECT";
        } else {
            respuesta = "Query valida";
        }

        try {
            Query q = entityManager.createQuery(strq);
        } catch (Exception e) {
            respuesta = e.getMessage();
        }

        return respuesta;
    }

    @Override
    public java.util.List QueryOnDemand(String strq) {
        Query q = this.entityManager.createQuery(strq);
        java.util.List list = q.getResultList();

        //mirar si la lista de datos esta hecha de arrays, o de cualquier cosa que no es un array
        //si no esta hecha de arrays, pues lo que pasamos es un clon de esa lista con todo metido en un array

        if(!list.isEmpty()) {
            if(!list.get(0).getClass().isArray()) {
                //convertir esto en un array
                for (int i=0;i<list.size();i++) {
                    Object[] arrayo = {list.get(i)};
                    list.set(i, arrayo);
                }
            }
        }

        return list;
    }
}
