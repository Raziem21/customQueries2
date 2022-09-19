package co.develhope.customQueries.repositories;

import co.develhope.customQueries.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FlightRepository extends JpaRepository<Flight, Long> {


}
