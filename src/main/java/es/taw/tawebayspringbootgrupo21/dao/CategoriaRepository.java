package es.taw.tawebayspringbootgrupo21.dao;

import es.taw.tawebayspringbootgrupo21.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query("SELECT u from Categoria u where u.catId=:catId")
    Categoria findCatById(@Param("catId") Integer catId);
}