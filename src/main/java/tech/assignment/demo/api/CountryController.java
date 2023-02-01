package tech.assignment.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.assignment.demo.model.Country;
import tech.assignment.demo.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService service;

    //Gets country and country unicode flag from API
    @GetMapping("/countries")
    private String getCountries() {
        
        return service.getCountries();
    }

    @GetMapping("/country")
    private Country getCountry(@RequestParam String country) {

        return  service.getCountry(country);
    }
}
