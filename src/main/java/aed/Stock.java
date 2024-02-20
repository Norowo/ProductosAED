package aed;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(Stock.StockId.class) // clase de ID compuesta
@Table(name = "productos_stock")
public class Stock implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "Codtienda", columnDefinition = "char(5)")
    private Tienda tienda;

    @Id
    @ManyToOne
    @JoinColumn(name = "Codproducto", columnDefinition = "int(11)")
    private Producto producto;

    @Column(name = "Unidades", columnDefinition = "int(11)")
    private int unidades;

    // Constructor
    public Stock() {
    }

    // Getters and Setters
    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public static class StockId implements Serializable {
        private String tienda; 
        private Integer producto; 
    
    
        public StockId() {
        }
    
        // Getters y Setters para tienda y producto, que son los campos de la clave compuesta
        public String getTienda() {
            return tienda;
        }
    
        public void setTienda(String tienda) {
            this.tienda = tienda;
        }
    
        public Integer getProducto() {
            return producto;
        }
    
        public void setProducto(Integer producto) {
            this.producto = producto;
        }
    
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StockId stockId = (StockId) o;
            return Objects.equals(tienda, stockId.tienda) &&
                    Objects.equals(producto, stockId.producto);
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(tienda, producto);
        }
    }

}