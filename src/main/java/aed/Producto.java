package aed;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "productos_producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codproducto", nullable = false)
    private Integer codProducto;

    @Column(name = "Denoproducto", length = 50, nullable = false)
    private String denoProducto;

    @Column(name = "PrecioBase", precision = 8, scale = 2, nullable = false)
    private BigDecimal precioBase;

    //@Column(name = "Codfamilia", nullable = false)
    //private Integer codFamilia;

    @Column(name = "Congelado")
    private Boolean congelado;

    @OneToOne(mappedBy = "producto")
    private ProductoObservacion productoObservacion;
    

    // ... otros campos y métodos

    @ManyToOne(fetch = FetchType.LAZY) //para mejorar el rendimiento: lo que significa que la familia de un producto se cargará solo cuando se acceda a ella, en lugar de cuando se cargue el producto. 
    @JoinColumn(name = "Codfamilia", nullable = false)
    private Familia familia;

    // Getters y setters para familia
    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    // ... resto de la clase
    
    
    // Getters y setters
    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getDenoProducto() {
        return denoProducto;
    }

    public void setDenoProducto(String denoProducto) {
        this.denoProducto = denoProducto;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

 

    public Boolean getCongelado() {
        return congelado;
    }

    public void setCongelado(Boolean congelado) {
        this.congelado = congelado;
    }

    public ProductoObservacion getProductoObservacion() {
        return productoObservacion;
    }

    public void setProductoObservacion(ProductoObservacion productoObservacion) {
        this.productoObservacion = productoObservacion;
    }

    // toString, equals, y hashCode pueden ser añadidos según sea necesario
}
