package es.taw.tawebayspringbootgrupo21.dao;

import es.taw.tawebayspringbootgrupo21.entity.Categoria;
import es.taw.tawebayspringbootgrupo21.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p from Producto p where p.productId=:productId")
    Producto findProductoById(@Param("productId") Integer productId);

    @Query("SELECT p from Producto p where p.titulo LIKE CONCAT('%', :search, '%')")
    List<Producto> searchProductos(@Param("search") String search);
}