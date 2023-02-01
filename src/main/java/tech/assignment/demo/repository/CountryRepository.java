package tech.assignment.demo.repository;

import java.net.URL;

import org.springframework.data.repository.CrudRepository;

import tech.assignment.demo.model.Country;

public interface CountryRepository extends CrudRepository<Country, String> {

    /**
     * @param name
     * @param country_code
     * @param capital
     * @param population
     * @param flag_file_url
     * @return Iterable <Country>
     */
    
     Iterable <Country> additionalInfo(String name, String country_code, String capital, Integer population, URL flag_file_url);
}
