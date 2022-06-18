package es.taw.tawebayspringbootgrupo21.controller;


import es.taw.tawebayspringbootgrupo21.dto.EstudiosDTO;
import es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO;
import es.taw.tawebayspringbootgrupo21.service.EstudiosService;
import es.taw.tawebayspringbootgrupo21.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("analista")
public class EstudiosController {


    private EstudiosService es;

    private UsuarioService us;



    public EstudiosService getEs() {
        return es;
    }

    @Autowired
    public void setEs(EstudiosService es) {
        this.es = es;
    }

    public UsuarioService getUs() {
        return us;
    }

    @Autowired
    public void setUsuarioService(UsuarioService us) {
        this.us = us;
    }

    @GetMapping("/")
    public String init (Model model, HttpSession session) {
        UsuarioDTO u = us.findUsuarioByUserId(2);
        //UsuarioDTO u = es.findSUSsuarioByUserId(1);
        session.setAttribute("usuario", u);

        return "redirect:/analista/estudios";
    }

    @GetMapping("/estudios")
    public String doListar (Model model, HttpSession session) {

        UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuario");

        List<EstudiosDTO> estudios = this.es.FindByUserId(usuario);

        model.addAttribute("estudios", estudios);


        return "analista";
    }

    @GetMapping("/{query}/nuevoestudio")
    public String nuevoEstudio (Model model, @PathVariable("query") String query, HttpSession session) {
        model.addAttribute("query", query);

        return "nuevoestudio1";
    }

    @PostMapping("/checkstudio")
    public String checkstudio (Model model, @RequestParam("query") String query, HttpSession session) {

        String respuesta = this.es.CheckQuery(query);

        if ("Query valida".equals(respuesta)) {
            //crear estudio

            UsuarioDTO usuario = (UsuarioDTO)session.getAttribute("usuario");
            Integer stdId = es.crearEstudio(usuario.getId(), "", query, "");


            return "redirect:/analista/"+ stdId +"/visualizar/";
        } else {
            model.addAttribute("query", query);
            model.addAttribute("error", respuesta);

            return "nuevoestudio1";
        }

    }

    @GetMapping("/{std}/visualizar")
    public String visualizarEstudio(Model model, @PathVariable("std") Integer stdId, HttpSession session) {

        EstudiosDTO e = es.FindById(stdId);
        List<Object[]> datos = es.QueryOnDemand(e.getQuery());


        //inicializacion del titulo
        if (!datos.isEmpty() && (e.getTitulos() == null || e.getTitulos().equals(""))) {
            String strt = "";

            for (int i = 0; i < datos.get(0).length; i++) {
                strt = strt + "_;";
            }

            es.modificarEstudio(e.getEstudioId(), e.getAnalistaId(), e.getNombre(), e.getQuery(), strt);
        }

        e = es.FindById(stdId);
        model.addAttribute("estudio", e);
        model.addAttribute("datos", datos);

        return "nuevoestudio2";
    }
}
