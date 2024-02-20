package aed;
import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
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
    @Column(name = "Codproducto", columnDefinition = "int(11)")
    private Integer codProducto;

    @Column(name = "Denoproducto", columnDefinition = "varchar(20)")
    private String denoProducto;

    @Column(name = "PrecioBase", columnDefinition = "decimal(8,2)")
    private BigDecimal precioBase;

    //@Column(name = "Codfamilia", columnDefinition = "int(11)")
    //private Integer codFamilia;

    @Column(name = "Congelado", columnDefinition = "tinyint(1)")
    private Boolean congelado;

    @OneToOne(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Observacion observacion;
    


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

	public Observacion getObservacion() {
		return observacion;
	}

	public void setObservacion(Observacion observacion) {
		this.observacion = observacion;
	}

   

 
}
