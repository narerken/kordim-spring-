package com.era.kordim.service;

import com.era.kordim.dto.GenreDto;
import com.era.kordim.entity.Genre;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();
    void addGenre(GenreDto genreDto);
    void updateGenre(Long id, GenreDto genreDto);
    boolean deleteGenre(Long id);
}
