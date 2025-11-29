package com.era.kordim.mapper;

import com.era.kordim.dto.GenreDto;
import com.era.kordim.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    @Mapping(source = "name", target = "nameDto")
    GenreDto toDto(Genre genre);

    @Mapping(source = "nameDto", target = "name")
    Genre toEntity(GenreDto genreDto);

    List<GenreDto> toDtoList(List<Genre> genres);
}
