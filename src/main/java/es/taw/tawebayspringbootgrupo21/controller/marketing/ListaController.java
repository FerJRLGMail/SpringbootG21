package es.taw.tawebayspringbootgrupo21.controller.marketing;
/*
Created by IntelliJ IDEA.
        User: zhang
        Date: 11/06/2022
 */
import es.taw.tawebayspringbootgrupo21.dto.ListaDTO;
import es.taw.tawebayspringbootgrupo21.service.UsuarioService;
import es.taw.tawebayspringbootgrupo21.service.markrting.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListaController {
    private ListaService listaService;
    private UsuarioService usuarioService;

    public UsuarioService getUsuarioService(){
        return  usuarioService;
    }
    public ListaService getListaService(){
        return listaService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @Autowired
    public void setListaService(ListaService listaService){
        this.listaService=listaService;
    }


    @GetMapping("/nuevoLista")
    public String nuevoLista(){
        return "lista";
    }

    @GetMapping("/editLista/{idL}")
    public String editLista(Model model,@PathVariable("idL") Integer idL){
        ListaDTO  listaDTO= this.listaService.filtrarByListaId(idL);
            model.addAttribute("lista", listaDTO);
        return "lista";
    }

    @GetMapping("/Lista/{idL}/add/{idC}")
    public String añadirCompradorALista(@PathVariable("idL") Integer idL, @PathVariable("idC") Integer idC){
        this.listaService.añadirCompradorALista(idL, idC);
        return "redirect:/verLista/{idL}";
    }

    @GetMapping("/Lista/{idL}/delete/{idC}")
    public String deleteCompradorALista(@PathVariable("idL") Integer idL, @PathVariable("idC") Integer idC){
       this.listaService.deleteCompradorALista(idL, idC);
        return "redirect:/verLista/{idL}";
    }

    @PostMapping("/listaFiltrar")
    public String listaFiltrar(Model model, @RequestParam("clave") String clave){
        List<ListaDTO> listasCompradores = this.listaService.findByClave(clave);
        model.addAttribute("listasComprador", listasCompradores);
        return "listasComprador";
    }

}
