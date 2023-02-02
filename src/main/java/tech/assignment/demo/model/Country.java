package tech.assignment.demo.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@JsonInclude(Include.NON_NULL)
public class Country {

    private String name;
    private String countryCode;
    private String capital;
    private Integer population;
    private String flagFileUrl;

    public Country(){
        
    }
}
