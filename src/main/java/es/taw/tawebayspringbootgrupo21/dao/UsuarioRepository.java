package es.taw.tawebayspringbootgrupo21.dao;

import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.rolId = 1 AND u.userId NOT IN :compradoresLista ")
    List<Usuario> fingByRolIdgetCompradoresDisponibles(@Param("compradoresLista") List<Integer> compradoresLista);

    @Query("SELECT u FROM Usuario u WHERE u.rolId = 1")
    List<Usuario> findByGetCompradores();

    Usuario findByUserId(Integer i);

    Object findSUSsuarioByUserId(Integer userId);
}
