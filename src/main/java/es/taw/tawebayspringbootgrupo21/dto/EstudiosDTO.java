package es.taw.tawebayspringbootgrupo21.dto;

public class EstudiosDTO {
    private Integer estudioId;
    private String nombre;
    private String query;
    private String titulos;
    private Integer analistaId;

    public void setEstudioId(Integer estudioId) {
        this.estudioId = estudioId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public void setAnalistaId(Integer analistaId) {
        this.analistaId = analistaId;
    }

    public Integer getEstudioId() {
        return estudioId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getQuery() {
        return query;
    }

    public String getTitulos() {
        return titulos;
    }

    public Integer getAnalistaId() {
        return analistaId;
    }

    public EstudiosDTO() {

    }

}