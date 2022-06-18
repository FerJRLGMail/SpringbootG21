package es.taw.tawebayspringbootgrupo21.controller;

import es.taw.tawebayspringbootgrupo21.dao.analista.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public void setCustomerRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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
            model.addAttribute("error", "Usuario no existe. Por favor registrate");
            goTo = "login";
        } else {
            model.addAttribute("usuario", user);
            //ver el rol de este usuario
            switch (user.getRolId()) {
                case 1:
                    //comprador
                    goTo="";
                    break;
                case 2:
                    //analista
                    goTo = "" + user.getUserId();
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
