package es.taw.tawebayspringbootgrupo21.entity;

import es.taw.tawebayspringbootgrupo21.dto.ListaDTO;
import es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Lista {
    private Integer listaId;
    private String nombre;
    private Collection<UsuarioHasLista> usuarioHasListasByListaId;

    public Lista(Integer id, String nombre) {
        this.listaId = id;
        this.nombre = nombre;
    }

    public Lista() {

    }

    public Lista(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LISTA_ID", nullable = false)
    public Integer getListaId() {
        return listaId;
    }

    public void setListaId(Integer listaId) {
        this.listaId = listaId;
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
        Lista lista = (Lista) o;
        return Objects.equals(listaId, lista.listaId) && Objects.equals(nombre, lista.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaId, nombre);
    }

    @OneToMany(mappedBy = "listaByListaId")
    public Collection<UsuarioHasLista> getUsuarioHasListasByListaId() {
        return usuarioHasListasByListaId;
    }

    public void setUsuarioHasListasByListaId(Collection<UsuarioHasLista> usuarioHasListasByListaId) {
        this.usuarioHasListasByListaId = usuarioHasListasByListaId;
    }

    @Transient
    public ListaDTO toDTO() {
        ListaDTO ldto = new ListaDTO();
        ldto.setListaId(this.getListaId());
        ldto.setNombre(this.getNombre());
        ldto.setUsuarioHasListasByListaId(this.getUsuarioHasListasByListaId());
        return ldto;
    }
}
