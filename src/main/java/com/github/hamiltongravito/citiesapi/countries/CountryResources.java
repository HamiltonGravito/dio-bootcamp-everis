package com.github.hamiltongravito.citiesapi.countries;

import com.github.hamiltongravito.citiesapi.countries.Country;
import com.github.hamiltongravito.citiesapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResources {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> country = repository.findById(id);
        if(country.isPresent()){
            return ResponseEntity.ok().body(country.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
