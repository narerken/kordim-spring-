package com.era.kordim.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private Long id;
    private String titleDto;
    private int yearDto;

    private CountryDto countryDto;
    private List<GenreDto> genreDtos;
}
