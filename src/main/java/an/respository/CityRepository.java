package an.respository;

import org.springframework.data.repository.CrudRepository;

import an.model.City;

public interface CityRepository extends CrudRepository<City, Integer> {

}
