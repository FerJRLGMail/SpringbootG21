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
public class ListasCompradorController {

    private ListaService listaService;
    private UsuarioService usuarioService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public ListaService getListaService() {
        return listaService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Autowired
    public void setListaService(ListaService listaService) {
        this.listaService = listaService;
    }

    @GetMapping("/listasComprador")
    public String doListarCompradores(Model model) {
        List<ListaDTO> listas = this.listaService.findAll();
        model.addAttribute("listasComprador", listas);
        return "listasComprador";
    }

    @PostMapping("/AddyEditLista")
    public String addListaComprador(@RequestParam("id") String id, @RequestParam("nombre") String nombre) {
        this.listaService.addListaComprador(id, nombre);
        return "redirect:/listasComprador";
    }

    @GetMapping("/deleteLista/{idL}")
    public String deleteLista(@PathVariable("idL") Integer idL) {
        this.listaService.deleteLista(idL);
        return "redirect:/listasComprador";
    }

    @GetMapping("/verLista/{idL}")
    public String verLista(Model model, @PathVariable("idL") Integer idL) {
        this.listaService.verLista(model, idL);
        return "compradoresDeLista";
    }

    @PostMapping("/Reset")
    public String resetFiltrar() {
        return "redirect:/listasComprador";
    }
}
