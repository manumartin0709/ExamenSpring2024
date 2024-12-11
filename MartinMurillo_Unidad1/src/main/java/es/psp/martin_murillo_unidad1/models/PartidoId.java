package es.psp.martin_murillo_unidad1.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class PartidoId implements Serializable
{

	
	private static final long serialVersionUID = -6697801377576176617L;
	
	private String nombreLocal;
	
	private String nombreVisitante;

}
