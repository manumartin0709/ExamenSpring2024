package es.psp.martin_murillo_unidad1.models;

import java.sql.Date;

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
@Table(name = "jugador")
public class Jugador 
{
	@Id
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "posicion", length = 50, nullable = false)
	private String posicion;
	
	@ManyToOne
	private Equipo idEquipo;
	
}
