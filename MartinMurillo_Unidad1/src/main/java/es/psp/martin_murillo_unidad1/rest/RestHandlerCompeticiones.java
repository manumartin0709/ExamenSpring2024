package es.psp.martin_murillo_unidad1.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.psp.martin_murillo_unidad1.dto.EquipoDto;
import es.psp.martin_murillo_unidad1.dto.JugadorDto;
import es.psp.martin_murillo_unidad1.exception.CompeticionesError;
import es.psp.martin_murillo_unidad1.models.Equipo;
import es.psp.martin_murillo_unidad1.models.Jugador;
import es.psp.martin_murillo_unidad1.models.Partido;
import es.psp.martin_murillo_unidad1.repository.EquipoRepository;
import es.psp.martin_murillo_unidad1.repository.JugadorRepository;
import es.psp.martin_murillo_unidad1.repository.PartidoRepository;

/**
 * Clase rest para crear los endpoints corres pondientes al swagger
 */
@RequestMapping(value = "/competiciones", produces = {"application/json"})
@RestController
public class RestHandlerCompeticiones 
{
	@Autowired
	private JugadorRepository jugadorRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired 
	private PartidoRepository partidoRepository;
	
	/** Attribute - Logger de la clase */
	private static final Logger LOGGER = LogManager.getLogger();
	
	/**
	 * Enpoint que se encarga de crear un jugador y subirlo la base de datos
	 * @param jugador
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/jugadores", consumes = {"application/json"})
	public ResponseEntity<?> uploadJugador(@RequestBody (required=true) JugadorDto jugadorDto)
	{
		//comprobamos que el jugador no exista buscnado por su id
		Optional<Jugador> jugador2 = this.jugadorRepository.findById(jugadorDto.getNombre());
		//si el jugador no existe lo metemos en la base de datos
		if (jugador2 == null || jugador2.isEmpty())
		{	
			Jugador jugadorModel = new Jugador();			
			jugadorModel.setNombre(jugadorDto.getNombre());
			jugadorModel.setPosicion(jugadorDto.getPosicion());
			jugadorModel.setIdEquipo(null);
			this.jugadorRepository.saveAndFlush(jugadorModel);
			LOGGER.info("jugador creado");
			return ResponseEntity.status(204).body("Jugador creadro con exito");
		}
		else
		{
			return ResponseEntity.status(404).body("El jugador ya existe");
		}
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/equipos", consumes = {"application/json"})
	public ResponseEntity<?> uploadEquipo(@RequestBody (required=true) EquipoDto equipoDto)
	{
		try 
		{
			Equipo equipo = new Equipo();
			Optional<Equipo> equipo2 = this.equipoRepository.findById(equipoDto.getNombre());
			List<Jugador> jugadorList = this.jugadorRepository.findAll();
			List<String> jugadorJuntos =  new ArrayList<String>();
			equipo.setNombre(equipoDto.getNombre());
			
//			for(int i = 0; i< jugadorList.size(); i++)
//			{
//				Jugador jugadorEquipo= jugadorList.get(i);
//				if(jugadorEquipo.getIdEquipo() == equipoDto.getNombre() )
//				{
//					
//					jugadorJuntos.add(jugadorEquipo.getNombre());
//				}
//				equipoDto.setJugadores(jugadorJuntos);
//			}
			
			if (equipo2 == null || equipo2.isEmpty())
			{	
				
				this.equipoRepository.saveAndFlush(equipo);
				
				return ResponseEntity.status(204).body("Equipo creadro con exito");
			}
			LOGGER.info("el equipo esta siendo procesado");
			return ResponseEntity.status(404).body("Equipo ya exsite en la base de datos");
		}
//		catch ( CompeticionesError exception) 
//		{
//			return ResponseEntity.status(404).body(exception.getBodyExceptionMessage()) ;
//
//		}
		catch (Exception exception) 
		{
			// Error desconocido sucedido en el servidor
			String error = "Error desconocido sucedido en el servidor";
						
			// Creamos una instancia de  con el error y la traza
			CompeticionesError competicionesError = new CompeticionesError(100, error, exception);
						
			// Logueamos y devolvemos error
			LOGGER.error(error, exception);
			return ResponseEntity.status(500).body(competicionesError.getBodyExceptionMessage()) ;
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/partidos")
	public ResponseEntity<?> uploadPartidos(
			@RequestHeader(value = "nombreEquipoLocal",required=true) String nombreEquipoLocal,
			@RequestHeader(value = "nombreEquipoVisitante",required=true) String nombreEquipoVisitante,
			@RequestHeader(value = "fecha",required=true) String fecha,
			@RequestHeader(value = "golesLocal",required=true) int golesLocal,
			@RequestHeader(value = "golesVisitante",required=true) int golesVisitante
			
			) throws CompeticionesError
	{
		try 
		{
			
			Partido partido = new Partido();
			partido.setNombreLocal(nombreEquipoLocal);
			partido.setNombreVisitante(nombreEquipoVisitante);
			partido.setGolesVisitante(golesVisitante);
			partido.setGolesLocal(golesLocal);
			partido.setFecha(fecha);
			LOGGER.info("CARGANDO PARTIDO");
			Optional<Partido> partidosComprobar = this.partidoRepository.findById(partido.getPartidoId());
			if(partidosComprobar == null)
			{
				this.partidoRepository.saveAndFlush(partido);
			}
			return ResponseEntity.status(204).body("El partido ha sido creado exitosamente") ;	
		}
		catch (Exception exception) 
		{
			// Error desconocido sucedido en el servidor
			String error = "Error desconocido sucedido en el servidor";
						
			// Creamos una instancia de  con el error y la traza
			CompeticionesError competicionesError = new CompeticionesError(100, error, exception);
						
			// Logueamos y devolvemos error
			LOGGER.error(error, exception);
			return ResponseEntity.status(500).body(competicionesError.getBodyExceptionMessage()) ;
		}
		
		
	}
	
	
	
}
