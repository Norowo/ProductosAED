package aed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_tienda")
public class Tienda {

    @Id
    @Column(name = "Codtienda", columnDefinition = "char(5)")
    private String codTienda;

    @Column(name = "Denotienda", columnDefinition = "varchar(20)")
    private String denoTienda;

    @Column(name = "CodigoPostal", columnDefinition = "char(5)")
    private String codigoPostal;

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
