package com.era.kordim.mapper;

import com.era.kordim.dto.CountryDto;
import com.era.kordim.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(source = "name", target = "nameDto")
    CountryDto toDto(Country country);

    @Mapping(source = "nameDto", target = "name")
    Country toEntity(CountryDto countryDto);

    List<CountryDto> toDtoList(List<Country> countries);
}
