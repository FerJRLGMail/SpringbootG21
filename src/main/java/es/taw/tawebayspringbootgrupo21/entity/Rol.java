package es.taw.tawebayspringbootgrupo21.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rol {
    private Integer rolId;
    private String nombre;
    private Collection<Usuario> usuariosByRolId;

    @Id
    @Column(name = "ROL_ID", nullable = false)
    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 50)
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
        Rol rol = (Rol) o;
        return Objects.equals(rolId, rol.rolId) && Objects.equals(nombre, rol.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId, nombre);
    }

    @OneToMany(mappedBy = "rolByRolId")
    public Collection<Usuario> getUsuariosByRolId() {
        return usuariosByRolId;
    }

    public void setUsuariosByRolId(Collection<Usuario> usuariosByRolId) {
        this.usuariosByRolId = usuariosByRolId;
    }
}
