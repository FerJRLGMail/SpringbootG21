package es.taw.tawebayspringbootgrupo21.dto;

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
    private Integer[] catPref;

    public UsuarioDTO() {
    }
    public Integer getRolID(){return  rolId;}
    public void setRolId(Integer rolId)
    {
        this.rolId=rolId;
    }
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


    public Integer[] getCatPref() {return catPref;}

    public void setCatPref(Integer[] catPref) {this.catPref = catPref;}
}
