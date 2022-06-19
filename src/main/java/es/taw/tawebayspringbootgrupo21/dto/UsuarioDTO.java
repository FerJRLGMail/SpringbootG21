package es.taw.tawebayspringbootgrupo21.dto;

import es.taw.tawebayspringbootgrupo21.entity.*;

import java.util.Collection;

public class UsuarioDTO {

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public Collection<CatFavoritas> getCatFavoritasByUserId() {
        return catFavoritasByUserId;
    }

    public void setCatFavoritasByUserId(Collection<CatFavoritas> catFavoritasByUserId) {
        this.catFavoritasByUserId = catFavoritasByUserId;
    }

    public Collection<Estudios> getEstudiosByUserId() {
        return estudiosByUserId;
    }

    public void setEstudiosByUserId(Collection<Estudios> estudiosByUserId) {
        this.estudiosByUserId = estudiosByUserId;
    }

    public Collection<Notificacion> getNotificacionsByUserId() {
        return notificacionsByUserId;
    }

    public void setNotificacionsByUserId(Collection<Notificacion> notificacionsByUserId) {
        this.notificacionsByUserId = notificacionsByUserId;
    }

    public Collection<Notificacion> getNotificacionsByUserId_0() {
        return notificacionsByUserId_0;
    }

    public void setNotificacionsByUserId_0(Collection<Notificacion> notificacionsByUserId_0) {
        this.notificacionsByUserId_0 = notificacionsByUserId_0;
    }

    public Collection<Producto> getProductosByUserId() {
        return productosByUserId;
    }

    public void setProductosByUserId(Collection<Producto> productosByUserId) {
        this.productosByUserId = productosByUserId;
    }

    public Collection<ProdFavoritos> getProdFavoritosByUserId() {
        return prodFavoritosByUserId;
    }

    public void setProdFavoritosByUserId(Collection<ProdFavoritos> prodFavoritosByUserId) {
        this.prodFavoritosByUserId = prodFavoritosByUserId;
    }

    public Collection<Puja> getPujasByUserId() {
        return pujasByUserId;
    }

    public void setPujasByUserId(Collection<Puja> pujasByUserId) {
        this.pujasByUserId = pujasByUserId;
    }

    public Rol getRolByRolId() {
        return rolByRolId;
    }

    public void setRolByRolId(Rol rolByRolId) {
        this.rolByRolId = rolByRolId;
    }

    public Collection<UsuarioHasLista> getUsuarioHasListasByUserId() {
        return usuarioHasListasByUserId;
    }

    public void setUsuarioHasListasByUserId(Collection<UsuarioHasLista> usuarioHasListasByUserId) {
        this.usuarioHasListasByUserId = usuarioHasListasByUserId;
    }
}
