package es.taw.tawebayspringbootgrupo21.dto;

import es.taw.tawebayspringbootgrupo21.entity.UsuarioHasLista;

import java.util.Collection;

/*
Created by IntelliJ IDEA.
        User: zhang
        Date: 19/06/2022
 */
public class ListaDTO {
    private Integer listaId;
    private String nombre;
    private Collection<UsuarioHasLista> usuarioHasListasByListaId;

    public Integer getListaId() {
        return listaId;
    }

    public void setListaId(Integer listaId) {
        this.listaId = listaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<UsuarioHasLista> getUsuarioHasListasByListaId() {
        return usuarioHasListasByListaId;
    }

    public void setUsuarioHasListasByListaId(Collection<UsuarioHasLista> usuarioHasListasByListaId) {
        this.usuarioHasListasByListaId = usuarioHasListasByListaId;
    }
}
