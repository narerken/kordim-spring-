package com.era.kordim.service;

import com.era.kordim.dto.CountryDto;
import com.era.kordim.entity.Country;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    void addCountry(CountryDto countryDto);
    void updateCountry(Long id, CountryDto countryDto);
    boolean deleteCountry(Long id);
}
