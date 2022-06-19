package es.taw.tawebayspringbootgrupo21.dao.marketing;
/*
Created by IntelliJ IDEA.
        User: zhang
        Date: 11/06/2022
 */
import es.taw.tawebayspringbootgrupo21.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    @Query("SELECT n FROM Notificacion n WHERE n.receptor =:idU")
    List<Notificacion> findAllNotificacionesByUserId(@Param("idU") Integer idU);
}
