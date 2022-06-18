package es.taw.tawebayspringbootgrupo21.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROD_FAVORITOS", schema = "GRUPO21", catalog = "")
public class ProdFavoritos {
    private Integer id;
    private Integer compradorId;
    private Integer productId;
    private Usuario usuarioByCompradorId;
    private Producto productoByProductId;

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
    @Column(name = "PRODUCT_ID", nullable = true)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdFavoritos that = (ProdFavoritos) o;
        return Objects.equals(id, that.id) && Objects.equals(compradorId, that.compradorId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, compradorId, productId);
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
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = false, updatable = false)
    public Producto getProductoByProductId() {
        return productoByProductId;
    }

    public void setProductoByProductId(Producto productoByProductId) {
        this.productoByProductId = productoByProductId;
    }
}
