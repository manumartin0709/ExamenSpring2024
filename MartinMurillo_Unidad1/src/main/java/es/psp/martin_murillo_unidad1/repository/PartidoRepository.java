package es.psp.martin_murillo_unidad1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.psp.martin_murillo_unidad1.models.Partido;
import es.psp.martin_murillo_unidad1.models.PartidoId;

public interface PartidoRepository extends JpaRepository<Partido, PartidoId>
{

}
