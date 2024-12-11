package es.psp.martin_murillo_unidad1.models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partido")
public class Partido 
{
	
	@EmbeddedId
	private PartidoId partidoId;
	
	@Column(name = "nombreEquipoLocal")
	private String nombreLocal;
	
	@Column(name = "nombreEquipoVisitante")
	private String nombreVisitante;
	
	@Column(name = "fecha")
	private String fecha;

	@Column(name = "golesLocal")
	private int golesLocal;
	
	@Column(name = "golesVisitante")
	private int golesVisitante;
	
}
