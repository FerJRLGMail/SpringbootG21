package es.taw.tawebayspringbootgrupo21.controller;

import es.taw.tawebayspringbootgrupo21.dao.ProductoRepository;
import es.taw.tawebayspringbootgrupo21.dao.PujaRepository;
import es.taw.tawebayspringbootgrupo21.dao.RolRepository;
import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.dto.UserDTO;
import es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO;
import es.taw.tawebayspringbootgrupo21.entity.Producto;
import es.taw.tawebayspringbootgrupo21.entity.Puja;
import es.taw.tawebayspringbootgrupo21.entity.Rol;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import es.taw.tawebayspringbootgrupo21.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("registration")
public class RegistrationController {


    @Autowired
    private UsuarioService us;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rr;
    @Autowired
    private ProductoRepository pr;
    @Autowired
    private PujaRepository pur;

    public UsuarioRepository getCustomerRepository() {
        return usuarioRepository;
    }

    @Autowired
    public void setCustomerRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/save")
    public String registration(HttpSession session, Model model, @ModelAttribute("usuario_new") UsuarioDTO usuario)
    {
        Integer rolid = 1;
        Rol rol = this.rr.findRolById(rolid);
        Usuario user = new Usuario();
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setEmail(usuario.getEmail());
        user.setRolId(rolid);
        user.setRolByRolId(rol);
        user.setDireccion(usuario.getDireccion());
        user.setCiudad(usuario.getCiudad());
        user.setSexo(usuario.getSexo());
        user.setEdad(usuario.getEdad());


        this.usuarioRepository.save(user);


        model.addAttribute("usuario", user);
        session.setAttribute("usuario", user);

        return "welcome";
    }
    @GetMapping("/edit/{userid}/{productId}")
    public String edit(HttpSession session, Model model, @PathVariable("userid") Integer userid, @PathVariable("productId") Integer productId, @RequestParam("puja") BigDecimal puja)
    {
        Usuario user = this.usuarioRepository.findByUserId(userid);
        model.addAttribute("usuario", user);

        Producto producto = this.pr.findProductoById(productId);

        List<Puja> pujalist = this.pur.findPujaByProductId(producto.getProductId());

        Puja puja1 = new Puja();
        puja1.setCantidad(puja);
        puja1.setCompradorId(user.getUserId());
        puja1.setProductoByProductId(producto);
        puja1.setUsuarioByCompradorId(user);
        this.pur.save(puja1);
        pujalist.add(puja1);

        producto.setPujasByProductId(pujalist);
        producto.setPrecio(puja);

        this.pr.save(producto);
        session.setAttribute("usuario", user);

        return "redirect:/listaProducto/"+userid+"";


    }


}
