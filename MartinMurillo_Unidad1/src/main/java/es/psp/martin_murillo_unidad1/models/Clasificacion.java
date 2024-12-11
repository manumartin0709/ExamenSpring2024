package es.psp.martin_murillo_unidad1.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clasificacion")
public class Clasificacion 
{
	@Id
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "puntuacionTotal")
	private int puntuacion_total;
	
	@OneToMany(mappedBy = "idClasificacion")
	private List<Equipo> equipo;

}
