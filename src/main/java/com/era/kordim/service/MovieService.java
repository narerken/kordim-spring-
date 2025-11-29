package com.era.kordim.service;

import com.era.kordim.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAll();
    void getById(Long id);
    void addMovie(MovieDto movieDto);
    void updateMovie(Long id, MovieDto movieDto);
    boolean deleteMovie(Long id);
}
