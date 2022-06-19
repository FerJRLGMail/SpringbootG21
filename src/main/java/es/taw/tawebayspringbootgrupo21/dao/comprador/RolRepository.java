package es.taw.tawebayspringbootgrupo21.dao.comprador;

import es.taw.tawebayspringbootgrupo21.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query("SELECT u from Rol u where u.rolId=:rolId")
    Rol findRolById(@Param("rolId") Integer rolId);
}