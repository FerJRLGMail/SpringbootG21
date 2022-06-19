package es.taw.tawebayspringbootgrupo21.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Puja {
    private Integer pujaId;
    private Integer compradorId;
    private Integer productId;
    private BigDecimal cantidad;
    private Date fecha;
    private Usuario usuarioByCompradorId;
    private Producto productoByProductId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PUJA_ID", nullable = false)
    public Integer getPujaId() {
        return pujaId;
    }

    public void setPujaId(Integer pujaId) {
        this.pujaId = pujaId;
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
    @Column(name = "PRODUCT_ID", nullable = true, insertable = false, updatable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "CANTIDAD", nullable = true, precision = 2)
    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
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
        Puja puja = (Puja) o;
        return Objects.equals(pujaId, puja.pujaId) && Objects.equals(compradorId, puja.compradorId) && Objects.equals(productId, puja.productId) && Objects.equals(cantidad, puja.cantidad) && Objects.equals(fecha, puja.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pujaId, compradorId, productId, cantidad, fecha);
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
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    public Producto getProductoByProductId() {
        return productoByProductId;
    }

    public void setProductoByProductId(Producto productoByProductId) {
        this.productoByProductId = productoByProductId;
    }
}
