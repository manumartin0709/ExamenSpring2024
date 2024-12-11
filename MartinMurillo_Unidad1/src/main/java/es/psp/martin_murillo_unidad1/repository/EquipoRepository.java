package es.psp.martin_murillo_unidad1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.psp.martin_murillo_unidad1.models.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, String> 
{
      List<Equipo> findByNombre(String nombre);
}
