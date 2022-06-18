package es.taw.tawebayspringbootgrupo21.dao.marketing;

import es.taw.tawebayspringbootgrupo21.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
    Lista findByListaId(Integer id);

    @Query("SELECT l FROM Lista l WHERE l.nombre LIKE :clave")
    List<Lista> findByClave(@Param("clave") String clave);
}
