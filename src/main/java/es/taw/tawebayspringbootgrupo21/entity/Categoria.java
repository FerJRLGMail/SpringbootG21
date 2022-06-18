package es.taw.tawebayspringbootgrupo21.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Categoria {
    private Integer catId;
    private String nombre;
    private Collection<CatFavoritas> catFavoritasByCatId;
    private Collection<Producto> productosByCatId;

    @Id
    @Column(name = "CAT_ID", nullable = false)
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(catId, categoria.catId) && Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, nombre);
    }

    @OneToMany(mappedBy = "categoriaByCatId")
    public Collection<CatFavoritas> getCatFavoritasByCatId() {
        return catFavoritasByCatId;
    }

    public void setCatFavoritasByCatId(Collection<CatFavoritas> catFavoritasByCatId) {
        this.catFavoritasByCatId = catFavoritasByCatId;
    }

    @OneToMany(mappedBy = "categoriaByCatId")
    public Collection<Producto> getProductosByCatId() {
        return productosByCatId;
    }

    public void setProductosByCatId(Collection<Producto> productosByCatId) {
        this.productosByCatId = productosByCatId;
    }
}
