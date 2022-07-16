package cic.diplojava.webcompras.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarroCompras {
    private List<ArticuloCarro> articulos;

    public CarroCompras() {
        articulos = new ArrayList<>();
    }

    public void agregarArticulos(ArticuloCarro articuloCarro) {
        if (articulos.contains(articuloCarro)) {
            Optional<ArticuloCarro> optionalArticuloCarro = articulos.stream()
                    .filter(articulo -> articulo.equals(articuloCarro))
                    .findAny();
            ArticuloCarro presente = optionalArticuloCarro.get();
            presente.setCantidad(presente.getCantidad() + 1);
        } else {
            this.articulos.add(articuloCarro);
        }
    }

    public List<ArticuloCarro> getArticulos(){
        return articulos;
    }

    public float getTotalCompra(){
      return (float)articulos.stream()
              .mapToDouble(articulo -> Double.parseDouble(Number.class.cast(articulo.totalArticulo()).toString()))
              .sum();
    }



}
