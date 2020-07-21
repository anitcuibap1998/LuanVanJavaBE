package an.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import an.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
