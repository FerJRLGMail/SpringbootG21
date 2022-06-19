package es.taw.tawebayspringbootgrupo21.service;


import es.taw.tawebayspringbootgrupo21.dao.UsuarioRepository;
import es.taw.tawebayspringbootgrupo21.dto.UsuarioDTO;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    private UsuarioRepository ur;

    @Autowired
    public void setUr(UsuarioRepository ur) {
        this.ur = ur;
    }

    public UsuarioDTO findUsuarioByUserId(Integer UserId) {
        return ur.findByUserId(UserId).toDTO();
    }

}
