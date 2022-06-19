package es.taw.tawebayspringbootgrupo21.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USUARIO_HAS_LISTA", schema = "GRUPO21", catalog = "")
public class UsuarioHasLista {
    private Integer id;
    private Integer userId;
    private Integer listaId;
    private Usuario usuarioByUserId;
    private Lista listaByListaId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "LISTA_ID", nullable = false)
    public Integer getListaId() {
        return listaId;
    }

    public void setListaId(Integer listaId) {
        this.listaId = listaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioHasLista that = (UsuarioHasLista) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(listaId, that.listaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, listaId);
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false, insertable = false, updatable = false)
    public Usuario getUsuarioByUserId() {
        return usuarioByUserId;
    }

    public void setUsuarioByUserId(Usuario usuarioByUserId) {
        this.usuarioByUserId = usuarioByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "LISTA_ID", referencedColumnName = "LISTA_ID", nullable = false, insertable = false, updatable = false)
    public Lista getListaByListaId() {
        return listaByListaId;
    }

    public void setListaByListaId(Lista listaByListaId) {
        this.listaByListaId = listaByListaId;
    }

}
