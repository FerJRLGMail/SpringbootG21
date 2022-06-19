package es.taw.tawebayspringbootgrupo21.service.markrting;
/*
Created by IntelliJ IDEA.
        User: zhang
        Date: 19/06/2022
 */
import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.dao.marketing.ListaRepository;
import es.taw.tawebayspringbootgrupo21.dao.marketing.NotificacionRepository;
import es.taw.tawebayspringbootgrupo21.dto.NotificacionDTO;
import es.taw.tawebayspringbootgrupo21.entity.Lista;
import es.taw.tawebayspringbootgrupo21.entity.Notificacion;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import es.taw.tawebayspringbootgrupo21.entity.UsuarioHasLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

@Service
public class NotificacionService {
    private UsuarioRepository usuarioRepository;
    private ListaRepository listaRepository;
    private NotificacionRepository notificacionRepository;

    public UsuarioRepository getUsuarioRepository(){ return usuarioRepository;}
    public ListaRepository getListaRepository(){ return listaRepository;}
    public NotificacionRepository getNodificacionRepository() { return notificacionRepository;}

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }
    @Autowired
    public void setListaRepository(ListaRepository listaRepository){
        this.listaRepository=listaRepository;
    }
    @Autowired
    public void setNodificacionRepository(NotificacionRepository notificacionRepository){
        this.notificacionRepository = notificacionRepository;
    }

    public void notificar(Usuario marketingUsuario, Integer idLista, String notificacion){
        if (idLista != null && notificacion != null && marketingUsuario.getRolId() == 5) {
            Lista l = this.listaRepository.findByListaId(idLista);

            for (UsuarioHasLista usuario : l.getUsuarioHasListasByListaId()) {
                Notificacion n = new Notificacion();
                n.setFecha(new Date(Calendar.getInstance().getTime().getTime()));
                n.setMensaje(notificacion);
                n.setReceptor(usuario.getUserId());
                n.setMensajero(marketingUsuario.getUserId());
                this.notificacionRepository.save(n);
            }
        }
    }


    public void verMensajes(Model model, Integer idU){
        List<Notificacion> notificaciones = new ArrayList<>();
        List<NotificacionDTO> lnDTO = new ArrayList<>();
        Usuario comprador=new Usuario();


        if(idU != null){
            notificaciones = this.notificacionRepository.findAllNotificacionesByUserId(idU);

            for (Notificacion n :notificaciones) {
                lnDTO.add(n.toDTO());
            }

            comprador = this.usuarioRepository.findByUserId(idU);
        }
        model.addAttribute("notificaciones", lnDTO);
        model.addAttribute("comprador", comprador.toDTO());
    }
}
