package es.psp.martin_murillo_unidad1.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoDto 
{
	private String nombre;
	private String ciudad;
	private List<String> jugadores;

}
