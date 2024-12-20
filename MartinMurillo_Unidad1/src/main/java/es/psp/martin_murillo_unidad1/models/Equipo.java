package es.psp.martin_murillo_unidad1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipo")
public class Equipo 
{
	@Id
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cuidad")
	private String cuidad;
	
	@OneToMany(mappedBy = "idEquipo")
	private List<Jugador> jugador;
	
	@ManyToOne
	private Clasificacion idClasificacion;
		
}
