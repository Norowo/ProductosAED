package aed;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_producto_observacion")
public class ProductoObservacion {

    @Id
    @Column(name = "codproducto", nullable = false)
    private Integer codProducto;

    @Column(name = "observacion", length = 60)
    private String observacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codproducto", referencedColumnName = "Codproducto", insertable = false, updatable = false)
    private Producto producto;

    // Getters y setters
    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // toString, equals, y hashCode pueden ser añadidos según sea necesario
}
