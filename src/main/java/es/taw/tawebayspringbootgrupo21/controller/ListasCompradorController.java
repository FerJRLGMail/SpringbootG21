package es.taw.tawebayspringbootgrupo21.controller;

import es.taw.tawebayspringbootgrupo21.dao.listas.ListaRepository;
import es.taw.tawebayspringbootgrupo21.dao.analista.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.entity.Lista;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ListasCompradorController {

    private ListaRepository listaRepository;
    private UsuarioRepository usuarioRepository;

    public UsuarioRepository getUsuarioRepository(){
        return  usuarioRepository;
    }
    public ListaRepository getListaRepository(){
        return listaRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    @Autowired
    public void setListaRepository(ListaRepository listaRepository){
        this.listaRepository=listaRepository;
    }

    @GetMapping("/listasComprador")
    public String doListarCompradores(Model model){
        List<Lista> listasCompradores = this.listaRepository.findAll();
        model.addAttribute("listasComprador", listasCompradores);
        return "listasComprador";
    }

    @PostMapping("/addLista")
    public String addListaComprador(Model model, HttpSession session, @RequestParam("nombre") String nombre){
        Lista lista = new Lista(nombre);
        this.listaRepository.save(lista);
        return "redirect:/listasComprador";
    }

    @GetMapping("/verLista/{idL}")
    public String verLista(Model model, HttpSession session, @PathVariable("idL") Integer idL){
        Lista lista = this.listaRepository.findByListaId(idL);
        List<Usuario> compradoresDisponibles = this.usuarioRepository.fingByRolIdgetCompradores();

        model.addAttribute("lista", lista);
        model.addAttribute("compradoresDisponibles", compradoresDisponibles);

        return "compradoresDeLista";
    }


}
