package aed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_tienda")
public class Tienda {

    @Id
    @Column(name = "Codtienda", nullable = false, length = 5)
    private String codTienda;

    @Column(name = "Denotienda", nullable = false, length = 20)
    private String denoTienda;

    @Column(name = "CodigoPostal", length = 5)
    private String codigoPostal;

    // Getters and Setters
    public String getCodTienda() {
        return codTienda;
    }

    public void setCodTienda(String codTienda) {
        this.codTienda = codTienda;
    }

    public String getDenoTienda() {
        return denoTienda;
    }

    public void setDenoTienda(String denoTiend) {
        this.denoTienda = denoTiend;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }  
}
