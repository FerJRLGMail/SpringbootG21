package es.taw.tawebayspringbootgrupo21.controller.marketing;
/*
Created by IntelliJ IDEA.
        User: zhang
        Date: 11/06/2022
 */

import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.dao.marketing.ListaRepository;
import es.taw.tawebayspringbootgrupo21.dao.marketing.NotificacionRepository;
import es.taw.tawebayspringbootgrupo21.entity.Lista;
import es.taw.tawebayspringbootgrupo21.entity.Notificacion;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import es.taw.tawebayspringbootgrupo21.entity.UsuarioHasLista;
import es.taw.tawebayspringbootgrupo21.service.UsuarioService;
import es.taw.tawebayspringbootgrupo21.service.markrting.ListaService;
import es.taw.tawebayspringbootgrupo21.service.markrting.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class NotificacionController {
    private ListaService listaService;
    private UsuarioService usuarioService;
    private NotificacionService notificacionService;

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public ListaService getListaService() {
        return listaService;
    }

    public NotificacionService getNotificacionService() {
        return notificacionService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Autowired
    public void setListaService(ListaService listaService) {
        this.listaService = listaService;
    }

    @Autowired
    public void setNotificacionService(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @PostMapping("/notificar")
    public String notificar(HttpSession session, @RequestParam("idLista") Integer idLista, @RequestParam("notificacion") String notificacion) {
        Usuario marketingUsuario = (Usuario) session.getAttribute("usuario");
        this.notificacionService.notificar(marketingUsuario, idLista, notificacion);
        return "redirect:/verLista/" + idLista;
    }

    @GetMapping("/verMensajes/{idU}")
    public String verMensajes(Model model, @PathVariable("idU") Integer idU) {
        this.notificacionService.verMensajes(model, idU);

        return "verMensaje";
    }
}
