package es.taw.tawebayspringbootgrupo21.entity;

import es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuario {
    private Integer userId;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String ciudad;
    private Integer edad;
    private String sexo;
    private Integer rolId;
    private Collection<CatFavoritas> catFavoritasByUserId;
    private Collection<Estudios> estudiosByUserId;
    private Collection<Notificacion> notificacionsByUserId;
    private Collection<Notificacion> notificacionsByUserId_0;
    private Collection<Producto> productosByUserId;
    private Collection<ProdFavoritos> prodFavoritosByUserId;
    private Collection<Puja> pujasByUserId;
    private Rol rolByRolId;
    private Collection<UsuarioHasLista> usuarioHasListasByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "APELLIDO", nullable = false, length = 50)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "DIRECCION", nullable = false, length = 50)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "CIUDAD", nullable = false, length = 50)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Basic
    @Column(name = "EDAD", nullable = false)
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "SEXO", nullable = false, length = 1)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "ROL_ID", nullable = false)
    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(userId, usuario.userId) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido) && Objects.equals(email, usuario.email) && Objects.equals(direccion, usuario.direccion) && Objects.equals(ciudad, usuario.ciudad) && Objects.equals(edad, usuario.edad) && Objects.equals(sexo, usuario.sexo) && Objects.equals(rolId, usuario.rolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nombre, apellido, email, direccion, ciudad, edad, sexo, rolId);
    }

    @OneToMany(mappedBy = "usuarioByCompradorId")
    public Collection<CatFavoritas> getCatFavoritasByUserId() {
        return catFavoritasByUserId;
    }

    public void setCatFavoritasByUserId(Collection<CatFavoritas> catFavoritasByUserId) {
        this.catFavoritasByUserId = catFavoritasByUserId;
    }

    @OneToMany(mappedBy = "usuarioByAnalistaId")
    public Collection<Estudios> getEstudiosByUserId() {
        return estudiosByUserId;
    }

    public void setEstudiosByUserId(Collection<Estudios> estudiosByUserId) {
        this.estudiosByUserId = estudiosByUserId;
    }

    @OneToMany(mappedBy = "usuarioByReceptor")
    public Collection<Notificacion> getNotificacionsByUserId() {
        return notificacionsByUserId;
    }

    public void setNotificacionsByUserId(Collection<Notificacion> notificacionsByUserId) {
        this.notificacionsByUserId = notificacionsByUserId;
    }

    @OneToMany(mappedBy = "usuarioByMensajero")
    public Collection<Notificacion> getNotificacionsByUserId_0() {
        return notificacionsByUserId_0;
    }

    public void setNotificacionsByUserId_0(Collection<Notificacion> notificacionsByUserId_0) {
        this.notificacionsByUserId_0 = notificacionsByUserId_0;
    }

    @OneToMany(mappedBy = "usuarioByVendedorId")
    public Collection<Producto> getProductosByUserId() {
        return productosByUserId;
    }

    public void setProductosByUserId(Collection<Producto> productosByUserId) {
        this.productosByUserId = productosByUserId;
    }

    @OneToMany(mappedBy = "usuarioByCompradorId")
    public Collection<ProdFavoritos> getProdFavoritosByUserId() {
        return prodFavoritosByUserId;
    }

    public void setProdFavoritosByUserId(Collection<ProdFavoritos> prodFavoritosByUserId) {
        this.prodFavoritosByUserId = prodFavoritosByUserId;
    }

    @OneToMany(mappedBy = "usuarioByCompradorId")
    public Collection<Puja> getPujasByUserId() {
        return pujasByUserId;
    }

    public void setPujasByUserId(Collection<Puja> pujasByUserId) {
        this.pujasByUserId = pujasByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "ROL_ID", referencedColumnName = "ROL_ID", nullable = false, insertable = false, updatable = false)
    public Rol getRolByRolId() {
        return rolByRolId;
    }

    public void setRolByRolId(Rol rolByRolId) {
        this.rolByRolId = rolByRolId;
    }

    @OneToMany(mappedBy = "usuarioByUserId")
    public Collection<UsuarioHasLista> getUsuarioHasListasByUserId() {
        return usuarioHasListasByUserId;
    }

    public void setUsuarioHasListasByUserId(Collection<UsuarioHasLista> usuarioHasListasByUserId) {
        this.usuarioHasListasByUserId = usuarioHasListasByUserId;
    }

    @Transient
    public UsuarioDTO toDTO() {
        UsuarioDTO udto = new UsuarioDTO();
        udto.setApellido(this.getApellido());
        udto.setNombre(this.getNombre());
        udto.setUserId(this.getUserId());
        udto.setRolId(this.getRolByRolId().getRolId());
        return udto;
    }
}
