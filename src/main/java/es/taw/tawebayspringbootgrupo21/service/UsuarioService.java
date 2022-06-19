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
    
    public Usuario setNewUsuario(UsuarioDTO usuario)
    {
        Integer rolid = 1;
        Rol rol = this.rr.findRolById(rolid);
        Usuario user = new Usuario();
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setEmail(usuario.getEmail());
        user.setRolId(rolid);
        user.setRolByRolId(rol);
        user.setDireccion(usuario.getDireccion());
        user.setCiudad(usuario.getCiudad());
        user.setSexo(usuario.getSexo());
        user.setEdad(usuario.getEdad());

        this.ur.save(user);

        return user;
    }
}
