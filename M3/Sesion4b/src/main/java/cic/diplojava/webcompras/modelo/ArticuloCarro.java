package cic.diplojava.webcompras.modelo;

import java.util.Objects;

public class ArticuloCarro {
    private int cantidad;
    private Producto producto;

    public ArticuloCarro(int cantidad, Producto producto){
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float totalArticulo(){
        return producto.getPrecio()*cantidad;
    }

    //para saber si los dos objetos son iguales
    @Override
    public boolean equals(Object otro){
        if (this == otro){
            return true;
        }
        if (otro == null || !(otro instanceof  ArticuloCarro)){
            return false;
        }
        ArticuloCarro externo = (ArticuloCarro) otro;
        return Objects.equals(producto.getId(),externo.getProducto().getId())
                && Objects.equals(producto.getNombre(), externo.getProducto().getNombre());
    }

}
