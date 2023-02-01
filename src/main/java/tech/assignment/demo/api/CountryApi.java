package tech.assignment.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tech.assignment.demo.model.Country;
import tech.assignment.demo.repository.CountryRepository;

@RestController
@RequestMapping("/country")

public class CountryApi {

    @Autowired
    private CountryRepository countryRepository;
    
    @GetMapping("/countries")
    private String getCountries() {
        String uri = "https://countriesnow.space/api/v0.1/countries";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
    public List<Country> getAll(){
        List<Country> countries = new ArrayList<>();
        this.countryRepository.findAll().forEach(countries::add);
        return countries;
    }
}
