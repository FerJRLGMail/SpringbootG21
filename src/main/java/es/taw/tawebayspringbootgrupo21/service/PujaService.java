package es.taw.tawebayspringbootgrupo21.service;

import es.taw.tawebayspringbootgrupo21.dao.PujaRepository;
import es.taw.tawebayspringbootgrupo21.entity.Producto;
import es.taw.tawebayspringbootgrupo21.entity.Puja;
import es.taw.tawebayspringbootgrupo21.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PujaService {
    @Autowired
    private PujaRepository pur;

    public Puja newPuja(BigDecimal puja, Usuario user, Producto producto)
    {
        Puja puja1 = new Puja();
        puja1.setCantidad(puja);
        puja1.setCompradorId(user.getUserId());
        puja1.setProductoByProductId(producto);
        puja1.setUsuarioByCompradorId(user);
        this.pur.save(puja1);
        return puja1;
    }
}
