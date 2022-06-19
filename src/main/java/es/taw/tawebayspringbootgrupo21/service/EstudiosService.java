package es.taw.tawebayspringbootgrupo21.service;


import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.dao.analista.EstudiosRepository;
import es.taw.tawebayspringbootgrupo21.dto.EstudiosDTO;
import es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO;
import es.taw.tawebayspringbootgrupo21.entity.Estudios;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudiosService {


    private EstudiosRepository er;

    private UsuarioRepository ur;

    @Autowired
    public void setEr(EstudiosRepository er) {
        this.er = er;
    }

    @Autowired
    public void setUr(UsuarioRepository ur) {
        this.ur = ur;
    }

    private List<EstudiosDTO> listaEntityADTO (List<Estudios> lista) {
        List<EstudiosDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Estudios estudio:lista) {
                listaDTO.add(estudio.toDTO());
            }
        }
        return listaDTO;
    }

    public List<EstudiosDTO> FindByUserId(UsuarioDTO udto) {
        Usuario u = ur.findByUserId(udto.getId());

        return this.listaEntityADTO(this.er.findEstudiosByUsuarioByAnalistaId(u));
    }

    public EstudiosDTO FindById(Integer id) {
        Estudios u = er.findById(id).orElse(null);
        if (u != null) {
            return u.toDTO();
        } else {
            return null;
        }

    }

    private void rellenarEstudio (Estudios estudio, Usuario analista,
                                  String nombre, String query, String titulos) {

        estudio.setUsuarioByAnalistaId(analista);
        estudio.setNombre(nombre);
        estudio.setQuery(query);
        estudio.setTitulos(titulos);
    }

    //conforme a parametros
    public void modificarEstudio (Integer id, Integer analistaId,
                                  String nombre, String query, String titulos) {

        Estudios estudio = this.er.findById(id).orElse(null);
        Usuario usuario = this.ur.findByUserId(analistaId);

        this.rellenarEstudio(estudio, usuario, nombre, query, titulos);

        this.er.save(estudio);
    }

    //conforme a objeto DTO
    public void guardarEstudio (EstudiosDTO edto) {
        Estudios estudio;

        estudio = new Estudios(edto);

        this.er.save(estudio);
    }

    //crear objeto y devolver su ID
    public Integer crearEstudio (Integer analistaId,
                                 String nombre, String query, String titulos) {
        Estudios nuevoestudio = new Estudios();
        Usuario usuario = this.ur.findByUserId(analistaId);

        this.rellenarEstudio(nuevoestudio, usuario, nombre, query, titulos);

        this.er.save(nuevoestudio);

        this.er.flush();

        return nuevoestudio.getEstudioId();
    }

    public String CheckQuery(String strq) {
        return er.CheckQuery(strq);
    }

    public List QueryOnDemand(String strq) {
        return er.QueryOnDemand(strq);
    }

    public void borrarEstudio (Integer id) {
        Estudios e = er.findById(id).orElse(null);
        er.delete(e);
    }

}
