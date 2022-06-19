package es.taw.tawebayspringbootgrupo21.dto;
/*
Created by IntelliJ IDEA.
        User: zhang
        Date: 19/06/2022
 */
import es.taw.tawebayspringbootgrupo21.entity.Usuario;

import java.sql.Date;

public class NotificacionDTO {
    private Integer notificacionId;
    private Integer receptor;
    private Integer mensajero;
    private String mensaje;
    private Date fecha;
    private Usuario usuarioByReceptor;
    private Usuario usuarioByMensajero;

    public Integer getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    public Integer getReceptor() {
        return receptor;
    }

    public void setReceptor(Integer receptor) {
        this.receptor = receptor;
    }

    public Integer getMensajero() {
        return mensajero;
    }

    public void setMensajero(Integer mensajero) {
        this.mensajero = mensajero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuarioByReceptor() {
        return usuarioByReceptor;
    }

    public void setUsuarioByReceptor(Usuario usuarioByReceptor) {
        this.usuarioByReceptor = usuarioByReceptor;
    }

    public Usuario getUsuarioByMensajero() {
        return usuarioByMensajero;
    }

    public void setUsuarioByMensajero(Usuario usuarioByMensajero) {
        this.usuarioByMensajero = usuarioByMensajero;
    }
}
