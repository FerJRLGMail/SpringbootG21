package es.taw.tawebayspringbootgrupo21.service;

import es.taw.tawebayspringbootgrupo21.dao.comprador.ProductoRepository;
import es.taw.tawebayspringbootgrupo21.entity.Producto;
import es.taw.tawebayspringbootgrupo21.entity.Puja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository pr;

    public void modificaProducto(Producto producto, List<Puja> pujalist, BigDecimal precio)
    {
        producto.setPujasByProductId(pujalist);
        producto.setPrecio(precio);

        this.pr.save(producto);
    }
}
