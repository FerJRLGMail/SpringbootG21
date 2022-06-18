package es.taw.tawebayspringbootgrupo21.controller.marketing;

import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.dao.marketing.ListaRepository;
import es.taw.tawebayspringbootgrupo21.dao.marketing.UsuarioHasListaRepository;
import es.taw.tawebayspringbootgrupo21.entity.Lista;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import es.taw.tawebayspringbootgrupo21.entity.UsuarioHasLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ListasCompradorController {

    private ListaRepository listaRepository;
    private UsuarioRepository usuarioRepository;
    private UsuarioHasListaRepository usuarioHasListaRepository;

    public UsuarioRepository getUsuarioRepository(){
        return  usuarioRepository;
    }
    public ListaRepository getListaRepository(){
        return listaRepository;
    }
    public UsuarioHasListaRepository getUsuarioHasListaRepository() {
        return usuarioHasListaRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    @Autowired
    public void setListaRepository(ListaRepository listaRepository){
        this.listaRepository=listaRepository;
    }

    @Autowired
    public void setUsuarioHasListaRepository(UsuarioHasListaRepository usuarioHasListaRepository){
        this.usuarioHasListaRepository=usuarioHasListaRepository;
    }

    @GetMapping("/listasComprador")
    public String doListarCompradores(Model model){
        List<Lista> listasCompradores = this.listaRepository.findAll();
        model.addAttribute("listasComprador", listasCompradores);
        return "listasComprador";
    }

    @PostMapping("/AddyEditLista")
    public String addListaComprador(Model model, HttpSession session,@RequestParam("id") String id, @RequestParam("nombre") String nombre){
        Lista lista;
        if(id.length() == 0){
            lista = new Lista(nombre);
        }else{
            lista = this.listaRepository.findByListaId(Integer.parseInt(id));
            if(lista != null){
                lista.setNombre(nombre);
            }
        }
        this.listaRepository.save(lista);
        return "redirect:/listasComprador";
    }

    @GetMapping("/deleteLista/{idL}")
    public String deleteLista(@PathVariable("idL") Integer idL){
        Lista l = this.listaRepository.findByListaId(idL);
        List<UsuarioHasLista> usuarioHasListas = this.usuarioHasListaRepository.findByListaId(idL);
        for (UsuarioHasLista u: usuarioHasListas) {
            this.usuarioHasListaRepository.delete(u);
        }
        this.listaRepository.deleteById(idL);
        return "redirect:/listasComprador";
    }

    @GetMapping("/verLista/{idL}")
    public String verLista(Model model, HttpSession session, @PathVariable("idL") Integer idL){
        Lista lista = this.listaRepository.findByListaId(idL);

        List<Integer> idsL = new ArrayList<>();
        for (UsuarioHasLista u : lista.getUsuarioHasListasByListaId()) {
            idsL.add(u.getUserId());
        }
        List<Usuario> compradoresDisponibles;
        if(idsL.isEmpty()){
            compradoresDisponibles=this.usuarioRepository.findByGetCompradores();
        }else{
            compradoresDisponibles = this.usuarioRepository.fingByRolIdgetCompradoresDisponibles(idsL);
        }

        model.addAttribute("lista", lista);
        model.addAttribute("compradoresDisponibles", compradoresDisponibles);

        return "compradoresDeLista";
    }

    @PostMapping("/Reset")
    public String resetFiltrar(){
        return "redirect:/listasComprador";
    }
}
