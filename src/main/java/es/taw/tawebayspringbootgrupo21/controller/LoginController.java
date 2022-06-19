package es.taw.tawebayspringbootgrupo21.controller;
/*
Created by IntelliJ IDEA.
        User: zhang 70%, Fernando 15%, Cecilia 15%
        Date: 11/06/2022
 */
import es.taw.tawebayspringbootgrupo21.dao.comprador.CategoriaRepository;
import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO;
import es.taw.tawebayspringbootgrupo21.entity.Categoria;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import es.taw.tawebayspringbootgrupo21.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    private UsuarioRepository usuarioRepository;


    private UsuarioService usuarioService;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    public void setCustomerRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String doInit () {
        return "login";
    }

    @PostMapping("/autentica")
    public String doAutentica (Model model, HttpSession session,
                               @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido, @RequestParam("email") String email) {
        String goTo = "";
        Usuario user = this.usuarioRepository.findByEmail(email);
        session.setAttribute("usuario", user);
        if (user == null) {
            List<Categoria> categorias = this.categoriaRepository.findAll();
            model.addAttribute("categorias", categorias);

            UsuarioDTO usuario_new = new UsuarioDTO();
            model.addAttribute("usuario_new", usuario_new);

            goTo = "registration";
        } else {
            model.addAttribute("usuario", user);
            //ver el rol de este usuario
            switch (user.getRolId()) {
                case 1:
                    //comprador
                    goTo="welcome";
                    break;
                case 2:
                    //analista
                    goTo = "redirect:/analista/";
                    break;
                case 5:
                    //Marketing
                    goTo = "redirect:/listasComprador";
                    break;
                default:
                    break;
            }
        }
        return goTo;
    }

    @GetMapping("/logout")
    public String doExit (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
