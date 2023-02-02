package tech.assignment.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;
import java.util.*;

import tech.assignment.demo.model.Country;

@Service
public class CountryService {
    public List<Country> fetchCountries(String countryValue) throws IOException  {
        List<Country> country = new ArrayList<Country>();
        Country countryObj = new Country();

        //Grabs the flag URLs
        final String uri = "https://countriesnow.space/api/v0.1/countries/flag/images";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(uri, String.class);

        JSONObject jsonResponse = new JSONObject(response);
        JSONArray arr = jsonResponse.getJSONArray("data");

        //This looks for the flag URL of the country with the given name
        for (int i = 0; i < arr.length(); i++) {
            String name = arr.getJSONObject(i).getString("name");
           
            if(name.equalsIgnoreCase(countryValue)) {
                String flag = arr.getJSONObject(i).getString("flag");

                countryObj.setName(name);
                countryObj.setFlagFileUrl(flag);
            }
        }

        //Looks for the capital of the given country, and adds it to the result
        final String uriCapital = "https://countriesnow.space/api/v0.1/countries/capital";

        RestTemplate restTemplateCapital = new RestTemplate();
        String responseCapital = restTemplateCapital.getForObject(uriCapital, String.class);

        JSONObject jsonResponseCapital = new JSONObject(responseCapital);
        JSONArray arrCapital = jsonResponseCapital.getJSONArray("data");

        //Grabs the capital and iso2 code for the given country
        for (int i = 0; i < arrCapital.length(); i++) {
            String name = arrCapital.getJSONObject(i).getString("name");
           
            if(name.equalsIgnoreCase(countryValue)) {
                String capital = arrCapital.getJSONObject(i).getString("capital");
                String code = arrCapital.getJSONObject(i).getString("iso2");

                countryObj.setCapital(capital);
                countryObj.setCountryCode(code);
            }
        }
        //Looks for population of given country
        final String uriPop = "https://countriesnow.space/api/v0.1/countries/population";

        RestTemplate restTemplatePop = new RestTemplate();
        String responsePop = restTemplatePop.getForObject(uriPop, String.class);

        JSONObject jsonResponsePop = new JSONObject(responsePop);
        JSONArray arrPop = jsonResponsePop.getJSONArray("data");

        //Grabs the population of the given country
        for (int i = 0; i < arrPop.length(); i++) {
            String name = arrPop.getJSONObject(i).getString("country");
           
            //This picks out the latest population count available in the array
            if(name.equalsIgnoreCase(countryValue)) {
                JSONArray populationCount = arrPop.getJSONObject(i).getJSONArray("populationCounts");
                countryObj.setPopulation(populationCount.getJSONObject(populationCount.length() - 1).getInt("value"));
            }
        }
        
        country.add(countryObj);

        return country;
    }
    //This responds to a "/countries" request with the name and iso2 of every country available
    public List<Country> fetchCountries() {
        final String uri = "https://countriesnow.space/api/v0.1/countries/iso";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(uri, String.class);

        JSONObject jsonResponse = new JSONObject(response);
        JSONArray arr = jsonResponse.getJSONArray("data");

        List<Country> countries = new ArrayList<Country>();

        for (int i = 0; i < arr.length(); i++) {
            String name = arr.getJSONObject(i).getString("name");
            String code = arr.getJSONObject(i).getString("Iso2");

            Country country = new Country();
            country.setName(name);
            country.setCountryCode(code);

            countries.add(country);
        }

        return countries;
    }

}
