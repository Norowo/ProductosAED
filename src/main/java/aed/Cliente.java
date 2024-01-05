package aed;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_cliente")

public class Cliente {
	
	@Id
	@Column(name = "Codcliente", nullable = false)
	private int codCliente;
	
	@Column(name = "Denocliente", nullable = false)
	private String denoFamilia;

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getDenoFamilia() {
		return denoFamilia;
	}

	public void setDenoFamilia(String denoFamilia) {
		this.denoFamilia = denoFamilia;
	}
	
	

}

//LO DE NULLABLE
//HIBERNATEUTIL y proyecto de clase
//ONETOMANY producto y familia
//@OneToOne(cascade = CascadeType.ALL)
// @OneToOne(mappedBy = "producto")
//Hacer otro tipo el stock???