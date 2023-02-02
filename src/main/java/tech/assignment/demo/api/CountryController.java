package tech.assignment.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.assignment.demo.model.Country;
import tech.assignment.demo.service.CountryService;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService service;

    //Always returns a List
    @RequestMapping (value= "/countries", method = RequestMethod.GET)
    public List<Country> handleRequest(@RequestParam("country") Optional<String> country) throws IOException {
        String countryValue = country.orElse("");

        //This is here so that a separate controller is not needed
        if (countryValue != "") {
            return service.fetchCountries(countryValue);
        }

        return service.fetchCountries();
    }
}
