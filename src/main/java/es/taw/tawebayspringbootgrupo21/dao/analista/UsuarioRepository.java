package es.taw.tawebayspringbootgrupo21.dao.analista;

import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>, SUSuarioRepository {
    Usuario findByEmail(String email);

    @Query("SELECT u from Usuario u where u.rolId= 1")
    List<Usuario> fingByRolIdgetCompradores();
    
    Usuario findByUserId(Integer i);
}
