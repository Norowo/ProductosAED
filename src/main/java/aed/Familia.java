package aed;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_familia")
public class Familia {

    @Id
    @Column(name = "Codfamilia", columnDefinition = "int(11)")
    private int codFamilia;

    @Column(name = "Denofamilia", columnDefinition = "varchar(50)")
    private String denoFamilia;

    // Getters y setters
    public int getCodFamilia() {
        return codFamilia;
    }

    public void setCodFamilia(int codFamilia) {
        this.codFamilia = codFamilia;
    }

    public String getDenoFamilia() {
        return denoFamilia;
    }
    public void setDenoFamilia(String denoFamilia) {
        this.denoFamilia = denoFamilia;
    }  

}
