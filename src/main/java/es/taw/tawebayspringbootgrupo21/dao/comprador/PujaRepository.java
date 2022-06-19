package es.taw.tawebayspringbootgrupo21.dao.comprador;

import es.taw.tawebayspringbootgrupo21.entity.Puja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PujaRepository extends JpaRepository<Puja, Integer> {
    @Query("SELECT u from Puja u where u.productId=:productId")
    List<Puja> findPujaByProductId(@Param("productId") Integer productId);
}