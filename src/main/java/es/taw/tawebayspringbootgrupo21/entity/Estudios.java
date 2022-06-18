package es.taw.tawebayspringbootgrupo21.entity;

import es.taw.tawebayspringbootgrupo21.dto.EstudiosDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Estudios {
    private Integer estudioId;
    private Integer analistaId;
    private String nombre;
    private String query;
    private String titulos;
    private Usuario usuarioByAnalistaId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ESTUDIO_ID", nullable = false)
    public Integer getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    @Basic
    @Column(name = "ANALISTA_ID", nullable = true, insertable = false, updatable = false)
    public Integer getAnalistaId() {
        return analistaId;
    }

    public void setAnalistaId(Integer analistaId) {
        this.analistaId = analistaId;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 200)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "QUERY", nullable = true, length = 500)
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Basic
    @Column(name = "TITULOS", nullable = true, length = 200)
    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudios estudios = (Estudios) o;
        return Objects.equals(estudioId, estudios.estudioId) && Objects.equals(analistaId, estudios.analistaId) && Objects.equals(nombre, estudios.nombre) && Objects.equals(query, estudios.query) && Objects.equals(titulos, estudios.titulos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudioId, analistaId, nombre, query, titulos);
    }

    @ManyToOne
    @JoinColumn(name = "ANALISTA_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    public Usuario getUsuarioByAnalistaId() {
        return usuarioByAnalistaId;
    }

    public void setUsuarioByAnalistaId(Usuario usuarioByAnalistaId) {
        this.usuarioByAnalistaId = usuarioByAnalistaId;
    }

    public EstudiosDTO toDTO () {
        EstudiosDTO dto = new EstudiosDTO();
        dto.setAnalistaId(this.getUsuarioByAnalistaId().getUserId());
        dto.setEstudioId(estudioId);
        dto.setNombre(nombre);
        dto.setQuery(query);
        dto.setTitulos(titulos);

        return dto;
    }

    public Estudios() {}

    public Estudios(EstudiosDTO edto) {
        this.estudioId = edto.getEstudioId();
        //this.usuarioByAnalistaId =
        this.nombre = edto.getNombre();
        this.query = edto.getQuery();
        this.titulos = edto.getTitulos();
    }
}
