package es.taw.tawebayspringbootgrupo21.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Notificacion {
    private Integer notificacionId;
    private Integer receptor;
    private Integer mensajero;
    private String mensaje;
    private Date fecha;
    private Usuario usuarioByReceptor;
    private Usuario usuarioByMensajero;

    @Id
    @Column(name = "NOTIFICACION_ID", nullable = false)
    public Integer getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(Integer notificacionId) {
        this.notificacionId = notificacionId;
    }

    @Basic
    @Column(name = "RECEPTOR", nullable = true)
    public Integer getReceptor() {
        return receptor;
    }

    public void setReceptor(Integer receptor) {
        this.receptor = receptor;
    }

    @Basic
    @Column(name = "MENSAJERO", nullable = true)
    public Integer getMensajero() {
        return mensajero;
    }

    public void setMensajero(Integer mensajero) {
        this.mensajero = mensajero;
    }

    @Basic
    @Column(name = "MENSAJE", nullable = true, length = 200)
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Basic
    @Column(name = "FECHA", nullable = true)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notificacion that = (Notificacion) o;
        return Objects.equals(notificacionId, that.notificacionId) && Objects.equals(receptor, that.receptor) && Objects.equals(mensajero, that.mensajero) && Objects.equals(mensaje, that.mensaje) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificacionId, receptor, mensajero, mensaje, fecha);
    }

    @ManyToOne
    @JoinColumn(name = "RECEPTOR", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    public Usuario getUsuarioByReceptor() {
        return usuarioByReceptor;
    }

    public void setUsuarioByReceptor(Usuario usuarioByReceptor) {
        this.usuarioByReceptor = usuarioByReceptor;
    }

    @ManyToOne
    @JoinColumn(name = "MENSAJERO", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    public Usuario getUsuarioByMensajero() {
        return usuarioByMensajero;
    }

    public void setUsuarioByMensajero(Usuario usuarioByMensajero) {
        this.usuarioByMensajero = usuarioByMensajero;
    }
}
