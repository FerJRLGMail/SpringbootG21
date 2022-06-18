package es.taw.tawebayspringbootgrupo21.dao.analista;


import es.taw.tawebayspringbootgrupo21.entity.Estudios;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstudiosRepository extends JpaRepository<Estudios, Integer>, CustomRepository {

    public List<Estudios> findEstudiosByUsuarioByAnalistaId (Usuario u);
}
