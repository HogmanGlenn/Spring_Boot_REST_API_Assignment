package tech.assignment.demo.repository;

import org.springframework.data.repository.CrudRepository;

import tech.assignment.demo.model.Country;

public interface CountryRepository extends CrudRepository<Country, String> {

    /**
     * @param capital
     * @param population
     * @return Iterable <Country>
     */
    
     Iterable <Country> capitalAndPopulation(String capital, Integer population);
}
