package es.psp.martin_murillo_unidad1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.psp.martin_murillo_unidad1.models.Clasificacion;
@Repository
public interface ClasificacionRepository extends JpaRepository <Clasificacion, String>
{

}
