package tech.assignment.demo.model;

import lombok.Data;


@Data

//Model for Country.
public class Country {

    private String name;
    private String countryCode;
    private String capital;
    private Integer population;
    private String flagFileUrl;
    
    public Country(){
        
    }
}
