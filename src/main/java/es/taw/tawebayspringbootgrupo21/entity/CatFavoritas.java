package es.taw.tawebayspringbootgrupo21.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAT_FAVORITAS", schema = "GRUPO21", catalog = "")
public class CatFavoritas {
    private Integer id;
    private Integer compradorId;
    private Integer catId;
    private Usuario usuarioByCompradorId;
    private Categoria categoriaByCatId;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COMPRADOR_ID", nullable = true)
    public Integer getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(Integer compradorId) {
        this.compradorId = compradorId;
    }

    @Basic
    @Column(name = "CAT_ID", nullable = true)
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatFavoritas that = (CatFavoritas) o;
        return Objects.equals(id, that.id) && Objects.equals(compradorId, that.compradorId) && Objects.equals(catId, that.catId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, compradorId, catId);
    }

    @ManyToOne
    @JoinColumn(name = "COMPRADOR_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    public Usuario getUsuarioByCompradorId() {
        return usuarioByCompradorId;
    }

    public void setUsuarioByCompradorId(Usuario usuarioByCompradorId) {
        this.usuarioByCompradorId = usuarioByCompradorId;
    }

    @ManyToOne
    @JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID", insertable = false, updatable = false)
    public Categoria getCategoriaByCatId() {
        return categoriaByCatId;
    }

    public void setCategoriaByCatId(Categoria categoriaByCatId) {
        this.categoriaByCatId = categoriaByCatId;
    }
}
