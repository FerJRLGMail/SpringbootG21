package es.taw.tawebayspringbootgrupo21.service.markrting;
/*
Created by IntelliJ IDEA.
        User: zhang
        Date: 19/06/2022
 */

import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.dao.marketing.ListaRepository;
import es.taw.tawebayspringbootgrupo21.dao.marketing.UsuarioHasListaRepository;
import es.taw.tawebayspringbootgrupo21.dto.ListaDTO;
import es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO;
import es.taw.tawebayspringbootgrupo21.entity.Lista;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import es.taw.tawebayspringbootgrupo21.entity.UsuarioHasLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ListaService {
    private ListaRepository listaRepository;
    private UsuarioRepository usuarioRepository;
    private UsuarioHasListaRepository usuarioHasListaRepository;

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public ListaRepository getListaRepository() {
        return listaRepository;
    }

    public UsuarioHasListaRepository getUsuarioHasListaRepository() {
        return usuarioHasListaRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setListaRepository(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    @Autowired
    public void setUsuarioHasListaRepository(UsuarioHasListaRepository usuarioHasListaRepository) {
        this.usuarioHasListaRepository = usuarioHasListaRepository;
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

    public ListaDTO filtrarByListaId(Integer idLista) {
        Lista lista = this.listaRepository.findByListaId(idLista);
        return lista.toDTO();
    }


    public void editLista(Model model, @PathVariable("idL") Integer idL) {
        Lista lista = this.listaRepository.findByListaId(idL);
        model.addAttribute("lista", lista);
    }

    public void añadirCompradorALista(Integer idL, Integer idC) {
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

    }

    public void deleteCompradorALista(@PathVariable("idL") Integer idL, @PathVariable("idC") Integer idC) {
        if (this.exists(idL, idC)) {

            Lista l = this.listaRepository.findByListaId(idL);
            Usuario u = this.usuarioRepository.findByUserId(idC);

            UsuarioHasLista usuarioHasLista = this.usuarioHasListaRepository.findByListaIdyUserId(l.getListaId(), u.getUserId());
            this.usuarioHasListaRepository.delete(usuarioHasLista);
        }
    }


    public void listaFiltrar(Model model, @RequestParam("clave") String clave) {
        List<Lista> listasCompradores;
        listasCompradores = this.listaRepository.findByClave(clave);
        model.addAttribute("listasComprador", listasCompradores);
    }

    public List<ListaDTO> findByClave(String clave) {
        List<Lista> listas = this.listaRepository.findByClave(clave);
        List<ListaDTO> lDTO = new ArrayList<>();

        for (Lista lista :listas) {
            lDTO.add(lista.toDTO());
        }

        return lDTO;
    }

    public void deleteLista(Integer idL){
        Lista l = this.listaRepository.findByListaId(idL);
        List<UsuarioHasLista> usuarioHasListas = this.usuarioHasListaRepository.findByListaId(idL);
        for (UsuarioHasLista u: usuarioHasListas) {
            this.usuarioHasListaRepository.delete(u);
        }
        this.listaRepository.deleteById(idL);
    }

    public void addListaComprador(@RequestParam("id") String id, @RequestParam("nombre") String nombre){
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
    }

    public void verLista(Model model,  Integer idL){
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
        List<UsuarioDTO> luDTO = new ArrayList<>();

        for (Usuario u :compradoresDisponibles) {
            luDTO.add(u.toDTO());
        }

        model.addAttribute("lista", lista);
        model.addAttribute("compradoresDisponibles", luDTO);
    }
    public List<ListaDTO> findAll() {
        List<Lista> listas = this.listaRepository.findAll();
        List<ListaDTO> lDTO = new ArrayList<>();

        for (Lista lista :listas) {
            lDTO.add(lista.toDTO());
        }

        return lDTO;
    }

}
