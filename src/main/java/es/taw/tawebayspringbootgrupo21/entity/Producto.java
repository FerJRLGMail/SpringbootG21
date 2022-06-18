package es.taw.tawebayspringbootgrupo21.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Producto {
    private Integer productId;
    private Integer catId;
    private Integer vendedorId;
    private String titulo;
    private String descripcion;
    private String urlFoto;
    private BigDecimal precio;
    private Date comienzoPuja;
    private Date finalPuja;
    private Categoria categoriaByCatId;
    private Usuario usuarioByVendedorId;
    private Collection<ProdFavoritos> prodFavoritosByProductId;
    private Collection<Puja> pujasByProductId;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "CAT_ID", nullable = true, insertable = false, updatable = false)
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "VENDEDOR_ID", nullable = true, insertable = false, updatable = false)
    public Integer getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Integer vendedorId) {
        this.vendedorId = vendedorId;
    }

    @Basic
    @Column(name = "TITULO", nullable = true, length = 50)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 200)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "URL_FOTO", nullable = true, length = 200)
    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Basic
    @Column(name = "PRECIO", nullable = true, precision = 2)
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "COMIENZO_PUJA", nullable = true)
    public Date getComienzoPuja() {
        return comienzoPuja;
    }

    public void setComienzoPuja(Date comienzoPuja) {
        this.comienzoPuja = comienzoPuja;
    }

    @Basic
    @Column(name = "FINAL_PUJA", nullable = true)
    public Date getFinalPuja() {
        return finalPuja;
    }

    public void setFinalPuja(Date finalPuja) {
        this.finalPuja = finalPuja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(productId, producto.productId) && Objects.equals(catId, producto.catId) && Objects.equals(vendedorId, producto.vendedorId) && Objects.equals(titulo, producto.titulo) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(urlFoto, producto.urlFoto) && Objects.equals(precio, producto.precio) && Objects.equals(comienzoPuja, producto.comienzoPuja) && Objects.equals(finalPuja, producto.finalPuja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, catId, vendedorId, titulo, descripcion, urlFoto, precio, comienzoPuja, finalPuja);
    }

    @ManyToOne
    @JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID", insertable = false, updatable = false)
    public Categoria getCategoriaByCatId() {
        return categoriaByCatId;
    }

    public void setCategoriaByCatId(Categoria categoriaByCatId) {
        this.categoriaByCatId = categoriaByCatId;
    }

    @ManyToOne
    @JoinColumn(name = "VENDEDOR_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    public Usuario getUsuarioByVendedorId() {
        return usuarioByVendedorId;
    }

    public void setUsuarioByVendedorId(Usuario usuarioByVendedorId) {
        this.usuarioByVendedorId = usuarioByVendedorId;
    }

    @OneToMany(mappedBy = "productoByProductId")
    public Collection<ProdFavoritos> getProdFavoritosByProductId() {
        return prodFavoritosByProductId;
    }

    public void setProdFavoritosByProductId(Collection<ProdFavoritos> prodFavoritosByProductId) {
        this.prodFavoritosByProductId = prodFavoritosByProductId;
    }

    @OneToMany(mappedBy = "productoByProductId")
    public Collection<Puja> getPujasByProductId() {
        return pujasByProductId;
    }

    public void setPujasByProductId(Collection<Puja> pujasByProductId) {
        this.pujasByProductId = pujasByProductId;
    }
}
