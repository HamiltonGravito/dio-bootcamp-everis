package com.github.hamiltongravito.citiesapi.repository;

import com.github.hamiltongravito.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
