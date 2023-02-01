package tech.assignment.demo.model;

import java.net.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@Entity
public class Country {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String country_code;
    private String capital;
    private Integer population;
    private URL url;

    @Tolerate
    public Country() {

    }
    
}
