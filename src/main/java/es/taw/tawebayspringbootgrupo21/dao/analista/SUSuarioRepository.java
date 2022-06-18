package es.taw.tawebayspringbootgrupo21.dao.analista;

import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by shazi on 1/11/2017.
 */

public interface SUSuarioRepository {

    public Object findSUSsuarioByUserId(Integer UserId);

}