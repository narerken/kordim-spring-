package com.era.kordim.mapper;

import com.era.kordim.dto.MovieDto;
import com.era.kordim.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryMapper.class, GenreMapper.class})
public interface MovieMapper {

    @Mapping(source = "title", target = "titleDto")
    @Mapping(source = "year", target = "yearDto")
    @Mapping(source = "country", target = "countryDto")
    @Mapping(source = "genres", target = "genreDtos")
    MovieDto toDto(Movie movie);

    @Mapping(source = "titleDto", target = "title")
    @Mapping(source = "yearDto", target = "year")
    @Mapping(source = "countryDto", target = "country")
    @Mapping(source = "genreDtos", target = "genres")
    Movie toEntity(MovieDto movieDto);

    List<MovieDto> toDtoList(List<Movie> movieList);
}
