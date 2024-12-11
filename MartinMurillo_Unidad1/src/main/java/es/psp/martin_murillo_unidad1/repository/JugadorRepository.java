package es.psp.martin_murillo_unidad1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.psp.martin_murillo_unidad1.models.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, String> 
{

}
