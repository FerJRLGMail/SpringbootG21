package es.taw.tawebayspringbootgrupo21.dao.comprador;

import es.taw.tawebayspringbootgrupo21.entity.ProdFavoritos;
import es.taw.tawebayspringbootgrupo21.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ProdFavoritosRepository extends JpaRepository<ProdFavoritos, Integer> {

    @Query("SELECT u FROM ProdFavoritos u WHERE u.compradorId =:userId")
    List<ProdFavoritos> findProdFavoritosByCompradorId(@RequestParam("userId") Integer userId);

    ProdFavoritos save(ProdFavoritos prodFavoritos);

    @Query("SELECT u FROM ProdFavoritos u WHERE u.usuarioByCompradorId =:user")
    List<ProdFavoritos> findProdFavoritosByComprador(@RequestParam("user") Integer user);
}