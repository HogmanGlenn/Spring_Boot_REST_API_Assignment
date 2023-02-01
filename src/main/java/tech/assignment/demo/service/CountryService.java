package tech.assignment.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import tech.assignment.demo.model.Country;

@Service
public class CountryService {

    public Country getCountry(String country) {
        final String uri = "https://restcountries.com/v3.1/name/" + country;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        
        Gson gson = new Gson();
        gson.toJson(result);

        Country countryResult = new Country();
        countryResult.setName("testName");
        countryResult.setCountryCode("testCountryCode");
        countryResult.setCapital("testCapital");
        countryResult.setPopulation(1);
        countryResult.setFlagFileUrl("testFlagFileUrl");

        return countryResult;
    }

    public String getCountries() {
        final String uri = "https://restcountries.com/v3.1/all";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}
