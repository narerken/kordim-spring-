package com.era.kordim.service.impl;

import com.era.kordim.dto.MovieDto;
import com.era.kordim.entity.Movie;
import com.era.kordim.mapper.MovieMapper;
import com.era.kordim.repository.MovieRepository;
import com.era.kordim.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return movieMapper.toDtoList(movies);
    }

    @Override
    public MovieDto getById(Long id){
        Movie movie = movieRepository.findById(id).orElse(null);
        if(movie == null) return null;
        movie.getGenres().size();
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto){
        Movie movie = movieMapper.toEntity(movieDto);
        movie = movieRepository.save(movie);
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto){
        Movie movie = movieRepository.findById(id).orElse(null);
        if(movie == null) return null;

        movie.setTitle(movieDto.getTitleDto());
        movie.setYear(movieDto.getYearDto());
        movie.setCountry(movieMapper.toEntity(movieDto).getCountry());
        movie.setGenres(movieMapper.toEntity(movieDto).getGenres());

        movie = movieRepository.save(movie);
        return movieMapper.toDto(movie);
    }

    @Override
    public boolean deleteMovie(Long id){
        if(!movieRepository.existsById(id)) return false;
        movieRepository.deleteById(id);
        return true;
    }
}
