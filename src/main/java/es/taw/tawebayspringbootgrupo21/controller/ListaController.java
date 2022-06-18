package es.taw.tawebayspringbootgrupo21.controller;

import es.taw.tawebayspringbootgrupo21.dao.listas.ListaRepository;
import es.taw.tawebayspringbootgrupo21.dao.listas.UsuarioHasListaRepository;
import es.taw.tawebayspringbootgrupo21.dao.analista.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.entity.Lista;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import es.taw.tawebayspringbootgrupo21.entity.UsuarioHasLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Controller
public class ListaController {
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

    private boolean exists(Integer listaId, Integer compradorId) {
        boolean result = false;
        Lista l = this.listaRepository.findByListaId(listaId);
        for (UsuarioHasLista usuarioHasLista : l.getUsuarioHasListasByListaId()) {
            if (usuarioHasLista.getUserId() == compradorId) {
                result = true;
            }
        }
        return result;
    }



    @GetMapping("/nuevoLista")
    public String nuevoLista(Model model){
        Integer id = (Integer) model.getAttribute("id");
        if (id != null) {
            Lista lista = this.listaRepository.findByListaId(id);
            model.addAttribute("lista", lista);
        }
        return "crearLista";
    }

    @GetMapping("/Lista/{idL}/add/{idC}")
    public String añadirCompradorALista(Model model, @PathVariable("idL") Integer idL, @PathVariable("idC") Integer idC){
        if (this.exists(idL, idC) == false) {
            Lista l = this.listaRepository.findByListaId(idL);
            Usuario u = this.usuarioRepository.findByUserId(idC);

            Collection<UsuarioHasLista> usuarioHasListas = l.getUsuarioHasListasByListaId();

            UsuarioHasLista usuarioHasLista = new UsuarioHasLista();
            usuarioHasLista.setUserId(u.getUserId());
            usuarioHasLista.setListaId(l.getListaId());

            usuarioHasListas.add(usuarioHasLista);
            l.setUsuarioHasListasByListaId(usuarioHasListas);

            this.usuarioHasListaRepository.save(usuarioHasLista);
            this.listaRepository.save(l);
        }

        return "redirect:/verLista/{idL}";
    }

    @GetMapping("/Lista/{idL}/delete/{idC}")
    public String deleteCompradorALista(Model model, @PathVariable("idL") Integer idL, @PathVariable("idC") Integer idC){
        if (this.exists(idL, idC)) {

            Lista l = this.listaRepository.findByListaId(idL);
            Usuario u = this.usuarioRepository.findByUserId(idC);

            UsuarioHasLista usuarioHasLista = this.usuarioHasListaRepository.findByListaIdyUserId(l.getListaId(),u.getUserId());
            this.usuarioHasListaRepository.delete(usuarioHasLista);
        }
        return "redirect:/verLista/{idL}";
    }

}
