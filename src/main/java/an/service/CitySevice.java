package an.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import an.model.City;
import an.respository.CityRepository;

@Service
public class CitySevice {

	@Autowired
	CityRepository cityRepository;

	public Iterable<City> findAll() {
		return cityRepository.findAll();
	}
}
