package es.taw.tawebayspringbootgrupo21.dao.marketing;
/*
Created by IntelliJ IDEA.
        User: zhang
        Date: 11/06/2022
 */
import es.taw.tawebayspringbootgrupo21.entity.UsuarioHasLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioHasListaRepository extends JpaRepository<UsuarioHasLista, Integer> {
    @Query("SELECT u FROM UsuarioHasLista u WHERE u.listaId =:listaId AND u.userId =:userId")
    UsuarioHasLista findByListaIdyUserId(@Param("listaId") Integer listaId, @Param("userId") Integer userId);

    @Query("SELECT uhl FROM UsuarioHasLista uhl WHERE uhl.listaId =:listaId")
    List<UsuarioHasLista> findByListaId(@Param("listaId") Integer listaId);
}
