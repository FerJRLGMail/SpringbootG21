package es.taw.tawebayspringbootgrupo21.controller.comprador;

import es.taw.tawebayspringbootgrupo21.dao.comprador.ProdFavoritosRepository;
import es.taw.tawebayspringbootgrupo21.dao.comprador.ProductoRepository;
import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.entity.ProdFavoritos;
import es.taw.tawebayspringbootgrupo21.entity.Producto;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListaProductoController {
    @Autowired
    private ProductoRepository pr;
    @Autowired
    private UsuarioRepository ur;
    @Autowired
    private ProdFavoritosRepository pfr;

    @GetMapping("/back/{userid}")
    public String back(Model model, @PathVariable("userid") Integer userid) {
        Usuario user = this.ur.findByUserId(userid);
        model.addAttribute("usuario", user);
        return "welcome";
    }

    @GetMapping("/listaProducto/{userid}")
    public String getListaProducto(Model model, @PathVariable("userid") Integer userid) {
        String strError = "";
        List<Producto> productoList = this.pr.findAll();
        if (productoList.isEmpty()) {
            strError = "error";
        }
        Usuario user = this.ur.findByUserId(userid);
        model.addAttribute("user", user);
        model.addAttribute("productoList", productoList);
        model.addAttribute("strError", strError);
        return "listaProducto";
    }

    @GetMapping("/listaproductoFavorito/{userid}")
    public String getListaProductoFavorito(Model model, @PathVariable("userid") Integer userid) {
        String strError = "";
        Usuario user = this.ur.findByUserId(userid);
        model.addAttribute("user", user);

        List<ProdFavoritos> prodFavoritos = this.pfr.findProdFavoritosByCompradorId(userid);
        if (prodFavoritos.isEmpty()) {
            strError = "error";
        }
        model.addAttribute("prodFavoritos", prodFavoritos);
        model.addAttribute("strError", strError);
        return "listaProductoFavorito";
    }

    @GetMapping("/listaproductoComprado/{userid}")
    public String getListaProductoComprado(Model model, @PathVariable("userid") Integer userid) {
        String strError = "";
        Usuario user = this.ur.findByUserId(userid);
        model.addAttribute("user", user);
        List<Producto> productoList = new ArrayList<>();
        productoList = (List<Producto>) user.getProductosByUserId();
        if (productoList.isEmpty()) {
            strError = "error";
        }
        model.addAttribute("strError", strError);
        model.addAttribute("prodComprado", productoList);
        return "listaProductoComprado";
    }

    @GetMapping("/addproducto/{userid}/{productId}")
    public String addProducto(Model model, @PathVariable("userid") Integer userid, @PathVariable("productId") Integer productId) {
        Usuario user = this.ur.findByUserId(userid);
        model.addAttribute("user", user);
        Producto producto = this.pr.findProductoById(productId);

        ProdFavoritos prodFavoritos = new ProdFavoritos();
        prodFavoritos.setUsuarioByCompradorId(user);
        prodFavoritos.setProductoByProductId(producto);

        this.pfr.save(prodFavoritos);


        return "redirect:/listaProducto/" + userid + "";
    }

    @GetMapping("/search/productos/{userid}")
    public String searchproductos(Model model, HttpSession session, @PathVariable("userid") Integer userid, @RequestParam("search") String search) {
        String strError = "";
        Usuario user = this.ur.findByUserId(userid);
        model.addAttribute("user", user);
        List<Producto> productoList = this.pr.searchProductos(search);
        if (productoList.isEmpty()) {
            strError = "error";
        }
        model.addAttribute("strError", strError);
        model.addAttribute("productoList", productoList);
        return "searchResults";


    }
}